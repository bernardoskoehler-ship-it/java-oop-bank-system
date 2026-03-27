import java.util.Scanner;
import java.util.ArrayList;

abstract class ContaBase {
    Scanner scanner = new Scanner(System.in);
    private String titular;
    private double saldo;
    private String senha;

    private int tentativasValidas = 3;
    private boolean contaAtiva = false;
    private ArrayList<String> historico = new ArrayList<>();

    protected double valorMaximo;

    ContaBase(String titular, double saldo, String senha) {
        setTitular(titular);
        setSaldo(saldo);
        setSenha(senha);
    }

    /// /// /// /// /// Get/Set /// /// /// /// ///
    private void setTitular(String titular) {
        if (titular != null && !titular.trim().isEmpty()) {
            this.titular = titular;
            return;
        }
        System.out.println("Nome de titular invalido, nome padrao *Null* adotado.");
        this.titular = "Null";
    }
    protected String getTitular() {
        return titular;
    }
    private void setSaldo(double saldo) {
        if (!valorValido(saldo)) {
            System.out.println("Saldo inserido invalido, saldo padrao *100.00* adotado.");
            return;
        }
        this.saldo = saldo;
    }
    protected double getSaldo() {
        return saldo;
    }
    private void setSenha(String senha) {
        if (titular != null && !senha.trim().isEmpty() && senha.length() >= 8) {
            this.senha = senha;
            return;
        }
        System.out.println("Senha inserida invalida, senha padrao *12345678* adotada.");
        this.senha = "12345678";
    }
    private String getSenha() {
        return senha;
    }
    protected int getTentativasValidas() {
        return tentativasValidas;
    }

    /// /// /// /// /// Get/Set /// /// /// /// ///
    /// /// /// /// /// Validações /// /// /// ///
    protected boolean valorValido(double valor) {
        if (valor > 0) {
            return true;
        }
        System.out.println("Valor inserido invalido!");
        return false;
    }

    protected boolean contaEstaAtiva() {
        if(contaAtiva) {
            return true;
        }
        System.out.println("Acesse a conta primeiro");
        return false;
    }

    protected boolean temTentativas() {
        if(getTentativasValidas() <= 0) {
            System.out.println("Nao tem mais tentativas");
        }
        return getTentativasValidas() > 0;
    }
    private boolean tentativaSenha() {
        if(!temTentativas()) {
            System.out.println("Você nao tem mais tentativas.");
            return false;
        }
        System.out.println("Digite a senha atual:");
        String tentativaSenha = scanner.nextLine();
        if(!tentativaSenha.equals(getSenha())){
            tentativasValidas --;
            System.out.println("Senha inseria incorreta, tentativas restantes: " +getTentativasValidas());
            return  false;
        }
        tentativasValidas = 3;
        return true;
    }
    private boolean podeSacar(double valor) {
        if(!valorValido(valor)) {
            return false;
        }
        if(getSaldo() - valor < 0) {
            System.out.println("Nao tem saldo o suficiente");
            return false;
        }
        if(valor > valorMaximo) {
            System.out.println("Valor é maior que limite de saque");
            return false;
        }
        return true;
    }
    /// /// /// /// /// Validações /// /// /// ///
    protected void ativarConta() {
        if (contaEstaAtiva()) {
            return;
        }
        if(tentativaSenha()) {
            contaAtiva = true;
            System.out.println("Você acessou a conta do " + getTitular());
        }
    }
    protected void mudarSenha() {
        if(!contaEstaAtiva()) {
            return;
        }
        if(tentativaSenha()) {
            System.out.println("Digite uma nova senha:");
            String novaSenha = scanner.nextLine();
            setSenha(novaSenha);
            return;
        }
    }
    protected void mudarTitular() {
        if(!contaEstaAtiva()) {
            return;
        }
        if(tentativaSenha()) {
            System.out.println("Digite um novo nome:");
            String novoTitular = scanner.nextLine();
            setTitular(novoTitular);
            return;
        }
    }
    private void adicionarSaldo(double valor) {
        saldo += valor;
    }
    private void removerSaldo(double valor) {
        saldo -= valor;
    }

    protected void depositar(double valor){
        if(!contaEstaAtiva()) {
            return;
        }
        if(!valorValido(valor)) {
            System.out.println(getTitular() +" Nao foi pocivel depositar quantia.");
            return;
        }
        System.out.println(getTitular() +" depositou R$" +valor);
        adicionarSaldo(valor);
        historico.add( "+" + String.valueOf(valor));
    }
    protected void sacar(double valor) {
        if(!contaEstaAtiva()) {
            return;
        }
        if(!podeSacar(valor)) {
            System.out.println(getTitular() +" Nao foi possivel sacar quantia.");
            return;
        }
        System.out.println(getTitular() +" sacou R$" +valor);
        removerSaldo(valor);
        historico.add( "-" + String.valueOf(valor));
    }
    protected void transferir(double valor, ContaBase destino) {
        if(!contaEstaAtiva()) {
            return;
        }
        if(this == destino) {
            System.out.println(getTitular() +" Nao e possivel tranferir para si mesmo. Tente fazer um deposito");
            return;
        }
        if(podeSacar(valor)) {
            System.out.println(getTitular() +" tranferiu R$" +valor +" para " +destino.getTitular());
            removerSaldo(valor);
            historico.add( "-" + String.valueOf(valor));
            destino.adicionarSaldo(valor);
            destino.historico.add( "+" + String.valueOf(valor));
        }
    }
    protected void mostrarConta() {
        System.out.println("Titular: " +getTitular() +"/ Saldo: R$" +getSaldo() +"/ Limite da conta: R$" +valorMaximo +"/ Senha: ********");
    }
    protected void mostrarHistorico() {
        System.out.println("Historico da conta: " +getTitular());
        for(int i = 0;i < historico.size(); i ++) {
            System.out.println(historico.get(i));
        }
    }

}
