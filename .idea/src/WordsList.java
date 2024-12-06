import java.util.Random;

public class WordsList implements Dictionary {
    private final String[] words = {"compilation", "source", "strategy", "lizard", "photographer", "routine", "generation"};

    @Override
    public String randomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}
