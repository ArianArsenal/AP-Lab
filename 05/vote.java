import java.util.ArrayList;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Voting {
    private String question;
    private HashMap <String, HashSet<Vote>> choices;
    private boolean multiChoice;
    private boolean isAnonymous;
    private ArrayList <Person> voters = new ArrayList<>();

    public Voting(String question, boolean multiChoice, boolean isAnonymous) {
        this.question = question;
        this.multiChoice = multiChoice;
        this.isAnonymous = isAnonymous;
    }

    public void createChoices(ArrayList<String> givenChoices){
        choices = new HashMap<>();
        for (String givenChoice : givenChoices) {
            choices.put(givenChoice, new HashSet<>());
        }
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getChoices(){
        ArrayList<String> choices = new ArrayList<>(this.choices.keySet());
        return choices;
    }

    public boolean isMultiChoice() {
        return multiChoice;
    }

    public void vote(String firstName , String lastName , ArrayList<String> choices){
        Person person = new Person(firstName , lastName);
        voters.add(person);
        for (String choice : choices) {
            HashSet<Vote> votes = this.choices.get(choice);
            Date date = new Date();
            votes.add(new Vote(person, date.toString()));
            this.choices.put(choice, votes);
        }
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void printAnonymous(){
        System.out.println(question);
        for (String str:choices.keySet()) {
            System.out.println("\t" + str + " : " + choices.get(str).size());
        }
    }

    public void printNonAnonymous(){
        System.out.println(question);
        for (String str: choices.keySet()) {
            System.out.println(str + " : {" );
            for (Vote vote : choices.get(str)) {
                System.out.println(vote.getVoter());
            }
            if(choices.get(str).size() == 0){
                System.out.println("No voters");
            }
            System.out.println("}");
        }
    }
}



public class VotingSystem {
    ArrayList <Voting> votingList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void createVoting(){
        System.out.println("please type your question :");
        String question = input.nextLine();
        boolean anonymous;
        while (true){
            System.out.println("do you want the vote to be anonymous :\n1.yes\t2.no");
            String temp = input.nextLine();
            if(temp.equals("yes") || temp.equals("1")){
                anonymous = true;
                break;
            }
            else if(temp.equals("no") || temp.equals("2")){
                anonymous = false;
                break;
            }
            else {
                System.out.println("invalid input!");
            }
        }
        boolean multiChoice;
        while (true){
            System.out.println("do you want the vote to be multiChoice :\n1.yes\t2.no");
            String temp = input.nextLine();
            if(temp.equals("yes") || temp.equals("1")){
                multiChoice = true;
                break;
            }
            else if(temp.equals("no") || temp.equals("2")){
                multiChoice = false;
                break;
            }
            else {
                System.out.println("invalid input!");
            }
        }
        ArrayList <String> choices = new ArrayList<>();
        System.out.println("please type your choices and when you're done type \"DONE!\" :");
        while (true){
            String choice = input.nextLine();
            if(choice.equals("DONE!")){
                break;
            }
            choices.add(choice);
        }
        System.out.println("voting successfully created.");

        Voting voting = new Voting(question , multiChoice , anonymous);
        voting.createChoices(choices);
        votingList.add(voting);
    }

    public boolean showQuestions(){
        if(votingList.size() == 0){
            System.out.println("there is no voting!");
            return false;
        }
        else {
            for (int i = 0; i <votingList.size() ; i++) {
                System.out.println((i+1) + ". " + votingList.get(i).getQuestion());
            }
            return true;
        }
    }


    public void vote(String firstname , String lastname){
        if(showQuestions()){
            int questionNumber = Integer.parseInt(input.nextLine());
            questionNumber--;
            System.out.println("------------------------------");
            Voting voting = votingList.get(questionNumber);
            ArrayList<String> questionChoices = voting.getChoices();
            System.out.println(voting.getQuestion());
            if(voting.isMultiChoice()){
                for (int i = 0; i < questionChoices.size(); i++) {
                    System.out.println((i+1) + ". " + questionChoices.get(i));
                }
                System.out.println("this is a multi choice question enter your choices and then type\"DONE!\"");
                String temp;
                ArrayList<String> givenChoices = new ArrayList<>();
                while (true){
                    temp = input.nextLine();
                    if(temp.equals("DONE!")){
                        break;
                    }
                    else{
                        int index = Integer.parseInt(temp) -1 ;
                        givenChoices.add(questionChoices.get(index));
                    }
                }
                voting.vote(firstname , lastname , givenChoices);
            }
            else {
                for (int i = 0; i < questionChoices.size(); i++) {
                    System.out.println((i+1) + ". " + questionChoices.get(i));
                }
                ArrayList<String> givenChoices = new ArrayList<>();
                int index = Integer.parseInt(input.nextLine()) -1;
                givenChoices.add(questionChoices.get(index));
                voting.vote(firstname , lastname , givenChoices);
            }
        }
    }

    public void printResult(){
        if(showQuestions()) {
            int questionNumber = Integer.parseInt(input.nextLine());
            questionNumber--;
            System.out.println("------------------------------");
            Voting voting = votingList.get(questionNumber);
            if(voting.isAnonymous()){
                voting.printAnonymous();
            }
            else{
                voting.printNonAnonymous();
            }
        }

    }

}
