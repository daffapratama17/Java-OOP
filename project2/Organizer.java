public class Organizer extends User{
    private String Nama;
    private boolean Aktif;

    public Organizer(){
        Aktif = false;
    }

    public void setNama(String Nama){
        this.Nama = Nama;
    }

    public String getNama(){
        return Nama;
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
        return "ID Organizer : "+ID+
        "\nPassword Organizer : "+Password+
        "\nStatus Organizer : "+(Aktif ? "Aktif" : "Tidak Aktif");
    }
}
