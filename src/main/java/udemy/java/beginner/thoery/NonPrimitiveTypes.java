package udemy.java.beginner.thoery;

import java.util.Scanner;

public class NonPrimitiveTypes {



    public static void main(String[] args) {
        // Non primitive type
        // String - as this is a class
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value");
        double value = scanner.nextDouble();
        System.out.println("Entered value " + value );

        // In UK and US 5$ 6 cents is 5.6
        // But in Europe its 5,6
        Robot robot = new Robot();
        String name = "Dumbo";
        robot.speak(name);
        System.out.println(name);
        int height = 7;
        robot.jump(height);
    }
}

class Robot{
    // In Java everything is pass by value

    public void speak(String name){
        name += "Robot";
        System.out.println("Hello" + name);


    }

    // Pass by value as its primitive
    public void jump ( int height){
        System.out.println("Jumping" + height);
    }
}