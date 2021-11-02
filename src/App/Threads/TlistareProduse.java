package App.Threads;

import App.Produse.adaugareInitiala;
import App.Produse.produseMagazin;

import javax.swing.*;

public class TlistareProduse extends adaugareInitiala implements Runnable{
    public TlistareProduse(produseMagazin[] p, DefaultListModel<String> str, int nrProd){
        for(int i=1; i<=nrProd; i++)
        {
            str.addElement("Produsul " + i + ": " + p[i].toString());
        }
    }
    @Override
    public void run() {

    }
}
