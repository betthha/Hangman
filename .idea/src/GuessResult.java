public interface GuessResult {
        char[] userAnswers();
        int attempt();
        int maxNumberAttempts();
        String answer();
}

record Win(char[] userAnswers, int attempt, int maxNumberAttempts, String answer) implements GuessResult {}
record SuccessfulGuess(char[] userAnswers, int attempt, int maxNumberAttempts, String answer) implements GuessResult {}
record FailedGuess(char[] userAnswers, int attempt, int maxNumberAttempts, String answer) implements GuessResult {}
record Defeat(char[] userAnswers, int attempt, int maxNumberAttempts, String answer) implements GuessResult {}

