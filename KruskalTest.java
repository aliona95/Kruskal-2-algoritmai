import org.junit.Test;

public class KruskalTest {
    @Test
    public void testGetMinimumumSpanningTreeEmptyResult() throws Exception {
        Grafas graph = new Grafas();
        Grafas minimumSpanningTree = Kruskal.gautiMST(graph);
        
    }
}
