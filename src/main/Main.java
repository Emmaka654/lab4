package main;

import main.ChangeString;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputString = scanner.nextLine();
        System.out.print("Enter separators: ");
        String inputSeparators = scanner.nextLine();
        System.out.print("Enter p for searching: ");
        String p = scanner.nextLine();

        ChangeString cs = new ChangeString();
        String[] masOfStrings = cs.tokenise(inputString, inputSeparators);
        System.out.println(String.format("Tokenised string: %s", String.join(" ", masOfStrings)));
        int[] masOf8Numbers = cs.isNumbers(masOfStrings);
        System.out.println(String.format("Numbers in string: %s", Arrays.toString(masOf8Numbers)));
        String[] masOfLatin = cs.isLatin(masOfStrings);
        System.out.println(String.format("String only latin: %s", String.join(" ", masOfLatin)));
        if (inputString.indexOf(p) == -1) {
            System.out.println("There is not p in this string");
        } else {
            int index = inputString.indexOf(p);
            System.out.println(String.format("Index of p: %d", index));
        }
        StringBuffer inputStringSB = cs.insertNumWithMinus(String.join(" ", masOfStrings), masOf8Numbers);
        System.out.println(String.format("String with minus: %s", inputStringSB));
        int[] masOfNumbers = cs.tokeniseNumbers (masOfStrings);
        String numberToDelete = String.valueOf(masOfNumbers[masOfNumbers.length - 2]);
        int index = inputStringSB.indexOf(numberToDelete);
        inputStringSB.delete(index, index + numberToDelete.length());
        System.out.println(String.format("String without prelast number: %s", inputStringSB));
        System.out.println(String.format("Sorted mas: %s",  cs.sortWithL(masOfStrings)));
    }
}
