package tp6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Memory {

    private  Map<Integer, Page> pages;
    public int maxSize;
    public int accessTime;

    public Memory(int maxSize, int accessTime, List<Page> pages){
        this.pages=new HashMap<Integer, Page>(maxSize);
        this.maxSize=maxSize;
        this.accessTime=accessTime;

        for (Page page : pages) this.pages.put(page.id, page);

    }

    public void addPage(Page p){
        pages.put(p.id, p);
    }

    public Page removePAge(int id){
        return pages.remove(id);
    }

    public Page getPage(int id){
        return pages.get(id);
    }
}
