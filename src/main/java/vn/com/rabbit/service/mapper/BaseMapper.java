package vn.com.rabbit.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class BaseMapper<T, D> {

	public List<D> entitysToDTOs(List<T> entities) {
		return entities.stream().filter(Objects::nonNull).map(this::entityToDTO).collect(Collectors.toList());
	}

	public List<T> dtosToEntitys(List<D> dtos) {
		return dtos.stream().filter(Objects::nonNull).map(this::dtoToEntity).collect(Collectors.toList());
	}

	public abstract D entityToDTO(T entity);

	public abstract T dtoToEntity(D dto);

}
