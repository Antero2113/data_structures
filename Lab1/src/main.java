//import Array.Position;
//import Array.List;
//import Array.Post;

//import Linked.Position;
//import Linked.List;
//import Linked.Post;

import DoublyLinked.Position;
import DoublyLinked.List;
import DoublyLinked.Post;

//import Cursors.Position;
//import Cursors.List;
//import Cursors.Post;

public class main {

	public static void main(String[] args) {
		
		// Список на массиве
		// Связный список
		// Двусвязный список
		// Список на курсорах
		
		List list = new List();
		Position p = new Position();
		list.Insert(new Post("фбвt", "гдер"), p);
//		p = list.End();
//		list.PrintList();	
//		list.Insert(new Post("фбвdddddddd", "гдер"), p);
//		list.PrintList();
//		p = list.End();
//		list.Insert(new Post("фбвdddddddd", "гдерgggg"), p);
//		list.PrintList();
//		p = list.End();
//		list.Insert(new Post("ВГОЛОВУ", "гдер"), p);
//		list.PrintList();
//		p = list.End();
//		list.Insert(new Post("ccdcssc", "гдер"), p);
//		list.PrintList();
//		p = list.End();
//		list.Insert(new Post("dscdcscc", "гдер"), p);
//		list.PrintList();
//		p = list.Previous(p);
//		//list.search(p).values.print();
//		p = list.Previous(p);
//		//list.search(p).values.print();
//		p = list.Previous(p);
//		//list.search(p).values.print();
//		p = list.Previous(p);
//		//list.search(p).values.print();
//		list.Insert(new Post("ЗАМЕНАВТОРОГО", "гдер"), p);
//		list.PrintList();
//		list.Delete(p);
//		list.PrintList();
//		p = list.End();
//		list.Insert(new Post("ccdcssc", "btttb"), p);
//		list.PrintList();
//		p = list.End();
//		list.Insert(new Post("ccdcssc", "fgbfgbgf"), p);
//		list.PrintList();
//		p = list.End();
//		list.Insert(new Post("ccdcssc", "btttb"), p);
//		list.PrintList();
//		p = list.End();
//		list.Insert(new Post("ccdcssc", "btttb"), p);
//		list.PrintList();
//		p = list.End();
//		list.Insert(new Post("ccdcssc", "гдер"), p);
//		list.PrintList();
//		
//		p = list.First();
//		list.Delete(p);
//		list.PrintList();
//		
//		deleteDuplicates(list);
        
	}
	
	public static void deleteDuplicates(List list) {
	   // в 2 циклах проходим по всем элементам списка с помощью Next
	   // сравниваем объекты Post с помощью Equals
	   // Если находим одинаковые, удаляем с помощью Delete
		
		Position p = list.First();
		System.out.println("УДАЛЕНИЕ ДУПЛИКАТОВ");
		
		while (list.Retrieve(p) != list.Retrieve(list.End())) // Пока позиция после последнего не окажется через один элемент
		{  
			Position pp = p; // Присваиваем второму сравниваемому значению первое для начала итерационного процесса

//			System.out.println("");
//			System.out.println("");
//			System.out.println("Новая итерация ВНЕШНЯЯ:");
			
            
			while(list.Retrieve(pp) != list.Retrieve(list.End()))    
			{ 
				pp = list.Next(pp);
				
				
				
//				System.out.println("");
//				System.out.println("");
//				System.out.println("Новая итерация ВНУТРЕННЯЯ:");		
//				
//				System.out.println("");
//				System.out.print("Текущее первое сравниваемое значение: ");
//	            list.Retrieve(p).values.print();
//	            System.out.println("");
//				System.out.print("Текущее второе сравниваемое значение: ");
//                list.Retrieve(pp).values.print();
                
				
				
				if (list.Retrieve(p).Equals(list.Retrieve(pp)))
				{
					list.Delete(pp);
					pp = list.Previous(pp);
				}
                else
                {
                	System.out.println("");
                	System.out.println("Ничего не удалено");
                	System.out.println("");
                }
				list.PrintList();
			}
			p = list.Next(p);
		}	
	}
}