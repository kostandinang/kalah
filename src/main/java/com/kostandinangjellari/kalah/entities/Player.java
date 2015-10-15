package com.kostandinangjellari.kalah.entities;

public class Player {

    private String name;
    private short id;

    public Player(String name, short id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        Player otherPlayer = (Player) obj;
        return (this.id == otherPlayer.getId());
    }
}
