/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheBusiness;

import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.Personnel.Person;
import TheBusiness.ProductManagement.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author harsh
 */
public class ReadCSVFileData {

    private static final String CUSTOMER_CSV_FILE_PATH = "src/resource/Customer.csv";
    private static final String PRODUCT_CSV_FILE_PATH = "src/resource/Product.csv";

    public static ArrayList<CustomerProfile> readCustomerCSVFileData(CustomerDirectory customerDir) {
        ArrayList<CustomerProfile> custProfileLi = new ArrayList<>();
        try {
            File custFile = new File(CUSTOMER_CSV_FILE_PATH);
            if (custFile.exists()) {
                Scanner sc = new Scanner(custFile);
                sc.useDelimiter(",");
                int lineCount = 0;
                while (sc.hasNext()) {
                    if (lineCount > 0) {
                        custProfileLi.add(new CustomerProfile(new Person(sc.next().trim())));
                    }
                    lineCount++;
                }
                sc.close();
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return custProfileLi;
    }

    public static Map<String, List<Product>> readProductCSVFileData() {
        Map<String, List<Product>> supplierProdMap = new HashMap<>();
        try {
            File custFile = new File(PRODUCT_CSV_FILE_PATH);
            List<Product> prodList = new ArrayList<>();
            if (custFile.exists()) {
                BufferedReader bf = new BufferedReader(new FileReader(custFile));
                int lineCount = 0;
                String line = "";
                while ((line = bf.readLine()) != null) {
                    if (lineCount > 0) {
                        String[] lineDetail = line.split(",");
                        String sName = lineDetail[0];
                        String pName = lineDetail[1];
                        String fp = lineDetail[2].trim();
                        String cp = lineDetail[3].trim();
                        String tp = lineDetail[4].trim();
                        if (supplierProdMap.containsKey(sName)) {
                            Product prod = new Product(pName, Integer.parseInt(fp),
                                    Integer.parseInt(cp), Integer.parseInt(tp));
                            prodList.add(prod);
                            supplierProdMap.put(sName, prodList);
                        } else {
                            prodList = new ArrayList<>();
                            Product prod = new Product(pName, Integer.parseInt(fp),
                                    Integer.parseInt(cp), Integer.parseInt(tp));
                            prodList.add(prod);
                            supplierProdMap.put(sName, prodList);
                        }

                    }
                    lineCount++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("ProdMap :" + supplierProdMap.toString());
        return supplierProdMap;
    }

}
