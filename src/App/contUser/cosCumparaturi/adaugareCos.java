package App.contUser.cosCumparaturi;


import App.Produse.cautareProduse;
import App.Produse.produseMagazin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adaugareCos extends cos{

    private JLabel labelCodProdus;
    private JButton buttonAdd, buttonClose;
    private JTextField tfCodProdus;
    JFrame f = new JFrame();
    JPanel panel = new JPanel(new GridLayout(2,2));
    int total = 0;
    int s = -1;
    int var;
    cautareProduse cp = new cautareProduse();
    public adaugareCos(cos[] c, produseMagazin[] p){
        labelCodProdus = new JLabel();
        labelCodProdus.setText("Introduceti codul produsului");
        tfCodProdus = new JTextField();
        buttonAdd = new JButton("Adauga");
        buttonClose = new JButton("Close");
        panel.add(labelCodProdus);
        panel.add(tfCodProdus);
        panel.add(buttonAdd);
        panel.add(buttonClose);




        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = Integer.parseInt(tfCodProdus.getText());
                var = cp.cautareProduse(p, s);
                if(s != -1)
                {
                    c[getNrCos()] = new cos();
                    c[getNrCos()].setCodProdus(p[var].getCodProdus());
                    c[getNrCos()].setNumeProdus(p[var].getNumeProdus());
                    c[getNrCos()].setCategorieProdus(p[var].getCategorieProdus());
                    c[getNrCos()].setPretProdus(p[var].getPretProdus());
                    c[getNrCos()].setCantitateProdus(p[var].getCantitateProdus());
                    total += p[var].getPretProdus();
                    System.out.println(c[getNrCos()].toString());
                    setNrCos(getNrCos()+1);
                    JOptionPane.showMessageDialog(null,
                            "Produs adaugat", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Input invalid", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.add(panel, BorderLayout.CENTER);
        f.setTitle("Adauga produs");
        f.setSize(500   ,250);
        f.setVisible(true);
    }

}
