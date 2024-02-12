
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Transactions extends JFrame implements ActionListener  {
    
    JButton deposit,withdraw,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    
    
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        setTitle("All Transactions");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT );
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0 ,900,900);
        add(image);



        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(208,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);

        deposit =new JButton("Deposit");
        deposit.setBounds(170,370,150,35);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw =new JButton("cash widthdrow");
        withdraw.setBounds(355,370,150,35);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash =new JButton("Fast Cash");
        fastcash.setBounds(170,415,150,35);
        fastcash.addActionListener(this);
        image.add(fastcash);


        ministatement =new JButton("Mini statement");
        ministatement.setBounds(355,415,150,35);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange =new JButton("Pin Change");
        pinchange.setBounds(170,460,150,35);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry =new JButton("balance enquiry");
        balanceenquiry.setBounds(355,460,150,35);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit =new JButton("Exit");
        exit.setBounds(355,508,150,35);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
   

    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==deposit){ 
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdraw){ 
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
     }
        
        else if(ae.getSource()==fastcash){ 
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){ 
            new MiniStatement(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){ 
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry){ 
          this.setVisible(false);
          new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==exit){ 
            System.exit(0);
        }

    }
    
     public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
    

