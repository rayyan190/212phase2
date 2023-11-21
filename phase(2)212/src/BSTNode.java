
public class BSTNode {
	public int key;
	public contact data;
	public BSTNode right;
	public BSTNode left;
	public BSTNode(int key , contact data) {
		this.key = key;
		
		this.data = data;
		left=right=null;
	}
	public BSTNode( int key, contact data, BSTNode right, BSTNode left) {
		
		this.key = key;
		this.data = data;
		this.right = right;
		this.left = left;
	}
	
	
	


}
