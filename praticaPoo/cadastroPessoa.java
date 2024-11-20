import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que representa uma pessoa genérica com um nome.
 */
class Pessoa {
    private String nome;

    /**
     * Construtor da classe Pessoa.
     *
     * @param nome Nome da pessoa.
     */
    public Pessoa(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o nome da pessoa.
     *
     * @return Nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Exibe os dados da pessoa no formato "Pessoa: Nome='nome'".
     */
    public void exibe() {
        System.out.println("Pessoa: Nome='" + nome + "'");
    }
}

/**
 * Classe que representa uma pessoa física, herdando a classe Pessoa.
 */
class PessoaFisica extends Pessoa {
    private String cpf;

    /**
     * Construtor da classe PessoaFisica.
     *
     * @param nome Nome da pessoa física.
     * @param cpf  CPF da pessoa física.
     */
    public PessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    /**
     * Exibe os dados da pessoa física no formato
     * "Pessoa Física: Nome='nome', CPF='cpf'".
     */
    @Override
    public void exibe() {
        System.out.println("Pessoa Física: Nome='" + getNome() + "', CPF='" + cpf + "'");
    }
}

/**
 * Classe que representa uma pessoa jurídica, herdando a classe Pessoa.
 */
class PessoaJuridica extends Pessoa {
    private String cnpj;

    /**
     * Construtor da classe PessoaJuridica.
     *
     * @param nome Nome da pessoa jurídica.
     * @param cnpj CNPJ da pessoa jurídica.
     */
    public PessoaJuridica(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    /**
     * Exibe os dados da pessoa jurídica no formato
     * "Pessoa Jurídica: Nome='nome', CNPJ='cnpj'".
     */
    @Override
    public void exibe() {
        System.out.println("Pessoa Jurídica: Nome='" + getNome() + "', CNPJ='" + cnpj + "'");
    }
}

/**
 * Classe que gerencia o cadastro de pessoas, permitindo cadastrar
 * e exibir os registros.
 */
class Cadastro {
    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Realiza o cadastro de uma pessoa.
     *
     * @param tipo Tipo de pessoa a ser cadastrada (1 para Pessoa, 2 para Pessoa Física,
     *             3 para Pessoa Jurídica).
     */
    public void cadastrarPessoa(int tipo) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        Pessoa p = (tipo == 1) ? new Pessoa(nome)
                : (tipo == 2) ? new PessoaFisica(nome, scanner.nextLine())
                : new PessoaJuridica(nome, scanner.nextLine());
        listaPessoas.add(p);
        System.out.println("Cadastro realizado com sucesso!\n");
    }

    /**
     * Imprime a lista de pessoas cadastradas.
     */
    public void imprimirCadastro() {
        System.out.println("\nLista de Pessoas Cadastradas:");
        listaPessoas.forEach(Pessoa::exibe);
    }
}

/**
 * Classe principal que inicializa o programa de cadastro de pessoas.
 */
public class cadastroPessoa {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.print("\n1. Cadastrar Pessoa\n2. Cadastrar Pessoa Física\n3. Cadastrar Pessoa Jurídica\n4. Imprimir Cadastro\n5. Sair\nEscolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao >= 1 && opcao <= 3) {
                cadastro.cadastrarPessoa(opcao);
            } else if (opcao == 4) {
                cadastro.imprimirCadastro();
            }
        } while (opcao != 5);
    }
}