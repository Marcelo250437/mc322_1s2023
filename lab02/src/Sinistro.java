import java.util.Random;

public class Sinistro {
	// private int id ;
	private String data;
	private String endereco;

	
	// Construtor
	public Sinistro(String data, String endereco) {
		// this.id = id;
		this.data = data;
		this.endereco = endereco;
	}
	
	
	// Getters e setters
	public int getId() {
		Random aleatorio = new Random();
		int id = aleatorio.nextInt((99999 - 10000) + 1) + 10000;
		// System.out.println("Número gerado: " + id);
		return id;
	}

	// public void setId(int id) {
		// this.id = id;
	// }

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
