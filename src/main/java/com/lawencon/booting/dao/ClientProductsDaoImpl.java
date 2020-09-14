package com.lawencon.booting.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.booting.model.ClientProducts;
import com.lawencon.booting.model.Companies;
import com.lawencon.booting.model.TicketPriority;

@Repository
public class ClientProductsDaoImpl extends BaseDao implements ClientProductsDao {

	@Override
	public ClientProducts insert(ClientProducts data) throws Exception {
		em.persist(data);
		return data;
	}

	@Override
	public ClientProducts update(ClientProducts data) throws Exception {
		return em.merge(data);
	}

	@Override
	public List<ClientProducts> getListClientProducts() throws Exception {
		return em.createQuery("FROM ClientProducts", ClientProducts.class).getResultList();
	}

	@Override
	public void delete(String id) throws Exception {
		em.createQuery("DELETE from ClientProducts where id = :id").setParameter("id", id);
	}

	@Override
	public List<ClientProducts> getListByCompany(ClientProducts data) throws Exception {
		return em.createQuery("FROM ClientProducts WHERE idCompany.id = :idCompany", ClientProducts.class)
				.setParameter("idCompany", data.getIdCompany().getId()).getResultList();
	}

	@Override
	public List<String> getListIdCompany(Companies data) throws Exception {
		List<Object> listData = em
				.createQuery("SELECT idProducts.id FROM ClientProducts WHERE idCompany.id = :id", Object.class)
				.setParameter("id", data.getId()).getResultList();
		List<String> ListProducts = new ArrayList<>();
		listData.forEach(l -> {
			ListProducts.add(l.toString());
		});
		return ListProducts;
	}

	@Override
	public List<ClientProducts> getListClientProductsActive() throws Exception {
		return em.createQuery("FROM ClientProducts WHERE active = TRUE", ClientProducts.class).getResultList();
	}

	@Override
	public ClientProducts getData(TicketPriority data) throws Exception {
		return em
				.createQuery("FROM ClientProducts WHERE idProduct.id = :idP AND idCompany.id = :idC",
						ClientProducts.class)
				.setParameter("idP", data.getIdProduct()).setParameter("idC", data.getIdCompany()).getSingleResult();
	}

}
