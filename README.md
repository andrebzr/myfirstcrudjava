# 📦 CRUD de Produtos em Java + MySQL

Meu primeiro projeto CRUD (Create, Read, Update, Delete) desenvolvido em Java, 
rodando via console e conectado a um banco de dados MySQL através de JDBC.

## 🚀 Funcionalidades

- ✅ Cadastrar produto (nome e preço)
- ✅ Listar todos os produtos cadastrados
- ✅ Atualizar dados de um produto pelo ID
- ✅ Deletar um produto pelo ID
- ✅ Validação de entrada (nome vazio, preço negativo, entrada não numérica)
- ✅ Persistência real dos dados em banco MySQL (via JDBC)

## 🛠️ Tecnologias

- Java 21
- MySQL 8.0
- JDBC (MySQL Connector/J)
- Eclipse IDE

## ▶️ Como rodar

1. Clone o repositório: git clone https://github.com/andrebzr/myfirstcrudjava.git
2. Crie o banco de dados no MySQL:
```sql
CREATE DATABASE loja;
USE loja;

CREATE TABLE produtos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL
);
```
3. Abra o projeto no Eclipse
4. Adicione o driver MySQL Connector/J ao Build Path do projeto
5. Configure usuário e senha do MySQL na classe `Conexao.java`
6. Execute a classe `Main.java` (Run As → Java Application)

## 📚 O que aprendi

Esse foi meu primeiro projeto em Java, evoluído em etapas. Durante o desenvolvimento, aprendi:
- Programação orientada a objetos (classes, atributos, encapsulamento)
- Coleções (`List`, `ArrayList`) — versão inicial em memória
- Estruturas de controle (`switch`, `do-while`, `for-each`)
- Tratamento de exceções (`try/catch`)
- Ordenação com `Comparator`
- SQL básico: `CREATE TABLE`, `INSERT`, `SELECT`, `UPDATE`, `DELETE`, `WHERE`
- JDBC: `Connection`, `PreparedStatement`, `ResultSet`, `try-with-resources`
- Migração de armazenamento em memória para persistência em banco de dados real
- Versionamento de código com Git e GitHub

## 👤 Autor

André — Estudante de Engenharia de Software
