
public class Virsune {
    private String zyme;
    private String pavadinimas;

    public Virsune(String zyme) {
        this.zyme = zyme;
        this.pavadinimas = zyme;
    }

    // seteriai
    public void uzsetintiVarda(String vardas) {
        this.pavadinimas = vardas;
    }
    
    public void uzsetintiZyme(String zyme) {
        this.zyme = zyme;
    }
    
    // geteriai
    public String gautiVarda() {
        return pavadinimas;
    }
    
    public String gautiZyme() {
        return zyme;
    }

    public String toString(){
    	return pavadinimas;
    }
}
