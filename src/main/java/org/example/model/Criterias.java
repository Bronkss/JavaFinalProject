package org.example.model;

import java.util.Scanner;

public class Criterias {
    Object value;
    Double minValue;
    Double maxValue;
    boolean isQuantitative;
    String property;

    public Criterias(String property, boolean isQuantitative, Object value, Double minValue, Double maxValue) {
        this.property = property;
        this.isQuantitative = isQuantitative;
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public static Criterias startGetting(Scanner scanner, String property, boolean isQuantitative) {
        if (isQuantitative) {
            String quest = "Выберите тип криетрия: " +
                    "\n 1. Значение" +
                    "\n 2. Меньше" +
                    "\n 3. Больше" +
                    "\n 4. Интервал";
            System.out.println(quest);

            String text = scanner.next();

            Criterias criterias = null;

            if (text.equals("1")) {
                System.out.println("Введите значение поиска: ");
                int getValue = scanner.nextInt();
                criterias = new Criterias(property, isQuantitative, getValue, null, null);
            } else if (text.equals("2")) {
                System.out.println("Введите максимальное предельное значение: ");
                double getValue = scanner.nextDouble();
                criterias = new Criterias(property, isQuantitative, null, null, getValue);
            } else if (text.equals("3")) {
                System.out.println("Введите минимальное предельное значение: ");
                double getValue = scanner.nextDouble();
                criterias = new Criterias(property, isQuantitative, null, getValue, null);
            } else if (text.equals("4")) {
                System.out.println("Введите минимальное предельное значение: ");
                double getMin = scanner.nextDouble();
                System.out.println("Введите максимальное предельное значение: ");
                double getMax = scanner.nextDouble();
                criterias = new Criterias(property, isQuantitative, null, getMin, getMax);
            }

            return criterias;
        }

        System.out.println("Введите значение поиска: ");
        String getValue = scanner.next();
        return new Criterias(property, isQuantitative, getValue, null, null);
    }



}
