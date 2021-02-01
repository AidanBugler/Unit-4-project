import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) throws IOException {
  
  ArrayList<ContactInfo> contactList = new ArrayList(); 
  
  File myFile = new File("PhoneBook.txt");
  myFile.createNewFile();

    int fileLength = 0;
    Scanner myReader = new Scanner (myFile);
    while (myReader.hasNextLine())
    {
      fileLength = fileLength+1;
      myReader.nextLine(); 
    }
    myReader.close();
    myReader = new Scanner (myFile);
    for(int i =0; i<fileLength/5; i++)
    {
      ContactInfo contact  = new ContactInfo(); 
      contact.setFirstName(myReader.nextLine());
      contact.setLastName(myReader.nextLine());
      contact.setPhoneNumber(Long.parseLong(myReader.nextLine()));
      contact.setContactEmail(myReader.nextLine());
      contact.setContactAge(Integer.parseInt(myReader.nextLine()));
      contactList.add (contact);
    }
    myReader.close();
// When doing each varable will have the same name but wont give 2 shits !!!!!
    
//output
   for (int i = 0; i< fileLength/5; i++)
    {
      System.out.println(contactList.get(i).getFirstName());
      System.out.println(contactList.get(i).getLastName()); 
      System.out.println(contactList.get(i).getPhoneNumber());
      System.out.println(contactList.get(i).getContactEmail());
      System.out.println(contactList.get(i).getContactAge());
      System.out.println();
    }
  //FileWriter myWriter = new FileWriter (myFile);
  //myWriter.write("This works");
  //myWriter.close();
  }
}