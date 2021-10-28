package App.Produse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cautareCod extends adaugareInitiala {
    private JPanel panel1;
    private JLabel labelCode, label;
    private JButton buttonAdd, buttonExit;
    private JTextField textCode;

    public void add(produseMagazin[] p){
        JFrame f = new JFrame();
        panel1 = new JPanel(new GridLayout(5,2));
        labelCode = new JLabel("Cod: ");
        textCode = new JTextField();
        panel1.add(labelCode);
        panel1.add(textCode);


        buttonAdd = new JButton();
        buttonAdd.setText("Search");
        buttonExit = new JButton();
        buttonExit.setText("Exit");
        panel1.add(buttonAdd);
        panel1.add(buttonExit);

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cautareProduse c = new cautareProduse();
                int a = c.cautareProduse(p, Integer.parseInt(textCode.getText()));
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
        f.setTitle("Cautare dupa cod");
        f.setSize(300   ,150);
        f.setVisible(true);
    }
}
