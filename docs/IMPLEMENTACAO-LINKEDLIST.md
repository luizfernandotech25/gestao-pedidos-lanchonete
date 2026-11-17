# Implementação com LinkedList — Biblioteca Padrão do Java

## 1. Visão geral

A segunda abordagem do projeto utiliza a classe `LinkedList`, disponibilizada pela biblioteca padrão do Java, por meio do pacote `java.util`.

Diferentemente da implementação manual, nessa abordagem não é necessário construir individualmente os nós, controlar referências ou implementar os mecanismos de encadeamento.

A própria biblioteca gerencia internamente a estrutura de dados, oferecendo métodos para inserção, remoção, consulta e manipulação dos elementos.

No projeto, a estrutura é declarada da seguinte maneira:

```java
private LinkedList<Pedido> pedidos;
```

A lista armazena objetos da classe `Pedido`.

É importante destacar que a classe `LinkedList` do Java implementa uma lista duplamente encadeada (*Doubly Linked List*). Internamente, cada elemento mantém referências para o nó anterior e para o próximo nó, permitindo percorrer a estrutura em ambas as direções. Essa característica diferencia sua organização interna da implementação manual desenvolvida neste projeto, que utiliza uma lista simplesmente encadeada.

## 2. Inicialização da estrutura

A estrutura é inicializada por meio do construtor:

```java
public ListaPedidosJava() {
    this.pedidos = new LinkedList<>();
}
```

O operador `new` instancia um objeto da classe `LinkedList`, permitindo armazenar os pedidos dinamicamente.

## 3. Operações de gerenciamento

### 3.1. Verificação de lista vazia

```java
public boolean estaVazia() {
    return pedidos.isEmpty();
}
```

O método `isEmpty()` verifica se a lista possui elementos.

Retorna `true` quando está vazia e `false` quando contém pedidos.

### 3.2. Consulta do tamanho

```java
public int tamanho() {
    return pedidos.size();
}
```

O método `size()` retorna a quantidade de elementos armazenados.

### 3.3. Inserção no início

```java
public void inserirInicio(Pedido pedido) {
    pedidos.addFirst(pedido);
}
```

O método `addFirst()` insere um novo pedido na primeira posição da lista.

### 3.4. Inserção no final

```java
public void inserirFim(Pedido pedido) {
    pedidos.addLast(pedido);
}
```

O método `addLast()` adiciona um pedido ao final da estrutura.

### 3.5. Inserção no meio

```java
public void inserirMedio(Pedido pedido) {
    int posicao = pedidos.size() / 2;
    pedidos.add(posicao, pedido);
}
```

Inicialmente, calcula-se a posição central da lista. Em seguida, o método `add(posicao, pedido)` insere o novo elemento nessa posição.

### 3.6. Remoção do início

```java
public Pedido removerInicio() {
    if (pedidos.isEmpty()) {
        return null;
    }

    return pedidos.removeFirst();
}
```

O método verifica se existem elementos antes de realizar a remoção.

O método `removeFirst()` retira e retorna o primeiro pedido.

### 3.7. Remoção do final

```java
public Pedido removerFim() {
    if (pedidos.isEmpty()) {
        return null;
    }

    return pedidos.removeLast();
}
```

O método `removeLast()` remove e retorna o último pedido.

### 3.8. Remoção por posição

```java
public Pedido removerPosicao(int posicao) {
    if (posicao < 0 || posicao >= pedidos.size()) {
        return null;
    }

    return pedidos.remove(posicao);
}
```

A posição informada é validada antes da remoção.

O método `remove(posicao)` remove o elemento localizado no índice especificado.

## 4. Operações de busca

### 4.1. Busca por identificador

```java
public Pedido buscarPorId(int idPedido) {
    for (Pedido pedido : pedidos) {
        if (pedido.getId_pedido() == idPedido) {
            return pedido;
        }
    }

    return null;
}
```

A busca percorre os elementos da lista utilizando um laço `for-each`.

Cada pedido tem seu identificador comparado com o ID informado.

Quando encontra correspondência, retorna o objeto. Caso contrário, retorna `null`.

### 4.2. Busca por posição

```java
public Pedido buscarPorPosicao(int posicao) {
    if (posicao < 0 || posicao >= pedidos.size()) {
        return null;
    }

    return pedidos.get(posicao);
}
```

O método `get(posicao)` permite recuperar o pedido localizado em determinado índice.

A posição é validada para evitar acessos inválidos.

## 5. Exibição dos pedidos

### 5.1. Impressão da lista

O método `imprimirLista()` percorre os pedidos e apresenta suas informações no terminal.

Na implementação atual, utiliza um laço `for` associado ao método `get(i)`.

### 5.2. Exibição dos próximos pedidos

O método `exibirProximosPedidos(int quantidade)` apresenta uma quantidade determinada de pedidos, respeitando o tamanho disponível na lista.

Para isso, utiliza:

```java
int limite = Math.min(quantidade, pedidos.size());
```

O método percorre as posições até atingir o limite estabelecido, apresentando os pedidos encontrados.

## 6. Análise da complexidade computacional

Considerando `n` como a quantidade de elementos armazenados:

| Operação | Complexidade |
|---|---|
| Verificar lista vazia | O(1) |
| Consultar tamanho | O(1) |
| Inserir no início | O(1) |
| Inserir no final | O(1) |
| Inserir no meio | O(n) |
| Remover do início | O(1) |
| Remover do final | O(1) |
| Remover por posição | O(n) |
| Buscar por ID | O(n) |
| Buscar por posição | O(n) |
| Imprimir lista (implementação atual) | O(n²) |
| Exibir próximos pedidos (implementação atual) | O(k²), para k ≤ n |

Na última operação, `k` representa a quantidade de pedidos solicitada para exibição.

**Observação sobre o desempenho:** embora a classe `LinkedList` disponibilize acesso por índice, esse acesso exige percorrer os nós a partir de uma das extremidades. Por isso, o uso repetido de `get(i)` dentro de laços pode elevar o custo de impressão e exibição.

A utilização de iteradores ou laços `for-each` permite percorrer a estrutura sequencialmente em O(n), sendo uma alternativa mais eficiente para essas operações.

## 7. Considerações finais

A utilização da classe `LinkedList` simplifica significativamente o desenvolvimento do sistema, pois disponibiliza operações prontas para manipulação de listas encadeadas.

Essa abordagem reduz a necessidade de implementar manualmente os mecanismos de gerenciamento dos nós e das referências entre elementos.

Entretanto, a abstração oferecida pela biblioteca não elimina a necessidade de compreender o funcionamento interno da estrutura e suas características de desempenho.

A implementação representa uma aplicação prática dos conceitos de listas encadeadas, permitindo posteriormente estabelecer uma comparação com a abordagem desenvolvida manualmente.
