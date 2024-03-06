package metier;

import java.util.ArrayList;
import java.util.List;

public class StorageGenerique <T> {
    private List<T> elements;

    public StorageGenerique(){
        this.elements = new ArrayList<>();
    }

    public void addElement(T o){
        this.elements.add(o);
    }

    public T getElement(int index){
        return this.elements.get(index);
    }

    public void removeElement(int index){
        this.elements.remove(index);
    }

    public int getSize(){
        return this.elements.size();
    }
}
