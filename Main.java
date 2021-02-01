import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;


class Main {

  static ArrayList<ContactInfo> remainderNumberSortMethod(ArrayList <ContactInfo> contactList, int arrLength)
  {
    if (arrLength==0)
    {
      return contactList;
    }
    ContactInfo info;
    for (int i = 0; i < arrLength-1; i++) 
    {
      if (contactList.get(i).getPhoneNumber() > contactList.get(i + 1).getPhoneNumber()) 
      {
      info = contactList.get(i);
      contactList.set(i,contactList.get(i+1));
      contactList.set(i+1,info);
      }
    }

  return remainderNumberSortMethod(contactList,arrLength-1);
  }

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

int userImput;
Scanner input = new Scanner(System.in);
boolean isPhoneNumberEntered;

String tempPhoneNumber;

  do
  {  
  System.out.println("Welcome to The Daily Bugle, your one stop shop for everyones information!");
  System.out.println("What would you like to do today?");
  System.out.println("1. Add a contacts info                         2. Delete a contacts info");  
  System.out.println("3. Show all current contacts (by phone number) 4. Search for contacts by name");
  System.out.println("5. Display all contacts and exit the Daily Bugle");
  System.out.println(); 
  userImput=Integer.parseInt(input.nextLine());
    if (userImput == 1)
    {
      ContactInfo contact  = new ContactInfo();
      System.out.println("What is their First Name?");
      contact.setFirstName(input.nextLine());
      System.out.println("What is their Last Name?");      
      contact.setLastName(input.nextLine());
      isPhoneNumberEntered = false;
      do {
      System.out.println("What is their phone number? (xxx-xxx-xxxx format)");
      tempPhoneNumber = input.nextLine();
      if(tempPhoneNumber.length() == 12)
       {
         if(tempPhoneNumber.charAt(3) == '-'&& tempPhoneNumber.charAt(7)=='-')
         {
           try 
            {
            tempPhoneNumber = tempPhoneNumber.replaceAll("-","");
            contact.setPhoneNumber(Long.parseLong(tempPhoneNumber)); 
            isPhoneNumberEntered  = true;       
            }
            catch(Exception e)
           {
            System.out.println("Thats not a real number silly!");
            isPhoneNumberEntered = false;
           }
         }
       }
      }while (isPhoneNumberEntered == false);
      System.out.println("What is their email?");
      contact.setContactEmail(input.nextLine());
      System.out.println("Finaly, how old is this person?");
      contact.setContactAge(Integer.parseInt(input.nextLine()));
      contactList.add (contact);
    }
    

    String userNameInput;
    if (userImput == 2)
    {
      System.out.println("Who's name will you be deleting?");
      userNameInput = input.nextLine();
      for (int i=0; i <contactList.size(); i++)
      {
        while(i<contactList.size()&&contactList.get(i).getFullName().equals(userNameInput))
        {
          contactList.remove(i);
        }
      }
    }
    if (userImput == 3)
    {
      for (int i =0; i <contactList.size(); i++)
      {
      System.out.println(remainderNumberSortMethod(contactList,contactList.size()).get(i).getFullName());
      }   
    }
    if (userImput == 4)
    {
      System.out.println("User picked 4");
    }         
  }while(userImput!=5);
// When doing each varable will have the same name but wont give 2 shits !!!!!
    
//output
   if (userImput == 5){
   for (int i = 0; i< contactList.size(); i++)
     {
      System.out.println(contactList.get(i).getFirstName());
      System.out.println(contactList.get(i).getLastName()); 
      System.out.println(contactList.get(i).getPhoneNumber());
      System.out.println(contactList.get(i).getContactEmail());
      System.out.println(contactList.get(i).getContactAge());
      System.out.println();
     }
    }
  }
}