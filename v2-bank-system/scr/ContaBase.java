abstract class ContaBase {

    private String nome;

    private int saldo;
    protected int limite;

    private String senhaAtual;
    private int tentativas = 5;

    private boolean contaAtiva = false;

    ContaBase(String nome, String senha) {
        setNome(nome);
        setSenha(senha);
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
        if(senha.equals(senhaAtual)) {
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
            this.nome = nome;
        }
    }

    private void setSenha(String senha) {
        if(senha.length() >= 8) {
            this.senhaAtual = senha;
        }
        System.out.println("Senha invalida, senha padrao *12345678* adotada!");
        this.senhaAtual = "12345678";
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
        if(saldo < valor) {
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

    private boolean adicionarSaldo(double valor) {
        if(!valorValido(valor)) {
            return false;
        }
        System.out.println("R$ " +valor +" adicionado a " +getNome());
        saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        return removerSaldo(valor);
    }
    public boolean depositar(double valor) {
        return adicionarSaldo(valor);
    }
    public boolean transferir(ContaBase destino, double valor) {
        if(sacar(valor)) {
            destino.depositar(valor);
            System.out.println(getNome() +" transferiu R$ " +valor +" para " +destino.getNome());
            return true;
        }
        System.out.println("Nao foi possivel transferir");
        return false;
    }

}
