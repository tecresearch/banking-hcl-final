
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

create table account(
	account_id varchar(100) primary key,
	account_type varchar(10),
	account_balance decimal,
	account_status varchar(10),
	account_internet_banking_enabled boolean default false,
	user_id varchar(100),
	foreign key (user_id) references corexfin_user(user_id)
);


-- Completed: ADMINISTRATION: Above tables are related to the corexfin-access portal(Dashboard)


-- internet_banking_request
-- transaction

-- :Pending: Above tables are related to the bank-access(eg. HEX,UBI,SBI,PNB) portal(Dashboard)




