package home_work.exceptions;

public class ComplexNumberExceptions extends Exception{
    public ComplexNumberExceptions(String msg) {
        throw new RuntimeException(msg);
    }
}
