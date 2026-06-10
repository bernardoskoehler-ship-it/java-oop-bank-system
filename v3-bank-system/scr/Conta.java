package org.example;

import java.util.ArrayList;

public class Conta {
    private ArrayList<String> historico = new ArrayList<>();

    private int id;
    private String nome;

    private String senha;

    private double saldo;
    private double limite = 2500;

    private boolean contaAtiva = false;

    Conta(int id, String nome, String senha, double saldo, double limite, boolean contaAtiva) {
        this.id = id;
        setNome(nome);
        setSenha(senha);
        this.saldo = saldo;
        this.limite = limite;
        this.contaAtiva = contaAtiva;
    }

    public int getId() {
        return id;
    }

    private boolean setNome(String nome) {
        if(nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
            return true;
        }
        System.out.println("Nome invalido!");
        return false;
    }
    public String getNome() {
        return nome;
    }

    private boolean setSenha(String senha) {
        if(senha != null && senha.length() >= 8) {
            this.senha = senha;
            return true;
        }
        System.out.println("Senha invalida!");
        return false;
    }
    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }
    public boolean contaEstaAtiva() {
        return contaAtiva;
    }

    public boolean valorValido(double valor) {
        if(valor > 0) {
            return true;
        }
        System.out.println("Valor inserido invalido!");
        return false;
    }

    public boolean verificarSenha(String senha) {
        if(senha != null && senha.equals(getSenha())) {
            return true;
        }
        System.out.println("Senha incorreta");
        return false;
    }

    protected boolean ativarConta(String senha) {
        if(contaEstaAtiva()) {
            System.out.println("A conta ja esta ativa!");
            return false;
        }
        if(!verificarSenha(senha)) {
            return false;
        }
        contaAtiva = true;
        System.out.println("Conta: " +getNome() +" Ativada.");
        return true;
    }

    public boolean podeRemoverSaldo(double valor) {
        if(!contaEstaAtiva()) {
            return false;
        }
        if(!valorValido(valor)) {
            return false;
        }
        if(valor > limite) {
            System.out.println("R$ " +valor +" esta acima do limite da conta");
            return false;
        }
        if(getSaldo() < valor) {
            System.out.println("Nao tem saldo o suficiente!");
            return false;
        }
        return true;
    }

    protected void adicionarSaldo(double valor) {
        saldo += valor;
    }
    protected void removerSaldo(double valor) {
        saldo -= valor;
    }
    
}
