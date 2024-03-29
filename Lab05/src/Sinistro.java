

import java.time.LocalDate;

public class Sinistro {
    private final int id;
    private LocalDate data;
    private String endereco;
    private Seguro seguro;
    private Condutor condutor;
    private static int numSinistros = 0; 

    public Sinistro(LocalDate data, String endereco, Seguro seguro, Condutor condutor) {
        this.data = data;
        this.endereco = endereco;
        this.seguro = seguro;
        this.condutor = condutor;
        this.id = numSinistros;
        numSinistros++;
    }
    
    public String toString() {
        String dados = "";
        dados += "ID:" + id + "\nData: " + data + "\nEndereco: " + endereco + "\nID do Seguro: " + seguro.getId()
                + "\nDados do Condutor do Sinistro:\n" + condutor;
        return dados;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public ClientePF getCliente() {
        return null;
    }

}
