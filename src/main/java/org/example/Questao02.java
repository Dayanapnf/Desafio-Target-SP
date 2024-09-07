package org.example;

import java.util.Scanner;

public class Questao02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe uma Palavra:");
        String palavra = scanner.nextLine();

        // Remove todas as ocorrências de 'a' e 'A' da string
        String modifiedPalvra = palavra.replaceAll("[aA]", "");

        // Calcula a diferença no comprimento das strings
        int count = palavra.length() - modifiedPalvra.length();

        System.out.println("A letra 'a' aparece " + count + " vezes na palavra:" + palavra);
    }
}
