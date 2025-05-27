package org.example.command.repository;

public interface Repository<T> {
    public void save(T t);
    public T findById(String id);
}
