package noSqlProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class progress extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static progress frame;
	private DBCollection collection1 = null;
	private DBCollection collection2 = null;
	private String person= null;
	private String identifier = null;
	private String identifier1 = null;
	private JLabel label_1,label_2,label_3,label_4,label_5,label_6; 
    private int n =0,abc=0 ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String name = null;
					frame = new progress(name);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public int value() {
		int m=0;
		BasicDBObject search = new BasicDBObject();
		search.put("id", person);
		DBCursor result = collection1.find(search);
		while(result.hasNext()) {
		     result.next();
			m=m+1;
		}
		return m;
	}
	public void loadMsg(int m) {
        label_1.setText(null);
        label_2.setText(null);
        label_3.setText(null);
        label_4.setText(null);
        label_5.setText(null);
        label_6.setText(null);

		BasicDBObject allQuery = new BasicDBObject();		
		BasicDBObject fields = new BasicDBObject();
		BasicDBObject fields1 = new BasicDBObject();
		fields.put("msg", 1);
		fields.put("_id",0);
		fields1.put("type", 1);
		DBCursor cursor = null,cursor1=null;
		String r=null;
		if(m>0) {
			allQuery.put(identifier, m);
			cursor = collection1.find(allQuery, fields);
		    label_6.setText(cursor.next().get("msg").toString()+"");			
            cursor1 = collection1.find(allQuery, fields1);
            r=cursor1.next().get("type").toString();
		    if(r.equals("rec")) {
				label_6.setHorizontalAlignment(SwingConstants.LEFT);}
		    else
				label_6.setHorizontalAlignment(SwingConstants.RIGHT);

	    }
		m--;
		if(m>0) {
			allQuery.put(identifier, m);
			cursor = collection1.find(allQuery, fields);
			label_5.setText(cursor.next().get("msg").toString()+"");
            cursor1 = collection1.find(allQuery, fields1);
            r=cursor1.next().get("type").toString();
			if(r.equals("rec")) {
				label_5.setHorizontalAlignment(SwingConstants.LEFT);}
			else
				label_5.setHorizontalAlignment(SwingConstants.RIGHT);
	    }		
		m--;
		if(m>0) {
			allQuery.put(identifier, m);
			cursor = collection1.find(allQuery, fields);
			label_4.setText(cursor.next().get("msg").toString()+"");
			fields.put("type", 1);
		    cursor1 = collection1.find(allQuery, fields1);
		    r=cursor1.next().get("type").toString();
			if(r.equals("rec")) {
				label_4.setHorizontalAlignment(SwingConstants.LEFT);}
			else
				label_4.setHorizontalAlignment(SwingConstants.RIGHT);
	    }
		m--;
		if(m>0) {
			allQuery.put(identifier, m);
			cursor = collection1.find(allQuery, fields);
			label_3.setText(cursor.next().get("msg").toString()+"");
			fields.put("type", 1);
		    cursor1 = collection1.find(allQuery, fields1);
		    r=cursor1.next().get("type").toString();
			if(r.equals("rec")) {
				label_3.setHorizontalAlignment(SwingConstants.LEFT);}
			else
				label_3.setHorizontalAlignment(SwingConstants.RIGHT);
	    }		
		m--;
		if(m>0) {
			allQuery.put(identifier, m);
			cursor = collection1.find(allQuery, fields);
			label_2.setText(cursor.next().get("msg").toString()+"");
			fields.put("type", 1);
		    cursor1 = collection1.find(allQuery, fields1);
		    r=cursor1.next().get("type").toString();
			if(r.equals("rec")) {
				label_2.setHorizontalAlignment(SwingConstants.LEFT);}
			else
				label_2.setHorizontalAlignment(SwingConstants.RIGHT);
	    }
		m--;
		if(m>0) {
			allQuery.put(identifier, m);
			cursor = collection1.find(allQuery, fields);
			label_1.setText(cursor.next().get("msg").toString()+"");
			fields.put("type", 1);
		    cursor1 = collection1.find(allQuery, fields1);
		    r=cursor1.next().get("type").toString();
			if(r.equals("rec")) {
				label_1.setHorizontalAlignment(SwingConstants.LEFT);}
			else
				label_1.setHorizontalAlignment(SwingConstants.RIGHT);
	    }
		
//		cursor.close();
//		cursor1.close();
		r=null;
		
	}
	
	

	/**
	 * Create the frame.
	 */

	public progress(String u) {
		
		 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		 DB database = mongoClient.getDB("college");
	     DBCollection collection = database.getCollection("student");
	     
	     
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSend = new JButton("Quit");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSend.setBounds(10, 439, 89, 23);
		contentPane.add(btnSend);
		
		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(178, 109, 238, 20);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(178, 134, 238, 20);
		contentPane.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(178, 165, 238, 20);
		contentPane.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(178, 196, 238, 20);
		contentPane.add(label_4);
		
		label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(178, 233, 238, 20);
		contentPane.add(label_5);
		
		label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(178, 266, 238, 20);
		contentPane.add(label_6);
		
		JButton button_5 = new JButton("-");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(abc<6) {}
				else
					loadMsg(abc--);
			}
		});
		button_5.setBounds(267, 52, 41, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("+");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ch=value();
				if(ch<abc) {}
				else if(ch==abc)
					loadMsg(abc);
				else {
					loadMsg(abc++);
				}
				
			}
		});
		button_6.setBounds(267, 295, 41, 23);
		contentPane.add(button_6);
		
		textField = new JTextField();
		textField.setBounds(178, 337, 217, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("");

		
		
		JComboBox comboBox = new JComboBox();
		BasicDBObject allQuery = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();
		fields.put("name", 1);
		fields.put("_id",0);
//		comboBox.addItem("Select to chat");
			DBCursor cursor = collection.find(allQuery, fields);
				while(cursor.hasNext()) {
					String a=cursor.next().get("name").toString();
					if(!a.equals(u))
					comboBox.addItem(a);
				}
				
				
		String user = u;
	    person = (String)comboBox.getSelectedItem();
	    identifier = person.concat("count");
	    identifier1 = user.concat("count");


		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				person = (String)comboBox.getSelectedItem();
				identifier = person.concat("count");
			    identifier1 = user.concat("count");
			    collection2 = database.getCollection(comboBox.getSelectedItem().toString());
			    abc = value();
				loadMsg(abc);
			}
		});
		comboBox.setBounds(10, 52, 149, 30);
		contentPane.add(comboBox);
	    
		
		try {
		 collection1 = database.getCollection(u);
	     collection2 = database.getCollection(comboBox.getSelectedItem().toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		JButton button_7 = new JButton("<");
		button_7.setBackground(new Color(176, 196, 222));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().equals("")) {
					
					BasicDBObject search = new BasicDBObject();
					search.put("id", person);
					DBCursor result = collection1.find(search);
					while(result.hasNext()) {
					     result.next();
						//System.out.println(result.next());
						n=n+1;
					}
					n=n+1;

					DBObject document = new BasicDBObject("id",person)
							.append("type", "sent")
							.append("msg", textField.getText())
							.append(identifier,n);
			    	collection1.insert(document);

			    	DBObject document1 = new BasicDBObject("id",user)
							.append("type", "rec")
							.append("msg", textField.getText())
							.append(identifier1,n);
			    	collection2.insert(document1);
					
					textField.setText("");
					n=0;
				//	collection1 = database.getCollection(u);

					abc= value();
					loadMsg(abc);
				}
			}
		});
		button_7.setBounds(393, 337, 41, 30);
		contentPane.add(button_7);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		label.setBounds(267, 0, 140, 41);
		contentPane.add(label);
		label.setText(u);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				person = (String)comboBox.getSelectedItem();
				identifier = person.concat("count");
			    collection2 = database.getCollection(comboBox.getSelectedItem().toString());
			    abc = value();
				loadMsg(abc);
			}
		});
		btnRefresh.setBounds(10, 397, 89, 23);
		contentPane.add(btnRefresh);
		

		
		abc = value();
		loadMsg(abc);
	
		////////////////////////////////////////////////////////////////////
		
	}
}
