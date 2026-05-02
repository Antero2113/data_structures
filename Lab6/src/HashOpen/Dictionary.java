package HashOpen;
import Default.Block;

public class Dictionary {
    Block[] array; // массив классов множества
    static int B = 25; // переменная задающая количество классов

    // Массив ссылочных переменных, не пустые строки, а ссылка null

    public Dictionary()
    {
    	array = new Block[B];
    }
    
    // Сравниваем не ссылки, отдельный метод!!!
    private static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1 == arr2) return true;
        if (arr1 == null || arr2 == null) return false;
        if (arr1.length != arr2.length) return false;
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    // Копирующий конструктор для сивольного массива
    public static char[] copyCharArray(char[] original) {
        if (original == null) {
            return null;
        }
        
        char[] copy = new char[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }
    

    // Метод для поиска в списке коллизий, возвращает предыдущий
    private Block search(Block start, char[] x) {
    	// Записываем в переменную начало списка
    	Block e = start;
    	// Если х не равно значению элемента головы списка, переходим к следующему
    	
    	// Создаём переменную для предыдущего элемента
    	Block prev = new Block();
    	// Проходим через next до конца списка,
    	while(e.next != null)
    	{
    	   // Сравниваем значение каждого из элементов с переданным
    	   if (compareCharArrays(e.value, x)) return prev;
     	   // Если находим совпадение, возвращаем prev
    	   prev = e;
    	   e = e.next;
    	}
    	// Для последнего
    	if (compareCharArrays(e.value, x)) return prev;
    	// Если ни одного совпадения не нашлось, возвращаем null
    	return null;
    }

    // Имеет аргументами множество А и объект х того же типа, что и элементы множества А,
    // и возвращает булево значение true (истина), если х принадлежит А, и значение false (ложь),
    // если х не принадлежит A
    public boolean Member(char[] x)
    {
        // Не нужно проверять передаваемые значения
    	// Иначе вызываем хеш-функцию для определения позиции
    	int hash = hashFunction(x);
    	if (compareCharArrays(array[hash].value, x)) return true;
    	// По полученной позиции вызываем search()
    	Block prev = search(array[hash], x);
    	// Если в списке коллизий нашлось нужное значение, возвращаем true
    	// Иначе false
    	return (prev != null);
    }

    // Присваивает множеству А значение пустого множества
    public void MakeNull()
    {
    	// Записываем null в каждую ячейку массива
    	for (int i = 0; i < B; i++)
    	{
    		array[i] = null;
    	}
    	
    }

    // Вычисляет индекс ячейки массива, в которую будут записаны данные
    private int hashFunction(char[] x)
    {
    	// Сумма кодов символов, составляющих имя
    	int sum = 0;
        for (char c : x) {
            sum += (int) c; // Преобразуем символ в его ASCII-код и добавляем к сумме
        }
    	// Эту сумму поделить на количество разбиений/сегментов B (поиск остатка от деления)
    	// Результат - значение от 0 до B-1
        return sum%B;
    }
    
    // Копировать символьный массив, а не сразу вставлять

    // Делает х элементом множества А
    public void Insert(char[] x)
    {
    	// При вставке вызываем хеш-функцию, передавая x
    	int hash = hashFunction(x);
    	// Получаем элемент массива по индексу, который вернула хэш-функция
    	// Если место свободно, вставляем сюда new Block(x, null), у которого next = null и выходим из метода
    	if (array[hash] == null) array[hash] = new Block(copyCharArray(x), null);
    	else
    	{
    	// Вызываем search(x)
    	Block prev = search(array[hash], x);
    	   // Если такой х уже есть в списке коллизий, ничего не делаем
    	   if (prev != null) return;
    	   // Если такого нет, создаём новый блок и вставляем его в начало списка коллизий
    	   else
    	   {
    		   Block e = new Block(copyCharArray(x), array[hash]);
    		   array[hash] = e;
    	   }
    	}
    }

    // Удаляет элемент х из множества А
    public void Delete(char[] x)
    {
    	// Вызываем хеш-функцию, вычисляем индекс ячейки массива, в которой располагается значение
    	int hash = hashFunction(x);
    	// Проверяем совпадение с элементом непосредственно в ячейке, индекс которой получен из хеш-функции
    	if (compareCharArrays(array[hash].value, x))
    	{
    		// Если в ней искомый х,
  	        // Если нет коллизий
    		if (array[hash].next == null) 
    			{
    			array[hash] = null;
    			}
  	        // Иначе если список коллизий есть, вместо этого элемента вставляем в ячейку массива следующий за ним элемент
    		else 
    		{
    			array[hash] = array[hash].next;
    		}
    	}
    	// Если в ней не х, а next != null, вызываем search(), он возвращает ссылку на предыдущий элемент или null
    	else
    	{
    		Block prev = search(array[hash], x);
    	   // Если нашли совпадение (метод вернул не null), удаляем элемент
    	   if (prev != null) {
    		   // Если последний, присваиваем null в next предпоследнего
    		   // Если не последний, в next предыдущего записываем ссылку на следующий после элемента со значением х
    		   prev.next = prev.next.next;
    	   }
    	}
    }

    // Вывод словаря на экран
    public void Print(String name) {
        // Выводим в столбик непустые ячейки (если значение не равно пустому символьному массиву)
        System.out.println(" ");
        System.out.println(name);
        System.out.println(" ");
        for (int i = 0; i < array.length; i++)
        {
     	   if (array[i] != null)
     	   {
     		   Block e = array[i];
     		   System.out.print(i + ": ");
         	   while(e.next != null)
         	   {
         		   System.out.print(e.print() + "  ");
         		   e = e.next;   		   
         	   }
         	   System.out.println(e.print() + "  ");
     	   }
        }
        System.out.println("");
     }



}
