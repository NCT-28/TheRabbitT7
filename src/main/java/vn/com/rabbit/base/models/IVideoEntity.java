package vn.com.rabbit.base.models;

import vn.com.rabbit.base.enums.ProviderVideo;

public interface IVideoEntity<T> extends IBaseEntity<T> {

    String getVideo();

    void setVideo(String video);

    ProviderVideo getProviderVideo();

    void setProviderVideo(ProviderVideo providerVideo);

    String getDescription();

    void setDescription(String description);
}