package Stack_linked;

public class Element {
    int value;
    Element next;
    
    // Конструктор для передаваемого значения
    public Element(int x, Element e)
    {
    	this.value = x;
    	this.next = e;
    }
    
    // Копирующий конструктор
    public Element(Element x)
    {
    	this.value = x.value;
    	this.next = x.next;
    }
    
    // Пустой конструктор
    public Element()
    {
    	
    }
}
