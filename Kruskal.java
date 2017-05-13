import java.util.Collections;

public class Kruskal {
    
    public static Grafas gautiMST(Grafas grafas) {
    	
        Grafas karkasas = new Grafas();
        karkasas.uzsetintiVirsunes(grafas.gautiVirsunes());
    
        DisjointSet<Virsune> vertexDisjointSet = new DisjointSet<Virsune>();
        
        // kiekvienai virsunei uzsetiname teva (ja pacia)
        for (Virsune virsune: grafas.gautiVirsunes()) {
            vertexDisjointSet.makeSet(virsune);
        }
        
        // surikiuojame briaunas ju svoriu didejimo tvarka
        Collections.sort(grafas.gautiBriaunas());

        for (Briauna briauna: grafas.gautiBriaunas()) {
        	// tikriname ar briaunos virsunes yra skirtinguose setuose
            if (vertexDisjointSet.findSet(briauna.gautiNuoKur()) != 
            	vertexDisjointSet.findSet(briauna.gautiIkiKur())) {
            	
                karkasas.pridetiBriauna(briauna);
               
                // sujungiame setus ir uzsetiname setui teva, kurio rangas didesnis
                vertexDisjointSet.union(briauna.gautiNuoKur(), briauna.gautiIkiKur());
            }
        }
        return karkasas;
    }
}
