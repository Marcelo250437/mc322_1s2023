import java.util.ArrayList;

public class Cliente {
	public String nome ;
	public String endereco;
	public ArrayList<Veiculo>listaVeiculos;
	// Construtor
	public Cliente(String nome , String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		listaVeiculos =new ArrayList<Veiculo>();
	
	}	
	public Cliente(String nome){
		this.nome = nome;

	}
	// Getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void listaVeiculos(){
		for (Veiculo k : listaVeiculos){
			System.out.println(k);
		}
	}


	@Override
	public String toString() {
		return String.format("o cliente é o %s e mora no endereço %s", this.nome, this.endereco);
		}

	
}
