package com.swpuWYP;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface taxService {
    @WebMethod
    double calculatePersonalIncomeTax(double income);
}
