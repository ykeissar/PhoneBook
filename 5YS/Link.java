public class Link<T> {
	
	private T data;
	private Link next;
	
	public Link(T data, Link next){
	    this.data = data;
	    this.next = next;
	}
	public Link(T data){
	    this(data, null);
	}
	
	public T getData(){
		return data;
	}
	
	public T setData(T data){
		T tmp = this.data;
		this.data = data; 
		return tmp;
	}
	
	public Link getNext(){
		return next;
	}
	
	public void setNext(Link next){
		this.next = next;
	}
	
        @Override
	public String toString(){ 
		return data.toString();
	}
	
        @Override
   	public boolean equals(Object other){
   		return data.equals(((Link)other).getData());
   	}

}
