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

        public BankResponse updateBankTOCorexfinById(String bankId,BankRequest bankRequest, WebRequest webRequest);
        public BankResponse updateBankTOCorexfinByEmail(String email,BankRequest bankRequest, WebRequest webRequest);
        
>>>>>>> fa67fc435e4f891ddfe0878be18ef0ef0a60f9cb
        public BankResponse deleteBankFromCorexfinById(String bankId);

}
