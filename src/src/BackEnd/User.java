package BackEnd;

abstract public class User implements HasID {
    protected String email;
    protected String username;
    protected String password;
    protected DateTime dateOfBirth;
    protected Gender gen;
    protected String ID;

    protected User (){

    }


    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }
    public Gender getGen() {
        return gen;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setGen(Gender gen) {
        this.gen = gen;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    abstract public String toString();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //    protected abstract void login();

}
