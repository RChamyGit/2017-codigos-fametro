create database aula_23_10_2017;
use aula_23_10_2017;

create table produto(
	idproduto int(2) primary key not null auto_increment,
    nomeproduto varchar(20) not null,
    precoproduto double (5,2) not null
    );
    
insert into produto values(null,'feijao',10.00);
insert into produto values(null,'café',8.50);
insert into produto values(null,'leite',12.80);
insert into produto values(null,'óleo',5.00);
insert into produto values(null,'manteiga',1.20);

select * from produto;

select idproduto,nomeproduto,precoproduto from produto
where idproduto = 1 or idproduto = 2;

select idproduto,nomeproduto,precoproduto from produto where nomeproduto = 'leite' limit 3;