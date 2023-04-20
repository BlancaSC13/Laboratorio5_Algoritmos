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
                "id=" + id +
                ", description='" + description + '\'' +
                ", hourlyWage=" + hourlyWage +
                '}';
    }
}
