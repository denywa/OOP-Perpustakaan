public abstract class client {
    protected String nama;
    protected String alamat;
    protected String telp;
    protected String prodi;
    protected String fakultas;
    protected String username;
    protected String password;


    public client (){}

    public client(String nama, String alamat, String telp, String prodi, String fakultas, String username,
            String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
        this.prodi = prodi;
        this.fakultas = fakultas;
        this.username = username;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    
}
