import java.util.ArrayList;


public class Salad {

    // -- Attributes - variables that describes a salad
    String greens;
    String protein;
    ArrayList<String> toppings;
    boolean isVegan;

    // -- Constructor for Salad Class
    public Salad() {
    }//end constructor


    // -- Accessor Methods - getters and setters
    public String getGreens() {
        return greens;
    }

    public void setGreens(String greens) {
        this.greens = greens;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public ArrayList<String> getToppings() {
        return toppings;
        
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }
}
