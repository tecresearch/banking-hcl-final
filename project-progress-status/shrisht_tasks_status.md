## Task Progress

---
# Details 

---I have completed the List<Bank> getAllBankFromCorexfin() method successfully in the bankServiceimpl where 
   i have sort the banks by using last digit of bank id using Lambda expression way of comparator which is ment 
   for custome sorting 
---it give the requred output as excepted given in the discription 

# Completed Task 

	- 1:Assigned takd done sucuessfully: 
	

# Code Snippet

	```
      date:20/08/2025

      ## BankServiceImpl methods
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


	## BankController Code 
     
	         @GetMapping("/banks")
    public ResponseEntity<List<Bank>> getAllBank(){
    	
    	return ResponseEntity.status(HttpStatus.OK).body(bankService. getAllBankFromCorexfin());
    }
	  

	## BankController Rest api/EndPoint
	  
	method: Get
	  Endpoint:http://localhost:9090/corexfin-bank/admin/bank/v1/banks

	  output:

	     [
  {
    "id": "BNK-A-2025819-267",
    "name": "A",
    "domain": "samplebank.com",
    "username": "admin",
    "password": "P@ssw0rd",
    "owner": "John Doe",
    "email": "contact@samplebank.com",
    "office": "123 Main St, Anytown, USA",
    "status": "Active",
    "role": "Administrator"
  },
  {
    "id": "BNK-BOB-2025819-387",
    "name": "bob",
    "domain": "samplebank.com",
    "username": "admin",
    "password": "P@ssw0rd",
    "owner": "John Doe",
    "email": "contact@samplebank.com",
    "office": "123 Main St, Anytown, USA",
    "status": "Active",
    "role": "Administrator"
  },
  {
    "id": "BNK-HDFC-2025819-472",
    "name": "hdfc",
    "domain": "samplebank.com",
    "username": "admin",
    "password": "P@ssw0rd",
    "owner": "John Doe",
    "email": "contact@samplebank.com",
    "office": "123 Main St, Anytown, USA",
    "status": "Active",
    "role": "Administrator"
  },
  {
    "id": "BNK-AXIS-2025819-483",
    "name": "axis",
    "domain": "samplebank.com",
    "username": "admin",
    "password": "P@ssw0rd",
    "owner": "John Doe",
    "email": "contact@samplebank.com",
    "office": "123 Main St, Anytown, USA",
    "status": "Active",
    "role": "Administrator"
  },
  {
    "id": "BNK-C-2025819-499",
    "name": "C",
    "domain": "samplebank.com",
    "username": "admin",
    "password": "P@ssw0rd",
    "owner": "John Doe",
    "email": "contact@samplebank.com",
    "office": "123 Main St, Anytown, USA",
    "status": "Active",
    "role": "Administrator"
  },
  {
    "id": "BNK-SAMPLE-2025819-836",
    "name": "Sample Bank1",
    "domain": "samplebank.com",
    "username": "admin",
    "password": "P@ssw0rd",
    "owner": "John Doe",
    "email": "contact@samplebank.com",
    "office": "123 Main St, Anytown, USA",
    "status": "Active",
    "role": "Administrator"
  },
  {
    "id": "BNK-B-2025819-865",
    "name": "B",
    "domain": "samplebank.com",
    "username": "admin",
    "password": "P@ssw0rd",
    "owner": "John Doe",
    "email": "contact@samplebank.com",
    "office": "123 Main St, Anytown, USA",
    "status": "Active",
    "role": "Administrator"
  },
  {
    "id": "BNK-SAMPLE-2025819-985",
    "name": "Sample Bank",
    "domain": null,
    "username": "admin",
    "password": "P@ssw0rd",
    "owner": "John Doe",
    "email": "contact@samplebank.com",
    "office": "123 Main St, Anytown, USA",
    "status": "Active",
    "role": "Administrator"
  }
]   
    

	```