public class Admin extends User{
    private String Pengumuman; 

    public Admin(){
        this.ID = "Admin";
        this.Password = "Admin";
        Pengumuman = "-";
    }

    public void setPengumuman(String Pengumuman){
        this.Pengumuman = Pengumuman;
    }

    public String getPengumuman(){
        return Pengumuman;
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
        return "ID Admin : "+ID+"\nPassword Admin : "+Password;
    }
}
