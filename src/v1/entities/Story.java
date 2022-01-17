package v1.entities;

import java.util.ArrayList;
import java.util.List;

import v2.entities.RolePlayingGame;

public class Story implements Executable  {
    private RolePlayingGame game;
    private List<GameAction> actions;

    public Story(RolePlayingGame game){
        this.game = game;
        this.actions = new ArrayList<GameAction>();
    }

    public RolePlayingGame getGame(){
        return this.game;
    }

    public List<GameAction> getActions(){
        return this.actions;
    }

    public void addAction(GameAction action){
        action.setGame(game);
        this.getActions().add(action);
    }
}
