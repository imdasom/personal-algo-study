package dp.bj2983;

/**
 * Created by dasom on 2016-10-03.
 */
public class ToPlant extends Plant{
    public LinkedPlant linkedPlant;
    public char direction;
    public int distance;
    public ToPlant link;

    public ToPlant(LinkedPlant linkedPlant, char direction, int distance) {
        super(linkedPlant.getMain().x, linkedPlant.getMain().y);
        this.linkedPlant = linkedPlant;
        this.direction = direction;
        this.distance = distance;
        this.link = null;
    }
}
