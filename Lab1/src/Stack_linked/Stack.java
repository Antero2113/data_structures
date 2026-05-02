package Stack_linked;

//Стек на связном списке
public class Stack {
	private Element head; // Начало связного списка
	
	// Конструктор списка - задаём нулевое значение голове связного списка
	public Stack()
	{
		head = null;
	}
	
	public void MAKENULL() //делает стек пустым
	{
		// Голова пустая
		head = null;
	}
	
	private Element searchLast()
	{
		Element e = head;
		Element prev = null; // Последний занятый
		while(e != null)
		{
			prev = e;
			e = e.next;
		}
		return prev;
	}
	
	private Element searchPreLast()
	{
		Element e = head;
		Element prev = null; // Последний занятый
		while(e.next != null)
		{
			prev = e;
			e = e.next;
		}
		return prev;
	}
	
	public int TOP() //возвращает элемент (копия) из вершины стека S
	{
		// Если стек пустой
		// FULL и EMPTY проверять в main или здесь?
		if (head == null) throw new StackException("Стек пуст, невозможно вернуть значение вершины");
		// Общий случай
		// Находим последний занятый элемент с помощью метода searchLast
		Element last_elem = searchLast();
		// Возвращаем из найденного элемента значение value
		return last_elem.value;
	}
	public int POP() //удаляет элемент из вершины стека S, и возвращает его в качестве результатата
	{
		// Если стек пустой
		// FULL и EMPTY проверять в main или здесь?
		if (head == null) throw new StackException("Стек пуст, невозможно вернуть значение вершины");

		// Общий случай
		// Находим последний занятый элемент с помощью метода searchLast
		Element last_elem = searchLast();
		
		if (head == last_elem)
		{
			head = null;
		}
		else
		{
			// Ищем предпоследний элемент
			Element prev = searchPreLast(); 
			// Удаляем элемент из вершины
			prev.next = null;
		}
		// Возвращаем из удалённого элемента значение value
		return last_elem.value;
	}
	
	public void PUSH(int x) //вставляет элемент x в вершину стека S
	{
		Element new_elem = new Element(x, null);
		if (head == null)
		{
			head = new_elem;
		}
		else
		{
			Element last_elem = searchLast();
			last_elem.next = new_elem;
			// Находим последний занятый элемент с помощью метода searchLast()
			// Создаём новый элемент с переданным значением
			// Записываем
		}
	}
	
	public boolean EMPTY() //возвращает значение true, если стек S пустой, и значение false в противном случае
	{
	    // Если голова пустая, возвращаем true
		if (head == null) return true;
		// Иначе false
		else return false;
	}
	
	public boolean FULL() //возвращает значение false всегда, так как стек не ограничен
	{
		return false;
	}
	
	public void PrintStack()
	{
		System.out.println("ВЫВОД СТЕКА: ");
		Element e = head;
		while(e != null)
		{
			System.out.print(e.value);
			e = e.next;
		}
		System.out.println("");
		System.out.println("");
	}

}


//класс исключения
class StackException extends RuntimeException{		
String ms;

	 public StackException(String ms) {
this.ms = ms;		
	 }

public String toString(){
return ms;
}
}
