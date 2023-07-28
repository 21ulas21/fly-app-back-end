package com.egrikulas.pinsoft.domain.ticket.impl;

import com.egrikulas.pinsoft.domain.security.user.impl.User;
import com.egrikulas.pinsoft.domain.travel.impl.Travel;
import com.egrikulas.pinsoft.library.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Ticket.TABLE)
public class Ticket extends AbstractEntity {

    public static final String TABLE="ticket";
    public static final String COL_INSURANCE = "insurance";
    public static final String COL_LUGGAGE="luggage";
    public static final String COL_USER="user-id";
    public static final String COL_TRAVEL="travel-id";

    @Column(name = COL_INSURANCE)
    private Boolean insurance;

    @Column(name = COL_LUGGAGE)
    private Double luggage;

    @OneToOne
    @JoinColumn(name = COL_USER)
    private User user;

    @OneToOne
    @JoinColumn(name = COL_TRAVEL)
    private Travel travel;
}


