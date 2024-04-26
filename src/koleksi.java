public class koleksi {
    protected String judul;
    protected int tahunTerbit;
    protected String kategori;

    public koleksi(){}
    
    public koleksi(String judul, int tahunTerbit, String kategori) {
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

}
