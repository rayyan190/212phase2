import java.util.Scanner;



public class LinkedList<T>  {
	
	private Node <T>head;
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
	public void addC (contact e) {
		Node  tmp=new Node(e);
		if(empty())
			current =head =new Node(e);  // if empty --> first element
		
		else {
			if(e.compareTo( (contact) head.data)<0) {
		 tmp.next =head;                // else add it after current 
		 head=tmp;
		 return;         }
			else {
				Node t=head;
				Node y=null;
				while(t!=null && ( (contact) t.data).compareTo(e) <=0) {
					y=t;
					t=t.next;
				}
				y.next=tmp;
				tmp.next=t;
				
			}
			
		}
		
		
		
	}
	
	public void remove () {         
		if (current == head) {      // just one element 
			head = head.next;
		}
		else {
			Node tmp = head;

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
	   	 Node current = head;
	   	 while (current != null) {
	   		 ((event) current.getData()).PrintEvent();
	   		 current=current.next;
	   	 }

			
		}
	 
	 public LinkedList searchByContactName(String contactname){
	    	boolean flag = false;
	    	LinkedList L =new LinkedList();
			 Node current = head;
			 while(current!=null) {
				 if( ((event) current.getData()).getContactName().equalsIgnoreCase(contactname)) {
					 L.addE((event) current.data);
					 System.out.println("Event found!"); 
					  ((event) current.getData()).PrintEvent();
					 flag = true;
				 }
				 current = current.next;
			 }
			 if(flag==false)
				 System.out.println("Event Not found!"); 
			 return L;
		 }
	 
	 public LinkedList searchByEventTitle(String Eventtittle){
	    	boolean flag = false;
	    	LinkedList L =new LinkedList();
			 Node current = head;
			 while(current!=null) {
				 if(((event) current.getData()).getEventTitle().equalsIgnoreCase(Eventtittle)) {
					 L.addE((event) current.data);
					 System.out.println("Event found!"); 
					((event) current.getData()).PrintEvent();
					 flag = true;
				 }			 
				 current = current.next;
			 }
			 if(flag==false)
				 System.out.println("Event Not found!");
			 return L;
		 }
	 
	 public void searchEvent(int criteria) {           // receive the way of searching then implement it
		 Scanner input = new Scanner(System.in);
		 if(criteria==1) {
			 System.out.println("Enter the contact's Name:");  
			 String contactName = input.nextLine();
			 searchByContactName(contactName);
		 }
		 else if(criteria==2) {
			 System.out.println("Enter the event title:");  
			 String EventTitle = input.nextLine();
			 searchByEventTitle(EventTitle);
		 }
	 }
	 
	 public LinkedList<contact> searchByTitle(String Eventtittle){
	    	
	    	LinkedList<contact> L =new LinkedList();
			 Node current = head;
			 while(current!=null) {
				 if(((event) current.getData()).getEventTitle().equalsIgnoreCase(Eventtittle)) {
					 L = ((event) current.getData()).getContactEvent();
					 
				 }			 
				 current = current.next;
			 }
			
				
			 return L;
		 }
	 
	 public void addString (T e) {
	        Node <T> tmp;
	        if(empty())
	            current =head =new Node<T>(e);  // if empty --> first element

	        else {
	         tmp =current.next;                 // else add it after current 
	         current.next=new Node<T>(e);
	         current =current.next;
	         current.next=tmp;}



	    }
	 
	
	
	

}
