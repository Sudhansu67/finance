drop schema imaginnovate;
create schema if not exists imaginnovate;
use imaginnovate;

drop table if exists employee;
drop table if exists tax_information;

-- Create Table
create table `employee` (
	`id` int not null auto_increment,
    `first_name` varchar(50) not null,
    `last_name` varchar(50) not null,
    `email` varchar(50) unique not null,
    `phone_number` decimal(10, 0) unique not null,
    `doj` datetime not null,
    `salary` decimal(12, 2) not null,
    primary key(`id`)
);

create table `tax_information`(
	`id` int not null auto_increment,
    `tax_percentage` decimal(4, 2) not null,
    `from_amount` decimal(12, 2) not null,
    `to_amount` decimal(12, 2) not null,
    primary key(id)
);

-- Insert Query
insert into tax_information values(1, 0, 0, 250000);
insert into tax_information values(2, 5, 250001, 500000);
insert into tax_information values(3, 10, 500001, 1000000);
insert into tax_information values(4, 20, 1000001, 10000000);
