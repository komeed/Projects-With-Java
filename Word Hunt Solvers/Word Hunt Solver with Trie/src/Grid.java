import java.util.ArrayList;
import java.util.List;
public class Grid {
    int[][] grid = new int[4][4];
    ArrayList<Location> constraints = new ArrayList<>();
    ArrayList<Location> based = new ArrayList<>();
    List<List<Location>> paths = new ArrayList<List<Location>>();
    public Grid(){
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4;j++){
                grid[i][j] = 0;
            }
        }
    }
    public void removeConstraintsExcept(){
        for(int i = 0; i  <constraints.size();i++){
            if(paths.get(i).size()>1){
                constraints.remove(i);
                paths.remove(i);
                based.remove(i);
                i--;
            }
        }
    }
    public boolean validVal(Location loc){
        return loc.getRow() > -1 && loc.getRow() < 4 && loc.getCol() > -1 && loc.getCol() < 4;
    }
    public int getValue(Location loc){
        return grid[loc.getRow()][loc.getCol()];
    }
    public void setValue(Location loc,int v){
        grid[loc.getRow()][loc.getCol()]=v;
    }
    public void addConstraint(Location loc,Location constBased,ArrayList<Location> path){
        constraints.add(loc);
        based.add(constBased);
        paths.add(path);
    }
    public boolean isConstrained(Location start,Location next, ArrayList<Location> path){
        //System.out.println(constraints);
        //System.out.println(based);
        //if(paths.size()==3){
            //System.out.println("this: "+paths.get(paths.size()-1));
        //}
        for(int i = 0; i < constraints.size(); i++){
            //System.out.println(i+" "+constraints.get(i)+based.get(i)+paths.get(i));
            boolean done = false;
            for(int j = 0; j< paths.get(i).size(); j++){
                if(paths.get(i).size()==path.size()){
                    if(!paths.get(i).get(j).equal(path.get(j).getRow(),path.get(j).getCol())){
                        done = true;
                        break;
                    }
                }
                else{
                    done=true;
                    break;
                }
            }
            if(done){
                continue;
            }
            if(constraints.get(i).equal(next.getRow(),next.getCol())&&based.get(i).equal(start.getRow(),start.getCol())){
                //System.out.println(i+" "+constraints.get(i).equal(next.getRow(),next.getCol())+based.get(i).equal(start.getRow(),start.getCol())+paths.get(i)+path);
                return true;
            }
        }
        return false;
    }
    public String toString(){
        StringBuilder a = new StringBuilder();
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                a.append(grid[i][j]).append(" ");
            }
            a.append("\n");
        }
        return String.valueOf(a);
    }
}
