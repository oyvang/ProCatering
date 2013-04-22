package gui;

import com.michaelbaranov.microba.calendar.CalendarPane;
import database.SecurityChecker;
import procatering.Customer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static procatering.Helper.GUI_NUMBER;
import static procatering.Helper.errorMessage;
import static procatering.Helper.searchPostalCode;

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
		setVisibility();
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
				menuFindButtonActionPerformed(evt);
			}
		});
		password_input.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				loginButtonActionPerformed(evt);
				menuFindButtonActionPerformed(evt);
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
		/* Customer search button */
		customerSearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt){
				customerSearchButtonActionPerformed();
			}
		});

		customerSearchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(customerSearchField.getText().length() >= 5)
					customerSearchButtonActionPerformed();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				//To change body of implemented methods use File | Settings | File Templates.
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//To change body of implemented methods use File | Settings | File Templates.
			}
		});
		/* Customer registration button */
		registerNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt){
				registerNewButtonActionPerformed(evt);
			}
		});

		postalCodeInputField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String saved = "";
				if(postalCodeInputField.getText().length() == 4){
					saved = postalCodeInputField.getText();
					postalCodeOutputLabel.setText(searchPostalCode(postalCodeInputField.getText()));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
	}



	private void setVisibility(){
		loginErrorMessage_label.setVisible(false);
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
		//TODO validate data.
		try{
        	id = Integer.parseInt(employee_ID_input.getText().trim());
        }catch(NumberFormatException e){
            employee_ID_input.setText("");
			loginErrorMessage_label.setVisible(true);
            loginErrorMessage_label.setText("The Employee ID-field must be a number");
        }

		String password = SecurityChecker.extractPasswordFromFieldToString(password_input.getPassword());

        if(SecurityChecker.logIn(id, password)){
            cl.show(ProCatering,"loggedInCard");
			employee_ID_input.setText("");
			password_input.setText("");
		}
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
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		cl.show(mainPanel, "findPanelCard");
	}

	private void menuSingleOrderButtonActionPerformed(ActionEvent evt){
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		cl.show(mainPanel, "singleOrderPanelCard");
	}

	private void menuExistingButtonActionPerformed(ActionEvent evt){
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		cl.show(mainPanel, "existOrderCard");
	}

	private void menuSubscriptionButtonActionPerformed(ActionEvent evt){
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		cl.show(mainPanel, "subscriptionOrder");
	}

	private void customerSearchButtonActionPerformed(){
		DefaultListModel<Customer> nameList = Customer.findCustomer(customerSearchField.getText());
		customerList = new JList<Customer>(nameList);
		customerScrollPane.setViewportView(customerList);
	}

	private void registerNewButtonActionPerformed(ActionEvent evt){
		Boolean gtg = true;
		String firstname 	= firstnameInputField.getText().trim();
		String lastname 	= lastnameInputField.getText().trim();
		String address 		= addressInputField.getText().trim();
		int postalCode = 0;
		try{
		postalCode	 	= Integer.parseInt(postalCodeInputField.getText().trim());
		}catch(NumberFormatException e){
			showErrorMessage(GUI_NUMBER, 1, new Exception("Postal code needs a numeric value"));
			gtg = false;
		}
		String phoneNumber 	= phonenumberInputField.getText().trim();
		String email 		= emailInputField.getText().trim();
		
		String note = notesInputArea.getText().trim();
		
		if(firstname.isEmpty() || lastname.isEmpty() || address.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()){
			showErrorMessage(GUI_NUMBER, 2, new Exception("All fields except note and email needs to be filled."));
			gtg = false;
		}

		if(gtg){
			Customer customer = new Customer(address, firstname, lastname, phoneNumber, email, postalCode);
			String confirmMessage = "<h3>This is the information you put in:<h3><br><p>Firstname: "+customer.getFirstName()+"</p>";
			int confirm = JOptionPane.showConfirmDialog(null, confirmMessage, "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(confirm == 0)
				customer.addCustomer(customer);
		}

	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//							staticMethods															//
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void showErrorMessage(int errorOrigin, int errorID, Exception exp){
			JOptionPane.showMessageDialog(null, "Error "+errorOrigin+"."+errorID+": "+exp, errorMessageTitle, JOptionPane.ERROR_MESSAGE);
	}
}