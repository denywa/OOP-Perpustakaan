import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class pustakawan {
    private int idPustakawan;
    private String nama;
    private String username;
    private String password;
    private String email;
    private String jabatan;
    private char kelamin;
    private String telp;

    public pustakawan (){}

    

    public pustakawan(int idPustakawan, String nama, String username, String password, String email, String jabatan,
            char kelamin, String telp) {
        this.idPustakawan = idPustakawan;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.email = email;
        this.jabatan = jabatan;
        this.kelamin = kelamin;
        this.telp = telp;
    }

    public int getIdPustakawan() {
        return idPustakawan;
    }

    public void setIdPustakawan(int idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public char getKelamin() {
        return kelamin;
    }

    public void setKelamin(char kelamin) {
        this.kelamin = kelamin;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public void displayPustakawanDetails(ArrayList<pustakawan> databasePustakawan) {
        Object[] columnNames = new Object[]{
            "Nama",
            "Email",
            "Telepon",
            "Jabatan",
            "Kelamin",
            "Username",
            "Password"
        };
        Object[][] rowData = dataGenerator(databasePustakawan.size(), columnNames);
        for(int i = 0; i < rowData.length; i++){
            pustakawan data = databasePustakawan.get(i);
            rowData[i][0] = data.getNama();
            rowData[i][1] = data.getEmail();
            rowData[i][2] = data.getTelp();
            rowData[i][3] = data.getJabatan();
            rowData[i][4] = data.getKelamin();
            rowData[i][5] = data.getUsername();
            rowData[i][6] = data.getPassword();
            
        }
        generateTable("Pustakawan Detail", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames, Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        try {
            printTXT("Pustakawan Detail", tableFormatter(rowData, columnNames).split("/")[0], rowData, "Pustakawan.txt", columnNames, Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
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
