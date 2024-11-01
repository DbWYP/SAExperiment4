import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;//tomcat10以下的
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WeatherServlet", urlPatterns = "/weathers")
public class WeatherServlet extends HttpServlet {
    private Weather weatherService = new Weather();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityname = request.getParameter("cityname");
        List<String> weatherInfo = new ArrayList<>();
        System.out.println("cityname: " + cityname);

        if (cityname != null && !cityname.isEmpty()) {
            try {
                weatherInfo = weatherService.getWeather(cityname);
            } catch (Exception e) {
                e.printStackTrace();
                weatherInfo.add("查询天气时发生错误，请稍后再试。");
            }
        } else {
            weatherInfo.add("请输入城市名。");
        }

        // 返回HTML格式的数据
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // 生成返回的HTML
        out.print("<div class='weather-results'>");
        if (weatherInfo.isEmpty()) {
            out.print("<p>未找到天气信息</p>");
        } else {
            for (String info : weatherInfo) {
                out.print("<p>" + info + "</p>");
            }
        }
        out.print("</div>");
        out.flush();
    }
}