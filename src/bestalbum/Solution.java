package bestalbum;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<SongInfo>> songs = new HashMap<>();
        HashMap<String, Integer> totalOfSong = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            totalOfSong.put(genres[i], totalOfSong.getOrDefault(genres[i], 0) + plays[i]);
            songs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new SongInfo(i, plays[i]));
        }

        for (String genre : songs.keySet()) {
            songs.get(genre).sort(new Comparator<SongInfo>() {
                @Override
                public int compare(SongInfo o1, SongInfo o2) {
                    if (o1.play != o2.play) return o2.play - o1.play;
                    return o1.index - o2.index;
                }
            });
        }

        ArrayList<String> totals = new ArrayList<>(totalOfSong.keySet());
        totals.sort((a,b) -> totalOfSong.get(b) - totalOfSong.get(a));
        ArrayList<Integer> answer = new ArrayList<>();
        for (String genre : totals) {
            int count = 0;
            for (SongInfo value : songs.get(genre)) {
                if(count < 2) {
                    answer.add(value.index);
                    count++;
                }else{
                    break;
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();


    }
}

class SongInfo {
    int index;
    int play;

    public SongInfo(int index, int play) {
        this.index = index;
        this.play = play;
    }
}