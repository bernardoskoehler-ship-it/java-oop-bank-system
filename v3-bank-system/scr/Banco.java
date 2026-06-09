package org.example;

public class Banco {

    public boolean banco_CriarConta(String nome, String senha) {
        try {
            if(nome == null || nome.trim().isEmpty()) {
                System.out.println("Nome inválido!");
                return false;
            }
            if(senha == null || senha.length() < 8) {
                System.out.println("Senha inválido!");
                return false;
            }

            ContaDAO dao = new ContaDAO();

            dao.inserir_TabelaConta(nome, senha);

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean banco_AtivarConta(int id, String senha) {
        try {
            ContaDAO dao = new ContaDAO();

            Conta conta = dao.mostrarId_TabelaConta(id);

            if(conta.ativarConta(senha)) {
                dao.atualizarContaAtiva_TabelaConta(id, true);
                return true;
            }
            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean banco_depositar(int id, double valor) {
        try {
            ContaDAO dao = new ContaDAO();
            Conta conta = dao.mostrarId_TabelaConta(id);

            if(conta == null) {
                return false;
            }
            if(!conta.contaEstaAtiva()) {
                return false;
            }
            if(valor <= 0) {
                return false;
            }

            conta.adicionarSaldo(valor);
            dao.atualizarSaldo_TabelaConta(id, conta.getSaldo());

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean banco_sacar(int id, double valor) {
        try {
            ContaDAO dao = new ContaDAO();
            Conta conta = dao.mostrarId_TabelaConta(id);

            if(conta == null) {
                System.out.println("Conta não encontrada.");
                return false;
            }
            if(!conta.contaEstaAtiva()) {
                System.out.println("Conta não está ativa.");
                return false;
            }
            if(valor <= 0) {
                System.out.println("Valor inválido.");
                return false;
            }
            if(conta.getLimite() < valor) {
                System.out.println("Valor ultrapassa limite.");
                return false;
            }
            if(conta.getSaldo() < valor) {
                System.out.println("Valor maior que saldo.");
                return false;
            }

            conta.removerSaldo(valor);
            dao.atualizarSaldo_TabelaConta(id, conta.getSaldo());

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
