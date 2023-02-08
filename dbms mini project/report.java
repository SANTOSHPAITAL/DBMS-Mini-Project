import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

class rep
{
    JFrame frame1 = new JFrame();
    JPanel p = new JPanel();
    JLabel label = new JLabel();
    JComboBox c1;

    JPanel panel = new JPanel();
    int[] sty={4,32,2,3,0};

   JButton check = new JButton();

    JPanel p1= new JPanel();


    ImageIcon image ;
    JLabel bgimg;
    ImageIcon image1 ;
    JLabel bgimg1;
    ImageIcon image2 ;
    JLabel bgimg2;
    JLabel roomid = new JLabel();
    JLabel l1 = new JLabel();
    Connection con= null;

    rep()

    {
        con = DB.dbconnect();

        frame1.setBounds(180,180,1360,650);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);
        //frame.setTitle("Guest");


        label.setText("Report Generation");
        label.setBounds(30,30,605,100);
        label.setFont(new Font("Comic sans",Font.BOLD,40));
        label.setForeground(Color.yellow);
        frame1.add(label);

        //roomid.setText("Room id");
        String Room[] = {"Select Room","Room No. 101","Room No. 102","Room No. 103","Room No. 104","Room No. 105"};
        c1 = new JComboBox(Room);
        c1.setBounds(130,150,200,40);
        c1.setBackground(new Color(255,255,255));
        c1.setFocusable(false);
        c1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==c1)
                {
                    if(c1.getSelectedItem()=="Room No. 101") {

                        image1 = new ImageIcon(this.getClass().getResource("/bill.png"));
                        bgimg1 = new JLabel(image1);
                        bgimg1.setBounds(0,0,100,150);
                        p.add(bgimg1);
                        p.setVisible(true);
                      /*  roomid.setText(" "+(sty[c1.getSelectedIndex()]*200));
                         roomid.setBounds(150,50,50,50);
                        p.add(roomid);*/
                    }
                    if(c1.getSelectedItem()=="Room No. 102") {
                        image2 = new ImageIcon(this.getClass().getResource("/bill1.png"));
                        bgimg2 = new JLabel(image2);
                        bgimg2.setBounds(0,0,100,150);
                        p.add(bgimg2);
                        p.setVisible(true);
                    }
                    if(c1.getSelectedItem()=="Room No. 103") {

                        image1 = new ImageIcon(this.getClass().getResource("/bill2.png"));
                        bgimg1 = new JLabel(image1);
                        bgimg1.setBounds(0,0,100,150);
                        p.add(bgimg1);
                        p.setVisible(true);
                    }
                    if(c1.getSelectedItem()=="Room No. 104") {

                        image1 = new ImageIcon(this.getClass().getResource("/bill3.png"));
                        bgimg1 = new JLabel(image1);
                        bgimg1.setBounds(0,0,100,150);
                        p.add(bgimg1);
                        p.setVisible(true);
                    }
                    if(c1.getSelectedItem()=="Room No. 105") {

                        image1 = new ImageIcon(this.getClass().getResource("/bill4.png"));
                        bgimg1 = new JLabel(image1);
                        bgimg1.setBounds(0,0,100,150);
                        p.add(bgimg1);
                        p.setVisible(true);
                    }

                        frame1.setVisible(true);

                }

            }
        });
       frame1.add(c1);

        p.setBounds(50,230,500,280);
        p.setVisible(false);
        frame1.add(p);


        check.setText("Chect Out");
        check.setFocusable(false);
        check.setBounds(190,540,150,30);
        check.setBackground(Color.cyan);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
            }
        });
        frame1.add(check);

        image = new ImageIcon(this.getClass().getResource("/checkout.jpg"));
        bgimg = new JLabel(image);
        bgimg.setBounds(600,50,700,500);
        frame1.add(bgimg);

        panel.setBounds(0,0,1360,640);
        panel.setBackground(new Color(53,94,59));
        frame1.add(panel);



        frame1.setVisible(true);

    }

}

public class report {
    public static void main(String []args)
    {
        //new rep();

    }

}
