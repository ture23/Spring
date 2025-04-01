package icu.investforyou.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String sticker;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = false)
    private String address;

    private String selectedFile;

    @Column(nullable = false)
    private String descriptionFull;

    @Column(nullable = false)
    private String descriptionSmall;

    private Long bothPrice;

    @Column(nullable = false)
    private Long currentPrice;

    private String creator;

    private Long myValuePrice;

    private Integer numberOfStocks;

    private String dateOfPurchase;

    private String industry;


    @ElementCollection
    @CollectionTable(name = "company_images", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "image")
    private List<String> images;

    @ElementCollection
    @CollectionTable(name = "company_likes", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "`like`")  // Escaping the reserved keyword
    private List<String> likes;


    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    private void prePersist() {
        if (this.slug == null || this.slug.isEmpty()) {
            this.slug = slugify(this.name); // Custom method for slugifying
        }
        if (this.createdAt == null) {
            this.createdAt = new Date();
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSticker() {
        return sticker;
    }

    public void setSticker(String sticker) {
        this.sticker = sticker;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSelectedFile() {
        return selectedFile;
    }

    public void setSelectedFile(String selectedFile) {
        this.selectedFile = selectedFile;
    }

    public String getDescriptionFull() {
        return descriptionFull;
    }

    public void setDescriptionFull(String descriptionFull) {
        this.descriptionFull = descriptionFull;
    }

    public String getDescriptionSmall() {
        return descriptionSmall;
    }

    public void setDescriptionSmall(String descriptionSmall) {
        this.descriptionSmall = descriptionSmall;
    }

    public Long getBothPrice() {
        return bothPrice;
    }

    public void setBothPrice(Long bothPrice) {
        this.bothPrice = bothPrice;
    }

    public Long getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Long currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getMyValuePrice() {
        return myValuePrice;
    }

    public void setMyValuePrice(Long myValuePrice) {
        this.myValuePrice = myValuePrice;
    }

    public Integer getNumberOfStocks() {
        return numberOfStocks;
    }

    public void setNumberOfStocks(Integer numberOfStocks) {
        this.numberOfStocks = numberOfStocks;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    // Custom method for slugify logic (you can use any third-party library like 'slugify' or implement a basic version)
    private String slugify(String name) {
        return name.toLowerCase().replaceAll("[^a-z0-9\\-]", "-");
    }
}
