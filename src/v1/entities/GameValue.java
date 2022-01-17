package v1.entities;

import java.util.EnumSet;
import java.util.Set;

//idea taken from: https://stackoverflow.com/a/7297532

public final class GameValue {

    public static enum GameValueType {
        MOTIVATION,
        DECISION,
        VOID;
    }

    public static enum GameValueEnum {
        VENGEANCE(GameValueType.MOTIVATION),
        GLORY(GameValueType.MOTIVATION),
        GIVE_UP(GameValueType.DECISION),
        PROCEED(GameValueType.DECISION),
        JUMPING(GameValueType.DECISION),
        WALKING(GameValueType.DECISION),
        RUNNING(GameValueType.DECISION),
        RIGHT_DOOR(GameValueType.DECISION),
        LEFT_DOOR(GameValueType.DECISION),
        VOID(GameValueType.VOID);
        public static Set<GameValueEnum> motivations = EnumSet.of(VENGEANCE, GLORY);
        public static Set<GameValueEnum> decisions = EnumSet.range(GIVE_UP, LEFT_DOOR);

        private GameValueType type;

        private GameValueEnum(GameValueType type){
            this.type = type;
        }

        public GameValueType getType(){
            return this.type;
        }
    }

}
