package App.Produse;

import App.Interfaces.IafisareProdus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class afisareProdus implements IafisareProdus {

    public void show(produseMagazin[] p, int a){
        JFrame f = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel(p[a].toString());
        panel.add(label);
        JButton button = new JButton("Close");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.add(panel, BorderLayout.CENTER);
        f.setTitle("Produs gasit!");
        f.setSize(800   ,100);
        f.setVisible(true);
    }
}
