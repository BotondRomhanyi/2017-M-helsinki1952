package erettsegik;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            List<Result> results = new ArrayList<>();

            //2.feladat
            try (BufferedReader reader = new BufferedReader(new FileReader("helsinki.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Result result = new Result(line);
                    results.add(result);
                }
            }

            //3.feladat
            System.out.println("3. feladat:\nPontszerző helyezések száma: " + results.size());

            //4.feladat
            int first = Result.placeCounter(results,1);
            int second = Result.placeCounter(results,2);
            int third = Result.placeCounter(results,3);
            int sum = first + second + third;
            System.out.println("4. feladat:");
            System.out.println("Arany: " + first);
            System.out.println("Ezüst: " + second);
            System.out.println("Bronz: " + third);
            System.out.println("Össszesen: " + sum);

            //5.feladat
            System.out.println("5. feladat:\nOlimpiai pontok száma: " + Result.pointCounter(results));

            //6.feladat
            System.out.println("6. feladat:");
            if (Result.counterBySport(results,"uszas") > Result.counterBySport(results,"torna")) {
                System.out.println("Úszás sportágban szereztek több érmet");
            } else if (Result.counterBySport(results,"uszas") < Result.counterBySport(results,"torna")) {
                System.out.println("Torna sportágban szereztek több érmet");
            } else {
                System.out.println("Egyenlő volt az érmek száma”");
            }

            //7.feladat
            try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("helsinki2.txt")))) {
                for (Result result : results) {
                    writer.print(
                            result.place + " " +
                                    result.teamSize + " " +
                                    Result.pointCounter(result) + " ");
                    if (result.sport.equals("kajakkenu")) {
                        writer.print( "kajak-kenu" + " " + result.event + "\n");
                    } else {
                        writer.print( result.sport + " " + result.event + "\n");
                    }
                }
            }

            //8.feladat
            Result mostMembers = null;
            int mostMemberCounter = 0;
            for(Result result : results) {
                if (result.teamSize > mostMemberCounter) {
                    mostMemberCounter = result.teamSize;
                    mostMembers = result;
                }
            }
            System.out.println("8. feladat:");
            System.out.println("Helyezés: " + mostMembers.place);
            System.out.println("Sportág: " + mostMembers.sport);
            System.out.println("Versenyszám: " + mostMembers.event);
            System.out.println("Sportolók száma: " + mostMembers.teamSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}