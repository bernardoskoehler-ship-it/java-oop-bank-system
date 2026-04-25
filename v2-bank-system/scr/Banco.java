import java.util.HashMap;
import java.util.Map;


public class Banco {
    private Map<String, ContaBase> contas = new HashMap<>();


    public boolean nomeValido(String nome) {
        return nome != null && !nome.isBlank();
    }
    public boolean isContaExistente(String nome) {
        return nomeValido(nome) && contas.containsKey(nome);
    }

    public ContaBase buscarConta(String nome) {
        if(!nomeValido(nome)) {
            System.out.println("Nome invalido!");
            return null;
        }

        ContaBase conta = contas.get(nome);
        if(conta == null) {
            System.out.println("Conta inexistente!");
            return null;
        }
        return conta;
    }

    public void mostrarConta(String nome) {
        ContaBase conta = buscarConta(nome);

        if (conta == null) {
            return;
        }

        System.out.println("Nome: " + conta.getNome());
        System.out.println("Saldo: R$ " + conta.getSaldo());
        System.out.println("Conta ativa: " + conta.contaEstaAtiva());
    }

    public boolean criarConta(String nome, String senha, String tipo) {
        if(!nomeValido(nome)) {
            System.out.println("Nome invalido!");
            return false;
        }
        if(tipo == null || tipo.isBlank()) {
            System.out.println("Tipo de conta invalido!");
            return false;
        }
        if(isContaExistente(nome)) {
            System.out.println("Ja existe uma conta com esse ID!");
            return false;
        }

        ContaBase novaConta;
        switch (tipo.toLowerCase()) {
            case "corrente":
                novaConta = new ContaCorrente(nome, senha);
                break;

            case "poupanca":
                novaConta = new ContaPoupanca(nome, senha);
                break;

            case "premium":
                novaConta = new ContaPremium(nome, senha);
                break;

            default:
                System.out.println("Tipo de conta invalido!");
                return false;
        }
        contas.put(nome, novaConta);
        System.out.println("Conta criada com sucesso!");
        return true;
    }

    public boolean mostrarHistorico(String nome) {
        ContaBase conta = buscarConta(nome);

        if(conta == null) {
            return false;
        }
        conta.mostrarHistorico();
        return true;
    }

    public boolean ativarConta(String nome, String senha) {
        ContaBase conta = buscarConta(nome);

        if(conta == null) {
            return false;
        }
        return conta.ativarConta(senha);
    }
    public boolean depositar(String nome, double valor) {
        ContaBase conta = buscarConta(nome);

        if(conta == null) {
            return false;
        }
        return conta.depositar(valor);
    }
    public boolean sacar(String nome, double valor) {
        ContaBase conta = buscarConta(nome);

        if(conta == null) {
            return false;
        }
        return conta.sacar(valor);
    }
    public boolean transferir(String nome, String destino, double valor) {
        ContaBase contaOrigem = buscarConta(nome);
        ContaBase contaDestino = buscarConta(destino);

        if(contaOrigem == null || contaDestino == null) {
            return false;
        }
        return contaOrigem.transferir(contaDestino, valor);
    }

}
