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
	public Cliente(String nome , String endereco , List < Veiculo > listaVeiculos) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = listaVeiculos
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

	public List setlistaVeiculos(){
		this.listaVeiculos = listaVeiculos;
	}

	public String toString() {
		return this.nome;
		}

	
}
