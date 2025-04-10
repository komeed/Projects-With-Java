public class Spawner {
    int a[][];
    public Spawner(int ar[][]){
        a=ar;
    }
    public void fixRow(int r){
        for (int i = 0; i < 10; i++){
            if (!checkBlock(r,i*2+1)){
                a[r][i*2+1]=0;
            }
            if (a[r][i*2+1]==2&&a[r][i*2]==1&&a[r][i*2+2]==1){
                a[r-1][i*2+1]=2;
            }
        }

    }
    public void shiftRow(int r){
        for (int i = r-1; i >0; i--){
            for (int j = 0; j < 21; j++){
                a[i+1][j]=a[i][j];
                a[i][j] = 0;
            }
        }
        fixRow(r);
    }
    public void checkRow(){
        int counter = 0;
        for (int i = 1; i < 21; i++){
            counter = 0;
            for (int j = 0; j < 10; j++){
                int k = j;
                k = k*2+1;
                if (checkBlock(i,k)){
                    counter++;
                }
            }
            if (counter == 10){
                shiftRow(i);
            }
        }
    }
    public void print(int bNum){
        int v = 200;
        if (bNum==0){
            System.out.println("         _\n       _|_|_\n      |_|_|_|\n\n");
        }
        else if (bNum==1){
            System.out.println("         _\n        |_|\n        |_|\n        |_|\n        |_|\n\n");
        }
        else if (bNum==2){
            System.out.println("         _\n        |_|\n       _|_|\n      |_|_|\n\n");
        }
        else if (bNum==3){
            System.out.println("         _\n        |_|\n        |_|_\n        |_|_|\n\n");
        }
        else if (bNum==4){
            System.out.println("         _ _\n        |_|_|\n        |_|_|\n\n");
        }
        else if (bNum==5){
            System.out.println("         _ _\n       _|_|_|\n      |_|_|\n\n");
        }
        else if (bNum==6){
            System.out.println("         _ _\n        |_|_|_\n          |_|_|\n\n");
        }
        for (int i = 0;i < 21; i++){
            for (int j = 0; j < 21; j++){
                if (a[i][j]==1 || a[i][j] == 2){
                    if (i-1 <v){
                        v = i-1;
                    }
                }
            }
        }
        for (int i = v; i<21; i++){
            for (int j = 0; j < 21; j++){
                if (a[i][j]==0){
                    System.out.print(" ");
                }
                else if (a[i][j]==1){
                    System.out.print("|");
                }
                else if (a[i][j]==2){
                    System.out.print("_");
                }
            }
            System.out.println("");
        }
        System.out.println("_^_^_^_^_^_^_^_^_^_^_");
        System.out.println(" 0 1 2 3 4 5 6 7 8 9");
    }

    public void makeBlock(int r, int c){
        a[r-1][c]=2;
        a[r][c] = 2;
        a[r][c-1] = 1;
        a[r][c+1]=1;
    }
    public boolean checkBlock(int r, int c){
        if (a[r-1][c]==2&&a[r][c]==2&&a[r][c-1]==1&&a[r][c+1]==1){
            return true;
        }
        else {
            return false;
        }
    }
    public void Block(int col, int rot, int bNum){
        //0=T, 1=I, 2=J, 3=L, 4=O, 5=S, 6=Z
        boolean y=false;
        col= col*2+1;
        int row = 20;
        while(!y){
            if (bNum==0){
                if (rot==0){
                    if (!checkBlock(row,col)&&!checkBlock(row,col+2)&&!checkBlock(row,col+4)&&!checkBlock(row-1,col+2)){
                        makeBlock(row,col);
                        makeBlock(row-1,col+2);
                        makeBlock(row,col+2);
                        makeBlock(row,col+4);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
                if (rot==1){
                    if (!checkBlock(row,col)&&!checkBlock(row-1,col)&&!checkBlock(row-2,col)&&!checkBlock(row-1,col+2)){
                        makeBlock(row,col);
                        makeBlock(row-1,col);
                        makeBlock(row-2,col);
                        makeBlock(row-1,col+2);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }

                }
                if (rot==2){
                    if (!checkBlock(row-1,col)&&!checkBlock(row-1,col+2)&&!checkBlock(row,col+2)&&!checkBlock(row-1,col+4)){
                        makeBlock(row-1,col);
                        makeBlock(row-1,col+2);
                        makeBlock(row,col+2);
                        makeBlock(row-1,col+4);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
                if (rot==3){
                    if (!checkBlock(row-1,col)&&!checkBlock(row-1,col+2)&&!checkBlock(row,col+2)&&!checkBlock(row-2,col+2)){
                        makeBlock(row-1,col);
                        makeBlock(row-1,col+2);
                        makeBlock(row,col+2);
                        makeBlock(row-2,col+2);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
            }
            if (bNum==1){
                if (rot==0){
                    if (!checkBlock(row,col)&&!checkBlock(row-1,col)&&!checkBlock(row-2,col)&&!checkBlock(row-3,col)){
                        makeBlock(row,col);
                        makeBlock(row-1,col);
                        makeBlock(row-2,col);
                        makeBlock(row-3,col);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
                if (rot==1){
                    if (!checkBlock(row,col)&&!checkBlock(row,col+2)&&!checkBlock(row,col+4)&&!checkBlock(row,col+6)){
                        makeBlock(row,col);
                        makeBlock(row,col+2);
                        makeBlock(row,col+4);
                        makeBlock(row,col+6);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }

                }

            }
            if (bNum==2){
                if (rot==0){
                    if (!checkBlock(row,col)&&!checkBlock(row,col+2)&&!checkBlock(row-1,col+2)&&!checkBlock(row-2,col+2)){
                        makeBlock(row,col);
                        makeBlock(row-1,col+2);
                        makeBlock(row-2,col+2);
                        makeBlock(row,col+2);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
                if (rot==1){
                    if (!checkBlock(row,col)&&!checkBlock(row-1,col)&&!checkBlock(row,col+4)&&!checkBlock(row,col+2)){
                        makeBlock(row,col);
                        makeBlock(row-1,col);
                        makeBlock(row,col+2);
                        makeBlock(row,col+4);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }

                }
                if (rot==2){
                    if (!checkBlock(row,col)&&!checkBlock(row-1,col)&&!checkBlock(row-2,col)&&!checkBlock(row-2,col+2)){
                        makeBlock(row,col);
                        makeBlock(row-1,col);
                        makeBlock(row-2,col);
                        makeBlock(row-2,col+2);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
                if (rot==3){
                    if (!checkBlock(row-1,col)&&!checkBlock(row-1,col+2)&&!checkBlock(row-1,col+4)&&!checkBlock(row,col+4)){
                        makeBlock(row-1,col);
                        makeBlock(row-1,col+2);
                        makeBlock(row-1,col+4);
                        makeBlock(row,col+4);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
            }
            if (bNum==3){
                if (rot==0){
                    if (!checkBlock(row,col)&&!checkBlock(row-1,col)&&!checkBlock(row-2,col)&&!checkBlock(row,col+2)){
                        makeBlock(row,col);
                        makeBlock(row-1,col);
                        makeBlock(row-2,col);
                        makeBlock(row,col+2);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
                if (rot==1){
                    if (!checkBlock(row,col)&&!checkBlock(row-1,col)&&!checkBlock(row-1,col+4)&&!checkBlock(row-1,col+2)){
                        makeBlock(row,col);
                        makeBlock(row-1,col);
                        makeBlock(row-1,col+2);
                        makeBlock(row-1,col+4);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }

                }
                if (rot==2){
                    if (!checkBlock(row-2,col)&&!checkBlock(row-1,col+2)&&!checkBlock(row-2,col+2)&&!checkBlock(row,col+2)){
                        makeBlock(row,col+2);
                        makeBlock(row-1,col+2);
                        makeBlock(row-2,col);
                        makeBlock(row-2,col+2);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
                if (rot==3){
                    if (!checkBlock(row,col)&&!checkBlock(row,col+2)&&!checkBlock(row,col+4)&&!checkBlock(row-1,col+4)){
                        makeBlock(row,col);
                        makeBlock(row,col+2);
                        makeBlock(row,col+4);
                        makeBlock(row-1,col+4);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
            }
            if (bNum==4){
                if (rot==0){
                    if (!checkBlock(row,col)&&!checkBlock(row-1,col)&&!checkBlock(row,col+2)&&!checkBlock(row-1,col+2)){
                        makeBlock(row,col);
                        makeBlock(row-1,col+2);
                        makeBlock(row-1,col);
                        makeBlock(row,col+2);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
            }
            if (bNum==5){
                if (rot==0){
                    if (!checkBlock(row,col)&&!checkBlock(row,col+2)&&!checkBlock(row-1,col+2)&&!checkBlock(row-1,col+4)){
                        makeBlock(row,col);
                        makeBlock(row-1,col+2);
                        makeBlock(row-1,col+4);
                        makeBlock(row,col+2);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
                if (rot==1){
                    if (!checkBlock(row,col+2)&&!checkBlock(row-1,col+2)&&!checkBlock(row-1,col)&&!checkBlock(row-2,col)){
                        makeBlock(row,col+2);
                        makeBlock(row-1,col);
                        makeBlock(row-1,col+2);
                        makeBlock(row-2,col);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
            }
            if (bNum==6){
                if (rot==0){
                    if (!checkBlock(row-1,col)&&!checkBlock(row,col+2)&&!checkBlock(row-1,col+2)&&!checkBlock(row,col+4)){
                        makeBlock(row,col+2);
                        makeBlock(row-1,col);
                        makeBlock(row-1,col+2);
                        makeBlock(row,col+4);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
                if (rot==1){
                    if (!checkBlock(row,col)&&!checkBlock(row-1,col)&&!checkBlock(row-1,col+2)&&!checkBlock(row-2,col+2)){
                        makeBlock(row-1,col+2);
                        makeBlock(row-1,col);
                        makeBlock(row-2,col+2);
                        makeBlock(row,col);
                        y=true;
                    }
                    else{
                        row -= 1;
                    }
                }
            }
        }

    }
    public void printAr(){
        for (int i = 0; i < 21; i++){
            for (int j = 0;j < 21; j++){
                if (a[i][j] ==0){
                    System.out.print(" ");
                }
                else if (a[i][j]==1){
                    System.out.print("|");
                }
                else if (a[i][j]==2){
                    System.out.print("_");
                }

            }
            System.out.println("");
        }
    }
}