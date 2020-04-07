package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class Peli {

    protected Scanner scanner;
    protected Tuomari tuomari;

    public Peli(Scanner scanner, Tuomari tuomari) {
        this.scanner = scanner;
        this.tuomari = tuomari;
    }   

    public static Peli luoPelaajaVsPelaajaPeli(Scanner scanner) {
        return new KPSPelaajaVsPelaaja(scanner, new Tuomari());
    }
    
    public static Peli luoPelaajaVsTekoalyPeli(Scanner scanner) {
        return new KPSTekoaly(scanner, new Tuomari(), new TekoalyYksinkertainen());
    }
    
    public static Peli luoPelaajaVsParempiTekoalyPeli(Scanner scanner) {
        return new KPSTekoaly(scanner, new Tuomari(), new TekoalyParannettu(20));
    }
    
    public void pelaa() {
        String[] siirrot = siirrot();
        String ekanSiirto = siirrot[0];
        String tokanSiirto = siirrot[1];

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            siirrot = siirrot();
            ekanSiirto = siirrot[0];
            tokanSiirto = siirrot[1];
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected abstract String[] siirrot();
}
