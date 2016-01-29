package com.herokuapp.lrjq.dao;

import java.util.HashMap;
import java.util.Map;

import com.herokuapp.lrjq.beans.Usuario;

public class UsuarioMockDAOImpl implements GenericDAO<Usuario> {
	
	private Map<Long, Usuario> lista = new HashMap<Long, Usuario>();
		
	@Override
	public Usuario src(long id) {
		return lista.get(id);
	}

	@Override
	public Usuario inc(Usuario bean) {
		if(null!=bean){
			Long id = new Long(lista.size() + 1);
			bean.setId(id);
			lista.put(id, bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean del(Usuario bean) {
		if(null!=bean){
			lista.remove(bean);
			return true;
		}
		return false;
	}

	@Override
	public Usuario upd(Usuario bean) {
		if(null!=bean){
			Usuario usuario = this.src(bean.getId());
			if(null!=usuario){
				this.del(usuario);
				lista.put(bean.getId(), bean);
			}
		}
		return null;
	}

		

}
