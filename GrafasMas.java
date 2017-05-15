import java.util.ArrayList;
import java.util.List;

public class GrafasMas {
	private Virsune[] virsunes = new Virsune[Main.n];
	private List<Briauna> briaunos = new ArrayList<Briauna>();
	static int atstumas = 0;
	
	public void pridetiVirsune(int indeksas, Virsune virsune){
		virsunes[indeksas] = virsune;
	}
	
	public void pridetiVirsunes(Virsune[] virsunes){
		this.virsunes = virsunes;
	}
	
	public void pridetiBriauna(Briauna briauna) {
        briaunos.add(briauna);
    }
	
	// seteriai
	public void uzsetintiVirsunes(Virsune[] virsunes){
		this.virsunes = virsunes;
	}
	
	// geteriai
	public Virsune[] gautiVirsunes(){
		return virsunes;
	}
	
	public Virsune gautiVirsune(int indeksas){
		return virsunes[indeksas];
	}
	public List<Briauna> gautiBriaunas() {
        return briaunos;
    }
	
	public Briauna gautiBriauna(){
		int skaitliukas = KruskalMas.briaunuSkaitliukas;
		return this.gautiBriaunas().get(skaitliukas); 
	}
	
	public String gautiZymeX(){
		int skaitliukas = KruskalMas.briaunuSkaitliukas;
		return this.gautiBriaunas().get(skaitliukas).gautiX().gautiZyme();
	}
	
	public String gautiZymeY(){
		int skaitliukas = KruskalMas.briaunuSkaitliukas;
		return this.gautiBriaunas().get(skaitliukas).gautiY().gautiZyme();
	}
	
	public Virsune gautiVirsuneX(){
		int skaitliukas = KruskalMas.briaunuSkaitliukas;
		return this.gautiBriaunas().get(skaitliukas).gautiX();
	}
	
	public Virsune gautiVirsuneY(){
		int skaitliukas = KruskalMas.briaunuSkaitliukas;
		return this.gautiBriaunas().get(skaitliukas).gautiY();
	}
	
	public int gautiVirsuniuSk(){
		return virsunes.length;
	}
	public String toString(int indeksas){
		return virsunes[indeksas].toString();
	}
	
	@Override
    public String toString() {
        String v = "Virsunes: ";
        String b = "MST briaunos: ";

        for(int i = 0; i < virsunes.length; i++){
        	v += Integer.toString(i + 1) + "  ";
        }
        
        for (Briauna briauna: briaunos) {
            b += "(" + briauna.gautiX().gautiVarda() + ", " + briauna.gautiY().gautiVarda() + ")  ";
        }
        
        return v + "\n" + b;
    }
	
	public String toString1() {
        String virsunes = "Virsunes: ";
        String briaunos = "MST briaunos: ";

        for (Virsune virsune : this.virsunes) {
            virsunes += virsune.gautiVarda() + " ";
        }

        for (Briauna briauna : this.briaunos) {
            briaunos += "(" + briauna.gautiX().gautiVarda() + ", " + briauna.gautiY().gautiVarda() + ")  ";
            atstumas += briauna.gautiSvori();
        }
        return virsunes + "\n" + briaunos + "\nMST svoris = " + atstumas;
    }
	
	public int gautiAtstuma(){
		int ats = 0;
		for (Briauna briauna : this.briaunos) {
            ats += briauna.gautiSvori();
        }
		return ats;
	}
	public String lentelesAntraste(){
		String v = "";
		for(int i = 0; i < virsunes.length; i++){
        	v += "L(" + Integer.toString(i + 1) + ") |";
        }
		return "Briauna | svoris | " + v + " Ar paimti?" + "\n" + 
        "-------------------------------------------------------";
	}
	
	public String spausdintiInit(){
		String v = "";
		for(int i = 0; i < virsunes.length; i++){
        	v += Integer.toString(i + 1) + "     ";
		}
		return " init       -       " + v + "   -    ";
	}
	
	public String spausdintiLentele(){
		String zymes = "";
		String virsuneX = this.gautiBriauna().gautiX().gautiVarda();
		String virsuneY = this.gautiBriauna().gautiY().gautiVarda();
		String briauna = "(" + virsuneX + ", " + virsuneY + ")";
		String paimti = "ne";
	
		if(KruskalMas.arPaimti == true){
			paimti = "taip";
			atstumas += this.gautiBriauna().gautiSvori();
		}
		
		for(int i = 0; i < virsunes.length; i++){
        	zymes += virsunes[i].gautiZyme() + "     ";
        }
		return "-------------------------------------------------------" + 
        "\n " + briauna + "     " + this.gautiBriauna().gautiSvori() + "       " +
		zymes + " " + paimti +"\n";
	}
	
	
}
