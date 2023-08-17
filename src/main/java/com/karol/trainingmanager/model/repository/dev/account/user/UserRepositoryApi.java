package com.karol.trainingmanager.model.repository.dev.account.user;

import com.karol.trainingmanager.model.entities.account.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoryApi extends JpaRepository <User, Long> {
}
