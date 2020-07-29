create database projetolivraria17112017;
use projetolivraria17112017;

create table cliente(
	clientecod int(10) primary key not null auto_increment,
    clientenome varchar(50) not null unique,
    clientecpf int(12) not null unique
    );
    
create table autor(
	autorcod int(10) primary key not null auto_increment,
    autornome varchar(50) not null,
    autornasc date not null
    );
    
create table livro(
	livrocod int(10) primary key not null auto_increment,
    livronome varchar(50) not null,
    livroidioma varchar(15) not null,
    livroano date not null);
    
    
create table editora(
	editoracod int(10) primary key not null auto_increment,
    editoraend varchar(100) not null,
    editorafone int(15),
    editoranome varchar(50) not null);
    
create table edicao(
	edicaocod int(10) primary key not null auto_increment,
    edicaolivrocod int(10) not null,
    edicaovalor double(5,2) not null, -- era do livro, agora  está na edição.
    constraint FK_LIVROCOD foreign key (edicaolivrocod)
    references livro(livrocod));
-- relacionamentos     
create table autor_livro( -- UM LIVRO TEM N AUTORES, CADA AUTOR TEM N LIVROS
    livrocod int(10),
    autorcod int(10) not null,
    foreign key (livrocod) references livro(livrocod),
    foreign key (autorcod) references autor(autorcod),
    primary key(livrocod,autorcod));
    
create table editora_edicao(
	editoracod int(10) not null, 
    edicaocod int(10),
    foreign key (editoracod) references editora(editoracod),
    foreign key (edicaocod) references edicao(edicaocod),
    primary key(editoracod,edicaocod));
    
create table venda (
	vendacod int(5) primary key not null auto_increment,
    vendaclientecod int(10) not null,
    vendaedicaocod int(10) not null,
    vendavalor double(6,2),
    foreign key (vendaedicaocod) references edicao(edicaocod),
    foreign key (vendaclientecod) references cliente(clientecod)
    );


-- AUTOR TESTE
insert into autor values(null, 'autor teste', '1994-05-10');
insert into autor values(null, 'autor teste 2','2017-11-23');
select * from autor;


-- LIVROS PARA TESTE! 
insert into livro values(null, 'livro teste','idioteste','1994-05-10');
insert into livro values(null, 'livro teste 2','idioma3','2017-11-19');

-- AUTOR 1 ESCREVE LIVRO 1
insert into autor_livro values(1,1);
-- AUTOR 1 ESCREVEU LIVRO 2 TAMBEM
insert into autor_livro values(2,1);

-- AUTOR 2 ESCREVEU LIVRO 2 
insert into autor_livro values(2,2);

-- EDITORA DE TESTE
insert into editora values(null,'endereco teste', 12345678,'editora teste');

-- EDICOES PARA TESTE, AMBAS DO livro teste
insert into edicao values(null, 1, 500);
insert into edicao values(null, 1, 700);

-- EDICAO 1 É DA EDITORA 1
insert into editora_edicao values(1,1); -- codigo editora , codigo edicao.


-- CLIENTE TESTE
insert into cliente values(null,'cliente teste' ,999999999);



-- TESTES DE SQL
select * from livro;


select * from livro where livronome ='livro teste';
select * from autor_livro;
select * from cliente where clientenome = 'cliente teste';


-- SQL DA VENDA
select edicao.edicaocod, edicao.edicaovalor, autor_livro.autorcod, livro.livrocod, livro.livronome from(((autor_livro 
	inner join autor on autor_livro.autorcod = autor.autorcod)
	inner join livro on autor_livro.livrocod = livro.livrocod)inner join edicao on edicao.edicaolivrocod = livro.livrocod) where livro.livronome like '%livro teste 2%';
select * from cliente;
select * from venda;