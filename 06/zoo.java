


abstract class Animal {
    
    
}

interface Hunter{

    
}

interface Prey{


}

abstract class Bird extends Animal{

}

abstract class Mammal extends Animal {

}

class Cheetah extends Mammal implements Hunter{

}

class Parrot extends Bird implements Prey{

}

class Girafe extends Mammal implements Prey{

}

class Eagle extends Bird implements Hunter{

}

/*
* the zoo class is the main class of the program
*/

public class zoo {

    public static void main(String[] args) {
        
    }
}