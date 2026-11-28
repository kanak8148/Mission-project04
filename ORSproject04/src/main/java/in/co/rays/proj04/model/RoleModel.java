package in.co.rays.proj04.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.proj04.bean.RoleBean;
import in.co.rays.proj04.expection.ApplicationException;
import in.co.rays.proj04.expection.DuplicateRecordException;
import in.co.rays.proj04.util.JDBCDataSource;

public class RoleModel extends BaseModel<RoleBean> {

	@Override
	public void update(RoleBean bean) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTable() {
		// TODO Auto-generated method stub
		return "st_role";
	}

	@Override
	public RoleBean getBean() {
		return new RoleBean();
	}

	@Override
	public long add(RoleBean bean) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Connection conn = null;
		conn = JDBCDataSource.getConnection();

		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES (?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getCreatedBy());
			pstmt.setString(5, bean.getModifiedBy());
			pstmt.setTimestamp(6, bean.getCreatedDatetime());
			pstmt.setTimestamp(7, bean.getModifiedDatetime());

			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			JDBCDataSource.trnRollBack(conn);
			
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		

		return bean.getId();
	}
	
	
	
	
	
}
