package GameHelper;

public class GameException {
    public static class InvalidGameActionException extends Exception {
        public InvalidGameActionException(String message) {
            super(message);
        }
    }

    public static class InsufficientHealthException extends Exception {
        public InsufficientHealthException(String message) {
            super(message);
        }
    }
}
