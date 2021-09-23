public class Factory {
    // Taha Tüfekçi 150119050
    // The purpose of the program is to  implement a factory simulator program with object-oriented approach.
    private String name;
    private Employee[] employees;
    private Storage storage;
    private Payroll[] payrolls;
    private double itemPrice;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Employee[] getEmployees() {
        return employees;
    }
    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
    public Storage getStorage() {
        return storage;
    }
    public void setStorage(Storage storage) {
        this.storage = storage;
    }
    public Payroll[] getPayrolls() {
        return payrolls;
    }
    public void setPayrolls(Payroll[] payrolls) {
        this.payrolls = payrolls;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }


    public Factory(String name, int capacity, double itemPrice){
        this.name = name;
        this.itemPrice = itemPrice;
        this.storage = new Storage(capacity);
        this.employees = new Employee[0];
        this.payrolls = new Payroll[0];

    }
    public double getRevenue() {
        // Calculate revenue
        return itemPrice * Item.numberOfItems;

    }
    public double getPaidSalaries() {
        // Calculate the paid salaries of the employees
        double sum = 0 ;
        for(int i = 0 ; i < payrolls.length;i++) {
            sum += payrolls[i].calculateSalary();
        }
        return sum;

    }
    public void addEmployee(Employee employee) {

        Employee[] tempArray = new Employee[this.employees.length+1];

        for(int i = 0; i < this.employees.length; i++){
            tempArray[i] = this.employees[i];
        }

        tempArray[tempArray.length-1] = employee;

        this.employees = tempArray;

        Item[] employeeItems = employee.startShift();

        for(int i = 0; i < employeeItems.length; i++){
            this.storage.addItem(employeeItems[i]);
        }

    }

    public Employee removeEmployee(int id ) {

        Employee removedEmployee = null;

        if(this.employees.length == 0){
            System.out.println("There are no employees!");
            return removedEmployee;
        }

        boolean flag = false;

        for(int i = 0 ; i < this.employees.length;i++){
            if(employees[i].getId() == id){
                flag = true;
                removedEmployee = employees[i];

                Employee[] newArray = new Employee[this.employees.length-1];


                for(int a = 0, b = 0; a < newArray.length; a++ , b++){
                    if(i == b){
                        a--;
                        continue;
                    }
                    newArray[a] = this.employees[b];
                }
                this.employees = newArray;

                break;
            }
        }

        if(flag == false){
            System.out.println("Employee does not exist !");
        }

        if(removedEmployee != null){
            Payroll payroll = removedEmployee.endShift();
            addPayroll(payroll);
        }

        return removedEmployee;

    }

    private void addPayroll(Payroll payroll) {

        Payroll[] tempPayrollArray = new Payroll[this.payrolls.length+1];

        for(int i = 0 ; i < this.payrolls.length; i++){
            tempPayrollArray[i] = this.payrolls[i];
        }

        tempPayrollArray[tempPayrollArray.length-1] = payroll;

        this.payrolls = tempPayrollArray;

    }

}

