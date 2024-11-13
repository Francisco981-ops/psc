import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {
    private String nome;

    public Pessoa(String nome) { this.nome = nome; }
    public String getNome() { return nome; }
    public void exibe() { System.out.println("Pessoa: Nome='" + nome + "'"); }
}

class PessoaFisica extends Pessoa {
    private String cpf;
    public PessoaFisica(String nome, String cpf) { super(nome); this.cpf = cpf; }
    @Override public void exibe() { System.out.println("Pessoa Física: Nome='" + getNome() + "', CPF='" + cpf + "'"); }
}

class PessoaJuridica extends Pessoa {
    private String cnpj;
    public PessoaJuridica(String nome, String cnpj) { super(nome); this.cnpj = cnpj; }
    @Override public void exibe() { System.out.println("Pessoa Jurídica: Nome='" + getNome() + "', CNPJ='" + cnpj + "'"); }
}

class Cadastro {
    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarPessoa(int tipo) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        Pessoa p = (tipo == 1) ? new Pessoa(nome) :
                   (tipo == 2) ? new PessoaFisica(nome, scanner.nextLine()) :
                                 new PessoaJuridica(nome, scanner.nextLine());
        listaPessoas.add(p);
        System.out.println("Cadastro realizado com sucesso!\n");
    }

    public void imprimirCadastro() {
        System.out.println("\nLista de Pessoas Cadastradas:");
        listaPessoas.forEach(Pessoa::exibe);
    }
}

public class cadastroPessoa {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.print("\n1. Cadastrar Pessoa\n2. Cadastrar Pessoa Física\n3. Cadastrar Pessoa Jurídica\n4. Imprimir Cadastro\n5. Sair\nEscolha: ");
            opcao = scanner.nextInt(); scanner.nextLine();
            if (opcao >= 1 && opcao <= 3) cadastro.cadastrarPessoa(opcao);
            else if (opcao == 4) cadastro.imprimirCadastro();
        } while (opcao != 5);
    }
}