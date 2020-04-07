package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends Peli {

    private Tekoaly tekoaly;

    public KPSTekoaly(Scanner scanner, Tuomari tuomari, Tekoaly tekoaly) {
        super(scanner, tuomari);
        this.tekoaly = tekoaly;
    }

    @Override
    protected String[] siirrot() {
        String[] siirrot = new String[2];
        System.out.print("Ensimmäisen pelaajan siirto: ");
        siirrot[0] = scanner.nextLine();
        siirrot[1] = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirrot[1]);
        tekoaly.asetaSiirto(siirrot[0]);
        return siirrot;
    }

}
