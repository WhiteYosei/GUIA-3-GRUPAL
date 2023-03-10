/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Esta clase representa una clase que evalúa expresiones en notación polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {

    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.
     */
    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();
        for (int i = 0; i < expresion.size(); i = i + 1){
            if (expresion.get(i).equals("+") || expresion.get(i).equals("-") ||
                    expresion.get(i).equals("*") || expresion.get(i).equals("/") ||
                    expresion.get(i).equals("%") || expresion.get(i).equals("^")) {
                int y = pila.pop();
                int x = pila.pop();
                int result = 0;
                if (expresion.get(i).equals("+")){
                    result = y + x;
                } else if (expresion.get(i).equals("-")) {
                    result = y - x;
                } else if (expresion.get(i).equals("*")) {
                    result = y * x;
                } else if (expresion.get(i).equals("/")) {
                    result = y / x;
                } else if (expresion.get(i).equals("%")) {
                    result = y % x;
                } else {
                    result = (int) Math.pow(y, x);
                }
                pila.push(result);
            }
            else {
                pila.push(Integer.parseInt(expresion.get(i)));
            }
        }

        // TODO: Realiza la evaluación de la expresión en formato postfijo

        return pila.pop();
    }

    /**
     * Programa principal
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("> ");
        String linea = teclado.nextLine();

        try {
            List<String> expresion = Token.dividir(linea);
            System.out.println(evaluarPostFija(expresion));
        }
        catch (Exception e) {
            System.err.printf("Error grave en la expresión: %s", e.getMessage());
        }

    }
}
