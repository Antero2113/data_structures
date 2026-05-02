package Queue_ATD;

//import Array.*;
import Linked.*;

public class Queue {
	private List list;
	
	public Queue()
	{
		list = new List();
	}
	
	public void EnQueque (int x) // помещает в конец очереди значение х
	{
		list.Insert(new Post("" + x, ""), list.End());
	}
	
	public Element DeQueque() // извлекает из начала очереди значение и возвращет его в качетсве результата
	{
		Element e = list.Retrieve(list.First());
		//Post e = list.Retrieve(list.First());
		list.Delete(list.First());
		return e;
	}
	
	public Element Front() // возвращает копию значения начала очереди
	{
		return list.Retrieve(list.First());
	}
	
	public boolean Full() 
	{
		return false; // очередь неограниченная
	}
	
	public boolean Empty() // возвращает истину, если очередь пустая, иначе ложь
	{
	    // Если голова пустая, возвращаем true
		if (list.First() == null) return true;
		// Иначе false
		else return false;
	}
	
	public void MakeNull() // делает очередь пустой
	{
		list.MakeNull();
	}
	
	public void PrintQueue()
	{
		System.out.println("ВЫВОД ОЧЕРЕДИ");
		list.PrintList();
	}
	
}
