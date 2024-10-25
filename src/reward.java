import java.util.Objects;

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
        String stars = null;
        switch (this.rarity) {
            case 0:
                stars = "***";
                break;
            case 1:
                stars = "****";
                break;
            case 2:
                stars = "*****";
                break;
        }
        if (Objects.equals(this.weaponType, "x")) {
            return stars + " " + name + " (" + element + ")";
        }
        else {
            return stars + " " + name + " (" + weaponType + ")";
        }
    }
}