package App.Threads;

import App.Produse.adaugareInitiala;
import App.Produse.produseMagazin;

import javax.swing.*;

public class TlistareProduse extends adaugareInitiala implements Runnable{
    produseMagazin[] p;
    DefaultListModel<String> str;
    int nrProd;
    public TlistareProduse(produseMagazin[] p, DefaultListModel<String> str, int nrProd){
        this.nrProd = nrProd;
        this.str = str;
        this.p = p;
    }
    @Override
    public void run() {
        for(int i=1; i<=nrProd; i++)
        {
            str.addElement("Produsul " + i + ": " + p[i].toString());
        }
    }
}
