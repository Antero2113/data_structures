package Array;

public class Position {
    public int p; // переменная для хранения позиции, число
    
    public Position() {
    	this.p = 0; // записываем передаваемое значение
    }
    
    public Position(int p) {
    	this.p = p; // записываем передаваемое значение
    }
    
    public Position(Position p) {
    	this.p = p.p; // записываем передаваемое значение
    }
    
}
