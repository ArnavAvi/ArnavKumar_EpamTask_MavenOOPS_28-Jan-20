package com.myEpam.Sweets;
import java.util.Scanner;

public abstract class Sweets {
    private long id = 12051;
    private int weightPerPiece;
    private int customTax;
    private int costPerPiece;
    private int quantity;

    Sweets() {id++;}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setWeightPerPiece(int weightPerPiece) {
        Scanner sc= new Scanner(System.in);
        if(weightPerPiece <1) {
            System.out.println("Invalid quantity please enter a valid quanity");
            setWeightPerPiece(sc.nextInt());
        }
        this.weightPerPiece = weightPerPiece;
    }

    public int getWeightPerPiece() {
        return weightPerPiece;
    }

    public int getCostPerPiece() {
        return costPerPiece;
    }

    public void setCostPerPiece(int costPerPiece) {
        this.costPerPiece = costPerPiece;
    }

    public int getCustomTax() {
        return customTax;
    }

    public int totalCost(){
        return (this.getQuantity()*this.getCostPerPiece()+this.getCustomTax());
    }

    public void setCustomTax(int customTax) {this.customTax = customTax;}

    public abstract void customTax();
    public abstract void CostPiece();
    public abstract void WeightPiece();
}
