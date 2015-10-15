package com.kostandinangjellari.kalah.entities;

public class Player {

    private String name;
    private long id;

    public Player(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        Player otherPlayer = (Player) obj;
        return (this.id == otherPlayer.getId());
    }
}
