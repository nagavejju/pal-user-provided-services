package io.pivotal.pal.paluserprovidedservices;


public class Cohort {

    private long id;
    private String name;
    private String nickname;

    public Cohort(){

    }
    public Cohort(String name){

        this.name = name;
    }

    public Cohort(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public Cohort(long id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
