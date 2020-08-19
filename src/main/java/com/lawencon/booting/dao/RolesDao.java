package com.lawencon.booting.dao;

import java.util.List;

import com.lawencon.booting.model.Roles;

public interface RolesDao {

	Roles insert(Roles data)throws Exception;
	Roles update(Roles data) throws Exception;
	List<Roles> getListRoles() throws Exception;
	void deleteRoles(Long id) throws Exception;
}
