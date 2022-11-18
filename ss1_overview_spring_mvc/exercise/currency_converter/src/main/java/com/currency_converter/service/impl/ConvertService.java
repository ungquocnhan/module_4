package com.currency_converter.service.impl;

import com.currency_converter.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public double convertToVnd(double usd) {
        return usd * 24785;
    }

    @Override
    public double convertToUsd(double vnd) {
        return vnd / 24785;
    }
}
