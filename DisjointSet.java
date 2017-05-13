import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DisjointSet<T> {
	
	private static class Virsune<T> {
		int rangas;
		T tevas;

		Virsune(T tevas, int rangas) {
			this.tevas = tevas;
			this.rangas = rangas;
		}
	}

	private final HashMap<T, Virsune<T>> objectsToNodes = new HashMap<>();
	
	// findSet(virsuneX) - f-ja surandanti kuriai aibei priklauso virsuneX
	public T findSet(Object o) {
		DisjointSet.Virsune<T> node = objectsToNodes.get(o);
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

	// o - vertex???
	// makeSet funkcija visoms virsunems priskiria save kaip teva (rodykle i save).
	public void makeSet(T o) {
		objectsToNodes.put(o, new Virsune<>(o, 0));   // 0 yra rangas
	}
	
	public void union(T virsuneX, T virsuneY) {
		// findSet(virsuneX) - f-ja surandanti kuriai aibei priklauso virsuneX
		T aibeVirsunesX = findSet(virsuneX);
		T aibeVirsunesY = findSet(virsuneY);
		// virsunes negali buti sujungtos briauna, jei jos yra is tos pacios aibes
		if (aibeVirsunesX == null || aibeVirsunesY == null || aibeVirsunesX == aibeVirsunesY) {
			return;
		}
		Virsune<T> mazgasX = objectsToNodes.get(aibeVirsunesX);
		Virsune<T> mazgasY = objectsToNodes.get(aibeVirsunesY);
	    
		// tevu tampa tas tevas, kurio rangas didesnis
		if (mazgasX.rangas > mazgasY.rangas) {
			mazgasY.tevas = virsuneX;
		} else {
			mazgasX.tevas = virsuneY;
			// jei aibiu rangai sutampa, tada rangas padidinamas vienetu
			if (mazgasX.rangas == mazgasY.rangas) {
				mazgasY.rangas++;
			}
		}
	}
}