// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner hi = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new FileReader("Test"));
        ArrayList<String> temp = new ArrayList<String>();
        String ln1 = bf.readLine();
        while(ln1!=null){
            boolean bad = false;
            for (int i = 0; i < ln1.length()-1; i++){
                if (ln1.charAt(i)==ln1.charAt(i+1)){
                    bad=true;
                    break;
                }
            }
            if(!bad) {
                temp.add(ln1);
            }
            ln1 = bf.readLine();
        }
        bf.close();
        //System.out.println("Which game for answers? \n1) spelling bee\n2) letters boxed\n3) ");
        String[] wordlist = temp.toArray(new String[0]);
        System.out.println("Input letter from top left corner of top row and go clockwise");
        String inp = hi.nextLine();
        System.out.println("How many words");
        int wordNum = hi.nextInt();
        ArrayList<String> in = new ArrayList<String>();
        for (int i = 0; i < 12; i+=3){
            in.add(inp.substring(i,i+3));
        }
        //System.out.println(in);
        ArrayList<String> possibleWords = new ArrayList<String>();
        String test = " ";
        String maxWord = "";
        for (int i = 0; i < wordlist.length;i++){
            boolean bad = false;
            if (wordlist[i].length()>=3){

                for (int j = 0; j < wordlist[i].length(); j++){
                    if(inp.indexOf(wordlist[i].charAt(j))==-1){
                        bad=true;
                        break;
                    }
                }
            }
            else{
                continue;
            }
            if(!bad) {
                boolean bad2 = false;
                for (int j = 0; j < wordlist[i].length() - 1; j++) {
                    if (inp.indexOf(wordlist[i].charAt(j)) / 3 == inp.indexOf(wordlist[i].charAt(j + 1)) / 3) {
                        bad2 = true;
                        break;
                    }
                }
                if (!bad2){
                    //System.out.println(wordlist[i]);
                    possibleWords.add(wordlist[i]);
                    test += wordlist[i]+" ";
                }
            }
        }
        if(wordNum==2){

            for (int i = 0; i < possibleWords.size(); i++){
                if (possibleWords.get(i).length()>maxWord.length()){
                    maxWord=possibleWords.get(i);
                }
                else if (possibleWords.get(i).length()==maxWord.length()){
                    maxWord=possibleWords.get(i);
                }
                String t = test;
                char last = possibleWords.get(i).charAt(possibleWords.get(i).length()-1);
                int index = t.indexOf(" "+last)+1;
                while(index!=0){
                    int index2 = t.substring(index).indexOf(" ")+index;
                    String combined = possibleWords.get(i)+t.substring(index,index2);
                    boolean bad = false;
                    for (int j = 0; j < inp.length(); j++){
                        if(combined.indexOf(inp.charAt(j))==-1){
                            bad=true;
                            break;
                        }
                    }
                    if(!bad){
                        System.out.println(possibleWords.get(i)+"-"+t.substring(index,index2));
                    }
                    t = t.substring(0,index-1)+t.substring(index2+1);
                    index = t.indexOf(" "+last)+1;
                    //System.out.println(index);
                }
            }
        }

        if(wordNum==3){
            for (int i = 0; i < possibleWords.size(); i++){
                if (possibleWords.get(i).length()>maxWord.length()){
                    maxWord=possibleWords.get(i);
                }
                else if (possibleWords.get(i).length()==maxWord.length()){
                    maxWord=possibleWords.get(i);
                }
                String t = test;
                char last = possibleWords.get(i).charAt(possibleWords.get(i).length()-1);
                int index = t.indexOf(" "+last)+1;
                while(index!=0){
                    int index2 = t.substring(index).indexOf(" ")+index;
                    char last2 = t.substring(index,index2).charAt(t.substring(index,index2).length()-1);
                    int index3 = t.indexOf(" "+last2)+1;
                    String t2 = t;
                    while(index3!=0) {
                        int index4 = t2.substring(index3).indexOf(" ") + index3;
                        //System.out.println(index4);
                        String combined = possibleWords.get(i) + t.substring(index, index2) + t2.substring(index3, index4);
                        //System.out.println(possibleWords.get(i)+" "+t.substring(index,index2)+" "+t2.substring(index3, index4));
                        boolean bad = false;
                        for (int j = 0; j < inp.length(); j++) {
                            if (combined.indexOf(inp.charAt(j)) == -1) {
                                bad = true;
                                break;
                            }
                        }
                        if (!bad) {
                            System.out.println(possibleWords.get(i) + "-" + t.substring(index, index2) + "-" + t2.substring(index3, index4));
                        }
                        //System.out.println(index4);
                        t2= t2.substring(0, index3 - 1) + t2.substring(index4);
                        index3 = t2.indexOf(" "+last2)+1;
                        //System.out.println(index);
                    }
                    t = t.substring(0, index - 1) + t.substring(index2);
                    index = t.indexOf(" "+last)+1;
                }
            }
        }
        System.out.println("Max Word: "+maxWord);
    }
}