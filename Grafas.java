
import java.util.LinkedList;
import java.util.List;

public class Grafas {
    private List<Virsune> virsunes = new LinkedList<Virsune>();
    private List<Briauna> briaunos = new LinkedList<Briauna>();
    static int atstumas = 0;
    
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

    public String toString() {
        String virsunes = "Virsunes: ";
        String briaunos = "MST briaunos: ";

        for (Virsune virsune : this.virsunes) {
            virsunes += virsune.gautiVarda() + " ";
        }

        for (Briauna briauna : this.briaunos) {
            briaunos += "(" + briauna.gautiX().gautiVarda() + ", " + briauna.gautiY().gautiVarda() + ")  ";
            atstumas += briauna.gautiSvori();
        }
        
        return virsunes + "\n" + briaunos + "\nAtstumas = " + atstumas;
    }
}
