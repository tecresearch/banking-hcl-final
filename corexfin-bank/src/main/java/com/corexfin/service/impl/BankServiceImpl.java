package com.corexfin.service.impl;

import com.corexfin.dto.request.BankRequest;
import com.corexfin.dto.response.BankResponse;
import com.corexfin.model.Bank;
import com.corexfin.repository.BankRepository;
import com.corexfin.service.BankService;
import org.hibernate.Session;
import org.hibernate.annotations.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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

    @Override
    public void deleteBankFromCorexfinById(String bankId) {

    }


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
