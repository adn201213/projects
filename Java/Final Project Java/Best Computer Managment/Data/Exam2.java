package Data;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Exam2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtInvoiceId;
	private JTextField txtInvoiceName;
	private JTextField txtPrice;
	private JTextField txtfind;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam2 frame = new Exam2();
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
	public Exam2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnadd = new JButton("add");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
				String username = "N01335459";
				String password = "oracle";
				String query="insert into invoice10(invoiceid,INVOICEName) values(?,?)";
				int invoiceid1=Integer.parseInt(txtInvoiceId.getText());
				String name=txtInvoiceName.getText();
			try {
				Connection conn1=DriverManager.getConnection(url,username,password);
				PreparedStatement pst=conn1.prepareStatement(query);
				pst.setInt(1,invoiceid1 );
				pst.setString(2, name);
				int num=pst.executeUpdate();
				//rs.insertRow();
				//rs.updateRow();
				//How to delete a record
				//rs.deleteRow();

				JOptionPane.showMessageDialog(null, "The Invoice adding was successfully"+num);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "The Invoice adding was unsuccessfully");
			}
			}
		});
		btnadd.setBounds(59, 152, 89, 23);
		contentPane.add(btnadd);
		
		JButton btndelete = new JButton("delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
				String username = "N01335459";
				String password = "oracle";
				String query="delete from invoice10 where invoiceid=?";
		
				
				int find =Integer.parseInt(txtfind.getText());
				
			try {
				Connection conn1=DriverManager.getConnection(url,username,password);
				PreparedStatement pst=conn1.prepareStatement(query);
				pst.setInt(1,find);

				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "The Invoice delete was successfully");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "The Invoice delete was unsuccessfully");
			}
			
			}
		});
		btndelete.setBounds(191, 152, 89, 23);
		contentPane.add(btndelete);
		
		JButton btnNewButton_2 = new JButton("first");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String url = "jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
				String username = "N01335459";
				String password = "oracle";
			
				
				try {
				
					Connection conn =DriverManager.getConnection(url,username,password);
					System.out.println("connection is Successfull");
				
					String query="select * from Invoice10 order by invoiceid";
					PreparedStatement st5=conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			        
				
					
					ResultSet rs2=st5.executeQuery();
				if(rs2!=null)
				{
					rs2.first();
					//rs2.absolute(3);
					//rs2.relative(-2);
					//rs2.relative(3);
						txtInvoiceId.setText(String.valueOf(rs2.getInt("invoiceid")));	
					
							txtInvoiceName.setText(rs2.getString("invoicename"));
							

				
				
				}
				} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				
			
			
			}
		});
		btnNewButton_2.setBounds(59, 202, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("next");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String url = "jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
				String username = "N01335459";
				String password = "oracle";
			
				
				try {
				
					Connection conn =DriverManager.getConnection(url,username,password);
					System.out.println("connection is Successfull");
				
					
					String query="select * from Invoice10 order by invoiceid";
					PreparedStatement st5=conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			        
				
					
					ResultSet rs2=st5.executeQuery(query);
				if(rs2!=null)
				{
					if(!rs2.isLast()) {
						rs2.first();
						rs2.next();
					txtInvoiceId.setText(String.valueOf(rs2.getInt("invoiceid")));	
					
					txtInvoiceName.setText(rs2.getString("invoicename"));
					
					
					//JOptionPane.showMessageDialog(null, 
							//rs2.getInt("invoiceid")+" "+rs2.getString("invoicename"));
					}
					}
				} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				
			
			}
		});
		btnNewButton_3.setBounds(191, 202, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnupdate = new JButton("update");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
				String username = "N01335459";
				String password = "oracle";
				String query="update invoice10 set invoiceid=?,INVOICEName=? where invoiceid=?";
		
				int invoiceid1=Integer.parseInt(txtInvoiceId.getText());
				String name=txtInvoiceName.getText();
				int find =Integer.parseInt(txtfind.getText());
				
			try {
				Connection conn1=DriverManager.getConnection(url,username,password);
				PreparedStatement pst=conn1.prepareStatement(query);
				pst.setInt(1,invoiceid1 );
				pst.setString(2, name);
				pst.setInt(3,find);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "The Invoice update was successfully");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "The Invoice update was unsuccessfully");
			}
			
			}
		});
		btnupdate.setBounds(322, 152, 89, 23);
		contentPane.add(btnupdate);
		
		JButton btnNewButton_5 = new JButton("previous");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String url = "jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
				String username = "N01335459";
				String password = "oracle";
			
				
				try {
				
					Connection conn =DriverManager.getConnection(url,username,password);
					System.out.println("connection is Successfull");
				
					
					Statement st5=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			        
					String query="select * from Invoice10 order by invoiceid";
					
					ResultSet rs2=st5.executeQuery(query);
				if(rs2!=null)
				{
					if(!rs2.isFirst()) {
						rs2.last();
					rs2.previous();
					txtInvoiceId.setText(String.valueOf(rs2.getInt("invoiceid")));	
					
					txtInvoiceName.setText(rs2.getString("invoicename"));
					
					//JOptionPane.showMessageDialog(null, 
							//rs2.getInt("invoiceid")+" "+rs2.getString("invoicename"));
					}
					}
				} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					
			
			}
		});
		btnNewButton_5.setBounds(322, 202, 89, 23);
		contentPane.add(btnNewButton_5);
		
		txtInvoiceId = new JTextField();
		txtInvoiceId.setBounds(41, 42, 96, 20);
		contentPane.add(txtInvoiceId);
		txtInvoiceId.setColumns(10);
		
		txtInvoiceName = new JTextField();
		txtInvoiceName.setBounds(191, 42, 96, 20);
		contentPane.add(txtInvoiceName);
		txtInvoiceName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(322, 42, 96, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtfind = new JTextField();
		txtfind.setBounds(41, 92, 96, 20);
		contentPane.add(txtfind);
		txtfind.setColumns(10);
		
		JButton btnNewButton_2_1 = new JButton("last");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String url = "jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
				String username = "N01335459";
				String password = "oracle";
			
				
				try {
				
					Connection conn =DriverManager.getConnection(url,username,password);
					System.out.println("connection is Successfull");
				
					
					Statement st5=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			        
					String query="select * from Invoice10 order by invoiceid";
					
					ResultSet rs2=st5.executeQuery(query);
				if(rs2!=null)
				{
					rs2.last();;
						txtInvoiceId.setText(String.valueOf(rs2.getInt("invoiceid")));	
					
							txtInvoiceName.setText(rs2.getString("invoicename"));
				}
				} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				
			
			}
		});
		btnNewButton_2_1.setBounds(69, 236, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("display");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
				String username = "N01335459";
				String password = "oracle";
			
				//String query = "update storeorderitem set itemid='" + order.getpItemid() + "',serialnumber='"
					//	+ order.getpSerialnumber() + "',quantity='" + order.getpQuantity() + "' where orderid='"
					//	+ order.getpOrderid() + "' ";
				
				try {
					Connection conn =DriverManager.getConnection(url,username,password);
					System.out.println("connection is Successfull");
					//This allows cursor move forward and backward 
					//but doesn't show any changes from other users or programs
					Statement st1=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					//This allows cursor move forward and backward 
					//and can show any changes from other users or programs
					Statement st2=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					//This allows cursor move forward only no backward 
					Statement st3=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
					//This is the default concurrency level. 
					//It specifies that result set contains a read-only version
					//of data from the database. You cannot change the contents 
					//of the database by altering the contents of the result set.
					Statement st4=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					//This specifies that the result set should be updateable. 
					//Changes can be made to the result
					//set, and then those changes can be saved to the database.
					Statement st5=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			         int n=Integer.parseInt(txtfind.getText());
					String query="select * from Invoice10 where invoiceid='"+n+"'";
					String query1="select * from Invoice10 where invoiceid=?";
					PreparedStatement st6=conn.prepareStatement(query1,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					st6.setInt(1, n);
					//for preparedstatment
					ResultSet rs1=st6.executeQuery();
					//for creatstatment
					ResultSet rs=st5.executeQuery(query);
				//	while(rs.next()) {
					if(rs1.next());
						txtInvoiceId.setText(String.valueOf(rs1.getInt("invoiceid")));	
						txtInvoiceName.setText(rs1.getString("invoicename").toString());
					//	txtPrice.setText(String.valueOf(rs1.getDouble("invoiceprice")));
				//	}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2_2.setBounds(191, 236, 89, 23);
		contentPane.add(btnNewButton_2_2);
	}
}
