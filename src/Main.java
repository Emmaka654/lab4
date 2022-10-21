import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputString = scanner.nextLine();
        System.out.print("Enter separators: ");
        String inputSeparators = scanner.nextLine();
        System.out.print("Enter p for searching: ");
        String p = scanner.nextLine();

        String[] masOfStrings = tokenise(inputString, inputSeparators);
        System.out.println(String.format("Tokenised string: %s", String.join(" ", masOfStrings)));
        int[] masOf8Numbers = isNumbers(masOfStrings);
        System.out.println(String.format("Numbers in string: %s", Arrays.toString(masOf8Numbers)));
        String[] masOfLatin = isLatin(masOfStrings);
        System.out.println(String.format("String only latin: %s", String.join(" ", masOfLatin)));
        if (inputString.indexOf(p) == -1) {
            System.out.println("There is not p in this string");
        } else {
            int index = inputString.indexOf(p);
            System.out.println(String.format("Index of p: %d", index));
        }
        StringBuffer inputStringSB = insertNumWithMinus(String.join(" ", masOfStrings), masOf8Numbers);
        System.out.println(String.format("String with minus: %s", inputStringSB));
        int[] masOfNumbers = tokeniseNumbers (masOfStrings);
        String numberToDelete = String.valueOf(masOfNumbers[masOfNumbers.length - 2]);
        int index = inputStringSB.indexOf(numberToDelete);
        inputStringSB.delete(index, index + numberToDelete.length());
        System.out.println(String.format("String without prelast number: %s", inputStringSB));
        System.out.println(String.format("Sorted mas: %s",  sortWithL(masOfStrings)));
    }

    private static String sortWithL(String[] masOfStrings) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String str : masOfStrings) {
            arrayList.add(str);
        }
        arrayList.sort((p1, p2) -> countAmountOfLatin(p1) - countAmountOfLatin(p2));
        return  arrayList.toString();
    }

    private static int countAmountOfLatin(String str){
        int size = 0;
        for (int i = 0; i < str.length(); i++) {
            String str1 = String.valueOf(str.charAt(i));
            if (str1.matches("[a-zA-Z]+")) {
                size++;
            }
        }
        return size;
    }

    private static StringBuffer insertNumWithMinus(String inputString, int[] masOfNumbers) {
        int numWithMinus = masOfNumbers[(int) (Math.random() * masOfNumbers.length)] * (-1);
        StringBuffer inputStringSB = new StringBuffer(inputString);
        return inputStringSB.insert(inputStringSB.length() / 2, numWithMinus);
    }

    private static String[] isLatin(String[] masOfStrings) {
        String[] masOfLatin = new String[50];
        int size = 0;
        for (int i = 0, j = 0; i < masOfStrings.length; i++) {
            if (masOfStrings[i].matches("[a-zA-Z]+")) {
                masOfLatin[j++] = masOfStrings[i];
                size++;
            }
        }
        return Arrays.copyOf(masOfLatin, size);
    }

    private static int[] isNumbers(String[] masOfStrings) {
        int[] masOfNumbers = new int[50];
        int size = 0;
        for (int i = 0, j = 0; i < masOfStrings.length; i++) {
            if (isNumeric(masOfStrings[i])) {
                masOfNumbers[j++] = Integer.parseInt(masOfStrings[i]);
                size++;
            }
        }
        return Arrays.copyOf(masOfNumbers, size);
    }

    private static String[] tokenise(String inputString, String inputSeparators) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, inputSeparators);
        String[] masOfStrings = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            masOfStrings[i++] = stringTokenizer.nextToken();
        }
        return masOfStrings;
    }

    private static int[] tokeniseNumbers(String[] masOfStrings) {
        int[] masOfNumbers = new int[50];
        int size = 0;
        for (int i = 0, j = 0; i < masOfStrings.length; i++) {
            if (isAnyNumeric(masOfStrings[i])) {
                masOfNumbers[j++] = Integer.parseInt(masOfStrings[i]);
                size++;
            }
        }
        return Arrays.copyOf(masOfNumbers, size);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str, 8);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isAnyNumeric(String str) {
        try {
            Integer.parseInt(str, 10);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
