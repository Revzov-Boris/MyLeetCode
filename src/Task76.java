import java.util.*;

public class Task76 {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        List<Character> charsOfT = new ArrayList<>();
        for (char c : t.toCharArray()) charsOfT.add(c);
        int minLen = s.length() + 1;
        int start = -1;
        int end = -1;

        // индексы, на которых находятся символы, содержащиеся в t
        List<Integer> goodIndexes = new ArrayList<>(s.length());
        char[] charArrayOfS = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (charsOfT.contains(charArrayOfS[i])) {
                goodIndexes.add(i);
            }
        }
        if (goodIndexes.size() < t.length()) {
            return "";
        }

        int startForJ;
        int lastJ = -1;
        List<Character> needToFind = new ArrayList<>(charsOfT);
        // Сколько каких символов нашли
        Map<Character, Integer> haveChars = new HashMap<>();
        for (Character c : charsOfT) {
            haveChars.put(c, 0);
        }
        Map<Character, Integer> mustHave = new HashMap<>();
        //Set<Character> charactersToFind = new HashSet<>(needToFind);
        for (Character c : new HashSet<>(needToFind)) {
            mustHave.put(c, (int) needToFind.stream().filter(it -> it.equals(c)).count());
        }
        boolean lost = false;
        System.out.println("Нужно: " + mustHave);
        int countToFind = needToFind.size();
        System.out.println("Количестов: " + countToFind);
        for (int i = 0; i < goodIndexes.size(); i++) {
            System.out.println("--- начало = " + goodIndexes.get(i));

            if (s.length() - goodIndexes.get(i) < t.length()) {
                break;
            }
            lost = false;
            startForJ = i;


            if (i != 0) {
                startForJ = lastJ;
                // символ, который теряется из-за сдвига старта
                Character abandoned = charArrayOfS[goodIndexes.get(i - 1)];
                //String str = s.substring(goodIndexes.get(i - 1), goodIndexes.get(lastJ));
                if (haveChars.get(abandoned) <= mustHave.get(abandoned)) {
                    lost = true;
                    startForJ++;
                    System.out.println("При сдвиге старта теряем незаменимый " + abandoned);
                    countToFind++;
                }
                haveChars.put(abandoned, haveChars.get(abandoned) - 1);
            }

            System.out.println("Нужно найти: " + countToFind);
            System.out.println("Имеем: " + haveChars);

            for (int j = startForJ; j < goodIndexes.size(); j++) {
                System.out.println("- конец = " + goodIndexes.get(j));
                Character c = charArrayOfS[goodIndexes.get(j)];
                System.out.println("Нашли: " + c);

                if (j == startForJ) {
                    System.out.println("lost = " + lost);
                    if (lost || j == 0) {
                        System.out.println("Удаляем из списка символ под индексом " + goodIndexes.get(j));
                        System.out.println("Имеем: " + haveChars);
                        if (mustHave.get(c) > haveChars.get(c) && countToFind > 0) {
                            System.out.println("Удалили");
                            countToFind--;
                        }
                        haveChars.put(c, haveChars.get(c) + 1);
                        System.out.println(haveChars);
                    }
                } else {
                    System.out.println("Удаляем из списка символ под индексом" + goodIndexes.get(j));
                    if (mustHave.get(c) > haveChars.get(c) && countToFind > 0) {
                        System.out.println("Удалили");
                        countToFind--;
                    }
                    haveChars.put(c, haveChars.get(c) + 1);
                    System.out.println(haveChars);
                }


                if (countToFind == 0) {
                    System.out.println("Нашли все");
                    lastJ = j;
                    if (goodIndexes.get(j) - goodIndexes.get(i) + 1 < minLen) {
                        minLen = goodIndexes.get(j) - goodIndexes.get(i) + 1;
                        start = goodIndexes.get(i);
                        end = goodIndexes.get(j) + 1;
                        if (minLen == charsOfT.size()) {
                            return s.substring(start, end);
                        }
                    }
                    break;
                }
            }
            // если взяв все символы из s не смогли найти все символы из t
            if (i == 0 && countToFind != 0) {
                System.out.println("Во всей S нет необходимых символов");
                return "";
            }
            // если нашли подходящую подстроку, но при сдвиге старта уже такой не находится, то возвращаем ту подходящую
            if (countToFind != 0 && start != -1) {
                return s.substring(start, end);
            }
        }

        if (minLen != s.length() + 1) {
            return s.substring(start, end);
        }
        return "";
    }


    public static void main(String[] args) {
                                                    //[0, 3, 5, 9, 10, 12]

        System.out.println("result: " + minWindow("ADOBECODEBANC",
                                                  "ABC"));
    }
}
