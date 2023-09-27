import java.util.*;

public class Main {
    static HashMap<String, Integer> phoneBook = new HashMap<>();
    public static void main(String[] args) {
        Map<String, HashSet<String>> map = new HashMap<>();

        updateBook(map, "Сергей Сапегин", "9539108172" );
        updateBook(map, "Константин Комигачев", "9539102182" );
        updateBook(map, "Андрей Сидун", "9539102882" );
        updateBook(map, "Сапегин Никита", "9539148882" );
        updateBook(map, "Корякин Павел", "9539105882" );
        updateBook(map, "Венчук Николай", "9539108682" );
        updateBook(map, "Уварова Анна", "9539108882" );

        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            HashSet<String> value = entry.getValue();
            System.out.println(key + value);
//            System.out.println();
        }
        phoneBook.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
    private static void updateBook(Map<String, HashSet<String>> map, String key, String value) {
        if (map.containsKey(key)) {
            HashSet<String> oldVal = map.get(key);
            oldVal.add(value);
        }
        else {
            HashSet<String> newList = new HashSet<>();
            newList.add(value);
            map.put(key, newList);
        }
    }
}

