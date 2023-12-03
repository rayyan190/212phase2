

public class event implements Comparable<event> {

	 private String eventTitle;
	 private String ContactName;
	 private String date;
	 private String Time;
	 private String location;    
	   

	 
	 public boolean isEvent=true;
	 
	 public LinkedList<contact> contactEvent;

	 
	 
	 
	 
	public event(String eventTitle, String contactName, String date, String time, String location) {
		this.eventTitle = eventTitle;
		ContactName = contactName;
		this.date = date;
		Time = time;
		this.location = location;
		contactEvent= new LinkedList<contact>();
	}
	
	 public event() {
		 eventTitle="";
		 ContactName="";
		 date="";
		 location="";
		 isEvent = true;  
		 Time="";
		 contactEvent = new LinkedList<contact> ();  
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public boolean isEvent() {
		return isEvent;
	}
	public void setEvent(boolean isEvent) {
		this.isEvent = isEvent;
	}
	public LinkedList<contact> getContactEvent() {
		return contactEvent;
	}
	public void setContactEvent(LinkedList<contact> contactEvent) {
		this.contactEvent = contactEvent;
	}
	
	
	 public  int compareTo(event e) {
			return getEventTitle().compareTo(e.eventTitle);
		}
	
	 
	 public void PrintEvent() {
		 if(isEvent==true) {
			 System.out.println("Event title: "+eventTitle); 
		     System.out.println("Contacts Name: "+ContactName); 
		     System.out.println("Date : "+date); 
		     System.out.println("Time: "+Time );
			 System.out.println("Location: "+location );
			 
		 }
		 else {
			 System.out.println("Appointment title: "+eventTitle); 
		     System.out.println("Contact Name: "+ContactName); 
		     System.out.println("Date : "+date); 
		     System.out.println("Time: "+Time );
			 System.out.println("Location: "+location );
			 
		 }
		

	 }
	

}
