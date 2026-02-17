import java.util.*;
import java.util.stream.Collectors;

public class Task139 {
    static Scanner scanner = new Scanner(System.in);

    public static boolean wordBreakSol(String s, List<String> wordDict, String sb, Set<String> cash) {
        List<String> mayBeNext = new ArrayList<>();
        for (String string : wordDict) {
            String nextNewString = sb + string;
            if (cash.contains(nextNewString)) {
                continue;
            }
            cash.add(nextNewString);
            if (nextNewString.length() <= s.length() && s.substring(0, nextNewString.length()).equals(nextNewString)) {
                if (s.length() == nextNewString.length()) {
                    return true;
                }
                mayBeNext.add(string);
            }
        }
       // System.out.println("mayBeNext " + mayBeNext);
        if (mayBeNext.isEmpty()) {
            return false;
        }

        for (String string : mayBeNext) {
            if (wordBreakSol(s, wordDict, sb + string, cash)) {
                return true;
            }
        }
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // убираем дубликаты
        wordDict = new HashSet<>(wordDict).stream().toList();
        // убираем слова, которые не содержатся в s
        List<String> isIn = new ArrayList<>();
        for (String word : wordDict) {
            if (s.contains(word)) {
                isIn.add(word);
            }
        }
//        if (isIn.size() == 1 && s.length() % isIn.getFirst().length() != 0) {
//            return false;
//        }

        
        return wordBreakSol(s, isIn, "", new HashSet<>());
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        String s = "bb";
        List<String> list = List.of("a","bbb","bbbb");
        System.out.println("ИТОГ: " + wordBreak(s, list));
        System.out.println(1.0 * (System.nanoTime() - start) / 1_000_000_000);
    }
}
