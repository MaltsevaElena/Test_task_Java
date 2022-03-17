package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);

        int radius = 0;
        Point circleCoordinate = null;
        Point pointCoordinate;

        String line;
        String[] allLine;
        List<Point> listPoints;


        try (FileReader fileReader = new FileReader(file1); Scanner scanner = new Scanner(fileReader)) {

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                allLine = line.split("\\s");
                if (allLine.length == 1) {
                    radius = Integer.parseInt(allLine[0]);
                } else {
                    circleCoordinate = new Point();
                    circleCoordinate.setX(Float.parseFloat(allLine[0]));
                    circleCoordinate.setY(Float.parseFloat(allLine[1]));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        listPoints = new ArrayList<>();

        try (FileReader fileReader = new FileReader(file2); Scanner scanner = new Scanner(fileReader)) {

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                allLine = line.split("\\s");

                pointCoordinate = new Point();
                pointCoordinate.setX(Float.parseFloat(allLine[0]));
                pointCoordinate.setY(Float.parseFloat(allLine[1]));
                listPoints.add(pointCoordinate);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        float radiusSquared = (float) Math.pow(radius, 2);
        for (Point p : listPoints) {
            assert circleCoordinate != null;
            float sumSquaresPointCoordinate = (float) (Math.pow(p.getX() - circleCoordinate.getX(), 2) +
                    Math.pow(p.getY() - circleCoordinate.getY(), 2));

            if (sumSquaresPointCoordinate < radiusSquared) {
                System.out.println("1 - точка внутри");
            } else if (sumSquaresPointCoordinate == radiusSquared) {
                System.out.println("0 - точка лежит на окружности");
            } else System.out.println("2 - точка снаружи");
        }
    }
}
