/*

CLASS: BSTNode.java

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
public class BSTNode {
	public String key;
	public contact data;
	public BSTNode right;
	public BSTNode left;
	public BSTNode(String key , contact data) {
		this.key = key;
		
		this.data = data;
		left=right=null;
	}
	public BSTNode( String key, contact data, BSTNode right, BSTNode left) {
		
		this.key = key;
		this.data = data;
		this.right = right;
		this.left = left;
	}
	
	
	


}
