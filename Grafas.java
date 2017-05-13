
import java.util.LinkedList;
import java.util.List;

public class Grafas {
    private List<Virsune> virsunes = new LinkedList<Virsune>();
    private List<Briauna> briaunos = new LinkedList<Briauna>();

    
    public void pridetiVirsune(Virsune virsune) {
        virsunes.add(virsune);
    }

    public void pridetiBriauna(Briauna briauna) {
        briaunos.add(briauna);
    }

    public void uzsetintiVirsunes(List<Virsune> virsunes) {
        this.virsunes = virsunes;
    }

    // geteriai
    public List<Virsune> gautiVirsunes() {
        return virsunes;
    }
    
    public List<Briauna> gautiBriaunas() {
        return briaunos;
    }

    @Override
    public String toString() {
        String virsunes = "Virsunes: {";
        String briaunos = "Briaunos: {";

        for (Virsune virsune :this.virsunes) {
            virsunes += virsune.gautiVarda() + ", ";
        }
        virsunes += "}";

        for (Briauna e :this.briaunos) {
            briaunos += "{" + e.gautiNuoKur().gautiVarda() + ", " + e.gautiIkiKur().gautiVarda() + "}, ";
        }
        briaunos += "}";

        return virsunes + "\n" + briaunos;
    }
}
