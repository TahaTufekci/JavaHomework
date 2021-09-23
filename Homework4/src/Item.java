
public class Item {
    // Taha Tüfekçi 150119050
    // The purpose of the program is to  implement a factory simulator program with object-oriented approach.
    private int id;
    public static int numberOfItems;

    public Item(int id) {
        this.id = id;
        numberOfItems++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}

