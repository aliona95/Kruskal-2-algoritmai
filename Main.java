import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static int n;
	static int m = 0;
	static String filename = "";
	static int argsNum = 0;
	
    public static void main(String[] args) throws Exception {
    	double time = 0;
    	BufferedReader br = null;
		FileReader fr = null;
		
		Grafas grafas = new Grafas();
    	
		try {

			if(args.length == 1){
				filename = "file.txt";
			}else{
				PrintWriter writer = new PrintWriter("test.txt", "UTF-8");
				Random random = new Random();
				Scanner sc = new Scanner(System.in);
				System.out.println("Iveskite n");
				n = sc.nextInt();
		        writer.println(n);
		        System.out.println("Iveskite m");
		        m = sc.nextInt();
		        if(sc != null)
					sc.close();
		        writer.println(m);
		        if(n > m){
		        	throw new Exception("Per mazas briaunu skaicius");
		        }
		        writer.println("VIRSUNES");
		        for(int i = 0; i < n; i++){
		        	writer.print((i + 1) + " ");
		        }
		        writer.println();
		        writer.println("BRIAUNOS IR JU SVORIAI");
		        Random random1 = new Random();
		        
		        for (int j = 1; j <= (m / n); j++){
	                for (int i = 1; i <= n; i++) {
	                	int randNum = random1.nextInt((n - 1) + 1);
	                	while(randNum == i || randNum == 0){
	                		randNum = random1.nextInt((n - 1) + 1);
	                	}
	                    writer.println("(" + i + ", " + randNum + ", " + random.nextInt(100) + ")");
	                }
		        }
		        writer.close();
				filename = "test.txt";
			}
			fr = new FileReader(filename);
			br = new BufferedReader(fr);

			String dabEilute = "";
			String buvEilute = "";
			br = new BufferedReader(new FileReader(filename));
			if(filename.equals("file.txt")){
				n = Integer.valueOf(br.readLine());
				m = Integer.valueOf(br.readLine());
			}
			GrafasMas grafasMas = new GrafasMas();
			time = System.currentTimeMillis();
			while ((dabEilute = br.readLine()) != null) {
				if (buvEilute.equals("VIRSUNES")){
					String[] virsunes = dabEilute.split(" ");
					for (int i = 0; i < virsunes.length; i++){   
						if(args[0].equals("1") || args[0].equals("3")){
							grafasMas.pridetiVirsune(i, new Virsune(virsunes[i]));
						}
						if (args[0].equals("2") || args[0].equals("3")){
							grafas.pridetiVirsune(new Virsune(virsunes[i]));
						}
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
						if(args[0].equals("1") || args[0].equals("3")){
							for (int i = 0; i < grafasMas.gautiVirsuniuSk(); i++){
								if (grafasMas.gautiVirsune(i).gautiVarda().equals(duom[0])){
									x = grafasMas.gautiVirsunes()[i];
								}
								if (grafasMas.gautiVirsune(i).gautiVarda().equals(duom[1])){
									y = grafasMas.gautiVirsunes()[i];
								}
							}
							grafasMas.pridetiBriauna(new Briauna(x, y, Integer.parseInt(duom[2])));	
						}
						if(args[0].equals("2") || args[0].equals("3")){
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
			if(args[0].equals("1") || args[0].equals("3")){
		        System.out.println("PRADINIS GRAFAS: ");
		        System.out.println(grafasMas);
		        System.out.println();
		        System.out.println("______________________________________________");
		        System.out.println("ALGORITMAS SU VIRSUNIU ZYMEMIS: ");
		        System.out.println();
		        if(args.length == 1){
			        System.out.println(grafasMas.lentelesAntraste());
			        System.out.println(grafasMas.spausdintiInit());
			        GrafasMas karkasas1 = KruskalMas.gautiMST(grafasMas);
			        System.out.println(karkasas1);
		        }else{
		        	argsNum = args.length;
		        	GrafasMas karkasas1 = KruskalMas.gautiMST(grafasMas);
			        System.out.println(karkasas1.toString1());
		        }
		        //System.out.println("MST svoris = " + GrafasMas.atstumas);
		        System.out.println();
	        // b punktas
			}   
			if(args[0].equals("2") || args[0].equals("3")){
				System.out.println("PRADINIS GRAFAS: ");
		        System.out.println(grafas.toString1());
		        System.out.println();
		        System.out.println("______________________________________________");
		        System.out.println("ALGORITMAS SU SARASAIS: ");
		        System.out.println();
		        Grafas karkasas2 = Kruskal.gautiMST(grafas);
		        System.out.println(karkasas2);
			}
	        
		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
				System.out.println("Vykdymo laikas: " + (System.currentTimeMillis() - time) + " ms");
			} catch (IOException ex) {
				ex.printStackTrace();

			}

		}
   
    }
}
