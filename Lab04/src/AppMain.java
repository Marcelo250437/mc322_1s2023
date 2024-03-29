import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AppMain {
    //cria lista que vai conter todas as seguradoras do programa
    private static ArrayList<Seguradora> seguradoras = new ArrayList<Seguradora>();

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
		System.out.println(Validacao.validarCPF("50443074836"));
		
		//Validando CNPJ
		System.out.println(Validacao.validarCNPJ("45990181000189"));
		
		// Adicionando um veiculo
		Veiculo bmw = new Veiculo("bmw2023", "BMW","320", 2023);
		cliente1.addVeiculos(bmw);
		cliente1.listarVeiculos();
		
		// Adicionando clientes
		porto.cadastrarClientes(cliente1);
		LocalDate data2 = LocalDate.of(1990,05,19);
		ClientePJ cliente2 = new ClientePJ("Bosch", "km98 rod.anhanguera", "45990181000189", data2,10);
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
        //iniciando o menu interativo
        criarMenu();
    }

    public static void criarMenu(){
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);
        // opções do menu
        loop: while (true){
            System.out.println("\n ----MENU----\nEscolha uma das opções digitando o número correspondente:\n"+
                                "1 Cadastrar\n"+
                                "2 Listar\n"+
                                "3 Excluir\n"+
                                "4 Gerar Sinistro\n"+
                                "5 Transferir Seguro\n"+
                                "6 Calcular Receita da Seguradora\n"+
                                "0 Sair");

            MenuOperacoes operacao = MenuOperacoes.valor(entrada.nextDouble());   
            switch(operacao){
                //opções cadastrar
                case CADASTRAR:{
                    System.out.println("\n----CADASTRAR----\nEscolha uma das opções digitando o número correspondente:\n"+
                                        "1.1 Cadastrar Cliente\n"+
                                        "1.2 Cadastrar Veículo\n"+
                                        "1.3 Cadastrar Seguradora\n"+
                                        "1.4 Voltar");
                    MenuOperacoes opCad = MenuOperacoes.valor(entrada.nextDouble());
                    //opção cadastrar cliente
                    switch(opCad){
                        case CAD_CLIENTE:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine();

                            System.out.println("Insira o tipo de cliente (digite \"pf\" para pessoa física, \"pj\" para pessoa jurídica): ");
                            String tipo = entrada.nextLine();
                            switch(tipo){
                                case "pf":{
                                    System.out.println("Nome: ");
                                    String nome = entrada.nextLine();
                                    System.out.println("CPF: ");
                                    String cpf = entrada.nextLine();
                                    System.out.println("Data de nascimento (formato aaaa-mm-dd): ");
                                    String dataNasc = entrada.nextLine();
                                    System.out.println("Endereço: ");
                                    String endereco = entrada.nextLine();
                                    System.out.println("Educação: ");
                                    String educacao = entrada.nextLine();
                                    System.out.println("Gênero: ");
                                    String genero = entrada.nextLine();
                                    System.out.println("Data licença (formato aaaa-mm-dd): ");
                                    String dataLicenca = entrada.nextLine();
                                    System.out.println("Classe econômica: ");
                                    String classe = entrada.nextLine();

                                    ClientePF clientePF = new ClientePF(nome, endereco, LocalDate.parse(dataLicenca), educacao, genero, classe, cpf, LocalDate.parse(dataNasc));
                                    s.cadastrarClientes(clientePF);
                                    if(s.cadastrarClientes(clientePF)){
                                        System.out.println("Cliente cadastrado com sucesso!");
                                        s.calcularPrecoSeguroCliente();
                                        System.out.println("Valor do seguro: "+clientePF.getValorSeguro());
                                    }else{
                                        System.out.println("Falha no cadastro, verifique se os dados estão corretos");
                                    }
                                }break;

                                case "pj":{
                                    System.out.println("Nome: ");
                                    String nomeEmpresa = entrada.nextLine();
                                    System.out.println("CNPJ: ");
                                    String cnpj = entrada.nextLine();
                                    System.out.println("Endereço: ");
                                    String endEmpresa = entrada.nextLine();
                                    System.out.println("Data de fundação (formato aaaa-mm-dd): ");
                                    String dataFund = entrada.nextLine();
                                    System.out.println("Quantidade de funcionários: ");
                                    int qtdFunc = entrada.nextInt();

                                    ClientePJ clientePJ = new ClientePJ(nomeEmpresa, endEmpresa, cnpj, LocalDate.parse(dataFund), qtdFunc);
                                    if(s.cadastrarClientes(clientePJ)){
                                        System.out.println("Cliente cadastrado com sucesso!");
                                        s.calcularPrecoSeguroCliente();
                                        System.out.println("Valor do seguro: "+clientePJ.getValorSeguro());
                                    }else{
                                        System.out.println("Falha no cadastro, verifique se os dados estão corretos");
                                    }
                                }break;

                                default:
                                    System.out.println("Comando inválido");
                                break;
                            }
                        }break;
                        //opção cadastrar veiculo
                        case CAD_VEICULO:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine(); //para nao pular o proximo

                            System.out.println("Insira o cpf/cnpj do cliente ao qual será cadastrado o veículo:");
                            String cliente = entrada.nextLine();
                            Cliente c = s.encontrarCliente(cliente);

                            if (c == null) {
                                System.out.println("Cliente inválido");
                            }else{
                                System.out.println("Placa: ");
                                String placa = entrada.nextLine();
                                System.out.println("Marca: ");
                                String marca = entrada.nextLine();
                                System.out.println("Modelo: ");
                                String modelo = entrada.nextLine();
                                System.out.println("Ano de fabricação: ");
                                int ano = entrada.nextInt();
                                Veiculo v = new Veiculo(placa, marca, modelo, ano);
                                c.addVeiculo(v);
                                s.calcularPrecoSeguroCliente();
                                System.out.println("O valor do seguro do cliente "+c.getNome()+" agora é: "+c.getValorSeguro());
                            }

                        }break;
                        //opção cadastrar seguradora
                        case CAD_SEGURADORA:{
                            entrada.nextLine(); //para nao pular o proximo
                            System.out.println("Nome da nova seguradora:");
                            String nome = entrada.nextLine();
                            System.out.println("Telefone: ");
                            String telefone = entrada.nextLine();
                            System.out.println("Email: ");
                            String email = entrada.nextLine();
                            System.out.println("Endereço: ");
                            String endereco = entrada.nextLine();

                            Seguradora seg = new Seguradora(nome, telefone, email, endereco);
                            seguradoras.add(seg);
                            System.out.println("Seguradora cadastrada");
                        }break;

                        case VOLTAR_CAD:
                            continue loop;
                        

                        default:
                            System.out.println("Operação inválida");
                        break;

                    }
                }break;
                //opções listar
                case LISTAR:{
                    System.out.println("\n----LISTAR----\nEscolha uma das opções digitando o número correspondente:\n"+
                                "2.1 Listar Cliente por Seguradora\n"+
                                "2.2 Listar Sinistros por Seguradora\n"+
                                "2.3 Listar Sinistros por Cliente\n"+
                                "2.4 Listar Veiculo por Cliente\n"+
                                "2.5 Listar Veiculo por Seguradora\n"+
                                "2.6 Voltar");
                    MenuOperacoes opListar = MenuOperacoes.valor(entrada.nextDouble());
                    //opção listar cliente
                    switch(opListar){
                        case LISTAR_CLIENTE:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());

                            entrada.nextLine();
                            System.out.println("Insira o tipo de cliente (digite \"pf\" para pessoa física, \"pj\" para pessoa jurídica): ");
                            String tipo = entrada.nextLine();
                            
                            if(tipo.equals("pf") || tipo.equals("pj")){
                                System.out.println("Listando clientes "+tipo+" da Seguradora "+s.getNome() + ":\n" + s.listarClientes(tipo));
                            }else{
                                System.out.println("Comando inválido");
                            }
                        }break;
                        //opção listar sinistros da seguradora
                        case LISTAR_SINISTROS_SEG:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            System.out.println(s.listarSinistros());
                        }break;
                        //opção listar sinistros do cliente
                        case LISTAR_SINISTROS_CLI:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine(); 

                            System.out.println("Insira o cpf/cnpj do cliente cujos sinistros deseja listar");
                            String cliente = entrada.nextLine();
                            if(!s.visualizarSinistro(cliente)){
                                System.out.println("Esse cliente não foi cadastrado ou não há sinistros associados a ele.");
                            }
                        }break;
                        //opção listar veiculos do cliente
                        case LISTAR_VEICULOS_CLI:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine(); 

                            System.out.println("Insira o cpf/cnpj do cliente:");
                            String cliente = entrada.nextLine();
                            Cliente c = s.encontrarCliente(cliente);
                            
                            if (c != null) {
                                System.out.println(c.getListaVeiculos());
                            }else{
                                System.out.println("Cliente inválido");
                            }
                        }break;
                        //opção listar veiculos da seguradora
                        case LISTAR_VEICULOS_SEG:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            System.out.println("Imprimindo veículos da da Seguradora "+s.getNome()+"\n"+s.listarVeiculosClientes());
                        }break;
                        //opção voltar listar
                        case VOLTAR_LISTAR:
                            continue loop;

                        default:
                            System.out.println("Operação inválida");
                        break;

                    }

                }break;
                //opções excluir
                case EXCLUIR:{
                System.out.println("\n ----EXCLUIR----\nEscolha uma das opções digitando o número correspondente:\n"+
                                        "3.1 Excluir Cliente\n"+
                                        "3.2 Excluir Veículo\n"+
                                        "3.3 Excluir Sinistro\n"+
                                        "3.4 Voltar");
                    MenuOperacoes opExcluir = MenuOperacoes.valor(entrada.nextDouble());
                    //opção excluir cliente
                    switch(opExcluir){
                        case EXCLUIR_CLIENTE:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine(); 

                            System.out.println("Insira o cpf/cnpj do cliente que deseja excluir:");
                            String cliente = entrada.nextLine();
                            if(s.removerCliente(cliente)){
                                System.out.println("Cliente removido com sucesso");
                                
                            }else{
                                System.out.println("Cliente não encontrado");
                            }
                        }break;
                        //opção excluir veiculo
                        case EXCLUIR_VEICULO:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine();

                            System.out.println("Insira a placa do veículo a ser removido:");
                            String placa = entrada.nextLine();
                            if(s.excluirVeiculoCliente(placa)){
                                System.out.println("Veiculo excluido com sucesso");
                            }else{
                                System.out.println("Veiculo não encontrado");
                            }
                        }break;
                        //opção excluir sinistro
                        case EXCLUIR_SINISTRO:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            System.out.println("Insira o ID do sinistro a ser removido:");
                            int id = entrada.nextInt();
                            if(s.excluirSinistro(id)){
                                System.out.println("Sinistro excluído com sucesso");
                            }else{
                                System.out.println("Sinistro não encontrado para essa seguradora");
                            }
                            
                    
                        }break;
                        //opção voltar excluir
                        case VOLTAR_EXCLUIR:
                            continue loop;

                        default:
                            System.out.println("Operação inválida");
                        break;

                    }
                }break;
                //opção gerar sinistro
                case GERAR_SINISTRO:{
                    imprimirIDSeguradoras();
                    Seguradora s = seguradoras.get(entrada.nextInt());
                    entrada.nextLine();

                    System.out.println("Insira o cpf/cnpj do cliente para o qual será gerado o sinistro");
                    String cliente = entrada.nextLine();
                    Cliente c = s.encontrarCliente(cliente);

                    if (c == null) {
                        System.out.println("Cliente não encontrado.");
                    }else{
                        System.out.println("Digite a placa do veículo associado:");
                        String placa = entrada.nextLine();
                        Veiculo veicSinistro = null;
                        for(Veiculo v : c.getListaVeiculos()){
                            if (v.getPlaca().equals(placa)){
                                veicSinistro = v;
                                break;
                            }
                        }
                        if(veicSinistro == null){
                            System.out.println("Veículo não encontrado");
                        }else{
                            System.out.println("Data de ocorrência do sinistro (formato aaaa-mm-dd):");
                            String data = entrada.nextLine();
                            System.out.println("Local do sinistro: ");
                            String endereco = entrada.nextLine();
                            Sinistro sinistro1 = new Sinistro(data, endereco, s, veicSinistro, c);
                            s.gerarSinistro(sinistro1);
                            s.calcularPrecoSeguroCliente();
                            System.out.println("Sinistro gerado com sucesso. Valor do seguro agora é: "+c.getValorSeguro());
                        }
                    }
                            
                }break;
                //opção transferir seguro
                case TRANSFERIR_SEGURO:{
                    imprimirIDSeguradoras();
                    Seguradora s = seguradoras.get(entrada.nextInt());
                    entrada.nextLine();

                    System.out.println("Insira o cpf/cnpj do primeiro cliente da transferência: ");
                    String cliente1 = entrada.nextLine();
                    System.out.println("Insira o cpf/cnpj do segundo cliente: ");
                    String cliente2 = entrada.nextLine();
                    
                    if(!s.transferirSeguro(cliente1, cliente2)){
                        System.out.println("Transferência não concluída. Clientes inválidos.");
                    }

                }break;
                //opção calcular receita
                case CALC_RECEITA:{
                    imprimirIDSeguradoras();
                    Seguradora s = seguradoras.get(entrada.nextInt());
                    s.calcularPrecoSeguroCliente();
                    System.out.println("A receita total da seguradora "+s.getNome()+" é de "+s.calcularReceita());
                }break;
                //opção sair
                case SAIR:
                    System.out.println("Saindo...");
                    break loop;

                default:
                    System.out.println("Operação inválida");
                break;
            }
        }
        entrada.close();
    }

    public static void imprimirIDSeguradoras(){
        System.out.println("Escolha uma das seguradoras digitando seu id:");
        for (int i=0; i < seguradoras.size(); i++){
            System.out.println("ID "+ i + " - "+ seguradoras.get(i).getNome());
        }
    }
    
}
