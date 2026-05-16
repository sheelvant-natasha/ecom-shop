package com.project.simpleshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description; 
    private Double price;
    private String brand;
    private String category; 
    private Integer quantity;
    private LocalDate releaseDate;
    private boolean available;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;


}
