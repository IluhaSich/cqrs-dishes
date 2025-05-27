package org.example.command.command;

public class ChangeOrderStatusCommand implements Command{
    private final String id;

    public ChangeOrderStatusCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
