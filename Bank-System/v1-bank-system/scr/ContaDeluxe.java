public class ContaDeluxe extends ContaBase {

    ContaDeluxe(String titular, double saldo, String senha) {
        super(titular, saldo, senha);
        this.valorMaximo = 7500;
    }
}
