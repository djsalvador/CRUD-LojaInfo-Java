# CRUD_JAVA_Loja_Info
CRUD em JAVA de uma Lojinha de Informática com Banco de Dados em MySQL (não é um carrinho de compras)

Descrição do Problema:
- Uma loja de informática deseja cadastrar clientes, produtos e pedidos de compra.
O sistema deverá permitir a inserção, atualização, remoção e a leitura dos dados (CRUD).

- Os dados do cliente a serem registrados serão:
    1. CPF
    2. Nome
    3. Telefone
    4. Rua
    5. Bairro
    6. Cidade
    7. Estado
- Os dados dos produtos a serem registrados serão:
    1. Código
    2. Descrição
    3. Valor Unitário
- Os dados do Pedido de Compra a serem registrados serão:
    1. Número
    2. Data do Pedido
    3. Forma de Pagamento
    4. Cliente(cpf)
    5. Produto(codigo)
    6. Quantidade
    
  ![image](https://user-images.githubusercontent.com/42014618/189203348-ff9b76e1-2b22-4d06-809a-44262fdd062a.png)

CÓDIGOS DE CRIAÇÃO DO BANCO DE DADOS:
create database loja_info;

create table clientes(
	cpf varchar(11) not null primary key,
	nome varchar(50) not null,
	telefone varchar(10),
	rua varchar(50),
	bairro varchar(50),
	cidade varchar(50),
	estado varchar(2)
);

create table produtos(
	codigo integer not null primary key,
	descricao varchar(50) not null,
	valor_unit decimal(8,2) not null
);

create table pedido(
	numero integer not null primary key,
	data_pedido date not null,
	forma_pg varchar(6),
	cliente varchar(11), foreign key(cliente) references clientes(cpf),
	produto integer, foreign key(produto) references produtos(codigo),
	qtde_prod integer default 1
);
