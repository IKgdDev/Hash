import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {

        Map<Character, Integer> lettersMap = new HashMap<>();
        char[] characters = text.toCharArray();

        for (char c : characters) {
            if (Character.isLetter(c)) {
                if (lettersMap.containsKey(c)) {
                    int count = lettersMap.get(c) + 1;
                    lettersMap.put(c, count);
                } else {
                    lettersMap.put(c, 1);
                }
            }
        }

        System.out.println(lettersMap);

        Map.Entry<Character, Integer> maxEntry = max(lettersMap);
        System.out.println("Чаще всего повторялась буква \"" + maxEntry.getKey() + "\". Число повторений: " + maxEntry.getValue());

        Map.Entry<Character, Integer> minEntry = min(lettersMap);
        System.out.println("Реже всего повторялась буква \"" + minEntry.getKey() + "\". Число повторений: " + minEntry.getValue());
    }


    public static Map.Entry<Character, Integer> max(Map<Character, Integer> map) {

        Map.Entry<Character, Integer> maxEntry = null;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }

        return maxEntry;
    }


    public static Map.Entry<Character, Integer> min(Map<Character, Integer> map) {

        Map.Entry<Character, Integer> minEntry = null;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0)
            {
                minEntry = entry;
            }
        }

        return minEntry;
    }
}
