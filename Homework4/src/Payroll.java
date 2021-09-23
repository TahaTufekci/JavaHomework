

public class Payroll {
    // Taha Tüfekçi 150119050
    // The purpose of the program is to  implement a factory simulator program with object-oriented approach.
    private int workHour;
    private int itemCount;

    Payroll(int workHour, int itemCount) {
        this.workHour = workHour;
        this.itemCount = itemCount;
    }

    public int getWorkHour() {
        return this.workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int calculateSalary() {
        // Calculate salary with this calculation
        return this.workHour * 3 + this.itemCount * 2;
    }

    public String toString() {
        return "The work hour is " + this.workHour + " and the produced item count is " + this.itemCount + ".";
    }
}

