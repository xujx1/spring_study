package pojo;


import org.springframework.context.annotation.PropertySource;

import java.util.List;

@PropertySource(value = "classpath:application.properties")
public class User {

    private String userName;

    private String age;

    private List<String> QQ;

    public User(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getQQ() {
        return QQ;
    }

    public void setQQ(List<String> QQ) {
        this.QQ = QQ;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", QQ=" + QQ +
                '}';
    }
}
