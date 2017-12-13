/*    */ package com.antbox.common;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ import java.util.Iterator;
/*    */ import javax.persistence.EntityManager;
/*    */ import org.springframework.dao.EmptyResultDataAccessException;
/*    */ import org.springframework.data.jpa.repository.support.JpaEntityInformation;
/*    */ import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ import org.springframework.util.Assert;
/*    */ 
/*    */ public class BaseRepositoryImpl<T, ID extends Serializable>
/*    */   extends SimpleJpaRepository<T, ID>
/*    */   implements BaseRepository<T, ID>
/*    */ {
/*    */   private static final String ID_MUST_NOT_BE_NULL = "The given id must not be null!";
/*    */   private final EntityManager em;
/*    */   private final JpaEntityInformation<T, ID> entityInformation;
/*    */   
/*    */   public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager)
/*    */   {
/* 23 */     super(entityInformation, entityManager);
/* 24 */     this.em = entityManager;
/* 25 */     this.entityInformation = entityInformation;
/*    */   }
/*    */   
/*    */   public <S extends T> S save(S entity)
/*    */   {
/*    */     try {
/* 31 */       Date now = new Date();
/* 32 */       if (this.entityInformation.isNew(entity)) {
/* 33 */         if (((BaseEntity)entity).getCreatedAt() == null) {
/* 34 */           ((BaseEntity)entity).setCreatedAt(Long.valueOf(now.getTime()));
/*    */         }
/* 36 */         if (((BaseEntity)entity).getUpdatedAt() == null) {
/* 37 */           ((BaseEntity)entity).setUpdatedAt(Long.valueOf(now.getTime()));
/*    */         }
/* 39 */         this.em.persist(entity);
/* 40 */         return entity;
/*    */       }
/* 42 */       ((BaseEntity)entity).setUpdatedAt(Long.valueOf(now.getTime()));
/* 43 */       return (S)this.em.merge(entity);
/*    */     }
/*    */     catch (Exception e) {
/* 46 */       e.printStackTrace();
/*    */     }
/* 48 */     return null;
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public void softDelete(T entity) {
/* 53 */     Assert.notNull(entity, "The entity must not be null!");
/* 54 */     ((BaseEntity)entity).setDeleted(Boolean.valueOf(true));
/* 55 */     this.em.merge(entity);
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public void softDelete(ID id)
/*    */   {
/* 61 */     Assert.notNull(id, "The given id must not be null!");
/*    */     
/* 63 */     T entity = findOne(id);
/*    */     
/* 65 */     if (entity == null) {
/* 66 */       throw new EmptyResultDataAccessException(String.format("No %s entity with id %s exists!", new Object[] { this.entityInformation.getJavaType(), id }), 1);
/*    */     }
/*    */     
/* 69 */     softDelete(entity);
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public void softDelete(Iterable<? extends T> entities)
/*    */   {
/* 75 */     Assert.notNull(entities, "The given Iterable of entities not be null!");
/*    */     
/* 77 */     for (T entity : entities) {
/* 78 */       softDelete(entity);
/*    */     }
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public void softDeleteInBatch(Iterable<T> entities)
/*    */   {
/* 85 */     Assert.notNull(entities, "The given Iterable of entities not be null!");
/*    */     
/* 87 */     if (!entities.iterator().hasNext()) {
/* 88 */       return;
/*    */     }
/*    */     
/* 91 */     for (T entity : entities) {
/* 92 */       softDelete(entity);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\BaseRepositoryImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */