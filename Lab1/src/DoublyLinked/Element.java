package DoublyLinked;

import Linked.Element;

public class Element {
    // Объявляем 2 переменные для хранения самого значения и положения блока
	public Post values;
	public Position place = new Position();
	
	public Element()
	{
		
	}
	
	// Копирующий конструктор
	public Element(Element e){
		// Записываем передаваемые значения в наши переменные
		this.values = e.values;
		this.place.next = e.place.next;
		this.place.prev = e.place.prev;
	}

	public Element(Post values, Position p){
		// Записываем передаваемые значения в наши переменные
		this.values = values;
		this.place.next = p.next;
		this.place.prev = p.prev;
	}
	
	public boolean Equals(Element elem) {
		return this.values.Equals(elem.values);
	}
}
