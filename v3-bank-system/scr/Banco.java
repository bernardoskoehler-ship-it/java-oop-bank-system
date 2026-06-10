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

            if(conta == null) {
                System.out.println("Conta não encontrada.");
                return false;
            }
            if(conta.ativarConta(senha)) {
                dao.atualizarContaAtiva_TabelaConta(id, true);
                return true;
            }
            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean banco_DesativarConta(int id) {
        try {

            ContaDAO dao = new ContaDAO();

            Conta conta = dao.mostrarId_TabelaConta(id);

            if(conta == null) {
                System.out.println("Conta não encontrada.");
                return false;
            }

            if(!conta.contaEstaAtiva()) {
                System.out.println("Conta já está inativa.");
                return false;
            }

            dao.atualizarContaAtiva_TabelaConta(id, false);

            System.out.println("Logout realizado.");
            return true;

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
            if(!conta.podeRemoverSaldo(valor)) {
                return false;
            }

            conta.removerSaldo(valor);
            dao.atualizarSaldo_TabelaConta(id, conta.getSaldo());

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean banco_transferir(int id, int destino, double valor) {
        try {
            ContaDAO dao = new ContaDAO();
            Conta conta = dao.mostrarId_TabelaConta(id);
            Conta contaDestino = dao.mostrarId_TabelaConta(destino);

            if(conta == null) {
                System.out.println("Conta origem não encontrada.");
                return false;
            }
            if(contaDestino == null) {
                System.out.println("Conta destino não encontrada.");
                return false;
            }
            if(id == destino) {
                System.out.println("Não é possivel transferir para a própia conta.");
                return false;
            }
            if(!conta.podeRemoverSaldo(valor)) {
                return false;
            }

            conta.removerSaldo(valor);
            contaDestino.adicionarSaldo(valor);

            dao.atualizarSaldo_TabelaConta(id, conta.getSaldo());
            dao.atualizarSaldo_TabelaConta(destino, contaDestino.getSaldo());

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void banco_MostrarConta(int id) {
        try {
            ContaDAO dao = new ContaDAO();
            Conta conta = dao.mostrarId_TabelaConta(id);

            System.out.println(conta.getId());
            System.out.println(conta.getNome());
            System.out.println(conta.getSaldo());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
