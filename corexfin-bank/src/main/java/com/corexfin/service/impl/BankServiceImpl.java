package com.corexfin.service.impl;

import com.corexfin.dto.request.BankRequest;
import com.corexfin.dto.response.BankResponse;
import com.corexfin.model.Bank;
import com.corexfin.repository.BankRepository;
import com.corexfin.service.BankService;

import jakarta.persistence.EntityNotFoundException;

import org.hibernate.Session;
import org.hibernate.annotations.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public BankResponse addAdminBankInCorexfin(BankRequest bankRequest, WebRequest webRequest) {
       try {



           /**
            * Validate bankRequest body
            */

           Bank bank = new Bank();
           /**
            * BankRequest
            *  String name,
            *  String Domain,
            *  String username,
            *  String password,
            *  String owner,
            *  String email,
            *  String office,
            *  String status,
            *  String role
            */

           bank.setName(bankRequest.name());//Hex Bank
           bank.setDomain(bankRequest.domain());//example.com
           bank.setUsername(bankRequest.username());//johndoe
           bank.setPassword(bankRequest.password());//password123
           bank.setOwner(bankRequest.owner());//John's Bank
           bank.setEmail(bankRequest.email());//john.doe@example.com
           bank.setOffice(bankRequest.office());//Main HQ
           bank.setStatus(bankRequest.status());//active
           bank.setRole(bankRequest.role());//admin

           /**
            *      inser into bank values (
            *     "name": "Hex Bank",
            *   "Domain": "example.com",
            *   "username": "johndoe",
            *   "password": "password123",
            *   "owner": "John's Bank",
            *   "email": "john.doe@example.com",
            *   "office": "Main HQ",
            *   "status": "active",
            *   "role": "admin"
            *        
            *      );
            *
            */
          Bank savedBank= bankRepository.save(bank);



           /**
            * String message,
            * boolean status,
            * int httpStatus,
            * String path,
            * LocalDateTime timestamp,
            * String id
            */

           BankResponse  response = new BankResponse();
           response.setMessage("Bank added successfully");
           response.setStatus(true);
           response.setHttpStatus(HttpStatus.CREATED.value());
           response.setPath(webRequest.getDescription(false).replace("uri=",""));
           response.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
           response.setId(savedBank.getId());
           return response;
       }catch (Exception e) {
          throw new RuntimeException(e.getMessage());
       }

    }

    @Override
    public Bank getBankFromCorexfinById(String bankId) {
        return null;
    }

    @Override
    public Bank getBankFromCorexfinByName(String bankName) {
        return null;
    }

   /**
    * @author shrisht.dev
    * Sort Banks by id of last digit using Lambda expression Comaprator Concept
    */
    @Override
    public List<Bank> getAllBankFromCorexfin() {
//        return bankRepository.findAll(Sort.by("id"));
    	
    	 List<Bank> data=bankRepository.findAll(); 
    	  Collections.sort(data,(o1,o2)->{
    		  
    		  
    		 String a=o1.getId();
    		 String aId[]=a.split("-");
    		 String toBeSortIda=aId[aId.length-1];
    		 
    		 
    		 String b=o2.getId();
    		 String bId[]=b.split("-");
    		 String toBeSortIdb=bId[bId.length-1];
    		  
    		  return toBeSortIda.compareTo(toBeSortIdb);
    	  });
    	  
    	  return data;
    	 
    }

    @Override
    public BankResponse updateBankTOCorexfin(BankRequest bankRequest, WebRequest webRequest) {
        return null;
    }

    @Override
    public BankResponse updateBankTOCorexfinByEmail(String email, WebRequest webRequest) {
        return null;
    }

    /**
     * @author ankit.kumarsahoo 
     * 
     * Delete Bank From Corexfin using Bank ID.
     */
    @Override
    public BankResponse deleteBankFromCorexfinById(String bankId) {
    		try {
    			Optional<Bank> bankOptional=bankRepository.findById(bankId);
    			if(bankOptional.isEmpty()) {
    				/**
    		            * String message,
    		            * boolean status,
    		            * int httpStatus,
    		            * String path,
    		            * LocalDateTime timestamp,
    		            * String id
    		            */
    				BankResponse bankresponse_not_found=new BankResponse();
    				bankresponse_not_found.setMessage("Bank with ID "+bankId+" not found");
    				bankresponse_not_found.setStatus(false);
    				bankresponse_not_found.setHttpStatus(HttpStatus.NOT_FOUND.value());
    				bankresponse_not_found.setPath("/admin/bank/v1/delete");
    				bankresponse_not_found.setTimestamp(Timestamp.from(Instant.now()));
    				bankresponse_not_found.setId(bankId);
    				return bankresponse_not_found;
    			}
    			/**
    		     * DELETE FROM bank WHERE id=BNK-HEX-2025119
    		     */
    			bankRepository.deleteById(bankId);//BNK-HEX-2025119
    			/**
    	            * String message,
    	            * boolean status,
    	            * int httpStatus,
    	            * String path,
    	            * LocalDateTime timestamp,
    	            * String id
    	            */
    			BankResponse bankresponse_ok=new BankResponse();
    			bankresponse_ok.setMessage("Bank with ID "+bankId+" deleted successfully");
    			bankresponse_ok.setStatus(true);
    			bankresponse_ok.setHttpStatus(HttpStatus.NO_CONTENT.value());
    			bankresponse_ok.setPath("/admin/bank/v1/delete");
    			bankresponse_ok.setTimestamp(Timestamp.from(Instant.now()));
    			bankresponse_ok.setId(bankId);
				return bankresponse_ok;
    		}catch(Exception e) {
    			/**
    	            * String message,
    	            * boolean status,
    	            * int httpStatus,
    	            * String path,
    	            * LocalDateTime timestamp,
    	            * String id
    	            */
    			BankResponse bankresponse_internal_server_error=new BankResponse();
    			bankresponse_internal_server_error.setMessage("Error while deleting bank: "+e.getMessage());
    			bankresponse_internal_server_error.setStatus(false);
    			bankresponse_internal_server_error.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    			bankresponse_internal_server_error.setPath("/admin/bank/v1/delete");
    			bankresponse_internal_server_error.setTimestamp(Timestamp.from(Instant.now()));
    			bankresponse_internal_server_error.setId(bankId);
				return bankresponse_internal_server_error;
    		}
    		
    }
    /**
     * {@summary : This function delete a bank using bank ID. First we are getting the Bank by bank Id, if 
     * we found bank ID then a custom message i was sending using BankResponse with status}
     */

}

// @Component
//class Mycomparator implements Comparator<Bank>{
//
//	@Override
//	public int compare(Bank o1, Bank o2) {
//		
//		return o2.getName().compareTo(o1.getName());
//	}
//	
//	  
//}
