import java.util.ArrayList;

abstract class ContaBase {
    private ArrayList<String> historico = new ArrayList<>();
    private String nome;

    private double saldo;
    protected double limite;

    private String senhaAtual;
    private int tentativas = 5;

    private boolean contaAtiva = false;

    ContaBase(String nome, String senha) {
        setNome(nome);
        setSenha(senha);
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean valorValido(double valor) {
        if(valor > 0) {
            return true;
        }
        System.out.println("Valor inserido invalido!");
        return false;
    }

    public boolean temTentativas() {
        if(tentativas > 0) {
            return true;
        }
        System.out.println("Nao tem mais tentativas!");
        return false;
    }
    public boolean verificarSenha(String senha) {
        if(senha != null && senha.equals(senhaAtual)) {
            return true;
        }
        tentativas --;
        System.out.println("Tentativas restantes: " +tentativas);
        return false;
    }

    protected void ativarConta(String senha) {
        if(contaEstaAtiva()) {
            System.out.println("A conta ja esta ativa!");
            return;
        }
        if(!temTentativas()) {
            return;
        }
        if(!verificarSenha(senha)) {
            return;
        }
        contaAtiva = true;
        System.out.println("Conta: " +getNome() +" Ativa.");
        tentativas = 5;
    }
    public boolean contaEstaAtiva() {
        if(contaAtiva == false) {
            System.out.println(nome +" ative a conta");
            return false;
        }
        return true;
    }

    private void setNome(String nome) {
        if(nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
            return;
        }
        System.out.println("Nome invalido, nome padrao *NULL* adotado!");
        this.nome = "NULL";
    }
    public String getNome() {
        return nome;
    }
    public void mudarNome(String nome) {
        if(contaEstaAtiva()) {
            setNome(nome);
        }
    }
    private boolean senhaValida(String senha) {
        return senha != null && senha.length() >= 8;
    }
    private void setSenha(String senha) {
        if(!senhaValida(senha)) {
            System.out.println("Senha invalida, senha padrao *12345678* adotada!");
            this.senhaAtual = "12345678";
            return;
        }
        this.senhaAtual = senha;
    }
    public void mudarSenha(String senhaAtual, String novaSenha) {
        if(!verificarSenha(senhaAtual)) {
            return;
        }
        setSenha(novaSenha);
    }

    public boolean podeRemoverSaldo(double valor) {
        if(!valorValido(valor)) {
            return false;
        }
        if(valor > limite) {
            System.out.println("R$ " +valor +" esta acima do limite da conta");
            return false;
        }
        if(getSaldo() < valor) {
            System.out.println("Nao tem saldo o suficiente!");
            return false;
        }
        return true;
    }
    private boolean removerSaldo(double valor) {
        if(!podeRemoverSaldo(valor)) {
            return false;
        }
        System.out.println("R$ " +valor +" removido de " +getNome());
        saldo -= valor;
        return true;
    }

    protected double valorTaxado(double valor) {
        return valor * 0.85;
    }
    private boolean adicionarSaldo(double valor) {
        if(!valorValido(valor)) {
            return false;
        }
        System.out.println("R$ " +valor +" adicionado a " +getNome());
        saldo += valorTaxado(valor);
        return true;
    }

    public boolean sacar(double valor) {
        if(!contaEstaAtiva()) {
            return false;
        }
        if(!removerSaldo(valor)) {
            return false;
        }
        historico.add("Saque: -" + valor);
        return true;
    }
    public boolean depositar(double valor) {
        if(!contaEstaAtiva()) {
            return false;
        }
        if(!adicionarSaldo(valor)) {
            return false;
        }
        historico.add("Depósito: +" + valor);
        return true;
    }
    public boolean transferir(ContaBase destino, double valor) {
        if(!contaEstaAtiva()) {
            return false;
        }
        if(!removerSaldo(valor)) {
            System.out.println("Nao foi possivel transferir");
            return false;
        }
        if(!destino.adicionarSaldo(valor)) {
            adicionarSaldo(valor);
            System.out.println("Nao foi possivel transferir");
            return false;
        }
        historico.add("Transferencia enviada: -" + valor);
        destino.historico.add("Transferencia recebida: +" + valor);
        System.out.println(getNome() + " transferiu R$ " + valor + " para " + destino.getNome());
        return true;
    }

    public void mostrarHistorico() {
        for(int i = 0; i < historico.size(); i++) {
            System.out.println(historico.get(i));
        }
    }

}
