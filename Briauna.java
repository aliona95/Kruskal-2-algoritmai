
public class Briauna implements Comparable<Briauna> {
	// briaunos galai
    private Virsune x;  
    private Virsune y;
    private int svoris;

    public Briauna(Virsune nuoKur, Virsune ikiKur, int svoris) {
        this.x = nuoKur;
        this.y = ikiKur;
        this.svoris = svoris;
    }

    public Virsune gautiX() {
        return x;
    }

    public Virsune gautiY() {
        return y;
    }

    public int gautiSvori() {
        return svoris;
    }

    @Override
    public int compareTo(Briauna briauna) {
        return this.svoris - briauna.gautiSvori();
    }
     
    public String toString(){
    	return x.toString() + y.toString();
    }
}
