package erettsegik;

import java.util.List;

public class Result {
    public int place;
    public int teamSize;
    public String sport;
    public String event;

    public Result(String dataLine) {
        String[] Data = dataLine.split(" ");
        this.place = Integer.parseInt(Data[0]);
        this.teamSize = Integer.parseInt(Data[1]);
        this.sport = Data[2];
        this.event = Data[3];
    }

    public static int placeCounter (List<Result> list, int place) {
        int counter = 0;
        for (Result result : list) {
            if (result.place == place) counter++;
        }
        return counter;
    }

    public static int pointCounter (List<Result> list) {
        int counter = 0;
        for (Result result : list) {
            switch (result.place) {
                case (1) -> counter += 7;
                case (2) -> counter += 5;
                case (3) -> counter += 4;
                case (4) -> counter += 3;
                case (5) -> counter += 2;
                case (6) -> counter += 1;
            }
        }
        return counter;
    }

    public static int pointCounter (Result result1) {
        return switch (result1.place) {
            case (1) -> 7;
            case (2) -> 5;
            case (3) -> 4;
            case (4) -> 3;
            case (5) -> 2;
            case (6) -> 1;
            default -> 0;
        };
    }

    public static int counterBySport (List<Result> list, String sport) {
        int counter = 0;
        for (Result result : list) {
            if (result.sport.equals(sport) && "123".contains(Integer.toString(result.place))) counter++;
        }
        return counter;
    }
}
