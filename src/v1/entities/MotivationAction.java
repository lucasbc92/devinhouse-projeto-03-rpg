package v1.entities;

import java.util.List;
import java.util.Scanner;

//import entities.GameValue.GameValueEnum;

public class MotivationAction extends GameAction {
    private MotivationAction(String description){
        super(description);
    }

    public MotivationAction(String description, List<String> options){
        super(description, options);
    }

    public int execute(){
        Scanner in = new Scanner(System.in);
        System.out.println(this.getDescription());
        for(int i = 0; i < this.getOptions().size(); i++){
            System.out.printf("%d - %s", (i+1), this.getOptions().get(i));
        }
        int option = 0;
        do {
            option = in.nextInt();
            if(option <= this.getOptions().size()){
                return option;
            } else {
                System.out.println("Invalid option.");
                option = 0;
            }
        } while(option == 0);
        return 0;
    }
}
