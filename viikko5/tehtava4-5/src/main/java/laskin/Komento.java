package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {

    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    protected int edellinenTulos;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.edellinenTulos = 0;
    }

    public abstract void suorita();

    public void peru() {
        sovellus.nollaa();
        sovellus.plus(edellinenTulos);
        int laskunTulos = sovellus.tulos();
        naytaTulos(laskunTulos);
        vaihdaNollausnapinTila(laskunTulos);
        undo.disableProperty().set(true);
    }

    protected void naytaTulos(int tulos) {
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);
    }

    protected void vaihdaNollausnapinTila(int tulos) {
        if (tulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
    }
}
