import java.sql.Time;

public class event implements Comparable<event> {

	 private String eventTitle;
	 private String ContactName;
	 private String date;
	 private String Time;
	 private String location;    
	 private contactBST BST;
	 private String start,end;    

	 private Time st,en;
	 public boolean isEvent=true;
	 
	 public LinkedList<contact> contactEvent= new LinkedList<contact>();

	 
	 
	 
	 
	public event(String eventTitle, String contactName, String date, String time, String location) {
		this.eventTitle = eventTitle;
		ContactName = contactName;
		this.date = date;
		Time = time;
		this.location = location;
	}
	public String toString() {
		return "event [eventTitle=" + eventTitle + ", ContactName=" + ContactName + ", date=" + date + ", Time=" + Time
				+ ", location=" + location + "]";
	}
	public event(event e) {
		  this.eventTitle = e.eventTitle;
		  this.ContactName = e.ContactName;
		  this.date = e.date;
		  this.location = e.location;
		 
	 }
	 public event() {
		 eventTitle="";
		 ContactName="";
		 date="";
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
	public contactBST getBST() {
		return BST;
	}
	public void setBST(contactBST bST) {
		BST = bST;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Time getSt() {
		return st;
	}
	public void setSt(Time st) {
		this.st = st;
	}
	public Time getEn() {
		return en;
	}
	public void setEn(Time en) {
		this.en = en;
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
		 System.out.println("Event title: "+eventTitle); 
	     System.out.println("Contact Name: "+ContactName); 
	     System.out.println("Date : "+date); 
		 System.out.println("Location: "+location );
		 System.out.println("Time: "+Time ); 

	 }
	

}
