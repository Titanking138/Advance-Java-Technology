/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

/**
 *
 * @author admin
 */
public class Gui extends Frame implements ItemListener, ActionListener {

    private Choice option = new Choice();
    private Choice searchList = new Choice();
    private Choice filt = new Choice();
    private TextField tf1 = new TextField(20);
    private TextField number = new TextField(20);
    private TextField firstName = new TextField(20);
    private TextField middleName = new TextField(20);
    private TextField lastName = new TextField(20);
    private TextField area = new TextField(20);
    private TextField city = new TextField(20);
    private TextArea ta1 = new TextArea(10, 100);
    Button submit = new Button("submit");
    String query = "";
    String insertQuery = "";
    PreparedStatement pstate = null;
    Connection conn = null;
    ResultSet rs = null;
    Label status = new Label("Result Found : 0 ");
    int flag=0;

    Gui(String name, Connection conn) {
        super(name);
        setVisible(true);
        setSize(1000, 1000);
        setLayout(new BorderLayout());
        this.conn = conn;
        Panel p = new Panel();

        p.setLayout(new GridLayout(6, 2));
        option.addItemListener(this);
        option.add("select option");
        option.add("Add contact");
        option.add("search");
        p.add(new Label("Feature : "));
        p.add(option);
        searchList.addItemListener(this);
        searchList.add("Telephone Number");
        searchList.add("Name");
        searchList.add("Address");
        p.add(new Label("Search By : "));
        p.add(searchList);
        p.add(new Label("Filters : "));
        p.add(filt);
        filt.setVisible(false);
        p.add(new Label("Enter detail :"));
        p.add(tf1);
        
        p.add(new Label("Enter Number : "));
        p.add(number);
        p.add(new Label("Enter First name : "));
        p.add(firstName);
        p.add(new Label("Enter Middle Name : "));
        p.add(middleName);
        p.add(new Label("Enter Last name : "));
        p.add(lastName);
        p.add(new Label("Enter area : "));
        p.add(area);
        p.add(new Label("Enter city : "));
        p.add(city);
        number.setVisible(false);
        firstName.setVisible(false);
        middleName.setVisible(false);
        lastName.setVisible(false);
        city.setVisible(false);
        area.setVisible(false);
        
        p.add(new Label(""));
        p.add(submit);
        add("North", p);
        add("Center", ta1);
        add("South", status);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        submit.addActionListener(this);
        searchList.addItemListener(this);

    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
        String arg = arg0.getItem().toString();
        
        if (arg.equals("search") || flag == 1) {
            flag = 1;
            tf1.setVisible(true);
            searchList.setVisible(true);
            number.setVisible(false);
            firstName.setVisible(false);
            middleName.setVisible(false);
            lastName.setVisible(false);
            city.setVisible(false);
            area.setVisible(false);
            if (arg0.equals("Telephone Number")) {
                filt.setVisible(false);
            } else if (arg0.equals("Name")) {
                filt.removeAll();
//                System.out.println("run name");
                filt.setVisible(true);
                filt.add("First Name");
                filt.add("Middle Name");
                filt.add("Last Name");
            } else if (arg0.equals("Address")) {
                filt.removeAll();
                filt.add("Area");
                filt.add("City");
                filt.setVisible(true);
            }
        } else if(arg.equals("Add contact") || flag == 2){
            tf1.setVisible(false);
            searchList.setVisible(false);
            number.setVisible(true);
            firstName.setVisible(true);
            middleName.setVisible(true);
            lastName.setVisible(true);
            city.setVisible(true);
            area.setVisible(true);
            status.setVisible(false);
            flag = 2;
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        int len = 0;

        try {
            ta1.setText("refresh");
            query = new String("select * from ajt.telephone ");
            len = tf1.getText().toString().trim().length();
            if (option.getSelectedItem().equals("search")) {
                if (searchList.getSelectedItem().equals("Telephone Number") && len > 0) {
                    query += " where number = ? ";
                    pstate = conn.prepareStatement(query);
                    pstate.setInt(1, Integer.parseInt(tf1.getText().toString().trim()));
//                System.out.println(tf1.getText().toString().trim());
                } else if (searchList.getSelectedItem().equals("Name") && len > 0) {
                    if (filt.getSelectedItem().equals("First Name")) {
                        query += " where firstname = ?";
                    } else if (filt.getSelectedItem().equals("Middle Name")) {
                        query += " where middlename = ? ";
                    } else if (filt.getSelectedItem().equals("Last Name")) {
                        query += " where lastname = ? ";
                    }
                    System.out.println(query);
                    pstate = conn.prepareStatement(query);
                    pstate.setString(1, tf1.getText().toString().trim());
                } else if (searchList.getSelectedItem().equals("Address") && len > 0) {
                    if (filt.getSelectedItem().equals("Area"));
                    {
                        query += " where area = ?";
                    }
                    if (filt.getSelectedItem().equals("City")) {
                        query += " where city = ?";
                    }

                    pstate = conn.prepareStatement(query);
                    pstate.setString(1, tf1.getText().toString().trim());

                } else {
                    pstate = conn.prepareStatement(query);
                }

                try {
                    System.out.println(query);
                    rs = pstate.executeQuery();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Text Null ");
                    ta1.setText("No records Found");
                    status.setText("Record Found : 0");
                }
                if (rs != null) {
                    //TODO : modify 
                    ta1.setText("Number\t\tFName\t\tMName\t\tLNAME\t\tArea\t\tCity\n");

                    int count = 0;

                    while (rs.next()) {
                        ta1.append("" + rs.getString(1) + "\t");
                        ta1.append("" + rs.getString(2) + "\t\t");
                        ta1.append("" + rs.getString(3) + "\t\t");
                        ta1.append("" + rs.getString(4) + "\t\t");
                        ta1.append("" + rs.getString(5) + "\t\t");
                        ta1.append("" + rs.getString(6) + "\t\t");
                        count++;
                    }
                    status.setText("Record Found : " + count);

                }
            } else {
                insertQuery = new String("insert into ajt.telephone values (?,?,?,?,?,?)");
                int number1 = Integer.parseInt(number.getText().toString().trim());
                pstate = conn.prepareStatement(insertQuery);
                pstate.setInt(1,number1 );
                pstate.setString(2, firstName.getText().toString().trim());
                pstate.setString(3, middleName.getText().toString().trim());
                pstate.setString(4, lastName.getText().toString().trim());
                pstate.setString(5, area.getText().toString().trim());
                pstate.setString(6, city.getText().toString().trim());
                pstate.executeUpdate();
                ta1.setText("inserted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
