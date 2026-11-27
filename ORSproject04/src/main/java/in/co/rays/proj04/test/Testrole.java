package in.co.rays.proj04.test;

import java.sql.Timestamp;

import in.co.rays.proj04.bean.RoleBean;
import in.co.rays.proj04.model.RoleModel;

public class Testrole {

	public static void main(String[] args) {

		add();

	}

	private static void add() {
		// TODO Auto-generated method stub

		RoleBean bean = new RoleBean();
		RoleModel md = new RoleModel();

		bean.setName("Admin");
		bean.setDescription("Admin");

		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");

		bean.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		bean.setModifiedDatetime(new Timestamp(System.currentTimeMillis()));

		md.add(bean);
		System.out.println("Add Role Successfully");
	}

}
