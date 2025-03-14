package model;

public final class User {
    private String username;
    private String password;
    private String email;
    private int userId;

    public void setUserId(final int userId){
       this. userId = userId;
    }
    public int getUserId(){
       return userId;
    }
    public void setUsername( final String username){
        this.username = username;
    }
    public void setPassword( final String password){
        this.password = password;
    }
    public void setEmail( final String email){
        this.email = email;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){return password;}
    public String getEmail(){return email;}

    public String toString(){
       return String.format("user id: %d \n user name: %s \n user email %s ",
                getUserId(), getUsername(), getEmail());
    }
}