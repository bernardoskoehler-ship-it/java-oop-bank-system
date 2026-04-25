public class ContaPoupanca extends ContaBase{

    private double taxaRendimento = 0.005;

    ContaPoupanca(String nome, String senha) {
        super(nome, senha);
        this.limite = 1000;
    }
    @Override
    protected double valorPosTaxa(double valor) {
        return valor;
    }
    public boolean aplicarRendimento() {
        double rendimento = getSaldo() * taxaRendimento;
        if(rendimento <= 0) {
            System.out.println("Nao foi possivel aplicar rendimento.");
            return false;
        }
        depositar(rendimento);
        System.out.println("Rendimento aplicado: R$ " + rendimento);
        return true;
    }
}
