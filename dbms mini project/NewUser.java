import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;

class neww {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel register = new JLabel();
    JLabel fname = new JLabel();
    JLabel lname= new JLabel();
    JLabel contact = new JLabel();
    JLabel email = new JLabel();
    JLabel password = new JLabel();
    JLabel confirmpass = new JLabel();
    Cursor cursor ;
    JTextField tfname = new JTextField();
    JTextField tlname= new JTextField();
    JTextField tcontact = new JTextField();
    JTextField temail = new JTextField();
    JTextField tpassword = new JTextField();
    JPasswordField tconfirmpass = new JPasswordField();
    JCheckBox check = new JCheckBox();
    JLabel terms = new JLabel();
    JButton reg = new  JButton();
    JLabel bgimg1;
    ImageIcon image1;
    JLabel bgimg2;
    ImageIcon image2;

    Connection con = null ;

    neww()
    {
        con=DB.dbconnect();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("NEW REGISTER");
        frame.setBounds(0,0,1900,900);
        frame.setLayout(null);

        register.setText("Register Here");
        register.setForeground(Color.ORANGE);
        register.setBounds(800,150,500,100);
        register.setFont(new Font("Verdana",Font.BOLD,40));
        frame.add(register);

        fname.setText("First Name/Username");
        fname.setBounds(800,230,300,100);
        fname.setFont(new Font("Verdana",Font.BOLD,15));
        frame.add(fname);

        //tfname.setText("Enter your First Name...");
        tfname.setBounds(800,300,190,23);
        frame.add(tfname);

        lname.setText("Last Name");
        lname.setBounds(1050,230,300,100);
        lname.setFont(new Font("Verdana",Font.BOLD,15));
        frame.add(lname);

        //tlname.setText("Enter your Last Name...");
        tlname.setBounds(1050,300,190,23);
        frame.add(tlname);

        contact.setText("Contact");
        contact.setBounds(800,330,300,50);
        contact.setFont(new Font("Verdana",Font.BOLD,15));
        frame.add(contact);

        //tcontact.setText("Enter your Contact...");
        tcontact.setBounds(800,370,190,23);
        frame.add(tcontact);


        email.setText("Email");
        email.setBounds(1050,330,300,50);
        email.setFont(new Font("Verdana",Font.BOLD,15));
        frame.add(email);

        //temail.setText("Enter your Email id...");
        temail.setBounds(1050,370,190,23);
        frame.add(temail);

        password.setText("Password");
        password.setBounds(800,410,300,50);
        password.setFont(new Font("Verdana",Font.BOLD,15));
        frame.add(password);

        //tpassword.setText("Enter your Password...");
        tpassword.setBounds(800,450,190,23);
        frame.add(tpassword);


        confirmpass.setText("Confirm Password");
        confirmpass.setBounds(1050,410,300,50);
        confirmpass.setFont(new Font("Verdana",Font.BOLD,15));
        frame.add(confirmpass);

      //  tconfirmpass.setText("Enter your Password...");
        tconfirmpass.setBounds(1050,450,190,23);
        frame.add(tconfirmpass);

        check.setBounds(800,500,30,30);
        frame.add(check);

        terms.setText("I Agree The Terms & Condition");
        terms.setFont(new Font("Verdana",Font.PLAIN,15));
        terms.setBounds(840,490,900,50);
        frame.add(terms);

        reg.setText("Register Now");
        reg.setBounds(950,560,150,40);
        reg.setFocusable(false);
        reg.setBackground(Color.red);
        Border border = BorderFactory.createEtchedBorder(10,Color.red,Color.yellow);
        reg.setBorder(border);
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String first = tfname.getText();
                    String last = tlname.getText();
                    String cont = tcontact.getText();
                    String mail = temail.getText();
                    String pass = tpassword.getText();
                    //String cp = tconfirmpass.getText();

                    PreparedStatement pst = con.prepareStatement("insert into new_register( fname,lname,contact,email ,password) values( ?,?,?,?,?)");
                   PreparedStatement pst2 = con.prepareStatement("insert into login( fname,password) values( ?,?)");


                    pst.setString(1,first);
                    pst.setString(2,last);
                    pst.setString(3,cont);
                    pst.setString(4,mail);
                    pst.setString(5,pass);
                    pst2.setString(1,first);
                    pst2.setString(2,pass);
                    pst.executeUpdate();
                    pst2.executeUpdate();
                    tfname.setText("");
                    tlname.setText("");
                    tconfirmpass.setText("");
                    tpassword.setText("");
                    tcontact.setText("");
                    temail.setText("");

                    //JOptionPane.showMessageDialog(null,"succesful");
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }


            }
        });
        frame.add(reg);

         /*cursor = new Cursor(Cursor.HAND_CURSOR);
        tlname.setCursor(cursor);*/

        image2 = new ImageIcon(this.getClass().getResource("/checkin3.jpg"));
        bgimg2 = new JLabel(image2);
        bgimg2.setBounds(230,120,550,600);
        frame.add(bgimg2);


        panel.setBounds(250,120,1050,600);
        frame.add(panel);


        image1 = new ImageIcon(this.getClass().getResource("/new1.jpg"));
        bgimg1 = new JLabel(image1);
        bgimg1.setBounds(0,0,1800,900);
        frame.add(bgimg1);




        frame.setVisible(true);

    }
}

public class NewUser {
    public static void main(String []args)
    {

        //new neww();

    }
}
