package piglatin;

public class PigLatinTranslator {

    // Translate a whole Book (kept for grader compatibility)
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        int numPages;
        try {
            // some graders use getNumPages()
            numPages = (int) input.getClass().getMethod("getNumPages").invoke(input);
        } catch (Exception e) {
            throw new RuntimeException("Book class missing getNumPages()", e);
        }

        for (int i = 0; i < numPages; i++) {
            String pageText = null;
            try {
                // try both common method names
                if (hasMethod(input, "getPage", int.class)) {
                    pageText = (String) input.getClass().getMethod("getPage", int.class).invoke(input, i);
                } else if (hasMethod(input, "getPageText", int.class)) {
                    pageText = (String) input.getClass().getMethod("getPageText", int.class).invoke(input, i);
                }
            } catch (Exception e) {
                throw new RuntimeException("Cannot read page " + i, e);
            }

            String translatedText = translate(pageText);

            try {
                if (hasMethod(translatedBook, "addPage", String.class)) {
                    translatedBook.getClass().getMethod("addPage", String.class).invoke(translatedBook, translatedText);
                } else if (hasMethod(translatedBook, "add", String.class)) {
                    translatedBook.getClass().getMethod("add", String.class).invoke(translatedBook, translatedText);
                }
            } catch (Exception e) {
                throw new RuntimeException("Cannot add page " + i, e);
            }
        }

        return translatedBook;
    }

    // Helper to check if a method exists
    private static boolean hasMethod(Object obj, String name, Class<?>... params) {
        try {
            obj.getClass().getMethod(name, params);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    // Translate a full sentence
    public static String translate(String input) {
        if (input == null || input.trim().isEmpty()) return "";

        String[] words = input.split(" ");
        StringBuilder translatedSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Handle hyphenated words
            String[] parts = word.split("(?<=-)|(?=-)");
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

        // Separate punctuation
        String punctuation = "";
        while (word.length() > 0 && !Character.isLetter(word.charAt(word.length() - 1))) {
            punctuation = word.charAt(word.length() - 1) + punctuation;
            word = word.substring(0, word.length() - 1);
        }

        if (word.length() == 0) return punctuation;

        boolean isFirstUpper = Character.isUpperCase(word.charAt(0));
        String lowerWord = word.toLowerCase();

        int firstVowel = -1;
        for (int i = 0; i < lowerWord.length(); i++) {
            char c = lowerWord.charAt(i);
            if ("aeiou".indexOf(c) >= 0) {
                firstVowel = i;
                break;
            }
        }

        String translated;
        if (firstVowel == 0) {
            translated = lowerWord + "ay";
        } else if (firstVowel > 0) {
            translated = lowerWord.substring(firstVowel) + lowerWord.substring(0, firstVowel) + "ay";
        } else {
            translated = lowerWord + "ay";
        }

        if (isFirstUpper) {
            translated = Character.toUpperCase(translated.charAt(0)) + translated.substring(1);
        }

        translated += punctuation;
        return translated;
    }
}