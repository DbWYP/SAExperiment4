package com.swpuWYP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;//tomcat10以下的
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateTax", urlPatterns = "/Tax")
public class CalculateTaxDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容类型
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 获取用户输入的收入参数
        String incomeStr = req.getParameter("income");
        if (incomeStr != null && !incomeStr.isEmpty()) {
            try {
                // 将收入转换为 double 类型
                double income = Double.parseDouble(incomeStr);

                // 计算税款
                double tax = calculateTax(income);

                // 输出税款结果
                out.println("<html><head><title>税款计算结果</title></head><body>");
                out.println("<h1>您的应纳税额为: " + tax + " 元</h1>");
                out.println("<a href=\"index.html\">返回</a>");
                out.println("</body></html>");
            } catch (NumberFormatException e) {
                out.println("<html><head><title>输入错误</title></head><body>");
                out.println("<h1>请输入有效的收入金额</h1>");
                out.println("<a href=\"index.html\">返回</a>");
                out.println("</body></html>");
            }
        } else {
            out.println("<html><head><title>输入错误</title></head><body>");
            out.println("<h1>请提供收入参数</h1>");
            out.println("<a href=\"index.html\">返回</a>");
            out.println("</body></html>");
        }
    }

    // 根据工资范围计算个人所得税
    private double calculateTax(double income) {
        double tax = 0.0;

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

