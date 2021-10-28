package App.Meniu;

import App.Produse.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meniu extends JFrame {
    private JPanel Meniu;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public void runMeniu(){
        produseMagazin[] p = new produseMagazin[100];
        adaugareInitiala a = new adaugareInitiala();
        a.adaugareProduse(p);
        setContentPane(Meniu);
        setTitle("Meniu");
        setSize(450,300);
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
                l.listare(p);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("D");
            }
        });
    }

    public static class mainClass {
        public static void main(String[] args) {
            Meniu meniu = new Meniu();
        }
    }
}
