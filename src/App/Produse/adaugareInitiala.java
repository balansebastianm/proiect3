package App.Produse;

import App.Interfaces.IadaugareInitiala;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class adaugareInitiala implements IadaugareInitiala {
    long lines;
    private int i = 1;
    {
        try {
            lines = Files.lines(Path.of("src\\App\\Produse\\listaProduse.txt")).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void adaugareProduse(produseMagazin[] p)
    {
        FileReader inputFile = null;
        try {
            inputFile = new FileReader("src\\App\\Produse\\listaProduse.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(inputFile);

        while(in.hasNextLine())
        {
            String s = in.nextLine();
            String[] sArray = s.split(",");

            int codProdus = Integer.parseInt(sArray[0]);
            String numeProdus = sArray[1];
            String categorieProdus = sArray[2];
            float pretProdus = Float.parseFloat(sArray[3]);
            int cantitateProdus = Integer.parseInt(sArray[4]);

            p[i] = new produseMagazin();
            p[i].setCodProdus(codProdus);
            p[i].setNumeProdus(numeProdus);
            p[i].setCategorieProdus(categorieProdus);
            p[i].setPretProdus(pretProdus);
            p[i].setCantitateProdus(cantitateProdus);
            i++;
        }
    }

    public int numarProduse(){
        return (int) lines;
    }


}
