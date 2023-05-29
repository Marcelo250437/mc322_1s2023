import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.xml.crypto.Data;
public class Main {
	public static void main(String[] args) {
		//Cliente teste = new Cliente("joao","123.456.789-12");
			//	System.out.println(teste.toString());
		Seguradora porto = new Seguradora("Porto seguro", "8002-8922", "porto@seguros.com","av.paulista,321 - São Paulo-SP");
		LocalDate agora = LocalDate.now();
		// add Cliente
		ClientePF cliente1 = new ClientePF("Marcelo Aguiar", "av.jonh boyd, numero 123, Campinas - SP" ,agora, "superior", "masculino", "média", "50443074836", agora);
		porto.cadastrarClientes(cliente1);
		System.out.println(porto.listarClientes("PF"));
		// removendo Cliente
		porto.removerCliente("Marcelo Aguiar");	
		System.out.println(porto.listarClientes("PF"));
		System.out.println(ClientePF.validarCPF("50443074836")); 
		System.out.println(ClientePJ.validarCNPJ("45990181000189")); 
		Veiculo bmw = new Veiculo("bmw2023", "BMW","320", 2023);
		cliente1.addVeiculos(bmw);
		cliente1.listarVeiculos();
		porto.cadastrarClientes(cliente1);
		LocalDate data = LocalDate.of(1990,05,19);
		ClientePJ cliente2 = new ClientePJ("Bosch", "km98 rod.anhanguera", "45990181000189", data);
		porto.cadastrarClientes(cliente2);
		Sinistro sinistro1 = new Sinistro("29/05/2023", "Av.europa,555,São Paulo -SP", porto, bmw, cliente1);
		porto.gerarSinistro(sinistro1);
		System.out.println(porto.toString()); 
		System.out.println(cliente1.toString());
		System.out.println(cliente2.toString());
		System.out.println(bmw.toString());
		System.out.println(sinistro1.toString());
		porto.listarClientes("PF");
		porto.listarSinistros();
		porto.visualizarSinistro("Marcelo Aguiar");
		System.out.print("Digite seu nome:");
		Scanner input = new Scanner(System.in);
		String nome = input.nextLine();
		ClientePF cliente3 = new ClientePF(nome, "rua Robert Bosch", data, "superior", "Masculino", nome, nome, data);
		inputs();
	}

	public static void inputs(){
		Seguradora porto = new Seguradora("Porto seguro", "8002-8922", "porto@seguros.com","av.paulista,321 - São Paulo-SP");
		int opcoes;
		Scanner input = new Scanner(System.in);
		System.out.print("O que deseja fazer?\n"+
		"1.Cadastrar clientePF\n"+
		"2.Cadastrar clientePJ\n"+
		"3.Remover cliente\n"+
		"4.listar cliente\n"+
		"5.Gerar sinistro\n"+
		"6.Visualizar sinistro\n"+
		"7.Listar sinistro\n");
		opcoes = input.nextInt();
		switch (opcoes){
			case 1:
				System.out.print("digite seu nome");
				String nome = input.nextLine();
				System.out.print("digite seu telefone");
				String telefone = input.nextLine();
				System.out.print("digite seu data de Licenca no formato DD/MM/YYYY ");
				String Lisc1 = input.nextLine();
				System.out.print("digite seu nível de educação");
				String educacao = input.nextLine();
				System.out.print("digite seu gênero ");
				String genero = input.nextLine();
				System.out.print("digite sua classe econômica ");
				String classe = input.nextLine();
				System.out.print("digite seu CPF ");
				String cpf = input.nextLine();
				System.out.print("digite seu data de nascimento no formato DD/MM/YYYY  ");
				String Nasc1 = input.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
				LocalDate Lisc = LocalDate.parse(Lisc1, formatter);
				LocalDate Nasc = LocalDate.parse(Nasc1, formatter);
				porto.cadastrarClientes(new ClientePF(nome, telefone,Lisc, educacao, genero, classe, cpf, Nasc));
				
			case 2:


		}
		



	}
}
