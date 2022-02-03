package algorithms;

import java.util.*;

public class Sentences {

    private List<String> sentences = new ArrayList<>();

    public void addSentence(String sentence) {
        sentenceValidatorStart(sentence);
        sentenceValidatorEnd(sentence);
        sentences.add(sentence);
    }

    public List<String> getSentences() {
        return sentences;
    }

    public String findLongestSentence() {
        if (sentences.size() == 0) {
            throw new IllegalStateException("No sentences to search in.");
        }
        return sentences.stream()
                .max(Comparator.comparing(String::length))
                .get();
    }

    private void sentenceValidatorStart(String sentence) {
        String firstDigit = String.valueOf(sentence.charAt(0)).toLowerCase(Locale.ROOT);
        if (firstDigit.equals(String.valueOf(sentence.charAt(0)))) {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
    }

    private void sentenceValidatorEnd(String sentence) {
        String lastDigit = String.valueOf(sentence.charAt(sentence.length()-1));
        List<String> ending = Arrays.asList(".", "?", "!");
        if (!ending.contains(lastDigit) ) {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
    }
}
