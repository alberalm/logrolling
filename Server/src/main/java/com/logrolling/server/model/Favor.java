package com.logrolling.server.model;

public class Favor {

    private int id;
    private String creator;
    private String title;
    private String description;
    private  Integer dueTime;
    private int reward;
    private Coordinates coordinates;
    private String worker;

    public Favor(int id, String creator, String title, String description, Integer dueTime, int reward, double latitude, double longitude) {
        this.id = id;
        this.creator = creator;
        this.title = title;
        this.description = description;
        this.dueTime = dueTime;
        this.reward = reward;
        this.coordinates = new Coordinates(latitude, longitude);
        this.worker = null;
    }

    public Favor(String creator, String title, String description, Integer dueTime, int reward, double latitude, double longitude) {
        this.creator = creator;
        this.title = title;
        this.description = description;
        this.dueTime = dueTime;
        this.reward = reward;
        this.coordinates = new Coordinates(latitude, longitude);
        this.worker = null;
    }

    public Favor(int id, String creator, String title, String description, Integer dueTime, int reward, double latitude, double longitude, String worker) {
        this.id = id;
        this.creator = creator;
        this.title = title;
        this.description = description;
        this.dueTime = dueTime;
        this.reward = reward;
        this.coordinates = new Coordinates(latitude, longitude);
        this.worker = worker;
    }

    public Favor(String creator, String title, String description, Integer dueTime, int reward, double latitude, double longitude, String worker) {
        this.creator = creator;
        this.title = title;
        this.description = description;
        this.dueTime = dueTime;
        this.reward = reward;
        this.coordinates = new Coordinates(latitude, longitude);
        this.worker = worker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription(){ return description; }

    public void setDescription(String description){ this.description = description; }

    public Integer getDueTime(){ return dueTime; }

    public void setDueTime(Integer dueTime){ this.dueTime = dueTime; }

    public Integer getReward(){ return reward; }

    public void setReward(int reward){ this.reward = reward; }

    public Double getLatCoord(){ return coordinates.getLatitude(); }

    public Double getLongCoord(){return coordinates.getLongitude(); }

    public Coordinates getCoordinates(){ return coordinates; }

    public void setCoordinates(double latitude, double longitude){
        coordinates.setLatitude(latitude);
        coordinates.setLongitude(longitude);
    }

    public String getWorker(){ return worker; }

    public void setWorker(String worker){ this.worker = worker; }


}