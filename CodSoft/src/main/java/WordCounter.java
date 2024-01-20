import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCounter {

    public static void main(String[] args) {
        // Prompt the user to enter text or provide a file
        System.out.println("Enter a text or provide a file path:");

        // Read input text or file and store it in a string
        String input = readUserInput();
        if (input.isEmpty()) {
            System.out.println("No input provided. Exiting...");
            return;
        }

        // Split the string into an array of words using space or punctuation as delimiters
        String[] words = splitIntoWords(input);

        // Initialize a counter variable to keep track of the number of words
        int wordCount = countWords(words);

        // Display the total count of words to the user
        System.out.println("Total words count: " + wordCount);

        // Additional Features:
        // 7. Ignoring common words or stop words
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "and", "is", "in", "to", "of"));
        int filteredWordCount = countWordsIgnoringStopWords(words, stopWords);
        System.out.println("Total words count (excluding stop words): " + filteredWordCount);

        // 8. Providing statistics like the number of unique words or the frequency of each word
        displayWordStatistics(words);
    }

    private static String readUserInput() {
        // Implement input validation to handle empty inputs or file errors
        // You can further enhance this based on your specific requirements
        try (BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in))) {
            StringBuilder input = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                input.append(line).append("\n");
            }
            return input.toString().trim();
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
            return "";
        }
    }

    private static String[] splitIntoWords(String input) {
        // Split the string into an array of words using space or punctuation as delimiters
        return input.split("[\\s.,;?!()-]+");
    }

    private static int countWords(String[] words) {
        // Initialize a counter variable to keep track of the number of words
        return words.length;
    }

    private static int countWordsIgnoringStopWords(String[] words, Set<String> stopWords) {
        // Ignore common words or stop words
        int count = 0;
        for (String word : words) {
            if (!stopWords.contains(word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    private static void displayWordStatistics(String[] words) {
        // Providing statistics like the number of unique words or the frequency of each word
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Number of unique words: " + uniqueWords.size());

        System.out.println("Word frequency:");
        Arrays.stream(words)
                .collect(java.util.stream.Collectors.groupingBy(String::toLowerCase, java.util.stream.Collectors.counting()))
                .forEach((word, frequency) -> System.out.println(word + ": " + frequency));
    }
}
