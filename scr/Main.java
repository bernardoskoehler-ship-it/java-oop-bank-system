public static void main(String[] args) {
    ContaBase[] contas = {
            new ContaPadrao("Leo", 2000, "12345678"),
            new ContaDeluxe("Bernardo", 3000, "87654321")
    };
    contas[0].ativarConta();
    contas[1].ativarConta();

    contas[0].sacar(100);
    contas[0].sacar(1000);
    contas[1].sacar(7500);
    contas[1].depositar(6000);
    contas[0].transferir(10, contas[1]);

    contas[0].mudarSenha();
    contas[1].mudarTitular();

    contas[0].mostrarConta();
    contas[1].mostrarConta();
    contas[0].mostrarHistorico();
    contas[1].mostrarHistorico();
}
