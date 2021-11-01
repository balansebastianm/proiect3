package App.Produse;

import java.util.Objects;

public class cautareProduse extends adaugareInitiala{
    int nrProduse = numarProduse();

    //cautare dupa nume
    public int cautareProduse(produseMagazin[] p, String name){
        for(int i=1; i<=nrProduse; i++){
            if (Objects.equals(p[i].getNumeProdus(), name)) {
                return i;
            }
        }

        return 0;
    }
    //cautare dupa cod
    public int cautareProduse(produseMagazin[] p, int cod){
        for(int i=1; i<=nrProduse; i++){
            if (Objects.equals(p[i].getCodProdus(), cod)) {
                return i;
            }
        }
        return 0;
    }
}
