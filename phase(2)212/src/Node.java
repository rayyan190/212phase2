/*

CLASS: Node.java

CSC212 Data structures - Project phase 2

Fall 2023

EDIT DATE:

3-12-2023

TEAM:

team name: my technology.

AUTHORS:
Rayan Alghamdi. id:443102225
Mohammed Aleidi.id:443102416



*/
public class Node<T> {
	public T data;
    public Node<T> next;
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
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public T getData() {
        return data;
    }
    public Node<T> getNext() {
        return next;
    }
	

}
