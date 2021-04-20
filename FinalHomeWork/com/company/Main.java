package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void doTask1() throws JAXBException {
        // Unmarshaller to read Availabilities and Products from xml
        Unmarshaller u = JAXBContext.newInstance(AvailabilitiesRoot.class,
                Availability.class, Product.class,
                ProductsRoot.class).createUnmarshaller();

        // Reading Availabilities
        AvailabilitiesRoot availabilities = (AvailabilitiesRoot) u
                .unmarshal(new File("availabilities.xml"));

        // Reading Products
        ProductsRoot products = (ProductsRoot) u
                .unmarshal(new File("products.xml"));

        // Map to log Products by Id
        Map<Integer, String> productsMap = new HashMap<>();

        // Filling productsMap
        for (Product p : products.getProducts()) {
            productsMap.put(p.getId(), p.getName());
        }

        // Map to log counts of available Products
        Map<String, Integer> availableProducts = new HashMap<>();

        // Filling availableProducts
        for (Availability a : availabilities.getAvailabilities()) {
            if (availableProducts.containsKey(productsMap.get(a.getProductId()))) {
                availableProducts.put(productsMap.get(a.getProductId()),
                        availableProducts.get(productsMap.get(a.getProductId()))
                                + a.getProductCount());
            } else {
                availableProducts.put(productsMap.get(a.getProductId()),
                        a.getProductCount());
            }
        }

        // List of ProductCounts fo ProductCountsRoot
        ArrayList<ProductCount> productCountList = new ArrayList<>();

        // Filling productCountList
        for (String key : availableProducts.keySet()) {
            productCountList.add(new ProductCount(key, availableProducts.get(key)));
        }

        // ProductCountRoot for use JAXB Marshaller
        ProductCountRoot productCountRoot = new ProductCountRoot(productCountList);

        // Marshal productCounts
        Marshaller m = JAXBContext.newInstance(ProductCountRoot.class,
                ProductCount.class).createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(productCountRoot, new File("task1.xml"));
    }

    public static void doTask2() throws JAXBException {
        // Unmarshaller to read Sales
        Unmarshaller u = JAXBContext.newInstance(Sale.class,
                SalesRoot.class).createUnmarshaller();

        // Reading sales
        SalesRoot salesRoot = (SalesRoot) u.unmarshal(
                new File("sales.xml"));

        // Map<day, {count of day entry, sum of sold products for day}>
        Map<String, int[]> log = new HashMap<>();

        // Filling log
        for (Sale s : salesRoot.getSales()) {
            if (log.containsKey(s.getSaleDate())) {
                log.put(s.getSaleDate(), new int[]{
                                log.get(s.getSaleDate())[0] + 1,
                                log.get(s.getSaleDate())[1] + s.getProductCount()
                        }
                );
            } else {
                log.put(s.getSaleDate(), new int[]{1, s.getProductCount()});
            }
        }

        // List for MeanSoldRoot
        ArrayList<MeanSold> meanSoldList = new ArrayList<>();

        // Filling meanSoldList
        for (String key : log.keySet()) {
            meanSoldList.add(new MeanSold(key,
                    (double)(log.get(key)[1]) / (double)(log.get(key)[0])));
        }

        // MeanSoldRoot for use JAXB Marshaller
        MeanSoldRoot meanSoldRoot = new MeanSoldRoot(meanSoldList);

        // Marshal meanSoldRoot
        Marshaller m = JAXBContext.newInstance(MeanSold.class,
                MeanSoldRoot.class).createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(meanSoldRoot, new File("task2.xml"));
    }

    public static void main(String[] args) throws JAXBException {
        doTask1();
        doTask2();
    }
}
