import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.xml.crypto.Data;
public class Main {
	public static void main(String[] args) {
		//Criando uma seguradora
		Seguradora porto = new Seguradora("Porto seguro", "8002-8922", "porto@seguros.com","av.paulista,321 - São Paulo-SP");
		
		// Adicionando um Cliente
		LocalDate data =  LocalDate.of(1990,05,19);
		ClientePF cliente1 = new ClientePF("Marcelo Aguiar", "av.jonh boyd, numero 123, Campinas - SP" ,data, "superior", "masculino", "média", "50443074836", data);
		porto.cadastrarClientes(cliente1);
		System.out.println(porto.listarClientes("PF"));

		// Removendo um Cliente
		porto.removerCliente("Marcelo Aguiar");	
		System.out.println(porto.listarClientes("PF"));

		// Validando CPF
		System.out.println(ClientePF.validarCPF("50443074836"));
		
		//Validando CNPJ
		System.out.println(ClientePJ.validarCNPJ("45990181000189"));
		
		// Adicionando um veiculo
		Veiculo bmw = new Veiculo("bmw2023", "BMW","320", 2023);
		cliente1.addVeiculos(bmw);
		cliente1.listarVeiculos();
		
		// Adicionando clientes
		porto.cadastrarClientes(cliente1);
		LocalDate data2 = LocalDate.of(1990,05,19);
		ClientePJ cliente2 = new ClientePJ("Bosch", "km98 rod.anhanguera", "45990181000189", data2);
		porto.cadastrarClientes(cliente2);
		
		// Gerando sinistro
		Sinistro sinistro1 = new Sinistro("29/05/2023", "Av.europa,555,São Paulo -SP", porto, bmw, cliente1);
		porto.gerarSinistro(sinistro1);
		
		// chamando metodos toString
		System.out.println(porto.toString()); 
		System.out.println(cliente1.toString());
		System.out.println(cliente2.toString());
		System.out.println(bmw.toString());
		System.out.println(sinistro1.toString());


		porto.listarClientes("PF");
		porto.listarSinistros();
		porto.visualizarSinistro("Marcelo Aguiar");
		//System.out.print("Digite seu nome 1:");
		//Scanner input = new Scanner(System.in);
		//String nome = input.nextLine();
		//ClientePF cliente3 = new ClientePF(nome, "rua Robert Bosch", data, "superior", "Masculino", nome, nome, data);
		inputs();
	}

	public static void inputs(){ //menu para realizar algumas operações
		String sair="";
		Scanner input = new Scanner(System.in);
		do {
			try{
				Seguradora porto = new Seguradora("Porto seguro", "8002-8922", "porto@seguros.com","av.paulista,321 - São Paulo-SP");
				int opcoes;
				
				System.out.print("O que deseja fazer?\n"+
				"1.Cadastrar clientePF\n"+
				"2.Cadastrar clientePJ\n"+
				"3.Remover cliente\n"+
				"4.listar cliente\n"+
				"5.Visualizar sinistro\n"+
				"6.Listar sinistro\n");
				opcoes = input.nextInt();
			
				input.nextLine();
				switch (opcoes){
					//executando as opções escolhidas
					case 1:
						System.out.print("digite seu nome: ");
						String nome2 = input.nextLine();
						System.out.print("\ndigite seu endereço: ");
						String endereco = input.nextLine();
						System.out.print("digite seu data de Licenca no formato DD/MM/YYYY: ");
						String lisc1 = input.nextLine();
						System.out.print("digite seu nível de educação: ");
						String educacao = input.nextLine();
						System.out.print("digite seu gênero: ");
						String genero = input.nextLine();
						System.out.print("digite sua classe econômica: ");
						String classe = input.nextLine();
						System.out.print("digite seu CPF: ");
						String cpf = input.nextLine();
						System.out.print("digite seu data de nascimento no formato DD/MM/YYYY: ");
						String nasc1 = input.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
						LocalDate lisc = LocalDate.parse(lisc1, formatter);
						LocalDate nasc = LocalDate.parse(nasc1, formatter);
						porto.cadastrarClientes(new ClientePF(nome2, endereco,lisc, educacao, genero, classe, cpf, nasc));
						System.out.println(porto.listarClientes("PF")); 
						break;
					case 2:
						System.out.print("digite o nome da empresa: ");
						String nome3 = input.nextLine();
						System.out.print("digite o endereço da empresa: ");
						String endereco2 = input.nextLine();
						System.out.print("digite o CNPJ: ");
						String cnpj = input.nextLine();
						System.out.print("digite a data de fundação no formato DD/MM/YYYY: ");
						String fund = input.nextLine();
						DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
						LocalDate fund1 = LocalDate.parse(fund, formatter1);
						porto.cadastrarClientes(new ClientePJ(nome3, endereco2, cnpj, fund1));
						System.out.println(porto.listarClientes("PJ"));
						break;
					case 3:
						System.out.print("digite o nome do cliente a ser removido: ");
						String cliente = input.nextLine();
						porto.removerCliente(cliente);
						System.out.println(porto.listarClientes("PF"));
						System.out.println(porto.listarClientes("PJ"));
						break;
					case 4:
						System.out.print("Listar PF ou PJ: ");
						String condicao = input.nextLine();
						if (condicao.equals("PF")){
							System.out.println(porto.listarClientes("PF"));
						}
						else if (condicao.equals("PJ")){
							System.out.println(porto.listarClientes("PJ"));
						}
						break;
					case 5:
						System.out.println(porto.visualizarSinistro("Marcelo Aguiar"));
						System.out.print("digite o nome do cliente: ");
						String cliente5 = input.nextLine();
						for(Cliente k: porto.listaClientes){
							if(k.nome.equals(cliente5)){
								porto.visualizarSinistro(k.nome);
							}
						}
						break;
					case 6:
						porto.listarSinistros();
						break;

					}
				}
			catch(InputMismatchException e){

				System.out.println();
				continue;
			}

			finally{
				System.out.println("Deseja sair do programa? sim ou nao");
				sair = input.nextLine();	

			}
		

			
	}while(!sair.equals("sim"));

		


	}
}
