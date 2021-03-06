package com.saintdan.framework.repo;

import com.saintdan.framework.enums.ValidFlag;
import com.saintdan.framework.po.Group;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Group's repository.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 10/16/15
 * @since JDK1.8
 */
public interface GroupRepository extends RepositoryWithoutDelete<Group, Long> {

  Optional<Group> findByName(String name);

  List<Group> findAllByValidFlag(ValidFlag validFlag);

  Page<Group> findAllByValidFlag(Pageable pageable, ValidFlag validFlag);

  @Modifying
  @Query("update Group g set g.validFlag=?1 where g.id=?2")
  void updateValidFlagFor(ValidFlag validFlag, Long id);
}
