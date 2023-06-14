import java.util.ArrayList;

public abstract class Cliente {
    protected String nome;
    protected String endereco;
    protected ArrayList<Veiculo> listaVeiculos;
    protected double valorSeguro;
	
	// Construtor
	public Cliente(String nome , String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		listaVeiculos =new ArrayList<Veiculo>();
	
	}	
	public Cliente(String nome){
		this.nome = nome;

	}
	public boolean addVeiculo(Veiculo veiculo){
        
        if(!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }

    public boolean removerVeiculo(Veiculo veiculo){
    
        if(listaVeiculos.contains(veiculo)){
            listaVeiculos.remove(veiculo);
            return true;
            
        }
        return false;
    }

    public boolean removerVeiculo(String placaVeiculo){
        for(Veiculo v : listaVeiculos){
            if(v.getPlaca().equals(placaVeiculo)){
                listaVeiculos.remove(v);
                return true;
            }
        }
        return false;
    }

    public abstract double calculaScore();
    
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
	public void listarVeiculos(){
		for (Veiculo k : listaVeiculos){
			System.out.println(k);
		}
	}
	public void addVeiculos(Veiculo veiculo){
		listaVeiculos.add(veiculo);
	}
	public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

	@Override
	public String toString() {
		return String.format("o cliente é o %s e mora no endereço %s", this.nome, this.endereco);
		}
		public double getValorSeguro() {
			return valorSeguro;
		}
	
	
		public void setValorSeguro(double valorSeguro) {
			this.valorSeguro = valorSeguro;
		}
	

	
}
