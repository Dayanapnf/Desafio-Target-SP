package org.example;

import java.util.Scanner;


public class Questao01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Informe um número para verificar se pertence à sequência de Fibonacci: ");
        int number = scanner.nextInt();

        // Verifica se o número pertence à sequência de Fibonacci
        boolean isFibonacci = isFibonacciNumber(number);

        // Imprime o resultado
        if (isFibonacci) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " NÃO pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }

    // Função para verificar se um número é um quadrado perfeito
    public static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }

    // Função para verificar se um número pertence à sequência de Fibonacci
    public static boolean isFibonacciNumber(int n) {
        // Usa o método matemático para determinar se o número é de Fibonacci
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }
}