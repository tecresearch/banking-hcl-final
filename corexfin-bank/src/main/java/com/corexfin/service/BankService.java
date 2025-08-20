package com.corexfin.service;

import com.corexfin.dto.request.BankRequest;
import com.corexfin.dto.response.BankResponse;
import com.corexfin.model.Bank;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Service
public interface BankService {

        public BankResponse addAdminBankInCorexfin(BankRequest bankRequest, WebRequest webRequest);
        public Bank  getBankFromCorexfinById(String bankId);
        public Bank  getBankFromCorexfinByName(String bankName);
        public List<Bank> getAllBankFromCorexfin();
<<<<<<< HEAD
        public BankResponse updateBankTOCorexfinById(String bankId,BankRequest bankRequest, WebRequest webRequest);
        public BankResponse updateBankTOCorexfinByEmail(String email,BankRequest bankRequest, WebRequest webRequest);
=======
        public BankResponse updateBankTOCorexfin(BankRequest bankRequest, WebRequest webRequest);
        public BankResponse updateBankTOCorexfinByEmail(String email, WebRequest webRequest);
>>>>>>> 4786cf3c59113d45eac3273b389a0f6bb4b08de2
        public BankResponse deleteBankFromCorexfinById(String bankId);

}
