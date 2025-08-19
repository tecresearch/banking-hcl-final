package com.corexfin;

import com.corexfin.model.Bank;
import com.corexfin.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CorexfinBankApplication implements CommandLineRunner {
    @Autowired
    private BankRepository bankRepository;
    public static void main(String[] args) {
        SpringApplication.run(CorexfinBankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Bank hex=new Bank();
//        hex.setName("hex Of Bank India");
//        hex.setEmail("hXB@hexbank.com");
//        hex.setDomain("https://www.hexbank.com");
//        hex.setOwner("Shrisht dev");
//        hex.setRole("admin");
//        hex.setOffice("Greater Noida");
//        hex.setUsername("mr_dev");
//        hex.setPassword("hex@admin");
//        hex.setStatus("Pending");
//        hex.setOffice("Greater Noida");
//        bankRepository.save(hex);
        for(Bank bank:bankRepository.findAll()){
            System.out.println(bank);
        }
    }

//    private String generateBankId(String bankName) {
//        String [] str=bankName.split(" ");
//        String prefix=str[0].trim();
//        int sufix=1000+(int)(Math.random()*9000);
//
//        return prefix+sufix;
//    }

}
