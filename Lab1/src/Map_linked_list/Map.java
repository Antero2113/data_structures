package Map_linked_list;

import Stack_linked.Element;

public class Map {
	ElementM head;
	
	public Map()
	{
		// При создании списка голова пустая
		head = null;
	}
	
	public void MakeNull() // делает отображение M пустым
	{
		head = null;
	}
	
	private ElementM search(int d) {
		ElementM e = head;
		while(e != null)
		{
			if (e.key == d) return e;
			e = e.next;
		}
		return null;
	}
	
	private ElementM last()
	{
		ElementM e = head;
		ElementM prev = null; // Последний занятый
		while(e != null)
		{
			prev = e;
			e = e.next;
		}
		return prev;
	}
	
	public void Assign(int d, int r) // делает M(d) равным r независимо от того, как M(d) было определено ранее
	{
		// Если список пустой, записываем новый элемент в head
		if (head == null) 
		{
			head = new ElementM(d, r, null);
		}
		// Если список непустой, проходимся по всем элементам и либо возвращаем ссылку на элемент с тем же ключом, либо указываем на необходимость добавления новой пары
		else
		{
			ElementM founded = search(d);
			if (founded == null) 
			{
				ElementM end = last();
				end.next = new ElementM(d, r, null);
			}
			else
			{
				founded.value = r;
			}		
		}
	}
	
	public boolean Compute(int d, Link_value r) // возвращает значение true и присваивает переменной r значение M(d), если последнее определено, 
	                                     // возвращает false в противном случае.
	{
		// Если существует элемент (search по ключу, возвращает ссылку на элемент), r = elem.value и возвращаем true
		ElementM founded = search(d);
		if (founded !=  null)
		{
			r.i = founded.value;
			return true;
		}
		// Иначе return false;
		else return false;
	}
	
	public void PrintMap()
	{
		System.out.println("ВЫВОД ОТОБРАЖЕНИЯ: ");
		ElementM e = head;
		while(e != null)
		{
			System.out.println("( key: " + e.key + ", value: " + e.value + ")");
			e = e.next;
		}
		System.out.println("");
	}
}
