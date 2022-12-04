package org.rt.advent.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public abstract class DayPuzzle {

    public BufferedReader getDayStream() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(getClass().getSimpleName().toLowerCase()+".txt");
        return new BufferedReader(new InputStreamReader(is));
    }

    public String[] getDayStreamAllLines() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        BufferedReader reader = getDayStream();
        String line = reader.readLine();
        while (line != null) {
            result.add(line);
            line = reader.readLine();
        }

        return result.toArray(new String[0]);
    }

    public Stream<String> getDayStreamAllLinesAsStream() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        BufferedReader reader = getDayStream();

        return reader.lines();
    }

    public int[] getDayStringAsIntArray() throws IOException {
        return Arrays.stream(getDayStream().readLine().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public URI getDayInput() throws IOException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            return classloader.getResource(getClass().getSimpleName().toLowerCase()+".txt").toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException("invalid uri:",e);
        }

    }

    public abstract String puzzle1() throws PuzzleFailedException;
    public abstract String puzzle2() throws PuzzleFailedException;

    public static void runPuzzles(DayPuzzle day) {
        try {
            display("Puzzle 1:");
            display(day.puzzle1());
            display("Puzzle 2:");
            display(day.puzzle2());

        } catch(Exception e) {
            System.err.println("Failed");
            e.printStackTrace();
        }
    }
    public static void display(String value) {
        System.out.println(value);
    }




}
