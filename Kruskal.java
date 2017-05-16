import java.util.Collections;

public class Kruskal {
    
    public static Grafas gautiMST(Grafas grafas) {
    	
        Grafas karkasas = new Grafas();
        karkasas.uzsetintiVirsunes(grafas.gautiVirsunes());
    
        DisjointSet<Virsune> miskas = new DisjointSet<Virsune>();
        
        // kiekvienai virsunei priskiriame teva (ja pacia)
        for (Virsune virsune: grafas.gautiVirsunes()) {
            miskas.makeSet(virsune);
            
        }
        
        // surikiuojame briaunas ju svoriu didejimo tvarka
        Collections.sort(grafas.gautiBriaunas());

        for (Briauna briauna: grafas.gautiBriaunas()) {
        	// tikriname ar briaunos virsunes yra skirtinguose setuose
            if (miskas.findSet(briauna.gautiX()) != 
            	miskas.findSet(briauna.gautiY())) {
            	
                karkasas.pridetiBriauna(briauna);
               
                // sujungiame setus ir uzsetiname setui teva, kurio rangas didesnis
                miskas.union(briauna.gautiX(), briauna.gautiY());
            }
        }
        return karkasas;
    }
}
