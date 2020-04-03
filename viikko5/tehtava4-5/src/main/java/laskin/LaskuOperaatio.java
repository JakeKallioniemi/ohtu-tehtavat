package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class LaskuOperaatio extends Komento {

    public LaskuOperaatio(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        edellinenTulos = sovellus.tulos();
        
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        int laskunTulos = laske(arvo);
        
        naytaTulos(laskunTulos);
        vaihdaNollausnapinTila(laskunTulos);
        
        undo.disableProperty().set(false);
    }
    
    protected abstract int laske(int luku);

}
