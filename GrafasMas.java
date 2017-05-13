import java.util.ArrayList;
import java.util.List;

public class GrafasMas {
	private Virsune[] virsunes = new Virsune[Main.n];
	private List<Briauna> briaunos = new ArrayList<Briauna>();
	
	
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
        String v = "Virsunes: {";
        String briaunos = "Briaunos: {";

        for(int i = 0; i < virsunes.length; i++){
        	v += Integer.toString(i + 1) + ", ";
        }
        v += "}";

        for (Briauna e :this.briaunos) {
            briaunos += "{" + e.gautiX().gautiVarda() + ", " + e.gautiY().gautiVarda() + "}, ";
        }
        briaunos += "}";

        return v + "\n" + briaunos;
    }
	
	
}
