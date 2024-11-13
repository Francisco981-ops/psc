import java.util.ArrayList;
import java.util.Scanner;

/** Classe Veiculo que representa as propriedades de um veículo. */
class Veiculo {
    private String marca, modelo, numeroChassi, placa, cor;

    /** Construtor da classe Veiculo. */
    public Veiculo(String marca, String modelo, String numeroChassi, String placa, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.numeroChassi = numeroChassi;
        this.placa = placa;
        this.cor = cor;
    }

    /** Exibe as informações do veículo em formato de string. */
    @Override
    public String toString() {
        return String.format("Veiculo  {marca='%s', modelo='%s', chassi='%s', placa='%s', cor='%s'}", marca, modelo, numeroChassi, placa, cor);
    }
}

/** Classe Cadastro para gerenciar o cadastro de veículos. */
class Cadastro {
    private ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    /** Método para adicionar um novo veículo ao cadastro. */
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

    /** Imprime todos os veículos cadastrados. */
    public void imprimirCadastro() {
        listaVeiculos.forEach(System.out::println);
    }
}

/** Classe principal para executar o cadastro de veículos. */
public class cadastroVeiculo {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.print("\n1. Cadastrar Veículo\n2. Imprimir Cadastro\n3. Sair\nEscolha: ");
            opcao = scanner.nextInt(); scanner.nextLine();
            if (opcao == 1) cadastro.cadastrarVeiculo();
            else if (opcao == 2) cadastro.imprimirCadastro();
        } while (opcao != 3);
        
        scanner.close();
    }
}