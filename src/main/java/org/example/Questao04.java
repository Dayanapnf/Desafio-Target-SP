/*

Detectado: Progressão Aritmética. Próximo elemento: 9
Detectado: Progressão Geométrica. Próximo elemento: 128
Detectado: Sequência de Quadrados Perfeitos Misto. Próximo elemento: 49
Detectado: Sequência de Quadrados Perfeitos Par. Próximo elemento: 100
Detectado: Sequência de Fibonacci. Próximo elemento: 13
Padrão não detectado.

*/

package org.example;

import java.util.ArrayList;
import java.util.List;

public class Questao04 {

    // Função principal para detectar e estender a sequência fornecida
    public static void detectarEEstenderSequencia(List<Integer> sequencia) {
        // Verifica se a sequência é uma progressão aritmética
        if (isAritmetica(sequencia)) {
            int proximoElemento = proximaAritmetica(sequencia);
            System.out.println("Detectado: Progressão Aritmética. Próximo elemento: " + proximoElemento);
            sequencia.add(proximoElemento);
        }
        // Verifica se a sequência é uma progressão geométrica
        else if (isGeometrica(sequencia)) {
            int proximoElemento = proximaGeometrica(sequencia);
            System.out.println("Detectado: Progressão Geométrica. Próximo elemento: " + proximoElemento);
            sequencia.add(proximoElemento);
        }
        // Verifica se a sequência é de Fibonacci
        else if (isFibonacci(sequencia)) {
            int proximoElemento = proximaFibonacci(sequencia);
            System.out.println("Detectado: Sequência de Fibonacci. Próximo elemento: " + proximoElemento);
            sequencia.add(proximoElemento);
        }
        // Verifica se a sequência é de quadrados perfeitos
        else if (isQuadradoPerfeito(sequencia)) {
            String tipo = identificarTipoQuadradoPerfeito(sequencia);
            int proximoElemento = proximoQuadradoPerfeito(sequencia, tipo);
            System.out.println("Detectado: Sequência de Quadrados Perfeitos " + tipo + ". Próximo elemento: " + proximoElemento);
            sequencia.add(proximoElemento);
        }
        // Se nenhum padrão conhecido for detectado
        else {
            System.out.println("Padrão não detectado.");
        }
    }

    // Verifica se a sequência é uma progressão aritmética
    public static boolean isAritmetica(List<Integer> sequencia) {
        if (sequencia.size() < 2) return false;
        int diferenca = sequencia.get(1) - sequencia.get(0);
        for (int i = 2; i < sequencia.size(); i++) {
            if (sequencia.get(i) - sequencia.get(i - 1) != diferenca) {
                return false;
            }
        }
        return true;
    }

    // Verifica se a sequência é uma progressão geométrica
    public static boolean isGeometrica(List<Integer> sequencia) {
        if (sequencia.size() < 2) return false;
        int primeiro = sequencia.get(0);
        if (primeiro == 0) return false;
        int razao = sequencia.get(1) / primeiro;
        for (int i = 2; i < sequencia.size(); i++) {
            if (sequencia.get(i - 1) == 0 || sequencia.get(i) / sequencia.get(i - 1) != razao) {
                return false;
            }
        }
        return true;
    }

    // Verifica se a sequência é de Fibonacci
    public static boolean isFibonacci(List<Integer> sequencia) {
        if (sequencia.size() < 3) return false;
        for (int i = 2; i < sequencia.size(); i++) {
            if (sequencia.get(i) != sequencia.get(i - 1) + sequencia.get(i - 2)) {
                return false;
            }
        }
        return true;
    }

    // Verifica se a sequência é de quadrados perfeitos
    public static boolean isQuadradoPerfeito(List<Integer> sequencia) {
        if (sequencia.size() < 1) return false;
        for (int num : sequencia) {
            int raiz = (int) Math.sqrt(num);
            if (raiz * raiz != num) {
                return false;
            }
        }
        return true;
    }

    // Identifica o tipo de sequência de quadrados perfeitos: Par, Ímpar ou Misto
    public static String identificarTipoQuadradoPerfeito(List<Integer> sequencia) {
        boolean temPar = false;
        boolean temImpar = false;
        for (int num : sequencia) {
            int raiz = (int) Math.sqrt(num);
            if (raiz % 2 == 0) {
                temPar = true;
            } else {
                temImpar = true;
            }
        }
        if (temPar && temImpar) {
            return "Misto";
        } else if (temPar) {
            return "Par";
        } else if (temImpar) {
            return "Ímpar";
        } else {
            return "Desconhecido";
        }
    }

    // Calcula o próximo número na sequência de quadrados perfeitos baseado no tipo identificado
    public static int proximoQuadradoPerfeito(List<Integer> sequencia, String tipo) {
        int ultimoNumero = sequencia.get(sequencia.size() - 1);
        int raiz = (int) Math.sqrt(ultimoNumero);
        if (tipo.equals("Par")) {
            // Encontrar o próximo quadrado perfeito par
            int proximaRaizPar = raiz + (raiz % 2 == 0 ? 2 : 1);
            return proximaRaizPar * proximaRaizPar;
        } else if (tipo.equals("Ímpar")) {
            // Encontrar o próximo quadrado perfeito ímpar
            int proximaRaizImpar = raiz + (raiz % 2 != 0 ? 2 : 1);
            return proximaRaizImpar * proximaRaizImpar;
        } else if (tipo.equals("Misto")) {
            // Encontrar o próximo quadrado perfeito misto
            int proximaRaiz = raiz + 1;
            while (true) {
                int proximoQuadrado = proximaRaiz * proximaRaiz;
                if (proximoQuadrado > ultimoNumero) {
                    return proximoQuadrado;
                }
                proximaRaiz++;
            }
        }
        return ultimoNumero;
    }

    // Calcula o próximo número em uma progressão aritmética
    public static int proximaAritmetica(List<Integer> sequencia) {
        int diferenca = sequencia.get(1) - sequencia.get(0);
        return sequencia.get(sequencia.size() - 1) + diferenca;
    }

    // Calcula o próximo número em uma progressão geométrica
    public static int proximaGeometrica(List<Integer> sequencia) {
        int primeiro = sequencia.get(0);
        int razao = sequencia.get(1) / primeiro;
        return sequencia.get(sequencia.size() - 1) * razao;
    }

    // Calcula o próximo número na sequência de Fibonacci
    public static int proximaFibonacci(List<Integer> sequencia) {
        int tamanho = sequencia.size();
        return sequencia.get(tamanho - 1) + sequencia.get(tamanho - 2);
    }

    public static void main(String[] args) {
        // Testes com várias sequências para verificação do funcionamento
        List<Integer> sequenciaA = new ArrayList<>(List.of(1, 3, 5, 7));
        detectarEEstenderSequencia(sequenciaA);

        List<Integer> sequenciaB = new ArrayList<>(List.of(2, 4, 8, 16, 32, 64));
        detectarEEstenderSequencia(sequenciaB);

        List<Integer> sequenciaC = new ArrayList<>(List.of(0, 1, 4, 9, 16, 25, 36));
        detectarEEstenderSequencia(sequenciaC);

        List<Integer> sequenciaD = new ArrayList<>(List.of(4, 16, 36, 64));
        detectarEEstenderSequencia(sequenciaD);

        List<Integer> sequenciaE = new ArrayList<>(List.of(1, 1, 2, 3, 5, 8));
        detectarEEstenderSequencia(sequenciaE);

        List<Integer> sequenciaF = new ArrayList<>(List.of(2, 10, 12, 16, 17, 18, 19));
        detectarEEstenderSequencia(sequenciaF);
    }
}
