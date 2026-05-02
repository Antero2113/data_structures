package Linked;

public class Element {
    // Объявляем 2 переменные для хранения самого значения и ссылки на следующий элемент
	public Post values;
	public Position next;
	
	public Element(){

	}

	public Element(Post values, Position p){
		// Записываем передаваемые значения в наши переменные
		this.values = values;
		this.next = p;
		//if (p == null) next = null;
		//else next = p;
	}
	
	public boolean Equals(Element elem) {
		return this.values.Equals(elem.values);
	}
}
