package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int quantityInStore = 0;

    public void addDVD(DigitalVideoDisc disc) {
        if (disc == null) {
            return;
        }
        if (quantityInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[quantityInStore] = disc;
            quantityInStore++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add \"" + disc.getTitle() + "\".");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        if (disc == null) {
            return;
        }
        int index = -1;
        for (int i = 0; i < quantityInStore; i++) {
            if (itemsInStore[i].equals(disc)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < quantityInStore - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            itemsInStore[quantityInStore - 1] = null;
            quantityInStore--;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The disc \"" + disc.getTitle() + "\" does not exist in the store.");
        }
    }
}

