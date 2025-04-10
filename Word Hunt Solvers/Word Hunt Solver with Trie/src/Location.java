public class Location {
    private int row;
    private int col;
    public Location(int r, int c){
        row = r;
        col = c;
    }
    public boolean equal(int r, int c){
        return row == r && col == c;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public void setRow(int r){
        row = r;
    }
    public void setCol(int c){
        col = c;
    }
    public String toString(){
        return row+""+col;
    }

}
