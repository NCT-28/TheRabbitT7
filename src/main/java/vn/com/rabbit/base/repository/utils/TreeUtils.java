package vn.com.rabbit.base.repository.utils;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.experimental.UtilityClass;
import vn.com.rabbit.base.dtos.jpa.BaseEntityDTO;
import vn.com.rabbit.base.dtos.jpa.ParentDTO;

@UtilityClass
public class TreeUtils {
	/**
     * @param list danh sách chưa mãng dạng cây
     * @param <T>  DTO chứa param
     * @return danh sách hiển thị dạng cây
     */
    public <T extends BaseEntityDTO & ParentDTO<UUID>> List<T> generateTree(List<T> list) {
        if (list != null) {
            List<T> roots = list.stream().filter(x -> x.getIDParent() == null).collect(Collectors.toList());
            getAllListTree(roots, list);
            return roots;
        }
        return null;
    }

    private <T extends BaseEntityDTO & ParentDTO<UUID>> void getAllListTree(Collection<T> roots, List<T> list) {
        roots.forEach(x -> {
            x.setChildren(findAllChildren(list, x.getUuid()));
            if (x.getChildren() != null) {
                getAllListTree(x.getChildren(), list);
            }
        });
    }

    private <T extends BaseEntityDTO & ParentDTO<UUID>> List<T> findAllChildren(Collection<T> collection, UUID uuid) {
        return collection.stream().filter(x -> uuid.equals(x.getIDParent())).collect(Collectors.toList());
    }
}
