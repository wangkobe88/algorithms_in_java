package dfs;

/**
 * Created by kewang on 11/11/18.
 */
/*
* 字符串有固定的长度，Recursion tree就有高度。
* */
public class WordSearch {
    private boolean existDFS(char[][] board, char[] wordChars, int row, int col, int level, boolean[][] visited) {

        if(wordChars.length == level) {
            return true;
        }
        //System.out.println(wordChars[level]);
        if((row + 1) < board.length && visited[row + 1][col] == false && wordChars[level] == board[row + 1][col]) {
            visited[row + 1][col] = true;
            if(existDFS(board, wordChars, row + 1, col, level + 1, visited)) {
                return true;
            }
            visited[row + 1][col] = false;
        }

        if((row - 1) >= 0 && visited[row - 1][col] == false && wordChars[level] == board[row - 1][col]) {
            visited[row - 1][col] = true;
            if(existDFS(board, wordChars, row - 1, col, level + 1, visited)) {
                return true;
            }
            visited[row - 1][col] = false;
        }

        if((col + 1) < board[0].length && visited[row][col + 1] == false && wordChars[level] == board[row][col + 1]) {
            visited[row][col + 1] = true;
            if(existDFS(board, wordChars, row, col + 1, level + 1, visited)) {
                return true;
            }
            visited[row][col + 1] = false;
        }

        if((col - 1) >= 0 && visited[row][col - 1] == false && wordChars[level] == board[row][col - 1]) {
            visited[row][col - 1] = true;
            if(existDFS(board, wordChars, row, col - 1, level + 1, visited)) {
                return true;
            }
            visited[row][col - 1] = false;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if(existDFS(board, word.toCharArray(), i, j, 1, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
