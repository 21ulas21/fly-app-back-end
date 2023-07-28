package com.egrikulas.pinsoft.domain.travel.price.baseprice;

import com.egrikulas.pinsoft.library.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = BasePrice.TABLE)
public class BasePrice extends AbstractEntity {

    public static final String TABLE="sales-price";
    public static final String COL_AMOUNT="amount";
    public static final String COL_CURRENCY="currency";

    @Column(name = COL_AMOUNT)
    private double amount;
    @Column(name = COL_CURRENCY)
    private String currency;
}
