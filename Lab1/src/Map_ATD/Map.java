package Map_ATD;

//import Array.*;
import Linked.*;

public class Map {
	private List list;
	
	public Map()
	{
		list = new List();
	}
	
	public void MakeNull() // делает отображение M пустым
	{
		list.MakeNull();
	}
	
	public void Assign(int d, int r) // делает M(d) равным r независимо от того, как M(d) было определено ранее
	{
		
	}
	
	public boolean Compute(int d, Link_value r) // возвращает значение true и присваивает переменной r значение M(d), если последнее определено, 
	                                     // возвращает false в противном случае.
	{
		
	}
	
	public void PrintMap()
	{
		System.out.println("ВЫВОД ОТОБРАЖЕНИЯ: ");
		list.PrintList();
	}
}
