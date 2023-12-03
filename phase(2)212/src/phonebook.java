/*

CLASS: phonebook.java

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

public class phonebook {
	private LinkedList<event> eventList;
	private contactBST contactTree;
	
	public phonebook() {
		eventList = new LinkedList<>();
		contactTree = new contactBST();
	}
	public void addContact(contact contact) { //bigO(n)
		if(!contactTree.isContactUnique(contact)) {
			System.out.println();       
			 System.out.println("Contact with the same name or phone number already exists.");
		}
		else {
			contactTree.insert(contact.getName(), contact);
			System.out.println();
				System.out.println("Contact inserted succefully");
			
			
		}
	}
	
	private boolean isConflict(contact c,event e) { //bigO(n)
		if(c.eventList.empty()) {
			
                    return false;}
		else {
		
		c.eventList.findFirst();
		while(!c.eventList.last()) {
			if(e.getDate().equalsIgnoreCase(c.eventList.retrieve().getDate())&& e.getTime().equalsIgnoreCase(c.eventList.retrieve().getTime())&&e.getContactName().equalsIgnoreCase(c.eventList.retrieve().getContactName())) {
				System.out.println();
				System.out.println("there is conflict ");
				return true;
			}
			c.eventList.findNext();
		}
		if(e.getDate().equalsIgnoreCase(c.eventList.retrieve().getDate())&& e.getTime().equalsIgnoreCase(c.eventList.retrieve().getTime())&&e.getContactName().equalsIgnoreCase(c.eventList.retrieve().getContactName())) {
			System.out.println();
			System.out.println("there is conflict ");
			return true;}
		
		else return false;

	}}
	public void scheduleEvent(event e, String contactName) { //big(n^2)
		boolean flag =false; ;//1
		String [] names= contactName.split(",");//n
		
		for(int i= 0;i<names.length;i++) {//n
			if(contactTree.CheckName(names[i]))//n^2-1
				flag=true;//n^2-2
			
			else flag =false;
		}
		if(flag==false) {
			System.out.println();//1
			System.out.println("Can t' schedule becuase one or more  contacts not found");//1
                 return;}
		else {
			contact currentC;//1
			if(names.length==1 ) {  // appointment or event with one contact//1
				 currentC=contactTree.CheckNameObj(names[0]);//n
			boolean conflict= isConflict(currentC, e);  //n
			if(conflict)//1
			return;
			else {
				eventList.addE(e);//n
				currentC.getEventList().addE(e);//n
				e.contactEvent.addC(currentC);//n
				System.out.println();//1
				if(e.isEvent==false)//1
					System.out.println("Appointment scheduled successfuly");//1
					else
					System.out.println("Event scheduled successfuly");//1
				
			}
			}
	
			else  {
				boolean flags=false; //1
				for(int i= 0;i<names.length;i++) { //checking conflict  n
				currentC=contactTree.CheckNameObj(names[i]);//n^2-1
				if(isConflict(currentC, e))//n^2-2
				{  flags=false;
					return;}
				else flags=true;}
				if(flags) {
					System.out.println();//1
					System.out.println("Event secheduled successfuly");//1
				}
				for(int i= 0;i<names.length;i++) { // scheduling   //n
					currentC=contactTree.CheckNameObj(names[i]);//n^2-1
					currentC.getEventList().addE(e);//n^2-1
					e.contactEvent.addC(currentC);//n^2-1
					
					}
				    eventList.addE(e);//n

				}
				
			}
			
			
		}
		
		
		
		
	
	
	public void removeContact(String contactName ) { ////bigO(n^2)
		if(contactTree.empty()) {
			System.out.println("Contact tree is empty."); 
			return;
		}
		else {
		LinkedList<event> list = new LinkedList<>();
		if(!contactTree.findkey(contactName)) {
			System.out.println();
			System.out.println("Contact not found in the tree."); 
			return;
		}
		
		list = contactTree.retrieve().getEventList();
		removeEventwithContact(contactName,list);
		if(contactTree.removeKey(contactName)) {
			System.out.println();
			System.out.println("Contact removed succefully.");  
		         
		}
		else {
			System.out.println();
			System.out.println("Contact removing failed."); 
		}
		}
		
		
	}
	private void removeEventwithContact(String name,LinkedList<event> list) {
		while(!list.empty()) {
			removeEvent(list.retrieve().getEventTitle(),name);
			list.remove();
		}
	}
	private void removeEvent(String eventTitle,String name) {
		LinkedList<contact> contactsEvent = getContactInEvent(eventTitle);
		while(!contactsEvent.empty()&&!contactsEvent.last()) {
			if(contactsEvent.retrieve().getName().equalsIgnoreCase(name)) {
				contactsEvent.remove();
				break;
			}
			contactsEvent.findNext();
		}
		if(!contactsEvent.empty()&&contactsEvent.retrieve().getName().equalsIgnoreCase(name))
			contactsEvent.remove();
		
		if(!contactsEvent.empty())
			return;
		
		if(eventList.empty()) {
			return;
		}
		
		
		eventList.findFirst();
		event e;
		while(!eventList.last()) {
			if(eventList.retrieve().getEventTitle().equalsIgnoreCase(eventTitle)) {
				e=eventList.retrieve();
				eventList.remove();
				System.out.println();
				if(e.isEvent==true) {
					System.out.println("Event is deleted. "); 
					
				}
				else {
					System.out.println("Appointment is deleted. "); 
					
				}
				return;
				
				
			}
			eventList.findNext();
		}
		
		if(eventList.retrieve().getEventTitle().equalsIgnoreCase(eventTitle)) {
			e=eventList.retrieve();
			eventList.remove();
			System.out.println();
			if(e.isEvent==true) {
				System.out.println("Event is deleted. "); 
			}
			else
				System.out.println("Appointment is deleted. "); 
			
			
			
		}
		
		
		else {
			System.out.println();
			System.out.println("event does not exist.");  
		}
		
	
		
		
	}
	
	 
	public void searchContacts(int criteria) {//bigO(n)
		 if(contactTree.empty()) {
			 System.out.println();
			 System.out.println("Contact tree is empty ");
		 }
		 else
			 contactTree.searchContacts(criteria);
	 }
	 
	 public void searchEvent(int criteria) {//bigO(n)
		 if(eventList.empty()) {
			 System.out.println();
			 System.out.println("Event list is empty ");
		 }
		 else {
			 eventList.searchEvent(criteria);
		 }
	 }
	 
	 
	 
	 public void printContactsByFirstName(String firstName) {//bigO(n)
		 contactTree.printByFirstName(firstName);
		 
	 }
    
	 
	 public void printAllEventsAlphabetically() {//bigO(n)
		 if(eventList.empty()) {
			 System.out.println("Event list is empty");
			 System.out.println();
		 }
		 
		 eventList.PrintEvents();
		 
	 }
	 
	
	 
	 public LinkedList<contact> getContactInEvent(String n){
		 event e = eventList.findTitle(n);
		 if(e!=null)
			 return e.getContactEvent();
		 return new LinkedList<contact>();
	 }
	 
	 
	
	

}
