import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class ticTac{
    static ArrayList<String>list=new ArrayList<>();
    static int count=0;
    static int opt;
    
    ticTac(){
        
       Scanner sc=new Scanner(System.in);
       System.out.println("Chose your option\n1:-Play with AI\n2:-Play with friend");
       opt=sc.nextInt();
       sc.nextLine();
       switch(opt){
        case 1:
            System.out.println("Enter first player name for X");
                list.add(sc.nextLine());
                list.add("AI");
                break;
        case 2:  
                System.out.println("Enter first player name for X");
                list.add(sc.nextLine());

                System.out.println("Enter second player name O");
                list.add(sc.nextLine());
                break;
        default:
                System.out.println("Invalid size number");
       } 
    }
    public int Aiplay(int [][]board){
        //check for winning move 
        
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0 && board[i][j] != -1) {
                    int temp = board[i][j];
                    board[i][j] = -1; // AI move
                    if (winnerCheeck(board) == -1) {
                        return -1; // AI wins
                    }
                    board[i][j] = temp; // Reset
                }
            }
        }
        //Block the oponent winner move
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0 && board[i][j] != -1) {
                    int temp = board[i][j];
                    board[i][j] = 0; // Block player's move
                    if (winnerCheeck(board) == 0) {
                        board[i][j] = -1;// Block player's win
                        return 22; 
                    }
                    board[i][j] = temp; // Reset
                }
            }
        }
        //make a random move
        Random ran=new Random();
       while (true){
        int move=ran.nextInt(9)+1;
        int row=(move-1)/3;
        int col=(move-1)%3;
        if(board[row][col]!=0&&board[row][col]!=-1){
            board[row][col]=-1;
            break;
        } 
       }
        return 22;

    } 
    public void printBoard(int board[][]){
        for (int i = 0; i < board.length; i++) {
            System.out.println("|-----------|");
             for (int j = 0; j < board[0].length; j++) {
                switch (board[i][j]) {
                    case 0:
                        System.out.print("| X ");
                        break;
                    case -1:
                        System.out.print("| O ");
                        break;
                    default:
                        System.out.print("| "+board[i][j]+" ");
                        break;
                } 
        }
        System.out.println("|");
        }
    }
    public void change(int[][]board,int turn ,int position ){
        
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if(turn==-1&&board[i][j]==position){
                        board[i][j]=0;
                        break;
                    }
                    else if(turn==0&&board[i][j]==position){
                        board[i][j]=-1;
    break;
                    }                   
                }
            }        
    }
    public int winnerCheeck(int[][]board){
        //check for row and colume
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j < board[0].length-2; j++) {
        if(board[i][j]==board[i][j+1]&&board[i][j+2]==board[i][j+1]){
            return board[i][j];

        }
        else if(board[j][i]==board[j+1][i]&&board[j+2][i]==board[j+1][i]){
            return board[i][j];
                    }
            }
        }
        //check for digonal
               if(board[0][0]==board[1][1]&&board[2][2]==board[1][1])
            return board[0][0];
           
        //check for digonal
        if(board[0][2]==board[1][1]&&board[2][0]==board[1][1])
            return board[0][2];
count++;       
        return 22;
    }
    public static void main(String []ard){
        int turn=0,winner=22,position;
        //object for scanner calles
        Scanner sc=new Scanner(System.in);
        //declearing the 2d array for boad 
        int [][]board={{1,2,3},{4,5,6},{7,8,9}};
        //creat object for class 
        ticTac obj=new ticTac();
        //boarde print function call
        obj.printBoard(board);
        //loop until winner are not decided 
        while(winner==22){
        if(turn==0){
            System.out.println(list.get(0)+" for X enter your postition");
            turn=-1;
        }
        else{
            if(opt==1){
                //AI play automatically
                System.out.println(list.get(1)+" for O enter your position");
                winner=obj.Aiplay(board);
                turn=0;
            }else{      System.out.println(list.get(1)+" for O enter your position");
            turn=0;
            }        }
        while(turn==-1||opt!=1){
            try {               
                position=sc.nextInt();
                int row=(position-1)/3;
                int col=(position-1)%3;
                if(position>=1&&position<=9&&(board[row][col]!=0&&board[row][col]!=-1)) {
                obj.change(board,turn,position);            
                    break;
                }else 
                System.out.println("invalid input or alredy fill: enter once again"); 
            } catch (Exception e) {
                System.out.println("invalid input:enter once again");
            }       
        }        
        obj.printBoard(board);
        winner=obj.winnerCheeck(board);
        if(count>=9&&opt!=1){
            System.out.println("match is draw");
            break;
        }
        }
        //display for winner
        if(winner==0){
            System.out.println("X is a winner");
        }
        else if (winner==-1){
            System.out.println("O is a winner");
        }        
    }
}
