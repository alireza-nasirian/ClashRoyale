package model.cards;

public enum Cards {

    BARBARIANS("Barbarians"),
    ARCHERS("Archer"),
    BABY_DRAGON("Baby Dragon"),
    WIZARD("Wizard"),
    PEKA("Mini P.E.K.A"),
    GIANT("Giant"),
    VALKYRIE("Valkyrie"),
    RAGE("Rage"),
    FIREBALL("Fireball"),
    ARROWS("Arrows"),
    CANNON("Cannon"),
    INFERNO_TOWER("Inferno Tower");

    private final String name;

    Cards(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
