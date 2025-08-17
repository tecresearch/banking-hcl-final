## Task Progress

---
# Details 

---

# Completed Task 

	- 1: Database Setup sucuessfully: 
	- 2: Data Modelling Completed : Administration Part

# Code Snippet

	```
		create table bank(
	bank_id varchar(100) primary key,
	name varchar(100) not null,
	domain varchar(100),
	username varchar(50),
	password varchar(16),
	owner varchar(50),
	email varchar(50),
	active_status varchar(50) default 'PENDING'
);

alter table bank
add column role varchar(16);
alter table bank
add column head_office varchar(50) default 'Head_Branch';

insert into bank values ('hex103','Hex Bank','http://www.hexbank.com','mr_dev','hex@admin','Shrisht Dev','Dev@hexbank.com');
select * from public.bank;
update bank set role='admin' where username='mr_dev' and password='hex@admin';
update bank set head_office='Greater Noida Head Branch' where username='mr_dev' and password='hex@admin';
create table branch(
	branch_id varchar(100) primary key,
	name varchar(100) not null,
	ifsc_code varchar(11),
	micr_code varchar(9),
	email varchar(100),
	phone varchar(12),
	branch_type varchar(20),
	address jsonb,
	bank_id varchar(100),
	foreign key (bank_id) references bank(bank_id)
);

select * from public.bank where username='mr_dev' and password='hex@admin' and role='admin';

insert into branch values ('hex103b','Greater Noida Hex Bank','HEXN0000001','948737849','greater_Noida@hexbank.com','919506563150','Sub-branch'
,null,'hex103');

update branch set address='{
"country":"India",
"state":"UP",
"district":"Greater Noida"
}' where branch_id='hex103b';

UPDATE branch
SET address = jsonb_build_object(
  'country', 'India',
  'state', 'UP',
  'district', 'Greater Noida',
  'head_office', (
    SELECT head_office FROM bank WHERE bank_id = branch.bank_id
  )
)
WHERE branch_id = 'hex103b';

select * from public.branch;
SELECT address->'head_office' as head_office, address->'state' AS state FROM public.branch;



create table corexfin_user(
	user_id varchar(100) primary key,
	name varchar(50),
	pan_no varchar(10),
	dob varchar(20),
	addhaar_no varchar(12),
	email varchar(50),
	phone varchar(12),
	address jsonb,
	username varchar(20),
	password varchar(20),
	role varchar[],
	user_details jsonb,
	user_status boolean default true,
	branch_id varchar(100),
	foreign key (branch_id) references branch(branch_id)
);

INSERT INTO corexfin_user VALUES (
  'corex001',
  'Priya Sharma',
  'pan_no',
  '2002-01-14',
  'addhaar_no',
  'priya@hexbank.com',
  '34054905',
  '{"address":"Varanasi"}',
  'priya123',
  '12345',
  '{Manager}',
  '{"user_details":"Basic info"}',
  true,
  'hex103b'
);

SELECT *
FROM corexfin_user 
WHERE branch_id = 'hex103b';

select b.* 
from corexfin_user u
join branch b on u.branch_id=b.branch_id
where u.user_id='corex001';

select bk.*
from branch b
join bank bk on b.bank_id=bk.bank_id 
where b.branch_id='hex103b';

create table account(
	account_id varchar(100) primary key,
	account_type varchar(10),
	account_balance decimal,
	account_status varchar(10),
	account_internet_banking_enabled boolean default false,
	user_id varchar(100),
	foreign key (user_id) references corexfin_user(user_id)
);

INSERT INTO corexfin_user VALUES (
  'corexcust001',
  'Suhani Shroff',
  'pan_no',
  '2002-01-14',
  '353464657',
  'suhani@hexbank.com',
  '343546',
  '{"address":"maharastra"}',
  'suhani123',
  '12345',
  '{customer}',
  '{"user_details":"Basic info"}',
  true,
  'hex103b'
);

select * from corexfin_user where role='{customer}' and branch_id='hex103b';

select cust.*,bch.*,bk.*
from corexfin_user cust
join branch bch on cust.branch_id=bch.branch_id
join bank bk on bch.bank_id=bk.bank_id
where cust.user_id='corexcust001';

select cust.*,bch.*,bk.*
from corexfin_user cust
 join branch bch on cust.branch_id=bch.branch_id
 join bank bk on bch.bank_id=bk.bank_id
where cust.user_id='corexcust001';


 





	```