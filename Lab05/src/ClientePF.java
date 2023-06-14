import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;


public class ClientePF extends Cliente {
    private String CPF ;
    private LocalDate dataNascimento ;
	private String educacao;
    private String genero;
    private LocalDate dataLicenca;
    private String classeEconomica;
	public ArrayList<Veiculo>listaVeiculos;


     public ClientePF ( String nome , String endereco , LocalDate dataLicenca ,
     String educacao , String genero , String classeEconomica , String CPF , LocalDate dataNascimento ) {
     
	// chama o construtor da superclasse
     super ( nome , endereco);
     this . CPF = CPF ;
     this . dataNascimento = dataNascimento ;
	 this.educacao = educacao;
     this.genero = genero;
	 this.dataLicenca = dataLicenca;
	 this.classeEconomica = classeEconomica;
     }
    
     // TO DO:
     // metodos getters e setters para cpf e dataNascimento
	 
     // ...
	 public long idade(){
        LocalDate agora = LocalDate.now();
        return ChronoUnit.YEARS.between(dataNascimento, agora);
    }
	@Override
    public double calculaScore(){
        double score = 0;

        if (idade() >= 18 && idade() <= 30){
            score = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_18_30.fator * listaVeiculos.size(); 

        }else if(idade() > 30 && idade() <= 60){
            score = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_30_60.fator * listaVeiculos.size();

        }else if(idade() > 60 && idade() <=90){
            score = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_60_90.fator * listaVeiculos.size(); 
        }
        return score;
    }

     public String getCpf() {
		return CPF;
	}

     public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    
    
     
     
		@Override
		public String toString() {
			return String.format("o cliente é uma pessoa física, cujo nome é %s, mora no endereço %s, habilitado desde %s", this.nome, this.endereco, this.dataLicenca );
			
		}

     }   


