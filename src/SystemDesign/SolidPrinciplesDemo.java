package SystemDesign;

/*
    Problems:
    1.Maintainability
    2.Readability
    3.BUGS

    SOLID ->
    S - Single Responsibility Principle (SRP)
    O - Open-close principle (OCP)
    L - Liskov Substitution
    I - Interface segregation
    D - Dependency Inversion

    1. Single Responsibility principle:
        A class should have only one reason to change
        Class handle single responsibility
        A class should do only one thing

    2. Open-close principle:
    A class should be open for extension but close for modification.


 */
// ONE FILE – Demonstrates all SOLID principles

public class SolidPrinciplesDemo {

    public static void main(String[] args) {

        User user = new User("Kaushal", "kaushal@email.com");

        // D – Dependency Inversion
        UserRepository repository = new DatabaseUserRepository();
        NotificationService notificationService = new EmailNotificationService();
        Logger logger = new ConsoleLogger();

        UserService userService =
                new UserService(repository, notificationService, logger);

        userService.registerUser(user);
    }
}

/* ===========================
   S – Single Responsibility
   =========================== */

// Only holds user data
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}

// Only logging responsibility
interface Logger {
    void log(String message);
}

class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

/* ===========================
   O – Open / Closed Principle
   =========================== */

// Open for extension, closed for modification
interface NotificationService {
    void notifyUser(User user);
}

// New notification types can be added WITHOUT changing existing code
class EmailNotificationService implements NotificationService {
    public void notifyUser(User user) {
        System.out.println("Email sent to: " + user.getEmail());
    }
}

class SmsNotificationService implements NotificationService {
    public void notifyUser(User user) {
        System.out.println("SMS sent to: " + user.getName());
    }
}


/* ===========================
   L – Liskov Substitution
   =========================== */

// Any implementation can replace UserRepository safely
interface UserRepository {
    void save(User user);
}

class DatabaseUserRepository implements UserRepository {
    public void save(User user) {
        System.out.println("User saved in database: " + user.getName());
    }
}

class InMemoryUserRepository implements UserRepository {
    public void save(User user) {
        System.out.println("User saved in memory: " + user.getName());
    }
}

/* ===========================
   I – Interface Segregation
   =========================== */

// Small, specific interfaces
interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

// Printer only prints
class SimplePrinter implements Printable {
    public void print() {
        System.out.println("Printing document");
    }
}

// Multi-function device
class MultiFunctionPrinter implements Printable, Scannable {
    public void print() {
        System.out.println("Printing document");
    }

    public void scan() {
        System.out.println("Scanning document");
    }
}

/* ===========================
   D – Dependency Inversion
   =========================== */

// High-level module depends on abstractions
class UserService {

    private UserRepository repository;
    private NotificationService notificationService;
    private Logger logger;

    public UserService(UserRepository repository,
                       NotificationService notificationService,
                       Logger logger) {

        this.repository = repository;
        this.notificationService = notificationService;
        this.logger = logger;
    }

    public void registerUser(User user) {
        repository.save(user);
        notificationService.notifyUser(user);
        logger.log("User registered successfully");
    }
}

