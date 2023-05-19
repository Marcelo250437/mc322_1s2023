import java.util.Random;

public class Sinistro {
	private int id ;
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;

	
	// Construtor
	public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.setId();
	}
	
	
	// Getters e setters
	public void setId() {
		Random aleatorio = new Random();
		int idn = aleatorio.nextInt((99999 - 10000) + 1) + 10000;
		// System.out.println("Número gerado: " + id);
		this.id = idn;
	}
	public int getId(){
		return this.id;
	}

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
