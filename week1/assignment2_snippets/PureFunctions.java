
class TaxUtil {
 public double calculateTax(double amount, double rate) {
  return amount * rate;
 }
}

public class PureFunctions {
  public static void main(String[] args) {
    TaxUtil taxUtil = new TaxUtil();
    double amount = 100000;
    double rate = 0.2;
    double tax = taxUtil.calculateTax(amount, rate);
    System.out.printf("Amount: %.2f, Rate: %.2f, Tax: %.2f%n", amount, rate, tax);
  }
}