package App.contUser.cosCumparaturi;

public class adaugareCos extends cos{

    public adaugareCos(int codProdus, String numeProdus, String categorieProdus, float pretProdus, int cantitateProdus){
        cos[] c = new cos[getNrCos()];
        c[getNrCos()].setCodProdus(codProdus);
        c[getNrCos()].setNumeProdus(numeProdus);
        c[getNrCos()].setCategorieProdus(categorieProdus);
        c[getNrCos()].setPretProdus(pretProdus);
        c[getNrCos()].setCantitateProdus(cantitateProdus);
    }

}
