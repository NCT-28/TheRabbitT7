package vn.com.rabbit.base.service;


import java.util.UUID;

import vn.com.rabbit.base.entity.NaturalIdEntity;
import vn.com.rabbit.base.repository.BaseRepository;
import vn.com.rabbit.base.utils.RandomStringUtils;

public abstract class CodeImplService<T extends NaturalIdEntity> extends BaseImplService<T> {
    protected CodeImplService(BaseRepository<T, UUID> repo) {
        super(repo);
    }

    public String getCode() {
        String code = RandomStringUtils.randomAlphaNumeric(16);
        T val = getRepository().findByName("code",code);
        if(val != null){
            code = getCode();
        }
        return code;
    }
}