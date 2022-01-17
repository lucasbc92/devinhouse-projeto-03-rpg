package v1.entities;

public class RolePlayingGame {
    private DifficultyLevel difficultyLevel;
    private PlayableCharacter character;

    public RolePlayingGame(DifficultyLevel difficultyLevel, PlayableCharacter character){
        this.difficultyLevel = difficultyLevel;
        this.character = character;
    }

    public DifficultyLevel getDifficultyLevel(){
        return this.difficultyLevel;
    }

    public PlayableCharacter getCharacter(){
        return this.character;
    }
}
