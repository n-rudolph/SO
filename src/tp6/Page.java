package tp6;

public class Page {

    public int id;
    public int size;

    public boolean reference;
    public boolean modified;

    public Page(int id, int size){
        this.id=id;
        this.size=size;
        reference= false;
        modified = false;
    }
}
