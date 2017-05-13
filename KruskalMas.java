
import java.util.Collections;
public class KruskalMas {
	static int briaunuSkaitliukas = 0;
    
    public static GrafasMas gautiMST(GrafasMas grafas) {
        GrafasMas karkasas = new GrafasMas();   
        
        karkasas.uzsetintiVirsunes(grafas.gautiVirsunes());
       
        // surikiuojame briaunas ju svoriu didejimo tvarka
        Collections.sort(grafas.gautiBriaunas());
        
        // vykdome kol briaunu skaicius nebus vienetu mazesnis uz virsuniu skaiciu
        while (karkasas.gautiBriaunas().size() != grafas.gautiVirsunes().length - 1){
        	// x virsunes zyme, tai briaunos(x, y) pirmoji virsune
        	if (grafas.gautiZymeX() != grafas.gautiZymeY()){
        		
        		Briauna briauna;
        		briauna = grafas.gautiBriauna();
        		karkasas.pridetiBriauna(briauna);
        		
        		// tikriname ar briaunos pirmos virsunes zyme mazesne
        		
        		if (xZymeMazesne(grafas)){
        			
        			// pereiname per visas virsunes ir priskiriame naujas zymes 
        			for (int i = 0; i < grafas.gautiVirsuniuSk(); i++){
        				
        				// keiciame visas senas sutapusias zymes i naujai priskirtas
        				if (zymesSutapoSuY(grafas, i)){
        					grafas.gautiVirsunes()[i].uzsetintiZyme(grafas.gautiZymeX());
        				}
        			}
        			grafas.gautiVirsuneY().uzsetintiZyme(grafas.gautiZymeX());
        		}else{
        			for (int i = 0; i < grafas.gautiVirsuniuSk(); i++){
        				if (zymesSutapoSuX(grafas, i)){
        					
        					grafas.gautiVirsunes()[i].uzsetintiZyme(grafas.gautiZymeY());
        				}
        			}
        			
        			grafas.gautiVirsuneX().uzsetintiZyme(grafas.gautiZymeY());
        		}
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
