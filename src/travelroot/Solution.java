package travelroot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    static List<String> result;
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        result = new ArrayList<>();
        visited = new boolean[tickets.length];

        Arrays.sort(tickets, Comparator.comparing((String[] arr) -> arr[0] + arr[1]));

        dfs(tickets, "ICN", 0, new ArrayList<>(List.of("ICN")));

        return result.toArray(new String[0]);
    }

    private boolean dfs(String[][] tickets, String currentAirport, int count, List<String> path) {
        if (count == tickets.length) {
            result = path;
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(currentAirport)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                if (dfs(tickets, tickets[i][1], count + 1, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
        return false;
    }
}