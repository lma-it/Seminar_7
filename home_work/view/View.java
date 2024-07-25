package home_work.view;

import home_work.controller.ComplexNumberCalculatorController;
import home_work.entity.ComplexNumber;
import home_work.exceptions.InvalidOperandException;
import home_work.exceptions.InputIsNotValueOfDoubleTypeException;
import home_work.util.Operands;

import java.util.Scanner;

public class View {

    private ComplexNumberCalculatorController controller;
    private boolean isContinue;

    public View() {
        this.controller = new ComplexNumberCalculatorController();
    }

    public void start(){

        isContinue = true;

        while (isContinue) {

            ComplexNumber number1 = new ComplexNumber();
            double real = Double.valueOf(consoleInput("Введите вещественную часть комплексного числа: "));
            number1.setReal(real);
            double imaginary = Double.valueOf(consoleInput("Введите мнимую часть комплексного числа"));
            number1.setImaginary(imaginary);

            ComplexNumber number2 = new ComplexNumber();
            real = Double.valueOf(consoleInput("Введите вещественную часть комплексного числа: "));
            number2.setReal(real);
            imaginary = Double.valueOf(consoleInput("Введите мнимую часть комплексного числа"));
            number2.setImaginary(imaginary);
            String operand = consoleInput("Введите операнд (+, -, *, /), чтоб выполнить дальнейшие действия с этими числами:");

            switch (operand) {

                case Operands.ADDITION.getOperand():
                
                    this.controller.getCalculator().addict(number1, number2);
                    System.out.println("Хотите продолжить? y/n");
                    String stop = consoleInput("Хотите продолжить? y/n");
                    if(stop == "y"){
                        break;
                    }else{
                        operand = "n";
                        break;
                    }
                case Operands.SUBTRACTION.getOperand():
                    this.controller.getCalculator().substract(number1, number2);
                    break;
                case Operands.DIVISION.getOperand():
                    this.controller.getCalculator().divide(number1, number2);
                    break;
                case Operands.MULTIPLY.getOperand():
                    this.controller.getCalculator().multiply(number1, number2);
                    break;
                case Operands.EXIT.getOperand():
                    isContinue = false;
                    break;
            }
        }
        
    }

    private String consoleInput(String msg)
                throws InvalidOperandException, InputIsNotValueOfDoubleTypeException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);
        return scan.nextLine();
    }

    
}
