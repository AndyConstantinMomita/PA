import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {

    private String name;
    private List<Token> playersTokens= new ArrayList<>();
    private Board board;

    public Player(){}

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String tokensList(){
        String tokens = "";
        for(Token token : playersTokens) {
            tokens += token.getValue()+" ";
        }
        return tokens;
    }

    @Override
    public void run() {

        while (!(board.getTokens().isEmpty())){
            this.playersTokens.add(board.getTokens().get(0));
            System.out.println(getName() + board.getTokens().get(0));
            board.removeToken(0);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", playersTokens=" + tokensList() +
                '}';
    }
}
