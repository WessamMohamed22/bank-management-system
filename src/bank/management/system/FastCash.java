
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    
     JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, back;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(210, 300, 700, 35);
        image.add(l1);

        b1 = new JButton("Rs 100");
        b1.setBounds(170, 375, 150, 35);
         b1.addActionListener(this);
        image.add(b1);
        
        
        b2 = new JButton("Rs 500");
        b2.setBounds(355, 375, 150, 35);
        b2.addActionListener(this);
        image.add(b2);
        
        
        b3 = new JButton("Rs 1000");
        b3.setBounds(170, 420, 150, 35);
         b3.addActionListener(this);
        image.add(b3);
        
        
        b4 = new JButton("Rs 2000");
        b4.setBounds(355, 420, 150, 35);
          b4.addActionListener(this);
        image.add(b4);
        
        
        b5 = new JButton("Rs 5000");
        b5.setBounds(170, 465, 150, 35);
        b5.addActionListener(this);
        image.add(b5);
        
        
        b6 = new JButton("Rs 10000");
        b6.setBounds(355, 465, 150, 35);
        b6.addActionListener(this);
        image.add(b6);
        
        
        back = new JButton("BACK");
        back.setBounds(355, 510, 150, 35);
        back.addActionListener(this);
        image.add(back);

        setLayout(null);

       


        setSize(900, 900);
        setLocation(300, 0);
      //  setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == back) {
                this.setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }else{
                Date date = new Date();
                c1.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
    
}

