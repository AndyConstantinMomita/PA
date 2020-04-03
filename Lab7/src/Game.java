import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;

    public Game(){}

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void initBoard(int number){
        this.board = new Board();
        List<Token> tokens = new ArrayList<>();
        for(int i=0; i<=number; i++){
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
        this.board.setTokens(tokens);
    }

    public void initPlayers(String name1, String name2, Board board){
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);

        this.player1.setBoard(board);
        this.player2.setBoard(board);
    }

    public void start(){
        synchronized (board) {
            Thread player1Thread = new Thread();
            Thread player2Thread = new Thread();

            player1Thread.start();
            player2Thread.start();
        }
    }

}
