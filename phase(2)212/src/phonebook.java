

public class phonebook {
	private LinkedList<event> eventList;
	private contactBST contactTree;
	
	public phonebook() {
		eventList = new LinkedList<>();
		contactTree = new contactBST();
	}
	public void addContact(contact contact) {
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
	
	private boolean isConflict(contact c,event e) {
		if(c.eventList.empty()) {
			
                    return false;}
		else {
		
		c.eventList.findFirst();
		while(!c.eventList.last()) {
			if(e.getDate().equalsIgnoreCase(c.eventList.retrieve().getDate())&& e.getTime().equalsIgnoreCase(c.eventList.retrieve().getTime())) {
				System.out.println();
				System.out.println("there is conflict ");
				return true;
			}
			c.eventList.findNext();
		}
		if(e.getDate().equalsIgnoreCase(c.eventList.retrieve().getDate())&& e.getTime().equalsIgnoreCase(c.eventList.retrieve().getTime())) {
			System.out.println();
			System.out.println("there is conflict ");
			return true;}
		
		else return false;

	}}
	public void scheduleEvent(event e, String contactName) {
		boolean flag =false; ;
		String [] names= contactName.split(",");
		
		for(int i= 0;i<names.length;i++) {
			if(contactTree.CheckName(names[i]))
				flag=true;
			
			else flag =false;
		}
		if(flag==false) {
			System.out.println();
			System.out.println("Can t' schedule becuase one or more  contacts not found");
                 return;}
		else {
			contact currentC;
			if(names.length==1 ) {  // appointment or event with one contact
				 currentC=contactTree.CheckNameObj(names[0]);
			boolean conflict= isConflict(currentC, e);  
			if(conflict)
			return;
			else {
				eventList.addE(e);
				currentC.getEventList().addE(e);
				e.contactEvent.addC(currentC);
				System.out.println();
				if(e.isEvent==false)
					System.out.println("Appointment scheduled successfuly");
					else
					System.out.println("Event scheduled successfuly");
				
			}
			}
	
			else  {
				boolean flags=false; 
				for(int i= 0;i<names.length;i++) { //checking conflict
				currentC=contactTree.CheckNameObj(names[i]);
				if(isConflict(currentC, e))
				{  flags=false;
					return;}
				else flags=true;}
				if(flags) {
					System.out.println();
					System.out.println("Event secheduled successfuly");
				}
				for(int i= 0;i<names.length;i++) { // scheduling
					currentC=contactTree.CheckNameObj(names[i]);
					currentC.getEventList().addE(e);
					e.contactEvent.addC(currentC);
					
					}
				    eventList.addE(e);

				}
				
			}
			
			
		}
		
		
		
		
	
	
	public void removeContact(String contactName ) {
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
			System.out.println("event dose not exist.");  
		}
		
	
		
		
	}
	
	 
	public void searchContacts(int criteria) {
		 if(contactTree.empty()) {
			 System.out.println();
			 System.out.println("Contact tree is empty ");
		 }
		 else
			 contactTree.searchContacts(criteria);
	 }
	 
	 public void searchEvent(int criteria) {
		 if(eventList.empty()) {
			 System.out.println();
			 System.out.println("Event list is empty ");
		 }
		 else {
			 eventList.searchEvent(criteria);
		 }
	 }
	 
	 
	 
	 public void printContactsByFirstName(String firstName) {
		 contactTree.printByFirstName(firstName);
		 
	 }
    
	 
	 public void printAllEventsAlphabetically() {
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
