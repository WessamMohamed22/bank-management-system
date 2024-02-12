
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel text,cardno,pin;
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField ;
    
    
    Login(){
        
        
        
         setTitle("AUTOMATED TELLER MACHINE");
         
         setLayout(null);
         
         
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.png"));
         Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel label = new JLabel(i3);
         label.setBounds(70, 10, 100, 100);
         add(label);
         
         
         
          text = new JLabel("WELCOME TO ATM");
          text.setFont(new Font("Osward", Font.BOLD, 38));
          text.setBounds(200,45,450,40);
          add(text);
          
          
          
          cardno = new JLabel("Card No : ");
          cardno.setFont(new Font("Raleway", Font.BOLD, 28));
          cardno.setBounds(120,150,400,40);
          add(cardno);
          
          
          
          cardTextField= new JTextField();
          cardTextField.setBounds(300, 160, 230, 30);
          cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
          add(cardTextField);
          
          
          
          
          pin = new JLabel("PIN : ");
          pin.setFont(new Font("Raleway", Font.BOLD, 28));
          pin.setBounds(120,220,250,30);
          add(pin);
          
          
          
          
          pinTextField= new JPasswordField();
          pinTextField.setBounds(300, 230, 230, 30);
          pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
          add(pinTextField);
          
          
          
                   
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
         
        
        
        
        
       clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        
        
        
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
          
        
        
          
          
         getContentPane().setBackground(new Color(221, 221, 221));
         setSize(800,480);
         setVisible(true);
         setLocation(550,200);
    
    
    }
    
    
    
      public void actionPerformed(ActionEvent ae){
          
         

           try{        
           if(ae.getSource()==login){
              Conn c1 = new Conn();
                String cardnumber  = cardTextField.getText();
                String pinnumber  = pinTextField.getText();
                String q  = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==clear){
                cardTextField.setText("");
                pinTextField.setText("");
            }else if(ae.getSource()==signup){
                setVisible(false);
                new SignupOne().setVisible(true);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
      }
    
    
    
    public static void main(String[] args) {
        
        new Login().setVisible(true);
    }
    
}
