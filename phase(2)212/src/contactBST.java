import java.util.Scanner;

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
		BSTNode p = root; BSTNode q=root;
				
		if(empty())
			return false;
		
		while(p != null) {
			current = p;
			if(tkey.compareToIgnoreCase(p.key) == 0) {
				return true;
			}
			else if(tkey.compareToIgnoreCase(p.key)<0)
				p = p.left;
			else
				p = p.right;
		}
		
		
		return false;
	}
	public boolean insert(String key, contact val) {
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
	
	// uniqe search  
	public boolean CheckPhoneNumber(String phone ) {
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
	public boolean CheckName(String name ) {
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
	
	
	public boolean isContactUnique(contact NewContact) {
		if(CheckName(NewContact.getName())||CheckPhoneNumber(NewContact.getPhoneNumber()))
			return false;
		return true;
	}
	
	public void inorderPrint() {
		if(empty()) 
			System.out.println("tree is empty");
		else inorderPrint(root);
	}
	private void inorderPrint(BSTNode p) {
		inorderPrint(p.left);
		p.data.PrintContact();
		
		inorderPrint(p.right);
	}
	
	
	
	
	/*public boolean searchEmail1(String email) {
		if(empty())
			return false;
		return searchEmail1( root, email);
		
	}
	private boolean searchEmail1(BSTNode p,String email) {
		
		boolean foundLeft=searchEmail1(p.left, email);
		if(foundLeft) {
			p.data.PrintContact();
			return true;}
		
		if(p.data.getName().equalsIgnoreCase(email)) {
			p.data.PrintContact();
			return true;}
		
		return searchEmail1(p.right, email);
	}
	*/
	
	public void searchName(String name) {
		if(empty())
			return ;
		searchName(root, name);
	}
	private void searchName(BSTNode p,String name) {
		if(p!=null) {
			if(p.data.getName().equalsIgnoreCase(name)) {
				System.out.println("Contact found!"); 
				p.data.PrintContact();
				return;
			}
			searchName(p.left,name);
			searchName(p.right,name);
		}
	}
	public contact findName(String name) {
		if(empty())
			return null ;
		boolean found= findkey(name);
		if(found)
		return retrieve();
		else return null;
	}
	
	
	
	public void searchPhoneNumber(String phone) {
		if(empty())
			return ;
		searchPhoneNumber(root, phone);
	}
	private void searchPhoneNumber(BSTNode p,String phone) {
		if(p!=null) {
			if(p.data.getPhoneNumber().equalsIgnoreCase(phone)) {
				System.out.println("Contact found!"); 
				p.data.PrintContact();
				return;
			}
			searchPhoneNumber(p.left,phone);
			searchPhoneNumber(p.right,phone);
		}
	}
	
	public void searchEmail(String email) {
		if(empty())
			return ;
		searchEmail(root, email);
	}
	private void searchEmail(BSTNode p,String email) {
		if(p!=null) {
			if(p.data.geteMail().equalsIgnoreCase(email)) {
				System.out.println("Contact found!"); 
				p.data.PrintContact();
				return;
			}
			searchEmail(p.left,email);
			searchEmail(p.right,email);
		}
	}
	
	public void searchBirthday(String birthday) {
		if(empty())
			return ;
		searchBirthday(root, birthday);
	}
	private void searchBirthday(BSTNode p,String birthday) {
		if(p!=null) {
			if(p.data.getBirthday().equalsIgnoreCase(birthday)) {
				System.out.println("Contact found!"); 
				p.data.PrintContact();
				return;
			}
			searchBirthday(p.left,birthday);
			searchBirthday(p.right,birthday);
		}
	}
	
	public void searchAddres(String addres) {
		if(empty())
			return ;
		searchAddres(root, addres);
	}
	private void searchAddres(BSTNode p,String addres) {
		if(p!=null) {
			if(p.data.getAddres().equalsIgnoreCase(addres)) {
				System.out.println("Contact found!");  
				p.data.PrintContact();
				return;
			}
			searchAddres(p.left,addres);
			searchAddres(p.right,addres);
		}
	}
	
	
	
	
	 
	  public void searchContacts(int criteria){
    	Scanner input = new Scanner(System.in);       // receive the way of searching then implement it
    	if(criteria==1) {
    		 System.out.print("Enter the contact's name:");
    		 String name = input.nextLine();
    		 searchName (name);
    	}
    	else if(criteria==2) {
    		 System.out.print("Enter the contact's phone number:"); 
    		 String phoneNumber = input.next();
    		 searchPhoneNumber (phoneNumber);
    	}
    	else if(criteria==3) {
    		 System.out.print("Enter the contact's email address:"); 
    		 String emailAddress = input.next();
    		 searchEmail (emailAddress );
    	}
    	else if(criteria==4) {
    		 System.out.print("Enter the contact's address: "); 
    		 String address = input.nextLine();
    		 searchAddres (address );
    	}
    	else if(criteria==5) {
    		 System.out.print("Enter the contact's birthday:"); 
    		 String birthday = input.nextLine();
    		 searchBirthday (birthday);
    	}
    }
	  
	  
	  public void printByFirstName(String name) {
		  if(empty()) {
			  System.out.println("its empty");
			  return;
			  } 
		  printByFirstName(root, name);
	  }
	  private void printByFirstName(BSTNode p ,String name) {
		  printByFirstName(p.left, name);
		  String FullName=p.key;
		  String FirstName=FullName.substring(0, FullName.indexOf(" "));
		  if(FirstName.equalsIgnoreCase(name))
			  p.data.PrintContact();
		  printByFirstName( p.right , name);
		  
	  }
	  
	  
	 
	 
	 







}
