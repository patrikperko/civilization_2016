package model;

public class ElementDoesNotExistException extends Exception {
    private Object object;

    public ElementDoesNotExistException(String message) {
        this(message, null);
    }

    public ElementDoesNotExistException(String message, Object object) {
        super(message);
        this.object = object;
    }

    public Object getObject() {
        return this.object;
    }
}
