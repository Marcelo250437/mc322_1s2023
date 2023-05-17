// import java.io.FileInputStream; 
import java.util.Date;
// import java.util.Enumeration;
// import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;


public class Seguradora {
	private String nome ;
	private String telefone ;
	private String email ;
	private String endereco ;
	private List listaSinistros;
	private List<Cliente>listaClientes=new ArrayList<>();
	
	// Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		
		
	}
	// Getters e setters
	public boolean cadastrarClientes(Cliente cliente){
		listaClientes.add(cliente);
		return true;
	}
	public boolean removerCliente(String cliente){
		listaClientes.remove(new Cliente(cliente));
		return true;
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

	public List getListaSinistros(){
		return listaSinistros;
	}

	public void setListaSinistros(){
		this.listaSinistros = listaSinistros;
	}

	public List getListaClientes(){
		return listaClientes;
	}

	public void setListaClientes(){
		this.listaClientes = listaClientes;
	}


}
