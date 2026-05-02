package Default;
import HashClosed.Dictionary;
import java.util.Random;

public class main {

	public static void main(String[] args) {


		// Создание множества goodguys
		Dictionary goodguys = new Dictionary();
		// Создание множества badguys
		Dictionary badguys = new Dictionary();
		
		init(goodguys);
		goodguys.Print("СЛОВАРЬ 1");
		badguys.Print("СЛОВАРЬ 2");
		
		char[] in = {'j','h','k'};
		char[] lin = {'h','j','k'};
		char[] in2 = {'j','h','k'};
		char[] lin2 = {'h','j','k'};
		goodguys.Insert(in);
		goodguys.Insert(lin);
		goodguys.Print("СЛОВАРЬ 1_ВСТАВИЛИ_1");
		
		goodguys.Delete(in2);
		goodguys.Delete(lin2);
		goodguys.Print("СЛОВАРЬ 1_УДАЛИЛИ");
		
		goodguys.Insert(in);
		goodguys.Insert(lin);
		goodguys.Print("СЛОВАРЬ 1_ВСТАВИЛИ_2");
		
		char[] not_in = {'l','h','k'};
		
		if (goodguys.Member(in)) System.out.println("Переданное значение есть в множестве goodguys.");
		else System.out.println("Переданного значения нет в множестве goodguys.");
		
		//Занесение значения в словарь 2
        //goodguys.Delete(in); // если значения нет, просто ничего не изменится
        badguys.Insert(lin);
        badguys.Insert(in);
        

		badguys.Print("СЛОВАРЬ 2");

		// Вывести - удалить 2 значения - добавить обратно (должны поменяться местами в закрытом)
		// Сами задаём, в какой список
		// Занесение - в одном удаляем, в другой помещаем

		// Подумать, вставлять в голову или в конец


	}
	public static void init(Dictionary d) {
		Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 20; i++)
		{
			char[] x = new char[8];
			for (int j = 0; j<8; j++)
			{
				x[j] = characters.charAt(random.nextInt(characters.length()));
			}
			
			d.Insert(x);
			System.out.println(" ");
		}
    }

}
