package gol;

import java.util.Arrays;

public class GameOfLife implements Board {

   
    private int[][] board;

    public GameOfLife(int x, int y)
    {
        board = new int[x][y];
    }

    public void set(int x, int y, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                board[i + x][j + y] = data[i][j];
            }
        }
    }

    public void run(int turns) {
        for (int i = 0; i < turns; i++) {
            step();
        }
    }

    public void step()
    {
        print();

        int[][] next = new int[board.length][board[0].length];

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {

                int neighbors = countNeighbors(x, y);
                int cell = board[x][y];

                if (cell == 1) {
                    if (neighbors == 2 || neighbors == 3)
                        next[x][y] = 1;
                    else
                        next[x][y] = 0; 
                }
                else {
                    if (neighbors == 3)
                        next[x][y] = 1; 
                    else
                        next[x][y] = 0;
                }
            }
        }

        board = next;
    }

    public int countNeighbors(int x, int y) {
        int count = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {

                // skip the cell itself
                if (dx == 0 && dy == 0) continue;

                count += get(x + dx, y + dy);
            }
        }

        return count;
    }

    