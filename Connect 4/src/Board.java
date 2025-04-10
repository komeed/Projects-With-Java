public class Board {
    char[][] b = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
    public void dropIn(int pos, int p){
        for (int i = 5; i >=0; i--){
            if (b[i][pos-1]==' '){
                if (p==1){
                    b[i][pos-1]='R';
                    break;
                }
                else{
                    b[i][pos-1]='B';
                    break;
                }
            }

        }
    }
    //1 = red wins, 2 = blue wins
    public int check(){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 4; j++){
                if (b[i][j]=='R'&&b[i][j+1]=='R'&&b[i][j+2]=='R'&&b[i][j+3]=='R'){
                    return 1;
                }
                else if (b[i][j]=='B'&&b[i][j+1]=='B'&&b[i][j+2]=='B'&&b[i][j+3]=='B'){
                    return 2;
                }
            }
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 7; j++){
                if (b[i][j]=='R'&&b[i+1][j]=='R'&&b[i+2][j]=='R'&&b[i+3][j]=='R'){
                    return 1;
                }
                else if (b[i][j]=='B'&&b[i+1][j]=='B'&&b[i+2][j]=='B'&&b[i+3][j]=='B'){
                    return 2;
                }
            }
        }
        for (int i = 3; i <=5; i++){
            for (int j = 0; j <= 3; j++){
                if (b[i][j]=='R'&&b[i-1][j+1]=='R'&&b[i-2][j+2]=='R'&&b[i-3][j+3]=='R'){
                    return 1;
                }
                else if (b[i][j]=='B'&&b[i-1][j+1]=='B'&&b[i-2][j+2]=='B'&&b[i-3][j+3]=='B'){
                    return 2;
                }
            }
        }
        for (int i = 0; i <=2; i++){
            for (int j = 0; j <=3; j++){
                if (b[i][j]=='R'&&b[i+1][j+1]=='R'&&b[i+2][j+2]=='R'&&b[i+3][j+3]=='R'){
                    return 1;
                }
                else if (b[i][j]=='B'&&b[i+1][j+1]=='B'&&b[i+2][j+2]=='B'&&b[i+3][j+3]=='B'){
                    return 2;
                }
            }
        }
        return 0;
    }
    public void printBoard(){
        for (int i =0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                System.out.print("|"+b[i][j]);
                if (j==6){
                    System.out.print("|");
                }
            }
            System.out.println("");
        }
        System.out.println(" 1 2 3 4 5 6 7\n");

    }
}