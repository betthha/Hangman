import java.util.Scanner;

class Game {
    private final Dictionary dictionary;
    private final Scanner scanner;

    public Game(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome! Try to stay alive or you will die))");
        String word = dictionary.randomWord();
        Session session = new Session(word, 7);

        while (true) {
            System.out.println("\nYour current answer, nerd: " + new String(session.getUserAns()));
            System.out.println("Attempts: " + session.getAttempts() + " out of " + session.getMaxNumAttempts());
            System.out.print("Keep on suffering or print 'exit' if you are a weak: ");
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) {
                GuessResult res = session.giveUp();
                printAnswer(res);
                break;
            }

            if (input.length() == 1 && input.matches("[a-zA-Z]")) {
                char guess = input.charAt(0);
                GuessResult res = session.guess(guess);
                printAnswer(res);

                if (res instanceof Win) {
                    break;
                }

                if (res instanceof Defeat) {
                    break;
                }
            } else {
                System.out.println("You are stupid?! Write only one letter!!!");
            }
        }
    }

    private void printAnswer(GuessResult res) {
        System.out.println(res.answer());
    }
}
