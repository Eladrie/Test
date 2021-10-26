
public class Body {

    public static void calc(String[] stringInput) {
        if (stringInput.length != 3) {
            throw new InvalidInputException("Некорректный ввод");
        }
        int firstNumber = 0;
        int secondNumber = 0;
        int result = 0;
        boolean flag = false;

        try {
            firstNumber = Integer.parseInt(stringInput[0]);
            secondNumber = Integer.parseInt(stringInput[2]);
            if (firstNumber > 10 || firstNumber < 0 || secondNumber > 10 || secondNumber < 0) {
                throw new InvalidInputException("По заданию вводные цифры больше 0 и меньше или равно 10");
            }
        } catch (NumberFormatException e) {
            firstNumber = RomeConverter.romeCalc(stringInput[0]);
            secondNumber = RomeConverter.romeCalc(stringInput[2]);
            flag = true;
            if (firstNumber > 10 || secondNumber > 10) {
                throw new InvalidInputException("По заданию вводные цифры меньше 10");
            }
        }

        switch (stringInput[1]) {
            case "+":
                result =firstNumber + secondNumber;
                break;
            case "-": {
                result = firstNumber - secondNumber;
                if (flag && (result < 1)) {
                    throw new InvalidInputException("Результат калькулятора с римскими цифрами должен быть больше или равен I");
                }
                break;
            }
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/": {
                result = firstNumber / secondNumber;
                if (flag && (result < 1)) {
                    throw new InvalidInputException("Результат калькулятора с римскими цифрами должен быть больше или равен I");
                }
                break;
            }
            default:
                throw new InvalidInputException("Неправильно введен операнд");
        }



        if (flag) {
            System.out.println(RomeConverter.romeResult(result));
        } else {
            System.out.println(result);
        }

    }
}