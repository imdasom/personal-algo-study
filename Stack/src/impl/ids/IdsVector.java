package impl.ids;

/**
 * Created by dasom on 2016-10-03.
 */
public class IdsVector<E> {

    protected Object[] elementData;
    protected int elementCount;
    protected int capacityIncrement;
    protected int indexCounter;

    // 디폴트 VALUE
    protected final int DEFAULT_ELEMENT_COUNT = 10;
    protected final int DEFAULT_CAPACITY_INCREMENT = 10;

    // 생성자
    public IdsVector(){
        this.elementCount = DEFAULT_ELEMENT_COUNT;
        this.capacityIncrement = DEFAULT_CAPACITY_INCREMENT;
        this.elementData = new Object[DEFAULT_ELEMENT_COUNT];
        this.indexCounter = -1;
    }

    public IdsVector(int elementCount, int capacityIncrement) {
        this.elementCount = elementCount;
        this.capacityIncrement = capacityIncrement;
        this.elementData = new Object[DEFAULT_ELEMENT_COUNT];
        this.indexCounter = -1;
    }

    public int size(){
        return indexCounter;
    }

    public boolean isEmpty(){
        return (indexCounter == -1);
    }

    public void addElement(E e){
        elementData[++indexCounter] = e;
    }

    public void add(E e){
        elementData[++indexCounter] = e;
    }

    public void add(int index, E e){
        // 배열에 데이터가 모두 채워졌으면
        // 배열을 늘린다.
        Object[] newElement = null;
        if(indexCounter == elementData.length-1){
            newElement = new Object[elementData.length+capacityIncrement];
        }else{
            newElement = new Object[elementData.length];
        }

        for(int i=0, j=0; i<=indexCounter+1; i++, j++){
            if(i == index){
                newElement[i] = e;
                j--;
            }else{
                newElement[i] = elementData[j];
            }
        }

        elementData = newElement;
        ++indexCounter;
    }

    public int capacity(){
        return (elementData.length-1)-indexCounter;
    }

    public void clear(){
        elementData = null;
        elementData = new Object[DEFAULT_ELEMENT_COUNT];
    }

    public boolean contains(E e){
        for(int i=0; i<elementData.length; i++){
            if(elementData[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public E get(int index){
        if(elementData[index] != null){
            return (E)elementData[index];
        }
        return null;
    }

    public void printVector(){
        for(int i=0; i<elementData.length; i++){
            System.out.println(elementData[i]+" ");
        }
    }

}
