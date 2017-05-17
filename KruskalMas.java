
import java.util.Collections;
public class KruskalMas {
	static int briaunuSkaitliukas = 0;
	static boolean arPaimti = false;
	
    public static GrafasMas gautiMST(GrafasMas grafas) {
    	GrafasMas karkasas = new GrafasMas();   
    	int n = grafas.gautiVirsunes().length;
       
        karkasas.uzsetintiVirsunes(grafas.gautiVirsunes());
       
        // surikiuojame briaunas ju svoriu didejimo tvarka
        Collections.sort(grafas.gautiBriaunas());
        
        // vykdome kol briaunu skaicius nebus vienetu mazesnis uz virsuniu skaiciu
        while (karkasas.gautiBriaunas().size() != n - 1){
        	arPaimti = false;
        	// x virsunes zyme, tai briaunos(x, y) pirmoji virsune
        	if (grafas.gautiZymeX() != grafas.gautiZymeY()){
        		arPaimti = true;
        		
        		Briauna briauna;
        		briauna = grafas.gautiBriauna();
        		karkasas.pridetiBriauna(briauna);
        		
        		// tikriname ar briaunos pirmos virsunes zyme mazesne
        		
        		if (xZymeMazesne(grafas)){
        			
        			// pereiname per visas virsunes ir priskiriame naujas zymes 
        			for (int i = 0; i < n; i++){
        				// keiciame visas senas sutapusias zymes i naujai priskirtas
        				if (zymesSutapoSuY(grafas, i)){
        					int zyme = Integer.valueOf(grafas.gautiVirsunes()[i].gautiZyme());
        					for (int j = 0; j < n; j++){
        						if (Integer.valueOf(grafas.gautiVirsunes()[j].gautiZyme()) == zyme){
        							grafas.gautiVirsunes()[j].uzsetintiZyme(grafas.gautiZymeX());
        						}
        					}
        				}
        			}
        			grafas.gautiVirsuneY().uzsetintiZyme(grafas.gautiZymeX());
        		}else{
        			for (int i = 0; i < n; i++){
        				if (zymesSutapoSuX(grafas, i)){
        					int zyme = Integer.valueOf(grafas.gautiVirsunes()[i].gautiZyme());
        					for (int j = 0; j < n; j++){
        						if (Integer.valueOf(grafas.gautiVirsunes()[j].gautiZyme()) == zyme){
        							grafas.gautiVirsunes()[j].uzsetintiZyme(grafas.gautiZymeX());
        						}
        					}
        				}
        			}
        			
        			grafas.gautiVirsuneX().uzsetintiZyme(grafas.gautiZymeY());
        		}
        	}
        	if(Main.argsNum == 1){
        		System.out.println(grafas.spausdintiLentele());
        	}
        	briaunuSkaitliukas++;
        }
        return karkasas;
    }
    
    public static boolean xZymeMazesne(GrafasMas grafas){
    	return Integer.valueOf(grafas.gautiZymeX()) < Integer.valueOf(grafas.gautiZymeY());
    }
    
    public static boolean zymesSutapoSuY(GrafasMas grafas, int i){
    	return Integer.valueOf(grafas.gautiZymeY()) == 
    		   Integer.valueOf(grafas.gautiVirsunes()[i].gautiZyme());
    }
    
    public static boolean zymesSutapoSuX(GrafasMas grafas, int i){
    	return Integer.valueOf(grafas.gautiZymeX()) == 
    		   Integer.valueOf(grafas.gautiVirsunes()[i].gautiZyme());
    }
    
}
