package com.herokuapp.lrjq.dao;

public interface GenericDAO<T> {
	
	public T src(long id);
	
	public T inc(T bean);
	
	public boolean del(T bean);
	
	public T upd(T bean);

}
