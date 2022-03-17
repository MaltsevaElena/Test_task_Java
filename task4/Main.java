package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file;

        String line;
        int number;
        List<Integer> list;

        file = new File(args[0]);
        list = new ArrayList<>();

        try (FileReader fileReader = new FileReader(file); Scanner scanner = new Scanner(fileReader)) {

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                number = Integer.parseInt(line);
                list.add(number);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(minStep(list));
    }

    public static int minStep(List<Integer> lists) {
        int min = 0;
        int step;
        for (int i = 0; i < lists.size(); i++) {
            step = 0;
            for (int j = 0; j < lists.size(); j++) {
                if (j != i) {
                    step = step + Math.abs(lists.get(j) - lists.get(i));
                }
            }
            if (step < min || min == 0) {
                min = step;
            }
        }
        return min;
    }
}