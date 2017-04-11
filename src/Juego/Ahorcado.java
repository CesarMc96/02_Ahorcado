package Juego;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

    private final Scanner scanner;
    private final Integer numeroRandom;
    private Integer contador;

    public Ahorcado() {
        scanner = new Scanner(System.in);
        String[] listaPalabras = {"programacion", "karim", "computadora", "orientada a objetos", "cesar", "ahorcado"};

        numeroRandom = 1 + new Random().nextInt(listaPalabras.length);

        String palabraEscogida = listaPalabras[numeroRandom];
        System.out.println("Esta palabra tiene " + palabraEscogida.length() + " letras");
        String[] palabra = new String[palabraEscogida.length()];
        imprimirPalabra(palabra);
        int vidas = 15;

        while (true) {
            System.out.println("");    
            System.out.println("");
            System.out.println("*************************************************");
            System.out.println("Escoge una letra");
            String letraElegidaPorUsuario = scanner.nextLine();
            String[] letras = palabraEscogida.split("");
            contador = 0;

            boolean acertoAlguna = false;

            for (String letra : letras) {
                if (letraElegidaPorUsuario.equals(letra)) {
                    palabra[contador] = letraElegidaPorUsuario;
                    acertoAlguna = true;
                }
                contador++;
            }
            
            if (acertoAlguna) {
                System.out.println("Has acertado una palabra");
                System.out.println("Te quedan " + vidas + " vidas");
            } else {
                vidas--;
                System.out.println("No has acertado ninguna palabra");
                if (vidas == 0) {
                    System.out.println("Se te acabaron las vidas, quedas ahorcado x(");
                    break;
                } else {
                    System.out.println("Te quedan " + vidas + " vidas");
                }
            }
            
            System.out.println("Hasta el momento vas: ");
            imprimirPalabra(palabra);
            contador = 0;
            acertoAlguna = false;
            
            if (gano(palabra)) {
                System.out.println("Has completado la palabra");
                break;
            }
        }
    }

    public void imprimirPalabra(String[] palabra) {
        for (String letra : palabra) {
            if (letra != null) {
                System.out.print(letra);
            } else {
                System.out.print("-");
            }
        }
        System.out.println("");
    }

    public boolean gano(String[] palabra) {
        boolean gano = true;

        for (String letra : palabra) {
            if (letra == null) {
                gano = false;
                break;
            }
        }

        return gano;
    }

    public static void main(String[] args) {
        Ahorcado ahorcado = new Ahorcado();
    }
}
