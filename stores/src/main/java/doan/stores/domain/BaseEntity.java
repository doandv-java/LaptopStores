package doan.stores.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@EnableJpaAuditing
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 6010339256504929188L;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "create_at")
    private Date createdAt;


    @CreatedBy
    @Column(name = "create_by")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "update_at")
    private Date updatedAt;

    @LastModifiedBy
    @Column(name = "update_by")
    private String updatedBy;

}
