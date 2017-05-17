
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
            briaunos += briauna.gautiSvori() +" (" + briauna.gautiX().gautiVarda() + ", " + briauna.gautiY().gautiVarda() + ")  ";
            atstumas += briauna.gautiSvori();
            //System.out.println(briauna.gautiSvori());
        }
        //return virsunes + "\n" + briaunos + "\nMST svoris = " + atstumas;
        return virsunes + "\n" + briaunos + "\n";
    }
    public int gautiAtstuma(){
    	int ats = 0;
    	for (Briauna briauna : this.briaunos) {
            ats += briauna.gautiSvori();
        }
    	return ats;
    }
    public String toString1() {
        String v = "Virsunes: ";
        String b = "MST briaunos: ";

        for(int i = 0; i < virsunes.size(); i++){
        	v += Integer.toString(i + 1) + "  ";
        }
        
        for (Briauna briauna: briaunos) {
            b += "(" + briauna.gautiX().gautiVarda() + ", " + briauna.gautiY().gautiVarda() + ")  ";
        }
        
        return v + "\n" + b;
    }
    
}
