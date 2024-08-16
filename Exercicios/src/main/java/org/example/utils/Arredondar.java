package org.example.utils;

import java.text.DecimalFormat;

public class Arredondar {

    public String arredondar(double numero) {
        DecimalFormat df = new DecimalFormat("#.00");
        String numeroArredondado = df.format(numero);
        return numeroArredondado;
    }

}
