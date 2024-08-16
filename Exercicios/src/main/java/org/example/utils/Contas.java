package org.example.utils;

import java.util.Scanner;

public class Contas {
    public double getSalarioMinimo () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o salário mínimo: ");

        double salarioMinimo = scanner.nextInt();

        return salarioMinimo;
    }

    public double getQtdQuilowatt () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de quilowatts gasta: ");

        double qtdQuiloWatt = scanner.nextInt();

        return qtdQuiloWatt;
    }

    public double valorEmReaisDeCada100Quilowatt(double salarioMinimo, double qtdQuilowatt) {
        double valor100Qw = salarioMinimo / 7;
        return valor100Qw;
    }

    public double valorEmReaisDeCadaQuilowatt(double valorEmReaisDeCada100Quilowatt, double qtdQuilowatt) {
        double valorDeCadaQuilowatt = valorEmReaisDeCada100Quilowatt / 10;
        return valorDeCadaQuilowatt;
    }

    public double valorASerPago(double valorEmReaisDeCada100Quilowatt, double qtdQuilowatt) {
        double valorASerPago = valorEmReaisDeCada100Quilowatt * qtdQuilowatt;
        return valorASerPago;
    }

    public double novoValorComDesconto(double valorASerPago) {
        double novoValorComDesconto = valorASerPago - (valorASerPago * 0.10);
        return novoValorComDesconto;
    }
}
