

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private LocalDate dataFundacao;
    private int qtdFuncionarios; 
    private ArrayList<Frota> listaFrota;

    public ClientePJ(String nome, String cnpj, String telefone, String endereco, String email, LocalDate dataFundacao, int qtdFuncionarios) {
        super(nome, telefone, endereco, email );
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdFuncionarios = qtdFuncionarios;
        listaFrota = new ArrayList<Frota>();
    }

    @Override
    public String toString() {
        String dados = "";
        dados += "Nome: " + this.nome + "\nCNPJ: " + this.cnpj + "\nTelefone: " + this.telefone + "\nEndereco: " + this.endereco +
                "\nEmail: " + this.email + "\nData fundacao: " + this.dataFundacao + "\nNumero de funcionarios: " + this.qtdFuncionarios +
                "\nLista de Frotas do Cliente:\n" + this.listaFrota+"\n";

        return dados;
    }


    public boolean cadastrarFrota(Frota frota){
        return listaFrota.add(frota);
    }

   
    public Frota localizarFrota(String code){
        for(Frota f : listaFrota){
            if(code.equals(f.getCode())){
                return f;
            }
        }
        return null;
    }

    public boolean atualizarFrota(String code){
        Frota f = localizarFrota(code);
        if(f != null){
            return listaFrota.remove(f);
        }else{
            return false;
        }
    }

    
    public boolean atualizarFrota(String code, String placa){
        Frota f = localizarFrota(code);
        if(f != null){
            return f.removerVeiculo(placa);
        }else{
            return false;
        }
    }

    
    public boolean atualizarFrota(String code, Veiculo veiculo){
        Frota f = localizarFrota(code);
        if(f != null){
            return f.cadastrarVeiculo(veiculo);
        }else{
            return false;
        }
    }

   
    public ArrayList<Veiculo> getVeiculosPorFrota(String code){
        Frota f = localizarFrota(code);
        if(code.equals(f.getCode())){
            return f.getListaVeiculos();
        }else{
            return null;
        }
    }

    
    public Frota getFrotaPorCode(String code){
        for(Frota f : listaFrota){
            if(f.getCode().equals(code)){
                return f;
            }
        }
        return null;
    }

    public long AnosPosFundacao(){
        LocalDate agora = LocalDate.now();
        return ChronoUnit.YEARS.between(dataFundacao, agora);
    }

    @Override
    public int qtdVeiculos(){
        int qtd = 0;
        for(Frota f : listaFrota){
            qtd += f.getListaVeiculos().size();
        }
        return qtd;
    }
    
    // getters e setters:
    public String getCnpj() {
        return cnpj;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public ArrayList<Frota> getListaFrota() {
        return listaFrota;
    }

    public void setListaFrota(ArrayList<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }

    

}
