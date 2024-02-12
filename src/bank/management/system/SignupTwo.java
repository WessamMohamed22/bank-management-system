
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton next;
    JRadioButton ayes,ano,eyes,eno;
    JTextField panTextField,nationalidTextField;
    JComboBox religionComboBox,nationalitiesComboBox,incomeComboBox,educationComboBox,occupationComboBox;
    String formno;
    SignupTwo(String formno){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(150, 0, 100, 100);
        add(label);
        
        setLayout(null);
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        l1 = new JLabel("Page 2: Additonal Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,30,600,40);
        add(l1);
        
        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100,120,100,30);
        add(l2);
        
        String religion[] = {"Muslim","Christian","Jewish","Hindu","Other"};
        religionComboBox = new JComboBox(religion);
        religionComboBox.setBackground(Color.WHITE);
        religionComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        religionComboBox.setBounds(350,120,320,30);
        add(religionComboBox);
        
        l3 = new JLabel("Nationality:");
        l3.setFont(new Font("Raleway", Font.BOLD, 17));
        l3.setBounds(100,170,100,30);
        add(l3);
        
        String nationality[] = {"Egyption","Moroccan","Syrian","Sudanese","Other"};
        nationalitiesComboBox = new JComboBox(nationality);
        nationalitiesComboBox.setBackground(Color.WHITE);
        nationalitiesComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        nationalitiesComboBox.setBounds(350,170,320,30);
        add(nationalitiesComboBox);
        
        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100,220,100,30);
        add(l4);
        
        String income[] = {"Null","<3,50,0","<5,50,0","<10,00,0","Upto 20,00,0","Above 50,00,0"};
        incomeComboBox = new JComboBox(income);
        incomeComboBox.setBackground(Color.WHITE);
        incomeComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeComboBox.setBounds(350,220,320,30);
        add(incomeComboBox);
        
        l5 = new JLabel("Educational");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100,270,150,30);
        add(l5);
        
        l11 = new JLabel("Qualification:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100,290,150,30);
        add(l11);
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        educationComboBox = new JComboBox(education);
        educationComboBox.setBackground(Color.WHITE);
        educationComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        educationComboBox.setBounds(350,270,320,30);
        add(educationComboBox);
        
       
        l6 = new JLabel("Occupation:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(100,340,150,30);
        add(l6);
        
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupationComboBox = new JComboBox(occupation);
        occupationComboBox.setBackground(Color.WHITE);
        occupationComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationComboBox.setBounds(350,340,320,30);
        add(occupationComboBox);
        
        l7 = new JLabel("PAN Number:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100,390,150,30);
        add(l7);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(350,390,320,30);
        add(panTextField);
        
        l8 = new JLabel("National ID:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100,440,180,30);
        add(l8);
        
        nationalidTextField = new JTextField();
        nationalidTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nationalidTextField.setBounds(350,440,320,30);
        add(nationalidTextField);
        
        l9 = new JLabel("Senior Citizen:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(100,490,150,30);
        add(l9);
        
        ayes = new JRadioButton("Yes");
        ayes.setFont(new Font("Raleway", Font.BOLD, 14));
        ayes.setBackground(new Color(221, 221, 221));
        ayes.setBounds(350,490,100,30);
        add(ayes);
        
        ano = new JRadioButton("No");
        ano.setFont(new Font("Raleway", Font.BOLD, 14));
        ano.setBackground(new Color(221, 221, 221));
        ano.setBounds(460,490,100,30);
        add(ano);
        
        l10 = new JLabel("Existing Account:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100,540,180,30);
        add(l10);
        
        eyes = new JRadioButton("Yes");
        eyes.setFont(new Font("Raleway", Font.BOLD, 14));
        eyes.setBackground(new Color(221, 221, 221));
        eyes.setBounds(350,540,100,30);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setFont(new Font("Raleway", Font.BOLD, 14));
        eno.setBackground(new Color(221, 221, 221));
        eno.setBounds(460,540,100,30);
        add(eno);
        
        
        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));
        l12.setBounds(700,10,60,30);
        add(l12);
        
        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));
        l13.setBounds(760,10,60,30);
        add(l13);
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(570,640,100,30);
        next.addActionListener(this);
        add(next);
       
        
        
        
        
        
        getContentPane().setBackground(new Color(221, 221, 221)); 
        setSize(850,750);
        setLocation(500,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String religion = (String)religionComboBox.getSelectedItem(); 
        String nationality = (String)nationalitiesComboBox.getSelectedItem();
        String income = (String)incomeComboBox.getSelectedItem();
        String education = (String)educationComboBox.getSelectedItem();
        String occupation = (String)occupationComboBox.getSelectedItem();
        
        String pan = panTextField.getText();
        String nationalid = nationalidTextField.getText();
       
        String scitizen = "";
        if(ayes.isSelected()){ 
            scitizen = "Yes";
        }
        else if(ano.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(eyes.isSelected()){ 
            eaccount = "Yes";
        }else if(eno.isSelected()){ 
            eaccount = "No";
        }
        
        try{
            if(nationalidTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into SignupTwo values('"+formno+"','"+religion+"','"+nationality+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+nationalid+"','"+scitizen+"','"+eaccount+"')";
                c1.s.executeUpdate(q1);
               
               new SignupThree(formno).setVisible(true);
              setVisible(false);
            }
                
      
            
        }catch(Exception ex){
             ex.printStackTrace();
        }}
           public static void main(String[] args){
        new SignupTwo("").setVisible(true);
    }
}