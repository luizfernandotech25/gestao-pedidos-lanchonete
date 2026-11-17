
package br.edu.ifgoiano.gestaopedidoslanchonete.implementacaojava;

import java.util.LinkedList;

public class ListaPedidosJava {

    private LinkedList<Pedido> pedidos;

    public ListaPedidosJava() {
        this.pedidos = new LinkedList<>();
    }

    public boolean estaVazia() {
        return pedidos.isEmpty();
    }

    public int tamanho() {
        return pedidos.size();
    }
    
public void inserirInicio(Pedido pedido) {
    pedidos.addFirst(pedido);
}

public void inserirFim(Pedido pedido) {
    pedidos.addLast(pedido);
}

public void inserirMedio(Pedido pedido) {

    int posicao = pedidos.size() / 2;

    pedidos.add(posicao, pedido);
}

public Pedido removerInicio() {

    if (pedidos.isEmpty()) {
        return null;
    }

    return pedidos.removeFirst();
}

public Pedido removerFim() {

    if (pedidos.isEmpty()) {
        return null;
    }

    return pedidos.removeLast();
}

public Pedido removerPosicao(int posicao) {

    if (posicao < 0 || posicao >= pedidos.size()) {
        return null;
    }

    return pedidos.remove(posicao);
}

public Pedido buscarPorId(int idPedido) {

    for (Pedido pedido : pedidos) {

        if (pedido.getId_pedido() == idPedido) {
            return pedido;
        }
    }

    return null;
}

public Pedido buscarPorPosicao(int posicao) {

    if (posicao < 0 || posicao >= pedidos.size()) {
        return null;
    }

    return pedidos.get(posicao);
}

public void imprimirLista() {

    if (pedidos.isEmpty()) {
        System.out.println("Nenhum pedido na fila.");
        return;
    }

    System.out.println("\n===== FILA DE PEDIDOS =====");

    for (int i = 0; i < pedidos.size(); i++) {

        System.out.println(
            "Posição " + i + ": " + pedidos.get(i)
        );
    }

    System.out.println("===========================");
    System.out.println("Total de pedidos: " + pedidos.size());
}

public void exibirProximosPedidos(int quantidade) {

    if (pedidos.isEmpty()) {
        System.out.println("Nenhum pedido na fila.");
        return;
    }

    if (quantidade <= 0) {
        System.out.println("Quantidade inválida.");
        return;
    }

    System.out.println("\n===== PRÓXIMOS PEDIDOS =====");

    int limite = Math.min(quantidade, pedidos.size());

    for (int i = 0; i < limite; i++) {

        System.out.println(
            "Posição " + i + ": " + pedidos.get(i)
        );
    }

    System.out.println("============================");
}

}
