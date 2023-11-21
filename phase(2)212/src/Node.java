
public class Node {
	public event data;
    public Node next;
    public Node() {
        data =null;
        next=null;
    }
    public Node(event val) {
        data =val;
        next=null;
    }
    public void setData(event data) {
        this.data = data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public event getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
	

}
