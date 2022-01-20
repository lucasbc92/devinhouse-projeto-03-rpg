import v2.entities.RolePlayingGame;
import v2.entities.GameFactory;

public class App {
    public static void main(String[] args) throws Exception {
        RolePlayingGame game = GameFactory.createGame();
        game.play();
        System.out.println("FIM DO JOGO");
    }
}
