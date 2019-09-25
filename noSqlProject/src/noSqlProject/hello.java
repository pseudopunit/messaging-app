package noSqlProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hello extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hello frame = new hello();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JScrollPane scrollPane;
	/**
	 * Create the frame.
	 */
	public void initComponents() {
		 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
	        );

	        pack();
	}
	
	public hello() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 48, 14);
		contentPane.add(label);
		
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 239);
		contentPane.add(scrollPane);
		initComponents();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser jfc = new JFileChooser();
			        
			        //select file and display
			        if(jfc.showOpenDialog(mntmOpen) == JFileChooser.APPROVE_OPTION){
			            //get selected file name [i.e., complete file path]
			            java.io.File f = jfc.getSelectedFile();
			            
			            //set icon
			            label.setIcon(new ImageIcon(f.toString()));
			            
			            //alignment
			            label.setHorizontalAlignment(JLabel.CENTER);
			            
			            //add jLabel to scroll pane
			            scrollPane.getViewport().add(label);
			        }
			}
		});
		mnFile.add(mntmOpen);
	
	}

}
