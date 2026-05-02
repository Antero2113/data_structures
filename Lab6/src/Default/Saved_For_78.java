package Default;

public class Saved_For_78 {

}

//
////Класс частично упорядоченного множества
//class PartiallyOrderedSet {
//private Element head; // начало списка, реализующего множество
//private Element sorted_head; // начало отсортированного множества
//private int ElementCount;
//
//// Класс элемента списка
//private class Element {
//   protected int value; // численное значение
//   protected Element next; // следующий элемент списка
//   protected int inDegree; // кол-во входящих связей
//   protected OutLink outLinks; // ссылка на первую исходящую связь
//   
//   // Конструктор (передаётся значение)
//   Element(int value) {
//       this.value = value;
//       this.next = null;
//       this.inDegree = 0;
//       this.outLinks = null;
//   }
//}
//
//// Класс исходящей связи элемента множества
//private class OutLink {
//	protected Element target; // ссылка на элемент, которому текущий предшествует
//	protected OutLink next; // ссылка на следующую связь (если есть)
//   
//	// Конструктор (передаётся элемент для связи, следующая связь null)
//   OutLink(Element target) {
//       this.target = target;
//       this.next = null;
//   }
//}
//
//// Метод для инициализации частично упорядоченного множества
//public boolean initialize(int[][] pairs) {
//	// инициализируем начало списка 
//	// если инициализация не пройдёт, мы получим null
//   head = null;
//   ElementCount = 0;
//   
//   // Для каждой пары
//   for (int i = 0; i < pairs.length; i++) {
//   	// Если нарушено условие иррефлексивности
//       if (pairs[i][0] == pairs[i][1]) {
//       	// Обнуляем все ранее полученные пары
//           head = null;
//           return false;
//       }
//       // Пробуем добавить новые элементы (если какое-то значение уже было добавлено,
//          // мы получим ссылку на него, иначе на новый элемент)
//       Element from = findOrCreateElement(this.head, pairs[i][0]);
//       Element to = findOrCreateElement(this.head, pairs[i][1]);
//       
//       // Добавим связь между элементами
//       addLink(from, to);
//   }
//   return true;
//}
//
//// Метод для добавления связи
//// Получает на вход ссылки на 2 элемента
//private void addLink(Element from, Element to) {
//	// Создаём новый объект исходящей связи, передавая to
//   OutLink newLink = new OutLink(to);
//   
//   // Если ранее связей не было
//   if (from.outLinks == null) {
//   	// оздаём первую исходящую связь для from
//       from.outLinks = newLink;
//   } else {
//   	// Если раньше уже были добавлены исходящие связи
//   	// Вставляем новую связь в начало списка исходящих связей
//       newLink.next = from.outLinks;
//       from.outLinks = newLink;
//   }
//   // Для второго переданного элемента увеличиваем счётчик входящих связей
//   to.inDegree++;
//}
//
//// Вспомогательный метод для добавления элемента или получения ссылки на существующий
//private Element findOrCreateElement(Element head, int value) {
//	// Пытаемся найти значение среди имеющихся элементов
//   Element element = findElement(value);
//   // Если такого не было, добавляем его в начало списка
//   if (element == null) {
//       element = new Element(value);
//       element.next = head;
//       head = element;
//       ElementCount++;
//   }
//   // Если нашли существующее, возвращаем ссылку на него
//   return element;
//}
//
//// Вспомогательный метод для поиска значения в множестве
//private Element findElement(int value) {
//   Element current = head;
//   // С головы проходим по всему списку
//   while (current != null) {
//   	// Если элемент нашли, возвращаем ссылку на него
//       if (current.value == value) {
//           return current;
//       }
//       current = current.next;
//   }
//   // Если такого значения не было, возвращаем null
//   return null;
//}
//
//// Метод топологической сортировки
//public boolean topologicalSort() {
//	// Если список пуст, сортировка невозможна
//   if (head == null) {
//       return false;
//   }
//   
//   // Пока есть элементы с inDegree нулевым
//     // Извлекаем из очереди, мотаем дальше
//   Element current;
//   OutLink outLink;
//   Element target;
//   for (int i = ElementCount; i > 0; i--)
//   {
//   	current = head;
//   	while (current != null)
//   	{
//   		outLink = current.outLinks;
//   		if(current.inDegree == 0)
//   		{
//   			while(outLink != null)
//   			{
//   				findOrCreateElement(sorted_head, current.value);
//   				target = outLink.target;
//                   // Уменьшаем кол-во входящих связей
//                   target.inDegree--;
//                   outLink = outLink.next;
//   			}
//   			ElementCount--;
//   			break;
//   		}
//   		current = current.next;
//   	}
//   }
//   // Проверяем, что все значения удалось добавить в упорядоченное множество, циклов нет
//   return ElementCount == 0;
//}
//
//public void printSortedOrder() {
//	Element current = sorted_head;
//   System.out.print("Топологический порядок: ");
//   while (current != null) {
//       System.out.print(current.value + " ");
//       current = current.next;
//   }
//   System.out.println();
//}
//}
