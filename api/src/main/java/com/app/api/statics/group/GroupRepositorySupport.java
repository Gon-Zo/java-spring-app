package com.app.api.statics.group;

public interface GroupRepositorySupport {
    Group findBy(GroupDto.Param param);
    void updateOf(GroupDto.Param param);
}
