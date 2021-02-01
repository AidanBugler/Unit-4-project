public class ContactInfo
{
  private String firstName;
  private String lastName;
  private long phoneNumber;
  private String contactEmail;
  private int contactAge;

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public long getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getContactEmail()
  {
    return contactEmail;
  }

  public int getContactAge()
  {
    return contactAge;
  }

  public void setFirstName(String newFirstName)
  {
    this.firstName = newFirstName;
  }

  public void setLastName(String newLastName)
  {
    this.lastName = newLastName;
  }

  public void setPhoneNumber(long newPhoneNumber)
  {
    this.phoneNumber = newPhoneNumber;
  }

  public void setContactEmail(String newContactEmail)
  {
    this.contactEmail = newContactEmail;
  }

  public void setContactAge(int newContactAge)
  {
    this.contactAge = newContactAge;
  }
}  