public class Main {
    public static void main(String[] args){
        Game game = new Game();
        game.initBoard(100);
        game.initPlayers("Primul","Al doilea",game.getBoard());
        game.start();
    }
}
