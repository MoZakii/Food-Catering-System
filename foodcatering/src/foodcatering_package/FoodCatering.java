package foodcatering_package;

import javax.swing.plaf.synth.SynthMenuBarUI;
import java.lang.reflect.GenericArrayType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @see "Object Oriented Programming Lectures By Dr. Sherin Moussa and Dr. Sally Saad"
 */

/**
 *This interface applies Interface Segregation Principle. And
 * Is used for the Login method.
 */
interface Admin
{
    public boolean Login();

}

/**
 *This interface applies Interface Segregation Principle. And
 * Is used for the SignUp method.
 */

interface Account extends Admin
{
    public boolean Sign_Up();
}

/**
 * This class is used to implement Admin interface. To login as an admin to the system.
 * Uses method Overriding.
 */
class Admins implements Admin
{

    @Override
    /**
     * Method to implement logging in as Admin.
     * @return Boolean to confirm that the login procedure occurred.
     * @throws Customized_Exception if wrong information is used to Login.
     */
    public  boolean Login() {
        Scanner Input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("UserName: ");
                String name = Input.nextLine();
                System.out.print("Password: ");
                String password = Input.nextLine();
                if (name.equals("Admin") && password.equals("Admin")) {
                    system.is_Admin = true;
                    break;
                } else {
                    throw new Customized_Exception("Wrong Username or Password.");
                }
            }
            catch(Customized_Exception e)
            {
                System.out.println(e.message);
                return false;
            }
        }
        return true;
    }
}

/**
 * This class is used to implement Account Interface. To SignUp and Login as a User.
 */
class User implements Account
{

    @Override
    /**
     * This method is used to login as a user and confirm the information given.
     * Changes the User_Index in the system class according to the index of the List for later use.
     * @return Boolean to confirm that the login procedure occurred.
     * @throws Customized_Exception if wrong information is used to Login.
     */
    public  boolean Login()
    {
        boolean found = false;
        Scanner Input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("UserName: ");
                String name = Input.nextLine();
                System.out.print("Password: ");
                String password = Input.nextLine();
                for (int i = 0; i < system.Users.size(); i++) {
                    if (name.equals(system.Users.get(i).name) && password.equals(system.Users.get(i).password)) {
                        system.User_Index = i;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    throw new Customized_Exception("Wrong Username or Password.");
                }
                else
                    return true;
            }
            catch(Customized_Exception e)
                {
                    System.out.println(e.message);
                    return false;
                }

        }
    }


    @Override
    /**
     * This method is used to SignUp new Customers.
     * @return false by default as you will be prompted to login after.
     */
    public boolean Sign_Up()
    {
        Scanner Input = new Scanner(System.in);
        System.out.print("UserName: ");
        String name = Input.nextLine();
        System.out.print("Password: ");
        String password = Input.nextLine();
        Customer New_Customer = new Guest(name,password);
        system.Users.add(New_Customer);
        return false;
    }

}

/**
 * The main Class used to call DataBase method and run the Program.
 */
public class FoodCatering {

    public static void main(String[] args) {
        system.DATABASE();
        while(true) {
            Scanner Input = new Scanner(System.in);
            system.Menu();
            System.out.print("Would you like to Exit? (Y/N) : ");
            String choice = Input.nextLine();
            if(choice.equals("y") || choice.equals("Y"))
                break;
        }
    }
}

/**
 * This class is used for all the main procedures needed in the program. Such as the menus and output methods.
 * All_Food contains all food items available.
 * Users contains all customers currently registered in the program.
 * Static data members are used.
 * Static methods are used.
 * Exception handling used.
 */
class system{
    static public boolean is_Admin = false;
    static public int User_Index;

    static ArrayList<Food_Item> All_Food = new ArrayList<Food_Item>();
    static ArrayList<Customer> Users = new ArrayList<Customer>();

    /**
     * Static Method used to insert food items into the All_Food List containing all food items available. Also used for creating users and already made orders for testing purposes.
     */
    static void DATABASE()
    {
        All_Food.add(new  Food_Item("Nuggets","Appetizers",70,20,2));
        All_Food.add(new  Food_Item("Chicken Wings","Appetizers",50,15,2));
        All_Food.add(new  Food_Item("Fries","Appetizers",40,10,2));

        All_Food.add(new  Food_Item("Steak","Main",180,70,2));
        All_Food.add(new  Food_Item("Shawerma","Main",100,50,1));
        All_Food.add(new  Food_Item("Pasta","Main",150,80,3));
        All_Food.add(new  Food_Item("Fried Chicken","Main",220,180,4));
        All_Food.add(new  Food_Item("Pizza","Main",200,130,3));

        All_Food.add(new  Food_Item("Coleslaw","Salads",20,20,2));
        All_Food.add(new  Food_Item("Chicken Salad","Salads",50,40,2));
        All_Food.add(new  Food_Item("Caesar Salad","Salads",30,35,3));

        All_Food.add(new  Food_Item("Molten Cake","Desserts",60,15,1));
        All_Food.add(new  Food_Item("Brownies","Desserts",40,13,1));

        All_Food.add(new  Food_Item("Pepsi","Drinks",40,9,3));
        All_Food.add(new  Food_Item("7UP","Drinks",35,7,2));
        All_Food.add(new  Food_Item("Sprite","Drinks",30,10,3));
        All_Food.add(new  Food_Item("Diet Coke","Drinks",10,12,3));


        ArrayList<Order> Order1 = new ArrayList<Order>();
        ArrayList<Order> Order2 = new ArrayList<Order>();
        ArrayList<Order> Order3 = new ArrayList<Order>();
        ArrayList<Order> Order4 = new ArrayList<Order>();
        ArrayList<Order> Order5 = new ArrayList<Order>();


        ArrayList<Food_Item> Items1 = new ArrayList<Food_Item>();
        ArrayList<Food_Item> Items2 = new ArrayList<Food_Item>();
        ArrayList<Food_Item> Items3 = new ArrayList<Food_Item>();
        ArrayList<Food_Item> Items4 = new ArrayList<Food_Item>();

        Items1.add(new  Food_Item("Nuggets","Appetizers",70,20,2));
        Items2.add(new  Food_Item("Chicken Wings","Appetizers",50,0,2));
        Items2.add(new  Food_Item("Fries","Appetizers",40,0,2));

        Items1.add(new  Food_Item("Steak","Main",180,70,2));
        Items2.add(new  Food_Item("Shawerma","Main",100,50,1));
        Items3.add(new  Food_Item("Pasta","Main",150,80,3));
        Items4.add(new  Food_Item("Fried Chicken","Main",220,180,4));
        Items4.add(new  Food_Item("Pizza","Main",200,130,3));

        Items1.add(new  Food_Item("Coleslaw","Salads",20,20,2));
        Items2.add(new  Food_Item("Chicken Salad","Salads",50,40,2));
        Items3.add(new  Food_Item("Caesar Salad","Salads",30,35,3));

        Items1.add(new  Food_Item("Molten Cake","Desserts",60,15,1));
        Items4.add(new  Food_Item("Brownies","Desserts",40,13,1));

        Items1.add(new  Food_Item("Pepsi","Drinks",40,9,3));
        Items2.add(new  Food_Item("7UP","Drinks",35,8,2));
        Items3.add(new  Food_Item("Sprite","Drinks",30,10,3));

        Meal meal1 = new Meal(Items1);
        Meal meal2 = new Meal(Items2);
        Meal meal3 = new Meal(Items3);
        Meal meal4 = new Meal(Items4);
        Items3.add(new  Food_Item("Fries","Appetizers",40,10,2));
        Items3.add(new  Food_Item("Pepsi","Drinks",40,9,3));
        Meal meal5 = new Meal(Items3);

        Order1.add(new Order("Cairo", meal1, "07/1/6/2020", "07/2/6/2020"));
        Order2.add(new Order("Alexandria", meal2, "12/4/6/2020", "07/7/6/2020"));
        Order3.add(new Order("Giza", meal3, "15/5/6/2020", "07/2/9/2020"));
        Order4.add(new Order("Hurgada", meal4, "16/7/6/2020", "07/11/6/2020"));
        Order4.add(new Order("Luxor", meal5, "09/10/6/2020", "07/14/6/2020"));

        Users.add(new Guest("Jake", "12345", Order1));
        Users.add(new Loyalty_Customer("Anne", "12345", Order2));
        Users.add(new Guest("Micheal", "12345", Order3));
        Users.add(new Guest("Richard", "12345", Order4));

    }

    /**
     * Method used to display all data stored in each and every customer saved in the List.
     */
    static void Display()
    {
        for(int k = 0; k < Users.size(); k++)
        {
            System.out.println("Customer no." + (k+1));
            System.out.println("Name: " + Users.get(k).name + "| Password: " + Users.get(k).password);
            for(int i = 0; i < system.Users.get(k).Orders.size(); i++)
            {
                if(Current_Date.Order_received(system.Users.get(k).Orders.get(i).Deliver_Date))
                    system.Users.get(k).Orders.get(i).Status = "Received";
                System.out.println(i+1 + "- Order Code: " + system.Users.get(k).Orders.get(i).Code + " | Price: " + system.Users.get(k).Orders.get(i).Total_Cost + " | Delivery Address: " + system.Users.get(k).Orders.get(i).Delivery_Address + " | Status: " + system.Users.get(k).Orders.get(i).Status + " | Order Date: " + system.Users.get(k).Orders.get(i).Order_Date + " | Delivery Date: " + system.Users.get(k).Orders.get(i).Deliver_Date);
                for(int j = 0; j < system.Users.get(k).Orders.get(i).Food_Ordered.Items.size(); j++)
                {
                    System.out.print( system.Users.get(k).Orders.get(i).Food_Ordered.Items.get(j).getName() + " | ");
                }
                System.out.println("");
                System.out.println(system.Users.get(k).Orders.get(i).Review);
                System.out.println("");
            }
        }
    }
    /**
     * Method used as part of the UI which is the first thing the user gets to see.
     */
    static void Menu()
    {
        boolean done = false, display = false;

        Admin acc;
        Scanner Input = new Scanner(System.in);
        System.out.println("1- Costumer");
        System.out.println("2- System Admin");
        System.out.println("3- Display (Check for Name and Password of already registered Costumers)");
        int choice = Input.nextInt();
        while(!done) {
            if (choice == 1) {
                acc = new User();
                System.out.println("1- Sign Up");
                System.out.println("2- Login");
                int choice2 = Input.nextInt();
                if (choice2 == 1)
                    done = ((User) acc).Sign_Up();
                else if (choice2 == 2)
                    done = acc.Login();
            }
            else if (choice == 2) {
                acc = new Admins();
                done = acc.Login();
            }
            else if(choice == 3) {
                Display();
                display = true;
                break;
            }
        }
        if(!display) {
            if (is_Admin)
                Admin_Menu();
            else
                Customer_Menu();
        }
        display = false;
    }

    /**
     * Method used as part of the UI only available to the Admin.
     */
    static void Admin_Menu()
    {
        Scanner Input = new Scanner(System.in);
        while(true) {
            System.out.println("1- Add Food Item ");
            System.out.println("2- View Food Items ");
            System.out.println("3- Exit ");
            int choice = Input.nextInt();
            Input.nextLine();
            if (choice == 1)
                Shop_Owner.add_Item();
            else if (choice == 2)
                while(true) {
                    View_Items();
                    System.out.print("Back to Menu? (Y/N) : ");

                    String choice2 = Input.nextLine();
                    if(choice2.equals("y") || choice2.equals("Y"))
                        break;
                }
            else
                return;
        }
    }

    /**
     * Method used to pick food items to buy off the list.
     * @throws IndexOutOfBoundsException if user picks a number that isn't available in the List.
     */
    static void Pick_Item() {
        try {
            Scanner Input = new Scanner(System.in);
            System.out.print("Food's Number (0 To go back): ");
            int choice = Input.nextInt();
            if(choice == 0)
            {
                return;
            }
            Users.get(User_Index).Cart.Items.add(All_Food.get(choice - 1));
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method used to show all items available in the system.
     * @return Boolean to check if the user doesn't want to pick an item after.
     */
    static boolean View_Items()
    {
        Scanner Input = new Scanner(System.in);
        System.out.println("1- Appetizers");
        System.out.println("2- Main Dishes");
        System.out.println("3- Salads");
        System.out.println("4- Desserts");
        System.out.println("5- Drinks");
        System.out.println("6- Back");
        int choice = Input.nextInt();
        String category;
        if (choice == 1)
            category = "Appetizers";
        else if (choice == 2)
            category = "Main";
        else if (choice == 3)
            category = "Salads";
        else if (choice == 4)
            category = "Desserts";
        else if(choice == 5)
            category = "Drinks";
        else
            return false;
        for (int i = 0; i < All_Food.size(); i++)
        {
            if(All_Food.get(i).getCategory().equals(category))
            {
                System.out.println( i+1 + "-  " + All_Food.get(i).getName() + "  " + All_Food.get(i).getCategory() + "  " + All_Food.get(i).getNum_of_calories() + " Calories  " + All_Food.get(i).getPrice()+ "$  for: " + All_Food.get(i).getPortion());
            }

        }
        return true;
    }

    /**
     * Method used as part of the UI for Customers to choose from the different methods available.
     */
    static void Customer_Menu()
    {
        Scanner Input = new Scanner(System.in);
        while(true) {
            System.out.println("1- View Menu ");
            System.out.println("2- Open Cart ");
            System.out.println("3- Open Wish List ");
            System.out.println("4- Track Orders ");
            System.out.println("5- Exit ");
            int choice = Input.nextInt();
            Input.nextLine();
            if (choice == 1) {
                while(true) {
                    if(View_Items())
                        Pick_Item();
                    System.out.print("Would you like to go back? (Y/N) : ");
                    String choice2 = Input.nextLine();
                    if(choice2.equals("y") || choice2.equals("Y"))
                        break;
                }
            }
            else if (choice == 2)
                Users.get(User_Index).View_Cart();
            else if (choice == 3)
                Users.get(User_Index).WishList();
            else if (choice == 4)
                Users.get(User_Index).Order_Tracker();
            else
                return;
        }
    }

}

/**
 * Class used for the food items available.
 * Final data members used.
 */
class Food_Item {

    private final String name;
    private final String category;
    private final int num_of_calories;
    private final int price;
    private final int portion;

    /**
     * Class constructor to fill class variables.
     * @param name The Food item's name.
     * @param category The Food item's category.
     * @param num_of_calories The Food item's number of calories.
     * @param price The Food item's price.
     * @param portion The Food item's portion (Number of people).
     */
    public Food_Item(String name, String category, int num_of_calories, int price, int portion) {
        this.name = name;
        this.category = category;
        this.num_of_calories = num_of_calories;
        this.price = price;
        this.portion = portion;
    }

    /**
     * Method used to get food name.
     * @return food name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method used to get food category.
     * @return food category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Method used to get food number of calories.
     * @return food number of calories.
     */
    public int getNum_of_calories() {
        return num_of_calories;
    }

    /**
     * Method used to get food portion.
     * @return food portion.
     */
    public int getPortion() {
        return portion;
    }

    /**
     * Method used to get food price.
     * @return food price.
     */
    public int getPrice() {
        return price;
    }
}

/**
 * Class used for the meal that can be ordered or added to the wish list.
 * Uses Overloading
 */
class Meal{
    ArrayList<Food_Item> Items;

    /**
     * Constructor to initialize the List.
     */
    public Meal()
    {
        Items = new ArrayList<Food_Item>();
    }

    /**
     * Constructor to avoid passing by reference.
     * @param Items The list to be cloned.
     */
    public Meal(ArrayList<Food_Item> Items)
    {
        super();
        this.Items = (ArrayList<Food_Item>) Items.clone();
    }
}

/**
 * Class used for the Orders after submitting them.
 * Calculated data members used. (Total_Cost)
 */
class Order {
    final int Code;
    static int Code_Counter = 1;
    String Order_Date, Deliver_Date;
    final String Delivery_Address;
    Meal Food_Ordered;
    int Total_Cost = 0;
    String Status;
    String Review;

    /**
     * Class constructor used to fill class data members and give the order a unique code.
     * @param delivery_Address The delivery address submitted by the user.
     * @param Food_Ordered The list of food items ordered.
     * @param Order_Date The date of the order.
     * @param Deliver_Date The date for delivery.
     */
    public Order(String delivery_Address, Meal Food_Ordered, String Order_Date, String Deliver_Date) {
        Code = Code_Counter;
        Code_Counter++;
        Delivery_Address = delivery_Address;
        this.Food_Ordered = Food_Ordered;
        this.Order_Date = Order_Date;
        this.Deliver_Date = Deliver_Date;
        Status = "Not Received";
        Review = "";
        Total_Calculator();
    }

    /**
     * Method used to calculate the Total price of the order.
     */
    public void Total_Calculator()
    {
        Total_Cost = 0;
        for(int i = 0; i < Food_Ordered.Items.size(); i++)
        {
            Total_Cost += Food_Ordered.Items.get(i).getPrice();
        }
    }
}

/**
 * Class used for the Admin.
 */
class Shop_Owner
{
    /**
     * Method used to add items into the Food List.
     */
    static public void add_Item()
    {
        Scanner Input = new Scanner(System.in);
        System.out.print("Food Name: ");
        String name = Input.nextLine();
        System.out.print("Food Category: ");
        String category = Input.nextLine();
        System.out.print("Number of Calories: ");
        int numOfCal = Input.nextInt();
        System.out.print("Price: ");
        int price = Input.nextInt();
        System.out.print("Portion: ");
        int portion = Input.nextInt();
        Food_Item item = new Food_Item(name,category,numOfCal,price,portion);
        system.All_Food.add(item);
    }

}

/**
 * Abstract class used for the Customers data and functions.
 * Uses Inheritance.
 * Uses Final methods.
 * Uses Overloading
 * Uses Liskov Substitution Principle
 */
abstract class Customer{
    String name;
    String password;
    Meal Cart;
    ArrayList<Meal> Wish_List;
    ArrayList<Order> Orders;

    /**
     * Default class Constructor to initialize empty users.
     */
    public Customer()
    {
        this.name = "";
        this.password = "";
        Wish_List = new ArrayList<Meal>();
        Orders = new ArrayList<Order>();
        Cart = new Meal();
    }

    /**
     * Constructor used to initialize user saving their name and password.
     * @param name Customer's name.
     * @param password Customer's password.
     */
    public Customer(String name, String password)
    {
        this.name = name;
        this.password = password;
        Wish_List = new ArrayList<Meal>();
        Orders = new ArrayList<Order>();
        Cart = new Meal();
    }

    /**
     * Constructor used to initialize user using name, password and Order List.
     * @param name Customer's name.
     * @param password Customer's password.
     * @param Orders List of Orders for testing.
     */
    public Customer(String name, String password, ArrayList<Order> Orders)
    {
        this(name,password);
        this.Orders = Orders;
    }

    abstract void Create_Order();

    /**
     * Method used to cancel the order that the Customer asks to cancel.
     * @throws IndexOutOfBoundsException if user picks index not available in the list.
     * @throws Customized_Exception if user tries to cancel an order 24 hours earlier.
     */
    final void Cancel_Order()
    {
        Scanner Input = new Scanner(System.in);
        System.out.print("Which order do you want to cancel : ");
        int choice = Input.nextInt();
        try{
            if(!system.Users.get(system.User_Index).Orders.get(choice-1).Status.equals("Received")) {
                if (Current_Date.can_Cancel(system.Users.get(system.User_Index).Orders.get(choice - 1).Deliver_Date))
                    system.Users.get(system.User_Index).Orders.remove(choice - 1);
                else
                    throw new Customized_Exception("Cannot cancel order 24 hours prior to delivery date.");
            }
            else
                throw new Customized_Exception("Order already received.");
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        catch(Customized_Exception e)
        {
            System.out.println(e.message);
        }
    }

    /**
     * Method used to extend the order's delivery date or to add more items to it.
     * @throws Customized_Exception if user tries to place an earlier date.
     * @throws IndexOutOfBoundsException if user picks index not available in the list.
     */
    final void Update_Order()
    {
        Scanner Input = new Scanner(System.in);
        System.out.print("Which order do you want to update : ");
        int choice = Input.nextInt();
        try
        {
            if(system.Users.get(system.User_Index).Orders.get(choice-1).Status.equals("Not Received")) {
                System.out.println("1- Extend Delivery Date");
                System.out.println("2- Add Food Items");
                int choice2 = Input.nextInt();
                Input.nextLine();
                if(choice2 == 1)
                {
                    while(true) {
                        System.out.print("Enter new Date (HH/dd/MM/yyyy) : ");
                        String date = Input.nextLine();
                        if(Current_Date.can_update(system.Users.get(system.User_Index).Orders.get(choice-1).Deliver_Date,date)) {
                            system.Users.get(system.User_Index).Orders.get(choice - 1).Deliver_Date = date;
                            break;
                        }
                        else {
                            throw new Customized_Exception("You can only Extend the Date.");
                        }
                    }
                }
                else
                {
                    system.Users.get(system.User_Index).Cart = system.Users.get(system.User_Index).Orders.get(choice-1).Food_Ordered;
                    system.View_Items();
                    String choice3 = "y";
                    while(choice3.equals("y") || choice3.equals("Y"))
                    {
                        system.Pick_Item();
                        System.out.println("Would you like to buy more? (Y/N)");
                        choice3 = Input.nextLine();

                    }
                    Meal new_meal = new Meal(system.Users.get(system.User_Index).Cart.Items);
                    system.Users.get(system.User_Index).Orders.get(choice-1).Food_Ordered = new_meal;
                    system.Users.get(system.User_Index).Orders.get(choice-1).Total_Calculator();
                    system.Users.get(system.User_Index).Cart.Items.clear();
                }
            }
            else
            {
                throw new Customized_Exception("Order has been received.");
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        catch(Customized_Exception e)
        {
            System.out.println(e.message);
        }
    }

    /**
     * Method used to allow user to add a review after receiving and order.
     * @throws IndexOutOfBoundsException if user picks index not available in the list.
     * @throws Customized_Exception if the user didn't receive the order yet.
     */
    final void Review()
    {
        Scanner Input = new Scanner(System.in);
        System.out.print("Which order would you like to Review : ");
        int choice = Input.nextInt();
        Input.nextLine();
        try {
            if (system.Users.get(system.User_Index).Orders.get(choice - 1).Status.equals("Received")) {
                System.out.print("Your Review: ");
                String Review = Input.nextLine();
                system.Users.get(system.User_Index).Orders.get(choice - 1).Review = Review;
            } else {
                throw new Customized_Exception("The Order hasn't been received yet");
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        catch(Customized_Exception e)
        {
            System.out.println(e.message);
        }

    }

    /**
     * Method used to view all items in the cart. Giving the options to add the meal
     * to the wish list or make an order out of it.
     * @throws Customized_Exception if the user tries to buy one item only.
     */
    final void View_Cart()
    {
        for (int i = 0; i < Cart.Items.size(); i++)
        {
            System.out.println( i+1 + "-  " + Cart.Items.get(i).getName() + "  " + Cart.Items.get(i).getCategory() + "  " + Cart.Items.get(i).getNum_of_calories() + " Calories  " + Cart.Items.get(i).getPrice()+ "$  for: " + Cart.Items.get(i).getPortion());
        }

        System.out.println("\n1- Create Order");
        System.out.println("2- Add to Wish List");
        System.out.println("3- Back");
        Scanner Input = new Scanner(System.in);
        int choice = Input.nextInt();
        try {
            if ((choice == 1 || choice == 2) && Cart.Items.size() > 1) {
                if (choice == 1)
                    system.Users.get(system.User_Index).Create_Order();
                else if (choice == 2) {
                    Meal new_meal = new Meal(Cart.Items);
                    system.Users.get(system.User_Index).Wish_List.add(new_meal);
                }
            } else {
                throw new Customized_Exception("You must have more than one item in cart!");
            }
        }
        catch(Customized_Exception e)
        {
            System.out.println(e.message);
        }
        if(choice == 3)
            return;
        system.Users.get(system.User_Index).Cart.Items.clear();
    }

    /**
     * Method used to show the Customer the meals located in their wish list
     * giving the option to order them right away.
     * @throws IndexOutOfBoundsException if user picks index not available in the list.
     */
    final void WishList()
    {
        for(int i = 0; i < system.Users.get(system.User_Index).Wish_List.size(); i++)
        {
            System.out.println(i+1 +": ");
            for(int j = 0; j < system.Users.get(system.User_Index).Wish_List.get(i).Items.size(); j++)
            {
                System.out.println(system.Users.get(system.User_Index).Wish_List.get(i).Items.get(j).getName());
            }
        }
        System.out.println("Pick the meal number to order. (0 to back)");
        Scanner Input = new Scanner(System.in);
        int choice = Input.nextInt();
        if (choice == 0)
            return;
        else
        {
            try {
                Meal new_meal = new Meal(system.Users.get(system.User_Index).Wish_List.get(choice - 1).Items);
                Cart = new_meal;
                system.Users.get(system.User_Index).Create_Order();
                system.Users.get(system.User_Index).Cart.Items.clear();
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Method used to show all the Orders made by the user with their details and the food items in each.
     * Also giving the options to update , cancel or review.
     */
    final void Order_Tracker()
    {
        for(int i = 0; i < system.Users.get(system.User_Index).Orders.size(); i++)
        {
            if(Current_Date.Order_received(system.Users.get(system.User_Index).Orders.get(i).Deliver_Date))
                system.Users.get(system.User_Index).Orders.get(i).Status = "Received";
            System.out.println(i+1 + "- Order Code: " + system.Users.get(system.User_Index).Orders.get(i).Code + " | Price: " + system.Users.get(system.User_Index).Orders.get(i).Total_Cost + " | Delivery Address: " + system.Users.get(system.User_Index).Orders.get(i).Delivery_Address + " | Status: " + system.Users.get(system.User_Index).Orders.get(i).Status + " | Order Date: " + system.Users.get(system.User_Index).Orders.get(i).Order_Date + " | Delivery Date: " + system.Users.get(system.User_Index).Orders.get(i).Deliver_Date);
            for(int j = 0; j < system.Users.get(system.User_Index).Orders.get(i).Food_Ordered.Items.size(); j++)
            {
                System.out.print( system.Users.get(system.User_Index).Orders.get(i).Food_Ordered.Items.get(j).getName() + " | ");
            }
            System.out.println("");
            System.out.println(system.Users.get(system.User_Index).Orders.get(i).Review);
            System.out.println("");
        }
        System.out.println("1- Update Order");
        System.out.println("2- Cancel Order");
        System.out.println("3- Review Order");
        System.out.println("4- Back");
        Scanner Input = new Scanner(System.in);
        int choice = Input.nextInt();
        if(choice == 1)
            Update_Order();
        else if(choice == 2)
            Cancel_Order();
        else if (choice == 3)
            Review();
        else
            return;
    }
}

/**
 * Subclass of Customer contains special privilege for Loyal Customers.
 * Uses Overloading.
 * Uses Overriding
 */
class Loyalty_Customer extends Customer{

    /**
     * Constructor to fill name and password of the user.
     * @param name Customer's name.
     * @param password Customer's password.
     */
    public Loyalty_Customer(String name, String password) {
        super(name, password);
    }

    /**
     * Default Constructor to initialize data members.
     */
    public Loyalty_Customer()
    {
        this.name = "";
        this.password = "";
        Wish_List = new ArrayList<Meal>();
        Orders = new ArrayList<Order>();
        Cart = new Meal();
    }

    /**
     * Constructor used for the Guest to Loyal transition.
     * @param guest_user The Guest Customer.
     */
    public Loyalty_Customer(Customer guest_user)
    {
        this.name = guest_user.name;
        this.Orders = guest_user.Orders;
        this.password = guest_user.password;
        this.Cart = guest_user.Cart;
        this.Wish_List = guest_user.Wish_List;
    }
    /**
     * Constructor used to initialize user using name, password and Order List.
     * @param name Customer's name.
     * @param password Customer's password.
     * @param Orders List of Orders for testing.
     */
    public Loyalty_Customer(String name, String password, ArrayList<Order> Orders)
    {
        super(name,password);
        this.Orders = Orders;
    }

    @Override
    /**
     * Method used to submit order creation adding 2 appetizers and one drink for the Loyal customer and
     * submitting all order details.
     */
    void Create_Order() {
        Food_Item app1 = new Food_Item("Nuggets", "Appetizers", 70, 0, 2);
        Food_Item app2 = new Food_Item("Chicken Wings", "Appetizers", 50, 0, 2);
        Food_Item drink = new Food_Item("Pepsi", "Drinks", 40, 0, 2);

        Cart.Items.add(app1);
        Cart.Items.add(app2);
        Cart.Items.add(drink);

        Scanner Input = new Scanner(System.in);

        System.out.print("Delivery Address: ");
        String address = Input.nextLine();
        System.out.print("Delivery Date (HH/dd/MN/yyyy): ");
        String Delivery_Date = Input.nextLine();
        Meal new_meal = new Meal(Cart.Items);
        while(true) {
                if (!Current_Date.Order_received(Delivery_Date)) {
                    SimpleDateFormat Formatter = new SimpleDateFormat("HH/dd/MM/yyyy");
                    Date Current_Date = new Date();
                    Order new_order = new Order(address, new_meal, Formatter.format(Current_Date), Delivery_Date);
                    this.Orders.add(new_order);
                    break;
                }
                else
                    System.out.println("Invalid Date.");
           }
    }

}

/**
 * Subclass of Customer for guest customers.
 * Uses Overriding
 * Uses Overloading
 */
class Guest extends Customer {

    /**
     * Constructor used to fill name and password.
     *
     * @param name     Customer's name.
     * @param password Customer's password.
     */
    public Guest(String name, String password) {
        super(name, password);
    }

    /**
     * Default constructor to initialize data members.
     */
    public Guest() {
        this.name = "";
        this.password = "";
        Wish_List = new ArrayList<Meal>();
        Orders = new ArrayList<Order>();
        Cart = new Meal();
    }

    /**
     * Constructor used to initialize user using name, password and Order List.
     * @param name Customer's name.
     * @param password Customer's password.
     * @param Orders List of Orders for testing.
     */
    public Guest(String name, String password, ArrayList<Order> Orders)
    {
        super(name,password);
        this.Orders = Orders;
    }

    @Override
    /**
     * Method used to submit order creation checking if the user made 3 orders to make them a loyal customer and also
     * submits all order details.
     */
    void Create_Order() {
        Scanner Input = new Scanner(System.in);
        System.out.print("Delivery Address: ");
        String address = Input.nextLine();
        System.out.print("Delivery Date (HH/dd/MN/yyyy): ");
        String Delivery_Date = Input.nextLine();
        SimpleDateFormat Formatter = new SimpleDateFormat("HH/dd/MM/yyyy");
        Date Current_Dates = new Date();

        Meal new_meal = new Meal(Cart.Items);
        while (true) {
            if (!Current_Date.Order_received(Delivery_Date))
            {
                Order new_order = new Order(address, new_meal, Formatter.format(Current_Dates), Delivery_Date);
                this.Orders.add(new_order);
                if (Orders.size() == 3)
                {
                    System.out.println("Congratulations! You are now a Loyal Customer.");
                    Loyalty_Customer loyal = new Loyalty_Customer(system.Users.get(system.User_Index));
                    system.Users.set(system.User_Index, loyal);
                }
                break;
            }
            else
                System.out.println("Invalid Date");

        }

    }
}

/**
 * Class used for Operations related to the date.
 * Uses static data members.
 */
class Current_Date {
    static SimpleDateFormat Formatter = new SimpleDateFormat("HH/dd/MM/yyyy");
    static Date Current_Dates;
    static String Current;
    static String[] array;
    static int hour;
    static int day;
    static int month;
    static int year;

    /**
     * Constructor used to initialize all data members with the current date.
     */
    public Current_Date() {
        Current_Dates = new Date();
        Current = Formatter.format(Current_Dates);
        array = Current.split("/");
        hour = Integer.parseInt(array[0]);
        day = Integer.parseInt(array[1]);
        month = Integer.parseInt(array[2]);
        year = Integer.parseInt(array[3]);
    }

    /**
     * Method to check if the Order has been received.
     * @param Delivery_Date The order's Delivery date.
     * @return Boolean as true if current date/time passes delivery date/time.
     */
    public static boolean Order_received(String Delivery_Date) {
        new Current_Date();
        String[] new_array = Delivery_Date.split("/");
        int new_hour = Integer.parseInt(new_array[0]);
        int new_day = Integer.parseInt(new_array[1]);
        int new_month = Integer.parseInt(new_array[2]);
        int new_year = Integer.parseInt(new_array[3]);

        if (year == new_year) {
            if (month == new_month) {
                if (day == new_day) {
                    if (hour < new_hour)
                        return false;
                    else
                        return true;
                } else if (day < new_day)
                    return false;
                else
                    return true;
            } else if (month < new_month)
                return false;
            else
                return true;
        } else if (year < new_year)
            return false;
        else
            return true;
    }

    /**
     * Method to check if the user can cancel an order according to the 24 hour rule.
     * @param Delivery_Date The order's Delivery date.
     * @return Boolean as true if the difference between current date/time and Delivery date is equal or more than 24.
     */
    public static boolean can_Cancel(String Delivery_Date) {
        new Current_Date();
        String[] new_array = Delivery_Date.split("/");
        int new_hour = Integer.parseInt(new_array[0]);
        int new_day = Integer.parseInt(new_array[1]);
        int new_month = Integer.parseInt(new_array[2]);
        int new_year = Integer.parseInt(new_array[3]);
        if (year == new_year) {
            if (month == new_month) {
                if (new_day - day > 1)
                    return true;
                else if (new_day - day == 1) {
                    if ((24 - hour) + new_hour >= 24)
                        return true;
                    else
                        return false;
                } else
                    return false;
            } else if (month < new_month)
                return true;
            else
                return false;
        } else if (year < new_year)
            return true;
        else
            return false;
    }

    /**
     * Method to check if the date added by the user exceed the current Delivery date.
     * @param Delivery_Date Order's Delivery date.
     * @param updated_Date New date added by the Customer.
     * @return Boolean as true if updated date exceeds delivery date.
     */
    public static boolean can_update(String Delivery_Date, String updated_Date) {
        new Current_Date();

        String[] new_array = Delivery_Date.split("/");

        int new_hour = Integer.parseInt(new_array[0]);
        int new_day = Integer.parseInt(new_array[1]);
        int new_month = Integer.parseInt(new_array[2]);
        int new_year = Integer.parseInt(new_array[3]);

        String[] new_array2 = updated_Date.split("/");

        int new_hour2 = Integer.parseInt(new_array2[0]);
        int new_day2 = Integer.parseInt(new_array2[1]);
        int new_month2 = Integer.parseInt(new_array2[2]);
        int new_year2 = Integer.parseInt(new_array2[3]);

        if (new_year2 == new_year) {
            if (new_month2 == new_month) {
                if (new_day == new_day2) {
                    if (new_hour < new_hour2)
                        return true;
                    else
                        return false;
                } else if (new_day < new_day2)
                    return true;
                else
                    return false;
            } else if (new_month < new_month2)
                return true;
            else
                return false;
        } else if (new_year < new_year2)
            return true;
        else
            return false;
    }
}

/**
 * Exception class used to throw exceptions if certain conditions apply.
 */
class Customized_Exception extends Exception
{
    String message;
    public Customized_Exception(String msg)
    {
        message = msg;
    }
}