import java.util.ArrayList;
import java.util.List;

public class Task85 {
    public int maximalRectangle(char[][] matrix) {
        matrix = changeMatrix(matrix);
        int lenX = matrix[0].length;
        int lenY = matrix.length;
        int maxS = 0;

        boolean isExtremeYKnow = false;
        int extremeX = 0;
        int extremeY = 0;
        for (int x = 0; x < lenX; x++) {
            for (int y = 0; y < lenY; y++) {


                if ((lenX - x) * lenY <= maxS) {
                    return maxS;
                }
                if ((lenX - x) * (lenY - y) <= maxS) {
                    break;
                }
                if (matrix[y][x] == '0') {
                    isExtremeYKnow = false;
                    continue;
                }

                extremeX = x; // последния точка где '1' по оси X

                for (int potentialX = x; potentialX < lenX; potentialX++) {
                    if (matrix[y][potentialX] == '0') {
                        extremeX = potentialX - 1;
                        break;
                    }
                    extremeX = potentialX;
                }

                if (!isExtremeYKnow) {
                    extremeY = y; // последния точка где '1' по оси Y
                    for (int potentialY = y; potentialY < lenY; potentialY++) {
                        if (matrix[potentialY][x] == '0') {
                            extremeY = potentialY - 1;
                            break;
                        }
                        extremeY = potentialY;
                    }
                    isExtremeYKnow = true;
                }


                if ((extremeX - x + 1) * (extremeY - y + 1) <= maxS) {
                    continue;
                }

                for (int endX = extremeX; endX >= x; endX--) {
                    for (int endY = extremeY; endY >= y; endY--) {
                        if ((endX - x + 1) * (endY - y + 1) <= maxS) {
                            break;
                        }
                        if (isCorrectRectangle(matrix, x, y, endX, endY)) {
                            maxS = (endX - x + 1)*(endY - y + 1);
                            break;
                        }
                    }
                }
            }
            isExtremeYKnow = false;
        }
        return maxS;
    }


    public static boolean isCorrectRectangle(char[][] matrix, int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (matrix[y][x] == '0') {
                    return false;
                }
            }
        }
        return true;
    }

    public static char[][] changeMatrix(char[][] matrix) {
        List<char[]> lines = new ArrayList<>();
        boolean lastLineZerow = false;
        boolean theLineZerow;
        for (char[] line : matrix) {
            theLineZerow = true;
            for (int i : line) {
                if (i != '0') {
                    lines.add(line);
                    theLineZerow = false;
                    lastLineZerow = false;
                    break;
                }
            }
            if (theLineZerow) {
                if (!lastLineZerow) {
                    lines.add(line);
                }
                lastLineZerow = true;
            }
        }
        char[][] newMat = new char[lines.size()][matrix[0].length];
        for (int i = 0; i < lines.size(); i++) {
            newMat[i] = lines.get(i);
        }
        return newMat;
    }
}
