package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5;
    public final static int OLETUSKASVATUS = 5;

    private int kasvatuskoko;
    private int[] luvut;
    private int koko;

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IllegalArgumentException("Kapasiteetti ei voi olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IllegalArgumentException("Kasvatuskoko ei voi olla negatiivinen");
        }
        luvut = new int[kapasiteetti];
        koko = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }
        lisaaLuku(luku);
        return true;
    }

    private void lisaaLuku(int luku) {
        luvut[koko] = luku;
        koko++;
        if (koko >= luvut.length) {
            kasvataKapasiteettia();
        }
    }

    private void kasvataKapasiteettia() {
        luvut = Arrays.copyOf(luvut, luvut.length + kasvatuskoko);
    }

    private int luvunIndeksi(int luku) {
        for (int i = 0; i < koko; i++) {
            if (luvut[i] == luku) {
                return i;
            }
        }
        return -1;
    }

    public boolean kuuluu(int luku) {
        return luvunIndeksi(luku) > -1;
    }

    public boolean poista(int luku) {
        int indeksi = luvunIndeksi(luku);
        if (indeksi == -1) {
            return false;
        }
        for (int i = indeksi; i < koko; i++) {
            luvut[i] = luvut[i + 1];
        }
        koko--;
        return true;
    }

    public int mahtavuus() {
        return koko;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < koko; i++) {
            sb.append(luvut[i]);
            if (i < koko - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public int[] toIntArray() {
        return Arrays.copyOf(luvut, koko);
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdiste.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdiste.lisaa(bTaulu[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkaus.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkaus;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotus.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotus.poista(bTaulu[i]);
        }
        return erotus;
    }

}
