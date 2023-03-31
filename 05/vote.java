import java.util.ArrayList;
import java.util.Objects;


class Vote {

    private final Person voter;
    private final String date;

    public Vote (Person voter,String date){
        this.voter = voter;
        this.date = date;
    }

    public Person getVoter() {
        return voter;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "" + voter + "-" + date ;
    }

    @Override
    public boolean equals(Object o){

        if ( this == o) return true;
        if ( !(o instanceof VotingSystem)) return false;
        VotingSystem that = (VotingSystem) o;
        return Objects.equals(getVotingList(), that.getVotingList());

    }

    @Override
    public int hashCode(){
        return Objects.hash(getVotingList());
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
        return firstname + "-" + lastname;
    }
    
}

public class vote {
    public static void main(String[] args) {
        
        
    }
}
