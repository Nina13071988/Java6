
import java.util.*;

public class Notebook {
    private String brand;
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;
    private double price;

    public Notebook(String brand, String model, int ram, int storage, String os, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return brand + " " + model + ", RAM: " + ram + "GB, Storage: " + storage + "GB, OS: " + os + ", Color: " + color + ", Price: $" + price;
    }

    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Apple", "MacBook Air", 8, 256, "macOS", "Silver", 999.99));
        notebooks.add(new Notebook("Dell", "XPS 13", 16, 512, "Windows 10", "Black", 1399.99));
        notebooks.add(new Notebook("Lenovo", "ThinkPad X1 Carbon", 16, 1000, "Windows 10 Pro", "Black", 1499.99));

        Map<Integer, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the criteria for filtering:");
        System.out.println("1 - RAM");
        System.out.println("2 - Storage");
        System.out.println("3 - Operating System");
        System.out.println("4 - Color");

        int criteria = scanner.nextInt();
        scanner.nextLine();

        switch (criteria) {
            case 1:
                System.out.println("Enter the minimum RAM:");
                int minRam = scanner.nextInt();
                filters.put(criteria, minRam);
                break;
            case 2:
                System.out.println("Enter the minimum storage:");
                int minStorage = scanner.nextInt();
                filters.put(criteria, minStorage);
                break;
            case 3:
                System.out.println("Enter the operating system:");
                String os = scanner.nextLine();
                filters.put(criteria, os);
                break;
            case 4:
                System.out.println("Enter the color:");
                String color = scanner.nextLine();
                filters.put(criteria, color);
                break;
            default:
                System.out.println("Invalid criteria.");
                return;
        }

        List<Notebook> filteredNotebooks = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            boolean passFilter = true;

            for (Map.Entry<Integer, Object> entry : filters.entrySet()) {
                int filterCriteria = entry.getKey();
                Object filterValue = entry.getValue();

                switch (filterCriteria) {
                    case 1:
                        if (notebook.getRam() < (int) filterValue) {
                            passFilter = false;
                        }
                        break;
                    case 2:
                        if (notebook.getStorage() < (int) filterValue) {
                            passFilter = false;
                        }
                        break;
                    case 3:
                        if (!notebook.getOs().equalsIgnoreCase((String) filterValue)) {
                            passFilter = false;
                        }
                        break;
                    case 4:
                        if (!notebook.getColor().equalsIgnoreCase((String) filterValue)) {
                            passFilter = false;
                        }
                        break;
                }

                if (!passFilter) {
                    break;
                }
            }

            if (passFilter) {
                filteredNotebooks.add(notebook);
            }
        }

        System.out.println("Filtered notebooks:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }
}

