package numToWords;

public class NumToWords {
    private static final String[] units = {
            "", "один", "два", "три", "четыре", "пять",
            "шесть", "семь", "восемь", "девять", "десять",
            "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    };

    private static final String[] tens = {
            "", "", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"
    };

    private static final String[] hundreds = {
            "", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"
    };

    private static final String[] thousands = {"", "тысяча", "тысячи", "тысяч"};
    private static final String[] millions = {"", "миллион", "миллиона", "миллионов"};
    private static final String[] billions = {"", "миллиард", "миллиарда", "миллиардов"};
    private static final String[] trillions = {"", "триллион", "триллиона", "триллионов"};

    public static String convertToText(long number) {
        if (number == 0) {
            return "ноль";
        }

        String text = "";
        int level = 0;

        while (number > 0) {
            int triplet = (int) (number % 1000);
            String tripletText = convertTripletToText(triplet);

            if (!tripletText.isEmpty()) {
                if (level == 1) {
                    tripletText += " " + getUnitForm(triplet, thousands);
                } else if (level == 2) {
                    tripletText += " " + getUnitForm(triplet, millions);
                } else if (level == 3) {
                    tripletText += " " + getUnitForm(triplet, billions);
                } else if (level == 4) {
                    tripletText += " " + getUnitForm(triplet, trillions);
                }
            }

            text = tripletText + " " + text;
            number /= 1000;
            level++;
        }

        return text.trim();
    }

    private static String convertTripletToText(int number) {
        String text = "";

        int hundredsDigit = number / 100;
        int tensDigit = (number % 100) / 10;
        int unitsDigit = number % 10;

        if (hundredsDigit > 0) {
            text += hundreds[hundredsDigit] + " ";
        }

        if (tensDigit == 1) {
            text += units[number % 100] + " ";
        } else if (tensDigit > 1) {
            text += tens[tensDigit] + " ";
        }

        if (tensDigit != 1 && unitsDigit > 0) {
            text += units[unitsDigit] + " ";
        }

        return text.trim();
    }

    private static String getUnitForm(int number, String[] unitForms) {
        int lastTwoDigits = number % 100;
        int lastDigit = lastTwoDigits % 10;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return unitForms[3];
        } else if (lastDigit == 1) {
            return unitForms[1];
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return unitForms[2];
        } else {
            return unitForms[3];
        }
    }

    public static void main(String[] args) {
        long number = 123456789012111L;
        String text = convertToText(number);
        System.out.println(number + " = " + text);
    }
}




