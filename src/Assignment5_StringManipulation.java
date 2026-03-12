import java.util.*;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> task1(scanner);
                case 2 -> task2(scanner);
                case 3 -> task3(scanner);
                case 4 -> task4(scanner);
                case 5 -> task5(scanner);
                case 6 -> task6(scanner);
                case 7 -> task7(scanner);
                case 8 -> task8(scanner);
                case 0 -> {
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Подсчитать количество гласных (a, e, i, o, u)
        int count = 0;
        String lowers = input.toLowerCase();
        for (int i = 0; i< input.length(); i++){
            char character = lowers.charAt(i);
            if(character =='a' || character=='o' || character =='e' || character=='i' || character =='u' ){
                count +=1;
            }
        }

        System.out.println("Number of vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Вывести строку в обратном порядке
        String reversed = "";
        for (int i = input.length()-1;i>=0;i--){
            reversed += input.charAt(i);

        }




        System.out.println(reversed);
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Проверить, является ли строка палиндромом (игнорировать регистр)
        boolean isPalindrome = false;
        input = input.toLowerCase();
        String reverse = new StringBuilder(input).reverse().toString();
        if(input.equals(reverse)){
            isPalindrome=true;
        }

        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine().trim();

        // TODO: Подсчитать количество слов в предложении
        int wordCount = 0;
        if(sentence.isEmpty()){
            System.out.println("Number of words: 0");
            return;
        }
        ArrayList<String> words = new ArrayList<>(Arrays.asList(sentence.split("\\s+")));
        wordCount = words.size();
        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Удалить все пробелы из строки
        String noSpaces = "";
        noSpaces=input.replaceAll("\\s+","");


        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        if(sentence.isEmpty()){
            System.out.println("");
            return;
        }

        // TODO: Преобразовать первую букву каждого слова в заглавную
        String result = "";
        ArrayList<String> s = new ArrayList<>(Arrays.asList(sentence.split("\\s+")));
        for(String sd:s){
            result +=  sd.substring(0, 1).toUpperCase() + sd.substring(1) + " ";
        }



        System.out.println(result.trim());
    }

    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Найти символ, который встречается чаще всего
        char mostFrequent = ' ';
        HashMap<Character,Integer> e = new HashMap<>();
        for(int i = 0;i<input.length();i++){
            if(e.containsKey(input.charAt(i))){
                e.put(input.charAt(i), e.get(input.charAt(i)) +1);
            } else {
                e.put(input.charAt(i),1);
            }
        }
        int maxCount = -1;
        for(Map.Entry<Character, Integer> entry : e.entrySet()){
           if(entry.getValue() > maxCount){
               maxCount =entry.getValue();
               mostFrequent = entry.getKey();
           }
        }


        System.out.println("The most frequent character is: " + mostFrequent);
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine().toLowerCase().replaceAll("\\s","");
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine().toLowerCase().replaceAll("\\s+","");

        // TODO: Проверить, являются ли две строки анаграммами (игнорировать пробелы и регистр)
        boolean areAnagrams = true;
        char[] charArray = str1.toCharArray();
        char[] charArray2 =str2.toCharArray();

        Arrays.sort(charArray);
        Arrays.sort(charArray2);

        str1 = new String(charArray);
        str2 = new String(charArray2);
        if(str1.equals(str2)){
            areAnagrams=true;
        } else {
            areAnagrams=false;
        }





        System.out.println(areAnagrams ? "Yes" : "No");
    }
}