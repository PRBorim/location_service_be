package com.location_app.demo.logging.domain;

import com.location_app.demo.app.domain.Location;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "log_search_location")
public class LogSearchLocation {

    @Id
    @GeneratedValue
    @Column private BigInteger id;

    @Column private LocalDateTime date;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column private Collection<String> search;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column private Collection<Location> result;
}
