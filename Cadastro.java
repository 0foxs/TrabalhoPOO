import java.util.Scanner;
import java.util.ArrayList;


public class Cadastro {
    protected static ArrayList<Frota> Veiculos = new ArrayList<>();//Lista de veiculos
    protected static String grupoc;
    protected static String placac;

    public static void main(String args[]){

        //CADASTRO DE VEICULOS

        // Instanciando o scanner
        Scanner sc = new Scanner(System.in);
		

        //Questionario
        System.out.print("Insira as informações do veículo a baixo: \nDigite a placa do veículo (modelo: LLL-NLNN): ");
        Cadastro.placac = maiusculo(sc.nextLine().toUpperCase());
        
        System.out.print("Digite a marca do veículo: ");
        String marca = sc.nextLine();
        
        System.out.print("Digite o modelo do veículo: ");
        String modelo = sc.nextLine();
        
        System.out.print("Digite a cor do veiculo: ");
        String cor = sc.nextLine();
        
        System.out.print("Digite o ano de fabricacao do veículo: ");
	    int anoFabricacao = Integer.parseInt(sc.nextLine());
        
        System.out.print("Em qual grupo o veículo será inserido? \n <Basico>  <Padrao>  <Premiun>  ");
        Cadastro.grupoc = sc.nextLine();
        
        
        // validacao das informacoes
        
        Cadastro.verificacaoPlaca();
        Cadastro.verificacaoGrupo();


        // Verificaçao das informações

        Cadastro.printInfo(marca, modelo, anoFabricacao, cor); // print do objeto

        // Verificaçao das informações
        boolean x = true;
        do{
            
            System.out.print("\nDigite <Confirmar> para validar as informações ou <Ajustar> para Ajutar-las:  ");
            String validacao = sc.nextLine();
            

            switch(validacao.toLowerCase()){

                // Instanciando o veiculo
                case "confirmar":

                    // Switch para dar os valores de cada grupo
                    switch(Cadastro.grupoc.toLowerCase()){

                        // instanciando um veiculo Basico
                        case "basico":
                            Veiculos.add(new Basico(marca, modelo, anoFabricacao, cor, Cadastro.placac, Cadastro.grupoc));
                            break;

                        // instanciando um veiculo Padrao
                        case "padrao":
                            Veiculos.add(new Padrao(marca, modelo, anoFabricacao, cor, Cadastro.placac, Cadastro.grupoc));        
                            break;

                        // instanciando um veiculo Premiun
                        case "premiun":
                            Veiculos.add(new Premiun(marca, modelo, anoFabricacao, cor, Cadastro.placac, Cadastro.grupoc));
                            break;
                    }
                    System.out.println("\nVeiculo cadastrado com sucesso!");
                    x = false; //acaba o while
                    break;
                
                // Reescrevendo informações invalidas
                case "ajustar":
                
                    // Solicitar ao usuário que especifique quais informações estão incorretas
                    System.out.print("\n Informe quais informações estão incorretas: ");
                    String ajuste = sc.nextLine();
                    System.out.println(" ");

                    // Corrigir apenas as informações incorretas
                    if (ajuste.toLowerCase().contains("marca")) {
                        System.out.print("Digite a marca do veículo: ");
                        marca = sc.nextLine();
                    }

                    if (ajuste.toLowerCase().contains("modelo")) {
                        System.out.print("Digite o modelo do veículo: ");
                        modelo = sc.nextLine();
                    }

                    if (ajuste.toLowerCase().contains("fabricacao")) {
                        System.out.print("Digite a marca do veículo: ");
                        anoFabricacao = sc.nextInt();
                        sc.nextLine();
                    }

                    if (ajuste.toLowerCase().contains("cor")) {
                        System.out.print("Digite o modelo do veículo: ");
                        cor = sc.nextLine();
                    }

                    if (ajuste.toLowerCase().contains("placa")) {
                        System.out.print("Digite a marca do veículo: ");
                        Cadastro.placac = sc.nextLine();

                        //Validar placa
                        Cadastro.verificacaoPlaca();
                    }

                    if (ajuste.contains("grupo".toLowerCase())) {
                        System.out.print("Digite o modelo do veículo: ");
                        Cadastro.grupoc = sc.nextLine();

                        // Validar grupo
                        Cadastro.verificacaoGrupo();
                    }
                    else{
                        System.err.println("\n Informacao inesistente:" + ajuste); 
                        }
                    Cadastro.printInfo(marca, modelo, anoFabricacao, cor);
                    break;
                    
                default:
                    System.err.println("\n Entrada invalida:" + validacao);
                    break;

            }// Fim do switch validação
        } while(x);// Finm do While

    // Fechando o scanner
    sc.close();

    }// Fim do cadastro



    public static void printInfo(String marca, String modelo, int anoFabricacao, String cor){
        System.out.println("\n\nCerto! Agora verifique se as informações estão corretas para o cadastro:\n" + 
        "\n Marca do veiculo: " + marca +
        "\n Modelo do veiculo: " + modelo + 
        "\n Ano de fabricacao do veiculo: " + anoFabricacao +
        "\n Cor do veiculo: " + cor +
        "\n Placa do veiculo: " + Cadastro.placac +
        "\n Grupo que o veiculo pertence: " + Cadastro.grupoc);
    }



    // Verificacao grupo
    public static void verificacaoGrupo(){
        try (Scanner scanner = new Scanner(System.in)){            
            while(true) {
                // Verifica se o grupo é valido
                if ("Basico".equalsIgnoreCase(Cadastro.grupoc) || "Padrao".equalsIgnoreCase(Cadastro.grupoc) || "Premiun".equalsIgnoreCase(Cadastro.grupoc)) {
                    break; 
                } else {
                    System.err.println("\nGrupo inválido:" + Cadastro.grupoc);
                    // Solicitar nova entrada
                    System.out.print("Digite o grupo novamente: ");
                    Cadastro.grupoc = scanner.nextLine();
                }
            }
        }    
    }


    // Verificacao placa
    public static void verificacaoPlaca(){
        try (Scanner scanner = new Scanner(System.in)){
            while(true) {
                // Verifica se a placa atende ao modelo especificado
                if (Cadastro.placac.matches("[A-Z]{3}-[0-9][A-Z][0-9]{2}")) {
                    break; 
                } else {
                    System.err.println("\nFormato de placa inválido:" + Cadastro.placac);
                    // Solicitar nova entrada
                    System.out.print("Digite a placa novamente (modelo: LLL-NLNN): ");
                    Cadastro.placac = scanner.nextLine();
                }
            }
        }
    }
	
	public static String maiusculo(String entrada){
		if (entrada == null || entrada.isEmpty()) {
			return entrada;
		}
		return entrada.substring(0,1).toUpperCase + entrada.substring(1);
	}
}



