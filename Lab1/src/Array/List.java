package Array;

public class List{
    private int last; // индекс первого свободного
	private Post[] L; // Создаём массив для списка, каждый его элемент является объектом класса Post
	
	// Конструктор для пустого списка
	public List() {
		// Выделяем память под пустой массив
		last = 0;
		L = new Post[32];
	}
	
    public Position End() {
		return new Position(last); // Возвращает позицию первого свободного
    }
	
	public void Insert(Post x, Position p) {
        // если индекс меньше 0 или > last, выходим из метода
		if (p.p < 0 || p.p > last) return;
		
		// если p.p == last, помещаем x в ячейку с индексом last
		// В цикле перезаписываем все значения после позиции p-1, сдвигая на 1 ячейку массива вправо
		// помещаем элемент x в массив на позицию p
		if (p.p == last)
		{
			this.L[last] = x;
		}
		else
		{
			for (int i = last; i > p.p; i--)
			{
				this.L[i] = this.L[i-1];
			}
			this.L[p.p] = x;
		}
		last++;
	}
	
	public Position Locate(Post x) {
		//создаем переменную результата типа Position
		//в цикле for each для array:
		//если элемент из массива = объекту полученного в аргументах (методом equals класса Post)
				//вернуть переменную результата
		//return p;
		if (x == null) return new Position(-1);
		for (int i = 0; i<last; i++)
		{
			if (this.L[i].equals(x)) return new Position(i);
		}
		return new Position(-1);
	}
	
	public Post Retrieve(Position p) {
		//System.out.println(p.p);
		// если индекс меньше 0 или > last, выбросить исключение
		// Если позиция существует, возвращаем элемент списка
		// return x;
		if (p.p < 0 || p.p > last) throw new ListException("Такой позиции не существует");
		else if (p.p == last) return L[p.p-1];
		else
		{
			return this.L[p.p];
		}
	}
	
	public void Delete(Position p) {
		// если индекс меньше 0 или > last, выходим из метода
		if (p.p < 0 || p.p > last) return;
		// Иначе удаляем элемент на указанной позиции
		// В цикле сдвигаем все элементы правее удалённого на 1 влево
		// Уменьшаем last на 1
		else
		{
			System.out.println("");
			System.out.print("Удаляемый элемент:");
			L[p.p].print();
			System.out.println("");
			System.out.println("");
			for (int i=p.p; i<last; i++)
			{
				this.L[i] = this.L[i+1];
			}
		    last--;	
		}
	}
	
	public Position Next(Position p) {
		// Если текущей позиции не существует или она равна last, выбрасываем исключение
		// Иначе возвращаем следующую позицию
		if (p.p < 0 || p.p >= last) throw new ListException("Невозможно вернуть следующую позицию");
		else 
		{
			return new Position(p.p + 1);
		}
	}
	
	public Position Previous(Position p) {
		// если индекс меньше 0 или > last, или это First(L), выбрасываем исключение
		// Иначе возвращаем предыдущую позицию
		if (p.p <= 0 || p.p > last) throw new ListException("Невозможно вернуть предыдущую позицию");
		else 
		{
			return new Position(p.p-1);
		}
	}
	
	public Position MakeNull() {
		last = 0; // last 0 означает пустой список
		return new Position(0);
	}
	
	public Position First() {
		return new Position(0); // И для заполненного и для пустого списка возвращаем 0, так как при заполнении массива 0 - первый элемент, а при пустом - last
	}
	
	public void PrintList() {
		// Вывод массива по элементам с использованием метода Print класса Post
		System.out.println("ДАННЫЕ:");
		for (int i = 0; i < last; i++) {
			this.L[i].print();
			System.out.println(" ");
		}
		System.out.println(" ");
	}
}

//класс исключения
class ListException extends RuntimeException{		
String ms;

	 public ListException(String ms) {
   this.ms = ms;		
	 }

public String toString(){
   return ms;
}
}
