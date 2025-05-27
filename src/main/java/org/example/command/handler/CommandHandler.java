package org.example.command.handler;

import org.example.command.command.Command;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}