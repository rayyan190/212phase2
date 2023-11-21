
public class event {

	 private String eventTitle;
	 private String ContactName;
	 private String dateTime;
	 private String location;
	 private String type;    

	 
	 public event(String eventTitle, String ContactName, String dateTime, String location) {
	  this.eventTitle = eventTitle;
	  this.ContactName = ContactName;
	  this.dateTime = dateTime;
	  this.location = location;
	  
	 }
	 
	 public event(event e) {
		  this.eventTitle = e.eventTitle;
		  this.ContactName = e.ContactName;
		  this.dateTime = e.dateTime;
		  this.location = e.location;
		 
	 }
	 public event() {
		 eventTitle="";
		 ContactName="";
		 dateTime="";
		 location="";
		 
	 }
	 public String getEventTitle() {
	  return eventTitle;
	 }
	 public void setEventTitle(String eventTitle) {
	  this.eventTitle = eventTitle;
	 }
	 public String getContactName() {
	  return ContactName;
	 }
	 public void setContactName(String contactName) {
	  ContactName = contactName;
	 }
	 public String getDateTime() {
	  return dateTime;
	 }
	 public void setDateTime(String dateTime) {
	  this.dateTime = dateTime;
	 }
	 public String getLocation() {
	  return location;
	 }
	 public void setLocation(String location) {
	  this.location = location;
	 }
	
	 
	 public void PrintEvent() {
		 System.out.println("Event title: "+eventTitle); 
	     System.out.println("Contact Name: "+ContactName); 
	     System.out.println("Date Time: "+dateTime); 
		 System.out.println("Location: "+location ); 
	 }
	

}
