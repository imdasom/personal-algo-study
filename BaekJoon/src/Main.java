import algorithm.bj2983.bj2983;
import java.io.FileNotFoundException;

/**
 * Created by dasom on 2016-10-02.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        new bj2983();
    }
}

    /*public static LinkedPlant[] plants;
    public static LinkedPlant frog;
    public static Map<Plant, LinkedPlant> linkedPlantMap = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.nanoTime();
        bj2983();
        long end = System.nanoTime();

        System.out.println((end-start)/1000);
    }

    public static void bj2983() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input_data/bj2983_input.txt"));

        int N = sc.nextInt();
        int K = sc.nextInt();
        String directions = sc.next();

        plants = new LinkedPlant[N];
        for(int i=0; i<N; i++) {
            Plant newPlant = new Plant(sc.nextInt(), sc.nextInt());
            plants[i] = new LinkedPlant(newPlant);
            linkedPlantMap.put(newPlant, plants[i]);

            // 연결리스트에 추가한다.
            for (int j = i - 1; j >= 0; j--) {
                //System.out.println(i+", "+j);
                plants[i].insertPlant(plants[j]);
                plants[j].insertPlant(plants[i]);
            }
        }

        frog = plants[0];
        plants[0].getMain().removePlant();

        int i = 0;
        while(i < K){
            //System.out.println("점프 전 : "+frog.getMain().x+" "+frog.getMain().y);
            char newDirection = directions.charAt(i);
            LinkedPlant newPlant = frog.getProximatePlant(newDirection);
            if(newPlant == null) break;
            frog = newPlant;
            frog.getMain().removePlant();
            //System.out.println("점프 후 : "+frog.getMain().x+" "+frog.getMain().y+"\n");
            i++;
        }

        System.out.println(frog.getMain().x+" "+frog.getMain().y);
    }
}

class Plant {
    public int x;
    public int y;
    public boolean isPlanet;

    public char direction;
    public int distance;
    public Plant link;

    public Plant(int x, int y) {
        this.x = x;
        this.y = y;
        this.isPlanet = true;
    }

    public Plant(int x, int y, char direction, int distance) {
        this.x = x;
        this.y = y;
        this.isPlanet = true;

        this.direction = direction;
        this.distance = distance;
        this.link = null;
    }

    public void removePlant(){
        isPlanet = false;
    }
}

class LinkedPlant{
    private Plant main;
    private Plant AHead;
    private Plant BHead;
    private Plant CHead;
    private Plant DHead;

    public LinkedPlant(Plant plant) {
        this.main = plant;
    }

    public Plant getMain() {
        return main;
    }

    public void insertPlant(LinkedPlant newLinkedPlant) {
        Plant newToPlant = createToPlant(newLinkedPlant);
        Plant head = null;

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

    private Plant createToPlant(Plant plant) {
        int valueX = main.x - linkedPlant.getMain().x;
        int valueY = main.y - linkedPlant.getMain().y;

        if ((valueX > 0) && (valueY > 0)) {
            if (valueX == valueY) {
                //System.out.println(main.x+", "+main.y+" : D, " + linkedPlant.getMain().x+", "+linkedPlant.getMain().y);
                return (new Plant(plant, 'D', valueX));
            }
        }
        if ((valueX > 0) && (valueY < 0)) {
            if ((valueX + valueY) == 0) {
                //System.out.println(main.x+", "+main.y+" : C, " + linkedPlant.getMain().x+", "+linkedPlant.getMain().y);
                return (new Plant(plant, 'C', valueX));
            }
        }
        if ((valueX < 0) && (valueY > 0)) {
            if ((valueX + valueY) == 0) {
                //System.out.println(main.x+", "+main.y+" : B, " + linkedPlant.getMain().x+", "+linkedPlant.getMain().y);
                return (new Plant(plant, 'B', valueX * -1));
            }
        }
        if ((valueX < 0) && (valueY < 0)) {
            if (valueX == valueY) {
                //System.out.println(main.x+", "+main.y+" : A, " + linkedPlant.getMain().x+", "+linkedPlant.getMain().y);
                return (new Plant(plant, 'A', valueX * -1));
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
}*/
