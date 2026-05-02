package Linked;

public class List{
	// Создаём переменную для первого блока связного списка
	private Element head; 
	
	// Конструктор связного списка для инициализации внутренних переменных 
	public List() 
	{
		head = null; // задаём значение null первому элементу списка, так как список пока пуст
	}
	
	// Закрытый метод для поиска элемента по позиции, возвращает предыдущий элемент относительно переданной позиции
	private Element search(Position p)
	{
		// Создаём переменные для сохрания ссылок на каждом шаге на текущей и предыдущий элементы
		Element e = head;
		Element prev = null;
		// В цикле проходим по всему списку до искомой позиции, либо до конца
		while (e.next != null) 
		{
			// Элемент сравнивается с элементом в искомой позиции
			if (e == p.p) 
			{
				return prev; // Если совпадение обнаружено, возвращаем предыдущий элемент
			}
			prev = e; // сохраняем предыдущий элемент
			e = e.next.p; // переходим к следующему
			if (e == null) return prev; // проверяем, что не уткнулись в конец
		}
		return prev; // если не удалось найти позицию, возвращается prev = null
	}
	
	// Закрытый метод для поиска позиции по значению
	private Position searchValues(Post x) 
	{
		Element elem = head;
		Element end = lastElem(); 
		// В цикле проходим по связному списку:
		while (elem != end) 
		{
			// Если значение в объекте Post = переданному в аргументах (метод Equals класса Post))
			if (elem.values.Equals(x))
			{
				// Вернуть позицию из текущего объекта
				return elem.next;
			}
			// Иначе переходим к следующему объекту
			elem = elem.next.p;
		}
		return new Position(null); // если не нашлось совпадений, возвращается пустая позиция 
	}
	
	
    public Position End() 
    {
		return new Position(null); // Возвращает позицию после последнего (null)
    }
    
	// Метод, возвращающий последний заполненный элемент связного списка
	private Element lastElem() 
	{
		// Вызов метода search() для ппп (End()), возвращаем элемент перед ппп
		return search(End());
	}
    
	
	public void Insert(Post x, Position p) 
	{
		Element e1 = new Element();
		// Если искомая позиция является null, значит, мы вставляем в ппп, возможны 3 варианта - в голову, следующий за головой элемент и общий случай
		if (p.p == null)
		{
			// Если вставляем в ппп и список пуст, вставляем новый элемент в голову
			if (head == null) 
			{
				head = new Element(x, null);
				return;
			}
			// Ищем предыдущий элемент
			if (p.p != head) e1 = search(p);
			
			// Если вставляем в ппп и заполнена только голова
			if (e1 == null)
		    {
                head.next = new Position(new Element(new Post(x), null));
		    }
			// Если вставляем в ппп в общем случае
	    	else
	    	{
	    		e1 = e1.next.p;
	    		e1.next = new Position(new Element(new Post(x), null));
	    	}
		}
        // Если вставляем не в конец
		else
		{
			// Иначе запускаем search() для поиска предыдущего значения
			e1 = search(p);
			// Вызов копирующего конструктора для объекта Post в позиции p
			Post old_values = new Post(e1.next.p.values);
			// Создание нового элемента, куда копируются данные из блока в позиции p и адрес на блок в позиции p+1)
			Element e_new = new Element(old_values, e1.next.p.next);
			// Имя и адрес (передаваемое в Insert) копируем в объект в позиции p вместо старого набора 
			e1.next.p.values = new Post(x);
			// Добавляем новый элемент в список
			e1.next.p.next = new Position(e_new);
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
		if (elem == null && p.p != head) throw new ListException("Невозможно вернуть элемент в заданной позиции");
		// Если p == head, head 
		if (p.p == head) return head;
		// Если позиция существует, возвращаем объект класса Element (его ищем с помощью метода search + один раз перейти к следующему) 
		else return elem.next.p;
	}
	
    // Проблема идущих подряд дупликатов
	public void Delete(Position p) 
	{
		// Если удалить нужно в ппп, выходим из метода, так как удалять нечего
		if (p == null) return;
		// Если переданная позиция указывает на голову, просто отсекаем первый элемент, заменяя head
		if (p.p == head) 
			{
			head = head.next.p;
			return;
			}
		
		// В общем случае ищем предыдущий элемент для заданной позиции
		Element elem = search(p);
		
		// Вывод для проверки
		System.out.println("");
		System.out.print("Удаляемый элемент:");
		elem.next.p.values.print();
		System.out.println("");
		System.out.println("");
		
		// Если не существует позиции, выходим из метода
		if (elem == null) return;

		// Если удаляемый элемент в конце списка, просто отсекаем его
		else if (elem.next.p.next == null)
		{
			elem.next = null;
		}
		// Иначе записываем в next предыдущего элемент адрес на элемент, следующий за позицией p
	    else 
	    {
	    	elem.next.p = elem.next.p.next.p;
	    }
	}
	
	public Position Next(Position p) {
		// Если это ппп, выбрасываем исключение
		if (p == null) throw new ListException("Невозможно вернуть следующий элемент");
		// Если позиция указывает на голову, сразу возвращаем next.p для головы
		if (p.p == head) return new Position(head.next.p);
		
		// Иначе с помощью search() ищем предыдущий элемент
		Element elem = search(p);
		
		// Если позиции не существует, также выбрасываем исключение
		if (elem == null) throw new ListException("Невозможно вернуть следующий элемент");
		
		// Иначе возвращаем следующую позицию
		return new Position(elem.next.p.next.p);
	}
	
	public Position Previous(Position p) 
	{
		// Если текущая позиция head, выбрасываем исключение
		if (p.p == head) throw new ListException("Это первый элемент связного списка, невозможно вернуть предыдущий");
		// Находим предыдущий элемент для позиции
		Element elem = search(p);
		// Если позиции не существует, также выбрасываем исключение
		if (elem.next == null) throw new ListException("Этой позиции не существует, невозможно вернуть предыдущую");
		// Иначе возвращаем предыдущую позицию через конструктор класса Position и найденный предыдущий элемент
		else return new Position(elem);
	}
	
	public Position MakeNull() 
	{
		// Позиция после последнего 0 означает пустой список
		// head = null
		head = null;
		return new Position(null);
	}
	
	public Position First() 
	{
		if (head != null) return new Position(head); // Если список не пуст, возвращаем ссылку на head
		else return End(); // Иначе возвращаем ппп
	}
	
	// Метод для вывода связного списка на печать
	public void PrintList() 
	{
		System.out.println("ДАННЫЕ");
		Element e = head;
		while (e != null) {
			e.values.print();
			System.out.println("");
			if (e.next == null) e = null;
			else e = e.next.p;
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
