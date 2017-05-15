import java.util.HashMap;

public class DisjointSet<T> {
	
	private static class InnerVirsune<T> {
		int rangas;
		T tevas;

		InnerVirsune(T tevas, int rangas) {
			this.tevas = tevas;
			this.rangas = rangas;
		}
	}

	private final HashMap<T, InnerVirsune<T>> objectsToNodes = new HashMap<>();
	
	// makeSet funkcija visoms virsunems priskiria save kaip teva (rodykle i save).
	public void makeSet(T o) {
		objectsToNodes.put(o, new InnerVirsune<>(o, 0));   // 0 yra rangas
	}
	
	// findSet(virsuneX) - f-ja surandanti kuriai aibei priklauso virsuneX
	public T findSet(Object o) {
		DisjointSet.InnerVirsune<T> node = objectsToNodes.get(o);
		if (node == null) {
			return null;
		}
		if (o != node.tevas) {
			//System.out.println("REKURSIJA");
			node.tevas = findSet(node.tevas);
		}
		//System.out.println("FIND SET PARENT = " + node.tevas.toString());
		return node.tevas;
	}
	
	public void union(T virsuneX, T virsuneY) {
		// findSet(virsuneX) - f-ja surandanti kuriai aibei priklauso virsuneX
		//T aibeVirsunesX = findSet(virsuneX);
		//T aibeVirsunesY = findSet(virsuneY);
		// virsunes negali buti sujungtos briauna, jei jos yra is tos pacios aibes
		/*if (findSet(virsuneX) == null || findSet(virsuneY) == null || 
			findSet(virsuneX) == findSet(virsuneY)) {
			System.out.println("AAA");
			return;
		}*/
		/*if (aibeVirsunesX == null || aibeVirsunesY == null || aibeVirsunesX == aibeVirsunesY) {
			return;
		}*/
		InnerVirsune<T> mazgasX = objectsToNodes.get(/*aibeVirsunesX*/findSet(virsuneX));
		InnerVirsune<T> mazgasY = objectsToNodes.get(/*aibeVirsunesY*/findSet(virsuneX));
	    
		// tevu tampa tas tevas, kurio rangas didesnis
		/*if (mazgasX.rangas > mazgasY.rangas) {
			mazgasY.tevas = virsuneX;
		} else {
			mazgasX.tevas = virsuneY;
			// jei aibiu rangai sutampa, tada rangas padidinamas vienetu
			if (mazgasX.rangas == mazgasY.rangas) {
				mazgasY.rangas++;
			}
		}
		*/
		if (mazgasX.rangas <= mazgasY.rangas){
			if (mazgasX.rangas == mazgasY.rangas) {
				mazgasY.rangas++;
			}
			mazgasX.tevas = virsuneY;
		} else{
			mazgasY.tevas = virsuneX;
		}
	}
}