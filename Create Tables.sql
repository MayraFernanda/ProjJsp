create table Administradores(
login varchar(50) primary key,
senha varchar(12) not null
)

create table Clientes(
id int primary key,
nome varchar(50) not null,
endereco varchar(100),
telefone varchar(13),
email varchar(50),
senha varchar(12)
)

create table Produtos(
cod int primary key,
nome varchar(50),
imagem varchar(100),
preco float,
estoque int
)

create table Compras(
numero int primary key,
id int unique foreign key references Clientes(id),
cartao varchar(16),
estado int  
)

create table Itens(
numero int primary key foreign key references Compras(numero),
cod int foreign key references Produtos(cod),
qtd int 
)

select * from Compras


insert into Administradores values('admin','nimda')