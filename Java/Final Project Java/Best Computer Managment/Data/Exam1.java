package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exam1 {

	
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
		String username = "N01335459";
		String password = "oracle";
		Connection conn =DriverManager.getConnection(url,username,password);
		Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		System.out.println("enter invoice id");	
		int n=input.nextInt();
		String query="select * from storeInvoice where invoiceid='"+n+"'";
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getInt("invoiceid"));
			System.out.print(rs.getDate("invoicedate"));
			System.out.println(rs.getDouble("invoiceprice"));
		}
		
		System.out.println("comnection success");		
	}

}
