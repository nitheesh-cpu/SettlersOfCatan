package game.catan.simulation.structures;

import game.catan.simulation.engine.Location;
import game.catan.simulation.engine.Player;
import javafx.scene.image.ImageView;

public class Structure {

    private Location location;
    private Player owner;
    private ImageView image;
    private StructureType type;

    public Structure(Location location, ImageView image) {
        this(null, location, image);
    }

    public Structure(Player owner, Location location, ImageView image) {
        this.owner = owner;
        this.type = StructureType.SETTLEMENT;
        this.location = location;
        this.image = image;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public StructureType getType() {
        return type;
    }

    public void setType(StructureType type) {
        this.type = type;
    }

    public enum StructureType{
        SETTLEMENT,
        CITY;
    }
}
