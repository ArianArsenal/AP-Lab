import java.lang.reflect.Method;
import java.util.*;
import java.util.Scanner;

class Address{

    private String zipCode;
    private String Country;
    private String City;

    public Address(){
        zipCode=null;
        Country=null;
        City=null;
    }

    public String getZipCode(){
        return zipCode;
    }
    public void setZipCode(String gotZipCode){
        zipCode=gotZipCode;
        if(zipCode.equals("")){
            zipCode="-";
        }
    }

    public String getCountry(){
        return Country;
    }
    public void setCountry(String gotCountry){
        Country=gotCountry;
        if(Country.equals("")){
            Country="-";
        }
    }

    public String getCity(){
        return City;
    }
    public void setCity(String gotCity){
        City=gotCity;
        if(City.equals("")){
            City="-";
        }
    }

    public String StringToString(){
        String address = zipCode + "/" + City + "/" + Country;
        return address;
    }

}

class PhoneNumber{

    private String CountryCode;
    private String Number;

    public PhoneNumber(){
        CountryCode=null;
        Number=null;
    }

    public String getCountryCode(){
        return CountryCode;
    }
    public void setCountryCode(String gotCountryCode){
        CountryCode=gotCountryCode;
        if(CountryCode.equals("")){
            CountryCode="-";
        }
    }

    public String getNumber(){
        return Number;
    }
    public void setNumber(String gotNumber){
        Number=gotNumber;
        if(Number.equals("")){
           Number="-";
        }
    }


    public String StringToString(){
        String number = CountryCode + "/" + Number;
        return number;
    }

}

class Contact{

    private String group;
    public String email;
    private String firstName;
    private String lastName;
    private PhoneNumber number;
    private Address address;

    public Contact(){
        group=null;
        email=null;
        firstName=null;
        lastName=null;
        number=new PhoneNumber();
        address=new Address();
    }

    public Contact(String group,String email,String Name,String lastname){
        this.group = group;
        this.email = email;
        this.firstName = Name;
        this.lastName = lastname;
    }
}


public class phonebook {


    private ArrayList<Contact> contacts;

        public phonebook(){
            contacts=new ArrayList<Contact>();
        }
    
        public boolean addContact(Contact gotContact){
            if(contacts.contains(gotContact)){
                return false;
            } else{
                contacts.add(gotContact);
                return true;
            }
        }

        public boolean removeContact(Contact gotContact){
            if(contacts.contains(gotContact)){
                contacts.remove(gotContact);
                return true;
            } else{
                return false;
            }
        }

        public Contact showContact(String email){
            for(Contact contact : contacts){
                if(contact.email.equals(email)){
                    return contact;
                }
            }
            return null;
        }

        public ArrayList<Contact> showAll(){
            return contacts;
        }



    public static void main(String[] args) {

        while(true){
        System.out.println("========\n1.Add Contact\n2.Remove Contact\n3.Show Contact\n4.Show All\n5.Exit\n========");

        int menu;

    
        Scanner scanner = new Scanner(System.in);
        menu = scanner.nextInt();

        if(menu == 1){

            System.out.println("Enter Email:");
            String email = scanner.next();

            System.out.println("Enter firstName:\n");
            String firstName = scanner.next();

            System.out.println("Enter lastName:\n");
            String lastName = scanner.next();

            System.out.println("Enter Group:\n");
            String group = scanner.next();

            Contact test = new Contact(group,email,firstName,lastName);
            
        }

        if(menu == 2){
            System.out.println("Enter Email:");
            String email = scanner.next();

            Contact test = new Contact();
            test.email = email;
            return;
        }

        if(menu == 3){
            System.out.println("Enter Email:");
            String email = scanner.next();

            Contact test = new Contact();
            test.email = email;
            return;
        }

        if(menu == 4){
            Contact test = new Contact();
            return;
        }

        if(menu == 5){
            System.exit(0);
        }
        scanner.close();
    }
    
        
    }
}
