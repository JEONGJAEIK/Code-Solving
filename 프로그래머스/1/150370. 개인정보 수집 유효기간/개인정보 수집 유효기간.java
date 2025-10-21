import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);
        Map<String, String> termsMap = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        for (String privacy : privacies) {
            String[] a = privacy.split(" ");
            list.add(new String[]{a[1], a[0]});
        }

        for (String term : terms) {
            String[] a = term.split(" ");
            termsMap.put(a[0], a[1]);
        }
        List<Integer> destoryList = new ArrayList<>();


        for (String[] strings : list) {
            for (String s : termsMap.keySet()) {
                if (strings[0].equals(s)) {
                    LocalDate date = calculate(strings[1], termsMap.get(s));
                    if (!date.isAfter(todayDate)) {
                        destoryList.add(list.indexOf(strings) + 1);
                    }
                }
            }
        }

        int[] result = new int[destoryList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = destoryList.get(i);
        }

        return result;
    }

    public static LocalDate calculate(String privacyDay, String plus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(privacyDay, formatter);
        return date.plusMonths(Long.parseLong(plus));
    }
}