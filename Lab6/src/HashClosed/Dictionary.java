package HashClosed;
import Default.Block;

public class Dictionary {
    Block[] array; // массив классов множества
    static int B = 25; // переменная задающая количество классов
    static char[] t = {'0'};

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

    // Возвращает позицию, в которой расположен искомый массив
    private int searchPosition(char[] x)
    {
    	// Вызываем хеш-функцию для х
    	int sum = sum(x);
    	int num = 0;
    	int hash = hashFunction(sum, num);
    	// Переходим к ячейке массива с полученным индексом
    	   // Если в ней пусто, возвращаем -1
    	if (array[hash] == null) return -1;
    	   // Если значение совпало с искомым, возвращаем эту позицию
    	else if (compareCharArrays(array[hash].value, x)) return hash;
    	   // Если значение не совпало, но ячейка не пуста, повторно вызываем хеш-функцию, но теперь с num+=1
    	else 
    	{
    		num+=1;
    		hash = hashFunction(sum, num);
    		while(array[hash] != null && hash != sum%B-1) {
    		    // Аналогично проверяем значение и вызываем хеш-функцию с num+=1,
    		  	// пока либо не найдётся совпадения (тогда мы вернём эту позицию)
    			if (compareCharArrays(array[hash].value, x)) return hash;
    			num+=1;
    			hash = hashFunction(sum, num);
    		}
    		// либо совпадений не будет - вернём -1
    		return -1;
    	}
    }

    // Имеет аргументами множество А и объект х того же типа, что и элементы множества А,
    // и возвращает булево значение true (истина), если х принадлежит А, и значение false (ложь),
    // если х не принадлежит A
    public boolean Member(char[] x)
    {
    	//System.out.println(searchPosition(x));
    	// Можно поиск использовать
    	return (searchPosition(x) != -1);

    	// Если х пустой символьный массив, возвращаем false
    	// Вызываем хеш-функцию для определения позиции hashFunction(x, num)
    	   // Проверяем совпадает ли значение с переданным в метод
    	      // Если да, возвращаем true
    	      // Если нет, num += 1 и повторяем проверку с новой полученной позицией
    	   // Так проделываем, пока не окажемся в свободной позиции
    	   // (именно свободной! если значние было удалено, мы идём дальше, пока не дойдём до свободной)
    	// Если так и не нашли совпадения, возвращаем false
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
    
    // Отдельно подсчёт суммы кодов символов, а для хеширования одна функция с num от 0
    private int sum(char[] x) {
    	// Сумма кодов символов, составляющих имя
    	int sum = 0;
        for (char c : x) {
            sum += (int) c; // Преобразуем символ в его ASCII-код и добавляем к сумме
        }
        return sum;
    }

    // Вычисляет индекс ячейки массива, в которую будут записаны данные
    // В параметрах передаётся номер хэширования и символьный массив
    private int hashFunction(int sum, int num)
    {
    	// Корректируем сумму в зависимости от num
    	sum += num;
    	
    	// Эту сумму поделить на количество разбиений/сегментов B (поиск остатка от деления)
    	// Результат - значение от 0 до B-1
        return sum%B;
    }

    // Делает х элементом множества А
    public void Insert(char[] x)
    {
    	//System.out.println("Результат поиска:" + searchPosition(x));
    	// Проверка, что значение есть
        if (searchPosition(x)!=-1) return;
    	// При вставке вызываем хеш-функцию, передавая x
        int sum = sum(x);
        //System.out.println("Сумма: " + sum);
    	int num = 0;
    	int hash = hashFunction(sum, num);
    	int free = -1;
    	// Получаем элемент массива по индексу, который вернула хэш-функция
    	// Если место свободно, вставляем сюда new Block(x, null), у которого next = null
    	if (array[hash] == null) 
    	{
    		array[hash] = new Block(copyCharArray(x), null);
    	}
    	// Если место занято, повторно вызываем хеш-функцию (num += 1 ), получаем новый индекс
    	else {
    		hash = hashFunction(sum, num++);
    		//System.out.println("Зашли в занятое место");
    		
    		while (hash != sum%B-1) 
    		{
    			//System.out.println("Попытка в " + hash);
    			// Пробуем вставить в полученный индекс
    			if (array[hash] == null) 
    			{
    				array[hash] = new Block(copyCharArray(x), null);
    				//System.out.println("Вставили в " + hash);
    				return;
    			}
    			// Если в процессе встречаем ячейку с терминальным элементом (то есть ранее удалённое значение),
    			if (free != -1 || compareCharArrays(array[hash].value, t)) free = hash;
	    	         // сохраняем на него ссылку, чтобы вставить при отсутствии свободных
    			
    			// Если снова занято, вызываем хеш-функцию (num += 1)
    			hash = hashFunction(sum, num++);
	    	    // Повторяем это, пока продолжаем попадать на занятые ячейки
    		}
    		// Если так до конца списка, кроме ячейки с терминальным элементом, свободных и не было, вставляем
  	        // на сохранённое место ранее удалённого значения
    		if (free != -1)
    		{
    			array[free] = new Block(copyCharArray(x), null);
    			//System.out.println("В ранее удалённую " + hash);
    		}
    		// Если не было ни свободных, ни освободившихся в результате удаления,
  	        // а мы вернулись к ячейке, с которой начинали, просто не вставляем
    	}
    }

    // Удаляет элемент х из множества А
    public void Delete(char[] x)
    {
    	// Вызываем searchPosition() и, если он вернул не -1, заменяем значение в возвращённой позиции
    	   // на терминальный элемент
    	// Иначе просто выходим
    	int position = searchPosition(x);
    	if (position != -1) array[position].value = t;
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
     		   System.out.println(i + ": " + array[i].print() + " " + sum(array[i].value));
     	   }
        }
        System.out.println("");
     }
}
