package noSqlProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp frame = new signUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
    int flag=0;
    int b1 = 0;


	public signUp() {
		 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		 DB database = mongoClient.getDB("college");
	     DBCollection collection = database.getCollection("student");
	     
	     
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Name :");
		lblUsername.setBounds(70, 33, 78, 20);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(196, 30, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		String a= textField.getText();
		
		JLabel lblBranch = new JLabel("Branch :");
		lblBranch.setBounds(70, 158, 60, 14);
		contentPane.add(lblBranch);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 155, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number :");
		lblMobileNumber.setBounds(70, 96, 96, 20);
		contentPane.add(lblMobileNumber);
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 96, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Age :");
		lblNewLabel.setBounds(71, 216, 48, 14);
		contentPane.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(196, 213, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(70, 267, 78, 20);
		contentPane.add(lblPassword);
		
		textField_4 = new JTextField();
		textField_4.setBounds(196, 267, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setBounds(70, 320, 96, 14);
		contentPane.add(lblConfirmPassword);
		
		textField_5 = new JTextField();
		textField_5.setBounds(196, 317, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		
		
		String b= textField_1.getText();


		JButton btnCreateProfile = new JButton("Create Profile");
		btnCreateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=0;
				
				BasicDBObject whereQuery = new BasicDBObject();
				whereQuery.put("no", textField_2.getText());
				DBCursor cursor = collection.find(whereQuery);
				while(cursor.hasNext()) {
				    //System.out.println(cursor.next());
				    flag=1;
				    break;
				}
				
				
				if(flag==1) {
					JOptionPane.showMessageDialog(null, "Duplicate Mobile Number :");
				}
				else {
		        DBObject person = new BasicDBObject("name", textField.getText())
		                              .append("no", textField_2.getText())
                                      .append("branch", textField_1.getText())
                                      .append("age", textField_3.getText())
                                      .append("pass", textField_4.getText());
      
               collection.insert(person);
               JOptionPane.showMessageDialog(null, "Data saved successfully");
              
     	       DBCollection collection1 = database.getCollection(textField.getText());
     	       DBObject person1 = new BasicDBObject("name", textField.getText())
    		                         .append("no", textField_2.getText())
     	                             .append("branch", textField_1.getText());
     	       collection1.insert(person1);
     	     
		       contentPane.setVisible(false);
			   start window = new start();
			   window.frame.setVisible(true);
			}
			}
		});
		btnCreateProfile.setBounds(142, 377, 131, 23);
		contentPane.add(btnCreateProfile);
		
		
	}
}
