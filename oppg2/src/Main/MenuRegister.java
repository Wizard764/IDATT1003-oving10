package Main;

import java.security.interfaces.DSAKey;
import java.util.ArrayList;
public class MenuRegister
{
    ArrayList<Dish> dishes;
    ArrayList<Menu> menus;
    MenuRegister()
    {
        dishes = new ArrayList<Dish>();
        menus = new ArrayList<Menu>();
    }
    void AddDish(String name, String type, String recipe, int price)
    {
        dishes.add(new Dish(name, type, recipe, price));
    }
    Dish getDish(String name)
    {
        for(Dish dish : dishes)
        {
            if(dish.getName().equals(name))
            {
                return dish;
            }
        }
        return new Dish("Not found", "nAn", "nAn", 0);
    }
    Dish[] GetDishesOfType(String type)
    {
        ArrayList<Dish> temp = new ArrayList<Dish>();
        for(Dish dish : dishes)
        {
            if(dish.getType().equals(type))
            {
                temp.add(dish);
            }
        }
        Dish[] res = new Dish[temp.size()];
        for(int i = 0; i < temp.size(); i++)
        {
            res[i] = temp.get(i);
        }
        return res;
    }
    void AddMenu(String menuName, String[] dishes)
    {
        ArrayList<Dish> temp = new ArrayList<Dish>();
        for(String name : dishes)
        {
            boolean notFound = true;
            for(Dish dish : this.dishes)
            {
                if(dish.getName().equals(name))
                {
                    temp.add(dish);
                    notFound = false;
                    break;
                }
            }
            if(notFound)
            {
                temp.add(new Dish("Not found", "nAn", "nAn", 0));
            }
        }
        Dish[] res = new Dish[temp.size()];
        for(int i = 0; i < temp.size(); i++)
        {
            res[i] = temp.get(i);
        }
        menus.add(new Menu(menuName, res));
    }
    Menu[] GetMenusWithinPriceRange(int min, int max)
    {
        ArrayList<Menu> temp = new ArrayList<Menu>();
        for(Menu menu : menus)
        {
            if(menu.GetPrice() >= min && menu.GetPrice() <= max)
            {
                temp.add(menu);
            }
        }
        Menu[] res = new Menu[temp.size()];
        for(int i = 0; i < temp.size(); i++)
        {
            res[i] = temp.get(i);
        }
        return res;
    }
}