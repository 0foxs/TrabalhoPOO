import java.util.Scanner;


public class Padrao extends Frota{
    
    public Padrao(String marca, String modelo, int ano_fabricacao, String cor, String placa, String grupo) {
        super(marca, modelo, ano_fabricacao, cor, placa, grupo);
    }

    public void mudarValores(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\n Informe quais valores deseja alterar: ");
        String ajuste = sc.nextLine();
        System.out.println(" ");

        // Alterar valores
        if (ajuste.toLowerCase().contains("diaria")) {
            System.out.print("Digite a marca do veículo: ");
            Padrao.valor_diaria = sc.nextInt();
            sc.nextLine();
        }

        if (ajuste.toLowerCase().contains("tanque")) {
            System.out.print("Digite o modelo do veículo: ");
            Padrao.valor_tanque = sc.nextInt();
            sc.nextLine();
        }

        if (ajuste.toLowerCase().contains("interna")) {
            System.out.print("Digite a marca do veículo: ");
            Padrao.valor_limpezaExt = sc.nextInt();
            sc.nextLine();
        }

        if (ajuste.toLowerCase().contains("externa")) {
            System.out.print("Digite o modelo do veículo: ");
            Padrao.valor_limpezaInt = sc.nextInt();
            sc.nextLine();
        }

        if (ajuste.toLowerCase().contains("seguro")) {
            System.out.print("Digite a marca do veículo: ");
            Padrao.valor_seguro = sc.nextInt();
            sc.nextLine();
        }
        sc.close();
    } 
}