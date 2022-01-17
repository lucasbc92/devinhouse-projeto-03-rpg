package v1.entities;

import java.util.ArrayList;
import java.util.List;

import v2.entities.RolePlayingGame;

public abstract class GameAction {
    private RolePlayingGame game;
    private String description;
    private List<String> options;

    public GameAction(String description){
        this.description = description;
        this.options = new ArrayList<String>();
    }

    public GameAction(String description, List<String> options){
        this.description = description;
        this.options = options;
    }

    public void setGame(RolePlayingGame game){
        this.game = game;
    }

    public RolePlayingGame getGame(){
        return this.game;
    }

    public String getDescription(){
        return this.description;
    }

    public List<String> getOptions(){
        return this.options;
    }

    public abstract int execute();
}
