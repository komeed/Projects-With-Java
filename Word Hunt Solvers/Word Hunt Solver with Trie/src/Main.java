import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//test: oatrihpshtnrenei
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner hi = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new FileReader("list.txt"));
        String ln1 = bf.readLine();
        Trie trie = new Trie();
        while (ln1 != null) {
            boolean bad = false;
            if (ln1.length()>=3&&ln1.length()<=7) {
                trie.insert(ln1.toLowerCase());
            }
            ln1 = bf.readLine();
        }
        bf.close();
        System.out.println("Enter letters from left to right and top to bottom");
        String in = hi.nextLine();
        String[][] inp = new String[4][4];
        for (int j = 0; j< in.length();j++) {
            inp[j / 4][j % 4] = ""+in.charAt(j);
        }

        ArrayList<String> words = new ArrayList<>();
        List<List<Location>> paths = new ArrayList<>();
        long stime = System.nanoTime();
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                Grid check = new Grid();
                check.setValue(new Location(i,j),9);
                ArrayList<Location> last = new ArrayList<>();
                last.add(new Location(i,j));
                Location currentMove = new Location(i,j);
                StringBuilder word = new StringBuilder(inp[i][j]);
                while(true){
                    ArrayList<Location> test = new ArrayList<Location>(last);
                    Location next = moveNext(currentMove,check, new int[]{0},test);
                    if (next == currentMove && last.size() == 1) {
                        break;
                    }
                    if(last.size()==1){
                        check.removeConstraintsExcept();
                    }
                    while(next==currentMove){
                        if(last.size()<=1){
                            break;
                        }
                        word = new StringBuilder(word.substring(0,word.length()-1));
                        check.setValue(currentMove,0);
                        Location tempMove = last.remove(last.size()-1);
                        currentMove = last.get(last.size()-1);
                        test = new ArrayList<Location>(last);
                        check.addConstraint(tempMove,currentMove,test);
                        next = moveNext(currentMove, check, new int[]{0},test);
                    }
                    word.append(inp[next.getRow()][next.getCol()]);
                    int val = trie.search(""+word);
                    if(val==2||val==1){
                        if(val==1){
                            boolean x = false;
                            for (String s : words) {
                                if (s.equals("" + word)) {
                                    x = true;
                                    break;
                                }
                            }
                            if(!x){
                                words.add(word+"");
                                ArrayList<Location> hii = new ArrayList<Location>(last);
                                hii.add(next);
                                paths.add(hii);
                            }
                        }
                        currentMove = next;
                    }

                    else{
                        word = new StringBuilder(word.substring(0,word.length()-1));
                        check.setValue(next,0);
                        currentMove = last.get(last.size()-1);
                        test = new ArrayList<Location>(last);
                        check.addConstraint(next,currentMove,test);
                    }
                    check.setValue(currentMove,2);
                    if(!last.get(last.size()-1).equal(currentMove.getRow(),currentMove.getCol())){
                        last.add(currentMove);
                    }
                }
            }
        }
        Long etime = System.nanoTime();
        bubbleSort(words,paths);
        System.out.print("{");
        for(int i = 0; i < paths.size();i++){
            if(i!=0) {
                System.out.print(", \"");
            }
            else{
                System.out.print("\"");
            }
            for(int j = 0; j < paths.get(i).size();j++){
                System.out.print(paths.get(i).get(j));
            }
            System.out.print("\"");
        }
        System.out.print("}");
    }

    public static Location moveNext(Location start, Grid g, int[] check, ArrayList<Location> path){
        int i = start.getRow()+1;
        int j = start.getCol()+1;
        int si = i;
        int sj = j;
        int r = -1;
        for(int c = 0; c <8; c++){
            if(c%4==1||c%4==0){
                i+=r;
            }
            else{
                j+=r;
            }
            if(i==si-2&&j==sj-2){
                r*=-1;
            }
            Location loc = new Location(i,j);
            if(g.validVal(loc)){
                for (int k : check) {
                    if (g.getValue(loc) == k&&!g.isConstrained(start,loc,path)) {
                        return loc;
                    }
                }
            }

        }
        return start;
    }
    public static void swap(ArrayList<String> arr, List<List<Location>> arr1, int index0, int index1) {
        String temp = arr.get(index0);
        arr.set(index0, arr.get(index1));
        arr.set(index1, temp);
        List<Location> temp1 = arr1.get(index0);
        arr1.set(index0, arr1.get(index1));
        arr1.set(index1, temp1);
    }
    public static void bubbleSort(ArrayList<String> arr,List<List<Location>> paths) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < arr.size() - 1; i += 1) {
                if (arr.get(i).length() < arr.get(i + 1).length()) {
                    swap(arr, paths, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }
}