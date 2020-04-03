package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends LaskuOperaatio {

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    protected int laske(int arvo) {
        sovellus.miinus(arvo);
        return sovellus.tulos();
    }

}
