package Linked;

public class Position {
    public Element p; // переменная для хранения адреса следующей пары значение-позиция
    
    public Position() {
    	this.p = null;
    }
    
    public Position(Element p) {
    	this.p = p; // записываем передаваемую ссылку
    }

}
