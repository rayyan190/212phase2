

public class contact implements Comparable<contact>{
	private String name;
	private String PhoneNumber;
	private String eMail;
	private String Birthday;
	private String notes;
	private String addres;
	private LinkedList<event> eventList ;
	
	
	
	
	
	public LinkedList<event> getEventList() {
		return eventList;
	}
	public void setEventList(LinkedList<event> eventList) {
		this.eventList = eventList;
	}
	public contact(String name, String phoneNumber, String eMail, String birthday, String notes, String addres) {
		this.name = name;
		PhoneNumber = phoneNumber;
		this.eMail = eMail;
		Birthday = birthday;
		this.notes = notes;
		this.addres = addres;
		
	}
	public contact(contact c ) {
		this.name = c.name;
		this.PhoneNumber = c.PhoneNumber;
		this.eMail = c.eMail;
		this.addres = c.addres;
		this.Birthday = c.Birthday;
		this.notes = c.notes;
	}
	


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhoneNumber() {
		return PhoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}



	public String geteMail() {
		return eMail;
	}



	public void seteMail(String eMail) {
		this.eMail = eMail;
	}



	public String getBirthday() {
		return Birthday;
	}



	public void setBirthday(String birthday) {
		Birthday = birthday;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}



	public String getAddres() {
		return addres;
	}



	public void setAddres(String addres) {
		this.addres = addres;
	}



	public  int compareTo(contact o) {
		return getName().compareTo(o.name);
	}
	
	
	public void PrintContact () {
		System.out.println("Name: "+name); 
		System.out.println("Phone Number: "+PhoneNumber); 
		System.out.println("Email Address: "+eMail); 
		System.out.println("Address: "+addres); 
		System.out.println("Birthday: "+Birthday); 
		System.out.println("Notes: "+notes); 
		
	}

}
