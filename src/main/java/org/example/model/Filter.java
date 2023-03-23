package org.example.model;

import java.util.*;

public class Filter {
    private Set<Laptop> laptops = new HashSet<>();
    private List<Criterias> criteriasList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void printList() {
        for (Laptop laptop : laptops) {
            if (laptopIsCorrect(laptop)) {
                System.out.println(laptop);
            }
        }
    }

    private boolean laptopIsCorrect(Laptop laptop) {
        for (Criterias criterias : criteriasList) {
            Object valueLaptop = null;

            if (criterias.property.equals("laptopName")) {
                valueLaptop = laptop.getLaptopName();
            } else if (criterias.property.equals("laptopModel")) {
                valueLaptop = laptop.getLaptopModel();
            } else if (criterias.property.equals("amountRAM")) {
                valueLaptop = laptop.getAmountRAM();
            } else if (criterias.property.equals("operatingSystem")) {
                valueLaptop = laptop.getOperatingSystem();
            } else if (criterias.property.equals("hardDiskCapacity")) {
                valueLaptop = laptop.getHardDiskCapacity();
            } else if (criterias.property.equals("color")) {
                valueLaptop = laptop.getColor();
            } else {
                continue;
            }

            if (criterias.value != null && !criterias.value.equals(valueLaptop)) {
                return false;
            }
            if (criterias.maxValue != null && criterias.maxValue < Double.parseDouble(Objects.toString(valueLaptop))) {
                return false;
            }
            if (criterias.minValue != null && criterias.minValue > Double.parseDouble(Objects.toString(valueLaptop))) {
                return false;
            }
        }
        return true;
    }

    public Filter(Set<Laptop> laptops) {
        this.scanner = new Scanner(System.in);
        this.laptops = laptops;
    }

    public Filter(Set<Laptop> laptops, List<Criterias> criteriasList) {
        this.scanner = new Scanner(System.in);
        this.laptops = laptops;
        this.criteriasList = criteriasList;
    }

    public int getCriteria() {
        String text = "Введите цифру, соответствующую необходимому критерию: ";
        List<String> properties = propertiesForFilter();

        for (int i = 0; i < properties.size(); i++) {
            text += "\n" + (i + 1) + ". " + getPropertyDescription(properties.get(i));
        }

        System.out.println(text);
        int value = scanner.nextInt();

        return value;
    }

    public String getPropertyDescription(String property) {
        Map<String, String> descriptionsProperties = descriptionsProperties();

        return descriptionsProperties.get(property);

    }

    public Map<String, String> descriptionsProperties() {
        Map<String, String> map = new HashMap<>();

        map.put("laptopName", "Наименование");
        map.put("laptopModel", "Модель");
        map.put("amountRAM", "Объем оперативной памяти");
        map.put("operatingSystem", "Операционная система");
        map.put("hardDiskCapacity", "Объём жесткого диска");
        map.put("color", "цвет");

        return map;

    }

    public List<String> propertiesForFilter() {
        List<String> list = new ArrayList<>();
        list.add("laptopName");
        list.add("laptopModel");
        list.add("amountRAM");
        list.add("operatingSystem");
        list.add("hardDiskCapacity");
        list.add("color");

        return list;
    }

    public String getOperations() {
        String text = "Выберите опрерацию: \n " +
                "1. Добавить критерий \n " +
                "2. Вывести список \n " +
                "3. Завершить";

        System.out.println(text);
        String answer = scanner.next();
        return answer;
    }

    public Set<String> quantitativeSelection() {
        Set<String> set = new HashSet<>();
        set.add("amountRAM");
        set.add("hardDiskCapacity");

        return set;
    }

    public Set<String> stringSelection() {
        Set<String> set = new HashSet<>();
        set.add("laptopName");
        set.add("laptopModel");
        set.add("operatingSystem");
        set.add("color");

        return set;

    }

    public void start() {
        boolean flag = true;
        while (flag) {
            String operation = getOperations();
            if (operation.equals("3")) {
                flag = false;
                scanner.close();
                continue;
            } else if (operation.equals("1")) {
                int criterion = getCriteria();
                List<String> properites = propertiesForFilter();
                if (criterion - 1 < 0 || criterion - 1 > properites.size() - 1) {
                    System.out.println("Введено некорректное значение");
                    continue;
                }
                String property = properites.get(criterion - 1);
                Criterias criteriasObject = null;
                try {
                    if (quantitativeSelection().contains(property)) {
                        criteriasObject = Criterias.startGetting(scanner, property, true);
                    } else {
                        criteriasObject = Criterias.startGetting(scanner, property, false);
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка при выборе критерия");
                    continue;
                }
                if (criteriasObject != null) {
                    System.out.println("Критерий добавлен");
                    criteriasList.add(criteriasObject);
                }
            } else if (operation.equals("2")) {
                printList();
            }
        }


    }

}
