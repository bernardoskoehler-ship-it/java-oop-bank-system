package org.example;

import java.util.Scanner;

public class MenuBanco {
    Scanner scanner = new Scanner(System.in);

    private int idLogado = -1;

    private double lerValor() {
        System.out.println("Insira um valor:");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    public void iniciarBanco() {
        idLogado = -1;

        try {
            Banco banco = new Banco();
            ContaDAO dao = new ContaDAO();

            dao.desativarTodasContas();

            System.out.println("Bem vindo ao Banco BBE (Blumenau Bank Enterprices).");
            System.out.println("Menu:");
            System.out.println("1 - Login");
            System.out.println("2 - Criar Conta");
            System.out.println("----------");
            while(true) {
                int escolha = scanner.nextInt();
                scanner.nextLine();

                if(escolha == 1) {
                    System.out.println("Digite seu id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite sua senha:");
                    String senha = scanner.nextLine();

                    if(banco.banco_AtivarConta(id, senha)) {
                        idLogado = id;
                        System.out.println("Login realizado!");
                        break;
                    }

                    System.out.println("Falha no login.");
                    continue;
                }else if(escolha == 2) {

                    System.out.println("Digite seu nome:");
                    String nome = scanner.nextLine();

                    System.out.println("Digite sua senha:");
                    String senha = scanner.nextLine();

                    if(banco.banco_CriarConta(nome, senha)) {
                        System.out.println("Conta criada!");
                        System.out.println("Agora faça login na sua conta para prosseguir.");
                    }
                    continue;
                }else {
                    continue;
                }
            }

            while(true) {
            System.out.println("----------");
            System.out.println("Menu:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Ver Conta");
            System.out.println("5 - Logout");
            System.out.println("----------");

                int escolha = scanner.nextInt();
                scanner.nextLine();
                 if(escolha == 1 ) {
                     double valor = lerValor();

                     banco.banco_depositar(idLogado, valor);
                     continue;
                 }else if(escolha == 2) {
                     double valor = lerValor();

                     banco.banco_sacar(idLogado, valor);
                     continue;
                 }else if(escolha == 3) {
                     double valor = lerValor();

                     System.out.println("Insira a conta destino:");
                     int idDestino = scanner.nextInt();
                     scanner.nextLine();

                     banco.banco_transferir(idLogado, idDestino, valor);
                     continue;
                 }else if(escolha == 4) {
                     banco.banco_MostrarConta(idLogado);
                 }else if(escolha == 5) {
                     banco.banco_DesativarConta(idLogado);
                     idLogado = -1;
                     break;
                 }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
