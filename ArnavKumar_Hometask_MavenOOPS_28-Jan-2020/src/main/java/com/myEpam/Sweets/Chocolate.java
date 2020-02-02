package com.myEpam.Sweets;
import java.util.*;
public class Chocolate extends Sweets {
    private String brand;

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Chocolate(int brand, int quantity) {
        Scanner sc = new Scanner(System.in);
        this.setQuantity(quantity);
        if(brand<1 || brand>3) {
            System.out.println("Invalid brand, Please try again");
            new Chocolate(sc.nextInt(), sc.nextInt());
        }
        else if(brand == 1)
            this.setBrand("Cadbury");
        else if(brand == 2)
            this.setBrand("Perk");
        else
            this.setBrand("Snickers");
        this.CostPiece();
        this.WeightPiece();
        this.customTax();
    }

    @Override
    public void customTax() {
        this.setCustomTax(5);
    }

    @Override
    public void CostPiece() {              //Variable quantities
        if(getBrand().equals("Cadbury")) {
            this.setCostPerPiece(10);
        }
        else if(getBrand().equals("Perk")) {
            this.setCostPerPiece(15);
        }
        else if(getBrand().equals("Snickers")) {
            this.setCostPerPiece(20);
        }
    }

    @Override
    public void WeightPiece() {
        this.setWeightPerPiece(10);       //Retailer can change depending upon company rules
    }

    public static ArrayList<Chocolate> chockSort(int a, ArrayList<Chocolate> choco){
        Chocolate temp;
        if(a>=0) {
            for (int i = 0; i < choco.size(); i++) {
                for (int j = i + 1; j < choco.size(); j++) {
                    if (choco.get(i).getCostPerPiece() < choco.get(j).getCostPerPiece()) {
                        temp = choco.get(i);
                        choco.set(i, choco.get(j));
                        choco.set(j, temp);
                    }
                }
            }
        }
        else{
            for (int i = 0; i < choco.size(); i++) {
                for (int j = i + 1; j < choco.size(); j++) {
                    if (choco.get(i).getCostPerPiece() > choco.get(j).getCostPerPiece()) {
                        temp = choco.get(i);
                        choco.set(i, choco.get(j));
                        choco.set(j, temp);
                    }
                }
            }
        }
        return choco;
    }
}
