package tp6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rudy on 12/06/16.
 */
public class VirtualMemory {
    public int size;
    public int pageSize;
    public int accessTime;

    private List<Page> pages;

    public VirtualMemory(int size, int pageSize, int accessTime, List<Page> pagesList){
        pages = pagesList;
        this.size=size;
        this.pageSize=pageSize;
        this.accessTime=accessTime;

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

    public Page getPage(int id ){
        for (Page page : pages) {
            if (page.id == id)
                return page;
        }
        return null;
    }
}
