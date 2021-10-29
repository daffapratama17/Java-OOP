import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args){
        Sistem sistem = new Sistem();
        Scanner daffa = new Scanner(System.in);

        int pilihan;

        do{
            System.out.println("Selamat Datang di Social Media Olahraga");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan : ");

            try{
                pilihan = daffa.nextInt();
            }catch(InputMismatchException e){
                pilihan = -1;
                daffa.nextLine();
            }

            if(pilihan == 1){
                String ID, Password;
                
                daffa.nextLine();
                System.out.println("\nLogin ke Sistem");
                System.out.print("ID : ");
                ID = daffa.nextLine();
                System.out.print("Password : ");
                Password = daffa.nextLine();
                
                String Hasil = sistem.getUserLogin(ID, Password);
                
                if(Hasil.equals("Admin")){
                    int PilihanAdmin;
                    System.out.print("\n");
                    do{
                        System.out.println("Menu Admin");
                        System.out.println("1. Buat Pengumuman");
                        System.out.println("2. Lihat Daftar Akun");
                        System.out.println("3. Management Aktivasi Akun");
                        System.out.println("4. Keluar Admin");
                        System.out.print("Masukkan Pilihan : ");

                        try{
                            PilihanAdmin = daffa.nextInt();
                        }catch(InputMismatchException ex){
                            PilihanAdmin = -1;
                            daffa.nextLine();
                        }

                        if(PilihanAdmin == 1){
                            System.out.println("Buat Pengumuman");
                            System.out.println("Masukkan Pengumuman : ");
                            daffa.nextLine();
                            sistem.addPengumuman(daffa.nextLine());
                        }else if(PilihanAdmin == 2){
                            System.out.println("Lihat Daftar Akun");
                            sistem.LihatDaftarAkun();
                            System.out.print("\n");
                        }else if(PilihanAdmin == 3){
                            String IDUbah, Jenis, Aktiv;

                            daffa.nextLine();
                            System.out.println("Management Aktivasi Akun");
                            sistem.LihatDaftarAkun();

                            System.out.print("\nMasukkan ID yang akan diubah : ");
                            IDUbah = daffa.nextLine();
                            System.out.print("Masukkan Jenis Role User (Pemain/Organizer) yang akan diubah : ");
                            Jenis = daffa.nextLine();
                            System.out.print("Masukkan Jenis Aktivasi User (Aktiv/Blok) : ");
                            Aktiv = daffa.nextLine();

                            sistem.AktivasiAkun(IDUbah, Jenis, Aktiv.equalsIgnoreCase("Aktiv") ? true : false);
                        }else if(PilihanAdmin < 1 || PilihanAdmin > 4){
                            System.out.println("Pilihan Admin Salah\n");
                        }
                    }while(PilihanAdmin != 4);
                    System.out.print("\n");
                }else if(Hasil.equals("Player")){
                    boolean valid = sistem.ValidasiLogin(ID, Password);

                    if(!valid){
                        System.out.println("Akun Dibekukan atau Belum Divalidasi oleh Admin!\n");
                    }else{
                        int PilihanPemain;
                        System.out.print("\n");

                        do{
                            System.out.println("Pengumuman Admin");
                            sistem.showPengumuman();
                            System.out.println("\nMenu Pemain");
                            System.out.println("1. Lihat Daftar Acara Olahraga");
                            System.out.println("2. Ikut Acara Olahraga");
                            System.out.println("3. Batal Ikut Acara Olahraga");
                            System.out.println("4. Berikan Lencana Kepada Pemain Lain");
                            System.out.println("5. Lihat Profile");
                            System.out.println("6. Keluar");
                            System.out.print("Masukkan Pilihan : ");
                            PilihanPemain = daffa.nextInt();

                            if(PilihanPemain == 1){
                                System.out.println("Daftar Acara Olahraga Yang Tersedia");
                                sistem.LihatSemuaEvent();
                                System.out.print("\n");
                            }else if(PilihanPemain == 2){
                                int Nomor;
                                System.out.println("Ikut Acara Olahraga");
                                sistem.LihatSemuaEvent();
                                System.out.print("Masukkan Nomor Acara Yang Akan Diikut Sertakan : ");
                                Nomor = daffa.nextInt();
                                sistem.DaftarEvent(ID, Nomor);
                                System.out.print("\n");
                            }else if(PilihanPemain == 3){
                                String currentDate = java.time.LocalDate.now().toString();
                                int Nomor;
                                System.out.println("Batal Ikut Acara Olahraga");
                                sistem.PlayerLihatDaftarEvent(ID);
                                System.out.print("Masukkan Nomor Acara Yang Akan Dibatalkan : ");
                                Nomor = daffa.nextInt();
                                String eventDate = sistem.getTanggalEvent(ID, Nomor);

                                LocalDate dateNow = LocalDate.parse(currentDate);
                                LocalDate event = LocalDate.parse(eventDate);

                                int NumberDate = (int) ChronoUnit.DAYS.between(dateNow, event);
                                
                                if(NumberDate < 1){
                                    System.out.println("Tidak Dapat Membatalkan Acara!");
                                }else{
                                    sistem.BatalkanEvent(ID, Nomor);
                                }
                            }else if(PilihanPemain == 4){
                                String IDLain;

                                daffa.nextLine();
                                System.out.println("Berikan Lencana Kepada Pemain Lain");
                                sistem.LihatDaftarPemain(ID);

                                System.out.print("Masukkan ID Pemain Yang Akan Diberi Lencana : ");
                                IDLain = daffa.nextLine();

                                System.out.println("1. Lencana Friendly");
                                System.out.println("2. Lencana Team Work");
                                System.out.println("3. Lencana Great Performer");

                                int Lencana;
                                do{
                                    System.out.print("Masukkan Nomor Lencana : ");
                                    Lencana = daffa.nextInt();
                                }while(Lencana < 1 || Lencana > 3);

                                String LencanaStr;
                                if(Lencana == 1){
                                    LencanaStr = "Friendly";
                                }else if(Lencana == 2){
                                    LencanaStr = "Team Work";
                                }else{
                                    LencanaStr = "Great Performer";
                                }

                                sistem.addLencana(IDLain, LencanaStr);
                            }else if(PilihanPemain == 5){
                                System.out.println("Profile Pemain");
                                sistem.LihatDetailPemain(ID);
                                System.out.print("\n");
                            }else if(PilihanPemain < 1 || PilihanPemain > 6){
                                System.out.println("Menu Tidak Valid!\n");
                            }
                        }while(PilihanPemain != 6);
                        System.out.print("\n");
                    }
                }else if(Hasil.equals("Organizer")){
                    boolean valid = sistem.ValidasiLogin(ID, Password);

                    if(!valid){
                        System.out.println("Akun Dibekukan atau Belum Divalidasi oleh Admin!\n");
                    }else{
                        int PilihanOrganizer;
                        do{
                            System.out.println("Pengumuman Admin");
                            sistem.showPengumuman();
                            System.out.println("1. Lihat Daftar Acara Yang Telah Dibuat");
                            System.out.println("2. Tambah Acara");
                            System.out.println("3. Ubah Status Acara");
                            System.out.println("4. Keluar");

                            System.out.print("Masukkan Pilihan : ");
                            PilihanOrganizer = daffa.nextInt();

                            if(PilihanOrganizer == 1){
                                System.out.println("Daftar Acara Yang Telah Dibuat");
                                sistem.OrganizerLihatEvent(ID);
                                System.out.print("\n");
                            }else if(PilihanOrganizer == 2){
                                System.out.println("Menambahkan Acara Baru");
                                
                                String Jenis, Tanggal, Tempat;
                                int Level, Minimum, Maksimum, Biaya;
                                Organizer org = sistem.getOrganizers(ID);

                                daffa.nextLine();

                                System.out.print("Masukkan Jenis Olahraga (Gym/Renang/Badminton/Tenis) : ");
                                Jenis = daffa.nextLine();
                                System.out.print("Masukkan Tanggal Pelaksanaan (YYYY-MM-DD) : ");
                                Tanggal = daffa.nextLine();
                                System.out.print("Masukkan Tempat Pelaksanaan : ");
                                Tempat = daffa.nextLine();
                                System.out.print("Masukkan Level Acara (1. Beginner/2. Intermediate/3. Advanced) : ");
                                Level = daffa.nextInt();
                                System.out.print("Masukkan Jumlah Minimum Pemain : ");
                                Minimum = daffa.nextInt();
                                System.out.print("Masukkan Jumlah Maksimum Pemain : ");
                                Maksimum = daffa.nextInt();
                                System.out.print("Masukkan Biaya : ");
                                Biaya = daffa.nextInt();

                                Event baru = new Event(Maksimum, org);
                                baru.setJenis(Jenis);
                                baru.setTanggal(Tanggal);
                                baru.setTempat(Tempat);
                                baru.setLevel(Level);
                                baru.setJumlahMinimum(Minimum);
                                baru.setJumlahMaksimum(Maksimum);
                                baru.setBiaya(Biaya);

                                sistem.addEvent(baru);
                                System.out.print("\n");
                            }else if(PilihanOrganizer == 3){
                                int Nomor, Aktiv;
                                
                                System.out.println("Ubah Status Acara");
                                sistem.OrganizerLihatEvent(ID);

                                System.out.print("Masukkan Nomor Acara Yang Akan Diubah : ");
                                Nomor = daffa.nextInt();
                                System.out.print("Masukkan Nomor Status (1. Aktiv/2. Batal) : ");
                                Aktiv = daffa.nextInt();

                                sistem.OrganizerUbahStatusEvent(ID, Nomor, Aktiv == 1 ? true : false);

                                System.out.print("\n");
                            }else if(PilihanOrganizer < 1 || PilihanOrganizer > 4){
                                System.out.println("Menu Tidak Valid!\n");
                            }
                        }while(PilihanOrganizer != 4);
                        System.out.print("\n");
                    }
                }else{
                    System.out.println("ID atau Password Salah!\n");
                }
            }else if(pilihan == 2){
                int PilihanRegister;

                System.out.println("1. Register Pemain");
                System.out.println("2. Register Organizer");
                System.out.print("Masukkan Pilihan : ");
                
                try{
                    PilihanRegister = daffa.nextInt();
                    String ID, Password, Nama = "";
                    daffa.nextLine();
                    if(PilihanRegister == 1){
                        System.out.println("Registrasi Pemain");
                        
                        boolean NamaValid = false;
                        do{
                            try{
                                System.out.print("Nama : ");
                                Nama = daffa.nextLine();
                                int temp = Integer.parseInt(Nama);
                                System.out.println("Nama Tidak Boleh Berupa Angka!");
                            }catch(NumberFormatException ex){
                                NamaValid = true;
                            }
                        }while(!NamaValid);
                        
                        System.out.print("ID : ");
                        ID = daffa.nextLine();
                        System.out.print("Password : ");
                        Password = daffa.nextLine();

                        Player pemain = new Player();
                        pemain.setID(ID);
                        pemain.setPassword(Password);
                        pemain.setNama(Nama);

                        sistem.addPlayer(pemain);
                        System.out.print("\n");
                    }else if(PilihanRegister == 2){
                        System.out.println("Registrasi Organizer");
                        System.out.print("Nama : ");
                        Nama = daffa.nextLine();
                        System.out.print("ID : ");
                        ID = daffa.nextLine();
                        System.out.print("Password : ");
                        Password = daffa.nextLine();

                        Organizer organizer = new Organizer();
                        organizer.setID(ID);
                        organizer.setPassword(Password);
                        organizer.setNama(Nama);

                        sistem.addOrganizer(organizer);
                        System.out.print("\n");
                    }else{
                        System.out.println("Pilihan Salah\n");
                    }
                }catch(InputMismatchException e){
                    System.out.println("Pilihan Salah!\n");
                    daffa.nextLine();
                }
            }else if(pilihan < 1 || pilihan > 3){
                System.out.println("Menu Tidak Valid!\n");
            }
        }while(pilihan != 3);
    }
}
