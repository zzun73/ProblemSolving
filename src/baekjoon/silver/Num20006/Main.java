package baekjoon.silver.Num20006;

import java.io.*;
import java.util.*;

public class Main {

    static class Game {
        int level, maxSize;
        List<User> peoples = new ArrayList<>();

        public Game(int level, int maxSize) {
            this.level = level;
            this.maxSize = maxSize;
        }

        boolean isIn(int targetLevel) {
            return (targetLevel <= level + 10 && targetLevel >= level - 10) && this.peoples.size() < maxSize;
        }

        boolean isReadyGame() {
            return this.peoples.size() == maxSize;
        }

        String getStatusMessage() {
            return this.isReadyGame() ? "Started!" : "Waiting!";
        }

        void sortPeoples() {
            Collections.sort(this.peoples);
        }

        static class User implements Comparable<User> {
            int level;
            String nickname;

            public User(int level, String nickname) {
                this.level = level;
                this.nickname = nickname;
            }

            @Override
            public int compareTo(User o) {
                return this.nickname.compareTo(o.nickname);
            }

            @Override
            public String toString() {
                return new StringBuilder()
                        .append(level).append(" ")
                        .append(nickname)
                        .toString();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Game> games = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            if (games.isEmpty()) {
                games.add(new Game(level, m));

                games.get(0).peoples.add(new Game.User(level, nickname));
            } else {
                boolean found = false;
                for (Game game : games) {
                    if (game.isIn(level)) {
                        game.peoples.add(new Game.User(level, nickname));
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    games.add(new Game(level, m));
                    games.get(games.size() - 1).peoples.add(new Game.User(level, nickname));
                }
            }
        }

        for (Game game : games) {
            game.sortPeoples();
            sb.append(game.getStatusMessage()).append("\n");
            for (Game.User people : game.peoples) {
                sb.append(people.toString()).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}