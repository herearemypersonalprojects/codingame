/**
 * Created by qale0001 on 16/02/2017.
 */
import java.util.*;
public class Hashing {
    public static ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            List<Integer> lst;
            if (map.get(a.get(i)) == null) {
                lst = new LinkedList<>();
            } else {
                lst = map.get(a.get(i));
            }
            lst.add(lst.size(), i);
            map.put(a.get(i), lst);
        }

        int max = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            int remain = b - a.get(i);

            if (map.get(remain) != null) {
                for (int k = 0; k < map.get(remain).size(); k++) {
                    int j = map.get(remain).get(k);
                    if (i < j && j < max ) {
                        max = j;
                        result.clear();
                        result.add(0, i + 1);
                        result.add(1, j + 1);
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        //List<Integer> list = Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 );
        List<Integer> list = Arrays.asList(1, 1, 1 );
        ArrayList<Integer> result = twoSum(list, 2);
        System.out.println(result.get(0));
        System.out.println(result.get(1));

    }
}
