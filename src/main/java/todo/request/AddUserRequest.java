package todo.request;

public class AddUserRequest {

    private String name;

    public AddUserRequest() {
    }

    public AddUserRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
