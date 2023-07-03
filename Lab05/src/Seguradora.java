

import java.util.ArrayList;

public class Seguradora {
    private final String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Seguro> listaSeguros;
    private ArrayList<Cliente> listaClientes;

    // construtor
    public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        listaSeguros = new ArrayList<Seguro>();
        listaClientes = new ArrayList<Cliente>();
    }

    public String toString() { 
        String dados = "";
        dados += "CNPJ: " + this.cnpj + "\nNome: " + this.nome + "\nData Licenca: " + this.telefone
                + "\nEmail: " + this.email + "\nEndereco: " + this.endereco ;

        return dados;
    }


    public ArrayList<Cliente> listarClientes(){
        return listaClientes;
    }

 
    public ArrayList<Cliente> listarClientes(String tipoCliente) {
        
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        if (tipoCliente.equals("pf")) {
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePF) { 
                    lista.add(c);
                }
            }
        }
        if (tipoCliente.equals("pj")) {
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePJ) { 
                    lista.add(c);
                }
            }
        }
        return lista;
    }

   
    public boolean cadastrarCliente(ClientePF cliente) {

        if (Validacao.validarCPF(cliente.getCpf()) && Validacao.validarNome(cliente.getNome()) && !listaClientes.contains(cliente)) { // verifica se o cpf é valido e se o cliente ja foi cadastrado
            listaClientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    
    public boolean cadastrarCliente(ClientePJ cliente) {

        if (Validacao.validarCNPJ(cliente.getCnpj()) && Validacao.validarNome(cliente.getNome()) && !listaClientes.contains(cliente)) { // verifica se o cnpj é valido e se o cliente ja foi cadastrado
            listaClientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    
    public boolean removerCliente(String cliente) {

        if(Validacao.validarCPF(cliente)){
            for (Cliente c : listaClientes) { 
                if (c instanceof ClientePF) {  
                    ClientePF k = (ClientePF) c; 
                    if (k.getCpf().equals(cliente)) {
                        listaClientes.remove(c);
                        return true;
                    }
                }
            }
        }else if(Validacao.validarCNPJ(cliente)){
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePJ) { 
                    ClientePJ k = (ClientePJ) c; 
                    if (k.getCnpj().equals(cliente)) {
                        listaClientes.remove(c);
                        return true;
                    }
                }
            }
        }
        return false;

    }

  
    public Cliente encontrarCliente(String cliente){ 

        if(Validacao.validarCPF(cliente)){
            for (Cliente c : listaClientes) { 
                if (c instanceof ClientePF) { 
                    ClientePF k = (ClientePF) c; 
                    if (k.getCpf().equals(cliente)) {
                        return k;
                    }
                }
            }
        }else if(Validacao.validarCNPJ(cliente)){
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePJ) {  
                    ClientePJ k = (ClientePJ) c; 
                    if (k.getCnpj().equals(cliente)) {
                        return k;
                    }
                }
            }
        }
        return null;
    }

   
    public boolean gerarSeguro(Seguro seguro){
        return listaSeguros.add(seguro);
    }

    
    public boolean cancelarSeguro(int id){
        for(Seguro s : listaSeguros){
            if(s.getId() == id){
                listaSeguros.remove(s);
                return true;
            }
        }
        return false;
        
    }

    
    public ArrayList<Seguro> getSegurosPorCliente(String cliente){
        ArrayList<Seguro> segurosCliente = new ArrayList<Seguro>();

        if(Validacao.validarCPF(cliente)){ 
            for (Seguro s : listaSeguros) {
                if (s.getCliente() instanceof ClientePF) { 
                    ClientePF k = (ClientePF) s.getCliente();
                    if(k.getCpf().equals(cliente)){ 
                        segurosCliente.add(s);
                    }
                }
            }

        }else if(Validacao.validarCNPJ(cliente)){ 
            for (Seguro s : listaSeguros) {
                if (s.getCliente() instanceof ClientePJ) { 
                    ClientePJ k = (ClientePJ) s.getCliente();
                    if(k.getCnpj().equals(cliente)){  
                        segurosCliente.add(s);
                    }
                }
            }
        }
        return segurosCliente;
    }

   
    public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
        ArrayList<Seguro> segurosCliente = new ArrayList<Seguro>();
        for(Seguro s : listaSeguros){
            if (s.getCliente().equals(cliente)){
                segurosCliente.add(s);
            }
        }
        return segurosCliente;
    }

   
    public ArrayList<Sinistro> getSinistrosPorCliente(String cliente){
        ArrayList<Sinistro> sinistrosCliente = new ArrayList<Sinistro>();

        if(Validacao.validarCPF(cliente)){ 
            for (Seguro s : listaSeguros) {
                if (s.getCliente() instanceof ClientePF) { 
                    ClientePF k = (ClientePF) s.getCliente();
                    if(k.getCpf().equals(cliente)){
                        sinistrosCliente.addAll(s.getListaSinistros());
                    }
                }
            }

        }else if(Validacao.validarCNPJ(cliente)){
            for (Seguro s : listaSeguros) {
                if (s.getCliente() instanceof ClientePJ) { 
                    ClientePJ k = (ClientePJ) s.getCliente();
                    if(k.getCnpj().equals(cliente)){  
                        sinistrosCliente.addAll(s.getListaSinistros());
                    }
                }
            }
        }
        return sinistrosCliente;
    }

  
    public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente){
        ArrayList<Sinistro> sinistrosCliente = new ArrayList<Sinistro>();
        for(Seguro s : listaSeguros){
            if (s.getCliente().equals(cliente)){
                sinistrosCliente.addAll(s.getListaSinistros());
            }
        }
        return sinistrosCliente;
    }

    
    public ArrayList<Seguro> listarSeguros(){
        return listaSeguros;
    }

   
    public ArrayList<Sinistro> listarSinistros(){
        ArrayList<Sinistro> sinistros = new ArrayList<Sinistro>();
        for(Seguro s : listaSeguros){
            sinistros.addAll(s.getListaSinistros());
        }
        return sinistros;
    }

    
    public void calcularReceita(){
        double receitaTotal = 0;
        for(Cliente c : listaClientes){
            double receita = 0;
            String cliente;

            if(c instanceof ClientePF){
                cliente = ((ClientePF)c).getCpf();
            }else{
                cliente = ((ClientePJ)c).getCnpj();
            }
            for(Seguro s : listaSeguros){
                if (s.getCliente().equals(c)){
                    receita += s.calcularValor(); 
                }
            }
            receitaTotal += receita;
            System.out.println("Cliente: " + cliente + " ; Balanço de seguros: " + receita); 
        }
        System.out.println("Receita total da seguradora " + nome + ": " + receitaTotal);

    }   


    public ArrayList<Sinistro> getSinistrosPorSeguro(int id){
        for(Seguro s : listaSeguros){
            if(s.getId() == id){
                return s.getListaSinistros();
            }
        }
        return null;
    }

   
    public ArrayList<Condutor> getCondutoresPorSeguro(int id){
        for(Seguro s : listaSeguros){
            if(s.getId() == id){
                return s.getListaCondutores();
            }
        }
        return null;
    }

    
    public Seguro getSeguroPorID(int id){
        for(Seguro s : listaSeguros){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

}
