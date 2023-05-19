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
	private List<Sinistro>listaSinistros=new ArrayList<>();
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
	public boolean listarClientes(String cliente){
		return true;
	}
	public boolean gerarSinistro(Sinistro sinistro){
		listaSinistros.add(sinistro);
		return true;
	}
	public boolean visualizarSinistro(String cliente){
		System.out.println(sinistro);
		return true;
	}
	public void listarSintros(){
		for (Sinistro sinistro : listaSinistros){

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
