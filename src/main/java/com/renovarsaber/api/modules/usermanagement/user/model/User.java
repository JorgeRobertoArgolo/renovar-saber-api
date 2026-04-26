package com.renovarsaber.api.modules.usermanagement.user.model;

import com.renovarsaber.api.infrastructure.model.PersistenceEntity;
import com.renovarsaber.api.modules.usermanagement.person.model.Person;
import com.renovarsaber.api.modules.usermanagement.user.enums.Profile;
import com.renovarsaber.api.modules.usermanagement.user.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity(name = "User")
@Table(name = "users")
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public class User extends PersistenceEntity {

    @Email
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "password",  nullable = false, length = 255)
    private String password;

    @Column(name = "username",  nullable = false, length = 100)
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile", nullable = false)
    private Profile profile;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_person", unique = true,  nullable = false)
    private Person person;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
