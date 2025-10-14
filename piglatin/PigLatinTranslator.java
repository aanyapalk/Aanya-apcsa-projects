package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        for (int i = 0; i < input.getNumPages(); i++) {
            String pageText = input.getPage(i);
            String translatedText = translate(pageText);
            translatedBook.addPage(translatedText);
        }

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // ✅ FIX: define the words array before using it
        String[] words = input.split(" ");

        StringBuilder translatedSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String translatedWord = translateWord(word);

            if (i > 0) {
                translatedSentence.append(" ");
            }

            translatedSentence.append(translatedWord);
        }

        result = translatedSentence.toString();

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";

        if (input.length() == 0) {
            return result; // empty word
        }

        // Convert to lowercase for checking vowels (optional)
        char firstChar = input.charAt(0);
        char lowerFirst = Character.toLowerCase(firstChar);

        // Check if it starts with a vowel
        if (lowerFirst == 'a' || lowerFirst == 'e' || lowerFirst == 'i' ||
            lowerFirst == 'o' || lowerFirst == 'u') {
            result = input + "way";
        } else {
            result = input.substring(1) + firstChar + "ay";
        }

        return result;
    }

    // You can add helper methods here if needed
}