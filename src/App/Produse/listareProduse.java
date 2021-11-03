package App.Produse;
import App.Threads.TlistareProduse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class listareProduse extends adaugareInitiala{
    private JPanel panel;
    private JTextArea textArea;
    private JButton button;
    int nrProd = (int)lines;

    public void listare(produseMagazin[] p) throws InterruptedException {

        DefaultListModel<String> str = new DefaultListModel<>();
        JFrame f = new JFrame();
        panel = new JPanel();

        Runnable r = new TlistareProduse(p, str, nrProd);
        Thread t = new Thread(r);
        t.start();


/*        for(int i=1; i<=nrProd; i++)
        {
            str.addElement("Produsul " + i + ": " + p[i].toString());
        }*/
        JList<String> list = new JList<>(str);
        list.setBounds(100,100, 850,750);
        f.add(list);


        button = new JButton("Close");
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
