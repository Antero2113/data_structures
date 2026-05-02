package Queue_array;

public class Queue {
	private Element[] array; // массив очереди
	private int front; // начало очереди
	private int rear; // конец очереди
	private int first_free;
	
	public Queue()
	{
		array = new Element[100];
		front = 0;
		rear = 5;
		first_free = 0;
	}
	
	public void EnQueque (int x) // помещает в конец очереди значение х
	{
		if (first_free <= rear)
		{
			array[first_free] = new Element(x);
			first_free++;
		}
	}
	
	public int DeQueque() // извлекает из начала очереди значение и возвращет его в качетсве результата
	{
		if (array[front] == null)
		{
			throw new QueueException("Очередь пуста, невозможно вернуть начало");
		}
		else
		{
			int result = new Element(array[front]).value;
			front++;
			rear++;
			return result;
		}
	}
	
	public int Front() // возвращает копию значения начала очереди
	{
		if (array[front] == null)
		{
			throw new QueueException("Очередь пуста, невозможно вернуть начало");
		}
		else
		{
			int result = new Element(array[front]).value;
			return result;
		}
		
	}
	
	public boolean Full() // возвращает истину, если очередь полная (ограниченная очередь), иначе ложь
	{
		if (first_free > rear) return true;
		else return false;
	}
	
	public boolean Empty() // возвращает истину, если очередь пустая, иначе ложь
	{
		if (first_free == front) return true;
		else return false;
	}
	
	public void MakeNull() // делает очередь пустой
	{
		first_free = front;
	}
	
	public void PrintQueue()
	{
		System.out.println("ВЫВОД ОЧЕРЕДИ");
		for (int i = front; (i <= rear && i < first_free); i++)
		{
			System.out.print(array[i].value);
		}
		System.out.println("\n");
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
