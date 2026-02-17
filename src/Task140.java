import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task140 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> allLines = new ArrayList<>();
        List<List<String>> goodLines = new ArrayList<>();

        // создаём листы, в которых первое слово
        for (String word : wordDict) {
            if (goodLines.contains(word) || allLines.contains(word)) {
                continue;
            }
            if (s.startsWith(word)) {
                List<String> list = new ArrayList<>();
                list.add(word);
                if (s.equals(word)) {
                    goodLines.add(list);
                } else {
                    allLines.add(list);
                }
            }
        }
        System.out.println("старт:");
        allLines.forEach(System.out::println);
        System.out.println("-------");
        List<List<String>> toAdd = new ArrayList<>();
        while (!allLines.isEmpty()) {
            for (List<String> list : allLines) {
                for (String str : wordDict) {
                    if (s.startsWith(String.join("", list) + str)) {
                        List<String> newList = new ArrayList<>(list);
                        newList.add(str);
                        if (s.equals(String.join("", newList))) {
                            goodLines.add(newList);
                        } else {
                            toAdd.add(newList);
                        }
                    }
                }
            }
            allLines.clear();
            allLines.addAll(toAdd);
            toAdd.clear();
            System.out.println("Lines:");
            allLines.forEach(System.out::println);
            System.out.println("----------\n");
            scanner.nextLine();
        }
        System.out.println("good lines:");
        goodLines.forEach(System.out::println);

        List<String> result = new ArrayList<>(goodLines.size());
        for (List<String> list : goodLines) {
            result.add(String.join(" ", list));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("ab", List.of("a")));
    }
}
