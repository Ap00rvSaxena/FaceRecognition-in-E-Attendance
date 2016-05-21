/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FaceGUI;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class Login extends JFrame implements ActionListener{

    JLabel l,l1,l2;
    JTextField t1,t2;
    JButton b1;
    Login(){
        super("Login Page");

	l=new JLabel("Face Identification Login");
	l.setFont(new Font("Times New Roman",Font.BOLD/Font.ITALIC,20));

	l1=new JLabel(" User Name ");
	l2=new JLabel(" Password ");

	t1=new JTextField(10);
	t2=new JPasswordField(10);
	 
	b1=new JButton(" Submit ");

	JPanel p1=new JPanel();
	JPanel p2=new JPanel();

	Container c=getContentPane();
	c.setLayout(null);
	c.add(p1);
	c.add(p2);

	setSize(400,500);
	setResizable(false);
	
	java.awt.Dimension screen=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	java.awt.Rectangle frame=getBounds();
	this.setLocation((screen.width-frame.width)/2,(screen.height-frame.height)/2);

	p1.setBounds(20,20,300,300);
	p2.setBounds(20,350,300,100);
	
	l.setBounds(70,10,200,30);

	l1.setBounds(40,80,100,30);
	t1.setBounds(180,80,100,30);

	l2.setBounds(40,160,100,30);
	t2.setBounds(180,160,100,30);

	p1.setLayout(null);
	
	p1.add(l);
	p1.add(l1);p1.add(t1);
	p1.add(l2);p1.add(t2);

	b1.setBounds(150,40,80,30);
	

	t1.setFont(new Font("Times New Roman",Font.BOLD/Font.ITALIC,18));
	t2.setFont(new Font("Times New Roman",Font.BOLD/Font.ITALIC,18));

	p2.setLayout(null);
	p2.add(b1);

	b1.addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton b=(JButton)ae.getSource();
	 if(b==b1)
	{
	 String s1=t1.getText();
	 String s2=t2.getText();
	
	if((t1.getText()).equals("face"))
        {
            if((t2.getText()).equals("face"))
            {
                setVisible(false);
                dispose();
               new ScannerGUI().setVisible(true);
			}
            else
            {
                JOptionPane.showMessageDialog(this, "Invalid password", "Sign In", JOptionPane.WARNING_MESSAGE);
				t2.setText("");
				t2.requestFocus();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Invalid UserName", "Sign In", JOptionPane.WARNING_MESSAGE);
			t1.setText("");
			t1.requestFocus();
			t2.setText("");
        }
    }	
	}
    }
public class Logging
{
    public static void main(String args[])
    {
            Login ob1=new Login();
		ob1.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
			ob1.setVisible(true);
    }
}
