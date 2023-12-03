import java.util.Scanner;
/*

CLASS: LinkedList.java

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


public class LinkedList<T>  {
	
	public Node <T>head;
	private Node<T> current;
	public LinkedList() {
		head =current=null;
	}
	public boolean empty () {
		return head==null;
	}
	
	public boolean last() {
		return current.next==null;
	}
	public boolean full() {
		return false;
	}
	public void findFirst() {
		current =head;
	}
	public void findNext() {
		current=current.next;
	}
	public T retrieve( ) {
		return current.data;

	}
	public void update(T e) {
		current.data = e;
	}
	
	public void addE (event e) {
		Node  tmp=new Node(e);
		if(empty())
			current =head =new Node(e);  // if empty --> first element
		
		else {
			if(e.compareTo((event) head.data)<0) {
		 tmp.next =head;                // else add it after current 
		 head=tmp;
		 return;         }
			else {
				Node t=head;
				Node y=null;
				while(t!=null && ((event) t.data).compareTo(e) <=0) {
					y=t;
					t=t.next;
				}
				y.next=tmp;
				tmp.next=t;
				
			}
			
		}
		
		
		
	}
	public void addC (contact c) {
		Node  tmp=new Node(c);
		if(empty())
			current =head =new Node(c);  // if empty --> first element
		
		else {
			if(c.compareTo( (contact) head.data)<0) {
		 tmp.next =head;                // else add it after current 
		 head=tmp;
		 return;         }
			else {
				Node<T> p=head;
				Node<T> q=null;
				while(p!=null && ( (contact) p.data).compareTo(c) <=0) {
					q=p;
					p=p.next;
				}
				q.next=tmp;
				tmp.next=p;
				
			}
			
		}
		
		
		
	}
	
	public void remove () {         
		if (current == head) {      // just one element 
			head = head.next;
		}
		else {
			Node<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)      // set the current to head because to the the next is null
			current = head;
		else
			current = current.next;
	}
	
	 public void PrintEvents() {
	   	 Node<T> current = head;
	   	 while (current != null) {
	   		 ((event) current.getData()).PrintEvent();
	   		System.out.println();
	   		 current=current.next;
	   	 }

			
		}
	 
	 public void searchByContactName(String contactname){
	    	boolean flag = false;
	    	
			 Node<T> current = head;
			 while(current!=null) {
				 if( ((event) current.getData()).getContactName().equalsIgnoreCase(contactname)) {
					
					 System.out.println("Found!"); 
					 System.out.println(); 
					  ((event) current.getData()).PrintEvent();
					 flag = true;
				 }
				 current = current.next;
			 }
			 if(flag==false)
				 System.out.println("Not Found!"); 
			 
		 }
	 
	 public void searchByEventTitle(String Eventtittle){
	    	boolean flag = false;
	    	
			 Node<T> current = head;
			 while(current!=null) {
				 if(((event) current.getData()).getEventTitle().equalsIgnoreCase(Eventtittle)) {
					 System.out.println("Found!"); 
					 System.out.println(); 
					((event) current.getData()).PrintEvent();
					 flag = true;
				 }			 
				 current = current.next;
			 }
			 if(flag==false)
				 System.out.println("Found!");
			
		 }
	 
	 public void searchEvent(int criteria) {           // receive the way of searching then implement it
		 Scanner input = new Scanner(System.in);
		 if(criteria==1) {
			 System.out.println();
			 System.out.println("Enter the contact Name:");  
			 String contactName = input.nextLine();
			 searchByContactName(contactName);
		 }
		 else if(criteria==2) {
			 System.out.println();
			 System.out.println("Enter the event title:");  
			 String EventTitle = input.nextLine();
			 searchByEventTitle(EventTitle);
		 }
	 }
	 
	
	
	 public event findTitle(String Eventtittle){
	    	
	    	event t=null;
			 Node<T> current = head;
			 while(current!=null) {
				 if(((event) current.getData()).getEventTitle().equalsIgnoreCase(Eventtittle)) {
					 t = ((event) current.getData());
					 
				 }			 
				 current = current.next;
			 }
			
				
			 return t;
		 }
	
	 
	 
	
	
	

}
