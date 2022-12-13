package Models;

import java.util.ArrayList;

public class Pedido {

    private ArrayList<String> produtos;
    private double preco;
    private String status;
    private int userId;


    public Pedido(ArrayList<String> produtos, double preco, String status, int userId) {
        this.produtos = produtos;
        this.preco = preco;
        this.status = status;
        this.userId = userId;
    }
}
