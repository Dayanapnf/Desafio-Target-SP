
// O VALOR DA VARIAVEL SOMA É 77.

package org.example;

public class Questao03 {
    public static void main(String[] args) {
        int INDICE = 12, SOMA = 0, K = 1;

        // Loop para calcular a soma
        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        System.out.println("O valor de SOMA é: " + SOMA);
    }
}

