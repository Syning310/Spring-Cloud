package com.syning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String serial;

}
