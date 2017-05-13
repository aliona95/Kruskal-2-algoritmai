
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
        	if (grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiNuoKur().gautiZyme() != 
        	    grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiIkiKur().gautiZyme()){
        		
        		karkasas.pridetiBriauna(grafas.gautiBriaunas().get(briaunuSkaitliukas));
        		
        		if (Integer.valueOf(grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiNuoKur().gautiZyme()) < 
        		    Integer.valueOf(grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiIkiKur().gautiZyme())){
        			
        			for (int i = 0; i < grafas.gautiVirsunes().length; i++){
        				if (Integer.valueOf(grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiIkiKur().gautiZyme()) == 
        				    Integer.valueOf(grafas.gautiVirsunes()[i].gautiZyme())){
        					
        					grafas.gautiVirsunes()[i].uzsetintiZyme(grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiNuoKur().gautiZyme());
        				}
        			}
        			grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiIkiKur().uzsetintiZyme(grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiNuoKur().gautiZyme());
        		}else{
        			for (int i = 0; i < grafas.gautiVirsunes().length; i++){
        				if (Integer.valueOf(grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiNuoKur().gautiZyme()) == 
        				    Integer.valueOf(grafas.gautiVirsunes()[i].gautiZyme())){
        					
        					grafas.gautiVirsunes()[i].uzsetintiZyme(grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiIkiKur().gautiZyme());
        				}
        			}
        			
        			grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiNuoKur().uzsetintiZyme(grafas.gautiBriaunas().get(briaunuSkaitliukas).gautiIkiKur().gautiZyme());
        		}
        	}
        	briaunuSkaitliukas++;
        }
        return karkasas;
    }
    
}
