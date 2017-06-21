package com.water.entity;

import com.water.utils.LogUtils;
import org.springframework.stereotype.Component;

import javax.persistence.*;


/**
 * Created by Water on 17/4/14.
 * Email:water471871679@gmail.com
 */
@Component("user")
@Entity
public class User {
    private static final String TAG = User.class.getSimpleName();
    //    private static Logger logger = LogManager.getLogger(User.class);
    private String uid;
    private String name;
    private String email;
    private String phone;
    private String sex;
    private int state;
	/**
	 * username : 123
	 * password : 321
	 */

	private String username;
	private String password;
	/**
	 * age : 1
	 * id : 1
	 */

	private int age;
	private int id;

	public User() {
        System.out.println("无参构造方法创建User");
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    public void init() {
        LogUtils.info("初始化方法");
    }
    public void destory(){
        LogUtils.info("销毁方法");
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", state=" + state +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
