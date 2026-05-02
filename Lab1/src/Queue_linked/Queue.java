package Queue_linked;

public class Queue {
	private Element head;
	
	public Queue()
	{
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
	
	public void EnQueque (int x) // помещает в конец очереди значение х
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
	
	public int DeQueque() // извлекает из начала очереди значение и возвращет его в качетсве результата
	{
		if (head == null) throw new QueueException("Очередь пуста, невозможно вернуть начало");
        Element result = new Element(head);
        head = head.next;
        return result.value;
	}
	
	public int Front() // возвращает копию значения начала очереди
	{
		if (head == null) throw new QueueException("Очередь пуста, невозможно вернуть начало");
        return new Element(head).value;
	}
	
	public boolean Full() // возвращает истину, если очередь полная (ограниченная очередь), иначе ложь
	{
		return false; // очередь неограниченная
	}
	
	public boolean Empty() // возвращает истину, если очередь пустая, иначе ложь
	{
		if (head == null) return true;
		else return false;
	}
	
	public void MakeNull() // делает очередь пустой
	{
		head = null;
	}
	
	public void PrintQueue()
	{
		System.out.println("ВЫВОД ОЧЕРЕДИ");
		Element e = head;
		while(e != null)
		{
			System.out.print(e.value);
			e = e.next;
		}
		System.out.println("");
	}

}

//класс исключения
class QueueException extends RuntimeException{		
String ms;

	 public QueueException(String ms) {
 this.ms = ms;		
	 }

public String toString(){
 return ms;
}
}

