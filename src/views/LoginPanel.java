package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;





import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.Database;



@SuppressWarnings("serial")
/**
 
 */
public class LoginPanel extends JPanel {

	private static final int WIDTH = 400;
	private static final int HEIGHT = 100;



	private static final JLabel USERNAME_LABEL = new JLabel("Username");
	private static final JTextField USERNAME_FIELD = new JTextField(10);
	private static final JLabel PASSWORD_LABEL = new JLabel("Password");
	private static final JPasswordField PASSWORD_FIELD = new  JPasswordField(10);
	private static final JButton LOGIN = new JButton("Login");
	private static final JButton SIGN_UP = new JButton("SignUp");

	/**
	 * Constructor for creating the gui.
	 */
	public LoginPanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		initPanel();
		//setBackground(Color.BLACK);
	}

	/**
	 * Creates the gui for the login.
	 */
	private void initPanel() {
		USERNAME_LABEL.setBounds(8, 30, 150, 20);
		PASSWORD_LABEL.setBounds(8, 65, 150, 20);
		USERNAME_FIELD.setBounds(70, 30, 150, 20);
		PASSWORD_FIELD.setBounds(70, 65, 150, 20);
		LOGIN.setBounds(75, 100, 60, 20);
		SIGN_UP.setBounds(155,100, 60, 20);


		PASSWORD_FIELD.setPreferredSize(new Dimension(4, 5));
		PASSWORD_FIELD.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent the_e){
				LOGIN.doClick();
			}
		});
		LOGIN.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent the_e){
				validateUser();
				if ((!PASSWORD_FIELD.getText().trim().equals("")) && (!USERNAME_FIELD.getText().trim().equals(""))){
					Database db = null;
					try {
						db = new Database();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ResultSet set = null;
					try {
						set = db.findUser(USERNAME_FIELD.getText().trim(), PASSWORD_FIELD.getText().trim());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						if (set.next()){
							JOptionPane.showMessageDialog(LoginPanel.this, "You have logged into the System");
							Window w = SwingUtilities.getWindowAncestor(LoginPanel.this);
							w.setVisible(false);
							javax.swing.SwingUtilities.invokeLater(new Runnable() {
								public void run() {
									UserPanel.createAndShowGUI();
								}
							});
						}else{
							JOptionPane.showMessageDialog(LoginPanel.this, "You are not in the System");
						}
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		add(LOGIN); 
		add(USERNAME_FIELD); 
		add(PASSWORD_FIELD);
		add(SIGN_UP);
		add(PASSWORD_LABEL);
		add(USERNAME_LABEL);
	}
	public void loginToDatabase() throws SQLException, ClassNotFoundException{
		Database db = new Database();
		ResultSet set = db.findUser(USERNAME_FIELD.getText().trim(), PASSWORD_FIELD.getText().trim());
		if (set.next()){
			JOptionPane.showMessageDialog(LoginPanel.this, "You have logged into the System");
		}else{
			JOptionPane.showMessageDialog(LoginPanel.this, "You are not into the System");
		}
	}
	private void validateUser(){
		if ((PASSWORD_FIELD.getText().trim().equals("")) && (PASSWORD_FIELD.getText().trim().equals(""))){
			JOptionPane.showMessageDialog(LoginPanel.this, "Please enter a Username and Password!");
		}else if ((USERNAME_FIELD.getText().trim().equals("")) && (!PASSWORD_FIELD.getText().trim().equals(""))){
			JOptionPane.showMessageDialog(LoginPanel.this, "Please enter a Username!");
		}else if ((PASSWORD_FIELD.getText().trim().equals("")) && (!USERNAME_FIELD.getText().trim().equals(""))){
			JOptionPane.showMessageDialog(LoginPanel.this, "Please enter a Password!");
		}
	}
	public static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Edward Bassan");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Create and set up the content pane.
		LoginPanel newContentPane = new LoginPanel();
		//newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginPanel();
		
	}
}
