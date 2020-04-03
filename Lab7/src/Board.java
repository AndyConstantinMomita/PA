import java.util.List;

public class Board {
    private List<Token> tokens;

    public  Board(){}

    public Board(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void removeToken(int index){
        tokens.remove(index);
    }

}
