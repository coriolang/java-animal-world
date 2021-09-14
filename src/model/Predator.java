package model;

public class Predator extends Animal {

    public Predator() {
        super();
        setName("Default Predator");
    }

    public Predator(int id, String name, float weight) {
        super(id, name, weight);
    }

    private boolean hunt() {
        return Math.random() > 0.5;
    }

    @Override
    public void eat(Food food) {
        if (!isAlive) {
            return;
        }
        if (!(food instanceof Herbivore)) {
            return;
        }
        Herbivore herbivore = (Herbivore)food;
        if (!herbivore.isAlive) {
            return;
        }
        if (!hunt()) {
            return;
        }

        this.weight += 2.0F;
        herbivore.weight -= 2.0F;
        herbivore.die();
    }
}
