package DoublyLinked;

public class Position {	

    public Element next; // переменная для хранения адреса следующей пары значение-позиция
    public Element prev; // переменная для хранения адреса предыдущей пары значение-позиция
    
    public Position() {
    	next = null;
    	prev = null;
    }
    
    public Position(Element next, Element prev) {
    	this.next = next; // записываем передаваемую ссылку
    	this.prev = prev; // записываем передаваемую ссылку
    }

}
