package com.cathle.spring_boot_todo_application.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;



@Table(name ="todo_item")

@Getter
@Setter
@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @NotBlank(message="Description is required")
    private String description;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private Instant createdDate;

    @Getter
    @Setter
    private Instant modifiedDate;

    public TodoItem(){

    }

    public TodoItem(String description){
        this.description=description;
        this.complete=false;
        this.createdDate= Instant.now();
        this.modifiedDate=Instant.now();
    }

   @Override
    public String toString() {
       return String.format("TodoItem{id=%d, description='%s', complete='%s', createdDate='%s', modifiedDate='%s'}", id, description, complete, createdDate, modifiedDate);
   }

    public void setId(long id) {
        this.id = id;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }
}
