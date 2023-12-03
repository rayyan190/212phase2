import java.util.Scanner;
/*

CLASS: contactBST.java

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

public class contactBST {
	BSTNode root,current;
	
	public boolean empty() {
		return root == null;
	}
	
	public boolean full() {
		return false;
	}
	
	public contact retrieve () {
		return current.data;
	}
	public boolean update(String key, contact data){
		remove_key(current.key);
		return insert(key, data);
	}


	public boolean findkey(String tkey) {
		BSTNode p = root; BSTNode q=root;  // bigO(n) in the worst case
				
		if(empty())//1
			return false;
		
		while(p != null) {
			current = p;//n
			if(tkey.compareToIgnoreCase(p.key) == 0) {
				return true;//1
			}
			else if(tkey.compareToIgnoreCase(p.key)<0)
				p = p.left;
			else
				p = p.right;
		}
		
		
		return false;
	}
	public boolean insert(String key, contact val) { // bigO(n) in the worst case
		BSTNode p, q = current;
		
		if(findkey(key)) {
			current = q;  // findkey() modified current
			return false; // key already in the BST
		}
		
		p = new BSTNode(key, val);
		if (empty()) {
			root = current = p;
			return true;
		}
		else {
			// current is pointing to parent of the new key
			if (key.compareToIgnoreCase(current.key) <0  )
				current.left = p;
			else
				current.right = p;
			current = p;
			return true;
		}
	}
	
	public boolean remove_key (String tkey){ 
		Boolean removed = new Boolean(false);
		BSTNode p;
		p = remove_aux(tkey, root, removed);
		current = root = p;
		return removed;
	}
	private BSTNode remove_aux(String key, BSTNode p, Boolean flag) {
		BSTNode q, child = null;
		if(p == null)
			return null;
		if(key.compareToIgnoreCase(p.key)<0 )
			p.left = remove_aux(key, p.left, flag); //go left
		else if(key.compareToIgnoreCase(p.key)>0)
			p.right = remove_aux(key, p.right, flag); //go right
		else { // key is found
			flag= true;
			if (p.left != null && p.right != null){ //two children
				q = find_min(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove_aux(q.key, p.right, flag);
			}
			else {
				if (p.right == null) //one child
					child = p.left;
				else if (p.left == null) //one child
					child = p.right;
				return child;
			}
		}
		return p;
	}
	private BSTNode find_min(BSTNode p){
		if(p == null)
			return null;
		
		while(p.left != null){
			p = p.left;
		}
		
		return p;
	}
	
	 public boolean removeKey(String k) {  // bigO(n) in the worst case
		    // Search   
		    String k1 = k;        
		    BSTNode  p = root;        
		    BSTNode  q = null;    // Parent of p  
		      
		    while (p != null)   
		    {  
		        if (k1.compareTo(p.key) <0)   
		        {  
		            q =p;  
		            p = p.left;  
		        }  
		        else if (k1.compareTo(p.key) >0)   
		        {  
		            q = p;  
		            p = p.right;  
		        }   
		        else {   
		            // Found the key              
		            // Check the three cases  
		            if ((p.left != null) && (p.right != null))   
		            {   
		    // Case 3: two children                  
		                    // Search for the min in the right subtree  
		                    BSTNode  min = p.right;  
		                    q = p;  
		                    while (min.left != null)   
		                    {  
		                        q = min;  
		                        min = min.left;  
		                    }  
		                    p.key = min.key;                 
		                    p.data = min.data;  
		                    k1 = min.key;  
		                    p = min;  
		                    // Now fall back to either case 1 or 2  
		            }  
		            // The subtree rooted at p will change here               
		            if (p.left != null)   
		            {   
		                // One child  
		                p = p.left;  
		            }   
		            else   
		            {   
		                // One or no children  
		                p = p.right;  
		            }  
		              
		            if (q == null)   
		            {   
		                // No parent for p, root must change  
		                root = p;  
		            }   
		            else   
		            {  
		                if (k1.compareTo(q.key) <0)   
		                {  
		                    q.left = p;  
		                }   
		                else   
		                {  
		                    q.right = p;  
		                }  
		            }  
		            current = root;  
		            return true;  
		        }  
		    }  
		    return false; // Not found  
		    }  
	
	
	
	
	// uniqe search  
	public boolean CheckPhoneNumber(String phone ) {// bigO(n) in the worst case
		if(root==null)
			return false;
		return CheckPhoneNumber( root, phone);
		
	}
	private boolean CheckPhoneNumber(BSTNode p,String phone) { 
		if(p==null)
			return false;
		
		boolean foundLeft=CheckPhoneNumber(p.left, phone);
		if(foundLeft)
			return true;
		
		if(p.data.getPhoneNumber().equalsIgnoreCase(phone))
			return true;
		
		return CheckPhoneNumber(p.right, phone);
	}
	//// uniqe search
	public boolean CheckName(String name ) {// bigO(n) in the worst case
		if(root==null)
			return false;
		return CheckName( root, name);
		
	}
	private boolean CheckName(BSTNode p,String name) {
		if(p==null)
			return false;
		
		boolean foundLeft=CheckName(p.left, name);
		if(foundLeft)
			return true;
		
		if(p.data.getName().equalsIgnoreCase(name))
			return true;
		
		return CheckName(p.right, name);
	}
	
	
	public boolean isContactUnique(contact NewContact) { // bigO(n) in the worst case
		if(CheckName(NewContact.getName())||CheckPhoneNumber(NewContact.getPhoneNumber()))
			return false;
		return true;
	}
	
	public void inorderPrint() {
		if(empty()) 
			System.out.println("Contact tree is empty");
		else inorderPrint(root);
	}
	private void inorderPrint(BSTNode p) {
		inorderPrint(p.left);
		p.data.PrintContact();
		
		inorderPrint(p.right);
	}
	
	
	
	
	
	
	public void searchName(String name) { // bigO(n) in the worst case
		if(empty())
			return ;
		searchName(root, name) ;
		
	}
	private void searchName(BSTNode p,String name) {
		
		if(p!=null) {
			if(p.data.getName().equalsIgnoreCase(name)) {
				System.out.println();
				p.data.PrintContact();
				System.out.println();
				return;
			}
			
				
			searchName(p.left,name);
			searchName(p.right,name);
		}
		
	}
	
	
	
	
	public void searchPhoneNumber(String phone) { // bigO(n) in the worst case
		if(empty())
			return ;
		searchPhoneNumber(root, phone);
		
	}
	private void searchPhoneNumber(BSTNode p,String phone) {
		if(p!=null) {
			if(p.data.getPhoneNumber().equalsIgnoreCase(phone)) {
				System.out.println();
				p.data.PrintContact();
				System.out.println();
				return ;
			}
			searchPhoneNumber(p.left,phone);
			searchPhoneNumber(p.right,phone);
		}
		
		
	}
	
	public void searchEmail(String email) { // bigO(n) in the worst case
		if(empty())
			return ;
		searchEmail(root, email);
		
			 
	}
	private void searchEmail(BSTNode p,String email) {
		
		if(p!=null) {
			if(p.data.geteMail().equalsIgnoreCase(email)) {
				System.out.println();
				p.data.PrintContact();
				System.out.println();
				
			}
			searchEmail(p.left,email);
			searchEmail(p.right,email);
		}
		
	}
	
	public void searchBirthday(String birthday) { // bigO(n) in the worst case
		
	    if (empty()) {
	       
	        return;
	    }
	   searchBirthday(root, birthday);
	    
	}

	private void searchBirthday(BSTNode p, String birthday) {
	    if (p != null) {
	        if (p.data.getBirthday().equalsIgnoreCase(birthday)) {
	            System.out.println();
	            p.data.PrintContact();
	            System.out.println();
	            
	        }
	        searchBirthday(p.left, birthday);
	        searchBirthday(p.right, birthday);
	    }
	  
	}
	
	public void searchAddres(String addres) {// bigO(n) in the worst case
		if(empty())
			return ;
		searchAddres(root, addres);
		
	}
	private void searchAddres(BSTNode p,String addres) {
		if(p!=null) {
			if(p.data.getAddres().equalsIgnoreCase(addres)) { 
				System.out.println();
				p.data.PrintContact();
				System.out.println();
			
			}
			searchAddres(p.left,addres);
			searchAddres(p.right,addres);
		}
		
	}
	
	
	
	
	 
	  public void searchContacts(int criteria){ // bigO(n) in the worst case
    	Scanner input = new Scanner(System.in);       // receive the way of searching then implement it
    	if(criteria==1) {
    		 System.out.println();
    		 System.out.print("Enter the contact's name:");
    		 String name = input.nextLine();
    		 searchName (name);
    	}
    	else if(criteria==2) {
    		 System.out.println();
    		 System.out.print("Enter the contact's phone number:"); 
    		 String phoneNumber = input.next();
    		 searchPhoneNumber (phoneNumber);
    	}
    	else if(criteria==3) {
    		 System.out.println();
    		 System.out.print("Enter the contact's email address:"); 
    		 String emailAddress = input.next();
    		 searchEmail (emailAddress );
    	}
    	else if(criteria==4) {
    		 System.out.println();
    		 System.out.print("Enter the contact's address: "); 
    		 String address = input.nextLine();
    		 searchAddres (address );
    	}
    	else if(criteria==5) {
    		 System.out.println();
    		 System.out.print("Enter the contact's birthday:"); 
    		 String birthday = input.nextLine();
    		 searchBirthday (birthday);
    	}
    }
	  
	  
	  public void printByFirstName(String firstName) {// bigO(n) in the worst case
		  if(empty()) {
			  System.out.println("Contact tree is empty");
			  return;
			  } 
		  SearchFirstName(root, firstName);
	  }
	
	  private void SearchFirstName (BSTNode  p, String firstName)
	    {
	        if (p == null)
	            return ;
	        
	        else  if (p.data.compareFirstName(firstName) == 0)
	           p.data.PrintContact();

	        SearchFirstName(p.left , firstName);
	        SearchFirstName(p.right, firstName);
	    }
	  
	  
	  public contact CheckNameObj(String name ) {// bigO(n) in the worst case
			if(root==null)
				return null;
			return CheckNameObj( root, name);
			
		}
		private contact CheckNameObj(BSTNode p,String name) {
			if(p==null)
				return null;
			
			boolean foundLeft=CheckName(p.left, name);
			if(foundLeft)
				return p.data;
			
			if(p.data.getName().equalsIgnoreCase(name))
				return p.data;
			
			return CheckNameObj(p.right, name);
		}
		
		





}
