public class Barang {
    private String nama;
    private double harga;
    private int stok;

    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    @Override
    public String toString() {
        return String.format("%s - Rp%.2f - Stok: %d", nama, harga, stok);
    }
}