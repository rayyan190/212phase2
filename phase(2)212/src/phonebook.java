

public class phonebook {
	private LinkedList<event> eventList;
	private contactBST contactTree;
	
	public phonebook() {
		eventList = new LinkedList();
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
			System.out.println("can t' schedule becuase one or more  contacts not found");
                 return;}
		else {
			contact currentC;
			if(names.length==1 ) {  // appointment 
				 currentC=contactTree.CheckNameObj(names[0]);
			boolean conflict= isConflict(currentC, e);  
			if(conflict)
			return;
			else {
				eventList.addE(e);
				currentC.getEventList().addE(e);
				e.contactEvent.addC(currentC);
				System.out.println();
				System.out.println(" appointment scheduled successfuly");
			}
			}
	
			else  {
				boolean flags=false; 
				for(int i= 0;i<names.length;i++) { //cheking conflect
				currentC=contactTree.CheckNameObj(names[i]);
				if(isConflict(currentC, e))
				{  flags=false;
					return;}
				else flags=true;}
				if(flags) {
					System.out.println();
					System.out.println(" event will be sechedule  successfuly");
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
			System.out.println("Tree is empty."); 
			return;
		}
		else {
		LinkedList<event> list = new LinkedList<>();
		if(!contactTree.findkey(contactName)) {
			System.out.println();
			System.out.println("Contact does not exist."); 
			return;
		}
		
		list = contactTree.retrieve().getEventList();
		removeEventwithContact(contactName,list);
		if(contactTree.removeKey(contactName)) {
			System.out.println();
			System.out.println("Contact removed succefully. ");  
		         
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
					return;
				}
				else {
					System.out.println("Appointment is deleted. "); 
					return;
				}
				
				//System.out.println("Event/Appointment: "+eventTitle+" is deleted."); 
				
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
			 System.out.println("the Contact Tree is empty ");
		 }
		 else
			 contactTree.searchContacts(criteria);
	 }
	 
	 public void searchEvent(int criteria) {
		 if(eventList.empty()) {
			 System.out.println();
			 System.out.println("the Event List is empty ");
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
			 System.out.println("event is empty");
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
	 
	 
	 private  boolean Conflict(contact c,event e) {
		 if(c.eventList.empty()) 
			 return false;
				c.eventList.findFirst();
				while(!	c.eventList.last()) {
					if(!e.getDate().equalsIgnoreCase(c.eventList.retrieve().getDate()))
							return false;
					if(e.getDate().equalsIgnoreCase(c.eventList.retrieve().getDate())) {
						//if()
							//return true;
					}
					
					c.eventList.findNext();
				}
				if(!e.getDate().equalsIgnoreCase(c.eventList.retrieve().getDate()))
					return false;
				//if()
				//	return true;
				else
					return false;
					
             
	 }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 /*
	  * public void scheduleEvent(event e, String contactName) {
		boolean flag =false; ;
		LinkedList<String> l=new LinkedList<>();
		String [] names= contactName.split(",");
		for(int i= 0;i<names.length;i++) {
			l.addString(names[i]);
		}
		for(int i= 0;i<names.length;i++) {
			if(!contactTree.CheckName(names[i]))
				flag=false;
			
			else flag =true;
		}
		if(flag==false) {
			System.out.println("can t' schedule becuase contact not found");
                 return;}
		else {
		
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


			}}
		
	}
	  * 
	  * 
	  * 
	  * */
	 

}
