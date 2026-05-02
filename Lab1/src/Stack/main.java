package Stack;

//import Stack_array.Stack;
//import Stack_linked.Stack;
import Stack_ATD.Stack;

public class main {

	public static void main(String[] args) {
		
		// Создание объекта стека
		Stack s = new Stack();
		// Добавление поочерёдно символов в стек
		s.PUSH(1);
		s.PrintStack();
		s.PUSH(2);
		s.PrintStack();
		s.PUSH(3);
		s.PrintStack();
		s.PUSH(4);
		s.PrintStack();
		s.PUSH(5);
		s.PrintStack();
		s.PUSH(6);
		s.PrintStack();
		s.POP();
		s.PrintStack();
		System.out.println("Значение вершины стека: " + s.TOP());
		System.out.println("");
		s.MAKENULL();
		s.PrintStack();
	}

}
