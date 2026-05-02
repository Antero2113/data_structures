package Map;

import Map_linked_list.Map;
import Map_linked_list.Link_value;

public class main {

	public static void main(String[] args) {
		
		// Создаём новое отображение
		Map m = new Map();
		m.Assign(1, 2);
		m.Assign(2, 3);
		m.Assign(2, 6);
		m.Assign(4, 2);
		m.Assign(1, 7);
		m.PrintMap();
		
		Link_value founded_value = new Link_value();
		int key = 2;
		if (m.Compute(key, founded_value))
		{
			System.out.println("По заданному ключу " + key + " найдено значение: " + founded_value.i);
		}

	}

}


