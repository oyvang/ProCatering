package gui;

import com.toedter.calendar.JCalendar;
import database.SecurityChecker;
import procatering.Customer;
import procatering.Employee;
import procatering.Helper;
import procatering.Order;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static procatering.Helper.DATABASE_NUMBER;
import static procatering.Helper.GUI_NUMBER;
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
		editStartValues();

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
	private JButton menuSeeOrdersButton;
	private JPanel backendMenu;
	private JButton backendEmployeeButton;
	private JButton backendCustomerButton;
	private JButton backendOrderButton;
	private JButton backendDishButton;
	private JButton backendEconomicButton;
	private JPanel topPanel;
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
	private DefaultListModel<Customer> nameList;
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
	private JComboBox singleOrderAddTimeComboBox;
	private JButton singleOrderAddTimeButton;
	private JTextArea singleOrderCustomerInformationTextfield;
	private JPanel singleOrderCustomerInformationPanel;
	private JPanel singleOrderDishdateInformationPanel;
	private JLabel singleOrderTimeLabel;
	private JCalendar singleOrderDatePicker;
	private JTextPane singleOrderCustomerInformationTextpane;
	private JTextPane singleOrderOrderInformationTextpane;
	private JButton singleOrderProgressButton;

	private JLabel Label;
	private JLabel singleOrderCustomerIdLabel;

	private Employee loggedInEmployee;

    private JPanel subscriptionMakePanel;
    private JPanel subscriptionConfirmPanel;
    private JPanel subscriptionStepPanel;
    private JPanel subscriptionInformationPanel;
    private JPanel subscripionStatusPanel;
    private JPanel subscriptionSelectTimePanel;
    private JPanel subscriptionSelectDishPanel;
    private JPanel subscriptionCustomerInformationPanel;
    private JPanel subscriptionOrderInformationPanel;
    private JTextPane subscriptionCustomerInformation;
    private JCalendar subscriptionDatePicker;
    private JTextPane SubscriptionOrderInformationTextPane;
    private JPanel subscriptionStartDateSelectionPane;
    private JPanel subscriptionEndDateSelectionPane;
    private JComboBox subscriptionThursdayTimeSelector;
    private JComboBox subscriptionMondayTimeSelector;
    private JComboBox subscriptionTuesayTimeSelector;
    private JLabel subscriptionActivationDateValueLabel;
    private JButton subscriptionActivationDateSubmitButton;
    private JLabel subscriptionTerminationDateValueLabel;
    private JButton subscriptionTerminationDateSubmitButton;
    private JComboBox subscriptionFridayTimeSelector;
    private JComboBox subscriptionSundayTimeSelector;
    private JComboBox subscriptionSaturdayTimeSelector;
    private JComboBox subscriptionWednesdayTimeSelector;
    private JButton subscriptionMondayTimeSubmitButton;
    private JButton subscriptionTuesdayTimeSubmitButton;
    private JButton subscriptionWednesdayTimeSubmitButton;
    private JButton subscriptionThursdayTimeSubmitButton;
    private JButton subscriptionFridayTimeSubmitButton;
    private JButton subscriptionSaturdayTimeSubmitButton;
    private JButton subscriptionSundayTimeSubmitButton;
    private JPanel subscriptionTimeSelectionPanel;
    private JPanel subscriptionWeekdaySelectionPanel;
	private JPanel singleOrderProgressPanel;
	private JTextPane singleOrderProgressLabel;
	private JComboBox comboBox1;
	private JList list1;
	private JList list2;
	private static String errorMessageTitle = "Error";



	private void initListeners(){
		/* Login button action listener */
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt){
				loginButtonActionPerformed(evt);
				menuFindButtonActionPerformed(evt);
			}
		});
		/* Password field action listener */
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
		/* Menu see orders button */
		menuSeeOrdersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				menuSeeOrdersButtonActionPerformed(evt);
			}
		});
		/* Customer search button */
		customerSearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt){
				customerSearchButtonActionPerformed();
			}
		});
		/* Customer search field listener*/
		customerSearchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(customerSearchField.getText().length() >= 5)
					customerSearchButtonActionPerformed();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
        /* Subscription Start date add calendar listener */
        subscriptionDatePicker.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);    //To change body of overridden methods use File | Settings | File Templates.
                subscriptionActivationDateValueLabel.setText(subscriptionDatePicker.getCalendar().toString());//TODO ted
            }
        });
		/* Customer registration button */
		registerNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt){
				registerNewButtonActionPerformed(evt);
			}
		});
		/* Postal Code search listener */
		postalCodeInputField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			/**
			 * Method queries database and inserts postal place into field.
			 */
			public void insertUpdate(DocumentEvent e) {
				if(postalCodeInputField.getText().length() == 4){
					postalCodeOutputLabel.setText(searchPostalCode(postalCodeInputField.getText()));
				}
			}

			@Override
			/**
			 * Method resets the postalCodeField
			 */
			public void removeUpdate(DocumentEvent e) {
				if(postalCodeInputField.getText().length() == 3){
					postalCodeOutputLabel.setText("N/A");
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		/* Phone number field listener */
		phonenumberInputField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				customerSearchField.setText(phonenumberInputField.getText());

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
		/* King kong*/ //TODO something
		customerList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() >= 2 && !customerList.isSelectionEmpty()){
					String[] options = new String[]{"Single order","Subscription"};
					String message = "Please select order type for "+customerList.getSelectedValue().toString()+":";
					int option = JOptionPane.showOptionDialog(ProCatering, message, "Choose subscription type",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
					if(option == 0)
						menuSingleOrderButtonActionPerformed(new Customer((Customer)customerList.getSelectedValue()));
					if(option == 1)
						menuSubscriptionButtonActionPerformed(new Customer((Customer)customerList.getSelectedValue()));

				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//To change body of implemented methods use File | Settings | File Templates.
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				//To change body of implemented methods use File | Settings | File Templates.
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				//To change body of implemented methods use File | Settings | File Templates.
			}

			@Override
			public void mouseExited(MouseEvent e) {
				//To change body of implemented methods use File | Settings | File Templates.
			}
		});

		singleOrderDatePicker.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(singleOrderDatePicker.getDate());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//To change body of implemented methods use File | Settings | File Templates.
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				//To change body of implemented methods use File | Settings | File Templates.
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				//To change body of implemented methods use File | Settings | File Templates.
			}

			@Override
			public void mouseExited(MouseEvent e) {
				//To change body of implemented methods use File | Settings | File Templates.
			}
		});

		singleOrderAddTimeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				singleOrderAddTimeButtonActionPerformed();
			}
		});

		singleOrderProgressButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				singleOrderProgressButtonActionPerfomed();
				System.out.println("Clicked");
			}
		});
	}
	/**
	 * Method editStartValues sets the visibility of elements in the gui.
	 */
	private void editStartValues(){
		loginErrorMessage_label.setVisible(false);
		singleOrderCustomerInformationTextpane.setContentType("text/html");
		singleOrderCustomerInformationTextpane.setEditable(false);
		singleOrderOrderInformationTextpane.setContentType("text/html");
		singleOrderOrderInformationTextpane.setEditable(false);
        subscriptionCustomerInformation.setContentType("text/html");
        subscriptionCustomerInformation.setEditable(false);
        SubscriptionOrderInformationTextPane.setContentType("text/html");
        SubscriptionOrderInformationTextPane.setEditable(false);
		Helper.addTimes(singleOrderAddTimeComboBox);
		employee_ID_input.setText("1");
		password_input.setText("abc");

		singleOrderProgressLabel.setText("<html><b>Select time & date</b> - Select dishes - Overview </html>");



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

        if(SecurityChecker.logIn(id, password)){
			loggedInEmployee = new Employee(Employee.getEmployee(id));
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
		loggedInEmployee = null;
	}

	private void menuFindButtonActionPerformed(ActionEvent evt) {
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		cl.show(mainPanel, "findPanelCard");
	}

	private void menuSingleOrderButtonActionPerformed(Customer customer){
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		cl.show(mainPanel, "singleOrderCard");
		generateOrder(customer);
	}

	private void generateOrder(Customer customer) {
		String t =	"<html>"+
						"<table valign='top'>"+
							"<tr>" +
								"<td>"+customer.getFirstName()+"</td></td>"+customer.getLastName()+"</td>"+
							"</tr>"+
							"<tr>" +
								"<td>Address: </td><td>"+customer.getAddress()+"<br>"+customer.getPostalCode()+" "+customer.getPostPlace(String.valueOf(customer.getPostalCode()))+"</td>"+
							"</tr>"+
							"<tr>" +
								"<td>Phone number: </td><td>"+customer.getPhoneNumber()+"</td>"+
							"</tr>"+
						"</table>"+
					"</html>";
		singleOrderCustomerInformationTextpane.setText(t);
		singleOrderCustomerIdLabel.setText(String.valueOf(customer.getCustomerID()));
		System.out.println(customer.getCustomerID());
		loggedInEmployee.createOrder(customer.getCustomerID());
		singleOrderUpdateTextpane();
	}

	private void singleOrderUpdateTextpane() {
		singleOrderOrderInformationTextpane.setText(loggedInEmployee.getOrder().toString());
	}

	private void menuSubscriptionButtonActionPerformed(Customer customer){
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		cl.show(mainPanel, "subscriptionOrderCard");
        generateSubscription(customer);
	}
    private void generateSubscription(Customer customer) {

        String t =	"<html>"+
                "<table valign='top'>"+
                "<tr>" +
                "<td>"+customer.getFirstName()+"</td></td>"+customer.getLastName()+"</td>"+
                "</tr>"+
                "<tr>" +
                "<td>Address: </td><td>"+customer.getAddress()+"<br>"+customer.getPostalCode()+" "+customer.getPostPlace(String.valueOf(customer.getPostalCode()))+"</td>"+
                "</tr>"+
                "<tr>" +
                "<td>Phone number: </td><td>"+customer.getPhoneNumber()+"</td>"+
                "</tr>"+
                "</table>"+
                "</html>";
        subscriptionCustomerInformation.setText(t);
    }

	private void menuSeeOrdersButtonActionPerformed(ActionEvent evt){
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		cl.show(mainPanel, "existOrderCard");
	}

	private void customerSearchButtonActionPerformed(){
		nameList = Customer.findCustomer(customerSearchField.getText());
		MouseListener[] lis = customerList.getMouseListeners(); //Extracts the mouselisteners before overwrite.

		customerList = new JList<Customer>(nameList);
			customerScrollPane.setViewportView(customerList);
		for (MouseListener li : lis) {
			customerList.addMouseListener(li);
		}
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
		Customer customer = new Customer(address, firstname, lastname, phoneNumber, email, postalCode, note);
		if(Customer.customerExist(customer)){
			String confirmMessage = "<html>" +
										"<h3>It seems like the person you are trying to add to the customer database already exists</h3>" +
										"<p>Please select the person from the list to the right.</p>" +
									"</html>";
			int confirm = JOptionPane.showConfirmDialog(ProCatering, confirmMessage, "Are you sure?", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
			System.out.println(confirm);
			//if(confirm != 0) //TODO FIXME
				gtg = false;
		}

		if(gtg){
			String confirmMessage = "<html>" +
										"<h3>This is the information you put in:</h3>" +
										"<table>" +
												"<tr><td>Firstname:</td><td>"+customer.getFirstName()+"</td></tr>" +
												"<tr><td>Lastname:</td><td>"+customer.getLastName()+"</td></tr>" +
												"<tr><td>Phone number:</td><td>"+customer.getPhoneNumber()+"</td></tr>" +
												"<tr><td>Address:</td><td>"+customer.getAddress()+"</td></tr>" +
												"<tr><td>Postal Code:</td><td>"+customer.getPostalCode()+" "+postalCodeOutputLabel.getText()+"</td></tr>"+
												"<tr><td>Email:</td><td>"+customer.getEmail()+"</td></tr>" +
									"</html>";
			int confirm = JOptionPane.showConfirmDialog(ProCatering, confirmMessage, "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(confirm == 0){
				customer.addCustomer(customer);
				clearCustomerFields();
			}
		}

	}

	private void singleOrderAddTimeButtonActionPerformed() {
		Date date = singleOrderDatePicker.getDate();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		int i = cal.get(Calendar.YEAR);
		int i1 = cal.get(Calendar.MONTH);//TODO move.
		int i2 = cal.get(Calendar.DATE);
		int i3 = Integer.parseInt(singleOrderAddTimeComboBox.getSelectedItem().toString().trim().substring(0, 2));
		Timestamp ts = new Timestamp(i-1900,i1,i2,i3,0,0,0); //TODO Possible fix this... NOT
		System.out.println(ts); //TODO remove
		if(loggedInEmployee.addOrderContent(ts))
			singleOrderUpdateTextpane();
		else
			showErrorMessage(GUI_NUMBER, 4, new Exception("Make sure you have selected a date in the future."));
	}

	private void singleOrderProgressButtonActionPerfomed() {
		CardLayout cl = (CardLayout)singleOrderStepPanel.getLayout();
		cl.show(singleOrderStepPanel, "singleOrderSelectDishCard");
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//							staticMethods															//
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Method showErrorMessage prints an error in a JOptionPane for the user.
	 * @param errorOrigin
	 * @param errorID
	 * @param exp
	 */
	public static void showErrorMessage(int errorOrigin, int errorID, Exception exp){
			JOptionPane.showMessageDialog(null, "Error "+errorOrigin+"."+errorID+": "+exp, errorMessageTitle, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Method clearCustomerFields clears the fields when adding a customer.
	 */
	private static void clearCustomerFields(){
		//TODO Create method
	}

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}