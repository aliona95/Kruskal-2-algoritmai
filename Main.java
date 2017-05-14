import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	static int n = 4;
	static int m = 6;
	static String filename = "file.txt";
	
    public static void main(String[] args) {
    	BufferedReader br = null;
		FileReader fr = null;
		
		Grafas grafas = new Grafas();
    	GrafasMas grafasMas = new GrafasMas();
    	
		try {

			fr = new FileReader(filename);
			br = new BufferedReader(fr);

			String dabEilute = "";
			String buvEilute = "";
			br = new BufferedReader(new FileReader(filename));

			while ((dabEilute = br.readLine()) != null) {
				if (buvEilute.equals("VIRSUNES")){
					String[] virsunes = dabEilute.split(" ");
					for (int i = 0; i < virsunes.length; i++){   
						grafasMas.pridetiVirsune(i, new Virsune(virsunes[i]));
						grafas.pridetiVirsune(new Virsune(virsunes[i]));
					}
					buvEilute = "";
				}
				if(dabEilute.startsWith("BRIAUNOS")){
					while ((dabEilute = br.readLine()) != null){
						String briauna = "";
						briauna = dabEilute.substring(1, dabEilute.length() - 1);
						String[] duom = briauna.split(", ");
						Virsune x = null;
						Virsune y = null;
						
						for (int i = 0; i < grafasMas.gautiVirsuniuSk(); i++){
							if (grafasMas.gautiVirsune(i).gautiVarda().equals(duom[0])){
								x = grafasMas.gautiVirsunes()[i];
							}
							if (grafasMas.gautiVirsune(i).gautiVarda().equals(duom[1])){
								y = grafasMas.gautiVirsunes()[i];
							}
						}
						grafasMas.pridetiBriauna(new Briauna(x, y, Integer.parseInt(duom[2])));	
						for (int i = 0; i < grafas.gautiVirsunes().size(); i++){
							if(grafas.gautiVirsunes().get(i).gautiVarda().equals(duom[0])){
								x = grafas.gautiVirsunes().get(i);
							}
							if(grafas.gautiVirsunes().get(i).gautiVarda().equals(duom[1])){
								y = grafas.gautiVirsunes().get(i);
							}
						}
						grafas.pridetiBriauna(new Briauna(x, y, Integer.parseInt(duom[2])));
					}
					break;
				}
				if (dabEilute.equals("VIRSUNES")){
					buvEilute = dabEilute;
				}
				if (dabEilute.startsWith("BRIAUNOS")){
					buvEilute = dabEilute;
				}
			}

	    	/*
	        
	    	// virsuniu zymiu iniciavimas
	        Virsune vertex1 = new Virsune("1"); // "1" - label
	        Virsune vertex2 = new Virsune("2");
	        Virsune vertex3 = new Virsune("3");
	        Virsune vertex4 = new Virsune("4");
	  
	        
	        Briauna edge12 = new Briauna(vertex1, vertex2, 2);
	        //Briauna edge23 = new Briauna(vertex2, vertex3, 4);
	        Briauna edge34 = new Briauna(vertex3, vertex4, 8);
	        Briauna edge41 = new Briauna(vertex4, vertex1, 5);
	        //Briauna edge13 = new Briauna(vertex1, vertex3, 3);
	        Briauna edge24 = new Briauna(vertex2, vertex4, 7);
	
	        ///
	        graphMas.pridetiVirsune(0, vertex1);
	        graphMas.pridetiVirsune(1, vertex2);
	        graphMas.pridetiVirsune(2, vertex3);
	        graphMas.pridetiVirsune(3, vertex4);
	        
	        
	        graphMas.pridetiBriauna(edge12);
	        //graphMas.pridetiBriauna(edge23);
	        graphMas.pridetiBriauna(edge34);
	        graphMas.pridetiBriauna(edge41);
	        //graphMas.pridetiBriauna(edge13);
	        graphMas.pridetiBriauna(edge24);
	        ///
	        //System.out.println(graphArr.toString(1));
	        */
	        System.out.println("PRADINIS GRAFAS: ");
	        System.out.println(grafasMas);
	        System.out.println();
	        System.out.println("______________________________________________");
	        System.out.println("ALGORITMAS SU VIRSUNIU ZYMEMIS: ");
	        System.out.println();
	        System.out.println(grafasMas.lentelesAntraste());
	        System.out.println(grafasMas.spausdintiInit());
	        
	        GrafasMas karkasas1 = KruskalMas.gautiMST(grafasMas);
	        System.out.println(karkasas1);
	        System.out.println("Atstumas = " + GrafasMas.atstumas);
	        System.out.println();
	        System.out.println("______________________________________________");
	        System.out.println("ALGORITMAS SU SARASAIS: ");
	        Grafas karkasas2 = Kruskal.gautiMST(grafas);
	        System.out.println(karkasas2);
	        // b punktas
	        /*grafas.pridetiVirsune(vertex1);
	        grafas.pridetiVirsune(vertex2);
	        grafas.pridetiVirsune(vertex3);
	        grafas.pridetiVirsune(vertex4);
	
	        grafas.pridetiBriauna(edge12);
	        //grafas.pridetiBriauna(edge23);
	        //graph.addEdge(edge34);
	        grafas.pridetiBriauna(edge41);
	        //grafas.pridetiBriauna(edge13);
	        grafas.pridetiBriauna(edge24);
	        //
	
	        Grafas karkasas = Kruskal.gautiMST(grafas);
	
	        */
	        
	        //System.out.println(res);
	        
		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();

			}

		}
   
    }
}
