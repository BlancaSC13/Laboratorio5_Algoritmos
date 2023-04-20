package domain;

import util.Utility;

import java.util.Date;

public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String title;
    private java.util.Date birthday;

    public Employee(int id, String lastName, String firstName, String title, Date birthday) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
        this.birthday = birthday;
    }

    public int getAge() {
        return Utility.getAge(birthday);//realizar método
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", title='" + title + '\'' +
                ", birthday=" + util.Utility.dateFormat(birthday) +
                ",Age: " + getAge()
                + '}';
    }
}
