package SystemDesign.lldPractice;

import java.util.*;

class InventoryManager {
    private Map<String, Integer> stock = new HashMap<>();

    public InventoryManager() {
        stock.put("LAPTOP", 10);
        stock.put("PHONE", 25);
        stock.put("TABLET", 15);
    }

    public boolean checkStock(String productId, int quantity) {
        return stock.getOrDefault(productId, 0) >= quantity;
    }

    public void reduceStock(String productId, int quantity) {
        stock.put(productId, stock.get(productId) - quantity);
    }
}

class NotificationService {
    public void sendOrderConfirmation(String customerEmail, String orderId, double total) {
        System.out.println("Email to " + customerEmail + ": Order " + orderId + " confirmed. Total: $" + total);
    }
}

class OrderProcessor {
    private InventoryManager inventoryManager;
    private NotificationService notificationService;
    private int orderCounter = 0;

    public OrderProcessor(InventoryManager inventoryManager, NotificationService notificationService) {
        this.inventoryManager = inventoryManager;
        this.notificationService = notificationService;
    }

    public void placeOrder(String productId, int quantity, String customerEmail) {
        if (!inventoryManager.checkStock(productId, quantity)) {
            System.out.println("Insufficient stock for " + productId);
            return;
        }
        inventoryManager.reduceStock(productId, quantity);
        double total = quantity * 100.0;
        orderCounter++;
        String orderId = "ORD-" + orderCounter;
        notificationService.sendOrderConfirmation(customerEmail, orderId, total);
    }
}
// TODO: Refactor into OrderProcessor, InventoryManager, and NotificationService.
public class OrderProcessoringProblem {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();
        NotificationService notifications = new NotificationService();
        OrderProcessor processor = new OrderProcessor(inventory, notifications);
        processor.placeOrder("LAPTOP", 2, "alice@example.com");
    }
}
