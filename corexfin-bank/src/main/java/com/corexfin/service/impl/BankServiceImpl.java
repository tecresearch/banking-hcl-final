package com.corexfin.service.impl;

import com.corexfin.dto.request.BankRequest;
import com.corexfin.dto.response.BankResponse;
import com.corexfin.exception.BankNotFoundException;
import com.corexfin.exception.BankValidationException;
import com.corexfin.model.Bank;
import com.corexfin.repository.BankRepository;
import com.corexfin.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    
    /**
     * @author raushan.srivastava
     * Find bank by Bank Id
     * 
     * Response status:
     *    "name": "hex bank of China",
		  "domain": "brij.com",
		  "username": "brij123",
		  "password": "brij@1234",
		  "owner": "Brij Bank",
		  "email": "brij.doe@example.com",
		  "office": "Main HQ",
		  "status": "active",
		  "role":"admin"
     */
    
    public Bank getBankFromCorexfinById(String bankId) throws BankNotFoundException{
    	 
        return bankRepository.findById(bankId).orElseThrow(()->new BankNotFoundException("Bank with id :"+bankId+" not found"));

   
 
    }
    
    /**
     * @author raushan.srivastava
     * 
     * Find bank by the name of Bank
     * 
     * Response status:
     * 
     * "id": "BNK-HEX-2025820-947",
	   "name": "hex bank of China",
	   "domain": "brij.com",
	   "username": "brij123",
	   "password": "brij@1234",
	   "owner": "Brij Bank",
	   "email": "brij.doe@example.com",
	   "office": "Main HQ",
	   "status": "active",
	   "role": "admin"
     */

    @Override
    public Bank getBankFromCorexfinByName(String bankName) throws BankNotFoundException {
    	String name=bankName.trim();
        return bankRepository.findByNameContainingIgnoreCase(name).orElseThrow(()->new BankNotFoundException("Bank with given name :"+name+" not found"));
        		
    }

    @Override
    public List<Bank> getAllBankFromCorexfin() {
        return List.of();
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
