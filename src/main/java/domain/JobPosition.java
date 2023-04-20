package domain;

import java.util.Date;

public class JobPosition {
    private int id;
    private String description;
    private double hourlyWage;
    private static int autoid;

    public JobPosition(String description, double hourlyWage) {
        this.id = ++autoid;//autogenerado
        this.description = description;
        this.hourlyWage = hourlyWage;
    }

    public double getSalary(double n) {
        return n * hourlyWage;
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "Code=" + id +
                ", Description='" + description + '\'' +
                ", Hourly Wage=" + hourlyWage +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
