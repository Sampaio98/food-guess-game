package back;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodNode {

    private String name;
    private FoodNode foodNodeLeft;
    private FoodNode foodNodeRight;

    public FoodNode(String name) {
        this.name = name;
    }

    public FoodNode(String characteristic, String name) {
        this.name = characteristic;
        this.foodNodeRight = new FoodNode(name);
    }

}
