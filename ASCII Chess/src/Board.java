public class Board {
    boolean castleWhiteRight=false;
    boolean castleWhiteLeft=false;
    boolean castleBlackLeft=false;
    boolean castleBlackRight=false;
    boolean whiteKingMoved=false;
    boolean blackKingMoved=false;
    boolean leftWhiteRookMoved=false;
    boolean rightWhiteRookMoved=false;
    boolean leftBlackRookMoved=false;
    boolean rightBlackRookMoved=false;
    int wkr = 0;
    int wkc = 0;
    int bkr = 0;
    int bkc = 0;
    String[][] b = {{"R2", "H2", "B2", "Q2", "K2", "B2", "H2", "R2"},
            {"P2", "P2", "P2", "P2", "P2", "P2", "P2", "P2"},
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
            {"P1", "P1", "P1", "P1", "P1", "P1", "P1", "P1"},
            {"R1", "H1", "B1", "Q1", "K1", "B1", "H1", "R1"}};
    //0: no checks, 1: whkte checks black, 2: black checks white, 3: white wins, 4: black wins
    public int checkForCheck(){
        int x = -1;
        int y = -1;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (b[i][j]=="K1"){
                    x=1;
                    wkr = i;
                    wkc=j;
                }
                if (b[i][j] == "K2"){
                    y=1;
                    bkr = i;
                    bkc=j;
                }
            }
        }
        if (x==-1){
            return 3;
        }
        else if (y==-1){
            return 4;
        }
        for (int r = 0; r < 8; r++){
            for (int c = 0; c < 8; c++){
                if (b[r][c].charAt(0)=='P'){
                    if (b[r][c].charAt(1)=='1'){
                        if ((bkr==r-1&&bkc==c-1)||(bkr==r-1&&bkc==c+1)){
                            return 1;
                        }
                    }
                    else if (b[r][c].charAt(1)=='2'){
                        if ((wkr==r+1&&wkc==c-1)||(wkr==r+1&&wkc==c+1)){
                            return 2;
                        }
                    }
                }
                else if (b[r][c].charAt(0)=='H'){
                    if (b[r][c].charAt(1)=='1'){
                        if ((bkr==r-2&&bkc==c-1)||(bkr==r-2&&bkc==c+1)||(bkr==r-1&&bkc==c-2)||(bkr==r-1&&bkc==c+2)||(bkr==r+1&&bkc==c-2)||(bkr==r+1&&bkc==c+2)||(bkr==r+2&&bkc==c-1)||(bkr==r+2&&bkc==c+1)){
                            return 1;
                        }
                        //if (b[r-2][c+1]=="K2"||b[r-2][c-1]=="K2"||b[r-1][c+2]=="K2"||b[r-1][c-2]=="K2"||b[r+1][c+2]=="K2"||b[r+1][c-2]=="K2"||b[r+2][c-1]=="K2"||b[r+2][c-1]=="K2"){
                        //  return 1;
                        //}
                    }
                    else if (b[r][c].charAt(1)=='2'){
                        if ((wkr==r-2&&wkc==c-1)||(wkr==r-2&&wkc==c+1)||(wkr==r-1&&wkc==c-2)||(wkr==r-1&&wkc==c+2)||(wkr==r+1&&wkc==c-2)||(wkr==r+1&&wkc==c+2)||(wkr==r+2&&wkc==c-1)||(wkr==r+2&&wkc==c+1)){
                            return 2;
                        }
                        //if (b[r-2][c+1]=="K1"||b[r-2][c-1]=="K1"||b[r-1][c+2]=="K1"||b[r-1][c-2]=="K1"||b[r+1][c+2]=="K1"||b[r+1][c-2]=="K1"||b[r+2][c-1]=="K1"||b[r+2][c-1]=="K1"){
                        //  return 2;
                        //}
                    }
                }
                else if (b[r][c].charAt(0)=='R'){
                    if (b[r][c].charAt(1)=='1'){
                        if (r==bkr){
                            if (c>bkc){
                                int d = 0;
                                for (int i = c-1; i > bkc; i--){
                                    if (b[r][i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==c-bkc-1){
                                    return 1;
                                }
                            }
                            else if (c<bkc){
                                int d = 0;
                                for (int i = c+1; i < bkc; i++){
                                    if (b[r][i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==bkc-c-1){
                                    return 1;
                                }
                            }
                        }
                        else if (c==bkc){
                            if (r>bkr){
                                int d = 0;
                                for (int i = r-1; i > bkr; i--){
                                    if (b[i][c]=="  "){
                                        d++;
                                    }
                                }
                                if (d==r-bkr-1){
                                    return 1;
                                }
                            }
                            else if (r<bkr){
                                int d = 0;
                                for (int i = c+1; i < bkr; i++){
                                    if (b[i][c]=="  "){
                                        d++;
                                    }
                                }
                                if (d==bkr-r-1){
                                    return 1;
                                }
                            }
                        }
                    }
                    else if (b[r][c].charAt(1)=='2'){
                        if (r==wkr){
                            if (c>wkc){
                                int d = 0;
                                for (int i = c-1; i > wkc; i--){
                                    if (b[r][i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==c-wkc-1){
                                    return 2;
                                }
                            }
                            else if (c<wkc){
                                int d = 0;
                                for (int i = c+1; i < wkc; i++){
                                    if (b[r][i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==wkc-c-1){
                                    return 2;
                                }
                            }
                        }
                        else if (c==wkc){
                            if (r>wkr){
                                int d = 0;
                                for (int i = r-1; i > wkr; i--){
                                    if (b[i][c]=="  "){
                                        d++;
                                    }
                                }
                                if (d==r-wkr-1){
                                    return 2;
                                }
                            }
                            else if (r<wkr){
                                int d = 0;
                                for (int i = c+1; i < wkr; i++){
                                    if (b[i][c]=="  "){
                                        d++;
                                    }
                                }
                                if (d==wkr-r-1){
                                    return 2;
                                }
                            }
                        }
                    }
                }
                else if (b[r][c].charAt(0)=='B'){
                    if (b[r][c].charAt(1)=='1'){
                        if (bkr-r==bkc-c){
                            if (c>bkc){
                                int d = 0;
                                for (int i = -1; i > bkc-c; i--){
                                    if (b[r+i][c+i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==c-bkc-1){
                                    return 1;
                                }
                            }
                            else if (c<bkc){
                                int d = 0;
                                for (int i = 1; i < bkc-c; i++){
                                    if (b[r+i][c+i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==bkc-c-1){
                                    return 1;
                                }
                            }
                        }
                        else if (bkr-r==c-bkc){
                            if (r>bkr){
                                int d = 0;
                                for (int i = -1; i > bkr-r; i--){
                                    if (b[r+i][c-i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==r-bkr-1){
                                    return 1;
                                }
                            }
                            else if (r<bkr){
                                int d = 0;
                                for (int i = 1; i < bkr-r; i++){
                                    if (b[r+i][c-i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==bkr-r-1){
                                    return 1;
                                }
                            }
                        }
                    }
                    else if (b[r][c].charAt(1)=='2'){
                        if (wkr-r==wkc-c){
                            if (c>wkc){
                                int d = 0;
                                for (int i = -1; i > wkc-c; i--){
                                    if (b[r+i][c+i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==c-wkc-1){
                                    return 2;
                                }
                            }
                            else if (c<wkc){
                                int d = 0;
                                for (int i = 1; i < wkc-c; i++){
                                    if (b[r+i][c+i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==wkc-c-1){
                                    return 2;
                                }
                            }
                        }
                        else if (wkr-r==c-wkc){
                            if (r>wkr){
                                int d = 0;
                                for (int i = -1; i > wkr-r; i--){
                                    if (b[r+i][c-i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==r-wkr-1){
                                    return 2;
                                }
                            }
                            else if (r<wkr){
                                int d = 0;
                                for (int i = 1; i < wkr-r; i++){
                                    if (b[r+i][c-i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==wkr-r-1){
                                    return 2;
                                }
                            }
                        }
                    }
                }
                else if (b[r][c].charAt(0)=='Q'){
                    if (b[r][c].charAt(1)=='1'){
                        if (r==bkr){
                            if (c>bkc){
                                int d = 0;
                                for (int i = c-1; i > bkc; i--){
                                    if (b[r][i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==c-bkc-1){
                                    return 1;
                                }
                            }
                            else if (c<bkc){
                                int d = 0;
                                for (int i = c+1; i < bkc; i++){
                                    if (b[r][i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==bkc-c-1){
                                    return 1;
                                }
                            }
                        }
                        else if (c==bkc){
                            if (r>bkr){
                                int d = 0;
                                for (int i = r-1; i > bkr; i--){
                                    if (b[i][c]=="  "){
                                        d++;
                                    }
                                }
                                if (d==r-bkr-1){
                                    return 1;
                                }
                            }
                            else if (r<bkr){
                                int d = 0;
                                for (int i = c+1; i < bkr; i++){
                                    if (b[i][c]=="  "){
                                        d++;
                                    }
                                }
                                if (d==bkr-r-1){
                                    return 1;
                                }
                            }
                        }
                        else if (bkr-r==bkc-c){
                            if (c>bkc){
                                int d = 0;
                                for (int i = -1; i > bkc-c; i--){
                                    if (b[r+i][c+i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==c-bkc-1){
                                    return 1;
                                }
                            }
                            else if (c<bkc){
                                int d = 0;
                                for (int i = 1; i < bkc-c; i++){
                                    if (b[r+i][c+i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==bkc-c-1){
                                    return 1;
                                }
                            }
                        }
                        else if (bkr-r==c-bkc){
                            if (r>bkr){
                                int d = 0;
                                for (int i = -1; i > bkr-r; i--){
                                    if (b[r+i][c-i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==r-bkr-1){
                                    return 1;
                                }
                            }
                            else if (r<bkr){
                                int d = 0;
                                for (int i = 1; i < bkr-r; i++){
                                    if (b[r+i][c-i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==bkr-r-1){
                                    return 1;
                                }
                            }
                        }
                    }
                    else if (b[r][c].charAt(1)=='2'){
                        if (r==wkr){
                            if (c>wkc){
                                int d = 0;
                                for (int i = c-1; i > wkc; i--){
                                    if (b[r][i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==c-wkc-1){
                                    return 2;
                                }
                            }
                            else if (c<wkc){
                                int d = 0;
                                for (int i = c+1; i < wkc; i++){
                                    if (b[r][i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==wkc-c-1){
                                    return 2;
                                }
                            }
                        }
                        else if (c==wkc){
                            if (r>wkr){
                                int d = 0;
                                for (int i = r-1; i > wkr; i--){
                                    if (b[i][c]=="  "){
                                        d++;
                                    }
                                }
                                if (d==r-wkr-1){
                                    return 2;
                                }
                            }
                            else if (r<wkr){
                                int d = 0;
                                for (int i = c+1; i < wkr; i++){
                                    if (b[i][c]=="  "){
                                        d++;
                                    }
                                }
                                if (d==wkr-r-1){
                                    return 2;
                                }
                            }
                        }
                        else if (wkr-r==wkc-c){
                            if (c>wkc){
                                int d = 0;
                                for (int i = -1; i > wkc-c; i--){
                                    if (b[r+i][c+i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==c-wkc-1){
                                    return 2;
                                }
                            }
                            else if (c<wkc){
                                int d = 0;
                                for (int i = 1; i < wkc-c; i++){
                                    if (b[r+i][c+i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==wkc-c-1){
                                    return 2;
                                }
                            }
                        }
                        else if (wkr-r==c-wkc){
                            if (r>wkr){
                                int d = 0;
                                for (int i = -1; i > wkr-r; i--){
                                    if (b[r+i][c-i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==r-wkr-1){
                                    return 2;
                                }
                            }
                            else if (r<wkr){
                                int d = 0;
                                for (int i = 1; i < wkr-r; i++){
                                    if (b[r+i][c-i]=="  "){
                                        d++;
                                    }
                                }
                                if (d==wkr-r-1){
                                    return 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
    public void checkRook(){
        if (b[7][0]!= "R1"){
            leftWhiteRookMoved=true;
        }
        else if (b[7][7]!="R1"){
            rightWhiteRookMoved=true;
        }
        else if (b[0][7]!="R2"){
            rightBlackRookMoved=true;
        }
        else if (b[0][0]!="R2"){
            leftBlackRookMoved=true;
        }
    }
    public void moveTo(String start, String end){
        int srow = 7-(start.charAt(1)-49);
        int scol = start.charAt(0)-97;
        int erow = 7-(end.charAt(1)-49);
        int ecol = end.charAt(0)-97;
        if (castleWhiteLeft){
            b[7][2]=b[7][4];
            b[7][3]=b[7][0];
            b[7][4]="  ";
            b[7][0]="  ";
        }
        else if (castleWhiteRight){
            b[7][6]=b[7][4];
            b[7][5]=b[7][7];
            b[7][4]="  ";
            b[7][7]="  ";
        }
        else if (castleBlackLeft){
            b[0][2]=b[0][4];
            b[0][3]=b[0][0];
            b[0][4]="  ";
            b[0][0]="  ";
        }
        else if (castleBlackRight){
            b[0][6]=b[0][4];
            b[0][5]=b[0][7];
            b[0][4]="  ";
            b[0][7]="  ";
        }
        else{
            b[erow][ecol]=b[srow][scol];
            b[srow][scol]="  ";
        }

    }

    public boolean checkMove(String start, String end, int turn){
        if (start==end){
            return false;
        }
        int srow = 7-(start.charAt(1)-49);
        int scol = start.charAt(0)-97;
        int erow = 7-(end.charAt(1)-49);
        int ecol = end.charAt(0)-97;
        if (turn!=b[srow][scol].charAt(1)-48){
            return false;
        }
        if (b[srow][scol]=="P1"){
            if (ecol==scol){
                if (erow==srow-1&&b[erow][ecol]=="  "){
                    return true;
                }
                if ((erow==srow-2&&srow==6)&&b[erow][ecol]=="  "&&b[erow+1][ecol]=="  "){
                    return true;
                }
            }
            if (((erow==srow-1&&ecol==scol+1)||(erow==srow-1&&ecol==scol-1))&&b[erow][ecol].charAt(1)=='2'){
                return true;
            }
        }
        else if (b[srow][scol]=="P2"){
            if (ecol==scol){
                if (erow==srow-1&&b[erow][ecol]=="  "){
                    return true;
                }
                if ((erow==srow+2&&srow==1)&&b[erow][ecol]=="  "&&b[erow-1][ecol]=="  "){
                    return true;
                }
            }
            if (((erow==srow+1&&ecol==scol+1)||(erow==srow+1&&ecol==scol-1))&&b[erow][ecol].charAt(1)=='1'){
                return true;
            }
        }
        else if (b[srow][scol].charAt(0)=='R'){
            if (srow==erow){
                if (scol<ecol){
                    int c = 0;
                    for (int i = scol+1; i <= ecol; i++){
                        if (b[srow][i]=="  "){
                            c++;
                        }
                    }
                    if (c==ecol-scol){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==ecol-scol-1){
                        return true;
                    }
                }
                else if (scol>ecol){
                    int c = 0;
                    for (int i = scol-1; i >= ecol; i--){
                        if (b[srow][i]=="  "){
                            c++;
                        }
                    }
                    if (c==scol-ecol){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==scol-ecol-1){
                        return true;
                    }
                }
            }
            else if (scol==ecol){
                //System.out.println(srow+" "+scol+" "+erow+" "+ecol);
                if (srow<erow){
                    int c = 0;
                    for (int i = srow+1; i <= erow; i++){
                        if (b[i][scol]=="  "){
                            c++;
                        }
                    }
                    if (c==erow-srow){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==erow-srow-1){
                        return true;
                    }
                }
                else if (srow>erow){
                    int c = 0;
                    for (int i = srow-1; i >= erow; i--){
                        if (b[i][scol]=="  "){
                            //System.out.println("hi");
                            c++;
                        }
                    }
                    if (c==srow-erow){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==srow-erow-1){
                        return true;
                    }
                }
            }
        }
        else if (b[srow][scol].charAt(0)=='H'){
            if ((erow==srow-2&&ecol==scol+1)||(erow==srow-2&&ecol==scol-1)||(erow==srow-1&&ecol==scol+2)||(erow==srow-1&&ecol==scol-2)||(erow==srow+1&&ecol==scol+2)||(erow==srow+1&&ecol==scol-2)||(erow==srow+2&&ecol==scol+1)||(erow==srow+2&&ecol==scol-1)){
                if (b[erow][ecol].charAt(1)!= b[srow][scol].charAt(1)){
                    return true;
                }
            }
        }
        else if (b[srow][scol].charAt(0)=='B'){
            if (erow-srow==ecol-scol){
                if (erow-srow>0){
                    int c = 0;
                    for (int i = 1; i <= ecol-scol; i++){
                        if (b[srow+i][scol+i]=="  "){
                            c++;
                        }
                    }
                    if (c==ecol-scol){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==ecol-scol-1){
                        return true;
                    }
                }
                else if (erow-srow<0){
                    int c = 0;
                    for (int i = -1; i >= erow-srow; i--){
                        if (b[srow+i][scol+i]=="  "){
                            c++;
                        }
                    }
                    if (c==srow-erow){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==srow-erow-1){
                        return true;
                    }
                }
            }
            else if (erow-srow==scol-ecol){
                if (erow-srow<0){
                    int c = 0;
                    for (int i = 1; i <= ecol-scol; i++){
                        if (b[srow-i][scol+i]=="  "){
                            c++;
                        }
                    }
                    if (c==ecol-scol){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==ecol-scol-1){
                        return true;
                    }
                }
                else if (erow-srow>0){
                    int c = 0;
                    for (int i = -1; i >= ecol-scol; i--){
                        if (b[srow-i][scol+i]=="  "){
                            c++;
                        }
                    }
                    if (c==erow-srow){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==erow-srow-1){
                        return true;
                    }
                }
            }
        }
        else if (b[srow][scol].charAt(0)=='Q'){
            if (srow==erow){
                if (scol<ecol){
                    int c = 0;
                    for (int i = scol+1; i <= ecol; i++){
                        if (b[srow][i]=="  "){
                            c++;
                        }
                    }
                    if (c==ecol-scol){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==ecol-scol-1){
                        return true;
                    }
                }
                else if (scol>ecol){
                    int c = 0;
                    for (int i = scol-1; i >= ecol; i--){
                        if (b[srow][i]=="  "){
                            c++;
                        }
                    }
                    if (c==scol-ecol){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==scol-ecol-1){
                        return true;
                    }
                }
            }
            else if (scol==ecol){
                //System.out.println(srow+" "+scol+" "+erow+" "+ecol);
                if (srow<erow){
                    int c = 0;
                    for (int i = srow+1; i <= erow; i++){
                        if (b[i][scol]=="  "){
                            c++;
                        }
                    }
                    if (c==erow-srow){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==erow-srow-1){
                        return true;
                    }
                }
                else if (srow>erow){
                    int c = 0;
                    for (int i = srow-1; i >= erow; i--){
                        if (b[i][scol]=="  "){
                            //System.out.println("hi");
                            c++;
                        }
                    }
                    if (c==srow-erow){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==srow-erow-1){
                        return true;
                    }
                }
            }
            else if (erow-srow==ecol-scol){
                if (erow-srow>0){
                    int c = 0;
                    for (int i = 1; i <= ecol-scol; i++){
                        if (b[srow+i][scol+i]=="  "){
                            c++;
                        }
                    }
                    if (c==ecol-scol){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==ecol-scol-1){
                        return true;
                    }
                }
                else if (erow-srow<0){
                    int c = 0;
                    for (int i = -1; i >= erow-srow; i--){
                        if (b[srow+i][scol+i]=="  "){
                            c++;
                        }
                    }
                    if (c==srow-erow){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==srow-erow-1){
                        return true;
                    }
                }
            }
            else if (erow-srow==scol-ecol){
                if (erow-srow<0){
                    int c = 0;
                    for (int i = 1; i <= ecol-scol; i++){
                        if (b[srow-i][scol+i]=="  "){
                            c++;
                        }
                    }
                    if (c==ecol-scol){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==ecol-scol-1){
                        return true;
                    }
                }
                else if (erow-srow>0){
                    int c = 0;
                    for (int i = -1; i >= ecol-scol; i--){
                        if (b[srow-i][scol+i]=="  "){
                            c++;
                        }
                    }
                    if (c==erow-srow){
                        return true;
                    }
                    if (((b[srow][scol].charAt(1)=='1'&&b[erow][ecol].charAt(1)=='2')||(b[srow][scol].charAt(1)=='2'&&b[erow][ecol].charAt(1)=='1'))&&c==erow-srow-1){
                        return true;
                    }
                }
            }
        }
        if (b[srow][scol].charAt(0)=='K'){
            if (((erow==srow||erow==srow-1||erow==srow+1)&&(ecol==scol||ecol==scol-1||ecol==scol+1))&&b[erow][ecol].charAt(1)!= b[srow][scol].charAt(1)){
                if (b[srow][scol].charAt(1)=='1'){
                    if(!whiteKingMoved){
                        whiteKingMoved=true;
                    }
                }
                else if (b[srow][scol].charAt(1)=='2'){
                    if (!blackKingMoved){
                        blackKingMoved=true;
                    }
                }
                return true;
            }
            if (b[srow][scol].charAt(1)=='1'&&erow==7&&ecol==7&&!rightWhiteRookMoved&&!whiteKingMoved&&b[7][5]=="  "&&b[7][6]=="  "){
                castleWhiteRight=true;
                return true;
            }
            if (b[srow][scol].charAt(1)=='1'&&erow==7&&ecol==0&&!leftWhiteRookMoved&&!whiteKingMoved&&b[7][1]=="  "&&b[7][2]=="  "&&b[7][3]=="  "){
                castleWhiteLeft=true;
                return true;
            }
            if (b[srow][scol].charAt(1)=='0'&&erow==0&&ecol==0&&!leftBlackRookMoved&&!blackKingMoved&&b[0][1]=="  "&&b[0][2]=="  "&&b[0][3]=="  "){
                castleBlackLeft=true;
                return true;
            }
            if (b[srow][scol].charAt(1)=='0'&&erow==0&&ecol==7&&!rightBlackRookMoved&&!blackKingMoved&&b[0][5]=="  "&&b[0][6]=="  "){
                castleBlackRight=true;
                return true;
            }
        }
        return false;

    }
    public void printBoard(){
        for (int i = 8; i > 0; i--){
            if (i==8){
                System.out.println("   __ __ __ __ __ __ __ __");
            }
            else{
                //System.out.println("  |__|__|__|__|__|__|__|__|");
            }

            System.out.print(i+" ");
            for (int j = 0; j < 8; j++){
                System.out.print("|"+b[8-i][j]);
            }
            System.out.print("|\n");
        }
        System.out.println("  |__|__|__|__|__|__|__|__|\n   a  b  c  d  e  f  g  h\n");
    }
}