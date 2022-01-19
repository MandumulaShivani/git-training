package generics;

import java.beans.Customizer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class  OrderProcessor{

    public static void main(String[] args) {
        

         List<Item> ItemsName = new ArrayList<>();

        ItemsName.add(new Item("Tea Powder", 1, 72.99));
        ItemsName.add(new Item("Rice", 1, 799.99));
        ItemsName.add(new Item("Moong Dal", 2, 23.99));
        ItemsName.add(new Item("Hair oil", 3, 33.99));
        ItemsName.add(new Item("Oreo Biscuits", 6, 23.99));

     Order order = new Order(1,"Customer: Shivani",ItemsName, 100, 0.99, 0.99);
        order.displayOrder();
        OrderFileProcessor.serializeOrder(order);
    }
    

}


final class OrderFileProcessor {

    public static void deSerializeOrder(){
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream("orders_ser"))) {
            Order order = (Order) oin.readObject();
            order.displayOrder();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    public static void serializeOrder(Order order) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("orders_ser"))) {
            oos.writeObject(order);            
        } catch (IOException e) {
            System.err.println("Serialization IO Error:" + e.getMessage());

        }
    }

    public static void processOrder(Order order) {
        try (PrintWriter out = new PrintWriter("orders")) {
            out.printf("Order Id: %d  %50s %n", order.getOrderId(), order.getCustomer());
            out.printf("Order Id: %d  %10s %n", order.getCustomer());
            out.printf("%50s %n", "Items");
            for (Item item : order.getItemsName()) {
                out.printf("%20s %d %4.2f %4.2f %n", item.getName(), item.getQuantity(),
                        item.getPrice(), item.getTotalCost());
            }
            out.printf(
                    "============================================================================%n");
            out.printf("Net Total: %4.2f %n", order.getNetTotal());

        } catch (IOException e) {
            System.err.println("File IO Error:" + e.getMessage());
        } finally {
            System.out.println("Order processed successfully");
        }
    }

}


class Order implements Serializable {

    private int orderId;
    private String customer;
    // items
    private List<Item> ItemsName;
    private int Qty;
    private double UnitPrice;
    private double netTotal;
    private double TotalPrice;


    public Order(int orderId, String customer, List<Item> ItemsName, int Qty, double UnitPrice, double TotalPrice) {
        this.orderId = orderId;
        this.customer = customer;
        this.ItemsName = ItemsName;
        this.Qty = Qty;
        this.UnitPrice = UnitPrice;
        this.TotalPrice = TotalPrice;
        this.netTotal = 0;
        
        for (Item item : ItemsName) {
            netTotal += item.getPrice();
        }
        
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Item> getItemsName() {
        return ItemsName;
    }

    public void setItems(List<Item> items) {
        this.ItemsName = items;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }

    public void displayOrder() {
        System.out.printf(
                "============================================================================%n");
        System.out.printf("Order Id: %d  %50s %n", orderId, customer);
        System.out.printf("%50s %n", "ItemsName");
        System.out.printf("Qty: %d %n", Qty);
        System.out.printf("UnitPrice: %4.2f %n", UnitPrice);
        System.out.printf("TotalPrice: %4.2f %n", TotalPrice);
        System.out.printf(
                "============================================================================%n");
        for (Item item : ItemsName) {
            System.out.printf("%20s %d %4.2f %4.2f %n", item.getName(), item.getQuantity(),
                    item.getPrice(), item.getTotalCost());
        }
        System.out.printf(
                "============================================================================%n");
        System.out.printf("Net Total: %4.2f %n", netTotal);
        
    }


}


class Item implements Serializable {

    private String name;
    private int quantity;
    private double price;
    private double totalCost;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.totalCost = quantity * price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }


}