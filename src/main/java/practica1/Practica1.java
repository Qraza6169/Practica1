/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

public class Practica1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;

        do {
            String numero1;
            do {
                System.out.println("\nINTRODUEIX EL NUMERO 1: ");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double n1 = Double.parseDouble(numero1);

            do {
                System.out.println("\nINDICA LA OPERACIÓ QUE VOLS FER (Indica el signe)");
                System.out.println("+ = sumar\n- = restar\nx = multiplicar\n/ = dividir\n* = elevar primer num al segon num.\n% = residu");
                operacion = sc.nextLine();
            } while (!operacion.matches("[+\\-xX/*%]"));

            String numero2;
            do {
                System.out.println("\nINTRODUEIX EL NUMERO 2: ");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double n2 = Double.parseDouble(numero2);

            switch (operacion) {
                case "+" -> res = n1 + n2;
                case "-" -> res = n1 - n2;
                case "x", "X" -> res = n1 * n2;
                case "/" -> {
                    while (n2 == 0) {
                        System.err.println("AL DENOMINADOR HI HA UN 0.\nPER A EVITAR ERROR, COLOCA UN ALTRE NÚMERO.");
                        numero2 = sc.nextLine();
                        n2 = Double.parseDouble(numero2);
                    }
                    res = n1 / n2;
                }
                case "*" -> res = Math.pow(n1, n2);
                case "%" -> {
                    while (n2 == 0) {
                        System.err.println("AL DENOMINADOR HI HA UN 0.\nPER A EVITAR ERROR, COLOCA UN ALTRE NÚMERO.");
                        numero2 = sc.nextLine();
                        n2 = Double.parseDouble(numero2);
                    }
                    res = n1 % n2;
                }
            }

            System.out.println("RESULTAT: (" + numero1 + ") " + operacion + " (" + numero2 + ") = " + res);
            System.out.println("\nVOLS FER UNA ALTRA OPERACIÓ?");
            System.out.println("[s/n]");
            do {
                operacion = sc.nextLine();
                if (!operacion.matches("[sSnN]")) {
                    System.err.println("\nERROR. PON UN VALOR VÀLID (s/n).");
                }
            } while (!operacion.matches("[sSnN]"));

        } while (operacion.equalsIgnoreCase("s"));
        sc.close();
    }
}
