
# Sistema de Gestão de Pedidos de uma Lanchonete

Projeto acadêmico desenvolvido na disciplina de **Estrutura de Dados 1**, do curso de Tecnologia em Sistemas para Internet do Instituto Federal Goiano – Campus Morrinhos.

O sistema simula o gerenciamento de pedidos de uma lanchonete, utilizando listas encadeadas para organizar, consultar, inserir e remover pedidos.

O projeto apresenta duas abordagens de implementação:

1. **Implementação manual:** construção de uma lista encadeada simples, utilizando nós, referências e controle próprio da estrutura.
2. **Implementação com LinkedList:** utilização da classe `LinkedList` disponibilizada pela biblioteca padrão do Java.

---

## Objetivos do projeto

- Compreender o funcionamento das estruturas de dados encadeadas.
- Implementar manualmente uma lista simplesmente encadeada.
- Trabalhar com nós e referências entre objetos.
- Desenvolver operações de inserção, remoção e busca.
- Utilizar a estrutura `LinkedList` do Java.
- Comparar uma implementação manual com uma estrutura disponibilizada pela linguagem.

## Tecnologias utilizadas

- Java 26
- Apache Maven
- Apache NetBeans IDE 31
- Git
- GitHub

## Funcionalidades

As duas implementações contemplam operações de gerenciamento de pedidos:

| Operação | Descrição |
|---|---|
| Inserir no início | Adiciona um pedido no começo da lista. |
| Inserir no meio | Adiciona um pedido na posição intermediária. |
| Inserir no fim | Adiciona um pedido ao final da lista. |
| Remover do início | Remove o primeiro pedido. |
| Remover do fim | Remove o último pedido. |
| Remover por posição | Remove um pedido de uma posição específica. |
| Buscar por ID | Localiza um pedido pelo identificador. |
| Buscar por posição | Recupera um pedido pela posição na lista. |
| Imprimir lista | Exibe todos os pedidos cadastrados. |
| Exibir próximos pedidos | Apresenta uma quantidade determinada de pedidos. |

## Organização do projeto

```text
GestaoPedidosLanchonete/
│
├── docs/
│
├── src/
│   └── main/
│       └── java/
│           └── br/edu/ifgoiano/
│               └── gestaopedidoslanchonete/
│                   ├── implementacaomanual/
│                   └── implementacaojava/
│
├── pom.xml
├── .gitignore
└── README.md
```

### 1. Implementação manual

Localizada no pacote `implementacaomanual`.

A estrutura foi construída utilizando classes próprias:

- `No.java`: representa cada nó da lista, armazenando o pedido e a referência para o próximo nó.
- `Pedido.java`: representa os dados de cada pedido.
- `ListaEncadeada.java`: implementa a estrutura e suas operações.
- `Main.java`: executa a simulação do sistema.

A lista utiliza referências para cabeça e cauda, além de um atributo para controlar seu tamanho.

### 2. Implementação com LinkedList

Localizada no pacote `implementacaojava`.

Utiliza a estrutura nativa:

```java
import java.util.LinkedList;
```

A classe `ListaPedidosJava` encapsula uma `LinkedList<Pedido>` e implementa as operações de gerenciamento dos pedidos por meio dos métodos disponibilizados pela API Java.

## Como executar

### Pré-requisitos

- JDK 26 ou compatível com a versão configurada no projeto.
- Apache Maven.
- Git.

### Clonar o repositório

```bash
git clone https://github.com/luizfernandotech25/gestao-pedidos-lanchonete.git
```

### Acessar a pasta

```bash
cd gestao-pedidos-lanchonete
```

### Compilar o projeto

```bash
mvn clean install
```

### Executar a implementação manual

```bash
mvn exec:java -Dexec.mainClass="br.edu.ifgoiano.gestaopedidoslanchonete.implementacaomanual.Main"
```

### Executar a implementação com LinkedList

```bash
mvn exec:java -Dexec.mainClass="br.edu.ifgoiano.gestaopedidoslanchonete.implementacaojava.Main"
```

## Documentação técnica

Os documentos complementares estão organizados na pasta `docs/`:

- Implementação manual da lista encadeada.
- Implementação utilizando LinkedList.
- Análise comparativa das duas abordagens.

## Contexto acadêmico

Este projeto foi desenvolvido como atividade prática de Estrutura de Dados 1, com o propósito de aplicar conceitos de organização, manipulação e gerenciamento de dados por meio de estruturas lineares.

O desenvolvimento das duas abordagens permite observar as diferenças entre construir uma estrutura de dados desde seus fundamentos e utilizar uma implementação pronta disponibilizada pela linguagem Java.


---

## Documentação técnica

O projeto possui documentação específica para cada abordagem de implementação das listas encadeadas.

### 1. Implementação manual

[IMPLEMENTACAO-MANUAL.md](docs/IMPLEMENTACAO-MANUAL.md)

Documenta a construção de uma lista simplesmente encadeada, incluindo:
- Estrutura dos nós;
- Referências entre elementos;
- Controle de cabeça, cauda e tamanho;
- Operações de inserção e remoção;
- Busca e percurso;
- Análise de complexidade computacional.

### 2. Implementação com LinkedList

[IMPLEMENTACAO-LINKEDLIST.md](docs/IMPLEMENTACAO-LINKEDLIST.md)

Documenta a utilização da classe `LinkedList` da biblioteca padrão Java, incluindo:
- Declaração e inicialização;
- Operações de manipulação;
- Consultas e percursos;
- Características da estrutura;
- Análise de desempenho.

### 3. Análise comparativa

[COMPARACAO.md](docs/COMPARACAO.md)

Apresenta uma comparação entre as duas abordagens, considerando:
- Organização interna das estruturas;
- Complexidade computacional;
- Desempenho das operações;
- Vantagens e limitações;
- Aplicabilidade de cada implementação.

---

**Instituição:** Instituto Federal Goiano – Campus Morrinhos  
**Curso:** Tecnologia em Sistemas para Internet  
**Disciplina:** Estrutura de Dados 1  
**Projeto:** Gestão de Pedidos de uma Lanchonete

