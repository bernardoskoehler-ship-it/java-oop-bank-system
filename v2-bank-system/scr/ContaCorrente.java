public class ContaCorrente extends ContaBase{

    ContaCorrente(String nome, String senha) {
        super(nome, senha);
        this.limite = 2500;
    }

    @Override
    public boolean podeRemoverSaldo(double valor) {
        if(!valorValido(valor)) {
            return false;
        }
        if(valor > limite) {
            System.out.println("R$ " +valor +" esta acima do limite da conta");
            return false;
        }
        if((getSaldo() - valor) < -500) {
            System.out.println("Nao tem saldo o suficiente!");
            return false;
        }
        return true;
    }
}
