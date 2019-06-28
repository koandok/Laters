package com.gxuwz.laters.bean.manager;

import java.util.List;

import org.apache.poi.hssf.usermodel.*;

import com.gxuwz.laters.bean.entity.Later;

public class ExcManager {
	String[] excelHeader = { "��鵥��", "����ID", "ѧ��ID", "ѧ������", "���ʱ��", "ԭ��", "�༶��" };

	public HSSFWorkbook export(List<Later> list) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("later");
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();

		for (int i = 0; i < excelHeader.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(i);
		}

		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			Later later = list.get(i);
			row.createCell(0).setCellValue(later.getLaterID());
			row.createCell(1).setCellValue(later.getDormID());
			row.createCell(2).setCellValue(later.getStuID());
			row.createCell(3).setCellValue(later.getStuName());
			row.createCell(4).setCellValue(later.getLaterTime());
			row.createCell(5).setCellValue(later.getReason());
			row.createCell(6).setCellValue(later.getClassID());
		}
		return wb;
	}
}
