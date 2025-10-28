package piglatin;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    Book() {
        // Empty book - no code needed here.
    }

    // Helper to debug code
    // Prints out a range of lines from a book
    public void printlines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    int getLineCount() {
        return text.size();
    }

    void appendLine(String line) {
        text.add(line);
    }

    public void readFromString(String title, String string) {
        // load a book from an input string.
        this.title = title;

        Scanner sc = new Scanner(string);
        while(sc.hasNextLine()){
            text.add(sc.nextLine());
        }
        sc.close();
        // use: text.add(line) to add a line to the book.
    }

    public void readFromUrl(String titleIn, String url) {
        // load a book from a URL.
        // https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
        this.title = titleIn;

        try {
           URL bookUrl = URI.create(url).toURL();
            Scanner sc = new Scanner(bookUrl.openStream());
            while(sc.hasNextLine()){
                this.text.add(sc.nextLine());
            }
            sc.close();
            // Scanner can open a file on a URL like this:
            // Scanner(bookUrl.openStream())
            // use: text.add(line) to add a line to the book.
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void writeToFile(String name) {
        // Must write to file using provided name.
        try (BufferedWriter br = new BufferedWriter(new FileWriter(name))) {
          //  BufferedWriter br = new BufferedWriter(new FileWriter(name));
            // File myFile = new File(name);
                for(int c = 0; c < this.getLineCount(); c ++){
                    br.write(this.getLine(c));
                    br.newLine();

                }
            br.close();
        } 
        catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}

