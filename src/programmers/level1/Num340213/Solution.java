package programmers.level1.Num340213;

class Solution {

    private int toSeconds(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private String toTimeFormat(int seconds) {
        return String.format("%02d:%02d", seconds / 60, seconds % 60);
    }

    private boolean isInOperationRange(int current, int start, int end) {
        return start <= current && current <= end;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int current = toSeconds(pos);
        int start = toSeconds(op_start);
        int end = toSeconds(op_end);
        int video = toSeconds(video_len);

        for (String cmd : commands) {
            if (isInOperationRange(current, start, end)) {
                current = end;
            }

            if (cmd.equals("prev")) {
                current = Math.max(0, current - 10);
            } else if (cmd.equals("next")) {
                current = Math.min(video, current + 10);
            }
        }

        if (isInOperationRange(current, start, end)) {
            current = end;
        }

        return toTimeFormat(current);
    }
}