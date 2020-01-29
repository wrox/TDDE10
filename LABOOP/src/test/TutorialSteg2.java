package test;

import animals.Animal;
import animals.Cat;
import animals.Dog;

public class TutorialSteg2 {

    public static void main(String[] args) {
        Animal kurre = new Cat("Kurre");
        Animal vilma = new Dog("Vilma");
        
        kurre.age = 6;
        vilma.age = 3;
        
        kurre.setFriend("Vilma");
        
        kurre.introduceYourself();
        vilma.introduceYourself();
    }
}

