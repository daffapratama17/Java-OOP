public class Event{
    private String Jenis;
    private int Level;
    private String Tanggal;
    private String Tempat;
    private int JumlahMinimum;
    private int JumlahMaksimum;
    private int JumlahPeserta;
    private Player Peserta[];
    private int Biaya;
    private boolean Status;
    private Organizer organizer;

    public Event(int JumlahMaksimum, Organizer organizer){
        JumlahPeserta = 0;
        Status = false;
        Peserta = new Player[JumlahMaksimum];
        this.organizer = organizer;
    }

    public void addPeserta(Player player){
        try{
            Peserta[JumlahPeserta] = player;
            JumlahPeserta += 1;
            System.out.println("Player "+player.getNama()+" Berhasil Didaftarkan");
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Jumlah Peserta Sudah Mencapai Maksimum, Tidak Bisa Mendaftar Lagi!");
        }
    }

    public void setPeserta(Player[] Peserta){
        this.Peserta = Peserta;
    }

    public Player[] getPeserta(){
        return Peserta;
    }

    public void setJumlahPeserta(int JumlahPeserta){
        this.JumlahPeserta = JumlahPeserta;
    }

    public int getJumlahPeserta(){
        return JumlahPeserta;
    }

    public String getJenis(){
        return this.Jenis;
    }

    public void setJenis(String Jenis){
        this.Jenis = Jenis;
    }

    public int getLevel(){
        return this.Level;
    }

    public void setLevel(int Level){
        this.Level = Level;
    }

    public String getTanggal(){
        return this.Tanggal;
    }

    public void setTanggal(String Tanggal){
        this.Tanggal = Tanggal;
    }

    public String getTempat(){
        return this.Tempat;
    }

    public void setTempat(String Tempat){
        this.Tempat = Tempat;
    }

    public int getJumlahMinimum(){
        return this.JumlahMinimum;
    }

    public void setJumlahMinimum(int JumlahMinimum){
        this.JumlahMinimum = JumlahMinimum;
    }

    public int getJumlahMaksimum(){
        return this.JumlahMaksimum;
    }

    public void setJumlahMaksimum(int JumlahMaksimum){
        this.JumlahMaksimum = JumlahMaksimum;
    }

    public int getBiaya(){
        return this.Biaya;
    }

    public void setBiaya(int Biaya){
        this.Biaya = Biaya;
    }

    public void setOrganizer(Organizer organizer){
        this.organizer = organizer;
    }

    public Organizer getOrganizer(){
        return organizer;
    }

    public void setStatus(boolean Status){
        this.Status = Status;
    }

    public boolean getStatus(){
        return Status;
    }

    public String toString(){
        return 
        "Jenis Olahraga : "+Jenis+
        "\nLevel Olahraga : "+(Level == 1 ? "Beginner" : Level == 2 ? "Intermediate" : "Advanced")+
        "\nTanggal : "+Tanggal+
        "\nTempat : "+Tempat+
        "\nJumlah Minimum : "+JumlahMinimum+
        "\nJumlah Maksimum : "+JumlahMaksimum+
        "\nBiaya : "+Biaya+
        "\nJumlah Peserta Sekarang : "+JumlahPeserta+
        "\nStatus Acara : "+(Status ? "Berjalan" : "Belum Berjalan/Gagal Berjalan");
    }
}
