package dp.bj2983;

/**
 * Created by dasom on 2016-10-03.
 */
public class LinkedPlant{
    private Plant main;
    private ToPlant AHead;
    private ToPlant BHead;
    private ToPlant CHead;
    private ToPlant DHead;


    public LinkedPlant(Plant plant) {
        this.main = plant;
    }

    public Plant getMain() {
        return main;
    }

    public void insertPlant(LinkedPlant newLinkedPlant) {
        ToPlant newToPlant = (ToPlant)createToPlant(newLinkedPlant);
        ToPlant head = null;

        if(newToPlant == null) return;

        switch (newToPlant.direction){
            case 'A': head = AHead; break;
            case 'B': head = BHead; break;
            case 'C': head = CHead; break;
            case 'D': head = DHead; break;
            default: head = null; break;
        }

        // 만약 A의 헤드가 널이라면 첫번째 노드가 된다.
        // 그렇지 않다면 중간에 삽입된다.
        if(head == null){
            switch (newToPlant.direction){
                case 'A': AHead = newToPlant; break;
                case 'B': BHead = newToPlant; break;
                case 'C': CHead = newToPlant; break;
                case 'D': DHead = newToPlant; break;
            }
        }else{
            ToPlant curPlant = head;
            while(curPlant != null){
                if(curPlant.distance > newToPlant.distance){
                    newToPlant.link = curPlant;
                    curPlant = newToPlant;
                    break;
                }else{
                    curPlant = curPlant.link;
                }
            }
        }
    }

    private Plant createToPlant(LinkedPlant linkedPlant) {
        int valueX = main.x - linkedPlant.getMain().x;
        int valueY = main.y - linkedPlant.getMain().y;

        if ((valueX > 0) && (valueY > 0)) {
            if (valueX == valueY) {
                //System.out.println(main.x+", "+main.y+" : D, " + linkedPlant.getMain().x+", "+linkedPlant.getMain().y);
                return (new ToPlant(linkedPlant, 'D', valueX));
            }
        }
        if ((valueX > 0) && (valueY < 0)) {
            if ((valueX + valueY) == 0) {
                //System.out.println(main.x+", "+main.y+" : C, " + linkedPlant.getMain().x+", "+linkedPlant.getMain().y);
                return (new ToPlant(linkedPlant, 'C', valueX));
            }
        }
        if ((valueX < 0) && (valueY > 0)) {
            if ((valueX + valueY) == 0) {
                //System.out.println(main.x+", "+main.y+" : B, " + linkedPlant.getMain().x+", "+linkedPlant.getMain().y);
                return (new ToPlant(linkedPlant, 'B', valueX * -1));
            }
        }
        if ((valueX < 0) && (valueY < 0)) {
            if (valueX == valueY) {
                //System.out.println(main.x+", "+main.y+" : A, " + linkedPlant.getMain().x+", "+linkedPlant.getMain().y);
                return (new ToPlant(linkedPlant, 'A', valueX * -1));
            }
        }

        return null;
    }

    public LinkedPlant getProximatePlant(char newDirection) {
        ToPlant head = null;
        ToPlant result = null;

        switch (newDirection){
            case 'A': head = AHead; break;
            case 'B': head = BHead; break;
            case 'C': head = CHead; break;
            case 'D': head = DHead; break;
            default: head = null; break;
        }

        if((head != null)){
            result = head;
            head = head.link;
        }
        try{
            return result.linkedPlant;
        }catch (NullPointerException e){
            return null;
        }

    }
}
