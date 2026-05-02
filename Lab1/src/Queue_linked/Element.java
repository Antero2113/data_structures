package Queue_linked;

public class Element {
	public int value;
	public Element next;
	
	public Element(int x, Element e)
	{
		this.value = x;
		this.next = e;
	}
	
	public Element()
	{
	}
	
	public Element(Element x)
	{
		this.value = x.value;
		this.next = x.next;
	}

}
