import java.util.Hashtable;
public class Library extends Building{
//have a collection of titles but need to use a hashtable instead of array list (hastable 
//isnt organized but it is retrievable by name sort of like a dictionary the key is the title)
//when add title dont need a boolean value 
//when remove a title check if the title is checked out (use put and remove)
//checkout a title make sure its there and that no one already has it 
//change the status of the book when you check it out use (replace)


  //atributes
  private Hashtable<String, Boolean> collection;

  //constructor 
  /**
   * constructor for the library that extends the building class
   * @param name name of the building 
   * @param address address of building
   * @param nFloors number of floors 
   */
  public Library(String name, String address, int nFloors) {
    super(name, address,nFloors);
    this.collection= new Hashtable<String, Boolean>(0);
    System.out.println("You have built a library: 📖");
  }

  //methods for the library class
  /**
   * method that adds a book to the collection 
   * @param title title of the book
   */
  public void addTitle(String title){
    this.collection.put(title,true);
  }

  /**
   * function that removes a book from the collection 
   * @param title title of the book
   * @return the title of the book that was removed
   */
  public String removeTitle(String title){
    if (containsTitle(title) && isAvailable(title)){
      this.collection.remove(title);
    } else{
      System.out.println("this book cannot be removed");
    }
    return title;
  } 
  
  /**
   * method that checks out a book by changing its value to false 
   * @param title title of the book
   */
  public void checkOut(String title){
    if (containsTitle(title) && isAvailable(title)){
      this.collection.replace(title,false);
    } else{
      System.out.println("this book cannot be checked out");
    }
  }

  /**
   * method that returns a vook to the collection by changing its value to true 
   * @param title title of the book
   */
  public void returnBook(String title){
    if (containsTitle(title) && this.collection.get(title)==false){
      this.collection.replace(title,true);
    } else{
      System.out.println("this book cannot be returned");
    }
  }

  /**
   * method that checks if a book is present in the collection 
   * @param title title of the book
   * @return boolean representing if a title is contained in the collection
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  } 

  /**
   * methid that checks if a book is avaliable to be checked out 
   * @param title title of the book 
   * @return returns true if the title is currently available, false otherwise
   */
  public boolean isAvailable(String title){
    return this.collection.get(title)==true;

  } 

  /**
   * prints out the entire collection in an easy-to-read way (including checkout status)
   */
  public void printCollection(){
    for (String key : this.collection.keySet()){
      if (isAvailable(key)){
        String isit= " is avaliable";
        System.out.println(key+isit);
      } else {
        String isit= " is not avaliable";
        System.out.println(key+isit);
      }
    }
  } 

  public static void main(String[] args) {
    Library mylib= new Library("nielson","123 lane",4);
    mylib.addTitle("meow");
    System.out.println(mylib.collection);
    // mylib.removeTitle("meow");
    mylib.checkOut("meow");
    System.out.println(mylib.collection.get("meow"));
    mylib.returnBook("meow");
    mylib.addTitle("arf");
    mylib.checkOut("arf");
    System.out.println(mylib.collection.get("meow"));
    System.out.println(mylib.containsTitle("meowy"));
    mylib.printCollection();
  }
  
}