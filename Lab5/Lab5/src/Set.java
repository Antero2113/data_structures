
public class Set {
   Block tail;
   // переменная для хранения ссылки на конец кольцевого списка


   // Конструктор для создания пустого списка
   public Set() {
       tail = null; // Означает пустой список
   }

   // Копирующий конструктор для кольцевого списка
   public Set(Set other) {
       if (other == null || other.tail == null) {
           this.tail = null;
           return;
       }

       // Создаем копию первого элемента
       this.tail = new Block(other.tail.value);
       Block current = other.tail.next;
       Block currentCopy = this.tail;

       // Копируем остальные элементы
       while (current != other.tail) {
           currentCopy.next = new Block(current.value);
           currentCopy = currentCopy.next;
           current = current.next;
       }
       // Замыкаем кольцо
       currentCopy.next = this.tail;
   }

   // Метод для вставки первого элемента
   // Block t - tail списка, в который вставляем (равен null), x - вставляемое значение
   private void addFirst(int x)
   {
	   // Создаём новый элемент множества со значением х и вставляем его в tail
	   tail = new Block(x);
   	   // tail.next = tail закольцовываем список, определяя next для нового tail
	   tail.next = tail;
   }

   // Метод для добавления любых элементов, кроме первого
   // Block t - tail списка, в который вставляем, x - вставляемое значение
   private void addElement(int x)
   {
	   // Получаем голову кольцевого списка Block head = tail.next;
	   Block head = tail.next;
   	   // Создаём новый элемент new_elem множества с value = x
	   Block new_elem = new Block(x);
	   // В конец списка вставляем созданный элемент
	   tail.next = new_elem;
	   // Закольцовываем список, определяя next для нового элемента new_elem.next = head;
	   new_elem.next = head;
	   // Корректируем ссылку на tail, сдвигая её на вставленный элемент tail = tail.next;
	   tail = tail.next;
   }

   // Метод для поиска предыдущего элемента для искомого x
   // Параметры: хвост списка, с какого блока ищем в этом списке, какое значение ищем
   private Block searchPrevious(Block t_tail, Block start, int x) {
	   	// Создаём переменную для предыдущего
	    Block prev = t_tail;
	    Block curr = start;
	   	// Проходим по списку, начиная со start и сравниваем значения элементов с х, пока не дойдём до tail
	    while (curr != t_tail)
	    {
	       if (curr.value == x)
	       {
	    	  // Если обнаружено совпадение, возвращаем предыдущий
	    	   return prev;
	       }
	       prev = curr;
	       curr = curr.next;
	    }
	   	// Если дошли до tail, но так и нет совпадения, возвращаем null
	    if (t_tail.value == x) return prev;
	    else return null;
	   }


   // Метод для проверки пересечения множеств
   // Вызывается на множестве А, второе передаётся в параметрах
   public boolean CheckInterSection(Set B)
   {
	    // Какое-то(или оба) из множеств пустое:
	      // Для обоих множеств проверить tail == 0
	      // Если хотя бы одно пустое, возвращаем false

	   // Если передано одно и то же множество, возвращаем true
	   
	   if(this.tail == null || B.tail == null) return false;
       if (this == B) return true;

	   // Если наибольшее значение одного множества меньше наименьшего значения другого,
	      // также возвращаем false
       
       if (this.tail.value < B.tail.next.value || B.tail.value < this.tail.next.value) return false;

	   // Сравниваем первый элемент списка A с первым элементом списка B
	      // Если они совпадают, возвращаем true
       Block a = this.tail.next;
       Block b = B.tail.next;
       
	   // Иначе сдвигаем текущий элемент списка A и не сдвигаем элемент из B, пока значение элемента из А не стало больше значения элемента из В,
	         // Если при этом находим совпадение, возвращаем true
	   // Если совпадения не нашлось, а значение уже превышено (например, мы ищем 2, а текущее значение из первого списка уже 3),
	   // во втором списке переходим к следующему элементу и сравниваем уже его, в первом списке начинаем с того же элемента, на котором остановились
       
       while (a != this.tail && b != B.tail)
       {
    	   if (a.value == b.value) return true;
    	   if (a.value > b.value)
	       {
	          	 b = b.next;
	       }
    	   else if (b.value > a.value)
	       {
	        	 a = a.next;
	       }
       }
	   // Как только в одном из списков дошли до tail,
	        // вызываем searchPrevious(tail списка, который ещё не закончился, начало этого же списка, значение из tail закончившегося списка)
	   // Если совпадения так и не нашлись, возвращаем false
       if (a == this.tail)
       {
    	   return (searchPrevious(B.tail, b, a.value) != null);
       }
       else if (b == B.tail)
       {
    	   return (searchPrevious(this.tail, a, b.value) != null);
       }
       return false;
   }


   // Пересечение множеств, вызывается на множестве А, второе передаётся в параметрах, результатом является новое множество
   public Set InterSection(Set B) {

	   // Какое-то(или оба) из множеств пустое:
	      // Для обоих множеств проверить tail == 0
	      // Если хотя бы одно пустое, возвращаем новое пустое множество C

	   // Если передано одно и то же множество, возвращаем это множество
	   
	   if(this.tail == null || B.tail == null) return new Set();
       if (this == B) return this;

	   // Если наибольшее значение одного множества меньше наименьшего значения другого,
	      // также возвращаем новое пустое множество 
       
       if (this.tail.value < B.tail.next.value || B.tail.value < this.tail.next.value)
       {
    	  return new Set();
       }

       Set C;
	   // Вызов метода для пересечения списков listInterSection(this.tail, B.tail), возвращает tail для нового множества
       C = listInterSection(this.tail, B.tail);
 
	   // Возвращаем С, записывая в C.tail переданный конец нового списка из метода
       return C;
   }


   // Метод для поиска пересечения 2-х списков, возвращает tail нового сформированного списка
   private Set listInterSection(Block a_tail, Block b_tail)
   {
	   // Создаём новый список Block c_tail = 0;
	   Set C = new Set();
	   Block a = a_tail.next;
	   Block b = b_tail.next;

	   // Этап 1 Поиск первого совпадения

	   // Сравниваем первый элемент списка A с первым элементом списка B
	      // Если они совпадают, вызываем AddFirst() и выходим из цикла
	   // Иначе сдвигаем текущий элемент списка A и не сдвигаем элемент из B, пока значение элемента из А не стало больше значения элемента из В,
	         // Если для какой-то из пар значений находим совпадение, вызываем AddFirst() и выходим из цикла
	   // Если совпадения не нашлось, а значение уже превышено (например, мы ищем 2, а текущее значение из первого списка уже 3),
	   // во втором списке переходим к следующему элементу и сравниваем уже его, в первом списке начинаем с того же элемента, на котором остановились
	   // Как только в одном из списков дошли до tail,
	        // вызываем searchPrevious(tail списка, который ещё не закончился, начало этого же списка, значение из tail закончившегося списка)
	   // Если совпадения так и не нашлись, выходим из метода
	   if (a.value == b.value) C.addFirst(a.value);
	   else
	   {
		   while (a != this.tail && b != b_tail)
	       {
	    	   if (a.value == b.value) 
	    	   {
	    		   C.addFirst(a.value);
	    		   break;
	    	   }
	    	   if (a.value > b.value)
		       {
		          	 b = b.next;
		       }
	    	   else if (b.value > a.value)
		       {
		        	 a = a.next;
		       }
	       }
		   if (a == this.tail)
	       {
			   Block prev = searchPrevious(b_tail, b, a.value);
	    	   if (prev == null) return C;
	    	   else
	    	   {
	    		   C.addFirst(prev.next.value);
	    	   }
	       }
	       else if (b == b_tail)
	       {
	    	   Block prev = searchPrevious(this.tail, a, b.value);
	    	   if (prev == null) return C;
	    	   else
	    	   {
	    		   C.addFirst(prev.next.value);
	    	   }
	       }
	   }
	   //return C;

	   // Этап 2

	   // После вставки первого элемента, запускаем аналогичный цикл для добавления остальных элементов (начиная с тех позиций, на которых остановились
	   // при вставке первого:
	       // Но теперь для вставки элементов addElement() вместо AddFirst
	   
	   a = a.next;
	   b = b.next;
	   while (a != this.tail && b != b_tail)
       {
    	   if (a.value == b.value) 
    	   {
    		   C.addElement(a.value);
    		   a = a.next;
    		   b = b.next;
    	   }
    	   if (a.value > b.value)
	       {
	          	 b = b.next;
	       }
    	   else if (b.value > a.value)
	       {
	        	 a = a.next;
	       }
       }
	   // Этап 3

	     // Как только в одном из списков дошли до tail,
	        // вызываем searchPrevious(tail списка, который ещё не закончился, начало этого же списка, значение из tail закончившегося списка)
	          // Если метод вернул предыдущий блок для совпадения, переходим к следующему и добавляем его в список результата
	          // Если метод вернул null, ничего не делаем
	   if (a == this.tail)
       {
		   Block prev = searchPrevious(b, b, a.value);
    	   if (prev == null) return C;
    	   else
    	   {
    		   C.addElement(prev.value);
    	   }
       }
       else if (b == b_tail)
       {
    	   Block prev = searchPrevious(a, a, b.value);
    	   if (prev == null) return C;
    	   else
    	   {
    		   C.addElement(prev.value);
    	   }
       }
       return C;
   }



   // Объединение множеств, вызывается на множестве А, второе передаётся в параметрах
   public Set Union(Set B) {

   	   // Если оба пустые, возвращаем пустое множество C
	   if(this.tail == null && B.tail == null) return new Set();
	   // Если одно из двух пустое, а второе нет, возвращаем единственное непустое в качестве результата
       if (this.tail == null) return B;
       else if (B.tail == null) return this;
	   // Если передано одно и то же множество, возвращаем это множество
       if (this == B) return this;

       Set C;

	   // Если наибольший элемент одного множества меньше наименьшего элемента другого,
       if (this.tail.value < B.tail.next.value)
       {
    	  C = new Set(this);
	      // берём за основу множество, содержащее меньшие значения, а все значения второго вставляем с помощью AddElement() в конец друг за другом
    	  Block curr = B.tail.next;
    	  while (curr != B.tail)
    	  {
    		  C.addElement(curr.value);
    		  curr = curr.next;
    	  }
    	  C.addElement(B.tail.value);
       }
       else if (B.tail.value < this.tail.next.value)
       {
    	   C = new Set(B);
    	   Block curr = this.tail.next;
     	   while (curr != this.tail)
     	   {
     		  C.addElement(curr.value);
     		  curr = curr.next;
     	   }
     	   C.addElement(this.tail.value);
       }
       // Создаём копию того множества, первый элемент которого меньше или равен первому элементу второго множества:
	   // Set C = new Set(_);
	   // Во всех остальных случаях вызываем метод listUnion(C.tail, _.tail)
       else
       {
    	   if (this.tail.next.value >= B.tail.next.value) 
    	   {
    		   C = new Set(B);
    		   listUnion(this.tail, C);
    	   }
    	   else
    	   {
    		   C = new Set(this);
        	   listUnion(B.tail, C);
    	   }
       }

	   // Возвращаем C
       return C;
   }

   // Метод для объединения списков, a_tail - в него будем записывать результат
   // В рамках метода список А - список результата, В - список, из которого добавляем элементы в А
   private Block listUnion(Block b_tail, Set C)
   {
	   // Переходим к началам обоих списков
	   Block a = C.tail.next;
	   Block b = b_tail.next;
	   // Создаём переменные для предыдущих
	   Block a_prev = null;
	   Block b_prev = null;
	   // Пока не дошли до хвостов
	   while (a != C.tail && b != b_tail)
	   {
		   
		  // Если первые элементы равны, одновременно в обоих списках переходим ко вторым элементам
		  // Выполняем одновременный переход, пока элементы совпадают (в цикле проверяем всё время не текущую пару, а следующую через next
	      // чтобы хранить ссылки на предыдущие элементы
		   
		  if (a.value == b.value)
		  {
			  a_prev = a;
			  b_prev = b;
			  a = a.next;
			  b = b.next;
		  }
		  else if (a.value > b.value)
	      {
	          	 a_prev.next = new Block(b.value, a);
	          	 b_prev = b;
	          	 b = b.next;
	      }
		  else if (b.value > a.value)
	         {
	        	 a_prev = a;
	        	 a = a.next;
	         }
	   }
	   // Если перед хвостом нужно
	   if (a.value > b.value)
	   {
	       a_prev.next = new Block(b.value, a);
	       b_prev = b;
	       b = b.next;
	   }
	   // Если закончился список А, с помощью AddElement() вставляем в А все оставшиеся элементы из В
	   if (a == C.tail)
	   {
		   while (b != b_tail)
		   {
			   C.addElement(b.value);
			   a = a.next;
			   b = b.next;
		   }
		   if (C.tail.value != b_tail.value) C.addElement(b_tail.value);
	   }
	   // Если закончился список В, выходим из цикла

	   // Возвращаем a_tail
	   return C.tail;
   }


   // Разность, вызывается на множестве А, второе передаётся в параметрах
   public Set Difference(Set B) {
	   // Создаём пустое множество результата C

   	   // Если оба пустые, возвращаем пустое множество C
	   // Если одно из двух пустое, а второе нет, возвращаем единственное непустое в качестве результата

	   // Если передано одно и то же множество, возвращаем пустое множество

	   // Если наибольший элемент одного множества меньше наименьшего элемента другого,
	      // копируем поочереди сначала первое множество в C, потом второе
	   
	   if(this.tail == null && B.tail == null) return new Set();
       if (this.tail == null) return new Set();
       else if (B.tail == null) return this;
       if (this == B) return new Set();
       
       if (this.tail.value < B.tail.next.value || B.tail.value < this.tail.next.value)
       {
    	  return this;
       }

       Set C = listDifference(this.tail, B.tail);
       return C;

	   // Во всех остальных случаях вызываем listDifference(this.tail, B.tail), возвращает tail для нового множества

	   // Возвращаем C

   }

   // Обычная разность, проверить, какой список
   // Копирование, если закончился второй список
   // 3 цикла, разные алгоритмы в зависимости от того, чей это хвост

   // Вспомогательный метод для разности списков, A - множество, из которого вычитаем, В - вычитаемое множество
   private Set listDifference(Block a_tail, Block b_tail)
   {
	   // Создаём список результата С с концом c_tail
	   Set C = new Set();
	   // Получаем начала обоих списков
	   Block a = a_tail.next;
	   Block b = b_tail.next;

	   // Этап 1. Поиск первого

	   // Если текущий элемент из А совпадает с В, одновременно переходим ко вторым элементам списков
	      // Выполняем одновременный переход, пока элементы совпадают
	      // Как только не совпали:

	         // Вариант 1: значение из В больше, чем из А - можем записывать значение из А в список результата С с помощью AddFirst() и выходим из цикла
	         // Вариант 2: значение из А больше, чем из В
	                       // Проходим дальше по В, пока его значение не станет равно (тогда снова одновременный переход)
	                                                                         // или больше (тогда AddFirst() для текущего значения из А)

	      // Если мы дошли до конца одного из списков:

	         // Вариант 1: это список А или оба - просто выходим из цикла и из метода, возвращая c_tail (значит, разность пустая)
	         // Вариант 2: это список В - вставляем в С все оставшиеся элементы А, первый с помощью AddFirst()

	   while (a != this.tail && b != b_tail)
       {
		   while (a.value > b.value)
	       {
	          	 b = b.next;
	       }
    	   if (a.value == b.value) 
    	   {
    		   a = a.next;
    		   b = b.next;
    	   }
    	   else if (b.value > a.value)
	       {
    		     C.addFirst(a.value);
	        	 a = a.next;
	        	 break;
	       }
       }
	   
	   // Этап 2. Добавление остальных (на момент перехода к этой части ни один из списков ещё не закончился, в С есть первый элемент)

	   // Пока не дошли ни до одного конца:
	   // Если текущий элемент из А совпадает с В, одновременно переходим к  элементам списков
	      // Выполняем одновременный переход, пока элементы совпадают
	      // Как только не совпали:

	         // Вариант 1: значение из В больше, чем из А - можем записывать значение из А в список результата С с помощью AddElement() и одновременно переходим к следующим
	         // Вариант 2: значение из А больше, чем из В
	                       // Проходим дальше по В, пока его значение не станет равно (тогда снова одновременный переход)
	                                                                         // или больше (тогда AddElement() для текущего значения из А и одновременный переход дальше)
	   
	   while (a != this.tail && b != b_tail)
       {
		   while (a.value > b.value)
	       {
	          	 b = b.next;
	       }
    	   if (a.value == b.value) 
    	   {
    		   a = a.next;
    		   b = b.next;
    	   }
    	   else if (b.value > a.value)
	       {
    		     C.addElement(a.value);
	        	 a = a.next;
	       }
       }
	   
	   // Этап 3. Хвосты

	      // Если мы дошли до конца одного из списков:

	         // Вариант 1: это список А или оба - просто выходим из цикла и из метода, возвращая c_tail
	         // Вариант 2: это список В - вставляем в С все оставшиеся элементы А с помощью AddElement() и возвращаем c_tail
	   if (b == b_tail)
	   {
		   while (a != a_tail)
		   {
			   if (b.value != a.value)
			   {
				   C.addElement(a.value);
			   }
			   a = a.next;
		   }
		   if (a_tail.value != b_tail.value) C.addElement(a_tail.value);
	   }
	   
	   return C;
   }

   // Объединение непересекающихся множеств, вызывается на множестве А, второе передаётся в параметрах
   public Set Merge(Set B) {
	// Без проверок

   	// Перед вызовом метода пользователь должен проверить, что множества не пересекаются
	   if(this.tail == null || B.tail == null) return new Set();
	   
	// Создаём копию того множества, первый элемент которого меньше или равен первому элементу второго множества:
	   Set C = new Set();
	   if (this.tail.next.value < B.tail.next.value)
       {
    	  C = new Set(this);
    	  listUnion(B.tail, C);
       }
       else if (this.tail.next.value > B.tail.next.value)
       {
    	   C = new Set(B);
    	   listUnion(this.tail, C);
       }

	// Вызываем метод listUnion(C.tail, _.tail)
	// Возвращаем множество C
	   return C;
	   

	// ??? Вставлять не после, а перед элементом, который больше (в ListUnion)
	// При поиске значение строго меньше
	   // в Merge >, а в Union >=
	   // лучше разные методы, проверить, есть ли проблемы
   }

   // Возвращает true, если х есть в множестве, и false, если нет
   public boolean Member(int x) {
	// Если значение x больше наибольшего элемента множества или меньше наименьшего, возвращаем false
	   if (x > tail.value || x < tail.next.value) return false;
   	// Иначе вызываем метод searchPrevious()
	   // Если он вернул null, возвращаем false
	   // Если вернул ссылку на элемент, возвращаем true
	   else 
	   {
		   Block prev = searchPrevious(tail, tail.next, x);
		   return (prev != null);
	   }
   }

   // Вызывается на множестве, присваивает ему значение пустого множества
   public void MakeNull() {
   	// tail = null означает, что в кольцевом списке (множестве) нет ни одного элемента
	   this.tail = null;
   }



   // Добавляет элемент х в множество
   public void Insert(int x) {
   	// Если множество пустое (tail == null)
	if (tail == null)
	{
   	   // Вызываем AddFirst()
		this.addFirst(x);
	}
	// Рассматриваем первый элемент:
	   // если его значение совпадает с х, выходим из метода
	   // если не совпадает и при этом в множестве один элемент, переходим к вставке
	else
	{
		if (tail.next.value == x) return;
		//System.out.println(this.tail.value);
		//System.out.println(this.tail.next.value);
		if (tail == tail.next)
		{
			addElement(x);
			return;
		}

	// Иначе вызываем searchPrevious(), чтобы проверить, есть ли такое значение в множестве
	   // Если метод вернул ссылку и значение есть, выходим из метода
	   // Если вернул null, переходим дальше
		Block prev = searchPrevious(this.tail, this.tail.next, x);
		if (prev != null) return;
		else addElement(x);

   	// Если множество непустое (tail != null) и значения такого нет
   	   // Вызываем AddElement()
	}
   }

   public void Delete(int x) {
   	// Если множество пустое, выходим из метода
	   if (tail == null) return;
	// Рассматриваем первый элемент, если он не равен искомому и это не единственный элемент, продолжаем, иначе выходим
	   if (tail.next == tail)
	   {
		   if (tail.value == x) tail = null;
		   return;
	   }
	   else {
		// Иначе вызываем searchPrevious()
		   if (tail.next.value == x) tail.next = tail.next.next;
		   Block prev = searchPrevious(this.tail, this.tail.next, x);
		   if (prev == null) return;
		   else {
			   if (prev.next == tail) 
			   {  
				   tail = prev;
			   }
			   prev.next = prev.next.next;
		   }
		   
	   }
	   // Если элемента нет, выходим
	   // Если есть, удаляем:
   	      // Присваиваем next предыдущего ссылку на следующий после x элемент
   	         // Если x == tail, корректируем ссылку на конец списка после удаления
   }

   public void Assign(Set A, Set B) {
	// Проверки
	   if (this == B) return; // если одно и то же множество
	   if (B.tail == null) 
	   {
		   A = new Set(); // пустое множество
		   return;
	   }
	   A = new Set(B);
   }


   public Block Min() {
   	// Если множество линейно упорядочено, возвращаем голову списка как первое по возрастанию значение
   	return tail.next;
   }

   public Block Max() {
   	// Если множество линейно упорядочено, возвращаем хвост списка как последнее по возрастанию значение
   	return tail;
   }

   public boolean Equal(Set B) {
	// Проверки
	   
	   if(this.tail == null || B.tail == null) return true;
       if (this == B) return true;
       if (this.tail.value < B.tail.next.value || B.tail.value < this.tail.next.value) return false;

   	// Попарно сравниваем элементы, начиная с голов списков (множеств)
   	// Как только значения попарно не совпадают, возвращаем false
	// Если дошли до конца одного из списков, а второй ещё не закончился, возвращаем false
   	// Если дошли до концов одновременно, true
       Block a = this.tail.next;
       Block b = this.tail.next;
       while (a != this.tail && b != B.tail)
       {
    	   if (a.value != b.value) return false;
    	   else
    	   {
    		   a = a.next;
    		   b = b.next;
    	   }
       }
       return (a.value == this.tail.value && b.value == B.tail.value);
   }

   public Set Find(int x, Set B) {
	   Block a = this.tail.next;
	   Block b = B.tail.next;
   	// Если значение больше наибольшего или меньше наименьшего элемента обоих множеств,
	   // создаём и возвращаем в качестве результата пустое множество
	   if ((x < a.value || x > this.tail.value) && (x < b.value || x > B.tail.value)) return new Set();
    // Если хотя бы одно множество потенциально может содержать х, начинаем проверку
	// Для каждого из множеств:
	   // Рассматриваем первый элемент
	      // Если его значение равно искомому, возвращаем это множество
	      // Если значение не равно, но в множестве только один элемент, переходим к другому множеству или возвращаем пустое (если ни в одном не нашлось)
	   // Иначе вызываем searchPrevious()
	      // Если метод вернул ссылку и значение есть, возвращаем это множество
	      // Если вернул null, переходим к другому множеству или возвращаем пустое (если ни в одном не нашлось)
	   if (!(x < a.value || x > this.tail.value))
	   {
		   if (a.value == x) return this;
		   else if (a != this.tail) 
		   {
			   if (searchPrevious(this.tail, a, x) != null) return this;
		   }
	   }
	   if (!(x < b.value || x > B.tail.value))
	   {
		   if (b.value == x) return B;
		   else if (b != B.tail) 
		   {
			   if (searchPrevious(B.tail, b, x) != null) return B;
		   }
	   }
	   return new Set();
	   
   }

   public void print(String s) {
	   if (this.tail == null)
	   {
		   System.out.println("Множество пустое.");
		   System.out.println(" ");
		   return;
	   }
	   //System.out.println("tail: " + tail.value);
	   System.out.print(s + ": ");
	   Block curr = this.tail.next;
	   System.out.print("{ ");
	   while(curr != this.tail)
	   {
		   System.out.print(curr.value + ", ");
		   curr = curr.next;
	   }
	   System.out.print(this.tail.value + "}");
	   System.out.println(" ");
	   System.out.println(" ");
   }
}