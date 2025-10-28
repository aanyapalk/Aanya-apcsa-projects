package piglatin;

import java.io.IOException;
import java.util.Scanner;

public class PigLatinTranslator {

    public static Book translate(Book originalBook) {
        Book pigLatinBook = new Book();

        // Translate the title
        String translatedTitle = translate(originalBook.getTitle());
        pigLatinBook.setTitle(translatedTitle);

        // Translate each line
        for (int i = 0; i < originalBook.getLineCount(); i++) {
            String translatedLine = translate(originalBook.getLine(i));
            pigLatinBook.appendLine(translatedLine);
        }

        return pigLatinBook;
    }

    public static String translate(String sentence) {
        StringBuilder translatedSentence = new StringBuilder();
        Scanner wordScanner = new Scanner(sentence);

        while (wordScanner.hasNext()) {
            translatedSentence.append(translateWord(wordScanner.next()));
            if (wordScanner.hasNext()) {
                translatedSentence.append(" ");
            }
        }

        wordScanner.close();
        return translatedSentence.toString();
    }

    private static String translateWord(String word) {
        String vowels = "aeiouyAEIOUY";
        String digits = "0123456789";
        String punctuationMarks = ".,;:?!]}[{*#_$%@!&^()~`/|<>-+=";

        if (word.length() == 0 || word.charAt(0) == ' ') {
            return "";
        }

        // Ignore numbers or punctuation-only words
        if (digits.indexOf(word.charAt(0)) >= 0 || punctuationMarks.indexOf(word.charAt(0)) >= 0) {
            return word;
        }

        // Separate trailing punctuation
        String punctuation = "";
        if (punctuationMarks.indexOf(word.substring(word.length() - 1)) >= 0) {
            punctuation = word.substring(word.length() - 1);
            word = word.substring(0, word.length() - 1);
        }

        // Count vowels
        int vowelCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) >= 0) {
                vowelCount++;
            }
        }

        if (vowelCount == 0) {
            return word + "ay" + punctuation;
        }

        boolean startsWithCapital = Character.isUpperCase(word.charAt(0));
        String lowerCasedWord = Character.toLowerCase(word.charAt(0)) + word.substring(1);

        String pigLatinWord;
        if (vowels.indexOf(lowerCasedWord.charAt(0)) != -1 || word.length() == 1) {
            pigLatinWord = word + "ay";
        } else {
            while (vowels.indexOf(lowerCasedWord.charAt(0)) == -1) {
                lowerCasedWord = lowerCasedWord.substring(1) + lowerCasedWord.charAt(0);
            }
            pigLatinWord = lowerCasedWord + "ay";
        }

        if (startsWithCapital) {
            pigLatinWord = Character.toUpperCase(pigLatinWord.charAt(0)) + pigLatinWord.substring(1);
        }

        return pigLatinWord + punctuation;
    }
}