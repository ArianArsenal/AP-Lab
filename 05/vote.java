import java.util.ArrayList;


class Vote {

    private final Person voter;
    private final String date;

    public Vote (Person voter,String date){
        this.voter = voter;
        this.date = date;
    }




}

class Person {

    private String firstname;
    private String lastname;
    
    
    public Person(String firstname,String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public String getFirstName(){
        return firstname;
    }

    public String getLastName(){
        return lastname;
    }
    

    public String toString(){
        return firstname + '-' + lastname;
    }
    
}

public class vote {
    public static void main(String[] args) {
        
        
    }
}
