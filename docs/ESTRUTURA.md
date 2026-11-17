
# Estrutura do Projeto — Gestão de Pedidos de uma Lanchonete

## 1. Visão geral

O projeto foi desenvolvido em Java utilizando Apache Maven e está organizado em pacotes que separam as duas abordagens de implementação de listas encadeadas.

A estrutura facilita a organização do código, a manutenção e a compreensão das responsabilidades de cada classe.

## 2. Organização dos diretórios

```text
GestaoPedidosLanchonete/
│
├── docs/
│   ├── ESTRUTURA.md
│   ├── IMPLEMENTACAO-MANUAL.md
│   ├── IMPLEMENTACAO-LINKEDLIST.md
│   └── COMPARACAO.md
│
├── src/
│   └── main/
│       └── java/
│           └── br/
│               └── edu/
│                   └── ifgoiano/
│                       └── gestaopedidoslanchonete/
│                           │
│                           ├── implementacaojava/
│                           │   ├── ListaPedidosJava.java
│                           │   ├── Main.java
│                           │   └── Pedido.java
│                           │
│                           ├── implementacaomanual/
│                           │   ├── ListaEncadeada.java
│                           │   ├── Main.java
│                           │   ├── No.java
│                           │   └── Pedido.java
│                           │
│                           └── GestaoPedidosLanchonete.java
│
├── .gitignore
├── README.md
└── pom.xml
```

## 3. Descrição dos componentes

### 3.1. Diretório docs

Armazena a documentação técnica do projeto, incluindo explicações sobre as implementações, análise comparativa e organização dos arquivos.

### 3.2. Pacote implementacaomanual

Contém a implementação própria de uma lista simplesmente encadeada.

- **No.java:** representa cada nó, armazenando um objeto Pedido e a referência para o próximo nó.
- **ListaEncadeada.java:** gerencia os nós e implementa as operações de inserção, remoção, busca e percurso.
- **Pedido.java:** representa os pedidos cadastrados.
- **Main.java:** contém a execução da implementação manual.

### 3.3. Pacote implementacaojava

Contém a implementação utilizando a classe LinkedList da biblioteca padrão do Java.

- **ListaPedidosJava.java:** gerencia os pedidos utilizando a estrutura LinkedList.
- **Pedido.java:** representa os pedidos cadastrados.
- **Main.java:** contém a execução da implementação com LinkedList.

### 3.4. Classe principal

**GestaoPedidosLanchonete.java**

Localizada no pacote principal, representa um componente de entrada e organização geral do projeto.

## 4. Arquivo de configuração

### pom.xml

Arquivo de configuração do Apache Maven. Define informações do projeto, dependências, propriedades e configurações necessárias para compilação e execução.

## 5. Organização e separação de responsabilidades

A separação das implementações em pacotes distintos permite:

- Comparar duas abordagens de estruturas de dados.
- Evitar conflitos entre classes com nomes semelhantes.
- Organizar responsabilidades.
- Facilitar a manutenção e a evolução do sistema.
- Documentar individualmente cada implementação.

## 6. Considerações finais

A estrutura do projeto foi organizada para favorecer a modularidade e a compreensão das implementações de listas encadeadas.

A separação entre a implementação manual e a utilização da biblioteca padrão do Java permite analisar diferentes estratégias de construção e gerenciamento de estruturas de dados.
