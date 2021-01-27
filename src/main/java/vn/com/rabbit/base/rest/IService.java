package vn.com.rabbit.base.rest;

public interface IService<T, ID> {
	boolean delete(ID id);
}
