# Análise Comparativa — Lista Encadeada Manual e LinkedList do Java

## 1. Introdução

O projeto Sistema de Gestão de Pedidos de uma Lanchonete apresenta duas abordagens para a implementação de estruturas de dados encadeadas em Java.

A primeira abordagem consiste na construção manual de uma lista simplesmente encadeada, utilizando classes próprias para representar os nós e controlar as referências entre os elementos.

A segunda abordagem utiliza a classe `LinkedList`, disponibilizada pela biblioteca padrão do Java, que implementa internamente uma lista duplamente encadeada.

Ambas as implementações foram utilizadas para desenvolver funcionalidades de gerenciamento de pedidos, incluindo inserção, remoção, busca, consulta e exibição dos elementos.

O objetivo desta análise é comparar as duas soluções considerando sua organização interna, funcionamento, complexidade computacional, gerenciamento de memória e características de implementação.

## 2. Comparação da estrutura interna

### 2.1. Implementação manual

A implementação manual utiliza uma lista simplesmente encadeada (*Singly Linked List*).

Cada elemento é representado por um objeto da classe `No`, que possui dois atributos:

- `pedido`: referência para o objeto que armazena os dados do pedido.
- `proximo`: referência para o próximo nó da sequência.

A classe `ListaEncadeada` mantém três atributos principais:

- `cabeca`: referência para o primeiro nó.
- `cauda`: referência para o último nó.
- `tamanho`: quantidade de elementos armazenados.

O último nó possui sua referência `proximo` igual a `null`, indicando o encerramento da lista.

A organização dos elementos ocorre por meio do gerenciamento explícito das referências entre os nós.

### 2.2. Implementação com LinkedList

A segunda abordagem utiliza a classe `LinkedList` do pacote `java.util`.

Diferentemente da implementação manual, a estrutura interna é gerenciada pela própria biblioteca do Java.

A classe `LinkedList` implementa uma lista duplamente encadeada (*Doubly Linked List*), na qual cada elemento mantém referências para o nó anterior e para o próximo nó.

No projeto, a estrutura é declarada da seguinte maneira:

```java
private LinkedList<Pedido> pedidos;
```

A biblioteca disponibiliza métodos específicos para manipular os elementos, dispensando a construção manual dos nós e o gerenciamento direto de suas referências.

### 2.3. Diferenças estruturais

| Característica | Implementação manual | LinkedList |
|---|---|---|
| Tipo de estrutura | Simplesmente encadeada | Duplamente encadeada |
| Representação dos nós | Classe `No` própria | Gerenciada pela biblioteca |
| Referência anterior | Não possui | Possui |
| Referência seguinte | `proximo` | Referência interna |
| Controle da cabeça | Manual | Interno |
| Controle da cauda | Manual | Interno |
| Controle do tamanho | Atributo próprio | Gerenciado pela biblioteca |
| Gerenciamento de referências | Explícito | Automático |

## 3. Comparação das operações

### 3.1. Inserção no início

Na implementação manual, um novo nó é criado e sua referência `proximo` recebe o valor atual de `cabeca`. Em seguida, a cabeça passa a apontar para o novo nó.

Na implementação com `LinkedList`, utiliza-se o método `addFirst()`.

Ambas apresentam complexidade O(1).

### 3.2. Inserção no final

Na implementação manual, a inserção utiliza a referência `cauda`, fazendo com que o último nó passe a apontar para o novo elemento.

Na implementação com `LinkedList`, utiliza-se `addLast()`.

As duas operações apresentam complexidade O(1).

### 3.3. Inserção no meio

Na implementação manual, é necessário percorrer a lista até localizar a posição anterior ao ponto de inserção. Em seguida, as referências dos nós são atualizadas.

Na implementação com `LinkedList`, utiliza-se `add(posicao, pedido)`. A biblioteca localiza internamente a posição e realiza a inserção.

Ambas apresentam complexidade O(n), considerando a busca pela posição.

### 3.4. Remoção do início

Na implementação manual, a cabeça passa a apontar para o segundo nó da lista.

Na implementação com `LinkedList`, utiliza-se `removeFirst()`.

Ambas apresentam complexidade O(1).

### 3.5. Remoção do final

Na implementação manual, é necessário percorrer a lista até encontrar o penúltimo nó, pois a estrutura não possui referência para o elemento anterior.

Na implementação com `LinkedList`, utiliza-se `removeLast()`, que permite remover o último elemento diretamente por meio das referências internas da estrutura duplamente encadeada.

Nesse caso, existe uma diferença importante:

- Implementação manual: O(n).
- LinkedList: O(1).

### 3.6. Remoção por posição

Na implementação manual, é necessário percorrer a lista até encontrar o nó anterior à posição desejada e atualizar sua referência `proximo`.

Na implementação com `LinkedList`, utiliza-se `remove(posicao)`.

Ambas apresentam complexidade O(n), considerando a localização do elemento.

### 3.7. Busca por identificador

Nas duas abordagens, a busca por ID exige percorrer sequencialmente os pedidos até encontrar aquele que possui o identificador informado.

A complexidade é O(n).

### 3.8. Busca por posição

Na implementação manual, o acesso é realizado por meio de um percurso a partir da cabeça da lista.

Na implementação com `LinkedList`, utiliza-se `get(posicao)`, que também exige percorrer os nós até localizar o elemento.

Ambas apresentam complexidade O(n).

## 4. Análise comparativa da complexidade computacional

Considerando `n` como a quantidade de pedidos armazenados e `k` como a quantidade solicitada para exibição, temos:

| Operação | Lista manual | LinkedList |
|---|---|---|
| Verificar se está vazia | O(1) | O(1) |
| Consultar tamanho | O(1) | O(1) |
| Inserir no início | O(1) | O(1) |
| Inserir no final | O(1) | O(1) |
| Inserir no meio | O(n) | O(n) |
| Remover do início | O(1) | O(1) |
| Remover do final | O(n) | O(1) |
| Remover por posição | O(n) | O(n) |
| Buscar por ID | O(n) | O(n) |
| Buscar por posição | O(n) | O(n) |
| Imprimir todos os pedidos | O(n) | O(n²) |
| Exibir próximos pedidos | O(min(k,n)) | O(k²) |

### 4.1. Observação sobre a impressão e exibição

Na implementação manual, a impressão utiliza um percurso sequencial por meio da referência `proximo`, permitindo percorrer toda a estrutura em O(n).

Na implementação com `LinkedList`, os métodos `imprimirLista()` e `exibirProximosPedidos()` utilizam o acesso por índice através de `get(i)` dentro de laços.

Como o acesso por posição em uma lista duplamente encadeada exige percorrer os nós, a repetição dessa operação pode resultar em complexidade quadrática.

Portanto, embora a biblioteca disponibilize operações de acesso por índice, a utilização repetida de `get(i)` em laços não representa a forma mais eficiente de percorrer uma `LinkedList`.

O uso de iteradores ou laços `for-each` permite realizar essas operações em O(n) e O(k), respectivamente.

## 5. Comparação do gerenciamento de memória

### 5.1. Implementação manual

Cada nó armazena uma referência para o pedido e outra para o próximo nó.

A estrutura apresenta menor quantidade de referências por nó em comparação com uma lista duplamente encadeada.

Entretanto, o desenvolvedor precisa implementar e manter corretamente os mecanismos de encadeamento e controle dos elementos.

### 5.2. Implementação com LinkedList

Cada nó interno da estrutura mantém referências para o elemento anterior e o próximo elemento, além da referência para o objeto armazenado.

Essa organização exige espaço adicional para manter a referência anterior.

Por outro lado, a biblioteca gerencia automaticamente a criação, a conexão e a remoção dos nós.

### 5.3. Considerações sobre memória

A implementação manual utiliza menos referências de ligação por nó, enquanto a implementação com `LinkedList` mantém uma referência adicional para permitir a navegação nos dois sentidos.

Não foram realizados testes de medição de consumo de memória no projeto. Portanto, essa comparação é estrutural e não representa uma medição empírica de desempenho ou utilização de memória.

## 6. Vantagens e limitações

### 6.1. Implementação manual

**Vantagens:**

- Permite compreender o funcionamento interno de uma lista simplesmente encadeada.
- Possibilita controlar diretamente os nós e suas referências.
- Demonstra a aplicação prática dos conceitos de estruturas de dados dinâmicas.
- Permite personalizar as operações de acordo com as necessidades do sistema.
- Utiliza menos referências de ligação por nó.

**Limitações:**

- Exige implementação manual de todas as operações.
- Requer atenção ao atualizar as referências da cabeça e da cauda.
- A remoção do último elemento exige percorrer a estrutura.
- A manutenção da estrutura depende da consistência dos atributos e referências.

### 6.2. Implementação com LinkedList

**Vantagens:**

- Disponibiliza métodos prontos para inserção, remoção e consulta.
- Reduz a quantidade de código necessário.
- Gerencia automaticamente os nós e suas referências.
- Permite percorrer a estrutura nos dois sentidos.
- Possibilita inserção e remoção nas extremidades em O(1).

**Limitações:**

- Oculta os detalhes internos de gerenciamento dos nós.
- Utiliza memória adicional para armazenar as referências anteriores.
- O acesso por índice exige percurso sequencial.
- O uso inadequado de `get(i)` em laços pode prejudicar o desempenho.

## 7. Considerações sobre a aplicação no sistema

As duas abordagens foram utilizadas para implementar as funcionalidades de gerenciamento dos pedidos da lanchonete.

Nos testes realizados, ambas apresentaram os resultados esperados para as operações de inserção, consulta, atendimento e cancelamento de pedidos.

A implementação manual demonstrou como uma lista simplesmente encadeada pode ser construída utilizando classes, objetos e referências.

A implementação com `LinkedList` demonstrou como uma estrutura de dados disponibilizada pela biblioteca padrão do Java pode simplificar o desenvolvimento e oferecer funcionalidades equivalentes por meio de métodos prontos.

Os resultados funcionais foram satisfatórios nas duas abordagens. Entretanto, a análise de complexidade demonstra que existem diferenças importantes entre elas, especialmente nas operações de remoção do último elemento e nas estratégias utilizadas para percorrer a lista.

## 8. Conclusão

O desenvolvimento das duas abordagens permitiu compreender, na prática, os conceitos fundamentais das listas encadeadas.

A implementação manual proporcionou uma compreensão mais detalhada do funcionamento dos nós, das referências e do gerenciamento de uma lista simplesmente encadeada.

Por sua vez, a implementação com `LinkedList` demonstrou as vantagens de utilizar uma estrutura disponibilizada pela biblioteca padrão do Java, reduzindo a necessidade de implementar mecanismos internos de gerenciamento.

A comparação também evidenciou que a utilização de uma biblioteca não elimina a necessidade de compreender a complexidade das operações. A escolha dos métodos e das estratégias de percurso influencia diretamente o desempenho da aplicação.

Conclui-se que as duas abordagens possuem aplicações relevantes. A implementação manual é especialmente importante para fins didáticos e para a compreensão dos fundamentos das estruturas de dados, enquanto a classe `LinkedList` oferece uma solução pronta para aplicações que necessitam de uma lista duplamente encadeada.

O projeto, portanto, permitiu relacionar os conceitos teóricos estudados na disciplina de Estrutura de Dados 1 com sua aplicação prática no desenvolvimento de um sistema em Java.
