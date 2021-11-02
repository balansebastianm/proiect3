package App.Produse;

import App.Interfaces.IadaugareProdus;
import jdk.dynalink.StandardOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class adaugareProdus implements IadaugareProdus {

    public void addProd(produseMagazin[] p){
        JFrame f = new JFrame();
        JPanel panel = new JPanel(new GridLayout(6,2));
        JLabel labelCodProdus = new JLabel("Cod produs: ");
        JLabel labelNumeProdus = new JLabel("Nume produs: ");
        JLabel labelCategorieProdus = new JLabel("Categorie produs: ");
        JLabel labelPretProdus = new JLabel("Pret produs: ");
        JLabel labelCantitateProdus = new JLabel("Cantitate produs: ");
        JTextField tfCodProdus = new JTextField();
        JTextField tfNumeProdus = new JTextField();
        JTextField tfCategorieProdus = new JTextField();
        JTextField tfPretProdus = new JTextField();
        JTextField tfCantitateProdus = new JTextField();
        JButton buttonClose = new JButton("Close");
        JButton buttonAdd = new JButton("Add");

        panel.add(labelCodProdus);
        panel.add(tfCodProdus);
        panel.add(labelNumeProdus);
        panel.add(tfNumeProdus);
        panel.add(labelCategorieProdus);
        panel.add(tfCategorieProdus);
        panel.add(labelPretProdus);
        panel.add(tfPretProdus);
        panel.add(labelCantitateProdus);
        panel.add(tfCantitateProdus);
        panel.add(buttonAdd);
        panel.add(buttonClose);


        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codProdus = Integer.parseInt(tfCodProdus.getText());
                String numeProdus = tfNumeProdus.getText();
                String categorieProdus = tfCategorieProdus.getText();
                Float pretProdus = Float.parseFloat(tfPretProdus.getText());
                int cantitateProdus = Integer.parseInt(tfCantitateProdus.getText());
                try {
                    BufferedWriter out = new BufferedWriter(
                            new FileWriter("C:\\Users\\Sebi\\IdeaProjects\\Proiect final\\src\\App\\Produse\\listaProduse.txt", true));
                    out.write("\n" + codProdus + "," + numeProdus + "," + categorieProdus + "," + pretProdus + "," + cantitateProdus);
                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                adaugareInitiala ai = new adaugareInitiala();
                listareProduse l = new listareProduse();
                ai.lines = ai.lines+1;
                int n = l.nrProd;
                p[n] = new produseMagazin();
                p[n].setCodProdus(codProdus);
                p[n].setNumeProdus(numeProdus);
                p[n].setCategorieProdus(categorieProdus);
                p[n].setPretProdus(pretProdus);
                p[n].setCantitateProdus(cantitateProdus);
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
        f.setTitle("Cautare produse");
        f.setSize(500   ,250);
        f.setVisible(true);
    }
}
