package App.Meniu;

import App.Produse.*;
import App.contUser.cosCumparaturi.adaugareCos;
import App.contUser.cosCumparaturi.afisareCos;
import App.contUser.cosCumparaturi.cos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meniu extends JFrame {
    private JPanel Meniu;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;


    public void runMeniu(){
        produseMagazin[] p = new produseMagazin[100];
        adaugareInitiala a = new adaugareInitiala();
        cos[] c = new cos[100];
        a.adaugareProduse(p);
        setContentPane(Meniu);
        setTitle("Meniu");
        setSize(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cautareCod cd = new cautareCod();
                cd.add(p);

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cautareNume cn = new cautareNume();
                cn.add(p);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listareProduse l = new listareProduse();
                try {
                    l.listare(p);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaugareProdus adp = new adaugareProdus();
                adp.addProd(p);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaugareCos ac = new adaugareCos(c, p);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afisareCos ac = new afisareCos();
                ac.afisare(c);
            }
        });
    }


    public static class mainClass {
        public static void main(String[] args) {
            Meniu meniu = new Meniu();
        }
    }
}
