
public class Storage {
    // Taha Tüfekçi 150119050
    // The purpose of the program is to  implement a factory simulator program with object-oriented approach.
    private int capacity;
    private Item[] items;

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Item[] getItems() {
        return this.items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Storage(int capacity) {
        this.capacity = capacity;
        this.items = new Item[0];
    }

    public void addItem(Item item) {
        // Add item to the items data field
        Item[] tempItemArray = new Item[this.items.length + 1];

        for(int i = 0; i < this.items.length; ++i) {
            tempItemArray[i] = this.items[i];
        }
        tempItemArray[tempItemArray.length - 1] = item;
        this.items = tempItemArray;
    }
}
