package home_work.entity;

import home_work.service.ComplexNumberService;

public class ComplexNumbersCalculator implements ComplexNumbersOperations{

    ComplexNumberService service = new ComplexNumberService(new ComplexNumber());


    
    @Override
    public ComplexNumber addict(ComplexNumber cNumber1, ComplexNumber cNumber2) {

        service.getComplexNumber().setReal(cNumber1.getReal() + cNumber2.getReal());
        service.getComplexNumber().setImaginary(cNumber1.getImaginary() + cNumber2.getImaginary());
        return service.getComplexNumber();

    }

    @Override
    public ComplexNumber substract(ComplexNumber cNumber1, ComplexNumber cNumber2) {

        service.getComplexNumber().setReal(cNumber1.getReal() - cNumber2.getReal());
        service.getComplexNumber().setImaginary(cNumber1.getImaginary() - cNumber2.getImaginary());
        return service.getComplexNumber();

    }

    @Override
    public ComplexNumber divide(ComplexNumber cNumber1, ComplexNumber cNumber2) {

        if(cNumber1.getImaginary() != 0 && cNumber2.getImaginary() != 0){

            // Комплексно-сопряженное число
            ComplexNumber complexConjugateNumber = new ComplexNumber();
            complexConjugateNumber.setReal(cNumber2.getReal());
            complexConjugateNumber.setImaginary(-cNumber2.getImaginary());

            service.getComplexNumber().setReal(((cNumber1.getReal() * complexConjugateNumber.getReal()) 
                                + ((cNumber1.getImaginary() * complexConjugateNumber.getImaginary()) * -1D)) /*Числитель*/
                                / ((cNumber2.getReal() * complexConjugateNumber.getReal()) 
                                + ((cNumber2.getImaginary() * complexConjugateNumber.getImaginary())) * -1D) /*Знаминатель*/);

            service.getComplexNumber().setImaginary(((cNumber1.getImaginary() * complexConjugateNumber.getReal()) 
                                + (cNumber1.getImaginary() * complexConjugateNumber.getImaginary()) /*Числитель*/
                                / ((cNumber2.getReal() * complexConjugateNumber.getReal()) 
                                + ((cNumber2.getImaginary() * complexConjugateNumber.getImaginary())) * -1D) /*Знаминатель*/));

            return service.getComplexNumber();

        }else if(cNumber1.getImaginary() == 0){

            // Комплексно-сопряженное число
            ComplexNumber complexConjugateNumber = new ComplexNumber();
            complexConjugateNumber.setReal(cNumber2.getReal());
            complexConjugateNumber.setImaginary(-cNumber2.getImaginary());

            service.getComplexNumber().setReal((cNumber1.getReal() * complexConjugateNumber.getReal()) 
                                / (cNumber2.getReal() * complexConjugateNumber.getReal()) 
                                + ((cNumber2.getImaginary() * complexConjugateNumber.getImaginary()) * -1D));

            service.getComplexNumber().setImaginary((cNumber1.getReal() * complexConjugateNumber.getImaginary()) 
                                / (cNumber2.getReal() * complexConjugateNumber.getReal()) 
                                + ((cNumber2.getImaginary() * complexConjugateNumber.getImaginary()) * -1D));

            return service.getComplexNumber();

        }else{

            service.getComplexNumber().setReal(cNumber1.getReal() / cNumber2.getReal());
            service.getComplexNumber().setImaginary(cNumber1.getImaginary() / cNumber2.getReal());

            return service.getComplexNumber();
        }
    }

    @Override
    public ComplexNumber multiply(ComplexNumber cNumber1, ComplexNumber cNumber2) {

        if(cNumber1.getImaginary() != 0 && cNumber2.getImaginary() != 0){

            double real1 = cNumber1.getReal() * cNumber2.getReal();
            double imaginary1 = cNumber1.getReal() * cNumber2.getImaginary();
            double imaginary2 = cNumber1.getImaginary() * cNumber2.getReal();
            double real2 = (cNumber1.getImaginary() * cNumber2.getImaginary()) * -1D;
            service.getComplexNumber().setReal(real1 + real2);
            service.getComplexNumber().setImaginary(imaginary1 + imaginary2);
            return service.getComplexNumber();

        }else if (cNumber1.getImaginary() == 0){

            service.getComplexNumber().setReal(cNumber1.getReal() * cNumber2.getReal());
            service.getComplexNumber().setImaginary(cNumber1.getReal() * cNumber2.getImaginary());
            return service.getComplexNumber();

        }else{

            service.getComplexNumber().setReal(cNumber1.getReal() * cNumber2.getReal());
            service.getComplexNumber().setImaginary(cNumber1.getImaginary() * cNumber2.getReal());
            return service.getComplexNumber();
        }
        
    }
}
