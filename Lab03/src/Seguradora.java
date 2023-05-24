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
	// Getters e setters
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
		if(ClientePF.validarCPF(cliente)){ //verifica se é PF
            for (Sinistro i : listaSinistros) {
                if (i.getCliente() instanceof ClientePF) { 
                    ClientePF k = (ClientePF) i.getCliente();
                    if(k.getCpf().equals(cliente)){ 
                        System.out.println(i);
                        return true;
                    }
                }
            }

        }else if(ClientePJ.validarCNPJ(cliente)){ // verifica se é PJ
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
