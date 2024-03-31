/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar = false;

        do {

            String numero1;
            do {
                System.out.println(&quot;\n INTRODUEIX EL NUMERO 1 . &quot;);
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            //double nume1 = Double.parseDouble(numero1);
            double n1 = new Double(numero1);

            do {
                System.out.println(&quot;\n INDICA LA OPERACIÓ QUE VOLS FER
                 (Indica el signe)&quot;);
                System.out.println(&quot; + = sumar \n - = restar \n&quot;
                + &quot; x = multiplicar \n / = dividir \n * = elevar primer num al segon num.&quot;
                + &quot;\n % = residu&quot;); 
                operacion = sc.nextLine();
                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                        || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                        || operacion.equals("*")) {
                    comprobar = true;
                } else {
                    comprobar = false;
                }
            } while (comprobar != true);

            String numero2;
            do {
                System.out.println(&quot;\n INTRODUEIX EL NUMERO 2 . &quot;);
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            //double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2);

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
                            do {
                                System.err.println(&quot; AL DENOMINADOR HI HA UN 0. \n&quot;
                                + &quot; PER A EVITAR ERROR, COLOCA UN ALTRE NÚMERO.&quot;);
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
              //              nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 / n2;
                        break;
                    case "*":
                        res = Math.pow(n1, n2);
                        break;
                    case "%":
                        while (n2 == 0) {
                            do {
                                System.err.println(&quot; AL DENOMINADOR HI HA UN 0. \n&quot;
                                + &quot; PER A EVITAR ERROR, COLOCA UN ALTRE NÚMERO.&quot;);
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                //            nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 % n2;
                        break;
                }
            } while (comprobar != true);

            System.out.println(&quot;RESULTAT : (&quot; + numero1 + &quot;) &quot; + operacion + &quot; (&quot; + numero2 +
            &quot;)&quot; + &quot; = &quot; + res);
            System.out.println(&quot;\n VOLS FER UNA ALTRA OPERACIÓ? \n&quot;);
            System.out.println(&quot; [s/n]&quot;);
            do {
                comprobar = true;
                operacion = sc.nextLine();

                switch (operacion) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println(&quot;\n ERROR. PON UN VALOR VÁLIDO. \n&quot;);
                        comprobar = false;
                }
            } while (comprobar != true);
        } while (operacion.equals("s") || operacion.equals("S"));
    }
}