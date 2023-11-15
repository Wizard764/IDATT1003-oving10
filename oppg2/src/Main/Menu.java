package Main;

public class Menu
{
    private String name;
    Dish[] dishes;
    Menu(String name, Dish[] dishes)
    {
        this.dishes = dishes;
        this.name = name;
    }
    int GetPrice()
    {
        int sum = 0;
        for(Dish dish : dishes)
        {
            sum += dish.getPrice();
        }
        return sum;
    }
    @Override
    public String toString()
    {
        String out = name;
        for(Dish dish : dishes)
        {
            out += "\n" + dish.toString();
        }
        return out;
    }
}