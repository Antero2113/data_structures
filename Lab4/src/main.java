
import java.util.Random;

public class main {
	
	public static void main(String[] args) {
		
		// Создание очереди с приоритетами
		PriorityQueue q = new PriorityQueue();
		
		// Заполнение рандомными значениями от 1 до 10
		System.out.println("Заполнение очереди");
		Random random = new Random();
		for(int i = 0; i < 10; i++)
		{
			q.Insert(random.nextInt(10) + 1);
			// Выводим очередь на печать
			q.Print();
		}
		System.out.println("");
		
		// Удаляем минимальное значение из очереди
		System.out.println("Удаление минимального значения");
		int min = q.DeleteMin();
		System.out.println("Минимальное значение очереди: " + min);
		// Выводим очередь на печать
		q.Print();
		System.out.println("");
	}
}
