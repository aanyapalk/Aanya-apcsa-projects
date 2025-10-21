package piglatin;

import java.util.ArrayList;
import java.util.List;

public class PigLatinTranslator {

    // Translate an entire Book
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        for (int i = 0; i < input.getNumPages(); i++) {
            String pageText = input.getPage(i);
            String translatedText = translate(pageText);
            translatedBook.addPage(translatedText);
        }

        return translatedBook;
    }

    // Translate a full string (sentence)
    public static String translate(String input) {
        if (input.trim().isEmpty()) return "";

        String[] words = input.split(" ");
        StringBuilder translatedSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Handle hyphenated words
            String[] parts = word.split("(?<=-)|(?=-)"); // keep hyphens as separate parts
            for (int j = 0; j < parts.length; j++) {
                if (!parts[j].equals("-")) {
                    parts[j] = translateWord(parts[j]);
                }
            }
            String translatedWord = String.join("", parts);

            if (i > 0) translatedSentence.append(" ");
            translatedSentence.append(translatedWord);
        }

        return translatedSentence.toString();
    }

    // Translate a single word into Pig Latin
    private static String translateWord(String word) {
        if (word.length() == 0) return word;

        // Separate punctuation at the end
        String punctuation = "";
        while (word.length() > 0 && !Character.isLetter(word.charAt(word.length() - 1))) {
            punctuation = word.charAt(word.length() - 1) + punctuation;
            word = word.substring(0, word.length() - 1);
        }

        if (word.length() == 0) return punctuation;

        // Check if first letter is uppercase
        boolean isCapitalized = Character.isUpperCase(word.charAt(0));

        // Find first vowel position
        int firstVowel = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                firstVowel = i;
                break;
            }
        }

        String translated;
        if (firstVowel == 0) {
            translated = word + "ay"; // starts with vowel
        } else if (firstVowel > 0) {
            translated = word.substring(firstVowel) + word.substring(0, firstVowel) + "ay"; // consonant cluster
        } else {
            translated = word + "ay"; // no vowels
        }

        // Capitalize only first letter, lowercase the rest
        if (isCapitalized) {
            translated = Character.toUpperCase(translated.charAt(0)) +
                         translated.substring(1).toLowerCase();
        }

        // Add punctuation back
        translated += punctuation;

        return translated;
    }

}

// Simple Book stub for compilation and testing
class Book {
    private List<String> pages = new ArrayList<>();

    public int getNumPages() {
        return pages.size();
    }

    public String getPage(int i) {
        return pages.get(i);
    }

    public void addPage(String pageText) {
        pages.add(pageText);
    }
}