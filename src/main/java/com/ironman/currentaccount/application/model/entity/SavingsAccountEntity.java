package com.ironman.currentaccount.application.model.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@MongoEntity(collection = "savingsAccountFacility")
public class SavingsAccountEntity {

  @BsonId private ObjectId id;
  private CustomerReferenceEntity customerReference;
  private String accountType;
  private AccountDetailEntity accountDetail;
}
