public class ContaPadrao extends ContaBase{

    ContaPadrao(String titular, double saldo, String senha) {
        super(titular, saldo, senha);
        this.valorMaximo = 1000;
    }
}
