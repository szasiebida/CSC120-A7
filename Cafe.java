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
        

    public static void main(String[] args) {
        Cafe mycafe= new Cafe("compass","library",6, 20,100,20,20);
        System.out.println(mycafe.nCoffeeOunces);
        mycafe.sellCoffee(12, 1, 1);
        System.out.println(mycafe.nCoffeeOunces+"and" + mycafe.nSugarPackets+"and" + mycafe.nCreams + "and"+ mycafe.nCups);
        mycafe.sellCoffee(200, 30, 20);
        System.out.println(mycafe.nCoffeeOunces+"and" + mycafe.nSugarPackets+"and" + mycafe.nCreams + "and"+ mycafe.nCups);
    }
}
