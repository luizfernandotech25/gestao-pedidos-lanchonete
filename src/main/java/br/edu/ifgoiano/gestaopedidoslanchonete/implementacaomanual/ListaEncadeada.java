
package br.edu.ifgoiano.gestaopedidoslanchonete.implementacaomanual;

public class ListaEncadeada {

    private No cabeca;

    private No cauda;

    private int tamanho;

    public ListaEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public No obterCabeca() {
        return cabeca;
    }

    public No obterCauda() {
        return cauda;
    }

    public void inserirInicio(Pedido pedido) {

        No novoNo = new No(pedido);

        novoNo.proximo = cabeca;

        cabeca = novoNo;

        if (cauda == null) {
            cauda = novoNo;
        }

        tamanho++;
    }

    public void inserirFim(Pedido pedido) {

        No novoNo = new No(pedido);

        if (estaVazia()) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {

            cauda.proximo = novoNo;

            cauda = novoNo;
        }

        tamanho++;
    }

    public void inserirMedio(Pedido pedido) {

        int posicao = tamanho / 2;

        if (posicao == 0) {
            inserirInicio(pedido);
            return;
        }

        No novoNo = new No(pedido);
        No atual = cabeca;

        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }

        novoNo.proximo = atual.proximo;

        atual.proximo = novoNo;

        if (novoNo.proximo == null) {
            cauda = novoNo;
        }

        tamanho++;
    }

    public Pedido removerInicio() {

        if (estaVazia()) {
            return null;
        }

        Pedido pedidoRemovido = cabeca.pedido;

        cabeca = cabeca.proximo;

        tamanho--;

        if (cabeca == null) {
            cauda = null;
        }

        return pedidoRemovido;
    }

    public Pedido removerFim() {

        if (estaVazia()) {
            return null;
        }

        if (cabeca == cauda) {

            Pedido pedidoRemovido = cabeca.pedido;

            cabeca = null;
            cauda = null;
            tamanho--;

            return pedidoRemovido;
        }

        No atual = cabeca;

        while (atual.proximo != cauda) {
            atual = atual.proximo;
        }

        Pedido pedidoRemovido = cauda.pedido;

        atual.proximo = null;
        cauda = atual;

        tamanho--;

        return pedidoRemovido;
    }

    public Pedido removerPosicao(int posicao) {

        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        if (posicao == 0) {
            return removerInicio();
        }

        if (posicao == tamanho - 1) {
            return removerFim();
        }

        No atual = cabeca;

        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }

        Pedido pedidoRemovido = atual.proximo.pedido;

        atual.proximo = atual.proximo.proximo;

        tamanho--;

        return pedidoRemovido;
    }

    public Pedido buscarPorId(int idPedido) {

        No atual = cabeca;

        while (atual != null) {

            if (atual.pedido.getId_pedido() == idPedido) {
                return atual.pedido;
            }

            atual = atual.proximo;
        }

        return null;
    }

    public Pedido buscarPorPosicao(int posicao) {

        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        No atual = cabeca;

        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }

        return atual.pedido;
    }

    public void imprimirLista() {

        if (estaVazia()) {
            System.out.println("Nenhum pedido na fila.");
            return;
        }

        System.out.println("\n===== FILA DE PEDIDOS =====");

        No atual = cabeca;
        int posicao = 0;

        while (atual != null) {

            System.out.println(
                "Posição " + posicao + ": " + atual.pedido
            );

            atual = atual.proximo;
            posicao++;
        }

        System.out.println("===========================");
        System.out.println("Total de pedidos: " + tamanho);
    }

    public void exibirProximosPedidos(int quantidade) {

        if (estaVazia()) {
            System.out.println("Nenhum pedido na fila.");
            return;
        }

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida.");
            return;
        }

        System.out.println("\n===== PRÓXIMOS PEDIDOS =====");

        No atual = cabeca;
        int contador = 0;

        while (atual != null && contador < quantidade) {

            System.out.println(
                "Posição " + contador + ": " + atual.pedido
            );

            atual = atual.proximo;
            contador++;
        }

        System.out.println("============================");
    }

}
