/*
 * Vamsi Veeramasu
 * 10/2/2019
 * This is the Fraction class I created as specified in the project description. The constructor takes a string
 * as input, and converts the string into a decimal value stored as a double (decimals are essentially the same as fractions).
 * The class implements the abstract Comparable class, so I overrode the compareTo method to compare Fractions. I compared fractions
 * by simply comparing the value element of the two Fraction objects. I also included some accessor and modifier methods just in case, 
 * but I didn't need them and I diddn't use them, outside getVal(). 
 * Additionally, the numerator and denominator variables are of type double, since I kept getting 0 as a result for val when they were ints, 
 * due to integer division in Java.
 */
public class Fraction implements Comparable{
	private String str;
	public double numerator;
	public double denominator;
	private double val;
	public Fraction(String x) {
		str = new String(x);
		numerator = Double.parseDouble((x.substring(0, x.indexOf('/')))); //Parsing the input string to obtain the numerator and denominator
		denominator = Double.parseDouble(x.substring(x.indexOf('/')+1));
		val = numerator/denominator; //Dividing the two to obtain the fraction value to store.
	}
	public String toString() {
		return str;
	}
	public void setVal(String x) {
		str = new String(x);
	}
	public double getNumerator() {
		return numerator;
	}
	public double getDenominator() {
		return denominator; 
	}
	public double getVal() {
		return val;
	}
	@Override
	public int compareTo(Object x) { //Simply returning a negative number or a positive number to determine which Fraction object has a larger value.
		if(x instanceof Fraction) {
			if(val < ((Fraction) x).getVal())
				return -1;
			else if(val > ((Fraction) x).getVal())
				return 1;
			else
				return 0;
		}
		return -2;
	}
}