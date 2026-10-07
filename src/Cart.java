package src;

public class Cart {
    public static final  int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int quantityOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (quantityOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[quantityOrdered] = disc;
            ++ quantityOrdered;
            System.out.println("The disc has been added successfully.");
        } else {
            System.out.println("The cart is full.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < quantityOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < quantityOrdered - 1; ++ i)
                itemsOrdered[i] = itemsOrdered[i + 1];
            itemsOrdered[quantityOrdered - 1] = null;
            -- this.quantityOrdered;
            System.out.println("The disc has been removed successfully.");
        } else {
            System.out.println("The disc does not exist.");
        }
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (int i = 0; i < quantityOrdered; ++ i)
            totalCost += itemsOrdered[i].getCost();
        return totalCost;
    }

    public void print() {
        System.out.println("Items in the cart:");
        for (int i = 0; i < quantityOrdered; ++ i) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - $" + itemsOrdered[i].getCost());
        }
        System.out.println("Total cost: $" + getTotalCost());
    }
}
