package org.example;

public class Main {

    public static void main(String[] args) {
        try {
            ContaDAO dao = new ContaDAO();
            dao.criar_TabelaConta();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MenuBanco mb = new MenuBanco();
        mb.iniciarBanco();

    }
}
