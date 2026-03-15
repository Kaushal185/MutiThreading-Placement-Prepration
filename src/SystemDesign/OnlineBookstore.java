package SystemDesign;

import java.util.*;

// ---------- ENUMS ----------

enum OrderStatus {
    CREATED, PAID, SHIPPED, DELIVERED, CANCELLED
}

enum PaymentStatus {
    SUCCESS, FAILED
}

// ---------- ENTITIES ----------

class Book {
    String isbn;
    String title;
    String author;
    String subject;
    double price;

    Book(String isbn, String title, String author, String subject, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.price = price;
    }
}

class Patron {
    String id;
    String name;
    String email;
    List<Order> orderHistory = new ArrayList<>();

    Patron(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

class OrderItem {
    Book book;
    int quantity;

    OrderItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }
}

class Payment {
    double amount;
    PaymentStatus status;

    Payment(double amount) {
        this.amount = amount;
    }

    boolean processPayment() {
        // Mock payment success
        status = PaymentStatus.SUCCESS;
        return true;
    }
}

class Order {
    String orderId;
    Patron patron;
    List<OrderItem> items;
    OrderStatus status;
    Payment payment;

    Order(String orderId, Patron patron, List<OrderItem> items) {
        this.orderId = orderId;
        this.patron = patron;
        this.items = items;
        this.status = OrderStatus.CREATED;
    }

    double getTotalAmount() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.book.price * item.quantity;
        }
        return total;
    }
}

// ---------- SERVICES ----------

class InventoryService {
    Map<String, Integer> stock = new HashMap<>();
    int threshold = 5;

    void addStock(String isbn, int qty) {
        stock.put(isbn, stock.getOrDefault(isbn, 0) + qty);
    }

    boolean isAvailable(String isbn, int qty) {
        return stock.getOrDefault(isbn, 0) >= qty;
    }

    void reduceStock(String isbn, int qty) {
        stock.put(isbn, stock.get(isbn) - qty);
        checkRestock(isbn);
    }

    void checkRestock(String isbn) {
        if (stock.getOrDefault(isbn, 0) < threshold) {
            System.out.println("Restock alert for ISBN: " + isbn);
        }
    }
}

class SearchService {
    List<Book> books;

    SearchService(List<Book> books) {
        this.books = books;
    }

    List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.title.toLowerCase().contains(title.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.author.toLowerCase().contains(author.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }
}

class OrderService {
    InventoryService inventory;

    OrderService(InventoryService inventory) {
        this.inventory = inventory;
    }

    void placeOrder(Order order) {

        // Check inventory
        for (OrderItem item : order.items) {
            if (!inventory.isAvailable(item.book.isbn, item.quantity)) {
                System.out.println("Book out of stock: " + item.book.title);
                order.status = OrderStatus.CANCELLED;
                return;
            }
        }

        // Reduce stock
        for (OrderItem item : order.items) {
            inventory.reduceStock(item.book.isbn, item.quantity);
        }

        // Payment
        Payment payment = new Payment(order.getTotalAmount());
        if (payment.processPayment()) {
            order.payment = payment;
            order.status = OrderStatus.PAID;
            fulfillOrder(order);
        } else {
            order.status = OrderStatus.CANCELLED;
        }
    }

    void fulfillOrder(Order order) {
        order.status = OrderStatus.SHIPPED;
        System.out.println("Order shipped: " + order.orderId);
    }
}

// ---------- MAIN ----------

public class OnlineBookstore {

    public static void main(String[] args) {

        // Books
        Book b1 = new Book("1", "Java Basics", "James", "Programming", 500);
        Book b2 = new Book("2", "Spring Boot", "Rod", "Programming", 700);

        List<Book> books = Arrays.asList(b1, b2);

        // Inventory
        InventoryService inventory = new InventoryService();
        inventory.addStock("1", 10);
        inventory.addStock("2", 10);

        // Search
        SearchService search = new SearchService(books);
        System.out.println("Search Results:");
        for (Book b : search.searchByTitle("Java")) {
            System.out.println(b.title);
        }

        // Patron
        Patron p = new Patron("P1", "Kaushal", "k@mail.com");

        // Order
        OrderItem item = new OrderItem(b1, 2);
        Order order = new Order("O1", p, Arrays.asList(item));

        OrderService orderService = new OrderService(inventory);
        orderService.placeOrder(order);

        System.out.println("Order Status: " + order.status);
    }
}
