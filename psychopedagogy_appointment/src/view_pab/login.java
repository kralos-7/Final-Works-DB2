package view_pab;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Font;

public class login extends JFrame {

	private static final long serialVersionUID = 4093009431210604159L;

	public Container container=getContentPane();
	public JLabel userLabel=new JLabel("Username");
	public JLabel passwordLabel=new JLabel("Password");
	public JTextField userTextField=new JTextField();
	public JPasswordField passwordField=new JPasswordField();
	public JButton loginButton=new JButton("Ingresar");
	public JCheckBox showPassword=new JCheckBox("Mostrar password");
 
    public login() {
    	setBounds(10, 10, 240, 320);
    	setResizable(false);
    	setTitle("Login");
        setLayoutManager();
        addComponentsToContainer();
        setLocationAndSize();
    }
    
    public void setLayoutManager(){
    	container.setLayout(null);
    }
    
    public void setLocationAndSize(){
       userLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 10));
       userLabel.setHorizontalAlignment(SwingConstants.RIGHT);
       userLabel.setBounds(10,92,70,30);
       passwordLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 10));
       passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
       passwordLabel.setBounds(10,133,70,30);
       userTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 10));
       userTextField.setBounds(90,92,124,30);
       passwordField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 10));
       passwordField.setEchoChar('*');
       passwordField.setBounds(90,133,124,30);
       showPassword.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 8));
       showPassword.setBounds(90,170,124,30);
       loginButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
       loginButton.setBounds(62,230,100,30);
    }
    
    public void addComponentsToContainer()
    {
    	//Adding each components to the Container
    	container.add(userLabel);
    	container.add(passwordLabel);
    	container.add(userTextField);
    	container.add(passwordField);
    	container.add(showPassword);
    	container.add(loginButton);
    	
    	JLabel lblNewLabel = new JLabel("<html><center>Psychopedagogy</center>Appointment Book</html>");
    	lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
    	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel.setBounds(10, 10, 204, 58);
    	
    	container.add(lblNewLabel);
    }
}
