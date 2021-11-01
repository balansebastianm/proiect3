package App.Produse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cautareNume extends adaugareInitiala{
    private JPanel panel1;
    private JLabel labelName, label;
    private JButton buttonAdd, buttonExit;
    private JTextField textName;

    public void add(produseMagazin[] p){
        JFrame f = new JFrame();
        panel1 = new JPanel(new GridLayout(5,2));
        labelName = new JLabel("Nume: ");
        textName = new JTextField();
        panel1.add(labelName);
        panel1.add(textName);


        buttonAdd = new JButton();
        buttonAdd.setText("Search");
        buttonExit = new JButton();
        buttonExit.setText("Exit");
        panel1.add(buttonAdd);
        panel1.add(buttonExit);
        for(int i=1; i<=numarProduse(); i++)
            System.out.println(p[i].toString());

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cautareProduse c = new cautareProduse();
                String nume = textName.getText();
                System.out.println("\""+nume+"\"");
                int a = c.cautareProduse(p, nume);
                if(a == 0){
                    JOptionPane.showMessageDialog(null,
                            "Produsul nu a fost gasit", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                else{
                    afisareProdus ap = new afisareProdus();
                    ap.show(p, a);
                }
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                f.dispose();
            }
        });
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.add(panel1, BorderLayout.CENTER);
        f.setTitle("Cautare dupa nume");
        f.setSize(300   ,150);
        f.setVisible(true);
    }
}
