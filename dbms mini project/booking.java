import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.ResultSet;

class book
{
    JFrame frame1 = new JFrame();
    JPanel p = new JPanel();

    JPanel panel = new JPanel();
    //JMenuBar menu= new JMenuBar();
    JLabel label = new JLabel();
    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();
    JLabel l5 = new JLabel();
    JLabel l6 = new JLabel();
    JLabel l7 = new JLabel();
    JLabel l8 = new JLabel();
    JTextField tl1 = new JTextField();
    JTextField tl2 = new JTextField();
    JTextField tl3 = new JTextField();
    JTextField tl4 = new JTextField();
    JTextField tl5 = new JTextField();
    JTextField tl6 = new JTextField();
    JTextField tl7 = new JTextField();
    JTextField tl8 =new JTextField();
    // JMenu item1 = new JMenu("New Guest");
    // JMenu item2 = new JMenu("Guest List");
    //JButton listbtn = new JButton();
    //JButton guestbtn = new JButton();
    JButton submit = new JButton();
    ImageIcon image ;
    JLabel bgimg;
    Connection conn=null;

    book()

    {
        conn = DB.dbconnect();

        frame1.setBounds(180,180,1365,650);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);
        //frame.setTitle("Guest");

      /*  guestbtn.setText("  New Guest    ");
        guestbtn.setBounds(800,0,200,20);
        guestbtn.setFocusable(false);
        guestbtn.setBackground(Color.white);
        Border border1 = BorderFactory.createLineBorder(new Color(255,255,255));
        guestbtn.setBorder(border1);
        menu.add(guestbtn);

        listbtn.setText("Guest List");
        listbtn.setBounds(200,0,200,20);
        listbtn.setFocusable(false);
        listbtn.setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(new Color(255,255,255));
        listbtn.setBorder(border);
        listbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new list();
            }
        });
        menu.add(listbtn);*/



//        menu.add(item1);
//        menu.add(item2);
      //  frame1.setJMenuBar(menu);
        // item2.addActionListener(this);

        label.setText("New Guest Form");
        label.setBounds(30,10,600,100);
        label.setFont(new Font("Comic sans",Font.BOLD,40));
        label.setForeground(Color.yellow);
        frame1.add(label);

        l1.setText("First Name");
        l1.setBounds(60,90,100,100);
        l1.setFont(new Font("comic sans",Font.PLAIN,20));
        l1.setForeground(Color.white);
        frame1.add(l1);

        tl1.setBounds(220,125,250,26);
        frame1.add(tl1);

        l2.setText("Last Name");
        l2.setBounds(60,140,100,100);
        l2.setFont(new Font("comic sans",Font.PLAIN,20));
        l2.setForeground(Color.white);
        frame1.add(l2);

        tl2.setBounds(220,175,250,26);
        frame1.add(tl2);

        l3.setText("Address");
        l3.setBounds(60,190,100,100);
        l3.setFont(new Font("comic sans",Font.PLAIN,20));
        l3.setForeground(Color.white);
        frame1.add(l3);

        tl3.setBounds(220,225,250,26);
        frame1.add(tl3);

        l4.setText("Contact");
        l4.setBounds(60,240,100,100);
        l4.setFont(new Font("comic sans",Font.PLAIN,20));
        l4.setForeground(Color.white);
        frame1.add(l4);

        tl4.setBounds(220,275,250,26);
        frame1.add(tl4);

        l5.setText("ID Proof");
        l5.setBounds(60,290,100,100);
        l5.setFont(new Font("comic sans",Font.PLAIN,20));
        l5.setForeground(Color.white);
        frame1.add(l5);

        tl5.setBounds(220,325,250,26);
        frame1.add(tl5);

        l6.setText("Gender");
        l6.setBounds(60,340,100,100);
        l6.setFont(new Font("comic sans",Font.PLAIN,20));
        l6.setForeground(Color.white);
        frame1.add(l6);

        tl6.setBounds(220,375,250,26);
        frame1.add(tl6);

        l7.setText("Email Id");
        l7.setBounds(60,390,100,100);
        l7.setFont(new Font("comic sans",Font.PLAIN,20));
        l7.setForeground(Color.white);
        frame1.add(l7);

        tl7.setBounds(220,425,250,26);
        frame1.add(tl7);
        p.setBounds(0,0,1360,10);
        frame1.add(p);

        l8.setText("Room Allotment");
        l8.setBounds(60,440,300,100);
        l8.setFont(new Font("comic sans",Font.PLAIN,20));
        l8.setForeground(Color.white);
        frame1.add(l8);

        tl8.setBounds(220,475,250,26);
        frame1.add(tl8);
        p.setBounds(0,0,1360,10);
        frame1.add(p);




        submit.setText("Book Now");
        submit.setBounds(280,550,150,40);
        submit.setFocusable(false);
        submit.setBackground(Color.red);
        Border border = BorderFactory.createEtchedBorder(10,Color.red,Color.yellow);
        submit.setBorder(border);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String First_name = tl1.getText();
                    String Last_name = tl2.getText();
                    String Address = tl3.getText();
                    String contact = tl4.getText();
                    String Id_Proof = tl5.getText();
                    String gender = tl6.getText();
                    String email = tl7.getText();
                    String room = tl8.getText();


                    PreparedStatement pst1 = conn.prepareStatement("insert into Guestlist(First_name,Last_name,Address,contact,Id_Proof,gender,email,Room_Allotment) values( ?,?,?,?,?,?,?,?)");

                    pst1.setString(1,First_name);
                    pst1.setString(2,Last_name);
                    pst1.setString(3,Address);
                    pst1.setString(4,contact);
                    pst1.setString(5,Id_Proof);
                    pst1.setString(6,gender);
                    pst1.setString(7,email);
                    pst1.setString(8,room);
                    pst1.executeUpdate();
                    tl1.setText("");
                    tl2.setText("");
                    tl3.setText("");
                    tl4.setText("");
                    tl5.setText("");
                    tl6.setText("");
                    tl7.setText("");
                    tl8.setText("");

                    //JOptionPane.showMessageDialog(null,"succesful");
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }


            }
        });
        frame1.add(submit);

        image = new ImageIcon(this.getClass().getResource("/guest1.jpg"));
        bgimg = new JLabel(image);
        bgimg.setBounds(600,50,800,500);
        frame1.add(bgimg);

        panel.setBounds(0,0,1360,680);
        panel.setBackground(new Color(53,94,59));
        frame1.add(panel);

        frame1.setVisible(true);


    }

}

public class booking {
    public static void main(String []args)
    {
       // new book();

    }

}
