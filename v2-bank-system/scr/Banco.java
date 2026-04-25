import java.util.HashMap;
import java.util.Map;


public class Banco {
    private Map<String, ContaBase> contas = new HashMap<>();


    public boolean contaExistente(String nome) {
        if(nome == null || nome.isBlank()) {
            System.out.println("Nome invalido!");
            return false;
        }
        return contas.containsKey(nome);
    }

    public ContaBase buscarConta(String nome) {
        return contas.get(nome);
    }
    public void mostrarConta(String nome) {
        ContaBase conta = buscarConta(nome);

        if (conta == null) {
            System.out.println("Nao existe uma conta com esse ID!");
            return;
        }

        System.out.println("Nome: " + conta.getNome());
        System.out.println("Saldo: R$ " + conta.getSaldo());
        System.out.println("Conta ativa: " + conta.contaEstaAtiva());
    }

    public boolean criarConta(String nome, String senha, String tipo) {
        if(tipo == null || tipo.isBlank()) {
            System.out.println("Tipo de conta invalido!");
            return false;
        }
        if(contaExistente(nome)) {
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
}
