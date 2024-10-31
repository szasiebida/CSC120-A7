import java.util.ArrayList;
public class House extends Building {

  //new attributes for the house class
  private ArrayList<String> residents; 
  private boolean hasDiningRoom;

  //need to use the building constructor 
  //use super inside the constructor to say before you can make a house make a building
  //add the extra functionality and attributes for the house class 
  //in the house constructor need to initilza the array list of residents and a boolean rrepresenting if it has a dining room 
  //dining room boolean willbe passed in to the constructor 
  //when someone is moving in check to make sure they live there fist and that there is enough room 
  //resident array list is private so need a method to check is someone lives in a house use array list methods 


  /**
   * constructor for the house class extends the building class
   * @param name the name of the house
   * @param address the adress of the house
   * @param nFloors the number of floors
   * @param hasDiningRoom boolean reflecting if the house has a dining room 
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address,nFloors);
    this.hasDiningRoom=hasDiningRoom;
    this.residents=new ArrayList<String>(0);
    System.out.println("You have built a house: 🏠");
  }

  //accesors for the house class

  /**
   * accesor to see if the house has a dining room
   * @return boolean depending on if the house has a dining room 
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }
  
  /**
   * accesor to determine the number of residents in a house 
   * @returnthe number of residents in a house
   */
  public int nResidents(){
    return this.residents.size();
  }

  //methods for the house class

  /**
   * method to check if someone lives in a house 
   * @param person the person who is being checked 
   * @return a boolean reflecting if the person lives in the house
   */
  public boolean isResident(String person){
    return this.residents.contains(person);
  }

  /**
   * method to move someone in to a house 
   * @param name the person who is moving in to the house
   */
  public void moveIn(String name){
    if (isResident(name)){
      System.out.println("they already live here!");
    } else{
      this.residents.add(name);
    }
  }

  /**
   * method to remove a person from the house 
   * @param name the person who is moving out of the house
   * @return the name of the person who is moving out of the house
   */
  public String moveOut(String name){
    if (isResident(name)){
      this.residents.remove(name);
    } else{
      System.out.println("they don't live here so they can't move out");
    }
    return name; 
  } 

  public static void main(String[] args) {
    House myhouse= new House("sofias house","1 chapin way",5, true);
    System.out.println(myhouse.hasDiningRoom());
    myhouse.moveIn("sofia");
    System.out.println(myhouse.residents);
    System.out.println(myhouse.isResident("sofia"));
    myhouse.moveOut("sofia");
    System.out.println(myhouse.residents);
  }
}