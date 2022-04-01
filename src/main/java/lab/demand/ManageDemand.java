package lab.demand;

import java.util.List;

public class ManageDemand {

    private Tax tax;

    public ManageDemand(Tax tax) {
        this.tax = tax;
    }   
    public double calculateTaxes(List<Order> orders) {
        double taxes = 0.0;
        for (Order order : orders) {
            double tax = this.tax.calculateTax(order.getCountry());
            taxes += tax;
        }
        return taxes;
    }
    public double CalculateTotalTmp(List<Order> orders) {
        double quantities = 0.0;
        for (Order order : orders) {
            double temp = order.getQuantity();
            quantities += temp;
        }
        return quantities;
    }
    public double ResultTotal(double quantities, double taxes) {
        return quantities * taxes;
    }
    public double calculateTotal(List<Order> orders){
        double tmpTaxes = calculateTaxes(orders);
        double tmpQuantities= CalculateTotalTmp(orders);
        return ResultTotal(tmpQuantities, tmpTaxes);
    }
    
    public double CalculateAdditionalByCountry(List<Order> orders, double defaultAdditionalColombia, double defaultAdditionalPeru, double defaultAdditionalBrazil) {
        double taxes = 0.0;
        for (Order order : orders) {
            String currCountry = order.getCountry();
            if (currCountry.equals("PE")) {
                taxes += defaultAdditionalPeru;
            } else if (currCountry.equals("BR")) {
                taxes += defaultAdditionalBrazil;
            } else {
                taxes += defaultAdditionalColombia;
            }
        }
        return taxes;
    }

    public double calculateTotalForWithAdditionalByCountry(List<Order> orders, double defaultAdditionalColombia, double defaultAdditionalPeru, double defaultAdditionalBrazil){
        double tmp2Quantities= CalculateTotalTmp(orders);
        double tmp2Taxes= CalculateAdditionalByCountry(orders, defaultAdditionalColombia, defaultAdditionalPeru, defaultAdditionalBrazil);
        return ResultTotal(tmp2Quantities, tmp2Taxes);
    }
}
