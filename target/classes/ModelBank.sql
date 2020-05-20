	create table account(
	   account_number VARCHAR(100) NOT NULL,
	   account_name VARCHAR(100) NOT NULL,
	   current_balance bigint NOT NULL,
	   active char,
	   created_date Timestamp default now(),
	   modified_date Date,
	   PRIMARY KEY ( account_number )
	);
	
	alter table account alter column active set default 'y';


insert into account(account_number,account_name,current_balance) values('100','saipranathi',100);
insert into account(account_number,account_name,current_balance) values('200','saipranathi',0);
insert into account(account_number,account_name,current_balance) values('400','saipranathi',100);

create table transaction(
   transaction_id INT NOT NULL AUTO_INCREMENT,
   account_number  VARCHAR(100) NOT NULL,
   transaction_amount long NOT NULL,
   type VARCHAR(100) NOT NULL,
   transaction_date_time Timestamp default now(),
   PRIMARY KEY ( transaction_id )
);

alter table transaction ADD CONSTRAINT fk_transaction_Id FOREIGN KEY(account_number)references account(account_number);




