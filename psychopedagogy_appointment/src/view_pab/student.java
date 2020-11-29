package view_pab;

import java.awt.Container;

import javax.swing.JFrame;

public class student extends JFrame {

	private static final long serialVersionUID = 6171991730636292247L;
	private Container container=getContentPane();

	public student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	setTitle("Student");
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
