import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

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

    
    
     
     public static boolean validarCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") ||
			CPF.equals("11111111111") ||
			CPF.equals("22222222222") || CPF.equals("33333333333") ||
			CPF.equals("44444444444") || CPF.equals("55555555555") ||
			CPF.equals("66666666666") || CPF.equals("77777777777") ||
			CPF.equals("88888888888") || CPF.equals("99999999999") ||
			(CPF.length() != 11))
			return(false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
		// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i=0; i<9; i++) {
		// converte o i-esimo caractere do CPF em um numero:
		// por exemplo, transforma o caractere '0' no inteiro 0
		// (48 eh a posicao de '0' na tabela ASCII)
			num = (int)(CPF.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

		// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
			num = (int)(CPF.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else dig11 = (char)(r + 48);

		// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return(true);
			else return(false);
				} catch (InputMismatchException erro) {
				return(false);
			}

		}
		@Override
		public String toString() {
			return String.format("o cliente é uma pessoa física, cujo nome é %s, mora no endereço %s, habilitado desde %s", this.nome, this.endereco, this.dataLicenca );
			
		}

     }   


