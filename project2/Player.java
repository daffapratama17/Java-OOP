public class Player extends User{
    private String Nama;
    private int LencanaFriendly;
    private int LencanaTeamWork;
    private int LencanaGreatPerformer;
    private int Level;
    private int JumlahPertandingan;
    private boolean Aktif;

    public Player(){
        LencanaFriendly = 0;
        LencanaTeamWork = 0;
        LencanaGreatPerformer = 0;
        JumlahPertandingan = 0;
        Level = 1;
        Aktif = false;
    }

    public void setNama(String Nama){
        this.Nama = Nama;
    }

    public String getNama(){
        return Nama;
    }

    public void setLencanaFriendly(int LencanaFriendly){
        this.LencanaFriendly = LencanaFriendly;
    }

    public int getLencanaFriendly(){
        return LencanaFriendly;
    }

    public void setLencanaTeamWork(int LencanaTeamWork){
        this.LencanaTeamWork = LencanaTeamWork;
    }

    public int getLencanaTeamWork(){
        return LencanaTeamWork;
    }

    public void setLencanaGreatPerformer(int LencanaGreatPerformer){
        this.LencanaGreatPerformer = LencanaGreatPerformer;
    }

    public int getLencanaGreatPerformer(){
        return LencanaGreatPerformer;
    }

    public void setLevel(int Level){
        this.Level = Level;
    }

    public int getLevel(){
        return Level;
    }

    public void setJumlahPertandingan(int JumlahPertandingan){
        this.JumlahPertandingan = JumlahPertandingan;
        if(JumlahPertandingan > 5){
            Level = 2;
        }else if(JumlahPertandingan > 10){
            Level = 3;
        }
    }

    public int getJumlahPertandingan(){
        return JumlahPertandingan;
    }

    public void setAktif(boolean Aktif){
        this.Aktif = Aktif;
    }

    public boolean getAktif(){
        return Aktif;
    }

    @Override
    void setID(String ID){
        this.ID = ID;
    }

    @Override
    String getID(){
        return ID;
    }

    @Override
    void setPassword(String Password){
        this.Password = Password;
    }

    @Override
    String getPassword(){
        return Password;
    }

    @Override
    public String toString(){
        return "ID Player : "+ID+
        "\nPassword Player : "+Password+
        "\nNama Player :"+Nama+
        "\nJumlah Lencana Friendy : "+LencanaFriendly+
        "\nJumlah Lencana Team Work : "+LencanaTeamWork+
        "\nJumlah Lencana Great Performer : "+LencanaGreatPerformer+
        "\nLevel Player : "+(Level == 1 ? "Beginner" : Level == 2 ? "intermediate" : "Advanced")+
        "\nStatus Aktif : "+(Aktif ? "Aktif" : "Tidak Aktif");
    }
}
