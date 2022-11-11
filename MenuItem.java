public class MenuItem
{
    enum Type
    {
        DRINK, FOOD;
    }

    private String item;
    private int price;
    private Type type;

    public MenuItem(String item, Type type, int price)
    {
        this.item = item;
        this.type = type;
        this.price = price;
    }

    public int getPrice()
    {
        return this.price;
    }

    public String getItem()
    {
        return this.item;
    }

    public Type getType()
    {
        return this.type;
    }
}
