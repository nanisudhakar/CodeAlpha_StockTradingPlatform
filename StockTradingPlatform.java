import java.util.HashMap;
import java.util.Scanner;

class StockTradingPlatform {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

HashMap<String, Double> stocks = new HashMap<>();
stocks.put("TCS", 3500.0);
stocks.put("INFY", 1500.0);
stocks.put("RELIANCE", 2800.0);

HashMap<String, Integer> portfolio = new HashMap<>();

while (true) {
System.out.println("\n--- STOCK TRADING PLATFORM ---");
System.out.println("1. View Market");
System.out.println("2. Buy Stock");
System.out.println("3. Sell Stock");
System.out.println("4. View Portfolio");
System.out.println("5. Exit");

int choice = sc.nextInt();

switch (choice) {
case 1:
System.out.println("\nMarket Data:");
for (String stock : stocks.keySet()) {
System.out.println(stock + " : ₹" + stocks.get(stock));
}
break;

case 2:
System.out.print("Enter Stock Name: ");
String buyStock = sc.next().toUpperCase();

if (stocks.containsKey(buyStock)) {
System.out.print("Quantity: ");
int qty = sc.nextInt();

portfolio.put(buyStock,
portfolio.getOrDefault(buyStock, 0) + qty);

System.out.println("Stock Purchased!");
} else {
System.out.println("Stock Not Found!");
}
break;

case 3:
System.out.print("Enter Stock Name: ");
String sellStock = sc.next().toUpperCase();

if (portfolio.containsKey(sellStock)) {
System.out.print("Quantity: ");
int sellQty = sc.nextInt();

int currentQty = portfolio.get(sellStock);

if (sellQty <= currentQty) {
portfolio.put(sellStock,
currentQty - sellQty);
System.out.println("Stock Sold!");
} else {
System.out.println("Not enough shares.");
}
} else {
System.out.println("Stock not in portfolio.");
}
break;

case 4:
System.out.println("\nPortfolio:");
for (String stock : portfolio.keySet()) {
System.out.println(stock + " : "
+ portfolio.get(stock) + " shares");
}
break;

case 5:
System.out.println("Thank You!");
System.exit(0);

default:
System.out.println("Invalid Choice");
}
}
}
}