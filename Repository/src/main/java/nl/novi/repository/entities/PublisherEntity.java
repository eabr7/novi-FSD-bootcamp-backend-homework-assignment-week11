package nl.novi.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "publishers")
public class PublisherEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contactDetails")
    private String contactDetails;

    public PublisherEntity(Long id, String createDate, String editDate, String name, String address, String contactDetails) {
        super(id, createDate, editDate);
        this.name = name;
        this.address = address;
        this.contactDetails = contactDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}

