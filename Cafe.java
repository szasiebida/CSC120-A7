public class Cafe extends Building{

    //atributes for the cafe class
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * constructor for the cafe class
     * @param name name of cafe
     * @param address adress of cafe
     * @param nFloors number of floors
     * @param nSugarPackets number of sugar packets
     * @param nCoffeeOunces ounces of coffee
     * @param nCreams number of creams 
     * @param nCups number of cups 
     */
    public Cafe(String name, String address, int nFloors, int nSugarPackets , int nCoffeeOunces, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces=nCoffeeOunces;
        this.nSugarPackets=nSugarPackets;
        this.nCoffeeOunces=nCoffeeOunces;
        this.nCreams=nCreams;
        this.nCups=nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * default constructor that makes the CC 
     */
    public Cafe(){
        this("CC","1 chapin way",2,100,100,100,100);
    }

    /**
     * constructor that takes an input for the name and address but defaults on the values of materials
     * @param name name of the cafe
     * @param address address of the cafe 
     */
    public Cafe(String name, String address){
        this(name, address, 1, 100,100,100,100);
    }

    /**
     * method to make a coffee and remove the appropriate amounts from the innventory 
     * @param size size of the coffee
     * @param nSugarPackets number of sugars in the coffee
     * @param nCreams number of creams in the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (size>this.nCoffeeOunces || nSugarPackets>this.nSugarPackets || nCreams>this.nCreams){
            restock(size, nSugarPackets,nCreams,1);
        }
        this.nCoffeeOunces-=size;
        this.nSugarPackets-=nSugarPackets;
        this.nCreams-=nCreams;
        this.nCups-=1;
    }

    /**
     * method that restocks the innventory based on the inputed amounts 
     * @param nCoffeeOunces the amount of coffee to be restocked 
     * @param nSugarPackets the number of sugar packets to be restocked 
     * @param nCreams the number of creams to be restocked
     * @param nCups the number of cups to be restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces+= nCoffeeOunces;
        this.nSugarPackets+= nSugarPackets;
        this.nCreams+=nCreams;
        this.nCups+=nCups;
    } 
    
    /**
     * overided showOptions method for cafe class
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + sellCoffee(size, nSugarPackets, nCreams)\n + restock(nCoffeeOunces,  nSugarPackets, nCreams, nCups) ");
    }

    /**
     * overided method to go to a floor that is not valid because cafes dont have elevators 
     * @param floorNum the floor number you want to go to 
     */
    public void goToFloor(int floorNum) {
        System.out.println("cafes dont have elevators sorry");
    }

    public static void main(String[] args) {
        Cafe mycafe= new Cafe("compass","library",6, 20,100,20,20);
        System.out.println(mycafe.nCoffeeOunces);
        mycafe.sellCoffee(12, 1, 1);
        System.out.println(mycafe.nCoffeeOunces+"and" + mycafe.nSugarPackets+"and" + mycafe.nCreams + "and"+ mycafe.nCups);
        mycafe.sellCoffee(200, 30, 20);
        System.out.println(mycafe.nCoffeeOunces+"and" + mycafe.nSugarPackets+"and" + mycafe.nCreams + "and"+ mycafe.nCups);
    }
}
