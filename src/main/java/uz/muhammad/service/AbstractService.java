package uz.muhammad.service;

public abstract class AbstractService<T> {
    protected final T dao;

    public AbstractService(T dao) {
        this.dao = dao;
    }
}
