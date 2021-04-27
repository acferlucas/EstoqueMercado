
package model.bean;


public class Produto {
    
    private int id;
    private String nome;
    private int qtd;
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public int getId() {
        return id;
    }
    
    

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    




}
