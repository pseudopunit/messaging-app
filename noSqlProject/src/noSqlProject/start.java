package noSqlProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.bson.BSONObject;
import org.bson.codecs.configuration.*;
import org.bson.codecs.pojo.PojoCodecProvider;
import javax.swing.JPasswordField;

public class start {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start window = new start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JButton btnLogin = new JButton("Login");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(78, 32, 76, 22);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(78, 94, 65, 22);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(206, 33, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		//String a= textField.getText();
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 95, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
	    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	    DB database = mongoClient.getDB("college");
	   // database = database.withCodecRegistry(pojoCodecRegistry);
        DBCollection collection = database.getCollection("student");	
    //    DBObject query = new BasicDBObject("name",textField.getText() );
        DBCursor cursor = collection.find();
        DBCursor cursor1 = collection.find();
        int b = cursor.count();
        
        btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  while(b>0) {
			        	String ab=cursor.next().get("pass").toString();
			        	String a=cursor1.next().get("name").toString();
			        	if(a.equals(textField.getText()) && ab.equals(textField_1.getText())) {
			        		
			            System.out.println("Logined");
			        	frame.dispose();
						progress p=new progress(textField.getText());
						p.setVisible(true);
						break ;
			        	}


				  }
					
				
			}	
		});
		
		btnLogin.setBounds(164, 149, 89, 23);
		frame.getContentPane().add(btnLogin);
				
		JButton btnSignUp = new JButton("Sign UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				signUp sg = new signUp();
				sg.setVisible(true);
			}
		});
		btnSignUp.setBounds(164, 202, 89, 23);
		frame.getContentPane().add(btnSignUp);
		

	        
	}
}
