package com.myEpam.Sweets;

public class Candy extends Sweets{

    private String flavour;          //All candies in our store are made locally and are unbranded
    public Candy(int flavour, int quantity) {
        this.setQuantity(quantity);
        if(flavour==1)
            this.flavour = "mango";
        else if(flavour==2)
            this.flavour = "pineapple";
        else
            this.flavour = "lemon";
        this.CostPiece();           //Got to initialize the base properties
        this.WeightPiece();
        this.customTax();
    }

    @Override
    public void customTax() {
        this.setCustomTax(2);        //Variable quantity(Budget 2020) eg: 2Rs.
    }

    @Override
    public void CostPiece() {   //Variable quantities(Market cost)
        if(flavour.equals("mango"))
            this.setCostPerPiece(3);
        else if(flavour.equals("pineapple"))
            this.setCostPerPiece(4);
        else
            this.setCostPerPiece(2);
    }

    @Override
    public void WeightPiece() {
        this.setWeightPerPiece(2);   //Variable quantity(company decides) eg: 2gm.
    }


}
