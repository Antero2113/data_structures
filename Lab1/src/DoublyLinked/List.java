package DoublyLinked;

public class List{
	private Element start; // Создаём переменную для первого блока двусвязного списка
	private Element end;  // Создаём переменную для последнего блока двусвязного списка
	
	// end это заполненный элемент, а ппп идёт после него
	// при вставке надо отдельно рассмотреть вставку в end и в ппп, но end в обоих случаях будет сдвигаться
	
	// В конструкторе передаваемый массив записываем в закрытую переменную класса
	public List() {
		start = null; // задаём значение первому элементу списка
		end = null;
	}
	

	
	// Закрытый метод для поиска позиции по значению
	private Position searchValues(Post x) 
	{
		Element elem = start;
		Element end = lastElem(); 
		// В цикле проходим по связному списку:
		while (elem != end) 
		{
			// Если значение в объекте Post = переданному в аргументах (метод Equals класса Post))
			if (elem.values.Equals(x))
			{
				// Вернуть позицию из текущего объекта
				return elem.place;
			}
			// Иначе переходим к следующему объекту
			elem = elem.place.next;
		}
		return new Position(null, null); // если не нашлось совпадений, возвращается пустая позиция 
	}
	
	
    public Position End() 
    {
		return new Position(null, lastElem()); // Возвращает позицию после последнего (null)
    }
    
	// Метод, возвращающий последний заполненный элемент связного списка
	private Element lastElem() 
	{
		Element e = start;
		Element prev = null;
		if (e == null) return prev;

		while (e.place != null) 
		{
			prev = e;
			e = e.place.next; // переходим к следующему
			if (e == null) return prev;
		}
		
		return start; // если всё пусто, возвращаем 
	}
	
	// Закрытый метод для поиска элемента по позиции, возвращает текущий элемент в переданной позиции
	public Element search(Position p)
	{
		Element s = start;
		Element e = s;
		// В цикле проходим по всему списку до искомой позиции, либо до конца
		while (e != null) 
		{
			// Элемент сравнивается с элементом в искомой позиции
			if (e.place.next == p.next) 
			{
				return e; // Если совпадение обнаружено, возвращаем предыдущий элемент
			}
			e = e.place.next; // переходим к следующему
			if (e.place.next == null) return e; // проверяем, что не уткнулись в конец
		}
		return null; // если не нашлось позиции
		
	}
    
	public void Insert(Post x, Position p) 
	{
		Element e1 = new Element();
		// Если искомая позиция является null, значит, мы вставляем в ппп, возможны 3 варианта - в голову, следующий за головой элемент и общий случай
		if (p.next == null)
		{
			// Если вставляем в ппп и список пуст, вставляем новый элемент в голову
			if (start == null) 
			{
				start = new Element(x, new Position());
				return;
			}
            // Если вставляем в ппп и список не пуст
	    	else
	    	{
//	    		System.out.println("Попытка вставки");
//	    		x.print();
	    		lastElem().place.next = new Element(new Post(x), new Position(null, lastElem()));
	    	}
		}
        // Если вставляем не в конец
		else
		{
			// Иначе запускаем search() для поиска предыдущего значения
			
			e1 = search(p);
			//e1.place.next.values.print();
			//e1.place.prev.values.print();	
			
			// Создаём новый элемент, который необходимо вставить
			Element newElement = new Element(new Post(x), new Position());

			// Сохраняем ссылки на предыдущий и следующий элементы относительно e1
			Element prevElement = e1.place.prev;
			//e1.values.print();
			prevElement.values.print();

			 // Устанавливаем ссылки нового элемента
			newElement.place.next = e1;
			newElement.place.prev = prevElement;

			// Переназначаем ссылки предыдущего и следующего элементов
			prevElement.place.next = newElement;
			e1.place.prev = newElement;
		}	
	}
	
	// Метод возвращает позицию элемента, в котором находится переданный объект Post
	public Position Locate(Post x) 
	{
		// Создаем переменную результата и вызываем метод searchValues(Post x)
		Position p = searchValues(x);
		// Если p == null вернуть ппп
		if (p == null)
		{
			return End();
		}
		// Иначе возвращаем найденную существующую позицию
		else return p;
	}
	
	public Element Retrieve(Position p) 
	{
		// Если ппп или не существует позиции, выбросить исключение
		if (p == null) throw new ListException("Невозможно вернуть элемент в заданной позиции");
		Element elem = search(p);
		if (elem == null && p.next != start) throw new ListException("Невозможно вернуть элемент в заданной позиции");
		// Если p == head, head 
		if (p.next == start) return start;
		// Если позиция существует, возвращаем объект класса Element (его ищем с помощью метода search + один раз перейти к следующему) 
		else return elem.place.next;
	}
	
    // Проблема идущих подряд дупликатов
	public void Delete(Position p) 
	{
		// Если удалить нужно в ппп, выходим из метода, так как удалять нечего
		if (p == null) return;
		// Если переданная позиция указывает на голову, просто отсекаем первый элемент, заменяя head
		if (p.next == start) 
			{
			start = start.place.next;
			return;
			}
		
		// В общем случае ищем предыдущий элемент для заданной позиции
		Element elem = search(p);
		
		// Вывод для проверки
		System.out.println("");
		System.out.print("Удаляемый элемент:");
		elem = elem.place.prev;
		elem.values.print();
		System.out.println("");
		System.out.println("");
		
		// Если не существует позиции, выходим из метода
		if (elem == null) return;

		// Если удаляемый элемент в конце списка, просто отсекаем его
		else if (elem.place == null)
		{
			elem.place.prev.place.next = null;
		}
		// Иначе записываем в next предыдущего элемент адрес на элемент, следующий за позицией p
	    else 
	    {
//	    	System.out.println("удалялка не работает");
//	    	elem.values.print();
//	    	elem.place.prev.values.print();
	    	elem.place.prev.place.next = elem.place.next;
	    }
	}
	
	public Position Next(Position p) {
		// Если это ппп, выбрасываем исключение
		if (p == null) throw new ListException("Невозможно вернуть следующий элемент");
		// Если позиция указывает на голову, сразу возвращаем next.p для головы
		if (p.next == start) return new Position(start.place.next, null);
		
		// Иначе с помощью search() ищем предыдущий элемент
		Element elem = search(p);
		
		// Если позиции не существует, также выбрасываем исключение
		if (elem == null) throw new ListException("Невозможно вернуть следующий элемент");

		// Иначе возвращаем следующую позицию
		return new Position(elem.place.next.place.next, elem);
	}
	
	public Position Previous(Position p) 
	{
		// Если текущая позиция head, выбрасываем исключение
		if (p.next == start) throw new ListException("Это первый элемент связного списка, невозможно вернуть предыдущий");
		// Находим предыдущий элемент для позиции
		Element elem = search(p);
		// Если позиции не существует, также выбрасываем исключение
		if (elem == null) throw new ListException("Этой позиции не существует, невозможно вернуть предыдущую");
		// Иначе возвращаем предыдущую позицию через конструктор класса Position и найденный предыдущий элемент
		else return new Position(elem, elem.place.prev);
	}
	
	public Position MakeNull() 
	{
		// Позиция после последнего 0 означает пустой список
		// head = null
		start = null;
		return new Position(null, null);
	}
	
	public Position First() 
	{
		if (start != null) return new Position(start, null); // Если список не пуст, возвращаем ссылку на head
		else return End(); // Иначе возвращаем ппп
	}
	
	// Метод для вывода связного списка на печать
	public void PrintList() 
	{
		System.out.println("ДАННЫЕ");
		Element e = start;
		while (e != null) {
			e.values.print();
			System.out.print("  ");
			if (e != start) e.place.prev.values.print();
			System.out.println("");
			if (e.place == null) e = null;
			else e = e.place.next;
		}
		System.out.println("");
	}
}

//Класс исключения
class ListException extends RuntimeException
{		
  String ms;

	 public ListException(String ms) 
	 {
      this.ms = ms;		
	 }

  public String toString()
  {
      return ms;
  }
}
