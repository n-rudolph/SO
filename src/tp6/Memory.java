package tp6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Memory {

    public  List< Page> pages;
    public int maxSize;
    public int accessTime;

    public Memory(int maxSize, int accessTime, List<Page> pages){
        this.pages=new ArrayList<Page>(maxSize);
        this.maxSize=maxSize;
        this.accessTime=accessTime;

        this.pages=pages;

    }

    public void addPage(Page p){
        pages.add(p);
    }

    public Page removePage(int id){
        Page toRemove = null;
        for (Page page : pages) {
            if (page.id==id)
                toRemove=page;
        }
        if (toRemove!=null) {
            pages.remove(toRemove);
            return toRemove;
        }
        return null;
    }

    public Page getPage(int id){
        if (pages.isEmpty())
            return null;
        for (Page page : pages) {
            if (page.id == id)
                return page;
        }
        return null;
    }
}
