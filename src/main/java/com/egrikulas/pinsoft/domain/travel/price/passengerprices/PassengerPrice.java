package com.egrikulas.pinsoft.domain.travel.price.passengerprices;


import com.egrikulas.pinsoft.domain.travel.price.pricedetail.PriceDetail;
import com.egrikulas.pinsoft.library.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table()
public class PassengerPrice extends AbstractEntity {

    private String type;
    @OneToOne
    private PriceDetail priceDetail;
    @OneToOne
    private PriceDetail totalPriceDetail;




}
