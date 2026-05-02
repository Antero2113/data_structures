package Stack_ATD;

//import Array.*;
import Linked.*;

//Стек на АТД «Список»
public class Stack {
	private List list; // Начало связного списка
	
	// Конструктор списка - задаём нулевое значение голове связного списка
	public Stack()
	{
		list = new List();
	}
	
	public void MAKENULL() //делает стек пустым
	{
		list.MakeNull();
	}
	
	
	public Element TOP() //возвращает элемент (копия) из вершины стека S
	{
		if ( list.First() != list.End()) return list.Retrieve(list.Previous(list.End()));
		else return null;
	}
	public Element POP() //удаляет элемент из вершины стека S, и возвращает его в качестве результатата
	{
		if ( list.First() != list.End())
		{
		    Element p = list.Retrieve(list.Previous(list.End()));
		    //Post p = list.Retrieve(list.Previous(list.End()));
		    list.Delete(list.Previous(list.End()));
		    // Возвращаем из удалённого элемента значение value
		    return p;
		}
		else return null;
	}
	
	public void PUSH(int x) //вставляет элемент x в вершину стека S
	{
		list.Insert(new Post("" + x, ""), list.End());
	}
	
	public boolean EMPTY() //возвращает значение true, если стек S пустой, и значение false в противном случае
	{
	    // Если голова пустая, возвращаем true
		if (list.First() == null) return true;
		// Иначе false
		else return false;
	}
	
	public boolean FULL() //возвращает значение false всегда, так как атд не ограничен
	{
		return false;
	}
	
	public void PrintStack()
	{
		System.out.println("ВЫВОД СТЕКА: ");
		list.PrintList();
	}

}
