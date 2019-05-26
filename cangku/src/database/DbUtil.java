package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private Connection conn;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	private static DbUtil dbutil=new DbUtil();
	private DbUtil(){}
	/**
	 * ������ݿ�����
	 * @return
	 */
	public Connection getConnection(){
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/ljck","root","root");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;
	}
	public void closeConnection(){
		try {
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("���ݿ�ر�ʧ��");
			e.printStackTrace();
		}
	}
	public static DbUtil getDbutil() {
		return dbutil;
	}
}
