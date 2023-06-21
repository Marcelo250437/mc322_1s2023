import java.util.ArrayList;


public class Seguradora {
	private String nome ;
	private String telefone ;
	private String email ;
	private String endereco ;
	private ArrayList<Sinistro>listaSinistros;
	public ArrayList<Cliente>listaClientes;
	
	// Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaClientes = new ArrayList<Cliente>();

		
		
	}
	
	public boolean cadastrarClientes(Cliente cliente){
		this.listaClientes.add(cliente);
		return true;
	}
	public boolean removerCliente(String cliente){
		int contador = 0;
		for (Cliente i: listaClientes) {
			if (i.nome.equals(cliente)){
				break;
			}
				contador ++;			
		}
		this.listaClientes.remove(contador);
		return true;
	}
	public ArrayList<Cliente> listarClientes(String tipoCliente){
		ArrayList<Cliente> listaRetorna = new ArrayList<Cliente>();
		if (tipoCliente.equals("PF")) {
            for (Cliente i : listaClientes) {
                if (i instanceof ClientePF) { 
                    listaRetorna.add(i);
                }
            }
        }
        if (tipoCliente.equals("PJ")) {
            for (Cliente j : listaClientes) {
                if (j instanceof ClientePJ) { 
                    listaRetorna.add(j);
                }
            }
        }
		return listaRetorna;
    }

		
	
	public boolean gerarSinistro(Sinistro sinistro){
		listaSinistros.add(sinistro);
		return true;
	}
    public boolean excluirSinistro(int id){
        /* Exclui um Sinistro da listaSinistros com base no seu campo "id"
         * Entrada: int id (id do sinistro)
         * Saida: true se encontrar o sinistro e false do contrário
        */
    
        for (Sinistro s : listaSinistros){
            if (s.getId() == id){
                listaSinistros.remove(s);
                return true;
            }
        }
        return false;
    }

	public boolean visualizarSinistro(String cliente){
		if(Validacao.validarCPF(cliente)){ //verifica se é PF
            for (Sinistro i : listaSinistros) {
                if (i.getCliente() instanceof ClientePF) { 
                    ClientePF k = (ClientePF) i.getCliente();
                    if(k.getCpf().equals(cliente)){ 
                        System.out.println(i);
                        return true;
                    }
                }
            }

        }else if(Validacao.validarCNPJ(cliente)){ // verifica se é PJ
            for (Sinistro j : listaSinistros) {
                if (j.getCliente() instanceof ClientePJ) { 
                    ClientePJ k = (ClientePJ) j.getCliente();
                    if(k.getCnpj().equals(cliente)){  
                        System.out.println(j);
                        return true;
                    }
                }
            }
        }
        return false;
        
	}
	public Cliente encontrarCliente(String cliente){
        /* Localiza um cliente na listaClientes com base no seu cpf/cnpj
         * Entrada: String cliente (cpf ou cnpj do cliente buscado)
         * Saída: Cliente procurado (retorna null se não encontrar)
        */
        if(Validacao.validarCPF(cliente)){
            for (Cliente c : listaClientes) { 
                if (c instanceof ClientePF) {  // verifica se c eh pessoa fisica
                    ClientePF k = (ClientePF) c; // k recebe c convertido de Cliente para ClientePF
                    if (k.getCpf().equals(cliente)) {
                        return k;
                    }
                }
            }
        }else if(Validacao.validarCNPJ(cliente)){
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePJ) {  // verifica se c eh pessoa juridica
                    ClientePJ k = (ClientePJ) c; // k recebe c convertido de Cliente para ClientePJ
                    if (k.getCnpj().equals(cliente)) {
                        return k;
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Veiculo> listarVeiculosClientes(){
        /* Lista e retorna os veiculos de todos os clientes da seguradora
         * Saida: veiculosSeguradora (arraylist contendo todos os veiculos cadastrados)
        */
        ArrayList<Veiculo> veiculosSeguradora = new ArrayList<Veiculo>();
        for (Cliente c : listaClientes){
            for (Veiculo v : c.getListaVeiculos()){
                veiculosSeguradora.add(v);
            }
        }
        return veiculosSeguradora;
    }

    public boolean excluirVeiculoCliente(String placa){
        /* Exclui veiculo com base na placa
         * Entrada: String placa (placa do veiculo a ser excluido)
         * Saida: valor booleano (true se conseguir remover algum veículo, false do contrário)
        */
        for(Cliente c : listaClientes){
            if(c.removerVeiculo(placa)){
                return true;
            }
        }
        return false;
    }

	public int qtdSinistros(Cliente c){
        /* Conta os sinistros associados a um cliente c
         * Entrada: Cliente c (cliente cujos sinistros serão contados)
         * Saida: numero de sinistros
        */
        int n = 0;
        for(Sinistro s : listaSinistros){
            if (s.getCliente().equals(c)){
                n++;
            }
        }
        return n;
    }
	public ArrayList<Sinistro> listarSinistros(){
		return listaSinistros;
		
	}
	public void calcularPrecoSeguroCliente(){
        /* Calcula o preco do seguro de todos os clientes cadastrados na seguradora */
        for(Cliente c : listaClientes){
            double preco = c.calculaScore() * (1 + qtdSinistros(c));
            c.setValorSeguro(preco);
        }
    }

    public double calcularReceita(){
        /* Calcula a receita da seguradora somando o preco de todos os seguros 
         * Saida: receita calculada
        */
        double receita = 0;
        for(Cliente c : listaClientes){
            receita += c.getValorSeguro();
        }
        return receita;
    }   

    public boolean transferirSeguro(String cliente1, String cliente2){
        /* Recebe o cpf/cnpj de dois clientes, troca seus veiculos e recalcula e exibe o novo valor de seguro deles.
         * Entradas: cliente1, cliente2 (cpf ou cnpj dos dois clientes)
         * Saida: true se encontrar os clientes e false do contrário
        */
        Cliente c1 = encontrarCliente(cliente1);
        Cliente c2 = encontrarCliente(cliente2);

        if(c1 == null || c2 == null){
            return false;
        }else{
            ArrayList<Veiculo> aux = new ArrayList<Veiculo>();
            aux = c1.getListaVeiculos();
            c1.setListaVeiculos(c2.getListaVeiculos());
            c2.setListaVeiculos(aux);

            calcularPrecoSeguroCliente();

            System.out.println("Transferência de seguro concluída.\nValor do seguro de "+c1.getNome()+": "+c1.getValorSeguro()+
            "\nValor do seguro de "+c2.getNome()+": "+c2.getValorSeguro());
            return true;
        }
    }
	// Getters e setters
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

}
