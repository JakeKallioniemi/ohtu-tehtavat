package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends Peli {

    public KPSPelaajaVsPelaaja(Scanner scanner, Tuomari tuomari) {
        super(scanner, tuomari);
    }

    @Override
    protected String[] siirrot() {
        String[] siirrot = new String[2];
        System.out.print("Ensimmäisen pelaajan siirto: ");
        siirrot[0] = scanner.nextLine();
        System.out.print("Toisen pelaajan siirto: ");
        siirrot[1] = scanner.nextLine();
        return siirrot;
    }

}
