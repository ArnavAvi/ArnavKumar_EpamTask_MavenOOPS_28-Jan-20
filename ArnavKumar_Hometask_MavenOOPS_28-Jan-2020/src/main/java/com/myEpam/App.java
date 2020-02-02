package com.myEpam;
import java.util.*;

import com.myEpam.Sweets.Candy;
import com.myEpam.Sweets.Chocolate;
import com.myEpam.Sweets.Sweets;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class App
{
    int netWeight;
    int netAmount;
    int m,p,l = 0;
    Stack<Sweets> cart = new Stack<>();
    ArrayList<Chocolate> chocobill = new ArrayList<>();

    void billCart() {
        Sweets tmp;
        while(!cart.isEmpty()) {
            tmp = cart.peek();
            /*System.out.println("tmp.getQuantity():"+tmp.getQuantity()+"tmp.getWeightPerPiece()"+tmp.getWeightPerPiece());
            System.out.println("tmp.totalCost():"+tmp.totalCost());
            System.out.println("tmp.costPerPiece: " + tmp.getCostPerPiece());*/
            netWeight += tmp.getQuantity()*tmp.getWeightPerPiece();
            netAmount += tmp.totalCost();
            cart.pop();

        }
    }

    public ArrayList<Chocolate> sortByPrice(int a, ArrayList<Chocolate> choco) {
        return Chocolate.chockSort(a,choco);
    }

    public static void main( String[] args )
    {
        App gift = new App();
        Scanner sc = new Scanner(System.in);

        int i=0;
        System.out.println("Welcome to the Sweet shop we have Chocolates and Candies for you");

        while(true){
            System.out.println("Press 1 for Chocolates and 2 for Candies and q to quit");
            String num = sc.next();
            if(num.equals("1")) {
                System.out.println("Press 1) Cadbury 2) Perk and 3) snickers");
                String numb = sc.next();
                System.out.println("Quantity please");
                int qty = sc.nextInt();
                if(numb.equals("1")) {
                    gift.cart.push(new Chocolate(1,qty));
                    gift.chocobill.add(new Chocolate(1,qty));}
                else if(numb.equals("2")) {
                    gift.cart.push(new Chocolate(2,qty));
                    gift.chocobill.add(new Chocolate(2,qty));}
                else{
                    gift.cart.push(new Chocolate(3,qty));
                    gift.chocobill.add(new Chocolate(3,qty));}
            }
            else if(num.equals("2")) {
                System.out.println("Press 1) Mango 2) Pineapple and 3) Lemon");
                String numb = sc.next();
                System.out.println("Quantity please");
                int qty = sc.nextInt();

                if(numb.equals("1")){
                    gift.cart.push(new Candy(1,qty));
                gift.m+=qty;}
                else if(numb.equals("2")){
                    gift.cart.push(new Candy(2,qty));
                gift.p+=qty;}
                else{
                    gift.cart.push(new Candy(3,qty));
                gift.l+=qty;}
            }
            else if(num.equals("q") || num.equals("Q")) {
                System.out.println("Thank you for shopping with us!");
                break;
            }
        }
        gift.billCart();
        System.out.println("For sorting your chocolates Press 1)Asc 2)Desc 3)Quit");
        int srt = sc.nextInt();
        ArrayList<Chocolate> trayOfChocolate = new ArrayList<>();
        if(srt==1)
            trayOfChocolate = gift.sortByPrice(1,gift.chocobill);
        else if(srt==2)
            trayOfChocolate = gift.sortByPrice(2,gift.chocobill);
        else{}
        System.out.print("Chocolates: ");
        for(Chocolate c:trayOfChocolate)
            System.out.print(c.getBrand()+"(Rs."+c.getCostPerPiece()+") ");
        System.out.println();
        System.out.println("Mango candies -> "+gift.m + " Pineapple candies -> "+gift.p + " Lemon candies -> "+gift.l);
        System.out.println("Total Cart Weight: " + gift.netWeight + " gm" + "\n" +
                "Total Cart Price: " + gift.netAmount + " Rs.");
    }
}
