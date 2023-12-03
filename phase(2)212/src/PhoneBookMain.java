import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
/*

CLASS: PhoneBookMain.java

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

public class PhoneBookMain {

	public static void main(String[] args) {
		phonebook p  = new phonebook();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to theLinked Tree Phonebook!");
		System.out.println(); 
		int x;
		
		

		
			do {
				System.out.println("Please choose an option:");  
				System.out.println(); 
				System.out.println("1.Add a contact");  
				System.out.println("2.Search for a contact");  
				System.out.println("3.Delete a contact");  
				System.out.println("4.Schedule an event/appointment");  
				System.out.println("5.Print event details");  
				System.out.println("6.Printcontacts byfirstname ");  
				System.out.println("7.Print all events alphabetically");  
				System.out.println("8.Exit"); 
				System.out.println();
				System.out.print("Enter your choice:"); 
				 try {
				 x = input.nextInt();
				 if(x>8||x<1) {
					 System.out.println("inter 1-8"); 
					 continue;}}catch(InputMismatchException e) {
						 System.out.println("inter only 1-8");
						 input.nextLine();
						 x=0;

					 }
				 

				 System.out.println(); 
				 
				 if(x==1) {
					 System.out.print("Enter the contact's name:");
					 input.nextLine();
					 String name = input.nextLine();
					 System.out.print("Enter the contact's phone number:"); 
					 String phoneNumber = input.next();
					 System.out.print("Enter the contact's email address:"); 
					 String emailAddress = input.next();
					 System.out.print("Enter the contact's address: "); 
					 input.nextLine();
					 String address =  input.nextLine();
					
					 String birthday ;
					   while (true) {
				            System.out.print("Enter the contact's birthday (YYYY/MM/DD): ");
				            birthday = input.next();

				            if (checkDateInBirtday(birthday, "yyyy/MM/dd")) {
				                break;
				            } else {
				                System.out.println("wrong input try again.");
				            }
				        }
					 
					 System.out.print("Enter any notes for the contact: "); 
					 input.nextLine();
					 String notes =  input.nextLine();
				
					 contact NewContact = new contact(name,phoneNumber,emailAddress,birthday,notes,address);
					 p.addContact( NewContact);
					 System.out.println(); 
				 }
				 
				 else if(x==2) { 
					 
					 int  criteria = 0;
					 System.out.println("Enter search criteria:"); 
					 while(true){
					
					 System.out.println("1.Name");  
					 System.out.println("2.Phone Number");  
					 System.out.println("3.Email Address");  
					 System.out.println("4.Address");  
					 System.out.println("5.Birthday");  
					 System.out.println(); 
					 System.out.print("Enter your choice:"); 
					 System.out.println(); 
					 
					 
					 try {
					  criteria = input.nextInt();
					  if(criteria <1||criteria>5) {
						  System.out.println("wrong input try again");
						  System.out.println(); 
						  continue; 
						  }
					  else  { 
						  p.searchContacts(criteria);
						  System.out.println();    
						  break;
						  }
					  }catch(InputMismatchException e) {
						  System.out.println("wrong input try again"); 
						  System.out.println(); 
						  input.nextLine();
						  
					  }
					}
					 }
					 
					 
				 
				 else if(x==3) {
					 System.out.print("Enter the contact's name you want to delete:");
					 input.nextLine();
					 String name =  input.nextLine();
					 p.removeContact(name);
					 System.out.println();    
				 }
				 else if(x==4) {
					 while(true) {
					 System.out.println("Enter type:");  
				        System.out.println("1. event");  
				        System.out.println("2. appointment");  
				        System.out.println("\nEnter your choice: "); 
				        
				        int choice=0;
				     try {    choice = input.nextInt();
				     if(choice<1||choice>2) {
				    	 System.out.println("wrong input try again");
				    	 System.out.println(); 
				    	 continue;}
				    	 
				     }catch(InputMismatchException e) {
				     System.out.println("wrong input try again");
				     System.out.println(); 
				     input.nextLine();
				     }
				        
					 if(choice==1) {
						 
						 System.out.print("Enter event title:");
						 input.nextLine();
						 String eventTitle = input.nextLine();
						
						 
						
						
						 String date;
						   while (true) {
							   System.out.print("Enter event date (YYYY/MM/DD):");  
					            date = input.next();

					            if (checkDateInEvent(date, "yyyy/MM/dd")) {
					                break;
					            } else {
					                System.out.println("wrong input try again.");
					            }
					        }
						 System.out.print("Enter contacts name separated by a comma:"); 
					     input.nextLine();
						 String ContactName =input.nextLine();
						
						 String time ;
						 while (true) {
							 System.out.print("Enter event time (HH:MM):");  
					            time = input.next();

					            if (checkTime(time,"HH:mm")) {
					                break; 
					            } else {
					                System.out.println("wrong input try again.");
					            }
					        }

						 System.out.print("Enter event location:");  
						 input.nextLine();
						 String location = input.nextLine();
						 event NewEvent = new event(eventTitle,ContactName,date,time,location);
						 NewEvent.isEvent=true;
						 p.scheduleEvent( NewEvent,ContactName);
						 System.out.println();
						 break;
					 }
					 else if(choice==2) {
						
						 System.out.print("Enter appointment title:");
						 input.nextLine();
						 String eventTitle = input.nextLine();
						 String date ;
						 while (true) {
							 System.out.print("Enter appointment date (YYYY/MM/DD):");  
					            date = input.next();

					            if (checkDateInEvent(date, "yyyy/MM/dd")) {
					                break;
					            } else {
					                System.out.println("wrong input try again.");
					            }
					        }
						 System.out.print("Enter contact name:"); 
						 input.nextLine();
						 String ContactName =input.nextLine();
						 String time ;
						 while (true) {
							 System.out.print("Enter appointment time (HH:MM):");  
					            time = input.next();

					            if (checkTime(time,"HH:mm")) {
					                break; 
					            } else {
					                System.out.println("wrong input try again.");
					            }
					        }
						 System.out.print("Enter appointment location:");  
						 input.nextLine();
						 String location = input.nextLine();
						 event NewEvent = new event(eventTitle,ContactName,date,time,location);
						 NewEvent.isEvent=false;
						 p.scheduleEvent( NewEvent,ContactName);
						 System.out.println();
						 break;
					 }
					    
				 }}
				 else if(x==5) {
					 while (true) {
					 System.out.println("Enter search criteria:"); 
					 System.out.println("1.contact name");  
					 System.out.println("2.Event tittle"); 
					 System.out.println(); 
					 System.out.print("Enter your choice:"); 
					try { int  criteria = input.nextInt(); 
					if(criteria<1||criteria>2) {
						 System.out.println("Enter 1 or 2 please"); 

						continue;}
					else { 
						p.searchEvent(criteria);
						System.out.println();    
					    break;
					}
					}catch(InputMismatchException e) {
						 System.out.println();  
						input.nextLine();
					}
					}
					 }

						
					
				 
				 
				 else if(x==6) {
					 System.out.println("Enter the firstname:");
					 String firstName =  input.next();
					 //input.nextLine();
					 System.out.println();
					 p.printContactsByFirstName(firstName);
					 System.out.println();    
					 


				 }
				 
				 else if(x==7) {
					 p.printAllEventsAlphabetically();
					 System.out.println();    
				 }
				 else if(x==8) {
					 System.out.println("Goodbye!"); 
				 }
				 
				
			}while(x!=8);
			
			

	}
	
	public static boolean checkTime(String time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false); 

        try {
           
            Date Time = sdf.parse(time);
            return true; 
        } catch (ParseException e) {
            return false; 
        }
    }
	
	 
	 
	 public static boolean checkDateInBirtday(String inputDate, String format) {
	        SimpleDateFormat sdf = new SimpleDateFormat(format);
	        sdf.setLenient(false);

	        try {
	            Date date = sdf.parse(inputDate);

	           
	            int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
	            int month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
	            int day = Integer.parseInt(new SimpleDateFormat("dd").format(date));
	            
	            if (year < 1920 || year > 2200) {
	                return false;
	            }

	           
	            if (month < 1 || month > 12) {
	                return false;
	            }

	          
	            int maxDaysInMonth = getMaxDaysInMonth(year, month);
	            if (day < 1 || day > maxDaysInMonth) {
	                return false;
	            }

	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	    }

	    private static int getMaxDaysInMonth(int year, int month) {
	        switch (month) {
	            case 4: case 6: case 9: case 11:
	                return 30;
	            case 2:
	                return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
	            default:
	                return 31;
	        }
	    }
	    
	    public static boolean checkDateInEvent(String inputDate, String format) {
	        SimpleDateFormat sdf = new SimpleDateFormat(format);
	        sdf.setLenient(false);

	        try {
	            Date date = sdf.parse(inputDate);

	           
	            int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
	            int month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
	            int day = Integer.parseInt(new SimpleDateFormat("dd").format(date));
	            
	            if (year < 2023 || year > 2200) {
	                return false;
	            }
	            if(year == 2023 && month<12)
	            	return false;

	           
	            if (month < 1 || month > 12) {
	                return false;
	            }

	          
	            int maxDaysInMonth = getMaxDaysInMonth(year, month);
	            if (day < 1 || day > maxDaysInMonth) {
	                return false;
	            }

	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	    }
	    
	    
	    
	    

	 

}
