
public class TreeNode {

	private TreeNode left; //left child of the node
	private TreeNode right; // right child of the node
	private boolean frac; //Didn't end up using this, but keeping this just in case for the future. 
	private String val; // the actual value contained in the node - can be an operator or an operand. 
	//val is a String instead of a char to accomodate multiple digit numbers, such as 10 or 100, as well as fractions.
	public TreeNode(String x) { //A constructor that allows me to create a new TreeNode with a predetermined value. 
		val = x;
	}
	public TreeNode(String v, TreeNode x, TreeNode y) { //A constructor allowing me to create a parent TreeNode of two existing child nodes.
		val = v;
		left = x;
		right = y;
	}
	//The "Getters" (accessors) - These methods allow me to access data from the course while maintaing data encapsulation. 
	//The accessor methods for the children nodes are checked for null when called in my code to avoid nullpointerexceptions. 
	public TreeNode getLeft() { // Returns the left child
		return left;
	}
	public TreeNode getRight() { // Returns the right child 
		return right;
	}
	public String getVal() {
		return val;
	}
	// These methods allow us to modify the private variables of a TreeNode object from a different file. 
	public void setLeft(TreeNode x) { // Sets the left child of a TreeNode
		left = x;
	}
	public void setRight(TreeNode x) { // Sets the right child of a TreeNode
		right = x;
	}
	public boolean isFrac() {
		return frac;
	}
}