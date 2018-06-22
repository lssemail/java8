package mdpe.model;

/**
 * Created by Administrator on 2018/6/22.
 */
public class UserDTO {

    private Long id;

    private String nickname;

    private String honor;

    private String email;

    private String avatar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", honor='" + honor + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
