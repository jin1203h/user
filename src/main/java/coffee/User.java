package coffee;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="User_table")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String status;

    @PostPersist
    public void onPostPersist(){
        UserRegisted userRegisted = new UserRegisted();
        BeanUtils.copyProperties(this, userRegisted);
        userRegisted.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        UserUpdate userUpdate = new UserUpdate();
        BeanUtils.copyProperties(this, userUpdate);
        userUpdate.publishAfterCommit();


    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
