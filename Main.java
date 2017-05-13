
public class Main {
	static int n = 4;
	static int m = 6;
	
	
    public static void main(String[] args) {
    	Grafas grafas = new Grafas();
    	GrafasMas graphMas = new GrafasMas();
        
    	// virvuniu zymenu iniciavimas
        Virsune vertex1 = new Virsune("1"); // "1" - label
        Virsune vertex2 = new Virsune("2");
        Virsune vertex3 = new Virsune("3");
        Virsune vertex4 = new Virsune("4");
        // galima is karto zemiau padavinejant kurti edge
        /*Edge edge12 = new Edge(vertex1, vertex2, 2);
        Edge edge23 = new Edge(vertex2, vertex3, 4);
        Edge edge34 = new Edge(vertex3, vertex4, 8);
        Edge edge41 = new Edge(vertex4, vertex1, 5);
        Edge edge13 = new Edge(vertex1, vertex3, 3);
        Edge edge24 = new Edge(vertex2, vertex4, 7);*/
        
        Briauna edge12 = new Briauna(vertex1, vertex2, 2);
        Briauna edge23 = new Briauna(vertex2, vertex3, 4);
        //Edge edge34 = new Edge(vertex3, vertex4, 8);
        Briauna edge41 = new Briauna(vertex4, vertex1, 5);
        Briauna edge13 = new Briauna(vertex1, vertex3, 3);
        Briauna edge24 = new Briauna(vertex2, vertex4, 7);

        ///
        graphMas.pridetiVirsune(0, vertex1);
        graphMas.pridetiVirsune(1, vertex2);
        graphMas.pridetiVirsune(2, vertex3);
        graphMas.pridetiVirsune(3, vertex4);
        
        
        graphMas.pridetiBriauna(edge12);
        graphMas.pridetiBriauna(edge23);
        //graphArr.addEdge(edge34);
        graphMas.pridetiBriauna(edge41);
        graphMas.pridetiBriauna(edge13);
        graphMas.pridetiBriauna(edge24);
        ///
        //System.out.println(graphArr.toString(1));
        GrafasMas res = KruskalMas.gautiMST(graphMas);
        
        
        
        // b punktas
        grafas.pridetiVirsune(vertex1);
        grafas.pridetiVirsune(vertex2);
        grafas.pridetiVirsune(vertex3);
        grafas.pridetiVirsune(vertex4);

        grafas.pridetiBriauna(edge12);
        grafas.pridetiBriauna(edge23);
        //graph.addEdge(edge34);
        grafas.pridetiBriauna(edge41);
        grafas.pridetiBriauna(edge13);
        grafas.pridetiBriauna(edge24);
        //

        //Grafas karkasas = Kruskal.gautiMST(grafas);

        System.out.println("Start: ");
        System.out.println(graphMas);
        System.out.println("Result: ");
        System.out.println(res);
        //System.out.println(karkasas);
    }
}
