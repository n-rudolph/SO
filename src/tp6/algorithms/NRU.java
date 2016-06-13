package tp6.algorithms;

import tp6.Access;
import tp6.Memory;
import tp6.Page;
import tp6.VirtualMemory;

import java.util.List;

public class NRU extends PageReplacementAlgorithm {

    List<Page> notRnotM;
    List<Page> notRM;
    List<Page> rnotM;
    List<Page> rM;

    public NRU(Memory mem, VirtualMemory vMem) {
        super(mem, vMem);
    }

    @Override
    public void onSuccess(Access a) {

        if (a.accessType.equals(Access.AccessType.WRITE)){
            if (!a.page.modified && !a.page.reference){
                notRnotM.remove(a.page);
            } else if (!a.page.modified && a.page.reference){
                rnotM.remove(a.page);
            }else if (a.page.modified && !a.page.reference){
                notRM.remove(a.page);
            }
            rM.add(a.page);
            a.page.modified=true;
            a.page.reference=true;
        } else {
            if (!a.page.modified && !a.page.reference){
                notRnotM.remove(a.page);
            } else if (!a.page.modified && a.page.reference){
                rnotM.remove(a.page);
            }else if (a.page.modified && !a.page.reference){
                notRM.remove(a.page);
            }
            a.page.reference=true;
            if (a.page.modified)
                rM.add(a.page);
            else rnotM.add(a.page);
        }
    }

    @Override
    public void onFault(Access a) {
        if (memory.pages.size()== memory.maxSize){
            if (!notRnotM.isEmpty()){
                Page p = notRnotM.get(0);
                memory.removePage(p.id);
                notRnotM.remove(p);
                memory.addPage(a.page);
                p.modified=false;
                p.reference=true;
                if (a.accessType.equals(Access.AccessType.WRITE)) {
                    a.page.modified=true;
                    a.page.reference=true;
                    rM.add(a.page);
                }else{
                    rnotM.add(a.page);
                    a.page.reference=true;
                    a.page.modified=false;
                }

            } else if (!notRM.isEmpty()){
                Page p = notRM.get(0);
                memory.removePage(p.id);
                notRM.remove(p);
                memory.addPage(a.page);
                p.modified=false;
                p.reference=true;
                if (a.accessType.equals(Access.AccessType.WRITE)) {
                    a.page.modified=true;
                    a.page.reference=true;
                    rM.add(a.page);
                }else{
                    rnotM.add(a.page);
                    a.page.reference=true;
                    a.page.modified=false;
                }

            }else if (!rnotM.isEmpty()){
                Page p = rnotM.get(0);
                memory.removePage(p.id);
                rnotM.remove(p);
                memory.addPage(a.page);
                p.modified=false;
                p.reference=true;
                if (a.accessType.equals(Access.AccessType.WRITE)) {
                    a.page.modified=true;
                    a.page.reference=true;
                    rM.add(a.page);
                }else{
                    rnotM.add(a.page);
                    a.page.reference=true;
                    a.page.modified=false;
                }

            } else {
                Page p = rM.get(0);
                memory.removePage(p.id);
                rM.remove(p);
                memory.addPage(a.page);
                p.modified=false;
                p.reference=true;
                if (a.accessType.equals(Access.AccessType.WRITE)) {
                    a.page.modified=true;
                    a.page.reference=true;
                    rM.add(a.page);
                }else{
                    rnotM.add(a.page);
                    a.page.reference=true;
                    a.page.modified=false;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "NRU";
    }
}
