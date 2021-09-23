
public class Employee {
    // Taha Tüfekçi 150119050
    // The purpose of the program is to  implement a factory simulator program with object-oriented approach.
    private int id;
    private int workHour;
    private int speed;
    private String name;
    private String surname;
    private Item[] items;
    private Payroll payroll;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkHour() {
        return this.workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Item[] getItems() {
        return this.items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Payroll getPayroll() {
        return this.payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public Employee(int id, String name, String surname, int workHour, int speed) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.speed = speed;
        this.workHour = workHour;
        this.items = new Item[this.workHour * this.speed];
        Payroll payroll = new Payroll(this.workHour, this.items.length);
        this.payroll = payroll;
    }

    public Item[] startShift() {
        // Employee should produce items according to the calculation
        int need_item = this.workHour * this.speed;

        for(int i = 0; i < need_item; ++i) {
            Item produce_item = new Item((int)(Math.random() * 100.0D));
            this.items[i] = produce_item;
        }

        return this.items;
    }

    public Payroll endShift() {
        int item_count = this.getPayroll().getItemCount();
        Payroll payroll1 = new Payroll(this.workHour, this.getPayroll().getItemCount());
        this.payroll = payroll1;
        return payroll1;
    }

    public String toString() {
        int need_item = this.workHour * this.speed;
        // Display information about employee
        return "This is the employee with id " + this.id + " speed " + this.speed + ". The work hour is " + this.workHour + " and the produced item count is " + need_item + " .";
    }
}
