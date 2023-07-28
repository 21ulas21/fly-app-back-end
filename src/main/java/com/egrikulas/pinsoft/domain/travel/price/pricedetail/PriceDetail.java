package com.egrikulas.pinsoft.domain.travel.price.pricedetail;


import com.egrikulas.pinsoft.domain.travel.price.baseprice.BasePrice;
import com.egrikulas.pinsoft.library.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
@Table(name = PriceDetail.TABLE)
public class PriceDetail extends AbstractEntity {

    public static final String TABLE="price-detail";
    public static final String COL_BASE_PRICE="base-price";
    public static final String COL_TOTAL_TAX="total-tax";
    public static final String COL_SURCHARGE="surcharge";
    public static final String COL_SALES_PRICE="sales-price";

    @OneToOne
    @JoinColumn(name = COL_BASE_PRICE)
    private BasePrice basePrice;
    @OneToOne
    @JoinColumn(name = COL_TOTAL_TAX)
    private BasePrice totalTax;
    @OneToOne
    @JoinColumn(name = COL_SURCHARGE)
    private BasePrice surcharge;
    @OneToOne
    @JoinColumn(name = COL_SALES_PRICE)
    private BasePrice salesPrice;
}
