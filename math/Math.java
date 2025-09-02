package math;

class Math {
  public static void main(String[] args) {

    //Use the // to create single line comments to either add info or to take out code for debugging


    System.out.println("Hello world!");
    

    //We will be using System.out.println and System.out.print throughout the year. Try using both below to see what the difference is!

    System.out.print("Goodmorning!");
    System.out.println("Goodnight!");





    //ANSWER: 



    //Throughout the year this year we will need to store information. For that we will be using VARIABLES!

    //Java is an Object-Oriented programming language. All variables we use this year will either be OBJECTS or PRIMITIVES

    //There are 8 primitives in Java: int, byte, short, long, float, double, boolean, char

    //For AP we need to know: int, double, boolean

    //List examples of the types below and give definition
    //int (integer): 3, whole number
    //double: 3.14, decimal number
    //boolean: true, true or fales

    //For now we are just going to work with primitive

    //Create 3 variables of each of the above types (USE GOOD CODING PRACTICE WHEN CREATING THE VARIABLES

    int a = 3;
    int b = 5;
    int c = 0;
    double d = 3.14;
    double e = 5.75;
    double f = 7.25;
    boolean g = true;
    boolean h = false;
    boolean j = true;




    //MATH TIME!

    //What are the math operators that we can use?
    //+ - * / %

    //Try doing some math operations with numbers. How can we check to see if the math worked?

    System.out.print("What is 5 + 3? ");
    System.out.println(a+b);


    //Create codes that will print the following:

    //Odd integers from 1 to 100, inclusive of both
  for(int i=1; i<100; i++)
  {
    {if (i % 2 !=0)
    System.out.println(i);
    }
  }


  
  





    //All multiples of 3 from 1 to 100
    for(int z=1; z<=100; z++)
    {
      if (z % 3 ==0)
      {
        System.out.println(z);
      }
    }
    
    //Starting at 1000, print on the same line (with a - [hypthen] between each) all of the numbers that end in 0 going down to 0
    for (int y = 1000; y>=0; y-=10)
    System.out.print(y+"-");
  }
}