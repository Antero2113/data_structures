
public class Block {
   int value; // переменная для хранения числа
   Block next; // переменная для хранения ссылки на следующий блок

   // Конструктор по умолчанию
   public Block() {
    value = 0;
    next = null;
   }

   // Конструктор элемента по значению и ссылке на следующий
   public Block(int v, Block n) {
    value = v;
    next = n;
   }

   // Конструктор элемента по значению
   public Block(int x) {
       value = x;
       next = null;
      }
}