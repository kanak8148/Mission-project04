package in.co.rays.proj04.model;

import in.co.rays.proj04.bean.RoleBean;
import in.co.rays.proj04.expection.ApplicationException;
import in.co.rays.proj04.expection.DuplicateRecordException;

public class RoleModel extends BaseModel<RoleBean>{

	@Override
	public long add(RoleBean bean) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(RoleBean bean) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getWhereClause(RoleBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleBean getBean() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}}
