package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@Repository   //JpaRepository를 상속하는 경우에는 자동으롤 Repository Bean 속성을 가진다
public interface BlockRepository extends JpaRepository<Block, Long> {
}
