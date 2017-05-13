
public class Briauna implements Comparable<Briauna> {
	// briaunos galai
    private Virsune nuoKur;  
    private Virsune ikiKur;
    private int svoris;

    public Briauna(Virsune nuoKur, Virsune ikiKur, int svoris) {
        this.nuoKur = nuoKur;
        this.ikiKur = ikiKur;
        this.svoris = svoris;
    }

    public Virsune gautiNuoKur() {
        return nuoKur;
    }

    public Virsune gautiIkiKur() {
        return ikiKur;
    }

    public int gautiSvori() {
        return svoris;
    }

    @Override
    public int compareTo(Briauna briauna) {
        return this.svoris - briauna.gautiSvori();
    }
     
    public String toString(){
    	return nuoKur.toString() + ikiKur.toString();
    }
}
