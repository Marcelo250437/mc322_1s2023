import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.InputMismatchException;

public class ClientePJ extends Cliente {
    private final String CNPJ ;
    private LocalDate dataFundacao ;
    public ArrayList<Veiculo>listaVeiculos;
    private int qtdFuncionarios;
    
    // construtor
    public ClientePJ ( String nome , String endereco , String CNPJ, LocalDate dataFundacao, int qtdFuncionarios) {
     
        // chama o construtor da superclasse
     super ( nome , endereco );
     this . CNPJ = CNPJ ;
     this . dataFundacao = dataFundacao ;
     this . qtdFuncionarios = qtdFuncionarios;
     }
 // TO DO:
     // metodos getters e setters para cpf e dataNascimento
	 
     // ...

     @Override
     public double calculaScore(){
       
         double score = CalcSeguro.VALOR_BASE.fator * (1+(qtdFuncionarios/100)) * listaVeiculos.size();
         return score;
     }
     public String getCnpj() {
		return CNPJ;
	}

     public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
    
       
              @Override
              public String toString() {
                  return String.format("o cliente é uma pessoa jurídica, cujo nome é %s, com sede no endereço %s, fundado em %s", this.nome, this.endereco, this.dataFundacao );
                  
              }

}
