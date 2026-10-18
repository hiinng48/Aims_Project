package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int quantityOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (quantityOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[quantityOrdered] = disc;
            quantityOrdered++;
            System.out.println("The disc has been added successfully.");
        } else {
            System.out.println("The cart is full.");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (dvdList == null) {
            return;
        }
        for (DigitalVideoDisc disc : dvdList) {
            if (quantityOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[quantityOrdered] = disc;
                quantityOrdered++;
                System.out.println("The disc has been added successfully.");
            } else {
                System.out.println("The cart is full.");
                break;
            }
        }
    }

    /*
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        if (dvds == null) {
            return;
        }
        for (DigitalVideoDisc disc : dvds) {
            if (quantityOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[quantityOrdered] = disc;
                quantityOrdered++;
                System.out.println("The disc has been added successfully.");
            } else {
                System.out.println("The cart is full.");
                break;
            }
        }
    }
    */

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
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
            for (int i = index; i < quantityOrdered - 1; ++i) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            itemsOrdered[quantityOrdered - 1] = null;
            quantityOrdered--;
            System.out.println("The disc has been removed successfully.");
        } else {
            System.out.println("The disc does not exist.");
        }
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (int i = 0; i < quantityOrdered; ++i) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < quantityOrdered; ++i) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + getTotalCost());
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < quantityOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found DVD with ID " + id + ": " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < quantityOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found DVD: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title matching: " + title);
        }
    }
}

