import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();
        List<Integer> maxList = new ArrayList<>();
        List<Integer> minList = new ArrayList<>();
        boolean firstMax = first.length > second.length;

        if (firstMax) {
            for (char c : first) {
                maxList.add(Integer.parseInt(String.valueOf(c)));
            }
            for (char c : second) {
                minList.add(Integer.parseInt(String.valueOf(c)));
            }
            for (int i = 0; i < second.length - 1; i++) {
                maxList.add(0, 0);
            }
        } else {
            for (char c : second) {
                maxList.add(Integer.parseInt(String.valueOf(c)));
            }
            for (char c : first) {
                minList.add(Integer.parseInt(String.valueOf(c)));
            }
            for (int i = 0; i < first.length - 1; i++) {
                maxList.add(0, 0);
            }
        }

        List<Integer> len = new ArrayList<>();
        int size = maxList.size();
        int flagCount = 0;
        for (int j = 0; j < size; j++) {
            boolean flag = true;
            for (int i = 0; i < Math.min(maxList.size(), minList.size()); i++) {
                if (maxList.get(i) != 0 && minList.get(i) + maxList.get(i) > 3) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                flagCount++;
                len.add(Math.max(minList.size(), maxList.size()));
            }
            if (maxList.get(0).equals(0)) {
                maxList.remove(0);
            } else {
                minList.add(0, 0);
            }
        }
        if (flagCount < 1) {
            writer.write(String.valueOf(first.length + second.length));
        } else {
            writer.write(String.valueOf(len.stream().mapToInt(value -> value).min().orElse(0)));
        }
        writer.flush();
        writer.close();
    }
}