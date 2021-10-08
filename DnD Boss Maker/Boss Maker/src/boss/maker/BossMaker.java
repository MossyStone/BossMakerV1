/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boss.maker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Ivy @ MossyStone
 */
public class BossMaker {
    //creates the basic 6 stats
        //0 is strength then coniune down list as 6 is charsma
    private int[] statRolls;
    //self insert total of all dice rolls in the book.
    private int expectedTotalRoll;
    //dice slected for the ability stats
    private int dieChoosen;
    //2d Array to store bpth basic stat roll and modifier to call it forth
    private int[] modifiers;
    //Langauges arryaList
    private ArrayList<String> standardLang;
    private ArrayList<String> exoticLang;
    //resistances
    private ArrayList<String> resistance;
    private ArrayList<String> immunities;

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BossMaker test = new BossMaker();
        
        System.out.println("Hello! Welcome to Boss Maker. If you would like to "
                + "make a boss please type 'yes' otherwise type 'no'.");
        String start = scan.nextLine();
        
        while(start.equalsIgnoreCase("yes")){
           test.createMonster();

            System.out.println("Do you wish to make another? type 'yes' otherwise type 'no'.");
            start = scan.nextLine();
        }
    }
    
    //Start of Bossmaker constructor
    public BossMaker(){
        statRolls = new int[6];
        modifiers = new int[6];
    }//end of BoassMaker Conctructor
    
    //setter methods
    
    
    //rolls that stats up to 20
    private void makeStatRolls(int diceSelected, int abilityMin){
        expectedTotalRoll = abilityMin;
        dieChoosen = abilityMin;
        //choose between 30 as the max or 20
        if(diceSelected == 30){
              for(int i = 0; i < 6; i++){
            statRolls[i] = (int) (Math.random() * 30);
            }
        }
        
        else{
              for(int i = 0; i < 6; i++){
            statRolls[i] = (int) (Math.random() * 20);
            }
        }
      
        checkStatNum();
    }//end of makeStatRolls
    
    
    
     //setter method for expectedTotalRoll
    public void setTotalStats(int total){
        expectedTotalRoll = total;
    }//end of setTotalStats      
    
    //setter method for the modifiers given from statRolls[]
    public void setMods(){
        int[][] modifiersNums = new int[][]{
            
        };
        for(int i = 0; i < statRolls.length; i++){
                //there has to be a faster/better way to do this
                if(statRolls[i] == 1){
                    modifiers[i] = -5;
                }
                
                else if(statRolls[i] == 2 || statRolls[i] == 3){
                    modifiers[i] = -4;
                }
                
                else if (statRolls[i] == 4 || statRolls[i] == 5) {
                    modifiers[i] = -3;
                }
                
                else if(statRolls[i] == 6 || statRolls[i] == 7){
                    modifiers[i] = -2;
                }
                
                else if(statRolls[i] == 8 || statRolls[i] == 9){
                    modifiers[i] = -1;
                }
                
                else if(statRolls[i] == 10 || statRolls[i] == 11){
                    modifiers[i] = 0;
                }
                
                else if(statRolls[i] == 12 || statRolls[i] == 13){
                    modifiers[i] = 1;
                }
                
                else if(statRolls[i] == 14 || statRolls[i] == 15){
                    modifiers[i] = 2;
                }
                
                else if(statRolls[i] == 16 || statRolls[i] == 17){
                    modifiers[i] = 3;
                }
                
                else if(statRolls[i] == 18 || statRolls[i] == 19){
                    modifiers[i] = 4;
                }
                
                else if(statRolls[i] == 20 || statRolls[i] == 21){
                    modifiers[i] = 5;
                }
                
                else if(statRolls[i] == 22 || statRolls[i] == 23){
                    modifiers[i] = 6;
                }
                
                else if(statRolls[i] == 24 || statRolls[i] == 25){
                    modifiers[i] = 7;
                }
                
                else if(statRolls[i] == 26 || statRolls[i] == 27){
                    modifiers[i] = 8;
                }
                
                else if(statRolls[i] == 28 || statRolls[i] == 29){
                    modifiers[i] = 9;
                }
                
                else if(statRolls[i] == 30){
                    modifiers[i] = 10;
                }
                
                //if 13 failure occcures
                else
                {
                    modifiers[i] = 13;
                }
        }
    } //end of setMods
    
    
    
    //Getter Methods
    
    
    //getter method for expectedTotalRoll
    public int getTotalStats(){
        return expectedTotalRoll;
    }//get of getTotalStats 
    
    //getter method for statRolls[] as a String
    public String getStatRolls(){
        //Use toString unless you want gibberish
        return Arrays.toString(statRolls);
    }//end of getStatRolls
    
    //getter method for modieferies
    public String getModifiers(){
        //Use toString unless you want gibberish
        return Arrays.toString(modifiers);
    }//end of getModifiers
    
    //getter for exotic languages
    public ArrayList<String> getExoticLangugaes(){
        return exoticLang;
    }//end of getExoticLanguages
    
   //getter for exotic languages
    public ArrayList<String> getStandardLangugaes(){
        return standardLang;
    }//end of getStandardLangauges
    
    //getter for resitences
    public ArrayList<String> getResitences(){
        return resistance;
    }//end of getStandardLangauges
    
    //getter for immunities
    public ArrayList<String> getImmunities(){
        return immunities;
    }//end of getImmunities
    
    
    //start of Setter Methods
    
    //takes the total number of stats given from the makeStatRolls 
    //and make sure it follows the stat roll total for monster
    public void checkStatNum(){
       String isStatGood = "no";
       int totalGenRoll = 0;
       
       //loop the array and add total stats together
       for(int i:statRolls){
          totalGenRoll += i;
       }
       
       //will do until theisStatGood changes to yes to meet expected total
       do{
           //compares the generated rolls to see if it meets the source total
                // >= bc it will look forever until total is met.
            if(totalGenRoll >= expectedTotalRoll){
                isStatGood = "yes";
                setMods();
            }

            else{
                makeStatRolls(dieChoosen, expectedTotalRoll);
                //System.out.println(getStatRolls());
             }
       }
       
       while(isStatGood.equals("no"));

    }//end of checkStatNum
            
    //create damage resistances
    //arraylist as the set number may change is user wishes to change amount
    public void createResistances(int amount, String type)
    {
        ArrayList<String> dam = new ArrayList<String>();
        int randomNum;
        String[] damageTypes = new String[] {"Acid", "Bludgeoning", "Cold", "Fire"
            , "Force", "Lightning", "Necrotic", "Piercing", "Poison", "Psychic",
            "Radiant", "Slashing", "Thunder"};
        
        for(int i = 0; i < amount; i++)
        {
            randomNum = (int) (Math.random() * 13);
             dam.add(damageTypes[randomNum]);
        }
        
//        System.out.println("Unsorted");
//        for(int i = 0; i < amount; i++)
//        {
//            System.out.println(dam.get(i));
//        }
//        System.out.println("\nSorted");
        //use a TreeSet allows for sorting and no dups
        TreeSet<String> damTypes = new TreeSet<>(dam);
        
        //uses an iterator to sort through the treeset
        Iterator<String> sorting = damTypes.iterator();
//        while(sorting.hasNext())
//        {
//            System.out.println(sorting.next());
//        }
        
        //see if there are less reisteences then there should be
        //if so recurse
        if(dam.size() != amount)
        {
            createResistances(amount, type);
        }
        else{
            if(type.equalsIgnoreCase("resistance")){
                resistance = dam;
            }
            
            else if(type.equalsIgnoreCase("immunity")){
                immunities = dam;
            }
        }
    }//end of createResistances
    
    //takes in 2 ints to determine the types of languages wanted
    public void createLanguages(String type, int numLang){
        String[] exoticLanguages = new String[] {"Abyssal", "Celestial", 
            "Draconic", "Deep Speech", "Infernal", "Primordial", "Sylvan", 
            "Undercommon"};
        String[] standardLanguages = new String[] {"Common", "Dwarvish", 
            "Elvish", "Giant", "Gnomish", "Goblin", "Halfling", 
            "Orc"};
        ArrayList<String> langauges = new ArrayList<String>();
        
        if(type.equalsIgnoreCase("exotic")){
            int randomExLang = (int) (Math.random() * 8);
            for(int i = 0; i < numLang; i++){
                langauges.add(exoticLanguages[randomExLang]);
                randomExLang = (int) (Math.random() * 8);
            }
        }
        
        else if(type.equalsIgnoreCase("standard")){
            int randomStandLang = (int) (Math.random() * 8);
            for(int i = 0; i < numLang; i++){
                langauges.add(standardLanguages[randomStandLang]);
                randomStandLang = (int) (Math.random() * 8);
            }
        }
        
         TreeSet<String> lang = new TreeSet<>(langauges);
         Iterator<String> sorting = lang.iterator();
         
        if(lang.size() != numLang){
            createLanguages(type, numLang);
        }
        
        else{
            if(type.equalsIgnoreCase("exotic")){
                exoticLang = langauges;
            }
            
            else{
                standardLang = langauges;
            }
        }
    }//end of langaugeCreator func
    
    //start of createMonster
    public void createMonster(){
            Scanner scan = new Scanner (System.in);
            
            //Explaing the questions
            System.out.println("All questions below please enter as an intager, "
            + "unless otherwise stated.");
            
            //determining ability score
            System.out.println("Do you want the max roll for ability stats to be "
                    + "20 or 30? Tyepe '20' for 20 as max or '30' for 30 as "
                    + "the max");
            System.out.println("What is the minimum total for all stats? Please "
                    + "type a whole number.");
            makeStatRolls(scan.nextInt(), scan.nextInt());
            
            //setting langauges
            System.out.println("How many Standard langauges does the monster speak?");
            createLanguages("standard", scan.nextInt());
            
            System.out.println("How many exotic langauges do they speak?");
            createLanguages("exotic", scan.nextInt());
            
            //settting up resistenece/ immunities
            System.out.println("How many resistances does the monster have?");
            createResistances(scan.nextInt(), "resistance");
            
            System.out.println("How many immunnities does the monster have?");
            createResistances(scan.nextInt(), "immunity");
            
            System.out.println("");
            
            //gathering all the methods
            //rolls
            System.out.println("Total Stats: ");
            System.out.println(getTotalStats());
            System.out.println(getModifiers());
            
            System.out.println("");
            
            //Languages
            System.out.println("Langauges: ");
            System.out.println(getStandardLangugaes() + " " + getExoticLangugaes());
            
            System.out.println("");
            
            //Resistences
            System.out.println("Resistences: ");
            System.out.println(getResitences());
            System.out.println("Immunities: ");
            System.out.println(getImmunities());
            
            System.out.println("");
            
    }//end of create monster
     
    //start of the reRoll method
    public void reRoll(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Do you wish to reroll anything? " + 
                  "Please type 'yes' otherwise type 'no'.");
        String answer = scan.nextLine();
        
        while(answer.equalsIgnoreCase("yes")){
            System.out.println("What do you want to reroll?\n1 Ability Scores\n2 "
                    + "Imunnities\n3 Resistances\n 4 languages\n 5 all" );
            int reroll = scan.nextInt();
            
            //calling methods to reroll
            //rerolling stats
            if(reroll == 1){
                //confimr this is what the user wants
                System.out.println("Do you wish to reroll ability scores?" + 
                        "'yes' or 'no'");
                String confrim = scan.next();
                if(confrim.equalsIgnoreCase("yes")){
                    
                    System.out.println("You are rerolling all Ability Scores. "
                            + "Is there a certain number you wish to be the minimum "
                            + "total stat? 'yes' or 'no'");
                    String isMin = scan.next();

                    //determines if there is a mininium
                    if(isMin.equalsIgnoreCase("yes")){
                        System.out.println("Please type a whole number you wish to "
                                + "be the minimum total for ability scores.");
                        int newMin = scan.nextInt();

                        System.out.println("Do you still wish to use " + dieChoosen 
                                + " as the potential max number for an ability score?"
                                        + "'yes' or 'no'");
                        String dieChoice = scan.next();

                        //checking to see if die needs to be changed
                        if(dieChoice.equalsIgnoreCase("no")){
                            System.out.println("Please type '20' for 20 as the max"
                                    + " or '30' for 30 to be the potential max");
                            dieChoosen = scan.nextInt();
                        }

                        makeStatRolls(newMin, dieChoosen);
                        System.out.println("New Ability Stats\n" + getStatRolls()
                        + "\n New Modifiers\n" + getModifiers());
                    }    
                    
                }
            } //end of rerolling ability scores
            
            //rerolling immunities
            else if(reroll == 2){
                //confirms this is what the user wants
                System.out.println("Do you wish to reroll immuntites?" + 
                        "'yes' or 'no'");
                String confrim = scan.next();
                if(confrim.equalsIgnoreCase("yes")){
                    
                    System.out.println("You are rerolling all damage immunities. "
                            + "\nWhat is the number of immunities you want?");
                    createResistances(scan.nextInt(), "immunity");
                    
                    System.out.println("New Immunities: " + getImmunities());
                }  
            }//end of immunity reroll
            
            //start of restistence reroll
            else if(reroll == 3){
                //confirms this is what the user wants
                System.out.println("Do you wish to reroll resistances?" + 
                        "'yes' or 'no'");
                String confrim = scan.next();
                if(confrim.equalsIgnoreCase("yes")){
                    
                    System.out.println("You are rerolling all damage immunities. "
                            + "\nWhat is the number of resistances you want?");
                    createResistances(scan.nextInt(), "resistance");
                    
                    System.out.println("New Resistances: " + getResitences());
                }  
            }//end of resistance reroll
            
            //start of language reroll
            else if(reroll == 4){
                //confirms this is what the user wants
                System.out.println("Do you wish to languages, you will select "
                        + "which in a moment?" + 
                        "'yes' or 'no'");
                String confrim = scan.next();
                if(confrim.equalsIgnoreCase("yes")){
                    
                    System.out.println("Do you wihs to reroll 'standard', 'exotic'"
                            + " or 'both'");
                   String selectLang = scan.next();
                   
                   
                    
                    System.out.println("New Resistances: " + getResitences());
                }  
            }//end of resistance reroll
            
            //catch all if no numbers match
            else{
                System.out.println("Unable to understand your selection. Do you "
                        + "wish to reroll something? 'yes' or 'no'");
                answer = scan.nextLine();
            }
        }
        
        
    }//end of the reRoll method
}
