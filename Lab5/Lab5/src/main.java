
public class main {

	public static void main(String[] args) {

		Set A = new Set();
		A.print("A");
		
		A.Insert(4);
		A.Insert(6);
		A.Insert(7);
		A.Insert(8);
		A.Insert(10);
		A.Insert(16);
		//A.Insert(17);
		A.print("A");
		
		System.out.println("УДАЛЕНИЕ 8");
		A.Delete(8);
		A.print("A");
		
		System.out.println("Новое множество B");
		Set B = new Set();
		B.Insert(5);
		B.Insert(7);
		B.Insert(9);
		B.Insert(10);
		B.Insert(16);
		B.print("B");
		
		System.out.println("ОБЪЕДИНЕНИЕ A и B");
		B.Union(A).print("Union");
        	
		System.out.println("ПРОВЕРКА ПЕРЕСЕЧЕНИЯ A и B: " + A.CheckInterSection(B));
		System.out.println(" ");
		
		System.out.println("ПЕРЕСЕЧЕНИЕ A и B");
		System.out.println(" ");
		A.InterSection(B).print("InterSection");
		
		System.out.println("РАЗНОСТЬ A и B");
		System.out.println(" ");
		A.Difference(B).print("Difference");
		
		System.out.println("Новое множество C");
		Set C = new Set();
		C.Insert(5);
		C.Insert(7);
		C.Insert(9);
		C.Insert(10);
		C.Insert(16);
		C.print("C");
		
		System.out.println("ПРОВЕРКА СОВПАДЕНИЯ B и C: " + B.Equal(C));
		System.out.println(" ");
		
		System.out.println("ПОИСК 4 в A и B");
		B.Find(4, A).print("Find");
		
		System.out.println("ПРОВЕРКА ПРИНАДЛЕЖНОСТИ 9 к B: " + B.Member(9));
		System.out.println(" ");
		
		System.out.println("Новое множество E");
		Set E = new Set();
		E.Insert(6);
		E.Insert(8);
		E.Insert(11);
		E.Insert(17);
		E.print("E");
		
		System.out.println("ОБЪЕДИНЕНИЕ БЕЗ ПЕРЕСЕЧЕНИЯ C и E");
		System.out.println(" ");
		C.print("C");
		E.print("E");
		if (!C.CheckInterSection(E)) C.Merge(E).print("Merge");
	}

}
