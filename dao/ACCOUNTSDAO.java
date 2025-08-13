package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ACCOUNTS;

public class ACCOUNTSDAO extends DAO {

	public List<ACCOUNTS> search(String keyword) throws Exception {
		List<ACCOUNTS> list=new ArrayList<>();

		Connection con=getConnection();

		
		String stSql = "select * from ACCOUNTS where ACCOUNT_NUMBER like ?";
		
		System.out.print(stSql);
		
		PreparedStatement st=con.prepareStatement(stSql);
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			ACCOUNTS p=new ACCOUNTS();
			p.setBALANCE(rs.getInt("BALANCE"));
			p.setACCOUNT_NUMBER(rs.getString("ACCOUNT_NUMBER"));

			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

	public int insert(ACCOUNTS ACCOUNTS) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"insert into ACCOUNTS(ACCOUNT_NUMBER, BALANCE) values(?, ?)");
		st.setString(1, ACCOUNTS.getACCOUNT_NUMBER());
		st.setInt(2, ACCOUNTS.getBALANCE());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}
