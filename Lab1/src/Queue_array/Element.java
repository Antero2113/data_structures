package Queue_array;

public class Element {
	int value;
	
	public Element(int x)
	{
		this.value = x;
	}
	
	public Element()
	{
	}
	
	public Element(Element x)
	{
		this.value = x.value;
	}

}
