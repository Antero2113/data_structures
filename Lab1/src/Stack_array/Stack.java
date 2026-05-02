package Stack_array;

// Стек на массиве
public class Stack {
	// Создаём массив для реализации стека (какой длины?)
	private Element[] array;
	// Переменная для терминального элемента (первый свободный)
	int first_free;
	
	public Stack()
	{
		first_free = 0;
		array = new Element[5];
	}
	
	
	public void MAKENULL() //делает стек пустым
	{
		// Нулевой элемент массива равен 0
		first_free = 0;
	}
	
	public int TOP() //возвращает элемент (копия) из вершины стека S
	{
		// Если стек пустой
		// FULL и EMPTY проверять в main или здесь?
		if (first_free == 0) throw new StackException("Стек пуст, невозможно вернуть значение вершины");
		// Если стек полный
		if (first_free == -1) return new Element(array[array.length-1]).value;
		// Общий случай
		// Копирующий конструктор для элемента с индексом first_free - 1
		// Результат возвращаем
		return new Element(array[first_free - 1]).value;
	}
	public int POP() //удаляет элемент из вершины стека S, и возвращает его в качестве результатата
	{
		// Если стек пустой
		// FULL и EMPTY проверять в main или здесь? Вызовом метода или отдельно?
		if (first_free == 0) throw new StackException("Стек пуст, невозможно удалить вернуть значение вершины");
		// Если стек полный
		if (first_free == -1) return new Element(array[array.length-1]).value;
		// Общий случай
		// Создаём новую переменную для элемента с индексом first_free - 1
		Element copy = new Element(array[first_free - 1]);
		// first_free уменьшаем на 1, сдвигая терминальный элемент
		first_free--;
		// Удалённый элемент возвращаем
		return copy.value;
	}
	
	public void PUSH(int x) //вставляет элемент x в вершину стека S
	{
		// Создаём объект Element с переданным значением x
		if (first_free == -1) throw new StackException("Стек полон, невозможно вставить значение");
		Element new_elem = new Element(x);
		// Вставляем его в first_free, а конец сдвигаем
		array[first_free] = new_elem;
		if (array[first_free] != array[array.length-1]) first_free++;
		else first_free = -1;
	}
	
	public boolean EMPTY() //возвращает значение true, если стек S пустой, и значение false в противном случае
	{
	    // Если нулевой элемент массива равен first_free, возвращаем true
		if (first_free == 0) return true;
		// Иначе false
		else return false;
	}
	
	public boolean FULL() //возвращает значение true, если стек S полный, и значение false в противном случае
	{
		// Если first_free == -1 (все ячейки заняты), возвращаем true
		if (first_free == -1) return true;
		// Иначе false
		else return false;
	}
	
	public void PrintStack()
	{
		System.out.println("ВЫВОД СТЕКА: ");
		for (int i = 0; (i != first_free && i != array.length); i++)
		{
			System.out.print(array[i].value);
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
