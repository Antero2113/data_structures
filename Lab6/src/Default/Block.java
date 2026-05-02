package Default;

public class Block {
	   public char[] value; // переменная для хранения числа
	   public Block next; // переменная для хранения ссылки на следующий блок

	   // Конструктор по умолчанию
	   public Block() {
	    value = new char[0];
	    next = null;
	   }

	   // Конструктор элемента по значению и ссылке на следующий
	   public Block(char[] v, Block n) {
	    value = v;
	    next = n;
	   }

	   // Копирующий конструктор
	   public Block(Block x) {
	       value = x.value;
	       next = x.next;
	      }
	   public String print() {
		   return new String(value);
	   }
	}

