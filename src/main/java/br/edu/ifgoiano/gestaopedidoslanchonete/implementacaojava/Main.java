
package br.edu.ifgoiano.gestaopedidoslanchonete.implementacaojava;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ListaPedidosJava lista = new ListaPedidosJava();

        Pedido[] pedidos = {

            new Pedido(101, "Ana", "Hamburguer", 2, 35.00, "Normal"),
            new Pedido(102, "Carlos", "Pizza", 1, 48.00, "Urgente"),
            new Pedido(103, "Mariana", "Batata Frita", 2, 22.00, "Normal"),
            new Pedido(104, "Pedro", "X-Bacon", 1, 32.00, "Prioritario"),
            new Pedido(105, "Julia", "Refrigerante", 3, 18.00, "Normal"),

            new Pedido(106, "Lucas", "Combo", 1, 55.00, "Urgente"),
            new Pedido(107, "Beatriz", "Pizza", 2, 65.00, "Normal"),
            new Pedido(108, "Rafael", "X-Salada", 1, 28.00, "Prioritario"),
            new Pedido(109, "Fernanda", "Hamburguer", 2, 40.00, "Normal"),
            new Pedido(110, "Gabriel", "Combo", 1, 50.00, "Urgente"),

            new Pedido(111, "Camila", "Pizza", 1, 45.00, "Normal"),
            new Pedido(112, "Bruno", "X-Bacon", 2, 38.00, "Prioritario"),
            new Pedido(113, "Isabela", "Batata Frita", 1, 20.00, "Normal"),
            new Pedido(114, "Matheus", "Hamburguer", 1, 30.00, "Normal"),
            new Pedido(115, "Larissa", "Combo", 1, 60.00, "Prioritario")
        };

        Collections.shuffle(Arrays.asList(pedidos));

        for (Pedido pedido : pedidos) {

            switch (pedido.getTipo().toLowerCase()) {

                case "urgente":
                    lista.inserirInicio(pedido);
                    break;

                case "prioritario":
                case "prioritário":
                    lista.inserirMedio(pedido);
                    break;

                default:
                    lista.inserirFim(pedido);
                    break;
            }
        }

        System.out.println("\n==================================");
        System.out.println("     SISTEMA DA LANCHONETE");
        System.out.println("     IMPLEMENTAÇÃO COM LINKEDLIST");
        System.out.println("==================================");

        lista.imprimirLista();

        System.out.println("\nTamanho da lista: " + lista.tamanho());

        lista.exibirProximosPedidos(5);

        System.out.println("\n===== BUSCA POR ID =====");

        Pedido encontrado = lista.buscarPorId(108);

        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("Pedido não encontrado.");
        }

        System.out.println("\n===== BUSCA POR POSIÇÃO =====");

        Pedido pedidoPosicao = lista.buscarPorPosicao(2);

        if (pedidoPosicao != null) {
            System.out.println(pedidoPosicao);
        } else {
            System.out.println("Posição inválida.");
        }

        System.out.println("\n===== ATENDIMENTO =====");

        Pedido atendido = lista.removerInicio();

        if (atendido != null) {
            System.out.println("Pedido atendido: " + atendido);
        }

        System.out.println("\n===== CANCELAMENTO =====");

        Pedido cancelado = lista.removerFim();

        if (cancelado != null) {
            System.out.println("Pedido cancelado: " + cancelado);
        }

        System.out.println("\n===== CANCELAMENTO ESPECÍFICO =====");

        Pedido removido = lista.removerPosicao(2);

        if (removido != null) {
            System.out.println("Pedido removido: " + removido);
        }

        System.out.println("\n===== FILA ATUALIZADA =====");

        lista.imprimirLista();
    }
}
