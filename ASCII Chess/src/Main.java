import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("WARNING: only legal moves allowed (haven't implemented legal move checker)");
        Board b = new Board();
        Scanner hi = new Scanner(System.in);
        b.printBoard();
        while(true){
            if (b.checkForCheck()==1){
                System.out.println("White checks black");
            }
            else if (b.checkForCheck()==2){
                System.out.println("Black checks white");
            }
            else if (b.checkForCheck()==3){
                System.out.println("WHITE WINS");
            }
            else if (b.checkForCheck()==4){
                System.out.println("BLACK WINS");
            }
            System.out.println("Player 1 turn: (format: firstpos + secondpos: ex. 'a2a4'");
            System.out.print("Inp: ");
            String ba = hi.nextLine();
            if (b.checkMove(ba.substring(0,2),ba.substring(2),1)){
                b.moveTo(ba.substring(0,2),ba.substring(2));
            }
            else{
                System.out.println("Invalid Move");
            }
            b.printBoard();
            if (b.checkForCheck()==1){
                System.out.println("White checks black");
            }
            else if (b.checkForCheck()==2){
                System.out.println("Black checks white");
            }
            else if (b.checkForCheck()==3){
                System.out.println("WHITE WINS");
            }
            else if (b.checkForCheck()==4){
                System.out.println("BLACK WINS");
            }
            boolean check = false;
            while(!check){
                System.out.println("Player 2 turn: (format: firstpos + secondpos: ex. 'a7a5'");
                String bah = hi.nextLine();
                if (b.checkMove(bah.substring(0,2),bah.substring(2),2)){
                    b.moveTo(bah.substring(0,2),bah.substring(2));
                    check = true;
                }
                else{
                    System.out.println("Invalid Move");
                }
                b.printBoard();
            }

        }

    }
}