package practica1;

import java.util.Scanner;

public class Practica1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar = false;

        do {
            double n1 = obtenerNumero(sc, "\nINTRODUEIX EL PRIMER NUMERO ");
            operacion = obtenerOperacion(sc);
            double n2 = obtenerNumero(sc, "\nINTRODUEIX EL NUMERO 2.");

            do {
                comprobar = true;
                switch (operacion) {
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "x":
                    case "X":
                        res = n1 * n2;
                        break;
                    case "/":
                        while (n2 == 0) {
                            System.err.println("AL DENOMINADOR HI HA UN 0 \nPER EVITAR ERRORS COLOCA ALTRE NUMERO.");
                            n2 = obtenerNumero(sc, "\nINTRODUEIX EL NUMERO 2.");
                        }
                        res = n1 / n2;
                        break;
                    case "*":
                        res = Math.pow(n1, n2);
                        break;
                    case "%":
                        while (n2 == 0) {
                            System.err.println("AL DENOMINADOR HI HA UN 0 \nPER EVITAR ERRORS COLOCA UN ALTRE NUMERO");
                            n2 = obtenerNumero(sc, "\nINTRODUEIX EL NUMERO 2.");
                        }
                        res = n1 % n2;
                        break;
                }
            } while (comprobar != true);

            System.out.println("(" + n1 + ") " + operacion + " (" + n2 + ")" + " = " + res);
            System.out.println("\nVOLS CONTINUAR OPERANT? \n[S/N]");
        } while (operacion.equals("s") || operacion.equals("S"));

        sc.close();
    }

    private static double obtenerNumero(Scanner sc, String mensaje) {
        double numero;
        do {
            System.out.println(mensaje);
            while (!sc.hasNextDouble()) {
                System.out.println("INTRODUEIX UN NUMERO VALID");
                sc.next(); // Consumir entrada inválida
            }
            numero = sc.nextDouble();
        } while (numero == 0); // Puedes ajustar las condiciones de validación según sea necesario
        return numero;
    }

    private static String obtenerOperacion(Scanner sc) {
        String operacion;
        do {
            System.out.println("\nVOLS FER UNA OPERACIÓ? (Indica el signe)");
            System.out.println("+ = SUMAR \n- = RESTAR \nx = MULTIPLICAR \n/ = DIVIDIR \n* = ELEVAR EL NUMERO 1 AL NUMERO 2.\n% = RESIDU");
            operacion = sc.next();
        } while (!operacion.equals("+") && !operacion.equals("-") && !operacion.equals("x") && !operacion.equals("X") && !operacion.equals("/") && !operacion.equals("*") && !operacion.equals("%"));
        return operacion;
    }
}



