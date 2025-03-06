package model;

public final class User {
    private String username;
    private String password;
    private String email;
    private int userId;

   public final void setUserId(final int userId){
       this. userId = userId;
    }
   public final  int getUserId(){
       return userId;
    }
    public final void setUsername( final String username){
        this.username = username;
    }
    public final void setPassword( final String password){
        this.password = password;
    }
    public final void setEmail( final String email){
        this.email = email;
    }
    public final String getUsername(){
        return username;
    }
    public final String getPassword(){return password;}
    public final String getEmail(){return email;}

    public final String toString(){
       return String.format("user id: %d \n user name: %s \n user email %s ",
                getUserId(), getUsername(), getEmail());
    }
}