package com.app.api.statics.group;

import java.util.List;

public interface GroupService {
    List<Group> getList();

    void saveOf(Group group);

    void modifyOf(GroupDto.Param param);
}
