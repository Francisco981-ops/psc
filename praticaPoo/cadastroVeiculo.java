import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que representa um veículo com atributos básicos como marca, modelo, chassi, placa e cor.
 */
class Veiculo {
    private String marca, modelo, numeroChassi, placa, cor;

    /**
     * Construtor da classe Veiculo.
     * Marca do veículo.
     * Modelo do veículo.
     * Número do chassi do veículo.
     * Placa do veículo.
     * Cor do veículo.
     */
    public Veiculo(String marca, String modelo, String numeroChassi, String placa, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.numeroChassi = numeroChassi;
        this.placa = placa;
        this.cor = cor;
    }

    /**
     * Retorna uma representação em formato de string dos dados do veículo.
     *  String com os atributos do veículo formatados.
     */
    public String toString() {
        return String.format("Veiculo {marca='%s', modelo='%s', chassi='%s', placa='%s', cor='%s'}", 
                marca, modelo, numeroChassi, placa, cor);
    }
}

/**
 * Classe que gerencia o cadastro de veículos, permitindo adicionar e exibir os registros.
 */
class Cadastro {
    private ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Realiza o cadastro de um novo veículo solicitando as informações ao usuário.
     */
    public void cadastrarVeiculo() {
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Número do Chassi: ");
        String numeroChassi = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        listaVeiculos.add(new Veiculo(marca, modelo, numeroChassi, placa, cor));
        System.out.println("Veículo cadastrado com sucesso!\n");
    }

    /**
     * Exibe a lista de veículos cadastrados no formato definido pelo método toString().
     */
    public void imprimirCadastro() {
        listaVeiculos.forEach(System.out::println);
    }
}

/**
 * Classe principal que inicializa o programa de cadastro de veículos.
 */
public class cadastroVeiculo {
    /**
     * Método principal que gerencia o menu de interação com o usuário para o cadastro de veículos.
     * Argumentos de linha de comando (não utilizado neste programa).
     */
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.print("\n1. Cadastrar Veículo\n2. Imprimir Cadastro\n3. Sair\nEscolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            if (opcao == 1) {
                cadastro.cadastrarVeiculo();
            } else if (opcao == 2) {
                cadastro.imprimirCadastro();
            }
        } while (opcao != 3);

        scanner.close();
    }
}