import java.time.LocalDate;
public class Main {
	public static void main(String[] args) {
		Cliente teste = new Cliente("joao","123.456.789-12");
				System.out.println(teste.toString());
		Seguradora porto = new Seguradora("Porto seguro", "8002-8922", "porto@seguros.com","av.paulista,321 - São Paulo-SP");
		LocalDate agora = LocalDate.now();
		ClientePF cliente1 = new ClientePF("Marcelo Aguiar", "av.jonh boyd, numero 123, Campinas - SP" ,agora, "superior", "masculino", "média", "50443074836", agora);
				
	}
}
