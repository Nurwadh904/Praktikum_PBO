// Class Buah Lokal

package Posttest6;

public class BuahImport extends Buah {
    private String negaraAsal;

    public BuahImport(String nama, double harga, int stok, String negaraAsal) {
        super(nama, harga, stok);
        this.negaraAsal = negaraAsal;
    }

    public String getNegaraAsal() { return negaraAsal; }
    public void setNegaraAsal(String negaraAsal) { this.negaraAsal = negaraAsal; }

    @Override
    public String getAsal() {
        return negaraAsal;
    }

    @Override
    public String toString() {
        return super.toString() + ", Asal Negara: " + negaraAsal + " (Impor)";
    }
}
