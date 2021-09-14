package model;

public class Herbivore extends Animal implements Food {

    public Herbivore() {
        super();
        setName("Default Herbivore");
    }

    public Herbivore(int id, String name, float weight) {
        super(id, name, weight);
    }

    @Override
    public void eat(Food food) {
        if (!isAlive) {
            return;
        }
        if (!(food instanceof Grass)) {
            return;
        }
        Grass grass = (Grass)food;

        this.weight += 0.5F;
        grass.weight -= 0.5F;
    }
}
