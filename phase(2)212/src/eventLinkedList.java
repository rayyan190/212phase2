import java.util.Scanner;



public class eventLinkedList {
	
	private Node head;
	private Node current;
	public eventLinkedList() {
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
	public event retrieve( ) {
		return current.data;

	}
	public void update(event e) {
		current.data = e;
	}
	
	public void add (event e) {
		Node  tmp;
		if(empty())
			current =head =new Node(e);  // if empty --> first element
		
		else {
		 tmp =current.next;                 // else add it after current 
		 current.next=new Node(e);
		 current =current.next;
		 current.next=tmp;}  
		
		
		
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
	   		 current.getData().PrintEvent();
	   		 current=current.next;
	   	 }

			
		}
	 
	 public eventLinkedList searchByContactName(String contactname){
	    	boolean flag = false;
	    	eventLinkedList L =new eventLinkedList();
			 Node current = head;
			 while(current!=null) {
				 if( current.getData().getContactName().equalsIgnoreCase(contactname)) {
					 L.add(current.data);
					 System.out.println("Event found!"); 
					  current.getData().PrintEvent();
					 flag = true;
				 }
				 current = current.next;
			 }
			 if(flag==false)
				 System.out.println("Event Not found!"); 
			 return L;
		 }
	 
	 public eventLinkedList searchByEventTitle(String Eventtittle){
	    	boolean flag = false;
	    	eventLinkedList L =new eventLinkedList();
			 Node current = head;
			 while(current!=null) {
				 if(current.getData().getEventTitle().equalsIgnoreCase(Eventtittle)) {
					 L.add(current.data);
					 System.out.println("Event found!"); 
					current.getData().PrintEvent();
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
	
	

}
