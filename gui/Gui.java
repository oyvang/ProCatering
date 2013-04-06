package gui;

import database.SecurityChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: zalox
 * Date: 03.04.13
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 */
public class Gui {
	public Gui() {
		initListeners();
	}

	public static void main(String[] args) {
		frame = new JFrame("Gui");
		frame.setContentPane(new Gui().ProCatering);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}catch (Exception e){
			System.out.println("Running default");
		}

		frame.pack();
		frame.setVisible(true);
	}
	private static JFrame frame;
	private JPanel loggedIn;
	private JPanel mainMenu;
	private JPanel costumerPanel;
	private JButton menuFindButton;
	private JPanel orderMenu;
	private JButton menuSingleOrderButton;
	private JButton menuExistingButton;
	private JButton menuSubscriptionButton;
	private JPanel backendMenu;
	private JButton backendEmployeeButton;
	private JButton backendCustomerButton;
	private JButton backendOrderButton;
	private JButton backendDishButton;
	private JButton backendEconomicButton;
	private JPanel topPanel;
	private JLabel currentPosition_label;
	private JPanel bottomPanel;
	private JButton log_out_button;
	private JPanel mainPanel;
	private JPanel findPanel;
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
	private JPanel notePanel;
	private JTextArea notesInputArea;
	private JPanel customerListPanel;
	private JScrollPane customerScrollPane;
	private JList customerList;
	private JButton customerSearchButton;
	private JTextField customerSearchField;
	private JPanel singleOrderPanel;
	private JPanel existOrderPanel;
	private JPanel subscriptionOrderPanel;
	private JPanel employeesBackendPanel;
	private JPanel customerBackendPanel;
	private JPanel orderBackendPanel;
	private JPanel dishBackendPanel;
	private JPanel economicBackendPanel;
	private JPanel ProCatering;
	private JLabel welcomeMessageLabel;
	private JPanel loginPanel;
	private JLabel Employee_ID_input_label;
	private JLabel loginErrorMessage_label;
	private JPasswordField password_input;
	private JTextField employee_ID_input;
	private JButton loginButton;
	private JLabel Password_input_label;
	private JPanel loggedOut;
	private JPanel welcomeMessagePanel;


	private void createUIComponents() {
		// TODO: place custom component creation code here
	}

	private void initListeners(){
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				loginButtonActionPerformed(evt);
			}
		});
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//							EventHandlers															//
	//////////////////////////////////////////////////////////////////////////////////////////////////////

    /** Method handles the actions performed when pushing the "Enter"-button in the loggedOutCard.
     * @param evt ActionEvent-object from the button pressing.
     * @return void
     * @author Jørgen Lien Sellæg
     *
     * */
	private void loginButtonActionPerformed(ActionEvent evt){
		CardLayout cl = (CardLayout)ProCatering.getLayout(); //Object for handling the cardLayout switch
        Integer id = 0;
		try{
        	id = Integer.parseInt(employee_ID_input.getText().trim());
        }catch(NumberFormatException e){
            employee_ID_input.setText("");
			loginErrorMessage_label.setVisible(true);
            loginErrorMessage_label.setText("The Employee ID-field must be a number");
        }

        String password = SecurityChecker.extractPasswordFromFieldToString(password_input.getPassword());

        if(SecurityChecker.logIn(id, password))
            cl.show(ProCatering,"loggedInCard");
        else{
			loginErrorMessage_label.setVisible(true);
			loginErrorMessage_label.setText("Login unsuccessful. Please check your information");
		}
	}
}