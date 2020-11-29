package view_pab;

import java.awt.Container;

import javax.swing.JFrame;

public class administrator extends JFrame {

	private static final long serialVersionUID = -8773176858606913409L;
	private Container container=getContentPane();

	public administrator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	setTitle("Administrator");
		setBounds(100, 100, 450, 300);
		setLayoutManager();
        addComponentsToContainer();
	}

	public void setLayoutManager(){
    	container.setLayout(null);
    }

	public void addComponentsToContainer()
    {
    }


}
