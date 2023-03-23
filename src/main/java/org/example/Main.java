package org.example;

import org.example.model.Filter;
import org.example.model.Laptop;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> set = new HashSet<>();
        set.add(new Laptop("laptop1", "Asus", 16, "Windows", 256, "black"));
        set.add(new Laptop("laptop2", "HP", 8, "Linux", 512, "white"));
        set.add(new Laptop("laptop3", "Lenovo", 32, "Windows", 1024, "gold"));
        set.add(new Laptop("laptop4", "Apple", 16, "macOS", 512, "grey"));
        set.add(new Laptop("laptop5", "Apple", 16, "macOS", 512, "light-grey"));
        set.add(new Laptop("laptop6", "Apple", 32, "macOS", 512, "red"));
        set.add(new Laptop("laptop7", "Asus", 64, "Windows", 2048, "white"));
        set.add(new Laptop("laptop8", "Acer", 8, "Linux", 512, "yellow"));
        set.add(new Laptop("laptop9", "Acer", 8, "Linux", 512, "green"));

        Filter operation = new Filter(set);
        operation.start();

    }
}