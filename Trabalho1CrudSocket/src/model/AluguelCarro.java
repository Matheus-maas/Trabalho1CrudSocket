package model;

public class AluguelCarro {

    Double preco;
    String dataAluguel;
    String dataVencimento;
    Pessoa p;

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(String dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }
    

    @Override
    public String toString() {
        return "AluguelCarro{" + "preco=" + preco + ", dataAluguel=" + dataAluguel + ", dataVencimento=" + dataVencimento + '}';
    }
    

}
