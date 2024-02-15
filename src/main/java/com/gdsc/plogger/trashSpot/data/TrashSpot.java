package com.gdsc.plogger.trashSpot.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@NoArgsConstructor
@DynamicInsert
public class TrashSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;

    private double longitude;

    @ColumnDefault("0")
    private int report;

    @Builder
    public TrashSpot(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void report() {
        this.report += 1;
    }
}
