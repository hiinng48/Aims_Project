package src;

public class Aims {
    public static void main(String[] args) {
        Cart newCart = new Cart();
    
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 87, 19.95);
        newCart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 87, 24.95);
        newCart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 90, 18.99);
        newCart.addDigitalVideoDisc(dvd3);

        newCart.print();
        newCart.removeDigitalVideoDisc(dvd2);
        newCart.print();
    }
}