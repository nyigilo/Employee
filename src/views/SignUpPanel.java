package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controllers.Database;

public class SignUpPanel extends JPanel implements ActionListener 
{ 
	JLabel firstname, lastname, email, password1, password2, city, state, zip, sex, phone, username;
	JTextField firstnamefield, lastnamefield, emailfield, cityfield, zipfield, sexfield,
	usernamefield, statefield, phonefield;
	JButton submit, clear, login;
	JPasswordField passwordfield1, passwordfield2;

	public SignUpPanel()
	{
		super();
	//	setPreferredSize(new Dimension(100, 100));
		setLayout(null);
		//setVisible(true);
	//	setSize(600, 400);
	//	setLayout(null);
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setTitle("Registration Form");
		//setBackground(Color.LIGHT_GRAY);
	
		sex = new JLabel("Sex:");
		sex.setFont(new Font("Serif", Font.BOLD, 15));
		sex.setForeground(Color.yellow);
	 
		
		username = new JLabel("Username:");
		username.setFont(new Font("Serif", Font.BOLD, 15));
	    username.setForeground(Color.yellow);
	 
		firstname = new JLabel("First Name:");
		firstname.setFont(new Font("Serif", Font.BOLD, 15));
		firstname.setForeground(Color.yellow);
 		
		lastname = new JLabel("Last Name:");
		lastname.setFont(new Font("Serif", Font.BOLD, 15));
		lastname.setForeground(Color.yellow);
		
		email = new JLabel("Email:");
		email.setFont(new Font("Serif", Font.BOLD, 15));
		email.setForeground(Color.yellow);
		
		password1 = new JLabel("Create Password:");
		password1.setFont(new Font("Serif", Font.BOLD, 15));
		password1.setForeground(Color.yellow);
		
		password2 = new JLabel("Confirm Password:");
		password2.setFont(new Font("Serif", Font.BOLD, 15));
		password2.setForeground(Color.yellow);
		
		city = new JLabel("City:");
		city.setFont(new Font("Serif", Font.BOLD, 15));
		city.setForeground(Color.yellow);

		state = new JLabel("State:");
		state.setFont(new Font("Serif", Font.BOLD, 15));
		state.setForeground(Color.yellow);
		
		zip = new JLabel("Zip:");
		zip.setFont(new Font("Serif", Font.BOLD, 15));
		zip.setForeground(Color.yellow);
		
		phone = new JLabel("Phone #:"); 
		phone.setFont(new Font("Serif", Font.BOLD, 15));
		phone.setForeground(Color.yellow);
		
		sexfield = new JTextField();
		sexfield.setForeground(Color.blue);
		
		usernamefield = new JTextField();
		usernamefield.setForeground(Color.blue);
		
		cityfield = new JTextField();
		cityfield.setForeground(Color.blue);
		
		statefield = new JTextField();
		statefield.setForeground(Color.blue);
		
		zipfield = new JTextField();
		zipfield.setForeground(Color.blue);
		
		firstnamefield = new JTextField();
		firstnamefield.setForeground(Color.blue);
		
		lastnamefield = new JTextField();
		lastnamefield.setForeground(Color.blue);
		
		cityfield = new JTextField();
		cityfield.setForeground(Color.blue);
		
		statefield = new JTextField();
		statefield.setForeground(Color.blue);
		
		phonefield = new JTextField();
		phonefield.setForeground(Color.blue);
		
		emailfield = new JTextField();
		emailfield.setForeground(Color.blue);
		
		passwordfield1 = new JPasswordField();
		passwordfield2 = new JPasswordField();

		submit = new JButton("Submit");
		clear = new JButton("Clear");
		login = new JButton("Login");
		
		

		submit.addActionListener(this);
		clear.addActionListener(this);
		login.addActionListener(this);

		sex.setBounds(80, 30, 200, 30);
		username.setBounds(280, 30, 200, 30);
		firstname.setBounds(80, 60, 200, 30);
		lastname.setBounds(80, 90, 200, 30);
		password1.setBounds(80, 120, 200, 30);
		password2.setBounds(80, 150, 200, 30);
		email.setBounds(80, 180, 200, 30);
		phone.setBounds(80, 210, 200, 30);
		city.setBounds(80, 240, 200, 30);
		state.setBounds(250, 270, 200, 30);
		zip.setBounds(350, 270, 200, 30);
		submit.setBounds(245, 300, 100, 30);
		clear.setBounds(355, 300, 100, 30);
		login.setBounds(301, 330, 100, 30);


		sexfield.setBounds(250, 30, 30, 30);
		usernamefield.setBounds(350, 30, 100, 30);
		firstnamefield.setBounds(250, 60, 200, 30);
		lastnamefield.setBounds(250, 90, 200, 30);
		passwordfield1.setBounds(250, 120, 200, 30);
		passwordfield2.setBounds(250, 150, 200, 30);
		emailfield.setBounds(250, 180, 200, 30);
		phonefield.setBounds(250, 210, 200, 30);
		cityfield.setBounds(250, 240, 200, 30);
		statefield.setBounds(300, 270, 40, 30);
		zipfield.setBounds(390, 270, 60, 30);
		
        add(sexfield);
		add(passwordfield1);
		add(passwordfield2);
		add(emailfield);
		add(phonefield);
		add(cityfield);
		add(statefield);
		add(zipfield);
		add(firstname);
		add(firstnamefield);
		add(lastname);
		add(lastnamefield);
		add(usernamefield);
	
		
		add(password1);
		add(password2);
		add(email);
		add(phone);
		add(city);
		add(state);
		add(zip);
		add(submit);
		add(clear);
		add(login);
		add(sex);
		add(username);

	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == login)
		{
			 Window w = SwingUtilities.getWindowAncestor(SignUpPanel.this);
		      w.setVisible(false);
		      javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						 UserPanel.createAndShowGUI();
					}
				});
		}
		if (e.getSource() == submit)
		{
			int x = 0;

			try
			{
				//if(validateSignUp()){
					
					PreparedStatement insertSt = null;
					Connection con = null;
					Database DB = new Database();
					String insertString ="insert into signUp(sex, username, first_name, last_name, email, phone, city, state, zip) " +
							"values(?,?,?,?,?,?,?,?,?)";
					con = DB.getConnection();
					con.setAutoCommit(false);
					insertSt = con.prepareStatement(insertString);
					insertSt = con.prepareStatement(insertString);
				    insertSt.setString(1, sexfield.getText());
				 	insertSt.setString(2, usernamefield.getText());
					insertSt.setString(3, firstnamefield.getText());
					insertSt.setString(4, lastnamefield.getText());
					insertSt.setString(5, emailfield.getText());
					insertSt.setInt(6, 5);
					insertSt.setString(7, cityfield.getText());
					insertSt.setString(8, state.getText());
					insertSt.setInt(9, 7);


					insertSt.addBatch();
					insertSt.executeBatch();
					con.commit();

					x++;
					if (x > 0) 
					{
						JOptionPane.showMessageDialog(submit, "Data Saved Successfully");
						 Window w = SwingUtilities.getWindowAncestor(SignUpPanel.this);
					      w.setVisible(false);
					      javax.swing.SwingUtilities.invokeLater(new Runnable() {
								public void run() {
									 LoginPanel.createAndShowGUI();
								}
							});
					}
				//}
			}
			catch (Exception ex) 
			{
				System.out.println(ex);
			}
		}

		{
			firstnamefield.setText("");
			lastnamefield.setText("");
			emailfield.setText("");
			phonefield.setText("");
			sexfield.setText("");
			city.setText("");
			statefield.setText("");
			zipfield.setText("");

		}
	} 
	private boolean validateSignUp(){
		boolean field = false;
		if(firstnamefield.getText().equals("") && lastnamefield.getText().equals("")
				&& password1.getText().equals("") && password1.getText().equals("") &&
				email.getText().equals("") && phonefield.getText().equals("")  && city.getText().equals("") 
				 && state.getText().equals("")  && zip.getText().equals("")  && state.getText().equals("")){
			JOptionPane.showMessageDialog(submit, "You just can't submit an empty fields!");
			field = false;
		}else if(!firstnamefield.getText().equals("") && !lastnamefield.getText().equals("")
				&& !password1.getText().equals("") && !password1.getText().equals("") &&
				!email.getText().equals("") && !phonefield.getText().equals("")  && !cityfield.getText().equals("") 
				&& !statefield.getText().equals("") && !zipfield.getText().equals("")){
			field = true;
		}else if(!password1.getText().equals(password2.getText())){
			JOptionPane.showMessageDialog(submit, "Passwords doesnt match!");
			field = false;
		}
		return field;
	}
	 Image bg = new ImageIcon("/Users/Aden/Desktop/M/s7.jpg").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	public static void main(String args[])
	{
		new SignUpPanel();

	}
	
	

}