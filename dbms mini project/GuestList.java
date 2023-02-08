import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import  java.sql.*;
class list extends JFrame {
    JFrame frame = new JFrame();
    JButton btn = new JButton();
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane pane = new JScrollPane(table);
    Graphics g;

    Connection con= null;

    list()
    {

        con = DB.dbconnect();


        frame.setBounds(180,180,1365,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Guest");

        Object[] columns = {"First_name","Last_name", "Address","contact","Id_Proof","gender","email","Room_Allotment"};
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setGridColor(Color.black);
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        pane.setForeground(Color.red);
        pane.setBounds(200,10,1000,500);
        frame.getContentPane().add(pane);
        Object[] row = new Object[4];

        try {
            Statement st = con.createStatement();
            String sql = "Select * from guestlist";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                String First_name = rs.getString("First_name");
                String Last_name = rs.getString("Last_name");
                String Address = rs.getString("Address");
                String contact = rs.getString("contact");
                String Id_proof = rs.getString("Id_proof");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String Room_Allotment = rs.getString("Room_Allotment");

                String tbdata[] = {First_name,Last_name,Address,contact,Id_proof,gender,email,Room_Allotment};
                model.addRow(tbdata);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        /*btn.setText("Show Guest List");
        btn.setBounds(50,50,100,60);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });*/

        frame.add(btn);

        frame.setVisible(true);

    }
}
public class GuestList {
    public static void main(String args[])
    {
       // new list();

    }
}
