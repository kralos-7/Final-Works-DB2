package controller_pab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import model_pab.query_users;
import model_pab.users;
import view_pab.administrator;
import view_pab.login;
import view_pab.student;

public class ctrlusers implements ActionListener{
	
	private users userx;
	private query_users usersx_q;	
	private login login_v;

	public ctrlusers(users userx, query_users usersx_q, login login_v) {
		this.userx = userx;
		this.usersx_q = usersx_q;
		this.login_v = login_v;
		this.login_v.loginButton.addActionListener(this);
		this.login_v.showPassword.addActionListener(this);
	}

	public void init() {
		login_v.setTitle("Login");
		login_v.setLocationRelativeTo(null);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login_v.loginButton)
		{
			/*
			 *		Falta validación de login y password 
			 * */
			userx.setLogin(login_v.userTextField.getText());
			String myPass=String.valueOf(login_v.passwordField.getPassword());
			userx.setPassword(getMD5EncryptedValue(myPass));
						
			if(usersx_q.ingresar(userx)) {
				JOptionPane.showMessageDialog(null, "WELCOME :D");
				if(userx.getPrivileges().equals("administrador")) {
					administrator administrator_view = new administrator();
					administrator_view.setVisible(true);					
				}else {
					student student_view = new student();
					student_view.setVisible(true);
				}
				login_v.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "<html>SOMETHING IS WRONG :S<br>VERIFY YOUR DATA PLEASE</html>");				
			}
			
		}
		
		if(e.getSource() == login_v.showPassword) {
			if (login_v.showPassword.isSelected()) {
				login_v.passwordField.setEchoChar((char) 0);
			} else {
				login_v.passwordField.setEchoChar('*');				
			}		
        }
		
	}
		
	public static String getMD5EncryptedValue(String password) {
        final byte[] defaultBytes = password.getBytes();
        try {
            final MessageDigest md5MsgDigest = MessageDigest.getInstance("MD5");
            md5MsgDigest.reset();
            md5MsgDigest.update(defaultBytes);
            final byte messageDigest[] = md5MsgDigest.digest();

            final StringBuffer hexString = new StringBuffer();
            for (final byte element : messageDigest) {
                final String hex = Integer.toHexString(0xFF & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            password = hexString + "";
        } catch (final NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return password;
	}
}
