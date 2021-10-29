import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner daffa = new Scanner(System.in);
        ArrayList<Pelanggan> Plgn = new ArrayList<>();
        int choose1;
        int choose2;
        String name, pasword;

        do {
            System.out.println("Halaman awal Aplikasi");
            System.out.println("1.login");
            System.out.println("2.exit");

            System.out.println("choose:");
            choose1 = daffa.nextInt();
        } while (choose1 != 1 && choose1 != 2);
        System.out.println("------------------");
        if (choose1 == 1) {
            daffa.nextLine();
            System.out.println("Username");
            name = daffa.nextLine();
            System.out.println("Password");
            pasword = daffa.nextLine();

        } else {
            System.out.println("exit");
            System.exit(0);
        }

        do {
            System.out.println("------------------");
            System.out.println("Aplikasi perusahaan dua kertas");
            System.out.println("===============================");
            System.out.println("1.Pendataan nilai tukar mata uang");
            System.out.println("2.Pendataan transaksi penukaran asing ke IDR");
            System.out.println("3.Pendataan transaksi penukaran IDR ke asing");
            System.out.println("4.Menampilkan data transaksi penukaran");
            System.out.println("5.Log out");

            System.out.println("choose:");
            choose2 = daffa.nextInt();

            switch (choose2) {
                case 1:
                    datanilaitukar(Plgn);
                    daffa.nextLine();
                    daffa.nextLine();
                    break;
                case 2:
                    menjualrupiah(Plgn);
                    daffa.nextLine();
                    break;
                case 3:
                    membelirupiah(Plgn);
                    daffa.nextLine();
                    break;
                case 4:
                    menampilkan(Plgn);
                    daffa.nextLine();
                    break;


            }


        } while (choose2 != 4);
    }

    private static void datanilaitukar(ArrayList<Pelanggan> Cust) {
        System.out.println("|  Mata uang  |  KursJual  |  KursBeli  |");
        System.out.println("|     AUD     |   11.312   |   11.196   |");
        System.out.println("|     EUR     |   17.637   |   17.458   |");
        System.out.println("|     HKD     |   1.883    |   1.864    |");
        System.out.println("|     THB     |   465      |   460      |");
        System.out.println("|     USD     |   14.620   |   14.475   |");
        System.out.println("sumber : https://www.bi.go.id/id/statistik/informasi-kurs/transaksi-bi/Default.aspx");
        System.out.println("tanggal akses:26 april 2020");
        System.out.println("\n Press enter to go main menu");
    }

    private static void menjualrupiah(ArrayList<Pelanggan> Cust) {

        Scanner daffa = new Scanner(System.in);

        int tukar = 0;
        int dapat = 0;
        String nama, hp, nilai1 = "", nilai2 = "", tanggal;

        daffa.nextLine();
        System.out.println("Input Nama Pelanggan: ");
        nama = daffa.nextLine();
        System.out.println("Input NomorHP pelanggan: ");

        hp = daffa.nextLine();


        nilai1 = "IDR";
        daffa.nextLine();
        do {
            System.out.println("Input mata uang tujuan[AUD|EUR|HKD|THB|USD]: ");
            nilai2 = daffa.nextLine();
        } while (!nilai2.equalsIgnoreCase("AUD") && !nilai2.equalsIgnoreCase("EUR") && !nilai2.equalsIgnoreCase("HKD") && !nilai2.equalsIgnoreCase("THB") && !nilai2.equalsIgnoreCase("USD"));
        do {
            System.out.println("Input " + nilai1 + " yang akan ditukar: ");
            tukar = daffa.nextInt();
        } while (tukar < 0);


        if (nilai2.equalsIgnoreCase("AUD")) {
            dapat = tukar / 11196;
        } else {
            if (nilai2.equalsIgnoreCase("EUR")) {
                dapat = tukar / 17458;
            } else {
                if (nilai2.equalsIgnoreCase("HKD")) {
                    dapat = tukar / 1864;
                } else {
                    if (nilai2.equalsIgnoreCase("THB")) {
                        dapat = tukar / 460;
                    } else {
                        if (nilai2.equalsIgnoreCase("USD")) {
                            dapat = tukar / 14475;
                        }
                    }
                }
            }
        }
        System.out.println("Dapat " + dapat + " " + nilai2.toUpperCase());

        tanggal = LocalDate.now().toString();
        Pelanggan pelanggan = new Pelanggan(nama, hp, nilai1, tukar, nilai2, dapat, tanggal);
        Cust.add(pelanggan);


    }

    private static void membelirupiah(ArrayList<Pelanggan> Cust) {

        Scanner daffa = new Scanner(System.in);
        int tukar = 0;
        int dapat = 0;
        String nama, hp, nilai1 = "", nilai2 = "", tanggal;

        daffa.nextLine();
        System.out.println("Input Nama Pelanggan: ");
        nama = daffa.nextLine();
        System.out.println("Input NomorHP pelanggan: ");
        hp = daffa.nextLine();

        nilai2 = "IDR";
        daffa.nextLine();
        do {
            System.out.println("Input mata uang asal[AUD|EUR|HKD|THB|USD]: ");
            nilai1 = daffa.nextLine();
        } while (!nilai1.equalsIgnoreCase("AUD") && !nilai1.equalsIgnoreCase("EUR") && !nilai1.equalsIgnoreCase("HKD") && !nilai1.equalsIgnoreCase("THB") && !nilai1.equalsIgnoreCase("USD"));
        do {
            System.out.println("Input " + nilai1 + " yang akan ditukar: ");
            tukar = daffa.nextInt();
        } while (tukar < 0);

        if (nilai1.equalsIgnoreCase("AUD")) {
            dapat = tukar * 11312;
        } else {
            if (nilai1.equalsIgnoreCase("EUR")) {
                dapat = tukar * 17637;
            } else {
                if (nilai1.equalsIgnoreCase("HKD")) {
                    dapat = tukar * 1883;
                } else {
                    if (nilai1.equalsIgnoreCase("THB")) {
                        dapat = tukar * 465;
                    } else {
                        if (nilai1.equalsIgnoreCase("USD")) {
                            dapat = tukar * 14620;
                        }
                    }
                }
            }
        }
        System.out.println("Dapat " + dapat + " " + nilai2.toUpperCase());

        tanggal = LocalDate.now().toString();
        Pelanggan pelanggan = new Pelanggan(nama, hp, nilai1, tukar, nilai2, dapat, tanggal);
        Cust.add(pelanggan);


    }

    private static void menampilkan(ArrayList<Pelanggan> Cust) {

        Scanner daffa = new Scanner(System.in);

        if (Cust.size() == 0) {
            System.out.println("Transaksi nihil");
            System.out.println("Press enter to go main menu");
            daffa.nextLine();

        } else {

            System.out.println(" Data Transaksi Penukaran Mata Uang");
            System.out.printf("| %-5s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "No", "Tanggal", "Mata Uang Asal", "Jumlah Mata Uang Asal", "Mata Uang yang Dibeli", "Jumlah Mata Uang Dibeli");
            int i, j;
            for (i = 0; i < Cust.size(); i++) {
                j = i + 1;
                System.out.printf("| %-5s | %-10s | %-15s | %-20s | %-20s | %-20s |\n", j, Cust.get(i).getDate(), Cust.get(i).getuangT(), Cust.get(i).getTukar(), Cust.get(i).getuangD(), Cust.get(i).getDapat());
            }
            daffa.nextLine();
        }

    }


}


class Pelanggan {
    public String nama;
    public String nomorHP;
    public String uang1;
    public String uang2;
    public String date;

    public int tukar;
    public int dapat; //object: variabel dari kelas lain memanggil variabel


    Pelanggan(String nama, String nomorHP, String uang1, int tukar, String uang2, int dapat, String date) {
        this.nama = nama;
        this.nomorHP = nomorHP;
        this.uang1 = uang1;
        this.uang2 = uang2;

        this.dapat = dapat;
        this.tukar = tukar;

        this.date = date;
    }

    String getName() {
        return nama;
    }

    String getnoHp() {
        return nomorHP;
    }

    String getuangT() {
        return uang1;
    }

    String getuangD() {
        return uang2;
    }

    int getDapat() {
        return dapat;
    }

    int getTukar() {
        return tukar;
    }


    String getDate() {
        return date;
    }
}

