package App.contUser.cosCumparaturi;

public class cos {
    private int codProdus;
    private String numeProdus;
    private String categorieProdus;
    private float pretProdus;
    private int cantitateProdus;
    protected int nrCos = 0;

    public int getCodProdus() {
        return codProdus;
    }

    public void setCodProdus(int codProdus) {
        this.codProdus = codProdus;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    public String getCategorieProdus() {
        return categorieProdus;
    }

    public void setCategorieProdus(String categorieProdus) {
        this.categorieProdus = categorieProdus;
    }

    public float getPretProdus() {
        return pretProdus;
    }

    public void setPretProdus(float pretProdus) {
        this.pretProdus = pretProdus;
    }

    public int getCantitateProdus() {
        return cantitateProdus;
    }

    public void setCantitateProdus(int cantitateProdus) {
        this.cantitateProdus = cantitateProdus;
    }

    @Override
    public String toString() {
        return "cos{" +
                "codProdus=" + codProdus +
                ", numeProdus='" + numeProdus + '\'' +
                ", categorieProdus='" + categorieProdus + '\'' +
                ", pretProdus=" + pretProdus +
                ", cantitateProdus=" + cantitateProdus +
                '}';
    }

}
