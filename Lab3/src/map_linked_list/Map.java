package map_linked_list;

public class Map {
	ElementM head;
	
	public Map()
	{
		
	}
	
	public void MakeNull() // делает отображение M пустым
	{
		head = null;
	}
	
	public void Assign(int d, int r) // делает M(d) равным r независимо от того, как M(d) было определено ранее
	{
		
	}
	
	public boolean Compute(int d, int r) // возвращает значение true и присваивает переменной r значение M(d), если последнее определено, 
	                                     // возвращает false в противном случае.
	{
		// Если существует элемент (search по ключу, возвращает ссылку на элемент), r = elem.value и возвращаем true
		// Иначе return false;
	}
}
