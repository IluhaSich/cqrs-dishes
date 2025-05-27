package org.example.command.command;

import java.util.UUID;

public class ChangeOrderStatusCommand implements Command{
    private final String commandId;
    private final String id;

    public ChangeOrderStatusCommand(String id) {
        this.commandId = UUID.randomUUID().toString();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getCommandId() {
        return commandId;
    }
}
