import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;


class Main {

  static int binarySearchMethod(ArrayList <ContactInfo> contactList,String key)
  { 
    int mid = contactList.size() /2;
    int first =0;
    int last = contactList.size()-1;

    while (first<=last)
    {
      if (contactList.get(mid).getFullName().compareTo(key)<0)
      {
        first =mid +1;
      }
      else if (contactList.get(mid).getFullName().equals(key))
      {
       return mid; 
      }
      else
      {
        last = mid-1;
      }
      mid =(first+last)/2;
      if (first>last)
      {
        return -1;
      } 
    }
  return -1;
  }

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

  static ArrayList<ContactInfo> remainderNameSortMethod(ArrayList <ContactInfo> contactList, int arrLength)
  {
    if (arrLength==0)
    {
      return contactList;
    }
    ContactInfo info;
    for (int i = 0; i < arrLength-1; i++) 
    {
      if (contactList.get(i).getFullName().compareTo(contactList.get(i + 1).getFullName()) > 0) 
      {
      info = contactList.get(i);
      contactList.set(i,contactList.get(i+1));
      contactList.set(i+1,info);
      }
    }

  return remainderNameSortMethod(contactList,arrLength-1);
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

int userInput;
Scanner input = new Scanner(System.in);
boolean isPhoneNumberEntered;

String tempPhoneNumber;

  do
  {  
  System.out.println("Welcome to The Daily Bugle, your one stop shop for everyones information!");
  System.out.println("What would you like to do today?");
  System.out.println("1. Add a contacts info                         2. Delete a contacts info");  
  System.out.println("3. Show all current contacts (by phone number) 4. Search for contacts by name");
  System.out.println("5. Exit the Daily Bugle");
  System.out.println(); 
  userInput=Integer.parseInt(input.nextLine());
  System.out.println(); 
    if (userInput == 1)
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
    if (userInput == 2)
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
    if (userInput == 3)
    {
      for (int i =0; i <contactList.size(); i++)
      {
      System.out.println(remainderNumberSortMethod(contactList,contactList.size()).get(i).getFullName());
      }   
    }
    
String searchKey;    
    if (userInput == 4)
    {
    contactList = remainderNameSortMethod(contactList, contactList.size());  
    do {
    System.out.println("What is the full name of the person you are looking for?");
    searchKey = input.nextLine();  

    if (binarySearchMethod(contactList,searchKey)== -1)
     {
       System.out.println("This person does not exist and is a figment of your imagination");
     }
    else
     {
       for(int i =0; i<contactList.size();i++)
       {
         if(contactList.get(i).getFullName().equals(searchKey))
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
    } while(binarySearchMethod(contactList,searchKey)== -1);
   }         
  }while(userInput!=5);
// When doing each varable will have the same name but wont give 2 shits !!!!!
    
//output   
   FileWriter myWriter = new FileWriter (myFile);
    for (int i= 0; i<contactList.size(); i++)
    {
    myWriter.write(contactList.get(i).getFirstName()+"\n");
    myWriter.write(contactList.get(i).getLastName()+"\n");
    myWriter.write(contactList.get(i).getPhoneNumber()+"\n");
    myWriter.write(contactList.get(i).getContactEmail()+"\n");
    myWriter.write(contactList.get(i).getContactAge()+"\n");
    }
    myWriter.close(); 
   
  }
}