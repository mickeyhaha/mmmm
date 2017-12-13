/*    */ package com.antbox.common;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.EntityManager;
/*    */ import org.springframework.data.jpa.repository.JpaRepository;
/*    */ import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
/*    */ import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
/*    */ import org.springframework.data.repository.core.RepositoryInformation;
/*    */ import org.springframework.data.repository.core.RepositoryMetadata;
/*    */ import org.springframework.data.repository.core.support.RepositoryFactorySupport;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BaseRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
/*    */   extends JpaRepositoryFactoryBean<R, T, I>
/*    */ {
/*    */   public BaseRepositoryFactoryBean(Class<? extends R> repositoryInterface)
/*    */   {
/* 28 */     super(repositoryInterface);
/*    */   }
/*    */   
/*    */   protected RepositoryFactorySupport createRepositoryFactory(EntityManager em)
/*    */   {
/* 33 */     return new BaseRepositoryFactory(em);
/*    */   }
/*    */   
/*    */   private static class BaseRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory
/*    */   {
/*    */     private final EntityManager em;
/*    */     
/*    */     public BaseRepositoryFactory(EntityManager em)
/*    */     {
/* 42 */       super();
/* 43 */       this.em = em;
/*    */     }
/*    */     
/*    */     protected Object getTargetRepository(RepositoryInformation information)
/*    */     {
/* 48 */       return super.getTargetRepository(information);
/*    */     }
/*    */     
/*    */     protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata)
/*    */     {
/* 53 */       return BaseRepositoryImpl.class;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\BaseRepositoryFactoryBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */