package piglatin;

public class App {
    public static void main(String[] args)
    {
        /*  Introduction and 

        This project is setup with four main classes:
            1. App - the main application
            2. Book - a class that creates the basic book objects.
                - a Book contains a representation of a real book.
                - Book has methods to read data in from various sources
                - Book also has methods to read data out.
            3. PigLatinTranslator - a static class
                - Used to implement your translator.
                - Has two public methods to take input and return a translated copy.
                    - Book translate(Book input)
                    - String translate(String input)
            4. TestSuite - a simple class that helps you test your work.
                - Just like CodingBat this class tries your code against various cases.
                - It will tell you which cases return expected output or not
         */


        // Run tests, comment out once they pass.
        int score = TestSuite.run();

        // Focus on TestSuite until you get a score of 5 or higher.
        if (score > 4)
        {
            // Starter book
            Book Testinput = new Book();

            // Start with a "test" book based on a string.
            // Get this to work, and all the tests to pass first.
            //input.readFromString("TestBook", "Dog\nCat\nMouse");

            // Example reading from a URL
            Testinput.readFromUrl("Romeo and Juliette", "https://www.gutenberg.org/cache/epub/1342/pg1342.txt");

            Testinput.printlines(0,Testinput.getLineCount());
            Book output = new Book();
            output = PigLatinTranslator.translate(Testinput);
            //System.out.println(output);
            output.printlines(0,output.getLineCount());
            output.writeToFile("Pride.txt");
        }
    }
}

