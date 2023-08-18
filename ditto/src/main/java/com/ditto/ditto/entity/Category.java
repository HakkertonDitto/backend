package com.ditto.ditto.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @RequiredArgsConstructor
public enum Category {
    RESTAURANT_CAFE("카페"),
    HOSPITAL("병원"),
    BANK_PUBLIC_OFFICE("은행, 관공서"),
    TICKET("티켓팅");

    private final String title;

}
