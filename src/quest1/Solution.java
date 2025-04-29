package quest1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UnionFind {
    public int[] parent;
    private int size;

    public UnionFind(int size) {
        this.size = size;
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]); // Path compression
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootJ] = rootI;
        }
    }
}

class Solution {
    private int rows = 50;
    private int cols = 50;
    private UnionFind uf;
    private Map<Integer, String> valueMap;
    private Map<List<Integer>, Integer> cellIdMap;
    private int nextId = 0;

    public Solution() {
        int totalCells = rows * cols;
        uf = new UnionFind(totalCells);
        valueMap = new HashMap<>();
        cellIdMap = new HashMap<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cellIdMap.put(List.of(r, c), nextId++);
            }
        }
    }

    private int getId(int r, int c) {
        return cellIdMap.get(List.of(r, c));
    }

    public void update(int r, int c, String value) {
        int id = getId(r, c);
        int rootId = uf.find(id);
        valueMap.put(rootId, value);
    }

    public void update(String value1, String value2) {
        Map<Integer, String> newValueMap = new HashMap<>();
        for (Map.Entry<Integer, String> entry : valueMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().equals(value1)) {
                newValueMap.put(entry.getKey(), value2);
            } else {
                newValueMap.put(entry.getKey(), entry.getValue());
            }
        }
        valueMap = newValueMap;
    }

    public void merge(int r1, int c1, int r2, int c2) {
        int id1 = getId(r1, c1);
        int id2 = getId(r2, c2);
        if (id1 == id2) {
            return;
        }
        int root1 = uf.find(id1);
        int root2 = uf.find(id2);
        if (root1 == root2) {
            return;
        }

        String value1 = valueMap.get(root1);
        String value2 = valueMap.get(root2);
        String mergedValue = (value1 != null) ? value1 : value2;

        uf.union(root1, root2);
        valueMap.put(uf.find(root1), mergedValue);
        valueMap.remove(root2);
    }

    public void unmerge(int r, int c) {
        int id = getId(r, c);
        int rootId = uf.find(id);
        String originalValue = valueMap.get(rootId);
        valueMap.remove(rootId);

        List<Integer> toUnmerge = new ArrayList<>();
        for (int i = 0; i < rows * cols; i++) {
            if (uf.find(i) == rootId) {
                toUnmerge.add(i);
            }
        }

        for (int unmergeId : toUnmerge) {
            uf.parent[unmergeId] = unmergeId;
            if (unmergeId == id) {
                valueMap.put(unmergeId, originalValue);
            }
        }
    }

    public String print(int r, int c) {
        int id = getId(r, c);
        int rootId = uf.find(id);
        String value = valueMap.get(rootId);
        return (value == null) ? "EMPTY" : value;
    }

    public String[] solution(String[] commands) {
        Solution editor = new Solution();
        List<String> results = new ArrayList<>();

        for (String query : commands) {
            String[] parts = query.split(" ");
            String command = parts[0];

            switch (command) {
                case "UPDATE":
                    if (parts.length == 4) {
                        int r = Integer.parseInt(parts[1]) - 1;
                        int c = Integer.parseInt(parts[2]) - 1;
                        String value = parts[3];
                        editor.update(r, c, value);
                    } else if (parts.length == 3) {
                        String value1 = parts[1];
                        String value2 = parts[2];
                        editor.update(value1, value2);
                    }
                    break;
                case "MERGE":
                    int r1 = Integer.parseInt(parts[1]) - 1;
                    int c1 = Integer.parseInt(parts[2]) - 1;
                    int r2 = Integer.parseInt(parts[3]) - 1;
                    int c2 = Integer.parseInt(parts[4]) - 1;
                    editor.merge(r1, c1, r2, c2);
                    break;
                case "UNMERGE":
                    int r = Integer.parseInt(parts[1]) - 1;
                    int c = Integer.parseInt(parts[2]) - 1;
                    editor.unmerge(r, c);
                    break;
                case "PRINT":
                    int pr = Integer.parseInt(parts[1]) - 1;
                    int pc = Integer.parseInt(parts[2]) - 1;
                    results.add(editor.print(pr, pc));
                    break;
            }
        }

        return results.toArray(new String[0]);
    }
}