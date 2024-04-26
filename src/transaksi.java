import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class transaksi {
    private int idTransaksi;
    private String nimOrNikPeminjam;
    private buku isbnBuku;
    private cd iCd;
    private String tanggalPinjam;
    private String tanggalKembali;

    public transaksi (){}
    
    public transaksi(int idTransaksi, String nimOrNikPeminjam, buku isbnBuku, cd iCd, String tanggalPinjam, String tanggalKembali) {
        this.idTransaksi = idTransaksi;
        this.nimOrNikPeminjam = nimOrNikPeminjam;
        this.isbnBuku = isbnBuku;
        this.iCd = iCd;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getNimOrNikPeminjam() {
        return nimOrNikPeminjam;
    }

    public void setNimOrNikPeminjam(String nimOrNikPeminjam) {
        this.nimOrNikPeminjam = nimOrNikPeminjam;
    }

    public buku getIsbnBuku() {
        return isbnBuku;
    }

    public void setIsbnBuku(buku isbnBuku) {
        this.isbnBuku = isbnBuku;
    }

    public cd getICd() {
        return iCd;
    }

    public void setICd(cd iCd) {
        this.iCd = iCd;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    // public void displayTransaksiDetails(ArrayList<transaksi> databaseTransaksi) {
    //     System.out.println("+-------------------------------------------------------------------------------------------------------------------------------+");
    //     System.out.println("|                                                       Transaksi Details                                                      |");
    //     System.out.println("+-------------------------------------------------------------------------------------------------------------------------------+");
    //     System.out.println("| ID Transaksi | Buku/CD       | ISBN/IDCD       | Tanggal Pinjam | Tanggal Kembali | NIM/NIK Peminjam |");
    //     System.out.println("+-------------------------------------------------------------------------------------------------------------------------------+");
        
    //     for (transaksi transaksiItem : databaseTransaksi) {
    //         String judul = transaksiItem.getIsbnBuku() != null ? transaksiItem.getIsbnBuku().getJudul() : (transaksiItem.getICd() != null ? transaksiItem.getICd().getJudul() : "N/A");
    //         String isbnOrIdcd = transaksiItem.getIsbnBuku() != null ? transaksiItem.getIsbnBuku().getIsbn() : (transaksiItem.getICd() != null ? Integer.toString(transaksiItem.getICd().getIdCD()) : "N/A");
    //         System.out.format("| %-12d | %-14s | %-14s | %-14s | %-15s | %-16s |\n",
    //                           transaksiItem.getIdTransaksi(), judul, isbnOrIdcd, transaksiItem.getTanggalPinjam(), transaksiItem.getTanggalKembali(), transaksiItem.getNimOrNikPeminjam());
    //     }
    //     System.out.println("+-------------------------------------------------------------------------------------------------------------------------------+");
    // }

    public String getJudulItem() {
        if (this.getIsbnBuku() != null) {
            return this.getIsbnBuku().getJudul();
        } else if (this.getICd() != null) {
            return this.getICd().getJudul();
        } else {
            return "N/A";
        }
    }

    public String getIsbnOrIdCd() {
        if (this.getIsbnBuku() != null) {
            return this.getIsbnBuku().getIsbn();
        } else if (this.getICd() != null) {
            return Integer.toString(this.getICd().getIdCD());
        } else {
            return "N/A";
        }
    }
    

    public void displayTransaksiDetails(ArrayList<transaksi> databaseTransaksi) {
        Object[] columnNames = new Object[]{
            "ID Transaksi",
            "Judul Buku/CD",
            "ISBN/idCD",
            "Tanggal Pinjam",
            "Tanggal Kembali",
            "NIM/NIK Peminjam"
        };
        Object[][] rowData = dataGenerator(databaseTransaksi.size(), columnNames);
        for(int i = 0; i < rowData.length; i++){
            transaksi data = databaseTransaksi.get(i);
            rowData[i][0] = data.getIdTransaksi();
            rowData[i][1] = data.getJudulItem();
            rowData[i][2] = data.getIsbnOrIdCd();
            rowData[i][3] = data.getTanggalPinjam();
            rowData[i][4] = data.getTanggalKembali();
            rowData[i][5] = data.getNimOrNikPeminjam();
            
        }
        generateTable("Dosen Detail", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames, Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        try {
            printTXT("Transaksi Detail", tableFormatter(rowData, columnNames).split("/")[0], rowData, "Transaksi.txt", columnNames, Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        } catch (IOException e) {
            System.out.println("Failed to print to TXT file: " + e.getMessage());
        }
    }
    
    public static void generateTable(String bannerTitle, String tableFormat, Object[][] rowData, Object[] columnNames, int dataLengthTotal){
        String titleBanner = "+", titlePadding = "";
        if(dataLengthTotal % 2 == 0){
            for(int i=0; i < dataLengthTotal-1; i++){
                titleBanner += "-";
            }
        } else{
            for(int i=0; i < dataLengthTotal-1; i++){
                titleBanner += "-";
            }
        }
        titleBanner += "+";
        for(int i=0; i < ((dataLengthTotal-bannerTitle.length())/2)-1; i++){
            titlePadding += " ";
        }
        System.out.printf(titleBanner + "%n");
        System.out.printf("|" + titlePadding + bannerTitle + " " + titlePadding + "|%n");
        System.out.printf(titleBanner + "%n");
        System.out.printf(tableFormat, columnNames);
        System.out.printf(titleBanner + "%n");
        for (int n = 0; n < rowData.length; n++) {
            System.out.printf(tableFormat, rowData[n]);
        }
        System.out.printf(titleBanner + "%n");
}

public static boolean printTXT(String bannerTitle, String tableFormat, Object[][] rowData, String pathToFile, Object[] columnNames, int dataLengthTotal) throws IOException{
        try{
            PrintWriter txt = new PrintWriter (pathToFile);
            String titleBanner = "+", titlePadding = "";
            if(dataLengthTotal % 2 == 0){
                for(int i=0; i < dataLengthTotal; i++){
                    titleBanner += "-";
                }
            } else{
                for(int i=0; i < dataLengthTotal; i++){
                    titleBanner += "-";
                }
            }
            titleBanner += "+";
            for(int i=0; i < ((dataLengthTotal-bannerTitle.length())/2)-1; i++){
                titlePadding += " ";
            }
            txt.printf(titleBanner + "%n");
            txt.printf("|" + titlePadding + bannerTitle + " " + titlePadding + "|%n");
            txt.printf(titleBanner + "%n");
            txt.printf(tableFormat, columnNames);
            txt.printf(titleBanner + "%n");
            for (int n = 0; n < rowData.length; n++) {
                txt.printf(tableFormat, rowData[n]);
            }
            txt.printf(titleBanner + "%n");
            txt.close();
            return true;
        } catch(Exception e){
            return false;
        }
    }


public static Object[][] dataGenerator(int rowCount, Object[] columnNames){
    Object rowData[][] =  new Object[rowCount][columnNames.length];
    return rowData;
}

public static String tableFormatter(Object[][] rowData, Object[] columnNames){
    int[] dataLength = new int[columnNames.length];
    for (int length = 0; length < columnNames.length; length++) {
        if (columnNames[length] != null) {
            int panjangHeader = columnNames[length].toString().length();
            if (panjangHeader > dataLength[length]) {
                dataLength[length] = panjangHeader;
            }
        }
    }

    for(int i = 0; i < rowData.length; i++){
        for (int l = 0; l < columnNames.length; l++) {
            if (rowData[i][l] != null) {
                int panjangData = rowData[i][l].toString().length();
                if (panjangData > dataLength[l]) {
                    dataLength[l] = panjangData;
                }
            }
        }
    }
    
    String formatTable = "| %";
    int dataLengthTotal = 0;
    for(int a = 0; a < dataLength.length; a++) {
        formatTable += "-" + (dataLength[a] + 2) + "s | %";
        dataLengthTotal += dataLength[a] + 5;
    }
    formatTable += "n";
    return formatTable + "/" + dataLengthTotal;
}


}

