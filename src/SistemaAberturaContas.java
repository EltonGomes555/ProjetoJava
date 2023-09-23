import java.util.Scanner;

class Conta {
    private final String nomeCliente;
    private final String numeroConta;
    private final String numeroAgencia;
    private final double saldo;
    private final String tipoConta;

    public Conta(String nomeCliente, String numeroConta, String numeroAgencia, double saldo, String tipoConta) {
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeCliente +
                ", Número da Conta: " + numeroConta +
                ", Número da Agência: " + numeroAgencia +
                ", Saldo Inicial: " + saldo +
                ", Tipo de Conta: " + tipoConta;
    }
}

public class SistemaAberturaContas {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Conta[] contas = new Conta[10];  // Vetor para armazenar as contas

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = obterEscolhaMenu();

            switch (opcao) {
                case 1:
                    cadastrarConta();
                    break;
                case 2:
                    acessarContas();
                    break;
                case 3:
                    removerConta();
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);
    }

    private static void exibirMenu() {
        System.out.println("\nMenu");
        System.out.println("1. Cadastrar Conta");
        System.out.println("2. Acessar Contas");
        System.out.println("3. Remover Conta");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterEscolhaMenu() {
        return scanner.nextInt();
    }

    private static void cadastrarConta() {
        scanner.nextLine();  // Limpar o buffer

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Digite o número da agência: ");
        String numeroAgencia = scanner.nextLine();

        System.out.print("Digite o saldo inicial: ");
        double saldo = scanner.nextDouble();

        scanner.nextLine();  // Limpar o buffer

        System.out.println("Escolha o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        System.out.println("3. Conta Salário");

        int tipoEscolhido;
        while (true) {
            try {
                tipoEscolhido = scanner.nextInt();
                if (tipoEscolhido >= 1 && tipoEscolhido <= 3) {
                    break;  // Sair do loop se a escolha for válida
                } else {
                    System.out.println("Escolha inválida. Digite um número de 1 a 3.");
                }
            } catch (Exception e) {
                System.out.println("Escolha inválida. Digite um número de 1 a 3.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        String tipoConta;
        switch (tipoEscolhido) {
            case 1:
                tipoConta = "Conta Corrente";
                break;
            case 2:
                tipoConta = "Conta Poupança";
                break;
            case 3:
                tipoConta = "Conta Salário";
                break;
            default:
                System.out.println("Escolha de tipo inválida. Voltando ao menu.");
                return;
        }

        Conta novaConta = new Conta(nomeCliente, numeroConta, numeroAgencia, saldo, tipoConta);

        // Armazenar a conta no vetor
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] == null) {
                contas[i] = novaConta;
                break;
            }
        }

        System.out.println("Conta criada com sucesso!");
    }

    private static void acessarContas() {
        System.out.println("\nContas cadastradas:");
        for (Conta conta : contas) {
            if (conta != null) {
                System.out.println(conta);
            }
        }
    }

    private static void removerConta() {
        scanner.nextLine();  // Limpar o buffer

        System.out.print("Digite o número da conta que deseja remover: ");
        String numeroContaRemover = scanner.nextLine();

        boolean contaEncontrada = false;

        for (int i = 0; i < contas.length; i++) {
            if (contas[i] != null && contas[i].toString().contains("Número da Conta: " + numeroContaRemover)) {
                contas[i] = null;
                System.out.println("Conta removida com sucesso!");
                contaEncontrada = true;
                break;
            }
        }

        if (!contaEncontrada) {
            System.out.println("Conta não encontrada.");
        }
    }
}







