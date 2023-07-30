import java.util.*;
import javax.swing.*;
import java.awt.event.*;

class Accessories {
    int Prod_ID;
    String Prod_Name;
    int price;

    Accessories(int Prod_ID, String Prod_Name, int price) {
        this.Prod_ID = Prod_ID;
        this.Prod_Name = Prod_Name;
        this.price = price;
    }
}

class CustomerAcc extends JFrame implements ActionListener {
    int id;
    String name;
    String address;
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4;
    JButton b1, b2;
    JTextArea area1, area2;
    JList<String> list;
    ArrayList<Accessories> al = new ArrayList<Accessories>();
    ArrayList<CustomerAcc> alc = new ArrayList<CustomerAcc>();
    Accessories acrs1;
    Accessories acrs2;
    Accessories acrs3;
    Accessories acrs4;
    Accessories acrs5;

    CustomerAcc() {
        l1 = new JLabel("Accessories");
        l1.setBounds(50, 50, 100, 30);
        String s1[] = { "KeyBoard", "Mouse", "CPU", "Charger", "WPS" };
        list = new JList(s1);
        list.setSelectionMode(DefaultListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setBounds(150, 50, 100, 120);
        l2 = new JLabel("Quantity");
        l2.setBounds(50, 200, 100, 30);
        t1 = new JTextField();
        t1.setBounds(150, 200, 100, 30);
        l3 = new JLabel("Customer ID");
        l3.setBounds(50, 250, 100, 30);
        t2 = new JTextField();
        t2.setBounds(150, 250, 100, 30);
        l4 = new JLabel("Name");
        l4.setBounds(50, 300, 100, 30);
        t3 = new JTextField();
        t3.setBounds(150, 300, 100, 30);
        l5 = new JLabel("Address");
        l5.setBounds(50, 350, 100, 30);
        t4 = new JTextField();
        t4.setBounds(150, 350, 100, 30);
        b1 = new JButton("Purchase");
        b1.setBounds(75, 400, 100, 30);
        b2 = new JButton("Report");
        b2.setBounds(75, 450, 100, 30);
        area1 = new JTextArea();
        area1.setBounds(280, 50, 250, 380);
        area2 = new JTextArea();
        area2.setBounds(550, 50, 250, 380);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(b1);
        add(b2);
        add(area1);
        add(area2);
        add(list);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(1000, 1000);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        acrs1 = new Accessories(101, "KeyBoard", 500);
        acrs2 = new Accessories(102, "Mouse", 400);
        acrs3 = new Accessories(103, "CPU", 900);
        acrs4 = new Accessories(104, "Charger", 350);
        acrs5 = new Accessories(105, "WPS", 450);
        al.add(acrs1);
        al.add(acrs2);
        al.add(acrs3);
        al.add(acrs4);
        al.add(acrs5);
    }

    CustomerAcc(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void addDetails(CustomerAcc c1) {
        alc.add(c1);
    }

    public void actionPerformed(ActionEvent e) {
        CustomerAcc c;
        String qty = t1.getText();
        int a = Integer.parseInt(qty);
        String cid = t2.getText();
        int b = Integer.parseInt(cid);
        String nme = t3.getText();
        String addrs = t4.getText();
        if (e.getSource() == b1) {
            String Accc = "";
            Accc = list.getSelectedValue();
            String s = "";
            for (Accessories acrs6 : al) {
                if (acrs6.Prod_Name.equals(Accc)) {
                    s += "Product Name:" + acrs6.Prod_Name + "\n";
                    s += "Product Price:" + (acrs6.price * a) + "\n";
                    if ((acrs6.price * a) > 1000 && (acrs6.price * a) < 1500) {
                        s += "Discount price:" + ((acrs6.price * a) - (0.02f * acrs6.price)) + "\n";
                    }
                    if ((acrs6.price * a) > 1500) {
                        s += "Discount price:" + ((acrs6.price * a) - (0.05f * acrs6.price)) + "\n";
                    }
                }
            }
            area1.setText(s);
            c = new CustomerAcc(b, nme, addrs);
            addDetails(c);			
        }
		if(e.getSource()==b2){
			String ss="";
			for(CustomerAcc ca:alc){
				ss+=ca.id+"\n"+ca.name+"\n"+ca.address+"\n\n";
			}
			area2.setText(ss);
		}
    }

    public static void main(String args[]) {
        new CustomerAcc();
    }
}
