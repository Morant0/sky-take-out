package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.ReportService;
import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@RestController
@RequestMapping("/admin/report")
@Slf4j
@Api(tags = "数据统计相关接口")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 营业额数据统计
     * @param begin
     * @param end
     * @return
     */
    @RequestMapping("/turnoverStatistics")
    @ApiOperation("营业额数据统计")
    public Result<TurnoverReportVO> turnoverStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("营业额数据统计：{}到{}", begin, end);
        TurnoverReportVO reportData = reportService.getTurnoverStatistics(begin, end);
        return Result.success(reportData);
    }

    /**
     * 用户数据统计
     * @param begin
     * @param end
     * @return
     */
    @RequestMapping("/userStatistics")
    @ApiOperation("用户数据统计")
    public Result<UserReportVO> userStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("用户数据统计：{}到{}", begin, end);
        UserReportVO reportData = reportService.getUserStatistics(begin, end);
        return Result.success(reportData);
    }

    /**
     * 订单数据统计
     * @param begin
     * @param end
     * @return
     */
    @RequestMapping("/ordersStatistics")
    @ApiOperation("订单数据统计")
    public Result<OrderReportVO> ordersStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("订单数据统计：{}到{}", begin, end);
        OrderReportVO reportData = reportService.getOrdersStatistics(begin, end);
        return Result.success(reportData);
    }

    /**
     * 商品销量前10
     * @param begin
     * @param end
     * @return
     */
    @RequestMapping("/top10")
    @ApiOperation("商品销量排名")
    public Result<SalesTop10ReportVO> top10(
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("商品销量排名：{}到{}", begin, end);
        SalesTop10ReportVO reportData = reportService.getSalesTop10(begin, end);
        return Result.success(reportData);
    }

    @GetMapping("/export")
    @ApiOperation("导出数据报表")
    public void export(HttpServletResponse response) {
        reportService.exportBussinessData(response);
    }

}
