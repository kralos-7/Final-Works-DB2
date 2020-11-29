package pab;

import controller_pab.ctrlusers;
import model_pab.query_users;
import model_pab.users;
import view_pab.login;

public class main_pab {

	public static void main(String[] args) {
		users userx_model = new users();		
		query_users userx_query = new query_users();
		login userx_view = new login();

		ctrlusers userx_controller = new ctrlusers(userx_model, userx_query, userx_view);
		userx_controller.init();
		
		userx_view.setVisible(true);
	}

}
