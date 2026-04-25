import java.util.Scanner;

public class MenuBanco {
    Banco b = new Banco();
    Scanner scanner = new Scanner(System.in);

    private int lerInt() {
        while(true) {
            if(scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine(); // limpa o ENTER
                return valor;
            } else {
                System.out.println("Digite um numero inteiro valido!");
                scanner.nextLine(); // limpa entrada inválida
            }
        }
    }
    private double lerDouble() {
        while(true) {
            if(scanner.hasNextDouble()) {
                double valor = scanner.nextDouble();
                scanner.nextLine();
                return valor;
            } else {
                System.out.println("Digite um valor numerico valido!");
                scanner.nextLine();
            }
        }
    }
    public void menu() {
        String nome;
        String nomeDestino;
        String senha;
        String tipo;
        double valor;
        System.out.println("-Sistema Bancario Versao 2-");
        while(true) {
            System.out.println("1 - Criar conta");
            System.out.println("2 - Ativar conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Mostrar conta");
            System.out.println("7 - Mostrar histórico");
            System.out.println("0 - Sair");
            System.out.println("Digite o numero da açao que voce deseja realizar");
            int opcao = lerInt();
            switch(opcao){
                case 1 :
                    System.out.println("Digite um Nome para conta:");
                    nome = scanner.nextLine();
                    System.out.println("Digite uma Senha para conta:");
                    senha = scanner.nextLine();
                    System.out.println("Digite o Tipo da conta (corrente, poupanca, premium):");
                    tipo = scanner.nextLine();
                    b.criarConta(nome, senha, tipo);
                    continue;

                case 2 :
                    System.out.println("Digite o Nome da conta:");
                    nome = scanner.nextLine();
                    System.out.println("Digite a Senha da conta:");
                    senha = scanner.nextLine();
                    b.ativarConta(nome, senha);
                    continue;
                case 3 :
                    System.out.println("Digite o Nome da conta:");
                    nome = scanner.nextLine();
                    System.out.println("Digite o quanto voce gostaria de depositar:");
                    valor = lerDouble();
                    b.depositar(nome, valor);
                    continue;
                case 4 :
                    System.out.println("Digite o Nome da conta:");
                    nome = scanner.nextLine();
                    System.out.println("Digite o quanto voce gostaria de sacar:");
                    valor = lerDouble();
                    b.sacar(nome, valor);
                    continue;
                case 5 :
                    System.out.println("Digite o Nome da conta:");
                    nome = scanner.nextLine();
                    System.out.println("Digite o Nome da conta destino:");
                    nomeDestino = scanner.nextLine();
                    System.out.println("Digite o quanto voce gostaria de transferir:");
                    valor = lerDouble();
                    b.transferir(nome, nomeDestino, valor);
                    continue;
                case 6 :
                    System.out.println("Digite o Nome da conta:");
                    nome = scanner.nextLine();
                    b.mostrarConta(nome);
                    continue;
                case 7 :
                    System.out.println("Digite o Nome da conta:");
                    nome = scanner.nextLine();
                    b.mostrarHistorico(nome);
                    continue;
                case 0 :
                    return;
                default :
                    System.out.println("Comando inserido invalido!");
                    continue;
            }

        }
    }

}
