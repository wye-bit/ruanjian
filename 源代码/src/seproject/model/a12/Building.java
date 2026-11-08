package seproject.model.a12;

import java.util.ArrayList;
import java.util.List;

/** A1-2 学院办学所用的建筑，可脱离学院独立存在，因此与 College 是聚合关系。 */
public class Building {

    private String name;
    private int floors;
    private final List<String> rooms = new ArrayList<>();

    public Building(String name, int floors) {
        this.name = name;
        this.floors = floors;
    }

    public String getName() {
        return name;
    }

    public int getFloors() {
        return floors;
    }

    public List<String> getRooms() {
        return rooms;
    }

    public void addRoom(String room) {
        rooms.add(room);
    }

    @Override
    public String toString() {
        return "Building{" + name + "}";
    }
}
