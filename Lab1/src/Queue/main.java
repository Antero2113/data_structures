package Queue;

//import Queue_array.Queue;
//import Queue_linked.Queue;
import Queue_ATD.Queue;

public class main {

	public static void main(String[] args) {
		
		Queue q = new Queue();
		q.EnQueque(1);
		q.EnQueque(2);
		q.EnQueque(3);
		q.EnQueque(4);
		q.EnQueque(5);
		q.PrintQueue();
		System.out.println("Из начала очереди извлечено значение: " + q.DeQueque() + "\n");
		q.PrintQueue();

	}

}
