

public class phonebook {
	private eventLinkedList eventList;
	private contactBST contactTree;
	
	public phonebook() {
		eventList = new eventLinkedList();
		contactTree = new contactBST();
	}
	public void addContact(contact contact) {
		if(!contactTree.isContactUnique(contact))
			 System.out.println("Contact with the same name or phone number already exists.");
		else {
			
		}
	}
	
	public void removeContact(String contactName ) {
		
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
	 
	 public void scheduleEvent(event event) {
		 
	 }
	 
	 public void printContactsByFirstName(String firstName) {
		 
	 }
	 
	 public void printAllEventsAlphabetically() {
		 
	 }

}
