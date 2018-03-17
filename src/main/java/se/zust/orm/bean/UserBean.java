package se.zust.orm.bean;

public class UserBean {

    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String avatar;

    private String joinTime;
    public UserBean(Integer id,String username,String password,String nickname,String avatar,String joinTime){
        this.id=id;
        this.username=username;
        this.password=password;
        this.nickname=nickname;
        this.avatar=avatar;
        this.joinTime=joinTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

}
