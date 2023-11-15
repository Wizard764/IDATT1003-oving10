package Main;

public class Dish
{
    private final String name;
    private final String type;
    private final String recipe;
    private final int price;
    public Dish(String name, String type, String recipe, int price)
    {
        this.name = name;
        this.type = type;
        this.recipe = recipe;
        this.price = price;
    }
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public String getRecipe()
    {
        return recipe;
    }
    public int getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return "Name: " + name + ", Type: " + type + ", Price: " + Integer.toString(price) + ", Recipe: " + recipe;
    }
}