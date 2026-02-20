package StudentLogin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private double marks;



    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}
