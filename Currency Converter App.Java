
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Currency Converter ===");
        System.out.println("Available currencies:");
        System.out.println("1. USD (US Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. GBP (British Pound)");
        System.out.println("4. JPY (Japanese Yen)");
        System.out.println("5. INR (Indian Rupee)");
        System.out.println("6. CAD (Canadian Dollar)");
        System.out.println("7. AUD (Australian Dollar)");
        System.out.println();
        
        // Get source currency
        System.out.print("Enter source currency (1-7): ");
        int fromCurrency = scanner.nextInt();
        
        // Get target currency
        System.out.print("Enter target currency (1-7): ");
        int toCurrency = scanner.nextInt();
        
        // Get amount
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();
        
        // Exchange rates (relative to USD)
        double[] exchangeRates = {
            1.0,    // USD
            0.85,   // EUR
            0.75,   // GBP
            110.0,  // JPY
            83.0,   // INR
            1.35,   // CAD
            1.50    // AUD
        };
        
        String[] currencyNames = {
            "USD", "EUR", "GBP", "JPY", "INR", "CAD", "AUD"
        };
        
        // Validate input
        if (fromCurrency < 1 || fromCurrency > 7 || toCurrency < 1 || toCurrency > 7) {
            System.out.println("Invalid currency selection!");
            return;
        }
        
        if (amount < 0) {
            System.out.println("Amount cannot be negative!");
            return;
        }
        
        // Convert to USD first, then to target currency
        double usdAmount = amount / exchangeRates[fromCurrency - 1];
        double convertedAmount = usdAmount * exchangeRates[toCurrency - 1];
        
        // Display result
        System.out.println();
        System.out.println("=== Conversion Result ===");
        System.out.printf("%.2f %s = %.2f %s%n", 
            amount, 
            currencyNames[fromCurrency - 1], 
            convertedAmount, 
            currencyNames[toCurrency - 1]);
        
        // Show exchange rate used
        double rate = exchangeRates[toCurrency - 1] / exchangeRates[fromCurrency - 1];
        System.out.printf("Exchange Rate: 1 %s = %.4f %s%n", 
            currencyNames[fromCurrency - 1], 
            rate, 
            currencyNames[toCurrency - 1]);
        
        scanner.close();
    }
}
