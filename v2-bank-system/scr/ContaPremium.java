public class ContaPremium extends ContaBase {

    ContaPremium(String nome, String senha) {
        super(nome, senha);
        this.limite = 7500;
    }

    @Override
    protected double valorPosTaxa(double valor) {
        return valor * 0.97;
    }
}
