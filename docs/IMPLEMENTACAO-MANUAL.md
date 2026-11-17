# Implementação Manual — Lista Simplesmente Encadeada

## 1. Visão geral

A implementação manual utiliza uma estrutura de dados dinâmica denominada lista simplesmente encadeada (*Singly Linked List*).

Diferentemente das estruturas baseadas em arrays, os elementos não precisam ocupar posições contíguas na memória. Cada elemento é armazenado em um nó, que contém os dados e uma referência para o próximo nó da sequência.

Nesta abordagem, a estrutura de dados foi construída manualmente, utilizando classes próprias para representar os nós e gerenciar as operações de inserção, remoção, busca e percurso.

## 2. Estrutura do nó — No.java

A classe `No` representa cada elemento da lista encadeada.

Sua estrutura possui dois atributos:

- `pedido`: referência para um objeto da classe `Pedido`.
- `proximo`: referência para o próximo nó da lista.

O construtor recebe um objeto `Pedido` e inicializa a referência `proximo` com `null`.

```java
public class No {

    Pedido pedido;
    No proximo;

    public No(Pedido pedido) {
        this.pedido = pedido;
        this.proximo = null;
    }
}
```

Os atributos possuem visibilidade de pacote (*package-private*), permitindo seu acesso pelas classes pertencentes ao mesmo pacote.

O último nó da estrutura possui `proximo = null`, indicando o encerramento da sequência.

## 3. Gerenciamento da lista — ListaEncadeada.java

A classe `ListaEncadeada` controla a estrutura e o gerenciamento dos nós.

São utilizados três atributos principais:

| Atributo | Função |
|---|---|
| `cabeca` | Referência para o primeiro nó |
| `cauda` | Referência para o último nó |
| `tamanho` | Quantidade de elementos armazenados |

### 3.1. Inicialização

No construtor, as referências `cabeca` e `cauda` são inicializadas com `null`, enquanto `tamanho` recebe zero.

Isso representa uma lista inicialmente vazia.

### 3.2. Invariantes da estrutura

A implementação mantém as seguintes condições:

- Quando a lista está vazia, `cabeca` e `cauda` são `null`.
- Quando existe apenas um elemento, `cabeca` e `cauda` apontam para o mesmo nó.
- Quando existem vários elementos, a cabeça aponta para o primeiro e a cauda para o último.
- A referência `proximo` do último nó é sempre `null`.
- O atributo `tamanho` representa a quantidade efetiva de nós.

## 4. Operações implementadas

### 4.1. Verificação de lista vazia

O método `estaVazia()` verifica se o atributo `tamanho` é igual a zero.

### 4.2. Consulta do tamanho

O método `tamanho()` retorna diretamente o atributo que armazena a quantidade de elementos.

### 4.3. Obtenção da cabeça e da cauda

Os métodos `obterCabeca()` e `obterCauda()` retornam as referências para o primeiro e o último nó, respectivamente.

### 4.4. Inserção no início

O método `inserirInicio()` cria um novo nó e faz sua referência `proximo` apontar para a antiga cabeça.

Em seguida, atualiza `cabeca` para o novo nó.

Caso a lista esteja vazia, a cauda também passa a apontar para esse novo elemento.

### 4.5. Inserção no fim

O método `inserirFim()` utiliza a referência `cauda` para inserir diretamente um novo nó no final.

Quando a lista está vazia, cabeça e cauda recebem o novo nó.

Caso contrário, a referência `proximo` da antiga cauda passa a apontar para o novo nó, que se torna a nova cauda.

### 4.6. Inserção no meio

O método `inserirMedio()` calcula a posição central utilizando:

```java
int posicao = tamanho / 2;
```

O método percorre a lista até encontrar a posição anterior à inserção e ajusta as referências entre os nós.

Caso a posição calculada seja zero, utiliza o método `inserirInicio()`.

Também atualiza a cauda quando a inserção ocorre no final da estrutura.

### 4.7. Remoção no início

O método `removerInicio()` armazena o pedido removido e atualiza a cabeça para apontar para o segundo nó.

Se a remoção deixar a lista vazia, a cauda também recebe `null`.

### 4.8. Remoção no fim

O método `removerFim()` trata separadamente dois cenários:

- Lista com apenas um elemento: remove o nó e atualiza cabeça e cauda para `null`.
- Lista com vários elementos: percorre a estrutura até encontrar o penúltimo nó, remove a antiga cauda e atualiza a referência da nova cauda.

### 4.9. Remoção por posição

O método `removerPosicao()` verifica inicialmente se a posição informada é válida.

Quando a posição corresponde ao primeiro ou ao último elemento, utiliza os métodos específicos de remoção.

Para posições intermediárias, percorre a lista e ajusta as referências para retirar o nó desejado.

### 4.10. Busca por identificador

O método `buscarPorId()` percorre a lista utilizando uma referência auxiliar chamada `atual`.

Compara o identificador de cada pedido até encontrar o elemento correspondente.

Caso não encontre, retorna `null`.

### 4.11. Busca por posição

O método `buscarPorPosicao()` verifica se a posição está dentro dos limites da lista.

Depois percorre os nós até alcançar a posição solicitada e retorna o pedido armazenado.

### 4.12. Impressão da lista

O método `imprimirLista()` percorre toda a estrutura, utilizando uma referência auxiliar e um contador de posições.

Apresenta os pedidos armazenados e a quantidade total de elementos.

### 4.13. Exibição dos próximos pedidos

O método `exibirProximosPedidos()` percorre a lista até alcançar a quantidade solicitada ou encontrar o final da estrutura.

Dessa maneira, permite apresentar somente os próximos pedidos que serão atendidos.

## 5. Análise da complexidade computacional

Considerando `n` como a quantidade de elementos armazenados:

| Operação | Complexidade |
|---|---|
| Verificar lista vazia | O(1) |
| Consultar tamanho | O(1) |
| Obter cabeça | O(1) |
| Obter cauda | O(1) |
| Inserir no início | O(1) |
| Inserir no fim | O(1) |
| Inserir no meio | O(n) |
| Remover do início | O(1) |
| Remover do fim | O(n) |
| Remover por posição | O(n) |
| Buscar por ID | O(n) |
| Buscar por posição | O(n) |
| Imprimir lista | O(n) |
| Exibir próximos pedidos | O(min(k,n)) |

Na última operação, `k` representa a quantidade solicitada para exibição.

A inserção no fim apresenta complexidade O(1) devido à manutenção da referência `cauda`. Entretanto, a remoção no fim exige percorrer a estrutura para localizar o penúltimo nó, resultando em O(n).

## 6. Considerações finais

A implementação manual permite compreender o funcionamento interno de uma lista simplesmente encadeada, demonstrando o gerenciamento de nós, referências e operações sobre estruturas dinâmicas.

A construção própria da estrutura possibilita observar como as referências entre objetos determinam a organização dos elementos e como pequenas alterações nessas referências permitem inserir e remover pedidos sem deslocar os demais elementos.

Essa abordagem constitui a base para a comparação com a implementação que utiliza a classe `LinkedList`, disponibilizada pela biblioteca padrão do Java.
