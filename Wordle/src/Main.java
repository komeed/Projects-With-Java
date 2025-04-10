import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner hi = new Scanner(System.in);
        Random r = new Random();
        List<String> lw = new ArrayList<String>();
        List<String> la = new ArrayList<String>();
        BufferedReader bf1 = new BufferedReader(new FileReader("ValidWords.txt"));
        String ln1 = bf1.readLine();
        while (ln1 != null) {
            lw.add(ln1);
            ln1 = bf1.readLine();
        }
        bf1.close();
        BufferedReader bf2 = new BufferedReader(new FileReader("Answers.txt"));
        String ln2 = bf2.readLine();
        while(ln2 != null){
            la.add(ln2);
            ln2 = bf2.readLine();
        }
        bf2.close();
        String[] w = lw.toArray(new String[0]);
        String[] a = la.toArray(new String[0]);
        boolean stillPlaying = true;
        while(stillPlaying){
            char[] alph = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            //int[] checkA = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            ArrayList<Integer> checkA = new ArrayList<Integer>();
            ArrayList<Integer> rwordCount = new ArrayList<Integer>();
            for (int i = 0; i < 26; i++){
                rwordCount.add(0);
                checkA.add(0);
            }

            //int[] rwordCount = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

            String[][] b = {{"   ","   ","   ","   ","   "},
                    {"   ","   ","   ","   ","   "},
                    {"   ","   ","   ","   ","   "},
                    {"   ","   ","   ","   ","   "},
                    {"   ","   ","   ","   ","   "},
                    {"   ","   ","   ","   ","   "}};
            String rword = a[r.nextInt(2315)];

            for (int i = 0; i < 5; i++){
                rwordCount.set(rword.charAt(i)-97,rwordCount.get(rword.charAt(i)-97)+1);
                //rwordCount[rword.charAt(i)-97]++;
            }
            int row = 0;
            while(true){
                System.out.println(checkA);
                for (int i = 0; i < 6; i++){
                    for (int j = 0 ; j < 5; j++){
                        System.out.print("|" + b[i][j]+ "|");
                    }
                    System.out.println("");
                }
                System.out.print(" ______________________________\n|");
                for (int n = 0; n < 26; n++){
                    int z = 0;
                    for (int i = 0; i < 6; i++){
                        for (int j = 0; j < 5; j++){
                            if (b[i][j].charAt(1)==alph[n]){
                                if (b[i][j].charAt(0)=='Y'){
                                    if (checkA.get(b[i][j].charAt(1)-65)<=2) {
                                        checkA.set(b[i][j].charAt(1)-65,2);
                                    }
                                }
                                else if (b[i][j].charAt(0)=='G'){
                                    if (checkA.get(b[i][j].charAt(1)-65)<=3){
                                        checkA.set(b[i][j].charAt(1)-65,3);
                                    }
                                }
                                else{
                                    if (checkA.get(b[i][j].charAt(1)-65)<=1){
                                        checkA.set(b[i][j].charAt(1)-65,1);
                                    }
                                }
                            }
                        }
                    }
                    if (checkA.get(n)==0){
                        System.out.print(" "+alph[n]+" ");
                    }
                    else if (checkA.get(n)==1){
                        System.out.print("   ");
                    }
                    else if (checkA.get(n)==2){
                        System.out.print("Y"+alph[n]+"Y");
                    }
                    else if (checkA.get(n)==3){
                        System.out.print("G"+alph[n]+"G");
                    }
                    if (n==9){
                        System.out.print("|\n| ");
                    }
                    else if (n==18){
                        System.out.print("  |\n|    ");
                    }

                }
                System.out.println("     |\n");
                System.out.println("Enter word:");
                String inp = hi.nextLine();
                inp = inp.toLowerCase();
                if (inp.length()!=5){
                    System.out.println("not correct word length");
                    continue;
                }
                if (inp.equals(rword)){
                    System.out.println("YOU WIN");
                    boolean choice = true;
                    while(choice){
                        System.out.println("continue playing? 'y': yes, 'n': no");
                        String c = hi.nextLine();
                        if (c.length()!=1){
                            System.out.println("FOLLOW INSTRUCTIONS");
                            continue;
                        }
                        c.toLowerCase();
                        if (c.charAt(0)=='y'){
                            choice = false;
                            System.out.println("loading board");
                        }
                        else if (c.charAt(0)=='n'){
                            choice = false;
                            System.out.println("Have a good day :D");
                            stillPlaying = false;
                        }
                        else{
                            System.out.println("y or n dude");
                        }
                    }

                    break;
                }
                int[] awordCount = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                int c = 0;
                for (int i = 0; i < w.length; i++) {
                    if (w[i].equalsIgnoreCase(inp)) {
                        for (int z = 0; z < 5; z++){
                            b[row][z]=" "+Character.toUpperCase(inp.charAt(z))+" ";
                        }
                        c = 1;
                        int[] x = new int[5];
                        for (int j = 0; j < 5; j++) {
                            boolean found = false;
                            for (int k = 0; k < 5; k++) {

                                if (w[i].charAt(j) == rword.charAt(k)) {
                                    //System.out.println(j+" "+ k);
                                    if (j == k) {
                                        b[row][j]=""+'G'+Character.toUpperCase(inp.charAt(j))+'G';

                                        int c2 = 0;
                                        for (int m = 0; m < 5; m++){
                                            if (b[row][m].charAt(1)==Character.toUpperCase(inp.charAt(j))){
                                                //System.out.println("m: " +m+" j: "+j);
                                            //if (b[row][m].equals("Y"+Character.toUpperCase(inp.charAt(j))+"Y")||b[row][m].equals("G"+Character.toUpperCase(inp.charAt(j))+"G")){
                                                c2++;
                                            }
                                        }
                                        //System.out.println(rwordCount[inp.charAt(j)-97]+" "+c2);
                                        if (rwordCount.get(inp.charAt(j)-97)<c2){
                                            //System.out.println(c2+ " "+ j);
                                            for (int m = 0; m<5; m++){
                                                if (b[row][m].equals("Y"+Character.toUpperCase(inp.charAt(j))+"Y")||b[row][m].equals(" "+Character.toUpperCase(inp.charAt(j))+" ")){
                                                    //System.out.println(m);
                                                    int c3 = 0;
                                                    for (int g = 0; g < x.length; g++){
                                                        if (x[g]==1){
                                                            c3++;
                                                        }
                                                    }
                                                    if (c3+rwordCount.get(inp.charAt(j)-97)<c2){
                                                        x[m]=1;
                                                    }
                                                    //System.out.println(m+" "+j);

                                                    b[row][m]=" "+Character.toUpperCase(inp.charAt(j))+" ";
                                                }
                                            }
                                        }

                                    } else {
                                        if (x[j]!=1){

                                            b[row][j] = "" + 'Y' + Character.toUpperCase(inp.charAt(j)) + 'Y';
                                        }

                                    }
                                    found = true;
                                    if (b[row][j].equals("G"+Character.toUpperCase(inp.charAt(j))+"G")){
                                        break;
                                    }
                                }
                            }
                            if (!found) {
                                b[row][j] = " " + Character.toUpperCase(inp.charAt(j)) + " ";
                            }
                        }
                        row++;
                        break;
                    }
                }
                if(c!=1) {
                    System.out.println("invalid word");
                }
                if (row==6){
                    System.out.println("You suck!!!!! the word was "+rword+" lol");
                    boolean c2 = true;
                    while(c2){
                        System.out.println("continue playing? 'y': yes, 'n': no");
                        String d = hi.nextLine();
                        if (d.length()!=1){
                            System.out.println("FOLLOW INSTRUCTIONS");
                            continue;
                        }
                        d.toLowerCase();
                        if (d.charAt(0)=='y'){
                            c2 = false;
                            System.out.println("loading board");
                        }
                        else if (d.charAt(0)=='n'){
                            c2 = false;
                            System.out.println("Have a good day :D");
                            stillPlaying = false;
                        }
                        else{
                            System.out.println("y or n dude");
                        }
                    }
                    break;
                }
            }
        }

    }
}