/*
 * Vamsi Veeramasu
 * 12/2/2019
 * This file generates the GUI of the program. I used 4 JPanels to store all the UI elements in the specified order, and added the JPanels in the proper order for everything
 * to show up as requested in the project description. This GUI file is similar to the GUI files of the past two projects, as I followed the same format. 
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class P3GUI extends JFrame{
	
	private JLabel originalList = new JLabel("Original List");
	private JLabel sortedList = new JLabel("Sorted List");
	
	private JTextField input = new JTextField("");
	private JTextField result = new JTextField("");
	
	private JButton perform = new JButton("Perform Sort");
	
	private JRadioButton ascending = new JRadioButton("Ascending");
	private JRadioButton descending = new JRadioButton("Descending");
	
	private JRadioButton integ = new JRadioButton("Integer         "); //The Strings contain spaces to automatically give enough space for the title of their panel to fully display
	private JRadioButton fraction = new JRadioButton("Fraction     ");
	
	public P3GUI() {  
		super("Binary Search Tree Sort");
		setSize(600, 400);
		setLayout(new GridLayout(4, 1, 0, 5));
		
		result.setEditable(false);
		result.setBackground(getBackground());
		
		JPanel original = new JPanel();
		original.setLayout(new GridLayout(0,2));
		original.add(originalList);
		original.add(input);
		
		JPanel sorted = new JPanel();
		sorted.setLayout(new GridLayout(0,2));
		sorted.add(sortedList);
		sorted.add(result);
		
		JPanel middle = new JPanel();
		middle.setLayout(new FlowLayout());
		middle.add(perform);
		
		JPanel sortOrder = new JPanel();
		sortOrder = new JPanel();
		sortOrder.setLayout(new GridLayout(2,0));
		sortOrder.add(ascending);
		sortOrder.add(descending);
		
		JPanel numericOrder = new JPanel();
		numericOrder.setLayout(new GridLayout(2,0));
		numericOrder.add(integ);
		numericOrder.add(fraction);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout());
		bottom.add(sortOrder);
		bottom.add(numericOrder);
		
		String sortTitle = "Sort Order";
		String numberTitle = "Numeric Type";
		Border border1 = BorderFactory.createTitledBorder(sortTitle);
		Border border2 = BorderFactory.createTitledBorder(numberTitle);
		
		sortOrder.setBorder(border1);
		numericOrder.setBorder(border2);
		
		add(original);
		add(sorted);
		add(middle);
		add(bottom);
		
		perform.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BSTEval eval = new BSTEval();
				eval.setFractions(fraction.isSelected()); //To determine which of the radio buttons is selected
				eval.setAscending(ascending.isSelected());
				
				try {
					result.setText(eval.process(input.getText()));
				}
				catch(EmptyInputException e1) { //Custom OptionPanes to show the user what error was caught, and for what reason. 
					JOptionPane.showMessageDialog(null, e1);
				}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				catch(MalformedFractionException e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void display() {
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P3GUI gui = new P3GUI();
		gui.display();
	}
}