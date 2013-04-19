package gui;

import com.michaelbaranov.microba.calendar.CalendarPane;
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
			UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
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
	private JButton logOutButton;
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
	private JPanel singleOrderMakePanel;
	private JPanel singleOrderConfimPanel;
	private JPanel singleOrderInformationPanel;
	private JPanel singleOrderStepPanel;
	private JPanel singleOrderStatusPanel;
	private JPanel singleOrderSelectDatePanel;
	private JPanel singleOrderDatePanel;
	private JPanel singleOrderSelectDishPanel;
	private JLabel singleOrderProgressLabel;
	private CalendarPane singleOrderDatePicker;
	private JComboBox singleOrderAddTimeComboBox;
	private JButton singleOrderAddTimeButton;
	private JTextArea singleOrderCustomerInformationTextfield;
	private JPanel singleOrderCustomerInformationPanel;
	private JPanel singleOrderDishdateInformationPanel;
	private JLabel singleOrderTimeLabel;
	private JTextArea singleOrderDishInformationTextField;
	private static String errorMessageTitle = "Error";


	private void createUIComponents() {
		// TODO: place custom component creation code here
	}

	private void initListeners(){
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt){
				loginButtonActionPerformed(evt);
			}
		});
		/* Log Out-button */
		logOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				logOutButtonActionPerformed(evt);
			}
		});
		/* Menu Register/Find customer button */
		menuFindButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				menuFindButtonActionPerformed(evt);
			}
		});
		/* Menu Single order button */
		menuSingleOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				menuSingleOrderButtonActionPerformed(evt);
			}
		});
		/* Menu existing order button */
		menuExistingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				menuExistingButtonActionPerformed(evt);
			}
		});
		/* Menu subscription button */
		menuSubscriptionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				menuSubscriptionButtonActionPerformed(evt);
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
     * //TODO Write more documentation
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

        //if(SecurityChecker.logIn(id, password))
        if(true)
            cl.show(ProCatering,"loggedInCard");
        else{
			loginErrorMessage_label.setVisible(true);
			loginErrorMessage_label.setText("Login unsuccessful. Please check your information");
		}
	}
	//TODO add logOutCode
	private void logOutButtonActionPerformed(ActionEvent evt) {
		CardLayout cl = (CardLayout)ProCatering.getLayout();
		cl.show(ProCatering, "loggedOutCard");
	}

	private void menuFindButtonActionPerformed(ActionEvent evt) {
		CardLayout cl = (CardLayout)ProCatering.getLayout();
		cl.show(ProCatering, "loggedOutCard");
	}

	private void menuSingleOrderButtonActionPerformed(ActionEvent evt){
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		cl.show(mainPanel, "singleOrderPanelCard");
	}

	private void menuExistingButtonActionPerformed(ActionEvent evt){
		System.out.println("ButtonClicked");
	}

	private void menuSubscriptionButtonActionPerformed(ActionEvent evt){
		System.out.println("ButtonClicked");
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//							staticMethods															//
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void showErrorMessage(String errorOrigin, String errorID, Exception exp){
			JOptionPane.showMessageDialog(null, "Error "+errorOrigin+"."+errorID+": "+exp, errorMessageTitle, JOptionPane.ERROR_MESSAGE);
	}
}