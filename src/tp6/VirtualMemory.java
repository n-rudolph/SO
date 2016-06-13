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

    private Map<Integer, Page> pages;

    public VirtualMemory(int size, int pageSize, int accessTime, List<Page> pagesList){
        pages = new HashMap<Integer, Page>();
        this.size=size;
        this.pageSize=pageSize;
        this.accessTime=accessTime;

        for (Page page : pagesList) {
            pages.put(page.id, page);
        }
    }

    public void addPage(Page p){
        pages.put(p.id, p);
    }

    public Page removePage(int id){
        return pages.remove(id);
    }

    public Page getPage(int id ){
        return pages.get(id);
    }
}
