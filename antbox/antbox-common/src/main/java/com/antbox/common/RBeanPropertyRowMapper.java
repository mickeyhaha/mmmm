/*     */ package com.antbox.common;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonParseException;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.JsonMappingException;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.io.IOException;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.BeanUtils;
/*     */ import org.springframework.beans.BeanWrapper;
/*     */ import org.springframework.beans.NotWritablePropertyException;
/*     */ import org.springframework.beans.PropertyAccessorFactory;
/*     */ import org.springframework.beans.TypeMismatchException;
/*     */ import org.springframework.dao.DataRetrievalFailureException;
/*     */ import org.springframework.dao.InvalidDataAccessApiUsageException;
/*     */ import org.springframework.jdbc.core.BeanPropertyRowMapper;
/*     */ import org.springframework.jdbc.support.JdbcUtils;
/*     */ import org.springframework.util.Assert;
/*     */ import org.springframework.util.ClassUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RBeanPropertyRowMapper<T>
/*     */   extends BeanPropertyRowMapper<T>
/*     */ {
/*  44 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */   
/*     */ 
/*     */   private Class<T> mappedClass;
/*     */   
/*     */ 
/*  50 */   private boolean primitivesDefaultedForNullValue = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<String, PropertyDescriptor> mappedFields;
/*     */   
/*     */ 
/*     */ 
/*     */   private Set<String> mappedProperties;
/*     */   
/*     */ 
/*     */ 
/*     */   private ObjectMapper objectMapper;
/*     */   
/*     */ 
/*     */ 
/*     */   private Map<String, TypeReference> typeReferenceMap;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public RBeanPropertyRowMapper() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public RBeanPropertyRowMapper(Class<T> mappedClass)
/*     */   {
/*  79 */     initialize(mappedClass);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public RBeanPropertyRowMapper(Class<T> mappedClass, ObjectMapper objectMapper)
/*     */   {
/*  90 */     this.objectMapper = objectMapper;
/*  91 */     initialize(mappedClass);
/*     */   }
/*     */   
/*     */   public RBeanPropertyRowMapper(Class<T> mappedClass, ObjectMapper objectMapper, Map<String, TypeReference> typeReferenceMap) {
/*  95 */     this.objectMapper = objectMapper;
/*  96 */     this.typeReferenceMap = typeReferenceMap;
/*  97 */     initialize(mappedClass);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void initialize(Class<T> mappedClass)
/*     */   {
/* 106 */     this.mappedClass = mappedClass;
/* 107 */     this.mappedFields = new HashMap();
/* 108 */     this.mappedProperties = new HashSet();
/* 109 */     PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(mappedClass);
/* 110 */     for (PropertyDescriptor pd : pds) {
/* 111 */       if (pd.getWriteMethod() != null) {
/* 112 */         this.mappedFields.put(lowerCaseName(pd.getName()), pd);
/* 113 */         String underscoredName = underscoreName(pd.getName());
/* 114 */         if (!lowerCaseName(pd.getName()).equals(underscoredName)) {
/* 115 */           this.mappedFields.put(underscoredName, pd);
/*     */         }
/* 117 */         this.mappedProperties.add(pd.getName());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public T mapRow(ResultSet rs, int rowNumber)
/*     */     throws SQLException
/*     */   {
/* 130 */     Assert.state(this.mappedClass != null, "Mapped class was not specified");
/* 131 */     T mappedObject = BeanUtils.instantiate(this.mappedClass);
/* 132 */     BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(mappedObject);
/* 133 */     initBeanWrapper(bw);
/*     */     
/* 135 */     ResultSetMetaData rsmd = rs.getMetaData();
/* 136 */     int columnCount = rsmd.getColumnCount();
/* 137 */     Set<String> populatedProperties = isCheckFullyPopulated() ? new HashSet() : null;
/*     */     
/* 139 */     for (int index = 1; index <= columnCount; index++) {
/* 140 */       String column = JdbcUtils.lookupColumnName(rsmd, index);
/* 141 */       String field = lowerCaseName(column.replaceAll(" ", ""));
/* 142 */       PropertyDescriptor pd = (PropertyDescriptor)this.mappedFields.get(field);
/* 143 */       if (pd != null) {
/*     */         try {
/* 145 */           Object value = super.getColumnValue(rs, index, pd);
/*     */           
/*     */ 
/* 148 */           if ((rowNumber == 0) && (this.logger.isDebugEnabled())) {
/* 149 */             this.logger.debug("Mapping column '" + column + "' to property '" + pd.getName() + "' of type [" + 
/* 150 */               ClassUtils.getQualifiedName(pd.getPropertyType()) + "]");
/*     */           }
/*     */           try
/*     */           {
/* 154 */             if (((value instanceof String)) && (this.objectMapper != null) && (this.typeReferenceMap.size() > 0) && (pd.getPropertyType().getSimpleName().contains("List"))) {
/* 155 */               List list = (List)this.objectMapper.readValue(value.toString(), (TypeReference)this.typeReferenceMap.get(column));
/* 156 */               bw.setPropertyValue(pd.getName(), list);
/*     */             } else {
/* 158 */               bw.setPropertyValue(pd.getName(), value);
/*     */             }
/*     */           }
/*     */           catch (TypeMismatchException ex) {
/* 162 */             if ((value == null) && (this.primitivesDefaultedForNullValue)) {
/* 163 */               if (this.logger.isDebugEnabled()) {
/* 164 */                 this.logger.debug("Intercepted TypeMismatchException for row " + rowNumber + " and column '" + column + "' with null value when setting property '" + pd
/*     */                 
/* 166 */                   .getName() + "' of type [" + 
/* 167 */                   ClassUtils.getQualifiedName(pd.getPropertyType()) + "] on object: " + mappedObject, ex);
/*     */               }
/*     */             }
/*     */             else {
/* 171 */               throw ex;
/*     */             }
/*     */           } catch (JsonParseException e) {
/* 174 */             e.printStackTrace();
/*     */           } catch (JsonMappingException e) {
/* 176 */             e.printStackTrace();
/*     */           } catch (IOException e) {
/* 178 */             e.printStackTrace();
/*     */           }
/* 180 */           if (populatedProperties != null) {
/* 181 */             populatedProperties.add(pd.getName());
/*     */           }
/*     */         }
/*     */         catch (NotWritablePropertyException ex) {
/* 185 */           throw new DataRetrievalFailureException("Unable to map column '" + column + "' to property '" + pd.getName() + "'", ex);
/*     */         }
/*     */         
/*     */       }
/* 189 */       else if ((rowNumber == 0) && (this.logger.isDebugEnabled())) {
/* 190 */         this.logger.debug("No property found for column '" + column + "' mapped to field '" + field + "'");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 195 */     if ((populatedProperties != null) && (!populatedProperties.equals(this.mappedProperties)))
/*     */     {
/* 197 */       throw new InvalidDataAccessApiUsageException("Given ResultSet does not contain all fields necessary to populate object of class [" + this.mappedClass.getName() + "]: " + this.mappedProperties);
/*     */     }
/*     */     
/*     */ 
/* 201 */     return mappedObject;
/*     */   }
/*     */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\RBeanPropertyRowMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */