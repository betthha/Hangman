public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new WordsList();
        Game game = new Game(dictionary);
        game.start();
    }
}
