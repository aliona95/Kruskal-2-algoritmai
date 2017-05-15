import java.util.HashMap;

public class DisjointSet<Type> {
	
	private static class Mazgas<T> {
		int rangas;
		T tevas;

		Mazgas(T tevas, int rangas) {
			this.tevas = tevas;
			this.rangas = rangas;
		}
	}

	private final HashMap<Type, Mazgas<Type>> mazgai = new HashMap<>();
	
	// makeSet funkcija visoms virsunems priskiria save kaip teva (rodykle i save).
	public void makeSet(Type obj) {
		mazgai.put(obj, new Mazgas<>(obj, 0));   // 0 - pradinis rangas
	}
	
	// findSet(virsuneX) f-ja suranda kuriai aibei priklauso virsuneX
	public Type findSet(Object obj) {
		DisjointSet.Mazgas<Type> node = mazgai.get(obj);
	
		if (obj != node.tevas) {
			node.tevas = findSet(node.tevas);
		}
		return node.tevas;
	}
	
	public void union(Type virsuneX, Type virsuneY) {
		Mazgas<Type> mazgasX = mazgai.get(findSet(virsuneX));
		Mazgas<Type> mazgasY = mazgai.get(findSet(virsuneY));
		
		// tevu tampa tas tevas, kurio rangas didesnis
		if (mazgasX.rangas > mazgasY.rangas){
			mazgasY.tevas = virsuneX;
		} else{
			mazgasX.tevas = virsuneY;
			// jei aibiu rangai sutampa, tada rangas padidinamas vienetu
			if (mazgasX.rangas == mazgasY.rangas) {
				mazgasY.rangas++;
			}
		}
	}
}