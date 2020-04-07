package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            Peli peli;
            if (vastaus.endsWith("a")) {
                peli = Peli.luoPelaajaVsPelaajaPeli(scanner);
            } else if (vastaus.endsWith("b")) {
                peli = Peli.luoPelaajaVsTekoalyPeli(scanner);
            }  else if (vastaus.endsWith("c")) {
                peli = Peli.luoPelaajaVsParempiTekoalyPeli(scanner);
            } else {
                break;
            }
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            peli.pelaa();
        }

    }
}
