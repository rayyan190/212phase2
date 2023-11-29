

public class phonebook {
	private LinkedList<event> eventList;
	private contactBST contactTree;
	
	public phonebook() {
		eventList = new LinkedList();
		contactTree = new contactBST();
	}
	public void addContact(contact contact) {
		if(!contactTree.isContactUnique(contact))
			 System.out.println("Contact with the same name or phone number already exists.");
		else {
			contactTree.insert(contact.getName(), contact);
				System.out.println("inserted succefully");
			
			
		}
	}
	
	private boolean isConflict(contact c,event e) {
		LinkedList<event> events=c.getEventList();
		if(events.empty())
			return false;
		events.findFirst();
		while(!events.last()) {
			if(e.getDate().equalsIgnoreCase(events.retrieve().getDate())&& e.getTime().equalsIgnoreCase(events.retrieve().getTime())) {
				System.out.println("there is conflict");
				return true;
			}
			events.findNext();
		}
		if(e.getDate().equalsIgnoreCase(events.retrieve().getDate())&& e.getTime().equalsIgnoreCase(events.retrieve().getTime())) {
			System.out.println("there is conflict");

			return true;}
		else return false;

	}
	public void scheduleEvent(event e, String contactName) {
		contact currentContact=contactTree.findName(contactName);
		if(currentContact==null) {
			System.out.println("can t' schedule becuase contact not found");
			return;}
		if(!e.isEvent) {  // appointment
			if(!e.contactEvent.empty()) 
		    System.out.println("can t' schedule becuase appointment is scheduled already ");
			return;
		}
			boolean conflict=isConflict(currentContact, e);
			if(currentContact!=null&& conflict) {
			System.out.println("no conflect ");
			currentContact.getEventList().addE(e);
			e.contactEvent.addC(currentContact);
			eventList.addE(e);
			

			}
			else {
				if(currentContact==null)
					System.out.println("can t' schedule becuase contact not found");
				if(conflict)
					System.out.println("can t' schedule becuase there is conflict");


			}
		
	}
	
	public void removeContact(String contactName ) {
		if(contactTree.empty()) {
			System.out.println("Tree is empty."); 
			return;
		}
		LinkedList<event> list = new LinkedList<>();
		if(!contactTree.findkey(contactName)) {
			System.out.println("Contact dose not exist."); 
			return;
		}
		list = contactTree.retrieve().getEventList();
		removeEventwithContact(contactName,list);
		if(contactTree.remove_key(contactName)) 
			System.out.println("Contact removed succefully.");  
		else
			System.out.println("Contact removing failed."); 
			
		
		
	}
	private void removeEventwithContact(String name,LinkedList<event> list) {
		while(!list.empty()) {
			removeEvent(list.retrieve().getEventTitle(),name);
			list.remove();
		}
	}
	private void removeEvent(String eventTitle,String name) {
		LinkedList<contact> contactsEvent = eventList.searchByTitle(eventTitle);
		while(!contactsEvent.empty()&&!contactsEvent.last()) {
			if(contactsEvent.retrieve().getName().equalsIgnoreCase(name)) {
				contactsEvent.remove();
				break;
			}
			contactsEvent.findNext();
		}
		if(!contactsEvent.empty()&&!contactsEvent.last())
			contactsEvent.remove();
		if(!contactsEvent.empty())
			return;
		if(eventList.empty()) {
			return;
		}
		eventList.findFirst();
		while(!eventList.last()) {
			if(eventList.retrieve().getEventTitle().equalsIgnoreCase(eventTitle)) {
				eventList.remove();
				System.out.println(eventTitle+" deleted."); 
				return;
			}
			eventList.findNext();
		}
		if(eventList.retrieve().getEventTitle().equalsIgnoreCase(eventTitle)) {
			eventList.remove();
			System.out.println(eventTitle+" deleted."); 
			return;
		}
		else
			System.out.println("event dose not exist.");  
		
		
	}
	
	 
	public void searchContacts(int criteria) {
		 if(contactTree.empty())
			 System.out.println("the Contact Tree is empty ");
		 else
			 contactTree.searchContacts(criteria);
	 }
	 
	 public void searchEvent(int criteria) {
		 if(eventList.empty())
			 System.out.println("the Event List is empty ");
		 else {
			 eventList.searchEvent(criteria);
		 }
	 }
	 
	 
	 
	 public void printContactsByFirstName(String firstName) {
		 contactTree.printByFirstName(firstName);
		 
	 }
    
	 
	 public void printAllEventsAlphabetically() {
		 if(eventList.empty())
			 System.out.println("event is empty");
		 
		 eventList.PrintEvents();
		 
	 }
	 

}
