package com.corexfin.dto.request;

public record BankRequest(
 String name,
 String domain,
 String username,
 String password,
 String owner,
 String email,
 String office,
 String status,
 String role

) {

}
