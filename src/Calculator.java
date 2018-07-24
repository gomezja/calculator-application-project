import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class Calculator {

	private JFrame frmCalculator;
	private JTextField textField;
	private JLabel prevOperation;
	
	private JButton btnCe;
	private JButton btnC;
	private JButton btnDivide;
	private JButton btnMultiply;
	private JButton btnMinus;
	private JButton btnPlus;
	private JButton btnEquals;
	
	private JButton btnZero;
	private JButton btnOne;
	private JButton btnTwo;
	private JButton btnThree;
	private JButton btnFour;
	private JButton btnFive;
	private JButton btnSix;
	private JButton btnSeven;
	private JButton btnEight;
	private JButton btnNine;
	
	private JButton btnNegate;
	private JButton btnDecimal;
	
	private boolean operatorPressed = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// window
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 520, 750);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		// label
		prevOperation = new JLabel("");
		prevOperation.setForeground(SystemColor.textInactiveText);
		prevOperation.setFont(new Font("Tahoma", Font.PLAIN, 25));
		prevOperation.setHorizontalAlignment(SwingConstants.TRAILING);
		prevOperation.setBounds(15, 16, 469, 45);
		frmCalculator.getContentPane().add(prevOperation);
		
		// text area
		textField = new JTextField();
		textField.setBackground(new Color(163, 169, 157));
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setText("0");
		textField.setFont(new Font("Tahoma", Font.BOLD, 48));
		textField.setBounds(15, 75, 469, 100);
		frmCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		/***************************************************/
		
		// button CE
		btnCe = new JButton("CE");
		btnCe.setBackground(new Color(170, 90, 111));
		btnCe.setForeground(SystemColor.text);
		btnCe.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnCe.setBounds(15, 191, 106, 80);
		frmCalculator.getContentPane().add(btnCe);
		
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// reset all text on calculator
				resetLabel();
				resetTextfield();
			}
		});
		
		// button C
		btnC = new JButton("C");
		btnC.setBackground(new Color(170, 90, 111));
		btnC.setForeground(SystemColor.text);
		btnC.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnC.setBounds(136, 191, 106, 80);
		frmCalculator.getContentPane().add(btnC);
		
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTextfield();
			}
		});
		
		// button divide (/)
		btnDivide = new JButton("\u00F7");
		btnDivide.setBackground(new Color(63, 81, 111));
		btnDivide.setForeground(SystemColor.text);
		btnDivide.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnDivide.setBounds(257, 191, 106, 80);
		frmCalculator.getContentPane().add(btnDivide);
		
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorPressed("\u00F7");
			}
		});
		
		// button multiply (*)
		btnMultiply = new JButton("*");
		btnMultiply.setBackground(new Color(63, 81, 111));
		btnMultiply.setForeground(SystemColor.text);
		btnMultiply.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnMultiply.setBounds(378, 191, 106, 80);
		frmCalculator.getContentPane().add(btnMultiply);
		
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorPressed("*");
			}
		});
				
		// button subtract (-)
		btnMinus = new JButton("-");
		btnMinus.setBackground(new Color(63, 81, 111));
		btnMinus.setForeground(SystemColor.text);
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnMinus.setBounds(378, 287, 106, 80);
		frmCalculator.getContentPane().add(btnMinus);

		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorPressed("-");
			}
		});

		// button addition (+)
		btnPlus = new JButton("+");
		btnPlus.setBackground(new Color(63, 81, 111));
		btnPlus.setForeground(SystemColor.text);
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnPlus.setBounds(378, 383, 106, 80);
		frmCalculator.getContentPane().add(btnPlus);
		
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorPressed("+");
			}
		});
		
		// button equals (=)
		btnEquals = new JButton("=");
		btnEquals.setBackground(new Color(63, 81, 111));
		btnEquals.setForeground(SystemColor.text);
		btnEquals.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnEquals.setBounds(378, 479, 106, 176);
		frmCalculator.getContentPane().add(btnEquals);
		
		/***************************************************/
		
		// button zero (0)
		btnZero = new JButton("0");
		btnZero.setBackground(Color.WHITE);
		btnZero.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnZero.setBounds(136, 575, 106, 80);
		frmCalculator.getContentPane().add(btnZero);
		
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDigit("0");
			}
		});
		
		// button one (1)
		btnOne = new JButton("1");
		btnOne.setBackground(Color.WHITE);
		btnOne.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnOne.setBounds(15, 479, 106, 80);
		frmCalculator.getContentPane().add(btnOne);
		
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDigit("1");
			}
		});
		
		// button two (2)
		btnTwo = new JButton("2");
		btnTwo.setBackground(Color.WHITE);
		btnTwo.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnTwo.setBounds(136, 479, 106, 80);
		frmCalculator.getContentPane().add(btnTwo);
		
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDigit("2");
			}
		});
		
		// button three (3)
		btnThree = new JButton("3");
		btnThree.setBackground(Color.WHITE);
		btnThree.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnThree.setBounds(257, 479, 106, 80);
		frmCalculator.getContentPane().add(btnThree);
		
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDigit("3");
			}
		});
		
		// button four (4)
		btnFour = new JButton("4");
		btnFour.setBackground(Color.WHITE);
		btnFour.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnFour.setBounds(15, 383, 106, 80);
		frmCalculator.getContentPane().add(btnFour);
		
		btnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDigit("4");
			}
		});
		
		// button five (5)
		btnFive = new JButton("5");
		btnFive.setBackground(Color.WHITE);
		btnFive.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnFive.setBounds(136, 383, 106, 80);
		frmCalculator.getContentPane().add(btnFive);
		
		btnFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDigit("5");
			}
		});
		
		// button six (6)
		btnSix = new JButton("6");
		btnSix.setBackground(Color.WHITE);
		btnSix.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnSix.setBounds(257, 383, 106, 80);
		frmCalculator.getContentPane().add(btnSix);

		btnSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDigit("6");
			}
		});
		
		// button seven (7)
		btnSeven = new JButton("7");
		btnSeven.setBackground(Color.WHITE);
		btnSeven.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnSeven.setBounds(15, 287, 106, 80);
		frmCalculator.getContentPane().add(btnSeven);
		
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDigit("7");
			}
		});
		
		// button eight (8)
		btnEight = new JButton("8");
		btnEight.setBackground(Color.WHITE);
		btnEight.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnEight.setBounds(136, 287, 106, 80);
		frmCalculator.getContentPane().add(btnEight);

		btnEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDigit("8");
			}
		});
		
		// button nine (9)
		btnNine = new JButton("9");
		btnNine.setBackground(Color.WHITE);
		btnNine.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnNine.setBounds(257, 287, 106, 80);
		frmCalculator.getContentPane().add(btnNine);
		
		btnNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDigit("9");
			}
		});
		
		/***************************************************/
		
		// button negate (+/-)
		btnNegate = new JButton("+/-");
		btnNegate.setBackground(Color.WHITE);
		btnNegate.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnNegate.setBounds(15, 575, 106, 80);
		frmCalculator.getContentPane().add(btnNegate);
		
		// button decimal (.)
		btnDecimal = new JButton(".");
		btnDecimal.setBackground(Color.WHITE);
		btnDecimal.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnDecimal.setBounds(257, 575, 106, 80);
		frmCalculator.getContentPane().add(btnDecimal);
		
	}
	/**
	 * Resets calculator text field back to zero
	 */
	private void resetTextfield() {
		textField.setText("0");
	}
	
	/**
	 * Clears calculator label
	 */
	private void resetLabel() {
		prevOperation.setText("");
	}
	
	/**
	 * Sets string parameter to current text field
	 * 
	 * @param digit
	 */
	private void setDigit(String digit) {
		if(textField.getText().equals("0") || operatorPressed) {
			textField.setText(digit);
			operatorPressed = false;
		}
		else
			textField.setText(textField.getText() + digit);
	}
	
	/**
	 * Adds to current calculator label
	 * 
	 * @param operator
	 */
	private void operatorPressed(String operator) {
		if(!operatorPressed)
			prevOperation.setText(prevOperation.getText() + textField.getText() + " " + operator + " ");
		
		operatorPressed = true;
	}
}
