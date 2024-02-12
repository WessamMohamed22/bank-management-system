
package bank.management.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
      JTextField t1 ;
    JButton deposit,back;
    String pin;
    Deposit(String pin)
            {
           this.pin = pin;
         setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
         
        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);
        
            t1 = new JTextField();
           t1.setFont(new Font("Raleway", Font.BOLD, 22));
            t1.setBounds(175,350,320,30);
        image.add(t1);
        
        
         deposit   = new JButton("DEPOSIT");
         deposit.setBounds(350,450,150,30);
         deposit.addActionListener(this);
         image.add(deposit);
         
         
         back   = new JButton("Back");
         back.setBounds(350,490,150,30);
         back.addActionListener(this);
         image.add(back);
         
        

         
         
         setSize(900,900);
        //setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
    }
   
        
    
    public void actionPerformed(ActionEvent ae){
       
            try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        

        }  
    
    public static void main(String[] args){
          new Deposit("").setVisible(true);

    }
    
}
