package com.corexfin.pk_id_generator;

import com.corexfin.model.Bank;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class BankIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        Bank bank = (Bank) object;
        int sufix=100+(int)(Math.random()*900);
        String bankName=bank.getName();
        String [] str=bankName.split(" ");// Sbi Bank of in
        String prefix=str[0].trim();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        String year = String.valueOf(localDateTime.getYear());
        String month = String.valueOf(localDateTime.getMonthValue());
        String day = String.valueOf(localDateTime.getDayOfMonth());
        String pk_bank_id="BNK-"+prefix.toUpperCase()+"-"+year+month+day+"-"+sufix;
        return pk_bank_id;
    }
}
