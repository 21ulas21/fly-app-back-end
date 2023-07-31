package com.egrikulas.pinsoft.domain.travel.impl;

import com.egrikulas.pinsoft.domain.destination.impl.AirPort;
import com.egrikulas.pinsoft.domain.travel.price.passengerprices.PassengerPrice;
import com.egrikulas.pinsoft.domain.travel.price.pricedetail.PriceDetail;
import com.egrikulas.pinsoft.library.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table()
public class Travel extends AbstractEntity {

    private long leqId;
    private String flightNo;
    private String airlineCode;
    private String airline;
    private String depTime;
    private String arrTime;
    private String flightId;
    @OneToOne
    private AirPort depPort;
    @OneToOne
    private AirPort arrPort;
    private String flightDate;
    private String via;
    @OneToOne
    private PriceDetail priceDetail;
    @OneToMany
    private List<PassengerPrice> passengerPrices;


}
