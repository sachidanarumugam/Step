/**
 * Week 7 · S7 assignment · Problem 1 The Health Bar
 *
 * Health is private. Damage floors at 0. Healing caps at maxHealth, which is final.
 */
public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("takeDamage(30) -> health = " + c.getHealth());
        c.heal(50);
        System.out.println("heal(50) -> health = " + c.getHealth() + " (capped)");
        c.takeDamage(150);
        System.out.println("takeDamage(150) -> health = " + c.getHealth() + " (floored)");
        if (c.getHealth() != 0) {
            throw new AssertionError("Health floor failed");
        }
        System.out.println("Sample checks passed.");
    }
}
