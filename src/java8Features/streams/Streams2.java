package java8Features.streams;

import java.util.*;
import java.util.stream.Collectors;

class User {
    private String name;
    private boolean active;

    public User(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }
}

public class Streams2 {
    public static void main(String[] args) {

        // Input data
        List<User> users = Arrays.asList(
                new User("X", true),
                new User("Y", true),
                new User("Z", true),
                new User("A", true),
                new User("X", true),   // duplicate
                new User("B", false),
                new User("C", false)
        );

        // Distinct active users sorted alphabetically
        List<String> result =
                users.stream()
                        .filter(User::isActive)
                        .map(User::getName)
                        .distinct()
                        .sorted()
                        .collect(Collectors.toList());

        System.out.println("Distinct Active Users (Sorted): " + result);

        // Count active vs inactive users
        Map<Boolean, Long> countMap =
                users.stream()
                        .collect(Collectors.partitioningBy(
                                User::isActive,
                                Collectors.counting()
                        ));

        System.out.println("Active Users Count: " + countMap.get(true));
        System.out.println("Inactive Users Count: " + countMap.get(false));

        System.out.println();
    }
}