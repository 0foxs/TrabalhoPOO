import java.util.Scanner;


public abstract class Frota {
	
	protected String marca;				// Marca do fabricante do veículo
	protected String modelo;			// Modelo do veículo
	protected int ano_fabricacao;		// Ano no qual o veículo foi fabricado
	protected String cor;				// Cor dominante do veículo (possíveis cores: azul, verde, vermelho, prata, preto, branco, amarelo, laranja e suas derivações)
	protected String placa;				// Placa no modelo LLLNLNN
	protected String grupo;				// Grupo ao qual o veículo pertence: básico, padrão, premium (influencia no valor de taxa de limpeza ext/int e diária) 
	protected boolean status_aluguel;	// Indica se o veículo foi, ou não, alugado.

	protected static float valor_diaria;        // Valor da diário do aluguel
	protected static float valor_tanque;        // Valor para encher o tanque do carro
	protected static float valor_limpezaExt;    // Valor da limpeza externa do carro
	protected static float valor_limpezaInt;    // Valor da limpeza interna do carro
	protected static float valor_seguro;        // Valor da diária do seguro do carro
	

	//aqui eu tirei os setters pq como não tem uma função especial dentro deles não é necessário usa-los, this.atributo ja funciona e gasta menos passos na execução. 
	public Frota (String marca, String modelo, int ano_fabricacao, String cor, String placa, String grupo) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano_fabricacao = ano_fabricacao;
		this.cor = cor;
		this.placa = placa; 
		this.grupo = grupo; 
		status_aluguel = false;			

	}
	
	// Métodos Getters	
	
	public String getMarca(){
		return this.marca;
	}
	
	public String getModelo(){
		return this.modelo;
	} 

	public int getAnoFabricacao(){
		return this.ano_fabricacao;
	}
	
	public String getCor(){
		return this.cor;
	}
	
	public String getPlaca(){
		return this.placa;
	}
	
	public String getGrupo(){
		return this.grupo;
	}

	public boolean isAlugado(){
		return this.status_aluguel;

	}

	
	// Métodos Setters 

	protected void setMarca(String marca){
		this.marca = marca;
	}	
	
	protected void setModelo(String modelo){
		this.modelo = modelo;
	}
	
	protected void setAnoFabricacao(int ano_fabricacao){
		this.ano_fabricacao = ano_fabricacao;
	}
	
	protected void setCor(String cor){
		this.cor = cor;
	}

	protected void setPlaca (String placa) {   // aqui a gente tem que fazer uma verificação para seguir o modelo de placa que o professor pediu 
		//loop
		while (true) {
            // Verifica se a placa atende ao padrão especificado
            if (placa.matches("[A-Z]{3}-[0-9][A-Z][0-9]{2}")) { //chat GPT me passo o metodo "matches", tem q ver se da certo
                this.placa = placa;
                System.out.println("Placa definida como: " + placa);
                break; 
            } else {
                System.err.println("Formato de placa inválido:" + placa);
                // Solicitar nova entrada
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a placa novamente: ");
                placa = scanner.nextLine();
				scanner.close();
            }
        }
	}
	

	protected void setGrupo (String grupo){ 
		//loop
		while (true) {
			 // Verifica se o grupo é valido
            if ("Basico".equals(grupo) || "Padrao".equals(grupo) || "Premium".equals(grupo)) {
                this.grupo = grupo;
                System.out.println("Grupo definido como: " + grupo);
                break; 
            } else {
                System.err.println("Valor de grupo inválido. Tente novamente.");
                // Solicitar nova entrada
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o grupo novamente: ");
                grupo = scanner.nextLine();
				scanner.close();
			}
		}
	}

	public void setAlugado(){
		this.status_aluguel = !this.status_aluguel;
	}

	// Metodo para alterar valores dos serviços nas subclasses
	public abstract void mudarValores();


	//toString
	public String toString() {
		return ("Marca: " + this.marca + 
				"\nModelo: " + this.modelo + 
				"\nAno de Fabricacao: " + this.ano_fabricacao + 
				"\nCor: " + this.cor +
				"\nPlaca: " + this.placa + 
				"\nGrupo: " + this.grupo);
	}
}
