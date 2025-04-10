import java.util.Random;
public class Board{
    Random hi = new Random();
    private int[][] b = {{0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}};
    private int[][] tb = {{0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}};
    String[] a = {"00","01","02","03","10","11","12","13","20","21","22","23","30","31","32","33"};
    public boolean checkNum(){
        int c = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i].length() ==3){
                c++;
            }
        }
        if (c==a.length-1){
            return true;
        }
        return false;
    }
    public void spawnNum(int num){
        int c = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i].length() ==3){
                c++;
            }
        }
        int randPos = hi.nextInt(a.length-c);
        for (int i = 0; i < a.length; i++){
            if (a[i].length()==3){
                randPos++;
            }
            if (randPos==i){
                break;
            }
        }
        int row = Character.getNumericValue(a[randPos].charAt(0));
        int col = Character.getNumericValue(a[randPos].charAt(1));
        b[row][col]=num;
        for (int i = 0; i < a.length; i++){
            if (a[i].charAt(0) == (char)row && a[i].charAt(1)== (char)col){
                a[i] += "0";
            }
        }
    }

    public void check(){
        for (int i = 0; i < 4; i++){
            for (int j = 0;j<4;j++){
                if (b[i][j]==0){
                    for (int z = 0; z < a.length; z++){
                        if (Character.getNumericValue(a[z].charAt(0))==i&&Character.getNumericValue(a[z].charAt(1))==j){
                            if (a[z].length()==3){
                                a[z]=a[z].substring(0,2);
                            }
                        }
                    }
                }
                if (b[i][j]!=0){
                    for (int z = 0; z < a.length; z++){
                        if (Character.getNumericValue(a[z].charAt(0))==i&&Character.getNumericValue(a[z].charAt(1))==j){
                            if (a[z].length()==2){
                                a[z]+= "0";
                            }
                        }
                    }
                }
            }
        }
    }
    public void setNum(int row, int col, int num){
        b[row][col] = num;
        for (int i = 0; i < a.length; i++){
            if (a[i].charAt(0) == (char)row && a[i].charAt(1)== (char)col){
                a[i] = "0";
            }
        }
    }
    public boolean canShift(char direction) {
        for (int i = 0; i < 4; i++) {
            System.arraycopy(b[i], 0, tb[i], 0, 4);
        }
        switch (direction) {
            case 'a':
                shiftLeft(tb);
                break;
            case 'd':
                shiftRight(tb);
                break;
            case 'w':
                shiftUp(tb);
                break;
            case 's':
                shiftDown(tb);
                break;
            default:
                return false;
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (b[i][j] != tb[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
    public void shiftUp(int[][] boa) {
        int[][] bo = boa;
        if (bo != tb) {
            bo=b;
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                if (bo[i][j] != 0) {
                    int k = i - 1;
                    while (k >= 0 && bo[k][j] == 0) {
                        bo[k][j] = bo[k + 1][j];
                        bo[k + 1][j] = 0;
                        k--;
                    }
                    if (k >= 0 && bo[k][j] == bo[k + 1][j]) {
                        bo[k][j] *= 2;
                        bo[k + 1][j] = 0;
                    }
                }
            }
        }
    }
    public void shiftRight(int[][] boa) {
        int[][] bo = boa;
        if (bo != tb) {
            bo = b;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                if (bo[i][j] != 0) {
                    int k = j + 1;
                    while (k < 4 && bo[i][k] == 0) {
                        bo[i][k] = bo[i][k - 1];
                        bo[i][k - 1] = 0;
                        k++;
                    }
                    if (k < 4 && bo[i][k] == bo[i][k - 1]) {
                        bo[i][k] *= 2;
                        bo[i][k - 1] = 0;
                    }
                }
            }
        }
    }

    public void shiftLeft(int[][] boa) {
        int[][] bo = boa;
        if (bo != tb) {
            bo = b;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (bo[i][j] != 0) {
                    int k = j - 1;
                    while (k >= 0 && bo[i][k] == 0) {
                        bo[i][k] = bo[i][k + 1];
                        bo[i][k + 1] = 0;
                        k--;
                    }
                    if (k >= 0 && bo[i][k] == bo[i][k + 1]) {
                        bo[i][k] *= 2;
                        bo[i][k + 1] = 0;
                    }
                }
            }
        }
    }

    public void shiftDown(int[][] boa) {
        int[][] bo = boa;
        if (bo != tb) {
            bo= b;
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 2; i >= 0; i--) {
                if (bo[i][j] != 0) {
                    int k = i + 1;
                    while (k < 4 && bo[k][j] == 0) {
                        bo[k][j] = bo[k - 1][j];
                        bo[k - 1][j] = 0;
                        k++;
                    }
                    if (k < 4 && bo[k][j] == bo[k - 1][j]) {
                        bo[k][j] *= 2;
                        bo[k - 1][j] = 0;
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            result.append(" ______ ______ ______ ______\n|      |      |      |      |\n");
            for (int j = 0; j < 4; j++) {
                String value = String.valueOf(b[i][j]);
                int p = (6 - value.length()) / 2;
                int r = 6 - value.length() - p;
                result.append("|");
                for (int k = 0; k < p; k++) {
                    result.append(" ");
                }
                result.append(value);
                for (int k = 0; k < r; k++) {
                    result.append(" ");
                }
            }
            result.append("|\n|______|______|______|______|\n");
        }
        return result.toString();
    }
}