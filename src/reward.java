class Reward {
    int rarity;
    String name;
    String weaponType;
    String element;

    public Reward(int rarity, String name, String weaponType, String element) {
        this.rarity = rarity;
        this.name = name;
        this.weaponType = weaponType;
        this.element = element;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Weapon Type: " + weaponType + ", Element: " + element + ", Rarity: " + rarity;
    }
}