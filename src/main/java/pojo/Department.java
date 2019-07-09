package pojo;

public class Department {
    private int rownum;
    private int id;
    private String name;
    private String address;
    private int totalPeople;
    private int maxWage;
    private int minWage;
    private int totalSalary;
    private double avgSalary;

    public int getRownum() {
        return rownum;
    }

    public void setRownum(int rownum) {
        this.rownum = rownum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(int totalPeople) {
        this.totalPeople = totalPeople;
    }

    public int getMaxWage() {
        return maxWage;
    }

    public void setMaxWage(int maxWage) {
        this.maxWage = maxWage;
    }

    public int getMinWage() {
        return minWage;
    }

    public void setMinWage(int minWage) {
        this.minWage = minWage;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }
}
