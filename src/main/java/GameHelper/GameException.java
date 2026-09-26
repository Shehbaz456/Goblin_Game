package GameHelper;

public class GameException {
    public static class InvalidDamageException extends RuntimeException {
        public InvalidDamageException(String message) {
            super(message);
        }
    }

    public static class InsufficientPotionException extends RuntimeException {
        public InsufficientPotionException(String message) {
            super(message);
        }
    }

    public static class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(String message) {
            super(message);
        }
    }
}
