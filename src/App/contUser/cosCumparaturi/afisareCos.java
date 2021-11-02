package App.contUser.cosCumparaturi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class afisareCos extends cos{
    DefaultListModel<String> str = new DefaultListModel<>();
    JFrame f = new JFrame();
    JPanel panel = new JPanel();
    public void afisare(cos[] c){
        for(int i=1; i<=getNrCos(); i++){
            str.addElement(c[i].toString());

        }
        JList<String> list = new JList<>(str);
        list.setBounds(100,100, 850,750);
        f.add(list);
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
        f.setTitle("Lista produse");
        f.setSize(1200,800);
        f.setVisible(true);
    }
    }

