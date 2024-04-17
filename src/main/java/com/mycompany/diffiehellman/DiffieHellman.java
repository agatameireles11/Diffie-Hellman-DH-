/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.diffiehellman;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 *
 * @author agata
 */
public class DiffieHellman {

    private static final BigInteger ONE = BigInteger.ONE;
    private static final SecureRandom random = new SecureRandom();


    public static void main(String[] args) {

        BigInteger p, g, a, b, keyA, keyB, sharedKeyA, sharedKeyB;
        Scanner ler = new Scanner(System.in);
        
        /*
        p = 101333;
        g = 2;
        a = 254;
        b = 555;
        */

        System.out.println("Entre com valor de P: ");
        p = ler.nextBigInteger();

        System.out.println("Entre com valor de G: ");
        g = ler.nextBigInteger();

        System.out.println("Entre com valor da chave privada de A: ");
        a = ler.nextBigInteger();

        System.out.println("Entre com valor da chave privada de B: ");
        b = ler.nextBigInteger();

        //gera as chaves publicas
        keyA = g.modPow(a, p);
        keyB = g.modPow(b, p);

        //Faz a troca
        sharedKeyA = keyB.modPow(a, p);
        sharedKeyB = keyA.modPow(b, p);

        // Verificação se as chaves compartilhadas são iguais
        if (sharedKeyA.equals(sharedKeyB)) {
            System.out.println("Chaves compartilhadas são iguais: " + sharedKeyA);
            System.out.println("P: " + p + "\nG: " + g + "\nChave privada de A: " + a + "\nChave Privada de B: " + b + "\nChave Pública de A: " + keyA + "\nChave Pública de B: " + keyB + "\n");
        } else {
            System.out.println("Erro: Chaves compartilhadas são diferentes: " + sharedKeyA + " e " + sharedKeyB);
            System.out.println("P: " + p + "\nG: " + g + "\nChave privada de A: " + a + "\nChave Privada de B: " + b + "\nChave Pública de A: " + keyA + "\nChave Pública de B: " + keyB + "\n");
        }

    }

}
