import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderingSystem {
    public static void main(String[] args) {

        // -- Declare a variable to hold the STG greeting
        String greeting = "Welcome to Salads to Go!";

        // -- Declare a variable to hold the slogan
        String slogan = "Build Your Own Salads, Your Way. Time to build a salad.";

        //Declare a variable to track if the user salad order is vegan or not
        boolean isVegan;

        // -- Declare three array lists to hold the greens, proteins and toppings
        ArrayList<String> greens = new ArrayList<String>();
        ArrayList<String> proteins = new ArrayList<String>();
        ArrayList<String> toppings = new ArrayList<String>();

        // -- Add the values to the arraylists
        greens.add("Kale");
        greens.add("Romaine-Lettuce");
        greens.add("Iceberg-Lettuce");
        proteins.add("Tuna");
        proteins.add("Chicken");
        proteins.add("Black-Bean");
        toppings.add("Cheese");
        toppings.add("Croutons");
        toppings.add("Tomatoes");
        toppings.add("Onions");
        toppings.add("Bacon");
        toppings.add("Olives");

        // -- Display the greeting and the slogan to the customer
        System.out.println(greeting);
        System.out.println(slogan);
        System.out.println("--------------------------------" + "\n");

        // -- Call the method to display the greens types to the customer
        System.out.println("The types of greens we have are: "+ "\n");
        displayIngredients(greens);

        // -- Prompt the user to choose a type of salad greens
        System.out.println("What type of greens do you want for your salad?");

        // -- Get the type of greens from the user as input using the Scanner class
        Scanner scanner = new Scanner(System.in);
        String userGreens = scanner.next();

        // -- Create a new salad object with the greens
        Salad customerSalad = new Salad();
        customerSalad.setGreens(userGreens);

        // -- Call the method to display the proteins to the customer
        System.out.println("The types of proteins we have are:" + "\n");
        displayIngredients(proteins);

        // -- Prompt the user
        System.out.println("What type of protein do you want?");
        String customerProtein = scanner.next();
        customerSalad.setProtein(customerProtein);

        // -- Determine if the protein the customer chose is vegan
        if(customerProtein.equals("Tuna") ||customerProtein.equals("Chicken")){
            isVegan = false;
        }else{
            isVegan = true;
        }//end if-else

        // -- Create an array list to hold the toppings
        ArrayList<String> customerToppings = new ArrayList<String>();

        // -- Use a while loop to keep prompting the user to choose toppings until
        // - they are finished
        boolean wantsMoreToppings = true;
        while(wantsMoreToppings){

            // - Prompt the user to choose a topping & display the topping types to the customer
            System.out.println("What type of toppings do you want?");
            displayIngredients(toppings);

            // - Get the toppings from the user and add it to the customer's list of toppings
            String customerTopping = scanner.next();
            customerToppings.add(customerTopping);

            // -- Determine if the toppings the customer chose is vegan
            if(customerTopping.equals("Cheese") || customerTopping.equals("Bacon")){
                isVegan = false;
            }else{
                isVegan = true;
            }//end if-else

            // -- Ask the user if they want another topping
            System.out.println("Do you want to add another topping to your salad? Y/N");

            // -- If the user enters Y, stop the looping, else keep going
            String userResponse = scanner.next();
            if (userResponse.equals("Y")){
                wantsMoreToppings = true;
            } else {
                wantsMoreToppings = false;
            } //end if

        } //end while loop

        // -- Add the customer toppings to the salad
        customerSalad.setToppings(toppings);

        // -- Display a message to the user showing the type of salad they ordered
        System.out.println("You ordered a " + customerSalad.getProtein() + " salad on " + customerSalad.getGreens() + ".");

        // -- Use a loop to display the toppings the user ordered on their salad
        if(customerToppings.size() > 0 ) {

            // - Print a message about topping list
            System.out.println("You chose the following toppings:  ");
            for (String topping : customerToppings) {
                System.out.println(topping);
            } //end for each loop
        } //end if

        // -- If the salad is vegan, display a vegan message, if not, thank the customer for their order
        if(isVegan){
            System.out.println("Thank you for trying our vegan salad.");
        } else {
            System.out.println("Thank you for ordering a salad from Salads to Go.");
        } //end

        // -- Open a file called SaladOrder.txt and write the information about the salad to the file, including
        // - the greens type, protein type, and toppings
        try { // Hands the IO Exceptions thrown by writing to a file
            // - Create a file writer
            FileWriter file = new FileWriter("SaladOrder.txt");

            // - Create a bufferedWriter
            BufferedWriter buffer = new BufferedWriter(file);

            // - Write the salad information to the file
            buffer.write("The salad greens are: " + customerSalad.getGreens());
            buffer.write("The protein is: " + customerSalad.getProtein());

            // - Loop through the toppings to add them to the file
            for (String topping : customerToppings){
                buffer.write("Toppings: " + topping);

            } //end for loop

            //Close the writer
            buffer.close();

        } catch (IOException e){
            e.printStackTrace();
        } //end try-catch

    } //end main

    //______________________________________________________________________________________

    // --- Method to display the salad ingredients to the customer
    private static void displayIngredients(ArrayList<String> ingredients){
        // -- Use a loop to iterate over the items in the ArrayList and display them
        // - to the customer
        for (String ingredient : ingredients){
            System.out.println(ingredient + "\n");
        } //end for each loop

    } //end method displayIngredients

} //end class
