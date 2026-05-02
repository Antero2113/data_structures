package Cursors;

public class Position {

    public int index = -1; // переменная для хранения адреса следующей пары значение-позиция
    public Element next;
    
    public Position() {
    	
    }
    
    public Position(int i, Element p) {
    	this.next = p; // записываем передаваемую ссылку
    	this.index = i;
    }

}
