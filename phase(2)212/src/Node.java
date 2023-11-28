
public class Node<T> {
	public T data;
    public Node next;
    public Node() {
        data =null;
        next=null;
    }
    public Node(T val) {
        data =val;
        next=null;
    }
    public void setData(T data) {
        this.data = data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public T getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
	

}
