package src;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private int length;
    private double cost;

    public DigitalVideoDisc(String title, String category, int length, double cost) {
        this.title = title;
        this.category = category;
        this.length = length;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getLength() {
        return length;
    }

    public double getCost() {
        return cost;
    }
}