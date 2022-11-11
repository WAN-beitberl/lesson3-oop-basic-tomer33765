
public class CoffeeShop
{
    private String name;
    private MenuItem[] menu;
    private MenuItem[] orders;
    private int nextOrderIndex;

    public CoffeeShop(String name, MenuItem[] menu)
    {
        this.nextOrderIndex = 0;
        this.name = name;
        this.menu = new MenuItem[menu.length];

        for (int i = 0; i < menu.length; i++)
        {
            this.menu[i] = menu[i];
        }

        this.orders = new MenuItem[100];
    }

    // addOrder: adds the name of the item to the end of the orders array
    // if it exists on the menu. Otherwise, return "This item is currently unavailable!"
    public void addOrder(String item)
    {
        int i;
        MenuItem itemForOrder = this.menu[0];

        for (i = 0; i < this.menu.length; i++)
        {
            if (this.menu[i].getItem().equals(item))
            {
                itemForOrder = this.menu[i];
                break;
            }
        }

        if (i == this.menu.length)
        {
            System.out.println("This item is currently unavailable!");
        }

        else
        {
            orders[this.nextOrderIndex] = itemForOrder;
            this.nextOrderIndex++;
        }
    }

    // fulfillOrder: if the orders array is not empty, return "The {item} is ready!".
    // If the orders array is empty, return "All orders have been fulfilled!"
    public void fulfillOrder()
    {
        // if array is not empty
        if (this.nextOrderIndex > 0)
        {
            MenuItem item = this.orders[this.nextOrderIndex - 1];
            this.orders[this.nextOrderIndex - 1] = null;
            System.out.println(String.format("The %s is ready!", item.getItem()));
            this.nextOrderIndex--;
        }

        else
        {
            System.out.println("All orders have been fulfilled!");
        }
    }

    // listOrders: returns the list of orders taken, otherwise, an empty array.
    public String[] listOrders()
    {
        String[] Items = new String[this.nextOrderIndex];

        for (int i = 0; i < this.nextOrderIndex; i++)
        {
            Items[i] =  this.orders[i].getItem();
        }

        return Items;
    }

    // dueAmount: returns the total amount due for the orders taken.
    public int dueAmount()
    {
        int sum = 0;

        for (int i = 0; i < this.nextOrderIndex; i++)
        {
            sum += this.orders[i].getPrice();
        }

        return sum;
    }

    // cheapestItem: returns the name of the cheapest item on the menu.
    public String cheapestItem()
    {
        int min = Integer.MAX_VALUE;
        String nameOfCheapest = "";

        for (int i = 0; i < this.menu.length; i++)
        {
            if (min > this.menu[i].getPrice())
            {
                min = this.menu[i].getPrice();
                nameOfCheapest = this.menu[i].getItem();
            }
        }

        return nameOfCheapest;
    }


    // drinksOnly: returns only the item names of type drink from the menu.
    public String[] drinksOnly()
    {
        String[] Items = new String[this.menu.length];

        for (int i = 0; i < this.menu.length; i++)
        {
            if (this.menu[i].getType() == MenuItem.Type.DRINK)
            {
                Items[i] =  this.menu[i].getItem();
            }
        }

        return Items;
    }

    // foodOnly: returns only the item names of type food from the menu.
    public String[] foodOnly()
    {
        String[] Items = new String[this.menu.length];

        for (int i = 0; i < this.menu.length; i++)
        {
            if (this.menu[i].getType() == MenuItem.Type.FOOD)
            {
                Items[i] =  this.menu[i].getItem();
            }
        }

        return Items;
    }
}


