import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Instructions: wasd + enter to move (type w and enter for up, d for down, etc.");
        Random r = new Random();
        Scanner hi = new Scanner(System.in);
        Board b = new Board();
        int[][] his = {{0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}};
        int rand0 = r.nextInt(10);
        if (rand0==0){
            b.spawnNum(4);
        }
        else{
            b.spawnNum(2);
        }
        int rand1 = r.nextInt(10);
        if (rand1==0){
            b.spawnNum(4);
        }
        else{
            b.spawnNum(2);
        }

        System.out.print(b);
        while(true){
            boolean cshift = false;
            int rand2 = r.nextInt(10);
            String bds = "";
            boolean ma = false;
            while(!ma){
                bds = hi.nextLine();
                if(bds.length()>0){
                    if (b.canShift(bds.charAt(0))){
                        if (bds.charAt(0)=='w'){
                            b.shiftUp(his);

                            ma=true;
                        }
                        else if (bds.charAt(0)=='s'){
                            b.shiftDown(his);
                            ma=true;
                        }
                        else if (bds.charAt(0)=='a'){
                            b.shiftLeft(his);
                            ma=true;
                        }
                        else if (bds.charAt(0)=='d'){
                            b.shiftRight(his);
                            ma=true;
                        }
                        else{
                            System.out.println("WRong");
                        }
                    }
                    else{
                        cshift = true;
                        System.out.println("can't shift");
                    }
                }
                else{
                    cshift = true;
                    System.out.println("can't shift");
                }
            }
            b.check();
            if (b.checkNum()){
                System.out.println("YOU LOST!!!");
                break;
            }
            if (!cshift){
                if (rand2==0){
                    b.spawnNum(4);
                }
                else{
                    b.spawnNum(2);
                }
            }

            System.out.print(b);

        }

    }




}
