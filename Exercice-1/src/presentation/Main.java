package presentation;

import metier.StorageGenerique;


public class Main {
    public static void main(String[] args) {
        StorageGenerique<String> stringStorageGenerique = new StorageGenerique<>();
        StorageGenerique<Double> doubleStorageGenerique = new StorageGenerique<>();
        StorageGenerique<Integer> integerStorageGenerique = new StorageGenerique<>();


        // String
        stringStorageGenerique.addElement("Hello");
        stringStorageGenerique.addElement("World");
        System.out.println(stringStorageGenerique.getElement(0) + " " + stringStorageGenerique.getElement(1));


        // Double
        doubleStorageGenerique.addElement(1.0);
        doubleStorageGenerique.addElement(1.0);
        doubleStorageGenerique.removeElement(0);
        System.out.println("Size: " + doubleStorageGenerique.getSize());


        // Integer
        integerStorageGenerique.addElement(5);
        integerStorageGenerique.addElement(5);
        System.out.println("Somme: "+(integerStorageGenerique.getElement(0)+integerStorageGenerique.getElement(1)));
    }
}
