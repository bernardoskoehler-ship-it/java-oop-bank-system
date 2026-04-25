import java.util.HashMap;
import java.util.Map;


public class Banco {
    HashMap<String, ContaBase> contas = new HashMap<>();

    public void adicionarConta(int tipo) {
        if(tipo <= 0 || tipo > 3) {
            System.out.println("Tipo de conta invalida");
            return;
        }

    }


}
