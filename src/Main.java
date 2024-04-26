import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static ArrayList<mahasiswa> databaseMahasiswa = new ArrayList<>();
    private static ArrayList<dosen> databaseDosen = new ArrayList<>();
    private static ArrayList<buku> databaseBuku = new ArrayList<>();
    private static ArrayList<cd> databaseCD = new ArrayList<>();
    private static ArrayList<transaksi> databaseTransaksi = new ArrayList<>();
    private static ArrayList<pustakawan> databasePustakawan = new ArrayList<>();
    

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        try {
            // Create 5 mahasiswa objects
            databaseMahasiswa.add(new mahasiswa("Mahasiswa1", "Alamat1", "081234567890", "Informatika", "FTI", "m1", "m1", "NIM1"));
            databaseMahasiswa.add(new mahasiswa("Mahasiswa2", "Alamat2", "081234567891", "Sistem Informasi", "FTI", "m2", "m2", "NIM2"));
            databaseMahasiswa.add(new mahasiswa("Mahasiswa3", "Alamat3", "081234567892", "Teknik Elektro", "FTI", "m3", "m3", "NIM3"));
            databaseMahasiswa.add(new mahasiswa("Mahasiswa4", "Alamat4", "081234567893", "Teknik Industri", "FTI", "m4", "m4", "NIM4"));
            databaseMahasiswa.add(new mahasiswa("Mahasiswa5", "Alamat5", "081234567894", "Teknik Mesin", "FTI", "m5", "m5", "NIM5"));
           
            // Create 5 dosen objects
            databaseDosen.add(new dosen("Dosen1", "Alamat1", "081234567890", "Informatika", "FTI", "d1", "d1", "NIK1"));
            databaseDosen.add(new dosen("Dosen2", "Alamat2", "081234567891", "Sistem Informasi", "FTI", "d2", "d2", "NIK2"));
            databaseDosen.add(new dosen("Dosen3", "Alamat3", "081234567892", "Teknik Elektro", "FTI", "d3", "d3", "NIK3"));
            databaseDosen.add(new dosen("Dosen4", "Alamat4", "081234567893", "Teknik Industri", "FTI", "d4", "d4", "NIK4"));
            databaseDosen.add(new dosen("Dosen5", "Alamat5", "081234567894", "Teknik Mesin", "FTI", "d5", "d5", "NIK5"));

            // Create 5 buku objects
            databaseBuku.add(new buku("Buku1", 2001, "Edukasi", "ISBN1"));
            databaseBuku.add(new buku("Buku2", 2002, "Fiksi", "ISBN2"));
            databaseBuku.add(new buku("Buku3", 2003, "Non-Fiksi", "ISBN3"));
            databaseBuku.add(new buku("Buku4", 2004, "Sains", "ISBN4"));
            databaseBuku.add(new buku("Buku5", 2005, "Teknologi", "ISBN5"));

            // Create 5 cd objects
            databaseCD.add(new cd("CD1", 2010, "Musik", 101));
            databaseCD.add(new cd("CD2", 2011, "Film", 102));
            databaseCD.add(new cd("CD3", 2012, "Dokumenter", 103));
            databaseCD.add(new cd("CD4", 2013, "Edukasi", 104));
            databaseCD.add(new cd("CD5", 2014, "Game", 105));

            // Create 5 pustakawan objects
            databasePustakawan.add(new pustakawan(1, "Librarian1", "p1", "p1", "lib1@email.com", "Senior", 'M', "081234567890"));
            databasePustakawan.add(new pustakawan(2, "Librarian2", "p2", "p2", "lib2@email.com", "Junior", 'F', "081234567891"));
            databasePustakawan.add(new pustakawan(3, "Librarian3", "p3", "p3", "lib3@email.com", "Senior", 'M', "081234567892"));
            databasePustakawan.add(new pustakawan(4, "Librarian4", "p4", "p4", "lib4@email.com", "Junior", 'F', "081234567893"));
            databasePustakawan.add(new pustakawan(5, "Librarian5", "p5", "p5", "lib5@email.com", "Senior", 'M', "081234567894"));
        } catch (Exception e) {
            System.out.println("Error initializing data: " + e.getMessage());
        }

        while (running) {
            try {
                System.out.println("=== Pilihan Menu ===");
                System.out.println("1. Registrasi(Khusu Mahasiswa)");
                System.out.println("2. Login");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        // Registrasi
                        System.out.println("=== Registrasi ===");
                        System.out.print("Masukkan Nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Alamat: ");
                        String alamat = scanner.nextLine();
                        System.out.print("Masukkan Nomor Telepon: ");
                        String telp = scanner.nextLine();
                        System.out.print("Masukkan Program Studi: ");
                        String prodi = scanner.nextLine();
                        System.out.print("Masukkan Fakultas: ");
                        String fakultas = scanner.nextLine();
                        System.out.print("Masukkan NIM: ");
                        String nim = scanner.nextLine();
                        System.out.print("Masukkan Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Masukkan Password: ");
                        String password = scanner.nextLine();

                        mahasiswa mhs = new mahasiswa(nama, alamat, telp, prodi, fakultas, username, password, nim);
                        databaseMahasiswa.add(mhs);
                        System.out.println("Registrasi berhasil!");
                        break;
                    case 2:
                        // Login
                        System.out.println("\n=== Login ===");
                        System.out.println("Login sebagai:");
                        System.out.println("1. Dosen");
                        System.out.println("2. Mahasiswa");
                        System.out.println("3. Pustakawan");
                        System.out.print("Pilih jenis login: ");
                        int loginType = scanner.nextInt();
                        scanner.nextLine(); 

                        switch (loginType) {
                            case 1:
                                // Login Dosen
                                new dosen().displayDosenDetails(databaseDosen);
                                System.out.print("Masukkan Username: ");
                                String inputUsernameDosen = scanner.nextLine();
                                System.out.print("Masukkan Password: ");
                                String inputPasswordDosen = scanner.nextLine();

                                boolean isLoggedInDosen = false;
                                for (dosen d : databaseDosen) {
                                    if (d.getUsername().equals(inputUsernameDosen) && d.getPassword().equals(inputPasswordDosen)) {
                                        isLoggedInDosen = true;
                                        currentUser = d; // Set the current user
                                        break;
                                    }
                                }

                                if (isLoggedInDosen) {
                                    System.out.println("Login berhasil sebagai Dosen!");
                                    aksi(scanner, databaseBuku, databaseCD, databaseTransaksi);
                                } else {
                                    System.out.println("Login gagal. Periksa kembali Username dan Password.");
                                }
                                break;
                            case 2:
                                // Login Mahasiswa
                                new mahasiswa().displayMahasiswaDetails(databaseMahasiswa);
                                System.out.print("Masukkan Username: ");
                                String inputUsernameMhs = scanner.nextLine();
                                System.out.print("Masukkan Password: ");
                                String inputPasswordMhs = scanner.nextLine();

                                boolean isLoggedInMhs = false;
                                for (mahasiswa m : databaseMahasiswa) {
                                    if (m.getUsername().equals(inputUsernameMhs) && m.getPassword().equals(inputPasswordMhs)) {
                                        isLoggedInMhs = true;
                                        currentUser = m; // Set the current user
                                        break;
                                    }
                                }

                                if (isLoggedInMhs) {
                                    System.out.println("Login berhasil sebagai Mahasiswa!");
                                    aksi(scanner, databaseBuku, databaseCD, databaseTransaksi);
                                } else {
                                    System.out.println("Login gagal. Periksa kembali Username dan Password.");
                                }
                                break;
                            case 3:
                                // Login Pustakawan
                                new pustakawan().displayPustakawanDetails(databasePustakawan);
                                System.out.print("Masukkan Username: ");
                                String inputUsernameLibrarian = scanner.nextLine();
                                System.out.print("Masukkan Password: ");
                                String inputPasswordLibrarian = scanner.nextLine();

                                boolean isLoggedInLibrarian = false;
                                for (pustakawan p : databasePustakawan) {
                                    if (p.getUsername().equals(inputUsernameLibrarian) && p.getPassword().equals(inputPasswordLibrarian)) {
                                        isLoggedInLibrarian = true;
                                        currentUser = p; // Set the current user
                                        break;
                                    }
                                }

                                if (isLoggedInLibrarian) {
                                    System.out.println("Login berhasil sebagai Pustakawan!");
                                    boolean continueLibrarianActions = true;
                                    while (continueLibrarianActions) {
                                        System.out.println("=== Pilih Aksi Pustakawan ===");
                                        System.out.println("1. Tambah Buku");
                                        System.out.println("2. Tambah CD");
                                        System.out.println("3. Tampilkan Detail Mahasiswa");
                                        System.out.println("4. Tampilkan Detail Dosen");
                                        System.out.println("5. Tampilkan Detail Buku");
                                        System.out.println("6. Tampilkan Detail CD");
                                        System.out.println("7. Tampilkan Detail Pustakawan");
                                        System.out.println("8. Tampilakan Detail Transaksi");
                                        System.out.println("9. Kembali ke Menu Utama");
                                        System.out.print("Masukkan pilihan: ");
                                        int librarianChoice = scanner.nextInt();
                                        scanner.nextLine(); 

                                        switch (librarianChoice) {
                                            case 1:
                                                // Tambah Buku
                                                System.out.print("Masukkan Judul Buku: ");
                                                String judul = scanner.nextLine();
                                                System.out.print("Masukkan Tahun Terbit: ");
                                                int tahunTerbit = scanner.nextInt();
                                                scanner.nextLine(); 
                                                System.out.print("Masukkan Kategori: ");
                                                String kategori = scanner.nextLine();
                                                System.out.print("Masukkan ISBN: ");
                                                String isbn = scanner.nextLine().toUpperCase();
                                                buku newBuku = new buku(judul, tahunTerbit, kategori, isbn);
                                                databaseBuku.add(newBuku);
                                                System.out.println("Buku baru telah ditambahkan.");
                                                break;
                                            case 2:
                                                // Tambah CD
                                                System.out.print("Masukkan Judul CD: ");
                                                String judulCD = scanner.nextLine();
                                                System.out.print("Masukkan Tahun Terbit: ");
                                                int tahunTerbitCD = scanner.nextInt();
                                                scanner.nextLine();
                                                System.out.print("Masukkan Kategori: ");
                                                String kategoriCD = scanner.nextLine();
                                                System.out.print("Masukkan ID CD: ");
                                                int idCD = scanner.nextInt();
                                                scanner.nextLine();
                                                cd newCD = new cd(judulCD, tahunTerbitCD, kategoriCD, idCD);
                                                databaseCD.add(newCD);
                                                System.out.println("CD baru telah ditambahkan.");
                                                break;
                                            case 3:
                                                // Tampilkan Detail Mahasiswa
                                                new mahasiswa().displayMahasiswaDetails(databaseMahasiswa);
                                                break;
                                            case 4:
                                                // Tampilkan Detail Dosen
                                                new dosen().displayDosenDetails(databaseDosen);
                                                break;
                                            case 5:
                                                // Tampilkan Detail Buku
                                                new buku().displayBukuDetails(databaseBuku);
                                                break;
                                            case 6:
                                                // Tampilkan Detail CD
                                                new cd().displayCDDetails(databaseCD);
                                                break;
                                            case 7:
                                                new pustakawan().displayPustakawanDetails(databasePustakawan);
                                                break;
                                            case 8:
                                                new transaksi().displayTransaksiDetails(databaseTransaksi);
                                                break;
                                            case 9:
                                                continueLibrarianActions = false;
                                                break;
                                            default:
                                                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                                                break;
                                        }
                                    }
                                } else {
                                    System.out.println("Login gagal. Periksa kembali Username dan Password.");
                                }
                                break;
                            default:
                                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                                break;
                        }
                        break;
                    case 3:
                        running = false;
                        System.out.println("Keluar dari program...");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // clear scanner buffer
            }
        }
        scanner.close();
    }

    // Variabel global untuk menyimpan pengguna yang sedang login
    private static Object currentUser;

    // Metode untuk mendapatkan NIK atau NIM dari pengguna yang sedang login
    private static String getCurrentUserNikOrNim() {
        if (currentUser instanceof mahasiswa) {
            return ((mahasiswa) currentUser).getNim();
        } else if (currentUser instanceof dosen) {
            return ((dosen) currentUser).getNik();
        } else {
            return null; 
        }
    }

    private static void aksi(Scanner scanner, ArrayList<buku> databaseBuku, ArrayList<cd> databaseCD, ArrayList<transaksi> databaseTransaksi) {
        boolean continueActions = true;
        while (continueActions) {
            try {
                System.out.println("=== Pilih Aksi ===");
                System.out.println("1. Pinjam Buku");
                System.out.println("2. Kembalikan Buku");
                System.out.println("3. Pinjam CD");
                System.out.println("4. Kembalikan CD");
                System.out.println("5. Print Data Transaksi");
                System.out.println("6. Kembali ke Menu Utama");
                System.out.print("Masukkan pilihan: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        // Pinjam Buku
                        buku buku = new buku();
                        buku.displayBukuDetails(databaseBuku);
                        System.out.print("Masukkan ISBN buku yang ingin dipinjam: ");
                        String isbn = scanner.nextLine().toUpperCase();
                        buku foundBuku = databaseBuku.stream()
                            .filter(b -> b.getIsbn().equals(isbn))
                            .findFirst()
                            .orElse(null);
                        if (foundBuku != null) {
                            String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                            String activeUserNikOrNim = getCurrentUserNikOrNim(); // Get the currently logged-in user's NIK or NIM
                            transaksi newTransaksi = new transaksi(databaseTransaksi.size() + 1, activeUserNikOrNim, foundBuku, null, currentDate, null);
                            databaseTransaksi.add(newTransaksi);
                            System.out.println("Buku berhasil dipinjam dengan No Transaksi: " + newTransaksi.getIdTransaksi());
                        } else {
                            System.out.println("Buku tidak ditemukan.");
                        }
                        break;
                    case 2:
                        // Kembalikan Buku
                        System.out.print("Masukkan ID Transaksi pengembalian: ");
                        int idTransaksiKembali = scanner.nextInt();
                        transaksi foundTransaksiKembali = databaseTransaksi.stream()
                            .filter(t -> t.getIdTransaksi() == idTransaksiKembali && t.getIsbnBuku() != null && t.getTanggalKembali() == null)
                            .findFirst()
                            .orElse(null);
                        if (foundTransaksiKembali != null && foundTransaksiKembali.getNimOrNikPeminjam().equals(getCurrentUserNikOrNim())) {
                            String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                            foundTransaksiKembali.setTanggalKembali(currentDate);
                            System.out.println("Buku berhasil dikembalikan.");
                        } else {
                            System.out.println("Transaksi pengembalian buku tidak ditemukan atau buku sudah dikembalikan atau Anda tidak memiliki hak untuk mengembalikan buku ini.");
                        }
                        break;
                    case 3:
                        // Pinjam CD
                        cd cd = new cd();
                        cd.displayCDDetails(databaseCD);
                        System.out.print("Masukkan ID CD yang ingin dipinjam: ");
                        int idCD = scanner.nextInt();
                        cd foundCD = databaseCD.stream()
                            .filter(c -> c.getIdCD() == idCD)
                            .findFirst()
                            .orElse(null);
                        if (foundCD != null) {
                            String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                            String activeUserNikOrNim = getCurrentUserNikOrNim(); // Get the currently logged-in user's NIK or NIM
                            transaksi newTransaksiCD = new transaksi(databaseTransaksi.size() + 1, activeUserNikOrNim, null, foundCD, currentDate, null);
                            databaseTransaksi.add(newTransaksiCD);
                            System.out.println("CD berhasil dipinjam dengan No Transaksi: " + newTransaksiCD.getIdTransaksi());
                        } else {
                            System.out.println("CD tidak ditemukan.");
                        }
                        break;
                    case 4:
                        // Kembalikan CD
                        System.out.print("Masukkan ID Transaksi pengembalian CD: ");
                        int idTransaksiCDKembali = scanner.nextInt();
                        transaksi foundTransaksiCDKembali = databaseTransaksi.stream()
                            .filter(t -> t.getIdTransaksi() == idTransaksiCDKembali && t.getICd() != null && t.getTanggalKembali() == null)
                            .findFirst()
                            .orElse(null);
                        if (foundTransaksiCDKembali != null && foundTransaksiCDKembali.getNimOrNikPeminjam().equals(getCurrentUserNikOrNim())) {
                            String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                            foundTransaksiCDKembali.setTanggalKembali(currentDate);
                            System.out.println("CD berhasil dikembalikan.");
                        } else {
                            System.out.println("Transaksi pengembalian CD tidak ditemukan atau CD sudah dikembalikan atau Anda tidak memiliki hak untuk mengembalikan CD ini.");
                        }
                        break;
                    case 5:
                        transaksi transaksi = new transaksi();
                        // Print Data Transaksi dalam bentuk tabel
                        if (databaseTransaksi.isEmpty()) {
                            System.out.println("Tidak ada transaksi yang tersimpan.");
                        } else {
                            transaksi.displayTransaksiDetails(databaseTransaksi);                            
                        }
                        break;
                    case 6:
                        continueActions = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred during action selection: " + e.getMessage());
                scanner.nextLine(); // clear scanner buffer
            }
        }
    }
}


