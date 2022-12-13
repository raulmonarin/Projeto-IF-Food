package br.edu.ifsp.arq.ads.dmo5.projeto_if_food.Model;

public class MenuModal {
    private String nome;
    private String valor;

    public MenuModal() {

    }

    public MenuModal(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
