/*
 * Vamsi Veeramasu
 * 10/2/2019
 * This class defines the BinarySearchTree and it's methods. I created two separate add methods to add nodes to the tree, one for fractions 
 * and one for integers. They both have separate helper methods to recursively add nodes to the tree. Additionally, I have two methods to
 * recursively iterate through the tree to get the sorted order in ascending and descending order. 
 */
public class BinarySearchTree {
	private TreeNode head;
	private boolean frac;
	public BinarySearchTree() {
		
	}
	public void addInt(int val) {
		if (head == null)
			head = new TreeNode("" + val);
		else 
			helperInt(head, val);
	}
	//1/2 3/4 3/2 5/8 4/9 7/16 5/32 1/8
	public void helperInt(TreeNode x, int val) { //This helper method keeps checking the value of the number to be assigned to the new node with the current node, to find the right place to insert it. 
		if(val < Integer.parseInt(x.getVal())) {
			if(x.getLeft() == null) {
				x.setLeft(new TreeNode("" + val)); //Converting an int to a String since the constructor only takes Strings
				return;
			}
			else {
				helperInt(x.getLeft(), val);
			}
		}
		else {
			if(x.getRight() == null) {
				x.setRight(new TreeNode("" + val));
				return;
			}
			else {
				helperInt(x.getRight(), val);
			}
		}	
	}
	public void addFrac(String x) {
		if(head == null) //to add the first node, since no head node exists
			head = new TreeNode(x);
		else
			helperFrac(head, x);
	}
	public void helperFrac(TreeNode x, String val) { //Using Fraction's compareTo method to compare Fractions, otherwise this method is identical to the other helper method. 
		Fraction one = new Fraction(x.getVal());
		if(one.compareTo(new Fraction(val)) == 1) {
			if(x.getLeft() == null) {
				x.setLeft(new TreeNode(val));
				return;
			}
			else {
				helperFrac(x.getLeft(), val);
			}
		}
		else {
			if(x.getRight() == null) {
				x.setRight(new TreeNode(val));
				return;
			}
			else {
				helperFrac(x.getRight(), val);
			}
		}
	}
	public String inOrderAsc() { // Using a StringBuffer instead of a String since Strings are immutable in Java
		StringBuffer str = new StringBuffer();
		ascHelper(head, str);
		return str.toString();
	}
	public void ascHelper(TreeNode x, StringBuffer s) { 
		if( x == null)
			return;
		
		ascHelper(x.getLeft(), s);
		s.append(x.getVal() + " ");
		ascHelper(x.getRight(), s);
	}
	public String inOrderDesc() {
		StringBuffer str = new StringBuffer();
		descHelper(head, str);
		return str.toString();
	}
	public void descHelper(TreeNode x, StringBuffer s) {
		if( x == null)
			return;
		
		descHelper(x.getRight(), s);
		s.append(x.getVal() + " ");
		descHelper(x.getLeft(), s);
	}
}