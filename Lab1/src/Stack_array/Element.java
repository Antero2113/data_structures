package Stack_array;

public class Element {
    int value;
    
    // Конструктор для передаваемого значения
    public Element(int x)
    {
    	this.value = x;
    }
    
    // Копирующий конструктор
    public Element(Element x)
    {
    	this.value = x.value;
    }
    
    // Пустой конструктор
    public Element()
    {
    	
    }
}
