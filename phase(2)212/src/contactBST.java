
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
	public boolean searchPhoneNumber(String phone ) {
		if(root==null)
			return false;
		return searchPhoneNumber( root, phone);
		
	}
	private boolean searchPhoneNumber(BSTNode p,String phone) {
		if(p==null)
			return false;
		
		boolean foundLeft=searchPhoneNumber(p.left, phone);
		if(foundLeft)
			return true;
		
		if(p.data.getPhoneNumber().equalsIgnoreCase(phone))
			return true;
		
		return searchPhoneNumber(p.right, phone);
	}
	//// uniqe search
	public boolean searchName(String name ) {
		if(root==null)
			return false;
		return searchName( root, name);
		
	}
	private boolean searchName(BSTNode p,String name) {
		if(p==null)
			return false;
		
		boolean foundLeft=searchName(p.left, name);
		if(foundLeft)
			return true;
		
		if(p.data.getName().equalsIgnoreCase(name))
			return true;
		
		return searchName(p.right, name);
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
	
	
	
	
	public boolean searchEmail(String email) {
		if(empty())
			return false;
		return searchEmail( root, email);
		
	}
	private boolean searchEmail(BSTNode p,String email) {
		
		boolean foundLeft=searchEmail(p.left, email);
		if(foundLeft) {
			p.data.PrintContact();
			return true;}
		
		if(p.data.getName().equalsIgnoreCase(email)) {
			p.data.PrintContact();
			return true;}
		
		return searchName(p.right, email);
	}







}
