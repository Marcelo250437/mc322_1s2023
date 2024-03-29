

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    private final String cpf;
    private String genero;
    private String educacao;
    private LocalDate dataNascimento;
    private ArrayList<Veiculo> listaVeiculos;

    // construtor
    public ClientePF(String nome, String cpf, String telefone, String endereco, String email, String genero, String educacao, 
            LocalDate dataNascimento) {
        super(nome, telefone, endereco, email);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        listaVeiculos = new ArrayList<Veiculo>();
    }

    @Override
    public String toString() {
        String dados = ""; 
        
        dados += "Nome: " + this.nome + "\nCPF: " + this.cpf + "\nTelefone: " + this.telefone + "\nEndereco: " + this.endereco +
                "\nEmail: " + this.email + "\nGenero: " + this.genero + "\nEducacao: " + this.educacao + "\nData nascimento: " + 
                this.dataNascimento + "\nLista de Veiculos do Cliente:\n" + this.listaVeiculos;

        return dados;
    }

  
    public boolean cadastrarVeiculo(Veiculo veiculo){
        if(!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }

    public boolean removerVeiculo(Veiculo veiculo){
        if(listaVeiculos.contains(veiculo)){
            listaVeiculos.remove(veiculo);
            return true;
            
        }
        return false;
    }

  
    public boolean removerVeiculo(String placaVeiculo){
        for(Veiculo v : listaVeiculos){
            if(v.getPlaca().equals(placaVeiculo)){
                listaVeiculos.remove(v);
                return true;
            }
        }
        return false;
    }

   
    public Veiculo getVeiculoPorPlaca(String placa){
        for(Veiculo v : listaVeiculos){
            if(v.getPlaca().equals(placa)){
                return v;
            }
        }
        return null;
    }

    public long idade(){
        LocalDate agora = LocalDate.now();
        return ChronoUnit.YEARS.between(dataNascimento, agora);
    }

    @Override
    public int qtdVeiculos(){
        return listaVeiculos.size();
    }
    
    // getters e setters:
    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    

}
