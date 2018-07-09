package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();
        String[] wordlist = words;

        for (String word : wordlist) {
            int startX;
            int startY;


            for (int i = 0, j = 0; i < crossword.length; j++) {
                if (crossword[i][j] == word.charAt(0)) {
                    startX = i;
                    startY = j;

                    ArrayList<Cell> endCells = getEndCells(crossword, word, 1, startX, startY);

                    for (Cell endCell : endCells) {
                        Word word1 = new Word(word);
                        word1.setStartPoint(startY, startX);
                        word1.setEndPoint(endCell.getY(), endCell.getX());

                        result.add(word1);
                    }
                }

                if (j == crossword[i].length - 1) {
                    i++;
                    j = -1;
                }
            }
        }

        return result;
    }

    public static ArrayList<Cell> getEndCells(int[][] crossword, String word, int position, int x, int y) {
        Queue<Cell> cellQueue = new LinkedList<>();
        ArrayList<Cell> endCells = new ArrayList<>();

        cellQueue.add(new Cell(x, y, position));

        while (!cellQueue.isEmpty()) {
            Cell c = cellQueue.poll();
            findNextChar(crossword, word, c.charPosition, c.getX(), c.getY(), cellQueue, endCells);
        }

        return endCells;
    }

    public static final int[][] directionShifts = {
            {0, -1},
            {-1, -1},
            {-1, 0},
            {-1, +1},
            {0, +1},
            {+1, +1},
            {+1, 0},
            {+1, -1}
    };

    public static void findNextChar(int[][] crossword, String word, int position, int x, int y, Queue<Cell> cellQueue, ArrayList<Cell> endCells) {
        for (int[] shift : directionShifts) {
            int nextX = x + shift[0];
            int nextY = y + shift[1];

            if (nextX >= 0 && nextY >= 0 && nextX < crossword.length && nextY < crossword[nextX].length && crossword[nextX][nextY] == word.charAt(position)) {
                if (position != word.length() - 1) cellQueue.add(new Cell(nextX, nextY, position + 1));
                else endCells.add(new Cell(nextX, nextY));
            }
        }
    }

    public static class Cell {
        private int x, y, charPosition;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Cell(int x, int y, int charPosition) {
            this.x = x;
            this.y = y;
            this.charPosition = charPosition;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
