package river.rollforinitiative.common.stat;


import net.minecraft.nbt.CompoundTag;

public class CharacterStats {

    private String Id;
    private String Name;
    private int HP;
    private int MAX_HP;
    private int AC;
    private int INIT;

    public CharacterStats(String id, String name, int maxHp, int hp, int ac, int init) {
        this.Id = id;
        this.Name = name;
        this.MAX_HP = maxHp;
        this.HP = hp;
        this.AC = ac;
        this.INIT = init;

    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static CompoundTag serialize(CharacterStats stats) {
        CompoundTag tag = new CompoundTag();
        tag.putString("character_name", stats.getName());
        tag.putInt("hp", stats.getHP());
        tag.putInt("maxHp", stats.getMAX_HP());
        tag.putInt("ac", stats.getAC());
        tag.putInt("init", stats.getINIT());

        return tag;
    }

    public static CharacterStats deserialize(CompoundTag tag) {
        String id = tag.getString("id");
        String name = tag.getString("character_name");
        int hp = tag.getInt("hp");
        int maxHp = tag.getInt("maxHp");
        int ac = tag.getInt("ac");
        int init = tag.getInt("init");
        return new CharacterStats(id, name, maxHp, hp, ac, init);
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public int getINIT() {
        return INIT;
    }

    public void setINIT(int INIT) {
        this.INIT = INIT;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public void setMAX_HP(int MAX_HP) {
        this.MAX_HP = MAX_HP;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
