package home_work.entity;

public class ComplexNumber{

    private double real;
    private double imaginary;


    /**
     * Конструкторы
     */
    public ComplexNumber() {
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    

    /*                                                     ГЕТТЕРЫ И СЕТТЕРЫ                                          */

    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }


    @Override
    public String toString() {
        return String.format("Complex number is: (%s, %si)", this.real, this.imaginary);
    }

}
