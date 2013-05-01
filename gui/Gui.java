package gui;

import com.toedter.calendar.JCalendar;
import database.SecurityChecker;
import procatering.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static procatering.Helper.GUI_NUMBER;
import static procatering.Helper.searchPostalCode;

/**
 *
 */
public class Gui {
	private static JFrame frame;
	private static String errorMessageTitle = "Error";
	private static String currentStepCard;
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
	private JLabel customerIdLabel;
	private JLabel singleOrderCustomerIdLabel;
	private Employee loggedInEmployee;
	private JPanel subscriptionMakePanel;
	private JPanel subscriptionConfirmPanel;
	private JPanel subscriptionStepPanel;
	private JPanel subscriptionInformationPanel;
	private JPanel subscripionProgressPanel;
	private JPanel subscriptionSelectTimePanel;
	private JPanel subscriptionSelectDishPanel;
	private JPanel subscriptionCustomerInformationPanel;
	private JPanel subscriptionOrderInformationPanel;
	private JTextPane subscriptionCustomerInformation;
	private JCalendar subscriptionDatePicker;
	private JTextPane SubscriptionOrderInformationTextPane;
	private JPanel subscriptionStartDateSelectionPane;
	private JPanel subscriptionEndDateSelectionPane;
	private JComboBox subscriptionDaySelector;
	private JComboBox subscriptionTimeSelector;
	private JLabel subscriptionActivationDateValueLabel;
	private JButton subscriptionActivationDateSubmitButton;
	private JLabel subscriptionTerminationDateValueLabel;
	private JButton subscriptionTerminationDateSubmitButton;
	private JButton subscriptionAddDayButton;
	private JButton subscriptionRemoveDayButton;
	private JPanel subscriptionTimeSelectionPanel;
	private JPanel subscriptionWeekdaySelectionPanel;
	private JComboBox singleOrderTimesComboBox;
	private JList<Category> singleOrderDishSelectCategoryJList;
	private JList singleOrderDishSelectDishJList;
	private JLabel singleOrderSelectTimeLabel;
	private JLabel singleOrderDishCategoryLabel;
	private JLabel singleOrderDishDishLabel;
	private JScrollPane singleOrderDishSelectCategoryScrollPane;
	private JScrollPane singleOrderDishSelectDishScrollPane;
	private JButton singleOrderDishAddButton;
	private JButton singleOrderProgressBackButton;
	private JSpinner singleOrderDishSpinner;
	private JPanel singleOrderAddPanel;
	private JList subscriptionSelectCategoryJList;
	private JList subscriptionSelectDishJList;
	private JTextPane subscriptionProgressTextArea;
	private JButton subscriptionBackButton;
	private JButton subscriptionNextButton;
	private JPanel subscriptionProgressAreaPanel;
	private JPanel subscriptionProgressButtonPanel;
	private JComboBox subscriptionSelectDayComboBox;
	private JComboBox subscriptionEmergencySpacerComboBox;
	private JPanel subscriptionSelectCategoryJListPanel;
	private JScrollPane subscriptionSelectCategoryScrollPane;
	private JPanel subscriptionSelectDishJListPanel;
	private JScrollPane subscriptionSelectDishScrollPane;
	private JSpinner subscriptionDishCountSpinner;
	private JButton subscriptionDishAddButtion;
	private JTextPane subscriptionConfirmContactInformationTextPane;
	private JPanel subscriptionProgressConfirmTextPanel;
	private JTextPane subscriptionProgressConfirmTextPane;
	private JButton subscriptionUnconfirmButton;
	private JTextPane subscriptionConfirmOrderInformationTextPane;
	private JTextPane subscriptionConfirmPaymenttInformationTextPane;
	private JPanel subscriptionConfirmContentPanel;
	private JTextPane subscriptionConfirmShipmentInformationTextPane;
	private JButton subscriptionConfirmOrderButton;
	private JTabbedPane existOrderTabbedPane;
	private JTextPane singleOrderOverviewTextPane;
	private JTextPane subscriptionOverviewTextPane;
	private JPanel singleOrderTab;
	private JPanel archiveTab;
	private JPanel chefTab;
	private JTextPane existOrderChefOrdersTextPane;
	private JTextPane existOrderChefSubscriptionsTextPane;
	private JScrollPane existOrderChefOrdersScrollPane;
	private JScrollPane existOrderChefSubscriptionsScrollPane;
	private JTextPane singleOrderCustomerConfirm;
	private JTextPane singleOrderOrderConfirm;
	private JTextPane singleOrderPaymentConfirm;
	private JSpinner singleOrderDiscountSpinner;
	private JButton placeOrderButton;
	private JLabel loggedInEmployeeLabel;
	private JButton singleOrderRemoveTimeButton;
	private JButton addSingleOrderButton;
	private JTabbedPane tabbedPane1;
	private JPanel addEmployeePanel;
	private JPanel seeEmployeePanel;
	private JList employeeList;
	private JTextPane aboutEmployeeTextPane;
	private JTextField employeeFirstname;
	private JTextField employeeLastname;
	private JTextField employeeAdress;
	private JTextField employeePostalCode;
	private JTextField employeePhonenumber;
	private JTextField employeeEmail;
	private JLabel employeePostalCodeLabel;
	private JButton addEmployeeButton;
	private JPasswordField employeePasswordField;
	private JList subscriptionSelectList;
	private JList singleOrderSelectList;
	private JPanel subscriptionTab;
	private JTable table1;
	private JTabbedPane tabbedPane2;
	private ArrayList<String> jBoxLabels = new ArrayList<>(15);

	public Gui() {
		initListeners();
		editStartValues();
	}

	public static void main(String[] args) {
		frame = new JFrame("Gui");
		frame.setContentPane(new Gui().ProCatering);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			System.out.println("Running default");
		}

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Method showErrorMessage prints an error in a JOptionPane for the user.
	 *
	 * @param errorOrigin the origin of the Error.
	 * @param errorID the ID of the Error.
	 * @param exp the exception.
	 */
	public static void showErrorMessage(int errorOrigin, int errorID, Exception exp) {
		Boolean debug = true;
		if (debug)
			JOptionPane.showMessageDialog(null, "Error " + errorOrigin + "." + errorID + ": " + exp, errorMessageTitle, JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Error " + errorOrigin + "." + errorID + ": " + exp.getMessage(), errorMessageTitle, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Method clearCustomerFields clears the fields when adding a customer.
	 */
	private static void clearCustomerFields() {
		//TODO Create method
	}

	/**
	 * Initializes all the listeners in the GUI
	 * @author Jørgen Lien Sellæg & Ted Kristoffersen
	 */
	private void initListeners() {
		/* Login button action listener */
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				loginButtonActionPerformed();
				menuFindButtonActionPerformed();
			}
		});
		/* Password field action listener */
		password_input.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				loginButtonActionPerformed();
				menuFindButtonActionPerformed();
			}
		});
		/* Log Out-button */
		logOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				logOutButtonActionPerformed();
			}
		});
		/* Menu Register/Find customer button */
		menuFindButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				menuFindButtonActionPerformed();
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
			public void actionPerformed(ActionEvent evt) {
				customerSearchButtonActionPerformed();
			}
		});
		/* Customer search field listener*/
		customerSearchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if (customerSearchField.getText().length() >= 5)
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
		subscriptionDatePicker.addPropertyChangeListener("calendar", new PropertyChangeListener() {


			@Override
			public void propertyChange(PropertyChangeEvent e) { //TODO TED: Fix timestamp format
				Date date = subscriptionDatePicker.getDate();
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(date);
				int dd = c.get(Calendar.DATE);
				int mm = c.get(Calendar.MONTH);
				int yy = c.get(Calendar.YEAR);
				int hh = c.get(Calendar.HOUR);                         // TODO: Fix bug, "today" isn't choosable as activation date.
				if (loggedInEmployee.getSubscription().getStartDate() == null) {
					Timestamp ts = new Timestamp(yy - 1900, mm, dd, hh, 0, 0, 0);
					System.out.println("orderdate: " + loggedInEmployee.getSubscription().getOrderDate());
					System.out.println("active date: " + ts);
					if (ts.after(loggedInEmployee.getSubscription().getOrderDate())) {
						subscriptionActivationDateValueLabel.setText(ts.toString());
						subscriptionActivationDateValueLabel.setForeground(Color.black);
						subscriptionActivationDateSubmitButton.setEnabled(true);
					} else {
						subscriptionActivationDateValueLabel.setText(ts.toString() + "to early");
						subscriptionActivationDateValueLabel.setForeground(Color.red);
					}
				} else {
					Timestamp ts2 = new Timestamp(yy - 1900, mm, dd, 0, 0, 0, 0);
					if (ts2.before(loggedInEmployee.getSubscription().getStartDate())) {
						subscriptionTerminationDateValueLabel.setText(ts2.toString() + "to early");
						subscriptionTerminationDateValueLabel.setForeground(Color.red);
					} else {
						subscriptionTerminationDateValueLabel.setText(ts2.toString());
						subscriptionTerminationDateValueLabel.setForeground(Color.black);
						subscriptionTerminationDateSubmitButton.setEnabled(true);
					}
				}
			}
		});
		subscriptionActivationDateSubmitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subscriptionActivationDateSubmitButtonActionPerformed();
			}
		});
		subscriptionTerminationDateSubmitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subscriptionTerminationDateSubmitButtonActionPerformed();
			}
		});
		subscriptionAddDayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subscriptionDayAddButtonActionPerformed();
			}
		});
		subscriptionRemoveDayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subscriptionDayRemoveButtonActionPerformed();
			}
		});
		subscriptionNextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subscriptionNextButtonActionPerformed();
				System.out.println("Subscription progress Next Clicked");
			}
		});
		subscriptionDishAddButtion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSubscriptionDishAddButtionActionPerformed();
			}
		});
		subscriptionConfirmOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subscriptionConfirmOrderButtonActionPerformed();
			}
		});



		/* Customer registration button */
		registerNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				registerNewButtonActionPerformed();
			}
		});
		/* Postal Code search listener */
		postalCodeInputField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			/**
			 * Method queries database and inserts postal place into field.
			 */
			public void insertUpdate(DocumentEvent e) {
				if (postalCodeInputField.getText().length() == 4) {
					postalCodeOutputLabel.setText(searchPostalCode(postalCodeInputField.getText()));
				}
			}

			@Override
			/**
			 * Method resets the postalCodeField
			 */
			public void removeUpdate(DocumentEvent e) {
				if (postalCodeInputField.getText().length() == 3) {
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
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		/* King kong*/ //TODO something
		customerList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() >= 2 && !customerList.isSelectionEmpty()) {
					String[] options = new String[]{"Single order", "Subscription"};
					String message = "Please select order type for " + customerList.getSelectedValue().toString() + ":";
					int option = JOptionPane.showOptionDialog(ProCatering, message, "Choose subscription type", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
					if (option == 0)
						menuSingleOrderButtonActionPerformed();
					if (option == 1)
						menuSubscriptionButtonActionPerformed();

				}
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		singleOrderDatePicker.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(singleOrderDatePicker.getDate());
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});

		singleOrderAddTimeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				singleOrderAddTimeButtonActionPerformed();
				singleOrderProgressButtonActionPerfomed(e);
			}
		});

		singleOrderProgressButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				singleOrderProgressButtonActionPerfomed(e);
			}
		});
		singleOrderProgressBackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backButtonActionPerformed();
			}
		});

		subscriptionSelectCategoryJList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				subscriptionSelectCategoryJListActionPerformed();
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		singleOrderDishSelectCategoryJList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				singleOrderDishSelectCategoryJListActionPerfomed();
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});

		singleOrderDishAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				singleOrderDishAddButtonActionPerformed();
				singleOrderProgressButtonActionPerfomed(e);
			}
		});

		singleOrderRemoveTimeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				singleOrderRemoveTimeActionPerformed();
			}
		});

		addSingleOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addSingleOrderButtonActionPerformed(e);
			}
		});

		addEmployeeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addEmployeeButtonActionPerformed(e);
			}
		});
		employeePostalCode.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				if (employeePostalCode.getText().length() == 4) {
					employeePostalCodeLabel.setText(searchPostalCode(employeePostalCode.getText()));
				}
			}

			@Override
			/**
			 * Method resets the postalCodeField
			 */
			public void removeUpdate(DocumentEvent e) {
				if (employeePostalCode.getText().length() == 3) {
					employeePostalCodeLabel.setText("N/A");
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});

		backendEmployeeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backendEmployeeButtonActionPerformed(e);
			}
		});

		employeeList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				populateEmployeeInformation(e);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});

		singleOrderSelectList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Order order = (Order) singleOrderSelectList.getSelectedValue();
				singleOrderOverviewTextPane.setText(order.confirmToHtml());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});

    subscriptionSelectList.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Subscription order = (Subscription) subscriptionSelectList.getSelectedValue();
            subscriptionOverviewTextPane.setText(order.confirmToHtml());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    });

	backendEconomicButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			backendEconomicButtonActionPerfomed();
		}
	});
}

	/**
	 * Method editStartValues sets the visibility of elements in the gui.
	 */
	private void editStartValues() {
		loginErrorMessage_label.setVisible(false);
        subscriptionOverviewTextPane.setContentType("text/html");
        subscriptionOverviewTextPane.setEditable(false);
		singleOrderCustomerInformationTextpane.setContentType("text/html");
		singleOrderCustomerInformationTextpane.setEditable(false);
		singleOrderOrderInformationTextpane.setContentType("text/html");
		singleOrderOrderInformationTextpane.setEditable(false);
		subscriptionCustomerInformation.setContentType("text/html");
		subscriptionCustomerInformation.setEditable(false);
		SubscriptionOrderInformationTextPane.setContentType("text/html");
		SubscriptionOrderInformationTextPane.setEditable(false);
		aboutEmployeeTextPane.setContentType("text/html");
		singleOrderOverviewTextPane.setContentType("text/html");
		singleOrderOverviewTextPane.setEnabled(false);
		existOrderChefOrdersTextPane.setContentType("text/html");
		existOrderChefOrdersTextPane.setEditable(false);
		existOrderChefSubscriptionsTextPane.setContentType("text/html");
		existOrderChefSubscriptionsTextPane.setEditable(false);

		Helper.addTimes(singleOrderAddTimeComboBox);
		employee_ID_input.setText("1");//TODO remove
		password_input.setText("abc");//TODO remove
		//singleOrderProgressLabel.setText("<html><b>Select time & date</b> - Select dishes - Overview </html>");
		singleOrderProgressBackButton.setEnabled(false);
		singleOrderDiscountSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	}

	/**
	 * Method handles the actions performed when pushing the "Enter"-button in the loggedOutCard.
	 *
	 * @author Jørgen Lien Sellæg
	 * //TODO Write more documentation
	 */
	private void loginButtonActionPerformed() {
		CardLayout cl = (CardLayout) ProCatering.getLayout(); //Object for handling the cardLayout switch
		Integer id = 0;
		try {
			id = Integer.parseInt(employee_ID_input.getText().trim());
		} catch (NumberFormatException e) {
			employee_ID_input.setText("");
			loginErrorMessage_label.setVisible(true);
			loginErrorMessage_label.setText("The Employee ID-field must be a number");
		}

		String password = SecurityChecker.extractPasswordFromFieldToString(password_input.getPassword());

		if (SecurityChecker.logIn(id, password)) {
			loggedInEmployee = Employee.getEmployee(id);
			cl.show(ProCatering, "loggedInCard");
			loggedInEmployeeLabel.setText("Logged in employee " + loggedInEmployee.getFirstName() + " " + loggedInEmployee.getLastName());
			employee_ID_input.setText("");
			password_input.setText("");
		} else {
			loginErrorMessage_label.setVisible(true);
			loginErrorMessage_label.setText("Login unsuccessful. Please check your information");
		}
	}

	private void subscriptionUpdateTextpane() {
		SubscriptionOrderInformationTextPane.setText(loggedInEmployee.getSubscription().toHtml());
	}

	private void logOutButtonActionPerformed() {
		CardLayout cl = (CardLayout) ProCatering.getLayout();
		cl.show(ProCatering, "loggedOutCard");
		loggedInEmployee = null;
		loginErrorMessage_label.setVisible(true);
		currentStepCard = null;
	}//TODO add logout

	private void menuFindButtonActionPerformed() {
		CardLayout cl = (CardLayout) mainPanel.getLayout();
		cl.show(mainPanel, "findPanelCard");
	}

	private void menuSingleOrderButtonActionPerformed() {
		CardLayout cl = (CardLayout) mainPanel.getLayout();
		cl.show(mainPanel, "singleOrderCard");
		currentStepCard = "singleOrderSelectDateCard";
		generateOrder();
	}

	private void generateOrder() {
		Customer customer = (Customer) customerList.getSelectedValue();
		String t = "<html>" +
				"<table valign='top'>" +
				"<tr>" +
				"<td>" + customer.getFirstName() + "</td></td>" + customer.getLastName() + "</td>" +
				"</tr>" +
				"<tr>" +
				"<td>Address: </td><td>" + customer.getAddress() + "<br>" + customer.getPostalCode() + " " + customer.getPostPlace(String.valueOf(customer.getPostalCode())) + "</td>" +
				"</tr>" +
				"<tr>" +
				"<td>Phone number: </td><td>" + customer.getPhoneNumber() + "</td>" +
				"</tr>" +
				"</table>" +
				"</html>";
		singleOrderCustomerInformationTextpane.setText(t);
		singleOrderCustomerIdLabel.setText(String.valueOf(customer.getCustomerID()));
		loggedInEmployee.createOrder(customer.getCustomerID());
		singleOrderUpdateTextpane();
	}

	private void singleOrderUpdateTextpane() {
		singleOrderOrderInformationTextpane.setText(loggedInEmployee.getOrder().toHtml());
	}

	private void menuSubscriptionButtonActionPerformed() {
		CardLayout cl = (CardLayout) mainPanel.getLayout(); //TODO HER TED
		cl.show(mainPanel, "subscriptionOrderCard");
		generateSubscription();
		subscriptionProgressTextArea.setText("<html><b>Select Day/Time</b> - Select dishes - Overview </html>");
	}

	private void generateSubscription() {
		Customer customer = (Customer) customerList.getSelectedValue();
		String t = "<html>" +
				"<table valign='top'>" +
				"<tr>" +
				"<td>" + customer.getFirstName() + "</td></td>" + customer.getLastName() + "</td>" +
				"</tr>" +
				"<tr>" +
				"<td>Address: </td><td>" + customer.getAddress() + "<br>" + customer.getPostalCode() + " " + customer.getPostPlace(String.valueOf(customer.getPostalCode())) + "</td>" +
				"</tr>" +
				"<tr>" +
				"<td>Phone number: </td><td>" + customer.getPhoneNumber() + "</td>" +
				"</tr>" +
				"</table>" +
				"</html>";
		subscriptionCustomerInformation.setText(t); //TODO TED TED
		if (loggedInEmployee.createSubscription(customer.getCustomerID())) {
			System.out.println("Subscription ojbect created.");
		} else {
			System.out.println("Error while trying to create subscription ");
		}
		subscriptionUpdateTextpane();
	}

	private void subscriptionDayAddButtonActionPerformed() {
		int t = Integer.parseInt(subscriptionTimeSelector.getSelectedItem().toString().substring(0, 2));
		int m = Integer.parseInt(subscriptionTimeSelector.getSelectedItem().toString().substring(3));
		String day = subscriptionDaySelector.getSelectedItem().toString();

		Timestamp time = new Timestamp(loggedInEmployee.getSubscription().getStartDate().getYear(), loggedInEmployee.getSubscription().getStartDate().getMonth(), loggedInEmployee.getSubscription().getStartDate().getDate(), t, m, 0, 0);
		if (loggedInEmployee.getSubscription().addOrderContent(day, time)) {
			subscriptionUpdateTextpane();
		}
	}

	private void subscriptionDayRemoveButtonActionPerformed() {
		String day = subscriptionDaySelector.getSelectedItem().toString();
		if (loggedInEmployee.getSubscription().removeOrderContent(day)) {
			subscriptionUpdateTextpane();
		}
	}

	private void subscriptionActivationDateSubmitButtonActionPerformed() {
		System.out.println("addbutton pushed");
		Date date = subscriptionDatePicker.getDate();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH);//TODO move.
		int dd = cal.get(Calendar.DATE);
		int time = Integer.parseInt(singleOrderAddTimeComboBox.getSelectedItem().toString().trim().substring(0, 2));
		Timestamp ts = new Timestamp(yy - 1900, mm, dd, 0, 0, 0, 0); //TODO Possible fix this... NOT
		System.out.println(ts); //TODO remove
		if (loggedInEmployee.addSubscriptionStartDate(ts)) {
			System.out.println("SubscriptionStartDate added!");
		} else {
			System.out.println("Error while trying to make subscription object");
		}
		subscriptionUpdateTextpane();
		subscriptionEndDateSelectionPane.setEnabled(true);
		subscriptionTerminationDateValueLabel.setEnabled(true);
		subscriptionTerminationDateSubmitButton.setEnabled(true);
	}

	private void subscriptionTerminationDateSubmitButtonActionPerformed() {
		Date date = subscriptionDatePicker.getDate();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH);//TODO move.
		int dd = cal.get(Calendar.DATE);
		int time = Integer.parseInt(singleOrderAddTimeComboBox.getSelectedItem().toString().trim().substring(0, 2));
		Timestamp ts = new Timestamp(yy - 1900, mm, dd, 0, 0, 0, 0); //TODO Possible fix this... NOT
		System.out.println(ts); //TODO remove
		if (loggedInEmployee.addSubscriptionEndDate(ts)) {
			System.out.println("SubscriptionStartDate added!");
		} else {
			System.out.println("Error while trying to make subscription object");
		}
		subscriptionUpdateTextpane();
	}

	private void subscriptionNextButtonActionPerformed() {
		if (loggedInEmployee.getSubscription().getContent().isEmpty()) {
			CardLayout cl = (CardLayout) subscriptionStepPanel.getLayout();
			cl.show(subscriptionStepPanel, "subscriptionSelectTimeCard");
			showErrorMessage(GUI_NUMBER, 5, new Exception("Please select Days before you can continue"));
		} else if (!loggedInEmployee.getSubscription().getContent().getElementAt(0).getDishes().isEmpty()) { // If there is dishes added to the first element TODO: possible creating error if added day without dishes
			int option = JOptionPane.showOptionDialog(ProCatering, "Have you added all the Dishes into the order?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
			if (option == 0) {
				subscriptionPopulateConfirmPane();
			}
		} else {
			int option = JOptionPane.showOptionDialog(ProCatering, "Have you added all the Days/times into the order?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
			if (option == 0) {
				subscriptionProgressTextArea.setText("<html>Select Day/Time - <b>Select dishes</b> - Overview </html>");
				subscriptionBackButton.setEnabled(true);
				CardLayout cl = (CardLayout) subscriptionStepPanel.getLayout();
				cl.show(subscriptionStepPanel, "subscriptionSelectDishCard");
				DefaultListModel<OrderContent> orderContent = loggedInEmployee.getSubscription().getContent();
				for (int i = 0; i < orderContent.size(); i++) {
					subscriptionSelectDayComboBox.addItem(orderContent.get(i)); //TODO fix the toString
				}

				populateSubscriptionCategoryLists();

			}
		}
	}

	public void subscriptionPopulateConfirmPane() {
		subscriptionConfirmContactInformationTextPane.setText(subscriptionCustomerInformation.getText());
		CardLayout cl = (CardLayout) subscriptionOrderPanel.getLayout();
		cl.show(subscriptionOrderPanel, "subscriptionConfirmCard");
		subscriptionProgressConfirmTextPane.setText("<html>Select Day/Time - Select dishes -<b> Overview </b></html>");
		subscriptionConfirmOrderInformationTextPane.setText("Order information:<br>" + loggedInEmployee.getSubscription());//TODO Make presentation methods for order content.
		subscriptionConfirmPaymenttInformationTextPane.setText("Under construction");//TODO Make presentation methods for payment
		subscriptionConfirmShipmentInformationTextPane.setText("Under construction");
	}

	private void setSubscriptionDishAddButtionActionPerformed() {
		Dish dish = (Dish) subscriptionSelectDishJList.getSelectedValue();
		System.out.println("dish = " + dish); //TODO remove
		int q = Integer.parseInt(subscriptionDishCountSpinner.getValue().toString());
		System.out.println("q = " + q);    //TODO Remove
		int i = subscriptionSelectDayComboBox.getSelectedIndex();
		System.out.println("i = " + i); //TODO remove

		//System.out.println(singleOrderTimesComboBox.getSelectedItem());
		if (loggedInEmployee.getSubscription().addDish(dish, q, i)) {
			System.out.println("DET GIKK BRA");
			subscriptionUpdateTextpane();
		} else
			System.out.println("Alt gikk GALT!");
	}

	private void subscriptionConfirmOrderButtonActionPerformed() {
		if (loggedInEmployee.addSubscription()) {
			JOptionPane.showConfirmDialog(null, "The subscription was successfully savesd!");
		} else {
			JOptionPane.showConfirmDialog(null, "Something went wrong while saving the subscription!");
		}
	}

	private void populateSubscriptionCategoryLists() {
		DefaultListModel<Category> categoriesList = loggedInEmployee.getCategories();
		subscriptionSelectCategoryJList.setModel(categoriesList);
		subscriptionSelectCategoryScrollPane.setViewportView(subscriptionSelectCategoryJList);
	}

	private void subscriptionSelectCategoryJListActionPerformed() {
		Category cat = (Category) subscriptionSelectCategoryJList.getSelectedValue();
		subscriptionSelectDishJList.setModel(loggedInEmployee.getDishes(cat.getCategoryID()));

	}

	private void menuSeeOrdersButtonActionPerformed(ActionEvent evt) {
		CardLayout cl = (CardLayout) mainPanel.getLayout();
		cl.show(mainPanel, "existOrderCard");
		existOrderPopulate();
        existSubscriptionPopulate();
		chefSeeOrderPopulate();
		chefSeeSubscriptionPopulate();

	}

	private void chefSeeSubscriptionPopulate() {
		java.util.Date time = new java.util.Date();
		Timestamp date = new Timestamp(time.getTime());
		GregorianCalendar cal = new GregorianCalendar();
		SimpleDateFormat  fore = new SimpleDateFormat("EEEE");
		ArrayList<String[]> list = loggedInEmployee.getTodaySubscription(date.toString().substring(0, 10)+" 00:00:00");
		String html = "<html><h1>Current active subscriptions</h1>";
		html += "<h2>Today is "+fore.format(time)+"</h2>";
		if(list.isEmpty())
			html += "<p>No single orders today. </p>";
		else{
			html += "<table><tr><td>Amount</td><td>Time of delivery</td><td>Dish</td><td>First name</td><td>Last name</td></tr>";
			for (int i = 0; i < list.size(); i++) {
				html += "<tr>";
				for (int j = 0; j < list.get(i).length; j++) {
					html += "<td>"+list.get(i)[j]+"</td>";
				}
				html += "</tr>";
			}
			html += "</table>";
		}
		existOrderChefSubscriptionsTextPane.setText(html);
	}

	private void chefSeeOrderPopulate() {
		java.util.Date time = new java.util.Date();
		Timestamp date = new Timestamp(time.getTime());
		ArrayList<String[]> list = loggedInEmployee.getTodayOrder(date.toString().substring(0, 10));

		String html = "<html><h1>Orders today</h1>";

		if(list.isEmpty())
			html += "<p>No single orders today. </p>";
		else{
			html += "<table><tr><td>Amount</td><td>Dish</td><td>Day</td><td>First name</td><td>Last name</td></tr>";
			for (int i = 0; i < list.size(); i++) {
				html += "<tr>";
				for (int j = 0; j < list.get(i).length; j++) {
					html += "<td>"+list.get(i)[j]+"</td>";
				}
				html += "</tr>";
			}
			html += "</table>";
		}
		existOrderChefOrdersTextPane.setText(html);
	}

	private void existOrderPopulate() {
        subscriptionSelectList.setModel(loggedInEmployee.getSubscriptions());
	}
    private void existSubscriptionPopulate() {
        singleOrderSelectList.setModel(loggedInEmployee.getOrders());
    }

	private void customerSearchButtonActionPerformed() {
		nameList = Customer.findCustomer(customerSearchField.getText());
		customerList.setModel(nameList);
		customerScrollPane.setViewportView(customerList);
	}

	private void registerNewButtonActionPerformed() {
		Boolean gtg = true;
		String firstName = firstnameInputField.getText().trim();
		String lastName = lastnameInputField.getText().trim();
		String address = addressInputField.getText().trim();
		int postalCode = 0;
		try {
			postalCode = Integer.parseInt(postalCodeInputField.getText().trim());
		} catch (NumberFormatException e) {
			showErrorMessage(GUI_NUMBER, 1, new Exception("Postal code needs a numeric value"));
			gtg = false;
		}
		String phoneNumber = phonenumberInputField.getText().trim();
		String email = emailInputField.getText().trim();

		String note = notesInputArea.getText().trim();

		if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
			showErrorMessage(GUI_NUMBER, 2, new Exception("All fields except note and email needs to be filled."));
			gtg = false;
		}
		Customer customer = new Customer(address, firstName, lastName, phoneNumber, email, postalCode, note);
		if (Customer.customerExist(customer)) {
			String confirmMessage = "<html>" +
					"<h3>It seems like the person you are trying to add to the customer database already exists</h3>" +
					"<p>Please select the person from the list to the right.</p>" +
					"</html>";
			int confirm = JOptionPane.showConfirmDialog(ProCatering, confirmMessage, "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			System.out.println(confirm);
		if(confirm != 0)
			gtg = false;
		}

		if (gtg) {
			String confirmMessage = "<html>" +
					"<h3>This is the information you put in:</h3>" +
					"<table>" +
					"<tr><td>Firstname:</td><td>" + customer.getFirstName() + "</td></tr>" +
					"<tr><td>Lastname:</td><td>" + customer.getLastName() + "</td></tr>" +
					"<tr><td>Phone number:</td><td>" + customer.getPhoneNumber() + "</td></tr>" +
					"<tr><td>Address:</td><td>" + customer.getAddress() + "</td></tr>" +
					"<tr><td>Postal Code:</td><td>" + customer.getPostalCode() + " " + postalCodeOutputLabel.getText() + "</td></tr>" +
					"<tr><td>Email:</td><td>" + customer.getEmail() + "</td></tr>" +
					"</html>";
			int confirm = JOptionPane.showConfirmDialog(ProCatering, confirmMessage, "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (confirm == 0) {
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
		Timestamp ts = new Timestamp(i - 1900, i1, i2, i3, 0, 0, 0); //TODO Possible fix this... NOT
		System.out.println(ts); //TODO remove
		if (loggedInEmployee.addOrderContent(ts))
			singleOrderUpdateTextpane();
		else
			showErrorMessage(GUI_NUMBER, 4, new Exception("Make sure you have selected a date in the future."));
	}

	private void singleOrderProgressButtonActionPerfomed(ActionEvent event) {
		if (loggedInEmployee.getOrder() != null) {
			if (loggedInEmployee.getOrder().getOrderContent() != null) {
				DefaultListModel<OrderContent> ordercontent = loggedInEmployee.getOrder().getOrderContent();
				for (int i = 0; i < ordercontent.size(); i++) {
					if (!jBoxLabels.contains(ordercontent.get(i).getDeliveryDate().toString().substring(0, 16))) {
						jBoxLabels.add(i, ordercontent.get(i).getDeliveryDate().toString().substring(0, 16));
						singleOrderTimesComboBox.addItem(jBoxLabels.get(i));
					}
				}
				populateSingleOrderLists();

				for (int i = 0; i < ordercontent.size(); i++) {
					DefaultListModel<Dish> d = ordercontent.get(i).getDishes();
					for (int j = 0; j < d.size(); j++) {
						if (!d.isEmpty())
							addSingleOrderButton.setEnabled(true);
						else
							addSingleOrderButton.setEnabled(false);
					}
				}
			}
		} else {

		}
		if (event.getSource().equals(singleOrderProgressButton))
			backButtonActionPerformed();
		singleOrderProgressBackButton.setEnabled(true);
	}

	private void updateSingleOrderPanes() {
		singleOrderCustomerConfirm.setText(singleOrderCustomerInformationTextpane.getText());
		double[] sum = loggedInEmployee.getOrder().getSum();
		String output = "<html><body style='font-family:Courier New;'>";
		output += loggedInEmployee.getOrder().confirmToHtml();
		output += "<tr><td halign='left'>-----------</td><td>---------</td><td halign='right'>----------</td></tr>";
		output += "<tr><td halign='left'>Total:		</td><td> </td><td halign='right'>" + sum[1] + "</td></tr>";
		output += "</table></body></html>";
		singleOrderPaymentConfirm.setText(output);
	}

	private void populateSingleOrderLists() {
		DefaultListModel<Category> categoriesList = loggedInEmployee.getCategories();
		singleOrderDishSelectCategoryJList.setModel(categoriesList);
		singleOrderDishSelectCategoryScrollPane.setViewportView(singleOrderDishSelectCategoryJList);
	}

	private void singleOrderDishSelectCategoryJListActionPerfomed() {
		Category cat = (Category) singleOrderDishSelectCategoryJList.getSelectedValue();
		singleOrderDishSelectDishJList.setModel(loggedInEmployee.getDishes(cat.getCategoryID()));
	}

	private void singleOrderDishAddButtonActionPerformed() {
		Dish dish = (Dish) singleOrderDishSelectDishJList.getSelectedValue();
		System.out.println("dish = " + dish);
		int q = Integer.parseInt(singleOrderDishSpinner.getValue().toString());
		System.out.println("q = " + q);
		int i = singleOrderTimesComboBox.getSelectedIndex();
		System.out.println("i = " + i);

		//System.out.println(singleOrderTimesComboBox.getSelectedItem());
		if (loggedInEmployee.getOrder().addDish(dish, q, i)) {
			System.out.println("DET GIKK BRA");//TODO remove
			singleOrderUpdateTextpane();
		} else
			System.out.println("Alt gikk GALT!");//TODO remove
	}

	private void addSingleOrderButtonActionPerformed(ActionEvent e) {
		double[] sum = loggedInEmployee.getOrder().getSum();
		String output = "<html><body style='font-family:Courier New;'>";
		output += loggedInEmployee.getOrder().confirmToHtml();
		output += "<tr><td halign='left'>-----------</td><td>---------</td><td halign='right'>----------</td></tr>";
		output += "<tr><td halign='left'>Total:		</td><td> </td><td halign='right'>" + sum[1] + "</td></tr>";
		output += "</table></body></html>";
		int option = JOptionPane.showOptionDialog(ProCatering, output, "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
		if (option == 0) {
			if (loggedInEmployee.addOrder()) {
				JOptionPane.showMessageDialog(ProCatering, "Order was successfully added.", "Success", JOptionPane.PLAIN_MESSAGE);
				clearOrder();
			} else showErrorMessage(GUI_NUMBER, 6, new Exception("Error while adding order to database"));
		} else if (option == 1) {
			System.out.println("It was wrong!");
		}

	}

	private void clearOrder() {
		currentStepCard = null;
		CardLayout cl = (CardLayout) mainPanel.getLayout();
		cl.show(mainPanel, "findPanelCard");
	}

	private void backButtonActionPerformed() {
		CardLayout cl = (CardLayout) singleOrderStepPanel.getLayout();
		cl.previous(singleOrderStepPanel);
	}

	private void singleOrderRemoveTimeActionPerformed() {
		int i = singleOrderTimesComboBox.getSelectedIndex();
		loggedInEmployee.getOrder().getOrderContent().removeElementAt(i);
		singleOrderTimesComboBox.removeItemAt(i);
		singleOrderUpdateTextpane();
	}

	private void addEmployeeButtonActionPerformed(ActionEvent e) {
		Boolean gtg = true;
		String firstname = employeeFirstname.getText().trim();
		String lastname = employeeLastname.getText().trim();
		String address = employeeAdress.getText().trim();
		int postalCode = 0;
		try {
			postalCode = Integer.parseInt(employeePostalCode.getText().trim());
		} catch (NumberFormatException ere) {
			showErrorMessage(GUI_NUMBER, 1, new Exception("Postal code needs a numeric value"));
			gtg = false;
		}
		String phoneNumber = employeePhonenumber.getText().trim();
		String email = employeeEmail.getText().trim();

		if (firstname.isEmpty() || lastname.isEmpty() || address.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
			showErrorMessage(GUI_NUMBER, 2, new Exception("All fields except note and email needs to be filled."));
			gtg = false;
		}
		Employee employee = new Employee(firstname, lastname, phoneNumber, postalCode, "12.05.92", email);
		String confirmMessage = "<html>" +
				"<h3>It seems like the person you are trying to add to the customer database already exists</h3>" +
				"<p>Please select the person from the list to the right.</p>" +
				"</html>";
		int confirm = JOptionPane.showConfirmDialog(ProCatering, confirmMessage, "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		System.out.println(confirm);
		if (confirm != 0)
			gtg = false;

		if (gtg) {
			String confirmMessage1 = "<html>" +
					"<h3>This is the information you put in:</h3>" +
					"<table>" +
					"<tr><td>Firstname:</td><td>" + employee.getFirstName() + "</td></tr>" +
					"<tr><td>Lastname:</td><td>" + employee.getLastName() + "</td></tr>" +
					"<tr><td>Phone number:</td><td>" + employee.getPhoneNumber() + "</td></tr>" +
					"<tr><td>Postal Code:</td><td>" + employee.getPostalCode() + " " + employeePostalCode.getText() + "</td></tr>" +
					"<tr><td>Email:</td><td>" + employee.getEmail() + "</td></tr>" +
					"</html>";
			int confirm1 = JOptionPane.showConfirmDialog(ProCatering, confirmMessage, "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (confirm1 == 0) {
				if (employee.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getPhoneNumber(), employee.getPostalCode(), employee.getDob(), employee.getEmail(), employeePasswordField.getText()))
					JOptionPane.showMessageDialog(ProCatering, "The employee was added successfully!");
				else
					JOptionPane.showMessageDialog(ProCatering, "Failure");
			}
		}
	}

	/**
	 * Action performed when pressing economics button.
	 */
	private void backendEconomicButtonActionPerfomed() {
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		cl.show(mainPanel, "economicBackendCard");
	}


	private void backendEmployeeButtonActionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) mainPanel.getLayout();
		cl.show(mainPanel, "employeesBackendCard");
		populateEmployeesList();
	}

	private void populateEmployeesList() {
		employeeList.setModel(loggedInEmployee.getEmployees());
	}

	private void populateEmployeeInformation(MouseEvent e) {
		Employee print = (Employee) employeeList.getSelectedValue();
		String html = "<html><h3>About employee</h3>" +
				"<table>" +
				"<tr><td>Firstname:</td><td>" + print.getFirstName() + "</td></tr>" +
				"<tr><td>Lastname:</td><td>" + print.getLastName() + "</td></tr>" +
				"<tr><td>Phone number:</td><td>" + print.getPhoneNumber() + "</td></tr>" +
				"<tr><td>Postal Code:</td><td>" + print.getPostalCode() + "</td></tr>" +
				"<tr><td>Email:</td><td>" + print.getEmail() + "</td></tr>" +
				"</table>" +
				"</html>";
		aboutEmployeeTextPane.setText(html);
	}
}