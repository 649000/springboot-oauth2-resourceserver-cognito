package com.app.warrantychecker.crnkRepository;

import com.app.warrantychecker.model.User;
import com.app.warrantychecker.repository.UserRepository;
import com.app.warrantychecker.service.UserService;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl extends ResourceRepositoryBase<User, String> {
    //Example:
    //https://github.com/crnk-project/crnk-framework/blob/master/crnk-integration-examples/spring-boot-example/src/main/java/io/crnk/example/springboot/domain/repository/TaskRepositoryImpl.java
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public <S extends User> S create(S entity) {
        if (!userService.findOne(entity.getEmail()).isPresent())
            userService.create(entity);
        return entity;
    }

    @Override
    public <S extends User> S save(S entity) {
        if (!userService.findOne(entity.getEmail()).isPresent())
            userService.create(entity);
        return entity;
    }

    @Override
    public ResourceList<User> findAll(QuerySpec querySpec) {
        return querySpec.apply(userService.findAll());
    }

    @Override
    public void delete(String email) {
        userService.delete(email);
    }
}
