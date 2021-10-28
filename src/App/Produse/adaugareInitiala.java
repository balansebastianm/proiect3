package App.Produse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class adaugareInitiala {
    long lines;
    public int i = 1;
    {
        try {
            lines = Files.lines(Path.of("C:\\Users\\Sebi\\IdeaProjects\\Proiect final\\src\\App\\Produse\\listaProduse.txt")).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void adaugareProduse()
    {
        FileReader inputFile = null;
        try {
            inputFile = new FileReader("C:\\Users\\Sebi\\IdeaProjects\\Proiect final\\src\\App\\Produse\\listaProduse.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(inputFile);

        int i = 1;
        produseMagazin[] p = new produseMagazin[(int) lines];
        while(in.hasNextLine())
        {
            String s = in.nextLine();
            String[] sArray = s.split(",");

            int codProdus = Integer.parseInt(sArray[0]);
            String numeProdus = sArray[1];
            String categorieProdus = sArray[2];
            float pretProdus = Float.parseFloat(sArray[3]);
            int cantitateProdus = Integer.parseInt(sArray[4]);

            p[i].setCodProdus(codProdus);
            p[i].setNumeProdus(numeProdus);
            p[i].setCategorieProdus(categorieProdus);
            p[i].setPretProdus(pretProdus);
            p[i].setCantitateProdus(cantitateProdus);
            i++;
        }
        i--;
    }


}
