package tp6;


public class Access {

    public Page page;
    public AccessType accessType;
    public int process;

    public Access(Page p, AccessType at, int process){
        page=p;
        accessType=at;
        this.process=process;
    }

    public enum AccessType{
        READ, WRITE
    }
}
