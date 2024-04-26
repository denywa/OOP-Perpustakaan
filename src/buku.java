import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class buku extends koleksi {
    private String isbn;

    public buku(){}
    
    public buku(String isbn) {
        this.isbn = isbn;
    }

    public buku(String judul, int tahunTerbit, String kategori, String isbn) {
        super(judul, tahunTerbit, kategori);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
  

    public void displayBukuDetails(ArrayList<buku> databaseBuku) {
        Object[] columnNames = new Object[]{
            "Judul",
            "Kategori",
            "isbn",
            "Tahun Terbit"
        };
        Object[][] rowData = dataGenerator(databaseBuku.size(), columnNames);
        for(int i = 0; i < rowData.length; i++){
            buku data = databaseBuku.get(i);
            rowData[i][0] = data.getJudul();
            rowData[i][1] = data.getKategori();
            rowData[i][2] = data.getIsbn();
            rowData[i][3] = data.getTahunTerbit();

        }
        generateTable("Buku Detail", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames, Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        try {
            printTXT("Buku Detail", tableFormatter(rowData, columnNames).split("/")[0], rowData, "Buku.txt", columnNames, Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
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
