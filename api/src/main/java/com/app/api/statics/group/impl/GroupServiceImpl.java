package com.app.api.statics.group.impl;

import com.app.api.statics.group.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;
    private final GroupRepositorySupport groupRepositorySupport;


    public GroupServiceImpl(GroupRepository repository, GroupRepositorySupport groupRepositorySupport) {
        this.repository = repository;
        this.groupRepositorySupport = groupRepositorySupport;
    }

    @Override
    public List<Group> getList() {
        return repository.findAll();
    }


    /**
     * @param group
     */
    @Override
    public void saveOf(Group group) {
        repository.save(group);
    }

    /**
     * @param param
     */
    @Override
    public void modifyOf(GroupDto.Param param) {
        groupRepositorySupport.updateOf(param);
    }

}
