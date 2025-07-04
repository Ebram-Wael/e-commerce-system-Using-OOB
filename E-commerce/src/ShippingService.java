import Products.ShippableProduct;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class ShippingService {
    public static double handleShipment(List<ShippableProduct> items) {
        if (items.isEmpty()) return 0.0;

        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        Map<String, Integer> itemCounts = new LinkedHashMap<>();
        Map<String, Double> itemWeights = new HashMap<>();

        for (ShippableProduct item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            itemCounts.put(name, itemCounts.getOrDefault(name, 0) + 1);
            itemWeights.put(name, weight);
            totalWeight += weight;
        }

        for (String name : itemCounts.keySet()) {
            System.out.println(itemCounts.get(name) + "x " + name);
            System.out.println((int) (itemWeights.get(name) * 1000) + "g");
        }

        System.out.println("Total package weight " + totalWeight + "kg");
        return 30.0; // fixed shipping
    }
}