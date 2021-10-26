public class RomeConverter {

    public static int[]    numbers = { 1000,  900,  500,  400,  100,   90,
            50,   40,   10,    9,    5,    4,    1 };

    public static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
            "L",  "XL",  "X",  "IX", "V",  "IV", "I" };

    public static int romeCalc(String romanNumber){

        int count = 0;
        int i = 0;

        romanNumber = romanNumber.toUpperCase();
        //далее пишу конвертер из римских в арабские
        //не забыть проверку и исключение для > X (больше десяти)
        //+ отдельный метод для результата операций над римскими цифрами и его вывода

        while (i < romanNumber.length()) {
            char letter = romanNumber.charAt(i);
            int number = letterToNumber(letter);
            if (i == romanNumber.length() - 1){
                count += number;
                i++;
            } else {
                i++;
                int next = letterToNumber(romanNumber.charAt(i));
                if ( next > number){
                    count+= (next - number);
                    i++;
                } else {
                    count+=number;
                }
            }
        }
        if (count > 3999)
            throw new InvalidInputException("Римские числа могут быть только меньше или равны 3999.");

        return count;
    }

    public static String romeResult(int number){
        StringBuilder romeResult = new StringBuilder();
        int N = number;
        for (int i = 0; i < numbers.length; i++) {
            while (N >= numbers[i]) {
                romeResult.append(letters[i]);
                N -= numbers[i];
            }
        }

        return romeResult.toString();
    }

    public static int letterToNumber(char letter) {
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:   throw new InvalidInputException(
                    "Некорректный ввод");
        }
    }
}