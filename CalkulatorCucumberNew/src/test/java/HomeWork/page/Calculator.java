package HomeWork.page;

public class Calculator {

    // Метод для сложения двух чисел
    public double add(double num1, double num2) {

        return num1 + num2;
    }

    // Метод для вычитания двух чисел
    public double subtract(double num1, double num2) {

        return num1 - num2;
    }

    // Метод для умножения двух чисел
    public double multiply(double num1, double num2) {

        return num1 * num2;
    }

    // Метод для деления одного числа на другое
    // Возвращает Double.NaN, если num2 равен 0
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            return 0.00;
        }
        return num1 / num2;
    }

}
