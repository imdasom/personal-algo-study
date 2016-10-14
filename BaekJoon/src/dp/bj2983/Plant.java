package dp.bj2983;

/**
 * Created by dasom on 2016-10-03.
 */
public class Plant {
    public int x;
    public int y;
    public boolean isPlanet;

    public Plant(int x, int y) {
        this.x = x;
        this.y = y;
        this.isPlanet = true;
    }

    public void removePlant(){
        isPlanet = false;
    }
}
