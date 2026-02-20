import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import StudentLogin.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserApp {
    private static final String FILE_NAME = "Users.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static List<User> users = new ArrayList<>();
    private static List<Integer> userID = new ArrayList<>();

    public static void main(String[] args) {

        loadFromFile();
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Sign In");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.println("4. Show Users data");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addUser(scanner,random);
                    break;
                case 2:
                    System.out.println("Enter Id");
                    int id =scanner.nextInt();
                    if(checkUser(id)!=null)
                {System.out.println("Enter Password");
                    int pwd =scanner.nextInt();
                    if(pwd==checkUser(id).getPassword()){
                        System.out.println("Welcome!!!!");
                    }
                 }
                else{System.out.println("Non existing user");}
                    break;
                case 3:

                    System.out.println("Data saved. Exiting...");
                    return;
                case 4:
                    viewUsers();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addUser(Scanner scanner,Random random) {

        int randomNumber ;
        while (true){
            randomNumber= random.nextInt(100) + 1;
            if(!userID.contains(randomNumber)){
                break;
            }
        }


        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Password: ");
        int pwd = scanner.nextInt();

        users.add(new User(randomNumber, name, pwd));
        saveToFile();
        System.out.println("Student added successfully!");
        System.out.println("Name: "+name);
        System.out.println("Id: "+ randomNumber);

    }

    private static void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        users.forEach(student-> System.out.println(student));
    }

    private static User checkUser(int id){
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    private static void saveToFile() {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(FILE_NAME), users);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                users = mapper.readValue(
                        file,
                        new TypeReference<List<User>>() {}
                );
                userID.clear(); // clear old IDs
                users.forEach(user -> userID.add(user.getId()));
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

}

