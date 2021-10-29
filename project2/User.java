public abstract class User{
    String ID;
    String Password;

    abstract void setID(String ID);
    abstract String getID();
    abstract void setPassword(String Password);
    abstract String getPassword();
    @Override
    public abstract String toString();
}