package com.swpuWYP;
import javax.jws.WebService;

@WebService(endpointInterface = "com.swpuWYP.taxService")
public class taxServiceImpl implements taxService {
    public double calculatePersonalIncomeTax(double income) {
        double tax;
        if (income <= 5000) {
            tax = 0.0;  // 1-5000元之间，税率0%
        } else if (income <= 8000) {
            tax = (income - 5000) * 0.03;  // 5000-8000元之间，税率3%
        } else if (income <= 17000) {
            tax = (income - 8000) * 0.10 + 3000 * 0.03;  // 8000-17000元之间，税率10%
        } else if (income <= 30000) {
            tax = (income - 17000) * 0.20 + 9000 * 0.10 + 3000 * 0.03;  // 17000-30000元之间，税率20%
        } else if (income <= 40000) {
            tax = (income - 30000) * 0.25 + 13000 * 0.20 + 9000 * 0.10 + 3000 * 0.03;  // 30000-40000元之间，税率25%
        } else if (income <= 60000) {
            tax = (income - 40000) * 0.30 + 10000 * 0.25 + 13000 * 0.20 + 9000 * 0.10 + 3000 * 0.03;  // 40000-60000元之间，税率30%
        } else if (income <= 85000) {
            tax = (income - 60000) * 0.35 + 20000 * 0.30 + 10000 * 0.25 + 13000 * 0.20 + 9000 * 0.10 + 3000 * 0.03;  // 60000-85000元之间，税率35%
        } else {
            tax = (income - 85000) * 0.45 + 25000 * 0.35 + 20000 * 0.30 + 10000 * 0.25 + 13000 * 0.20 + 9000 * 0.10 + 3000 * 0.03;  // 85000元以上，税率45%
        }

        return tax;
    }
}
