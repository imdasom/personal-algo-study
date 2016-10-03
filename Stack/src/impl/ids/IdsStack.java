package impl.ids;

/**
 * Created by dasom on 2016-10-03.
 */
public class IdsStack<E> extends IdsVector {

    public boolean empty(){
        return (size() == 0);
    }

    public E push(E e){
        elementData[++indexCounter] = e;
        return e;
    }

    public E pop(){
        E element = (E)elementData[indexCounter];

        if(element == null){
            throw new ArrayIndexOutOfBoundsException(indexCounter);
        }

        elementData[indexCounter--] = null;
        return element;
    }

    public E peek(){
        return (E)elementData[indexCounter];
    }

    public int search(E e){
        for(int i=0; i<elementData.length; i++){
            if(elementData[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
}
