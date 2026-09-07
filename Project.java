import java.util.*;

public class Project {
    public static void main(String[] args) {
        Baker baker = new Baker("Joel", 7);
        Dessert cake = new Dessert("Strawberry cream Cake", 8.5, false);
        MainDish steak = new MainDish("Joel Steak house's Steak", 22.0, false);

        ArrayList<Dish> menu = new ArrayList<Dish>();

        menu.add(cake);
        menu.add(steak);

        System.out.println("Welcome to my restaurant!");
        System.out.println("Choose your meal");

        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i+1) + ". " + menu.get(i).getName());
        }

        int choiceNumber = In.nextInt();

        if (choiceNumber == 1) {
            System.out.println("Enter the dessert name:");
            String newName = In.nextLine();

            System.out.println("Enter the dessert price:");
            double newPrice = In.nextDouble();

            cake.setName(newName);
            cake.setPrice(newPrice);

            cake.prepare();
            baker.addPreparedDish(cake);

            System.out.println("Your selected dish:");
            System.out.println(cake);
            System.out.println("Total Price: $" + cake.calculatePrice());

        } else if (choiceNumber == 2) {
            System.out.println("Enter the main dish name:");
            String newName = In.nextLine();

            System.out.println("Enter the main dish price:");
            double newPrice = In.nextDouble();

            steak.setName(newName);
            steak.setPrice(newPrice);

            steak.prepare();
            baker.addPreparedDish(steak);

            System.out.println("Your selected dish:");
            System.out.println(steak);
            System.out.println("Total Price: $" + steak.calculatePrice());

        } else {
            System.out.println("Invalid choice.");
        }

        baker.work();
        baker.increaseExperience();

        System.out.println();
        System.out.println("Restaurant menu:");

        for (Dish dish : menu) {
            System.out.println(dish);
        }

        System.out.println();
        baker.showPreparedDishes();

        System.out.println();
        System.out.println(baker);
    }
}

class Dish {
    private String name;
    private double price;

    Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void prepare() {
        System.out.println(this.name + " is prepared.");
    }

    public double calculatePrice() {
        return this.price;
    }

    public String toString() {
        return "Dish name: " + this.name
                + ", Price: $" + this.price;
    }
}

class Dessert extends Dish {
    private boolean cold;

    Dessert(String name, double price, boolean cold) {
        super(name, price);
        this.cold = cold;
    }

    public boolean getCold() {
        return this.cold;
    }

    public void setCold(boolean cold) {
        this.cold = cold;
    }

    @Override
    public void prepare() {
        this.cold = true;
        System.out.println(getName() + " is prepared and enjoy your meal :)");
    }

    @Override
    public double calculatePrice() {
        return getPrice() + 2.0;
    }

    @Override
    public String toString() {
        return "Dessert: " + getName()
                + ", Price: $" + calculatePrice()
                + ", Cold: " + this.cold;
    }
}

class MainDish extends Dish {
    private boolean ready;

    MainDish(String name, double price, boolean ready) {
        super(name, price);
        this.ready = ready;
    }

    public boolean getReady() {
        return this.ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    @Override
    public void prepare() {
        this.ready = true;
        System.out.println(getName() + " is cooked and ready.");
    }

    @Override
    public double calculatePrice() {
        return getPrice() + 3.0;
    }

    @Override
    public String toString() {
        return "Main Dish: " + getName()
                + ", Price: $" + calculatePrice()
                + ", Ready: " + this.ready;
    }
}

class Baker {
    private String bakerName;
    private int yearsExperience;
    private ArrayList<Dish> preparedDishes;

    Baker(String bakerName, int yearsExperience) {
        this.bakerName = bakerName;
        this.yearsExperience = yearsExperience;
        this.preparedDishes = new ArrayList<Dish>();
    }

    public String getBakerName() {
        return this.bakerName;
    }

    public int getYearsExperience() {
        return this.yearsExperience;
    }

    public void setBakerName(String bakerName){ this.bakerName = bakerName;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public void work() {
        System.out.println(this.bakerName + " is preparing food.");
    }

    public void increaseExperience() {
        this.yearsExperience++;
    }

    public void addPreparedDish(Dish dish) {
        this.preparedDishes.add(dish);
    }

    public void showPreparedDishes() {
        System.out.println(this.bakerName + "'s prepared dishes:");

        for (Dish dish : preparedDishes) {
            System.out.println(dish);
        }
    }

    public String toString() {
        return "Baker: " + this.bakerName
                + ", Experience: "
                + this.yearsExperience
                + " years";
    }
}

class In {
    private static Scanner in = new Scanner(System.in);

    public static String nextLine() {
        return in.nextLine();
    }

    public static char nextChar() {
        return in.nextLine().charAt(0);
    }

    public static char nextUpperChar() {
        return in.nextLine().toUpperCase().charAt(0);
    }

    public static int nextInt() {
        int i = in.nextInt();
        in.nextLine();
        return i;
    }

    public static double nextDouble() {
        double d = in.nextDouble();
        in.nextLine();
        return d;
    }
}