drop table book;

create table book(
	bookid		 number(5) primary key,
	bookname	 varchar(100),
	publisher	 varchar(100),
	price		 number(8),
	img			 varchar(100)
);