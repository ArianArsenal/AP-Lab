
abstract class Animal {
    private int age;
    private String name;
    private String special;


    //construtor 
    public Animal(int age, String name, String special) {
        this.age = age;
        this.name = name;
        this.special = special;
    }

    public abstract void show();

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSpecial() {
        return special;
    }

}

interface Hunter{

    public void hunt(Prey prey);
    

}

interface Prey{

    public String getPreyName();

}

abstract class Bird extends Animal{
    private int altitutde;

    public Bird(int age, String name, String special,int altitutde)
    {
        super(age, name, special);
        this.altitutde = altitutde;
    }

    public int getAltitude(){
        return altitutde;
    }
}

abstract class Mammal extends Animal{
    private int speed;

    public Mammal(int age, String name, String special,int speed)
    {
        super(age, name, special);
        this.speed = speed;
    }

    public int getSpeed(){
        return speed;
    }
}

class Cheetah extends Mammal implements Hunter{

    public Cheetah(int age,String name,String special,int speed){
        super(age,name,special,speed);
    }

    @Override
    public void show(){
        System.out.println("Mammal's Name :" + getName());
        System.out.println("Mammal's Age :" + getAge());
        System.out.println("Mammal's Special :" + getSpecial());
        System.out.println("Mammal's Speed :" + getSpeed());
    }

    @Override
    public void hunt(Prey prey){
        System.out.println(""+ super.getName() +" is hunting " + prey.getPreyName());
    }
}

class Parrot extends Bird implements Prey{
    public Parrot(int age,String name,String speical,int altitude){
        super(age,name,speical,altitude);
    }

    @Override 
    public void show(){
        System.out.println("Bird's Name :" + getName());
        System.out.println("Bird's Age :" + getAge());
        System.out.println("Bird's Special :" + getSpecial());
        System.out.println("Bird's Altitude :" + getAltitude());
    }

    @Override
    public String getPreyName(){
        return super.getName();
    }
}

class Girafe extends Mammal implements Prey{
    public Girafe(int age,String name,String special,int speed){
        super(age,name,special,speed);
    }

    @Override
    public void show(){
        System.out.println("Mammal's Name :" + getName());
        System.out.println("Mammal's Age :" + getAge());
        System.out.println("Mammal's Special :" + getSpecial());
        System.out.println("Mammal's Speed :" + getSpeed());
    }

    @Override
    public String getPreyName(){
        return super.getName();
    }
}

class Eagle extends Bird implements Hunter{

    public Eagle(int age, String name, String special, int altitutde){
        super(age, name, special, altitutde);
    }

    @Override
    public void show(){
        System.out.println("Bird's Name :" + getName());
        System.out.println("Bird's Age :" + getAge());
        System.out.println("Bird's Special :" + getSpecial());
        System.out.println("Bird's Altitude :" + getAltitude());
    }

    @Override
    public void hunt(Prey prey){
        System.out.println(""+ getName() +" is hunting " + prey.getPreyName());
    }
}

/*
* the zoo class is the main class of the program
*/

public class zoo {

    public static void main(String[] args) {

        Bird eagle = new Eagle(10, "Eagle", "Sharp Eye", 100);
        Bird parrot = new Parrot(10, "Parrot", "Can Dance", 100);
        Mammal cheetah = new Cheetah(10, "Cheetah", "Fast AF", 100);
        
        Hunter hunter = (Hunter) cheetah;
        Prey prey = (Prey) parrot;
        hunter.hunt(prey);
        // cheetah.hunt(parrot);
        
    }
}