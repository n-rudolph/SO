package tp6;


public class Access {

    public Page page;
    public AccessType accessType;

    public Access(Page p, AccessType at){
        page=p;
        accessType=at;
    }

    public enum AccessType{
        READ, WRITE
    }
}
