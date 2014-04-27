package views;

/*
 * SimpleTableDemo.java requires no other files.
 */

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import models.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserPanel extends JPanel {
	private boolean DEBUG = false;
	private static final JFileChooser CHOOSER = new JFileChooser();
	private final JButton save = new JButton("Save As...");
	private String[]  columnNames;
	private Object[][] data;
	private final JTable table;
	private JScrollPane scrollPane;
	private File my_file;
	private JButton update = new JButton("Update");
	private JButton delete = new JButton("Delete");;
	JPanel buttons_panel = new JPanel(new FlowLayout());

	public UserPanel() {
		super(new BorderLayout());
		setPreferredSize(new Dimension(800, 400));

		String[] columnNames = {"Schedule",
				"Doctor",
				"Procedures",
				"Length",
				"Date",
				"Start time",
		"End time"};

		Object[][] data = {
				{"Monday", "Bassan, Edward",
					new Integer(9999), new Integer(5),"2014-34-8","01:01:00","12:00:00"},

					{"Tuesday", "Jake, Taylor",
						new Integer(0003), new Integer(3),"2014-34-8","01:01:00","12:00:00"}

		};


		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		//toExcel(table, new File("/Users/Aden/Desktop/MO.xls"));
		table.setBackground(Color.darkGray);
		table.setForeground(Color.green);
		table.setGridColor(Color.white);
		table.getTableHeader().setBackground(Color.orange);
		table.setFont(new Font("Serif", Font.BOLD, 15));
		


		if (DEBUG) {
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					printDebugData(table);
				}
			});
		}
		//Create the scroll pane and add the table to it.
		scrollPane = new JScrollPane(table);

		//Add the scroll pane to this panel.
		add(scrollPane,BorderLayout.CENTER);

		buttons_panel.setBackground(Color.CYAN);
		buttons_panel.setPreferredSize(new Dimension(100, 35));
		save.setBackground(Color.GREEN);
		buttons_panel.add(save);
		buttons_panel.add(update);
		add(buttons_panel, BorderLayout.SOUTH);
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				save();
			}
		});
		
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				save();
			}
		});
	}

	public void toExcel(JTable table, File file){
		try{
			TableModel model = table.getModel();
			FileWriter excel = new FileWriter(file);

			for(int i = 0; i < model.getColumnCount(); i++){
				excel.write(model.getColumnName(i) + "\t");
			}

			excel.write("\n");

			for(int i=0; i< model.getRowCount(); i++) {
				for(int j=0; j < model.getColumnCount(); j++) {
					excel.write(model.getValueAt(i,j).toString()+"\t");
				}
				excel.write("\n");
			}

			excel.close();

		}catch(IOException e){ System.out.println(e); }
	}
	public void populateTable(final User user){
		Object[] data = {user.getMy_schedule(), user.getLastName()+", "+ user.getFirstName(),
				user.getMy_procedure(), user.getMy_length(),"2014-34-8","01:01:00","12:00:00"};
	}

	private void printDebugData(JTable table) {
		int numRows = table.getRowCount();
		int numCols = table.getColumnCount();
		javax.swing.table.TableModel model = table.getModel();

		System.out.println("Value of data: ");
		for (int i=0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j=0; j < numCols; j++) {
				System.out.print("  " + model.getValueAt(i, j));
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	public static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Edward Bassan");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Create and set up the content pane.
		UserPanel newContentPane = new UserPanel();
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	private void setCenter(final JFrame frame){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}

	private void save() {
		final int retval = CHOOSER.showSaveDialog(null);
		if (retval == JFileChooser.APPROVE_OPTION) {
			my_file = CHOOSER.getSelectedFile();
			toExcel(table, new File(my_file.getAbsolutePath()));
		}
	}

	private void update() {
		final int retval = CHOOSER.showSaveDialog(null);
		if (retval == JFileChooser.APPROVE_OPTION) {
			my_file = CHOOSER.getSelectedFile();
			toExcel(table, new File(my_file.getAbsolutePath()));
		}
	}


	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}