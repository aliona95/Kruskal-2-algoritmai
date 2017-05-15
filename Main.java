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
			// a punktas
	        System.out.println("PRADINIS GRAFAS: ");
	        System.out.println(grafasMas);
	        System.out.println();
	        System.out.println("______________________________________________");
	        System.out.println("ALGORITMAS SU VIRSUNIU ZYMEMIS: ");
	        System.out.println();
	        System.out.println(grafasMas.lentelesAntraste());
	        System.out.println(grafasMas.spausdintiInit());
	        // b punktas
	        GrafasMas karkasas1 = KruskalMas.gautiMST(grafasMas);
	        System.out.println(karkasas1);
	        System.out.println("Atstumas = " + GrafasMas.atstumas);
	        System.out.println();
	        System.out.println("______________________________________________");
	        System.out.println("ALGORITMAS SU SARASAIS: ");
	        System.out.println();
	        Grafas karkasas2 = Kruskal.gautiMST(grafas);
	        System.out.println(karkasas2);
	        
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
