package com.antbox.common;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public abstract interface BaseRepository<T, ID extends Serializable>
  extends JpaRepository<T, ID>
{
  @Transactional
  public abstract void softDelete(T paramT);
  
  @Transactional
  public abstract void softDelete(ID paramID);
  
  @Transactional
  public abstract void softDelete(Iterable<? extends T> paramIterable);
  
  @Transactional
  public abstract void softDeleteInBatch(Iterable<T> paramIterable);
}


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\BaseRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */