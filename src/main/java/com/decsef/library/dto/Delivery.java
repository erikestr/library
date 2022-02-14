package com.decsef.library.dto;

import com.decsef.library.entity.LoansStatus;
import lombok.Data;

@Data
public class Delivery {

    private int expatriationDays;
    private LoansStatus loansStatus;
}
