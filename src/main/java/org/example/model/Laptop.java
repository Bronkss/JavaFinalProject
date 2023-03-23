package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Laptop {
    private String laptopName;
    private String laptopModel;
    private int amountRAM;
    private String operatingSystem;
    private int hardDiskCapacity;
    private String color;

    public Laptop(String laptopName, String laptopModel, int amountRAM, String operatingSystem, int hardDiskCapacity, String color) {
        this.laptopName = laptopName;
        this.laptopModel = laptopModel;
        this.amountRAM = amountRAM;
        this.operatingSystem = operatingSystem;
        this.hardDiskCapacity = hardDiskCapacity;
        this.color = color;
    }

    public static List<String> propertiesForFilter (){
        List<String> list = new ArrayList<>();
        list.add("laptopModel");
        list.add("amountRAM");
        list.add("operatingSystem");
        list.add("hardDiskCapacity");
        list.add("color");

        return list;
    }

    public boolean validateObject(){
        return true;
    }

    @Override
    public String toString() {
        return "Ноутбук: (" + laptopName + "): " +
                "модель ноутбука: " + laptopModel +
                ", количество опретивной памяти: " + amountRAM +
                ", операционная система: " + operatingSystem + '\'' +
                ", объём жесткого диска: " + hardDiskCapacity +
                ", цвет: " + color;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getLaptopModel() {
        return laptopModel;
    }

    public void setLaptopModel(String laptopModel) {
        this.laptopModel = laptopModel;
    }

    public int getAmountRAM() {
        return amountRAM;
    }

    public void setAmountRAM(int amountRAM) {
        this.amountRAM = amountRAM;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public void setHardDiskCapacity(int hardDiskCapacity) {
        this.hardDiskCapacity = hardDiskCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
