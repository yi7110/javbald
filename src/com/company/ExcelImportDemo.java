package com.company;



import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * com.company
 *
 * @author Liuzf
 * @date 2020-06-15 16:57:26
 * excel表格，兼容2003和2007
 */
public class ExcelImportDemo {
    /** 总行数 */
    private int totalRows = 0;

    /** 总列数 */
    private int totalCells = 0;

    /** 错误信息 */
    private String errorInfo;

    /** 构造方法 */
    public ExcelImportDemo() {}

    /**
     * 得到总行数
     */
    public int getTotalRows() {
        return totalRows;
    }

    /**
     * 得到总列数
     */
    public int getTotalCells() {
        return totalCells;
    }

    /**
     * 得到错误信息
     */
    public String getErrorInfo() {
        return errorInfo;
    }

    /**
     *
     * 验证excel文件
     * @author CaptainFM
     * @param：filePath 文件完整路径
     * @return 返回 true 表示文件没有问题
     */
    public boolean validateExcel(String filePath) {
        // 检查文件名是否为空或者是否是Excel格式的文件
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorInfo = "文件不是excel格式";
            return false;
        }

        // 检查文件是否存在
        File file = new File(filePath);

        if (file == null || !file.exists()) {
            errorInfo = "文件不存在";
            return false;
        }

        return true;
    }

    /**
     * 根据文件名读取excel文件
     * @author CaptainFM
     * @param filePath 文件完整路径
     * @param ignoreRows 读取数据忽略的行数，比喻第一行不需要读入，忽略的行数为1
     * @return：List  最后读取的结果，数据结构：List<List<String>>
     */
    public List<List<String>> read(String filePath, int ignoreRows) {

        List<List<String>> dataList = new ArrayList<List<String>>();
        InputStream is = null;

        try {
            // 验证文件是否合法
            if (!validateExcel(filePath)) {
                System.out.println(errorInfo);
                return null;
            }

            // 判断文件的类型，是2003还是2007
            boolean isExcel2003 = true;
            if (isExcel2007(filePath)) {
                isExcel2003 = false;
            }

            // 调用本类提供的根据流读取的方法
            File file = new File(filePath);
            is = new FileInputStream(file);
            dataList = read(is, isExcel2003, ignoreRows);
            is.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {

                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }

            }
        }

        // 返回最后读取的结果
        return dataList;
    }

    /**
     * 根据流读取Excel文件
     * @author CaptainFM
     * @param inputStream
     * @param isExcel2003  是否是2003的表格（xls格式）
     * @param ignoreRows 读取数据忽略的行数，比喻第一行不需要读入，忽略的行数为1
     * @return：List
     */
    public List<List<String>> read(InputStream inputStream, boolean isExcel2003, int ignoreRows) {
        List<List<String>> dataList = null;
        try {

            // 根据版本选择创建Workbook的方式
            Workbook wb = null;

            if (isExcel2003) {
                wb = new HSSFWorkbook(inputStream);
            } else {
                wb = new XSSFWorkbook(inputStream);
            }
            dataList = read(wb, ignoreRows);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    /**
     * 读取数据
     * @author CaptainFM
     * @param ignoreRows 读取数据忽略的行数，比喻第一行不需要读入，忽略的行数为1
     * @reture：List<List<String>>
     */
    private List<List<String>> read(Workbook wb, int ignoreRows) {
        List<List<String>> dataList = new ArrayList<List<String>>();

        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);

        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();

        // 得到Excel的列数，不从表格的第一行得到列数，从忽略之后的，要读取的第一行 获取列数
        if (this.totalRows >= 1 && sheet.getRow(ignoreRows) != null) {
            this.totalCells = sheet.getRow(ignoreRows).getPhysicalNumberOfCells();
        }

        // 循环Excel的行，不从表格的第一行循环，去掉忽略的行数
        for (int r = ignoreRows; r < this.totalRows; r++) {
            Row row = sheet.getRow(r);

            if (row == null) {
                continue;
            }

            List<String> rowList = new ArrayList<String>();

            // 循环Excel的列
            for (int c = 0; c < this.getTotalCells(); c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";

                if (null != cell) {
                    // 以下是判断数据的类型
                    switch (cell.getCellType()) {
                        // 数字
                        case NUMERIC:

                            // 如果数字是日期类型，就转换成日期
                            // 处理日期格式、时间格式
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                SimpleDateFormat sdf = null;
                                if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                                    sdf = new SimpleDateFormat("HH:mm");
                                } else {// 日期
                                    sdf = new SimpleDateFormat("yyyy年MM月dd日");
                                }
                                Date date = cell.getDateCellValue();
                                cellValue = sdf.format(date);
                            } else if (cell.getCellStyle().getDataFormat() == 31) {
                                // 处理自定义日期格式：yyyy年m月d日(通过判断单元格的格式id解决，id的值是31)
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                                double value = cell.getNumericCellValue();
                                Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                                cellValue = sdf.format(date);
                            } else {
                                double value = cell.getNumericCellValue();
                                CellStyle style = cell.getCellStyle();
                                DecimalFormat format = new DecimalFormat();
                                String temp = style.getDataFormatString();
                                // 单元格设置成常规
                                if (temp.equals("General")) {
                                    format.applyPattern("#");
                                }
                                cellValue = format.format(value);
                            }
                            break;
                        // 字符串
                        case STRING:
                            cellValue = cell.getStringCellValue();
                            break;
                        // Boolean
                        case BOOLEAN:
                            cellValue = cell.getBooleanCellValue() + "";
                            break;
                        // 公式
                        case FORMULA:
                            cellValue = cell.getCellFormula() + "";
                            break;
                        // 空值
                        case BLANK:
                            cellValue = "";
                            break;
                        // 故障
                        case ERROR:
                            cellValue = "非法字符";
                            break;

                        default:
                            cellValue = "未知类型";
                            break;
                    }
                }
                rowList.add(cellValue);
            }

            // 保存第r行的第c列
            dataList.add(rowList);
        }
        return dataList;
    }

    /**
     * 是否是2003的excel，返回true是2003
     * @author CaptainFM
     * @param filePath 文件完整路径
     * @return boolean true代表是2003
     */
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     * 是否是2007的excel，返回true是2007
     * @author CaptainFM
     * @param filePath 文件完整路径
     * @return boolean true代表是2007
     */
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}
