package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author lygwangyp
 * @return ȡ�����ݿ������
 */
public class DatabaseTools {
	public Connection conn=null;
	public Connection getConn() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");					//����MySQL�����ݿ���������
			String DBURL= "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=utf-8&useSSL=false";		//����MySQL�����ݿ����ӵ�ַ
			String DBUSER = "root";										//MySQL���ݿ�������û���
			String DBPASS = "root";										//MySQL���ݿ����������
			conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
