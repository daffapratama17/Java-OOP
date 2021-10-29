import java.util.ArrayList;

public class Sistem{
    private Admin admin;
    private ArrayList<Player> players;
    private ArrayList<Organizer> organizers;
    private ArrayList<Event> events;

    public Sistem(){
        admin = new Admin();
        players = new ArrayList<Player>();
        organizers = new ArrayList<Organizer>();
        events = new ArrayList<Event>();
    }

    /* Kuasa Admin */
    public void addPengumuman(String Pengumuman){
        admin.setPengumuman(Pengumuman);
    }

    public void showPengumuman(){
        System.out.println(admin.getPengumuman());
    }

    public String getUserLogin(String ID, String Password){
        if(admin.getID().equals(ID) && admin.getPassword().equals(Password)){
            return "Admin";
        }

        for(Player p : players){
            if(p.getID().equals(ID) && p.getPassword().equals(Password)){
                return "Player";
            }
        }

        for(Organizer o : organizers){
            if(o.getID().equals(ID) && o.getPassword().equals(Password)){
                return "Organizer";
            }
        }

        return "Salah";
    }

    public boolean ValidasiLogin(String ID, String Password){
        for(Player p : players){
            if(p.getID().equals(ID) && p.getPassword().equals(Password)){
                return p.getAktif();
            }
        }

        for(Organizer o : organizers){
            if(o.getID().equals(ID) && o.getPassword().equals(Password)){
                return o.getAktif();
            }
        }

        return false;
    }

    public void LihatDaftarAkun(){
        int i = 0;

        System.out.println("Daftar Akun Player");
        if(players.size() == 0){
            System.out.println("-\n");
        }else{
            for(Player p : players){
                i += 1;
                System.out.println(i+". ID : "+p.getID()+" | Password : "+p.getPassword()+" | Nama Player : "+p.getNama()+" | Status Aktif : "+(p.getAktif() ? "Aktif" : "Tidak Aktif"));
            }
            System.out.print("\n");
        }

        System.out.println("Daftar Akun Organizer");
        i = 0;
        if(organizers.size() == 0){
            System.out.println("-\n");
        }else{
            for(Organizer o : organizers){
                i += 1;
                System.out.println(i+". ID : "+o.getID()+" | Password : "+o.getPassword()+" | Aktif : "+(o.getAktif() ? "Aktif" : "Tidak Aktif"));
            }
            System.out.print("\n");
        }
    }

    public void AktivasiAkun(String ID, String Jenis, boolean Aktif){
        /* Membuka Akses Login atau Block Akun */
        if(Jenis.equals("Pemain")){
            for(Player p : players){
                if(p.getID().equals(ID)){
                    p.setAktif(Aktif);
                    System.out.println("Aktivasi Akun Pemain Berhasil Diubah\n");
                    break;
                }
            }   
        }else if(Jenis.equals("Organizer")){
            for(Organizer o : organizers){
                if(o.getID().equals(ID)){
                    o.setAktif(Aktif);
                    System.out.println("Aktivasi Akun Organizer Berhasil Diubah\n");
                    break;
                }
            }   
        }
        System.out.print("\n");
    }

    /* End of Kuasa Admin */

    /* Kuasa Organizer */

    public void addOrganizer(Organizer organizer){
        organizers.add(organizer);
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public void OrganizerLihatEvent(String ID){
        System.out.println("Daftar Event Yang Dibuat : ");
        int i = 0;
        for(Event e : events){
            if(e.getOrganizer().getID().equals(ID)){
                i += 1;
                System.out.println("Nomor Acara "+i);
                System.out.println(e.toString()+"\n");
            }
        }

        if(i == 0){
            System.out.println("Belum Ada Event Yang Dibuat\n");
        }
    }

    public void OrganizerUbahStatusEvent(String ID, int Nomor, boolean Status){
        int i = 0;
        boolean ketemu = false;
        for(Event e : events){
            if(e.getOrganizer().getID().equals(ID)){
                i += 1;
                if(i == Nomor){
                    if(Status && e.getJumlahPeserta() >= e.getJumlahMinimum()){
                        e.setStatus(Status);
                        System.out.println("Acara Berhasil DiAktivkan\n");
                    }else if(!Status){
                        e.setStatus(Status);
                        System.out.println("Acara Berhasil DiBlok!\n");
                    }else{
                        System.out.println("Jumlah Peserta Tidak Memenuhi Syarat Jumlah Minimum, Tidak Dapat DiAktivkan\n");
                    }
                    ketemu = true;
                    break;
                }
            }
        }

        if(ketemu){
            System.out.println("Status Berhasil Diubah");
        }else{
            System.out.println("Status Gagal Diubah");
        }
    }

    public Organizer getOrganizers(String ID){
        for(Organizer o : organizers){
            if(o.getID().equals(ID)){
                return o;
            }
        }
        return null;
    }

    /* End of Kuasa Organizer */

    /* Kuasa Player */

    public void addPlayer(Player player){
        players.add(player);
    }

    public void LihatSemuaEvent(){
        int i = 0;
        for(Event e : events){
            i += 1;
            System.out.println("Event Nomor "+i);
            System.out.println(e.toString()+"\n");
        }
    }

    public void DaftarEvent(String ID, int Nomor){
        Player player = new Player();
        for(Player p : players){
            if(p.getID().equals(ID)){
                p.setJumlahPertandingan(p.getJumlahPertandingan()+1);
                player = p;
            }
        }

        int i = 0;
        for(Event e : events){
            i += 1;
            if(i == Nomor){
                e.addPeserta(player);
                System.out.println("Player "+player.getNama()+" Berhasil Mendaftar Pada Event "+e.getJenis());
            }
        }
    }

    public void PlayerLihatDaftarEvent(String ID){
        int i = 0;
        for(Event e : events){
            Player peserta[] = e.getPeserta();
            for(int j=0; j<e.getJumlahPeserta(); j++){
                if(peserta[j].getID().equals(ID)){
                    i += 1;
                    System.out.println("Event Nomor "+i+" : ");
                    System.out.println(e.toString());
                    break;
                }
            }
        }
    }

    public void KurangiJumlahPertandinganPlayer(String ID){
        for(Player p : players){
            if(p.getID().equals(ID)){
                p.setJumlahPertandingan(p.getJumlahPertandingan()-1);
            }
        }
    }

    public void BatalkanEvent(String ID, int Nomor){
        int i = 0;
        int positionPlayer = 0;
        for(Event e : events){
            Player peserta[] = e.getPeserta();
            for(int j=0; j<e.getJumlahPeserta(); j++){
                if(peserta[j].getID().equals(ID)){
                    i += 1;
                    positionPlayer = j;
                    KurangiJumlahPertandinganPlayer(ID);
                    break;
                }
            }

            if(i == Nomor){
                for(int j=positionPlayer; j<e.getJumlahPeserta()-1; j++){
                    peserta[j] = peserta[j+1];
                }
                e.setPeserta(peserta);
                e.setJumlahPeserta(e.getJumlahPeserta()-1);
                System.out.println("Acara Berhasil Dibatalkan\n");
            }
        }
    }

    public void addLencana(String ID, String Lencana){
        for(Player p : players){
            if(p.getID().equals(ID)){
                if(Lencana.equals("Friendly")){
                    p.setLencanaFriendly(p.getLencanaFriendly()+1);
                }else if(Lencana.equals("Team Work")){
                    p.setLencanaTeamWork(p.getLencanaTeamWork()+1);
                }else{
                    p.setLencanaGreatPerformer(p.getLencanaGreatPerformer()+1);
                }
            }
        }
    }

    public void LihatDaftarPemain(String ID){
        /* Tampilkan Daftar Pemain Selain Dirinya */
        for(Player p : players){
            if(p.getID().equals(ID)){
                continue;
            }else{
                System.out.println("ID : "+p.getID()+" | Nama : "+p.getNama());
            }
        }
    }

    public String getTanggalEvent(String IDPlayer, int NomorEvent){
        int i = 0;
        for(Event e : events){
            Player peserta[] = e.getPeserta();
            for(int j=0; j<e.getJumlahPeserta(); j++){
                if(peserta[j].getID().equals(IDPlayer)){
                    i += 1;
                    break;
                }
            }

            if(NomorEvent == i){
                return e.getTanggal();
            }
        }
        return "";
    }

    public void LihatDetailPemain(String ID){
        boolean ketemu = false;
        for(Player p : players){
            if(p.getID().equals(ID)){
                System.out.println(p.toString()+"\n");
                ketemu = true;
                break;
            }
        }

        if(!ketemu){
            System.out.println("Pemain Tidak Ditemukan!\n");
        }
    }

    /* End of Kuasa Player */

    public Admin getAdmin(){
        return this.admin;
    }

    public void setAdmin(Admin admin){
        this.admin = admin;
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public void setPlayers(ArrayList<Player> players){
        this.players = players;
    }

    public ArrayList<Organizer> getOrganizers(){
        return this.organizers;
    }

    public void setOrganizers(ArrayList<Organizer> organizers){
        this.organizers = organizers;
    }

    public ArrayList<Event> getEvents(){
        return this.events;
    }

    public void setEvents(ArrayList<Event> events){
        this.events = events;
    }
}
