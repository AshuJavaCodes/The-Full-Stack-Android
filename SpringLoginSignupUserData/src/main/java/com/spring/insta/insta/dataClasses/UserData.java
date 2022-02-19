package com.spring.insta.insta.dataClasses;


import javax.persistence.*;

@Entity
@Table
public class UserData {

    @Id
    @SequenceGenerator(name = "userdata_sequence", sequenceName = "userdata_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userdata_sequence")



    private Long id;
    @Column(unique = true)
    private String userName;
    private String name;
    private String email;
    private String password;
    private String bio;
    private String profilePic;
    private int followers;
    private int following;
    private int posts;


    public UserData(){

    }

    public UserData(Long id, String userName, String name, String email, String password,String bio, String profilePic, int followers, int following, int posts) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.password=password;
        this.profilePic = profilePic;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
    }

    public UserData(String userName, String name, String email, String bio, String password,String profilePic, int followers, int following, int posts) {
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.password = password;

        this.profilePic = profilePic;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }
}
