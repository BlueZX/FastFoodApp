package cl.bluez.fastfoodapp.model;

import java.io.Serializable;

public class Sandwich implements Serializable {
    private String name;
    private String description;
    private int image;
    private int cost;

    public Sandwich(){

    }

    public Sandwich(String name, String description, int cost, int image){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
