package com.example.traveltourney;

class Player {

    String name;
    int ID;

    Player(String name){
        this.name = name;
//        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getID() {
//        return ID;
//    }

//    public void setID(int ID) {
//        this.ID = ID;
//    }

    public String toString(){
        return name + " " + ID;
    }
}
