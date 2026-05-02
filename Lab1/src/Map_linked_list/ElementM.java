package Map_linked_list;

public class ElementM {
	int key;
	int value;
    ElementM next;
    
    public ElementM()
    {
    	
    }
    
    public ElementM(int d, int r, ElementM e)
    {
    	this.key = d;
    	this.value = r;
    	this.next = e;
    }
}
