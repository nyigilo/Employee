package views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	public MainFrame(){
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(600, 500));

	}
	public void start() {
		setTitle("Employee");
		pack();
		setCenter();
		setVisible(true);
		setResizable(false);
	}
	private void setCenter(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
	

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		MainFrame frame = new MainFrame();
		LoginPanel login = new LoginPanel();
		frame.add(login);
	//	frame.add(login);
		//SignUpPanel p = new SignUpPanel();
		//frame.add(p);
		frame.start();
		frame.pack();
		 

	}
	 

}
