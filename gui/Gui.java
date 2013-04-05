package gui;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: zalox
 * Date: 03.04.13
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 */
public class Gui {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Gui");
		frame.setContentPane(new Gui().background);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}catch (Exception e){
			System.out.println("Running default");
		}

		frame.pack();
		frame.setVisible(true);
	}

	private JPanel background;
	private JPanel mainMenu;
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel costumerPanel;
	private JPanel orderMenu;
	private JPanel backendMenu;
	private JButton menuFindButton;
	private JButton menuSingleOrderButton;
	private JButton backendEmployeeButton;
	private JButton menuExistingButton;
	private JButton menuSubscriptionButton;
	private JButton backendCustomerButton;
	private JButton backendOrderButton;
	private JButton backendDishButton;
	private JButton backendEconomicButton;
	private JLabel currentPosition_label;
	private JPanel findPanel;
	private JPanel customerListPanel;
	private JPanel customerSearchPanel;
	private JLabel firstnameLabel;
	private JLabel lastnameLabel;
	private JLabel addressLabel;
	private JLabel postalCodeLabel;
	private JLabel postalCodeNameLabel;
	private JLabel phoneLabel;
	private JLabel emailLabel;
	private JLabel noteLabel;
	private JTextField firstnameInputField;
	private JTextField lastnameInputField;
	private JTextField addressInputField;
	private JTextField postalCodeInputField;
	private JTextField phonenumberInputField;
	private JTextField emailInputField;
	private JLabel postalCodeOutputLabel;
	private JButton registerNewButton;
	private JList customerList;
	private JButton customerSearchButton;
	private JTextField customerSearchField;
	private JScrollPane customerScrollPane;
	private JPanel notePanel;
	private JTextArea notesInputArea;
	private JButton log_out_button;
	private JPanel singleOrderPanel;


	private void createUIComponents() {
		// TODO: place custom component creation code here
	}

}
