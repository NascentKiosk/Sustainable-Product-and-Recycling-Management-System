package com.mightyfour.presentation;
import java.util.HashMap;
import java.util.Scanner;
import com.mightyfour.application.MaterialService;
import com.mightyfour.application.ProductApplicationService;

public class Menu {
    //private ImpactCalculationStrategy strategy;
    private Scanner input;
    private MaterialService serviceM;
    private ProductApplicationService serviceP;

    public Menu(MaterialService serviceM, ProductApplicationService serviceP, Scanner input){ 
        this.input = input;
        this.serviceM = serviceM;
        this.serviceP = serviceP; 
    }


    
    public void menuLoop(){
        //Here we define the menu options for our program
        String menu_options = "\n1) Add a new product to repository \n2) Add material to an existing product \n3) List all products in repository \n4) View product details \n5) Get recycling guidance \n6) Calculate environmental impact of product \nQ) Quit program\n";
        //Here we initialize a variable that will be checked for menu options
        String user_input = "";

        //Here we create a temporary hashmap that will store our predefined materials for clarity purposes
        HashMap<String, String> predefined_materials = new HashMap<String, String>();


        //Here we define which materials the user can select from in the program in a form of key + value
        predefined_materials.putIfAbsent("Plastic", "Dispose of plastic waste in the bin with the 'plastic packaging' label.");
        predefined_materials.putIfAbsent("Paper", "Dispose of paper waste in the bin with the 'paper packaging' label.");
       
        //Here we add a loop that will go through all keys we have added to hashmap and then make them available to the user (add to In_memory_repository_material)
        for(String key : predefined_materials.keySet()){
            serviceM.createMaterial(key, predefined_materials.get(key));
        }


        
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

                    printOutput("List of current reusable materials: \n");
                    printOutput(serviceM.listMaterials());
                    printOutput("Enter name of material from the list: ");
                    String user_adds_material = readInput();

                    //create product using productapplicationservice
                    //lifespan just used just for testing, not fully implemented yet
                    serviceP.createProduct(user_adds_product_name, user_adds_material, 0);
                    printOutput("Action was successful.");
                }
                //Here the user will try to add another material to existing product
                else if(user_input.equals("2")){
                    printOutput("Option2");
                }
                //Here we list all products stored in repo
                else if(user_input.equals("3")){
                    printOutput("Option3");
                }
                //Here we show all details of a product
                else if(user_input.equals("4")){
                    printOutput("Option4");
            
                }
                //Here we will showcase recycling instructions of specified Product object
                else if(user_input.equals("5")){
                    printOutput("Option5");
                    
                
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
