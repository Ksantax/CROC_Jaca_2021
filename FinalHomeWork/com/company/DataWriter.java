package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Класс задумывался как инструмент для создания данных,
 * которые необходимы для выполнения заданйи.
 * Почему-то я думал, что это хорошая идея,
 * и так будет легче создавать данные, но нет...
 * Есть основной метод writeData() который запускает запись данных.
 * Думаю стоит просто запустить это тметод и всё сразу станет понятнее,
 * но сам класс уже к заданиям отношения не имеет ¯\_(ツ)_/¯
 * Не знаю теперь, зачем я потратил на него время.
 */
public class DataWriter {
    private static final Scanner in = new Scanner(System.in);

    private static int getMode() {
        System.out.print("Выберите данные, которые хотите задать\n" +
                "  > 1 - Продукты\n" +
                "  > 2 - Продавцы\n" +
                "  > 3 - Наличия товаров\n" +
                "  > 4 - Продажи\n" +
                "Ввод> ");
        int ret = in.nextInt();
        in.nextLine();
        return ret;
    }

    private static void sayWarning() {
        System.out.println("***  Ввод любых символов, не подходящих под контекст, " +
                "вызовет ошибку и остановит работу программы!  ***");

    }

    private static File getFile(String target) {
        System.out.print("Введите название файла, в который хотите записать \""+ target +"\"\n" +
                "Ввод> ");
        return new File(in.nextLine());
    }

    private static void sayEndWriting(int count, String target) {
        System.out.println("Конец ввода. Введено \"" + target + "\": " + count);
    }

    private static void sayStopWord() {
        System.out.println("Когда решите остановиться, введите \"!\"");
    }

    private static Product getProduct(int id) {
        String input;
        System.out.print("Введите назнавние продукта> ");
        input = in.nextLine();
        if (input.equals("!")) return null;
        return new Product(id, input);
    }

    public static void writeProducts() throws JAXBException {
        sayWarning();
        String targetsString = "Продукты";


        Marshaller m = JAXBContext.newInstance(ProductsRoot.class,
                Product.class).createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ArrayList<Product> productsList = new ArrayList<>();

        File file = getFile(targetsString);
        sayStopWord();
        Product product;
        int iter = 0;
        while (true) {
            product = getProduct(iter);
            if (product != null)
                productsList.add(product);
            else break;
            iter++;
        }
        m.marshal(new ProductsRoot(productsList), file);
        sayEndWriting(iter, targetsString);
    }

    private static Seller getSeller(int id) {
        String input, name;

        System.out.print("Введите имя продавца> ");
        input = in.nextLine();
        if (input.equals("!")) return null;
        name = input;

        System.out.print("Введите фамилию продавца> ");
        input = in.nextLine();
        if (input.equals("!")) return null;

        return new Seller(id, name, input);
    }

    public static void writeSellers() throws JAXBException {
        sayWarning();
        String targetsString = "Продавцы";

        Marshaller m = JAXBContext.newInstance(SellersRoot.class,
                Seller.class).createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ArrayList<Seller> sellersList = new ArrayList<>();

        File file = getFile(targetsString);
        sayStopWord();
        Seller seller;
        int iter = 0;
        while (true) {
            seller = getSeller(iter);
            if (seller != null)
                sellersList.add(seller);
            else break;
            iter++;
        }
        m.marshal(new SellersRoot(sellersList), file);
        sayEndWriting(iter, targetsString);
    }

    private static int[] getPidCount() {
        String input;
        int productId, productCount;

        System.out.print("Введите id продукта> ");
        input = in.nextLine();
        if (input.equals("!")) return null;
        productId = Integer.parseInt(input);

        System.out.print("Введите количество продукта> ");
        input = in.nextLine();
        if (input.equals("!")) return null;
        productCount = Integer.parseInt(input);

        return new int[]{productId, productCount};
    }

    private static ArrayList<Availability> getAvailabilityForSeller() {
        String input;
        ArrayList<Availability> retList = new ArrayList<>();
        System.out.print("Задайте для одного продавца несколько наличий\n" +
                "Введите id продавца> ");
        int id = in.nextInt();
        in.nextLine();
        sayStopWord();
        while(true) {

            int[] pidCount = getPidCount();
            if (pidCount == null) return retList;

            System.out.print("Введите цену продукта> ");
            input = in.nextLine();
            if (input.equals("!")) return retList;
            retList.add(new Availability(id, pidCount[0],
                    pidCount[1], Double.parseDouble(input)));
        }
    }

    public static void writeAvailabilities() throws JAXBException {
        sayWarning();
        String targetsString = "Наличия";

        Marshaller m = JAXBContext.newInstance(AvailabilitiesRoot.class,
                Availability.class).createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ArrayList<Availability> availabilitiesList = new ArrayList<>();

        File file = getFile(targetsString);
        ArrayList<Availability> availabilities;
        int iter = 0;
        do {
            availabilities = getAvailabilityForSeller();
            availabilitiesList.addAll(availabilities);
            iter += availabilities.size();

            System.out.print("Ввести наличия для следующего продавца?\n" +
                    "  > 1 - да\n" +
                    "  > 2 - нет\n" +
                    "Ввод>");
        } while (in.nextLine().equals("1"));
        m.marshal(new AvailabilitiesRoot(availabilitiesList), file);
        sayEndWriting(iter, targetsString);
    }

    private static ArrayList<Sale> getSaleForSeller(int count) {
        String input;
        ArrayList<Sale> retList = new ArrayList<>();
        System.out.print("Задайте для одного продавца несколько продаж\n" +
                "Введите id продавца> ");
        int sellerId = in.nextInt();
        in.nextLine();
        sayStopWord();
        while(true) {

            int[] pidCount = getPidCount();
            if (pidCount == null) return retList;

            System.out.print("Введите дату продажи> ");
            input = in.nextLine();
            if (input.equals("!")) return retList;
            retList.add(new Sale(count ,sellerId, pidCount[0],
                    pidCount[1], input));
            count++;
        }
    }

    public static void writeSales() throws JAXBException {
        sayWarning();
        String targetsString = "Продажи";

        Marshaller m = JAXBContext.newInstance(SalesRoot.class,
                Sale.class).createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ArrayList<Sale> salesList = new ArrayList<>();

        File file = getFile(targetsString);
        ArrayList<Sale> sales;
        int iter = 0;
        do {
            sales = getSaleForSeller(iter);
            salesList.addAll(sales);
            iter += sales.size();

            System.out.print("Ввести продажи для следующего продавца?\n" +
                    "  > 1 - да\n" +
                    "  > 2 - нет\n" +
                    "Ввод>");

        } while (in.nextLine().equals("1"));
        m.marshal(new SalesRoot(salesList), file);
        sayEndWriting(iter, targetsString);
    }


    public static void writeData() throws JAXBException {
        sayWarning();
        boolean work = true;
        while (work) {
            switch (getMode()) {
                case 1: {
                    writeProducts();
                    break;
                }
                case 2: {
                    writeSellers();
                    break;
                }
                case 3: {
                    writeAvailabilities();
                    break;
                }
                case 4: {
                    writeSales();
                    break;
                }
            }
            System.out.print("Хотите продолжить создание данных?\n"+
                    "  > 1 - Да\n" +
                    "  > 2 - Нет\n" +
                    "Ввод> ");
            if(in.nextInt() == 2)
                work = false;
        }
        System.out.println("Конец ввода данных\n\n");
    }
}
