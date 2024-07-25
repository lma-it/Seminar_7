package home_work.service;

import java.util.Scanner;

import home_work.entity.ComplexNumber;

public class ComplexNumberService{

    // ЗАДАЧА: Разобраться в сервисах и контроллерах.
    private ComplexNumber complexNumber;

    public ComplexNumberService(ComplexNumber complexNumber) {
        this.complexNumber = complexNumber;
    }


    public ComplexNumber getComplexNumber() {
        return complexNumber;
    }

    public ComplexNumber createComplexNumber(){

        Scanner scan = new Scanner(System.in);
        ComplexNumber complexNumber = new ComplexNumber();
        double real = Double.valueOf(scan.nextLine("Введите вещественную часть комплексного числа: "));
        complexNumber.setReal(real);
        double imaginary = Double.valueOf(scan.nextLine("Введите мнимую часть комплексного числа"));
        complexNumber.setImaginary(imaginary);
        sca.close();
        return complexNumber;
    }

}
