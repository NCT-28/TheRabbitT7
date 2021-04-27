package vn.com.rabbit.service.bases;

import java.util.Optional;
import java.util.UUID;

import vn.com.rabbit.service.dto.response.ResponseMess;

public abstract interface BaseService <T, D> {
	
	abstract void saveAndUpdate(D dto);

	abstract ResponseMess<T> getAllTs(Integer pageNo, Integer pageSize, String name, String sortType,
			String sortBy);

	abstract Optional<T> getOneTById(UUID id);

	abstract void delete(UUID id);
}
