import java.io.FileInputStream; 
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.InputMismatchException;

public class Cliente {
	private String nome ;
	private String endereco;
	private List listaVeiculos;
	
	// Construtor
	public Cliente(String nome , String endereco) {
		this.nome = nome;
		this.endereco = endereco;
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

	public List getlistaVeiculos() {
		return listaVeiculos;
	}

	public void setlistaVeiculos(){
		this.listaVeiculos = listaVeiculos;
	}

	@Override
	public String toString() {
		return String.format("o cliente é o %s e mora no endereço %s", this.nome, this.endereco);
		}

	
}
