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

}
