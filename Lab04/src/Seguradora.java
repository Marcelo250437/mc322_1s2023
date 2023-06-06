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
	public void listarSinistros(){
		for (Sinistro k : listaSinistros){
			System.out.println(k);
		}
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
