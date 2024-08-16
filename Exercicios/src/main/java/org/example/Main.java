package org.example;

import org.example.utils.Arredondar;
import org.example.utils.Contas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Contas contas = new Contas();
        Arredondar ar = new Arredondar();

        double salarioMinimo = contas.getSalarioMinimo();
        double qtdQuilowatt = contas.getQtdQuilowatt();

        double valorEmReaisDeCada100Quilowatt = contas.valorEmReaisDeCada100Quilowatt(salarioMinimo, qtdQuilowatt);
        double valorDeCadaQuilowatt = contas.valorEmReaisDeCadaQuilowatt(valorEmReaisDeCada100Quilowatt, qtdQuilowatt);

        System.out.println("O valor de cada Quilowatt é: " + ar.arredondar(valorDeCadaQuilowatt));

        double valorASerPago = contas.valorASerPago(valorEmReaisDeCada100Quilowatt, qtdQuilowatt);

        System.out.println("O valor de total é: " + ar.arredondar(valorASerPago));

        double valorComDesconto = contas.novoValorComDesconto(valorASerPago);

        System.out.println("O valor com desconto é: " + ar.arredondar(valorComDesconto));

    }


}

