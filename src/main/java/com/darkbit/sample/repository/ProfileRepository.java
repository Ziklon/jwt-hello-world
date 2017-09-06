package com.darkbit.sample.repository;

import com.darkbit.sample.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProfileRepository extends JpaRepository<Profile,Long>, JpaSpecificationExecutor<Profile>{

}
