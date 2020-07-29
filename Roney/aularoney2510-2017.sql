create database teste;
use teste;

create table cliente(
	clicpf varchar(14) NOT NULL PRIMARY KEY,
    clinome varchar(80) not null);
    
create table contas_receber(
comcodigo int not null primary key auto_increment,
connumero int not null,
convalor double(8,2) not null,
conclicpf varchar(14) not null,
constraint fk_cliente foreign key(conclicpf) references cliente (clicpf));

insert into cliente values(123,'joao');
insert into cliente values(222,'monica');
insert into cliente values(333,'vania');

insert into contas_receber(connumero,convalor,conclicpf) values(1234,500,123);
insert into contas_receber(connumero,convalor,conclicpf) values(12345,650,123);
insert into contas_receber(connumero,convalor,conclicpf) values(54321,1800,222);
insert into contas_receber(connumero,convalor,conclicpf) values(11122,5000,222);

select * from cliente c;
select * from contas_receber c;

alter table contas_receber ADD valor double(8,4) not null AFTER connumero;



alter table contas_receber drop convalor;
alter table contas_receber add convalor decimal(10,2)
after connumero;

alter table contas_receber add convalor decimal(10,2)
not null default 2 after connumero;

update contas_receber set convalor=500 where comcodigo = 1;