public interface SpaceShip {
    boolean launch();
    boolean land();
    boolean canCarry(Cargo newCargo);
    void carry(Cargo newCargo);
}
