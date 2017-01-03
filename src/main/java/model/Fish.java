package model;

class Fish {

    private int weight;
    private int length;

    public Fish(int weight, int length) {
        this.weight = weight;
        this.length = length;
    }

    public Fish() {
        this(5, 5);
    }

    public int getHealth() {
        return weight + length;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Fish)) {
            return false;
        }
        Fish otherFish = (Fish) other;
        return this.weight == otherFish.weight
            && this.length == otherFish.length;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Fish: Weight=" + weight + ", Length=" + length;
    }
}
