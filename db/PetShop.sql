create database PetShopDb;

create table UserTbl(
UId int identity(1,1) primary key,
UName varchar(50),
UPass varchar(50)
);

create table CustomerTbl(
CustId int identity(1,1) primary key,
CustName varchar(50),
CustAdd varchar(50),
CustPhone varchar(50)
);

create table CategoryTbl(
CatId int identity(1,1) primary key,
CatDes varchar(50)
);

create table PetTbl(
PId int identity(1,1) primary key,
PName varchar(50),
PCat int foreign key references CategoryTbl(CatId),
Pprice int
);



