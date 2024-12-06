public class Session {
    private final String ans;
    private final char[] userAns;
    private final int maxNumAttempts;
    private int attempts;

    public Session(String answer, int maxNumAttempts) {
        this.ans = answer;
        this.userAns = new char[answer.length()];
        String userAns = "_".repeat(answer.length());
        this.maxNumAttempts = maxNumAttempts;
        this.attempts = 0;
    }

    public GuessResult guess(char guess) {
        int flag = 0;
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == guess) {
                userAns[i] = guess;
                flag = 1;
            }
        }

        if (new String(userAns).equals(ans)) {
            return new Win(userAns, attempts, maxNumAttempts, "You passed this game! You are sigma =)");
        }

        if (flag == 1) {
            return new SuccessfulGuess(userAns, attempts, maxNumAttempts, "Keep this up! ^^");
        }

        attempts++;
        if (attempts >= maxNumAttempts) {
            return new Defeat(userAns, attempts, maxNumAttempts, "GAME OVER!!! You are not sigma =( The answer is " + ans);
        }

        return new FailedGuess(userAns, attempts, maxNumAttempts, "Wrong! You are not an extrasensory. Attempts: " + attempts + " out of " + maxNumAttempts);
    }

    public GuessResult giveUp() {
        return new Defeat(userAns, attempts, maxNumAttempts, "WASTED!!! The answer is " + ans);
    }

    public char[] getUserAns() {
        return userAns;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxNumAttempts() {
        return maxNumAttempts;
    }
}
