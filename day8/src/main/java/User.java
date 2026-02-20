import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private int password;



    public User(int id, String name, int password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPassword() { return password; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}
