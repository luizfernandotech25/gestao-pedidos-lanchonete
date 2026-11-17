
package br.edu.ifgoiano.gestaopedidoslanchonete.implementacaojava;

public class Pedido {

    private int id_pedido;
    private String nome_cliente;
    private String item;
    private int quantidade;
    private double valor;
    private String tipo;

    public Pedido(int id_pedido, String nome_cliente,
                  String item, int quantidade,
                  double valor, String tipo) {

        this.id_pedido = id_pedido;
        this.nome_cliente = nome_cliente;
        this.item = item;
        this.quantidade = quantidade;
        this.tipo = tipo;

        switch (tipo.toLowerCase()) {

            case "urgente":
                this.valor = valor * 1.20;
                break;

            case "prioritario":
            case "prioritário":
                this.valor = valor * 1.10;
                break;

            default:
                this.valor = valor;
                break;
        }
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public String getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Pedido: " + id_pedido +
               " | Cliente: " + nome_cliente +
               " | Item: " + item +
               " | Quantidade: " + quantidade +
               " | Valor: R$ " + String.format("%.2f", valor) +
               " | Tipo: " + tipo;
    }
}
