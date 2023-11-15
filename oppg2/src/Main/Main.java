package Main;

public class Main
{
    public static void main(String[] args)
    {
        MenuRegister mr = new MenuRegister();
        mr.AddDish("Spaghetti Bolognese", "Main course", "[Simple recipe]", 189);
        mr.AddDish("Chicken Alfredo", "Main course", "[Simple recipe]", 149);
        mr.AddDish("Margherita Pizza", "Appetizer", "[Simple recipe]", 129);
        mr.AddDish("Caesar Salad", "Salad", "[Simple recipe]", 99);
        mr.AddDish("Beef Tacos", "Main course", "[Simple recipe]", 119);
        mr.AddDish("Chocolate Fondue", "Dessert", "[Simple recipe]", 79);
        mr.AddDish("Vegetable Stir-Fry", "Main course", "[Simple recipe]", 139);
        mr.AddDish("Mango Lassi", "Beverage", "[Simple recipe]", 49);
        mr.AddDish("Grilled Salmon", "Main course", "[Simple recipe]", 169);
        mr.AddDish("Garlic Bread", "Appetizer", "[Simple recipe]", 69);
        mr.AddDish("Tiramisu", "Dessert", "[Simple recipe]", 129);
        mr.AddDish("Chicken Parmesan", "Main course", "[Simple recipe]", 159);
        mr.AddDish("Caprese Salad", "Salad", "[Simple recipe]", 89);
        mr.AddDish("Shrimp Scampi", "Main course", "[Simple recipe]", 179);
        mr.AddDish("Crispy Calamari", "Appetizer", "[Simple recipe]", 119);
        mr.AddDish("Mushroom Risotto", "Main course", "[Simple recipe]", 139);
        mr.AddDish("Lemon Sorbet", "Dessert", "[Simple recipe]", 59);
        mr.AddDish("Spinach and Artichoke Dip", "Appetizer", "[Simple recipe]", 109);
        mr.AddDish("Tandoori Chicken", "Main course", "[Simple recipe]", 149);
        mr.AddDish("Mojito", "Beverage", "[Simple recipe]", 79);

        System.out.println(mr.getDish("Beef Tacos"));
        System.out.println(mr.getDish("Chicken Alfredo"));
        System.out.println(mr.getDish("Margherita Pizza"));
        System.out.println(mr.getDish("Mojito"));
        System.out.println(mr.getDish("Lemon Sorbet"));

        mr.AddMenu("Menu 1", new String[]{"Crispy Calamari", "Shrimp Scampi", "Lemon Sorbet"});
        mr.AddMenu("Menu 2", new String[]{"Spaghetti Bolognese", "Caesar Salad", "Tiramisu"});
        mr.AddMenu("Menu 3", new String[]{"Chicken Parmesan", "Garlic Bread", "Mojito"});
        mr.AddMenu("Menu 4", new String[]{"Margherita Pizza", "Caprese Salad", "Lemon Sorbet"});
        mr.AddMenu("Menu 5", new String[]{"Beef Tacos", "Tandoori Chicken", "Mango Lassi"});
        mr.AddMenu("Menu 6", new String[]{"Grilled Salmon", "Vegetable Stir-Fry", "Chocolate Fondue"});
        mr.AddMenu("Menu 7", new String[]{"Shrimp Scampi", "Mushroom Risotto", "Tiramisu"});
        mr.AddMenu("Menu 8", new String[]{"Crispy Calamari", "Spinach and Artichoke Dip", "Mojito"});
        mr.AddMenu("Menu 9", new String[]{"Chicken Alfredo", "Tandoori Chicken", "Tiramisu"});
        mr.AddMenu("Menu 10", new String[]{"Chicken Parmesan", "Margherita Pizza", "Mango Lassi"});

        System.out.println();
        System.out.println(new Menu("Dishes of type 'Main course':", mr.GetDishesOfType("Main course")).toString());
        System.out.println();
        System.out.println(new Menu("Dishes of type 'Appetizer':", mr.GetDishesOfType("Appetizer")).toString());
        System.out.println();
        System.out.println(new Menu("Dishes of type 'Dessert':", mr.GetDishesOfType("Dessert")).toString());

        System.out.println();
        System.out.println("Menus with a price between 300 and 600");
        Menu[] tempMenus = mr.GetMenusWithinPriceRange(300, 350);
        for(Menu menu: tempMenus)
        {
            System.out.println(menu.toString());
            System.out.println("Total price: " + menu.GetPrice());
        }
    }
}