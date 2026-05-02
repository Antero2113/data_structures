package Linked;

public class Post {
    private char[] name;
    private char[] address; 
    
    public Post(String name, String address) {
    	this.name = new char[20];
    	this.address = new char[50];
    	int n = 20;
    	int m = 50;
    	if (name.length() < 20) n = name.length();
    	for (int i = 0; i<n; i++) {
    		this.name[i] = name.charAt(i);
    	}
    	if (address.length() < 50) m = address.length();
    	for (int i = 0; i<m; i++) {
    		this.address[i] = address.charAt(i);
    	}
    }
    
    // маркер пустого элемента
    
    // Копирующий конструктор для объекта Post
    public Post(Post values){
    	this.name = new char[20];
    	this.address = new char[50];
    	copyarray(values.name,this.name);
    	copyarray(values.address, this.address);
    }
    
    // Копирование из a в b, пока a не закончится
    private void copyarray(char[]a, char[]b) {
    	for (int i = 0; i < a.length; i++) {
    		b[i] = a[i];
    	}
    }
    
    public boolean Equals(Post post) {
    	// Метод вызывается на текущем Post из Element, в качестве аргумента передаётся искомый объект Post
    	// Проверить, что это не один и тот же объект, если один, вернуть true
    	// Если в name или address элементы не совпадают, сразу возвращаем false
    	// Если прошли до конца и всё совпало, возвращаем true
    	
    	// составное условие, пока не 0
    	
    	if (this == post) 
    		{
    		//System.out.println("один и тот же объект");
    		return true; // если один и тот же объект 
    		}
    	for (int i = 0; i<20; i++) {
    		if (this.name[i] != post.name[i]) 
    		{
    			//System.out.println("имена разные");
    			return false;
    		}
    	}
    	for (int i = 0; i<50; i++) {
    		//this.print();
    		//post.print();
    		if (this.address[i] != post.address[i]) 
    		{
    			//System.out.println("адреса разные");
    			return false;
    		}
    	}
    	return true;
    }
    
    // Перевести в строку и убрать нули
    public void print() {
    	System.out.print("name:");
    	for (int i = 0; i<=20; i++) {
    		if (this.name[i] == 0) break;
    		System.out.print(this.name[i]);
    	}
    	System.out.print(" address:");
    	for (int i = 0; i<=50; i++) {
    		if (this.address[i] == 0) break;
    		System.out.print(this.address[i]);
    	}
    }
}
