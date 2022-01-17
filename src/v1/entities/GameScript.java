package v1.entities;

import java.util.ArrayList;
import java.util.List;

import v2.entities.RolePlayingGame;

public class GameScript {
    private RolePlayingGame game;
    private List<Story> stories;

    public GameScript(RolePlayingGame game){
        this.game = game;
        this.stories = new ArrayList<Story>();
    }

    public RolePlayingGame getGame(){
        return this.game;
    }

    public List<Story> getStories(){
        return this.stories;
    }

    public void addStory(){
        this.getStories().add(new Story(this.getGame()));
    }

}
