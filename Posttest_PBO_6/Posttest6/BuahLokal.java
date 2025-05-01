// Class Buah Lokal

package Posttest6;

public class BuahLokal extends Buah {
    private String daerahAsal;

    public BuahLokal(String nama, double harga, int stok, String daerahAsal) {
        super(nama, harga, stok);
        this.daerahAsal = daerahAsal;
    }

    public String getDaerahAsal() { return daerahAsal; }
    public void setDaerahAsal(String daerahAsal) { this.daerahAsal = daerahAsal; }

    @Override
    public String getAsal() {
        return daerahAsal;
    }

    @Override
    public String toString() {
        return super.toString() + ", Asal Daerah: " + daerahAsal + " (Lokal)";
    }
}
