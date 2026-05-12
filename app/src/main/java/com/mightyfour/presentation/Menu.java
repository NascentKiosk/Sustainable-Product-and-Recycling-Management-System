package com.mightyfour.presentation;
import java.util.HashMap;
import java.util.Scanner;
import com.mightyfour.application.MaterialService;
import com.mightyfour.application.ApplicationService;
import com.mightyfour.application.ListMaterialsResult;
import com.mightyfour.application.ProvideGuidanceResult;

public class Menu {
    //private ImpactCalculationStrategy strategy;
    private Scanner input;
    private ApplicationService serviceApp;
    private OutputFormatter formatter;

    public Menu(ApplicationService serviceApp, Scanner input, OutputFormatter formatter){ 
        this.input = input;
        this.serviceApp = serviceApp;
        this.formatter = formatter; 
    }


    
    public void menuLoop(){
        //Here we define the menu options for our program
        String menu_options = "\n1) Add a new product to repository \n2) Add material to an existing product \n3) List all products in repository \n4) View product details \n5) Get recycling guidance \n6) Calculate environmental impact of product \nQ) Quit program\n";
        //Here we initialize a variable that will be checked for menu options
        String user_input = "";
        
        while(!(user_input.equals("Q"))){ 
            
            //Try-catch statement that will handle all errors that bubble up to Menu
            try{
                //Here we print the menu options
                printOutput(menu_options);
                //Here we ask the user for input
                printOutput("Please enter your response: ");
                user_input = readInput();

        
                //Here the user will try to add a new product to repo
                if(user_input.equals("1")){
                    //Here the user will try to add a new product to repo
                    printOutput("Enter name of product: ");
                    String user_adds_product_name = readInput();

                    ListMaterialsResult result = serviceApp.listPredefinedMaterials();
                    formatter.printListMaterialsResult(result);

                    printOutput("Enter name of material from the list: ");
                    String user_adds_material = readInput();

                    //create product using productapplicationservice
                    //lifespan just used just for testing, not fully implemented yet
                    serviceApp.createProduct(user_adds_product_name, user_adds_material, 0);
                    printOutput("Action was successful.");
                }
                //Here the user will try to add another material to existing product
                else if(user_input.equals("2")){
                    printOutput("Enter ID of product: ");
                    String product_id_string = readInput();

                    ListMaterialsResult result = serviceApp.listPredefinedMaterials();
                    formatter.printListMaterialsResult(result);
                    printOutput("Enter name of material from the list that you would like to to add to product: ");
                    String material_name = readInput();

                    serviceApp.addMaterialtoProduct(material_name, product_id_string);
                    printOutput("Material has been successfully added to the specified product."); //SUCCESS MESSAGE
                }
                //Here we list all products stored in repo
                else if(user_input.equals("3")){
                    //Here we list all products stored in repo
                    printOutput("List of current products: \n");
                    printOutput(serviceApp.listProducts());
                }
                //Here we show all details of a product
                else if(user_input.equals("4")){
                    printOutput("Enter ID of product you wish to see the details of: ");
                    String product_id = readInput();
                
                
                    printOutput(serviceApp.displayProductDetails(product_id));
                }
                //Here we will showcase recycling instructions of specified Product object
                else if(user_input.equals("5")){
                    //Here we will display recycling instructions of a product
                    printOutput("Enter ID of product you wish to recycle: ");
                    String productId = readInput();

                    ProvideGuidanceResult result = serviceApp.provideGuidance(productId);
                    formatter.printProvideGuidanceResult(result);
                    
                
                }
                //This option will calculate impact of product 
                else if(user_input.equals("6")){
                    printOutput("Option6");
                    
            
                }
                //Exit program
                else if(user_input.equals("Q")){
                    printOutput("Exiting program..."); 
                    break;
                
                }
                //If user tries to enter something other than the values for menu options
                else{
                    printOutput("Unrecognized input. Please type one of the chosen values provided in the list.");
                    
                }
            }
            catch(Exception e){
                printOutput(e.toString());
            }
        }
    }


    public String readInput(){

        String user_response = input.nextLine();
        return user_response;
    }

    public void printOutput(String string){
        System.out.print(string);
    }
}