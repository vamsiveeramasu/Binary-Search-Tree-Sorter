
public class BSTEval {
	private boolean fractions;
	private boolean ascending; 
	
	public BSTEval(boolean x, boolean y) {
		fractions = x;
		ascending = y;
	}
	public BSTEval() {
		
	}
	public String process(String input) throws EmptyInputException, NumberFormatException, MalformedFractionException{
		int length = input.length();
		StringBuilder num = new StringBuilder();
	
		if(length == 0)
			throw new EmptyInputException("Empty Input Not Allowed");
		
		boolean isNumerator = true;
		int numerator = 0;
		int denominator = 0;
		
		BinarySearchTree bst = new BinarySearchTree();
		
		for(int k = 0; k < length; k++) {
			char c = input.charAt(k);
			if(c == ' ')
				continue;
			if(c == '/')
				throw new MalformedFractionException("Malformed Fraction");
			if(!isOperand(c) && c != ' ')
				throw new NumberFormatException("Invalid Character Found");
			
			if(fractions) {
					while( k < length && isOperand(input.charAt(k))) {
						num.append(input.charAt(k));
						k++;
					}
					k--;
					if(isNumerator) {
						k++; //to skip the dash in fractions
						isNumerator = false;
						num.append('/');
						
						continue;
					}
					else {
						bst.addFrac(num.toString());
						num.delete(0, num.length());
						isNumerator = true;
					}
			}
			else {
				while(k < length && isOperand(input.charAt(k))) {
					num.append(input.charAt(k));
					k++;
				}
				bst.addInt(Integer.parseInt(num.toString()));
				k--;
				num.delete(0, num.length());
			}
		}

		if(ascending)
			return bst.inOrderAsc();
		else
			return bst.inOrderDesc();
	}
	public void setFractions(boolean x) {
		fractions = x;
	}
	public void setAscending(boolean x) {
		ascending = x;
	}
	public boolean isOperand(Character c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		else {
			return false;
		}
	}
}