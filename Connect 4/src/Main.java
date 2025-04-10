import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner hi = new Scanner(System.in);
        Board b = new Board();
        b.printBoard();
        while(true){

            while(true){
                System.out.println("Player 1 turn: (format: type number that you see on board)");
                String s = hi.nextLine();
                if (s.length() ==1){
                    if (s.charAt(0)-49>=0&&s.charAt(0)-49<=7){
                        b.dropIn(s.charAt(0)-48, 1);
                        break;
                    }
                }
            }
            if (b.check()==1){
                b.printBoard();
                System.out.println("P1 WINS");
                break;
            }
            b.printBoard();
            while(true){
                System.out.println("Player 2 turn: (format: type number that you see on board)");
                String s2 = hi.nextLine();
                if (s2.length() ==1){
                    if (s2.charAt(0)-49>=0&&s2.charAt(0)-49<=7){
                        b.dropIn(s2.charAt(0)-48, 2);
                        break;
                    }
                }
            }
            if (b.check()==2){
                b.printBoard();
                System.out.println("P2 WINS");
                break;
            }
            b.printBoard();
        }

    }
}