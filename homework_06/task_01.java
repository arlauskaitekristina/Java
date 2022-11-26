package homework_06;

public class task_01 {
    public static void main(String[] args) {
        Products book = new NewItem()
                .setCount(1)
                .setName("Andrey")
                .setprice(80)
                .create();

        Products notebooks = new NewItem()
                .setCount(2)
                .setName("Marina")
                .setprice(150)
                .setdescription("Subjects for school")
                .create();

        Products nothing = new NewItem()
                .create();

        book.print();
        notebooks.print();
        nothing.print();
    }
}

class Products {
    public int count;
    public String name;
    public double price;
    public String description;

    public void print() {
        System.out.println(
                String.format(
                        "Name: %s\nPrice: %.3f\nCount: %d\nDescription: %s\n",
                        name,
                        price,
                        count,
                        description));
    }
}

class NewItem {
    Products newItem;

    public NewItem() {
        newItem = new Products();
        newItem.count = 0;
        newItem.name = "---";
        newItem.price = 0;
        newItem.description = "---";
    }

    public NewItem setCount(int count) {
        newItem.count = count;
        return this;
    }

    public NewItem setprice(int price) {
        newItem.price = price;
        return this;
    }

    public NewItem setName(String name) {
        newItem.name = name;
        return this;
    }

    public NewItem setdescription(String description) {
        newItem.description = description;
        return this;
    }

    public Products create() {
        return newItem;
    }
}