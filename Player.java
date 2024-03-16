/**
 * The Player class represents a player in the adventure game. 
 * It stores information about the player, including their name 
 * and their current location within the game.
 */
public class Player 
{
    private String name;
    private Room currentRoom;
    
    public Player(String name) {
        this.name = name;
    }
    
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public String getName() {
        return name;
    }
}

