import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFName;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.CellReference;

import org.apache.poi.hssf.usermodel.HSSFCell;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.IndexedColors;
public class printExcel extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
			{
			
		// Get Excel Template
					POIFSFileSystem fs;
					try {
						String realPath =request.getServletContext().getRealPath("excel/StudentTemplate.xls");
						
						fs = new POIFSFileSystem(new FileInputStream(realPath));
						HSSFWorkbook wb = new HSSFWorkbook(fs, true);
						
						//HSSFSheet sheet = wb.getSheet("Data");
						
						HSSFSheet sheet = wb.getSheetAt(0);
							
						HSSFRow row;
						HSSFCell cell;
						
						CellStyle globalStyle = wb.createCellStyle();
						globalStyle.setAlignment(CellStyle.ALIGN_CENTER);
						globalStyle.setWrapText(true);
						globalStyle.setBorderRight(CellStyle.BORDER_THIN);
						globalStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
						globalStyle.setBorderLeft(CellStyle.BORDER_THIN);
						globalStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
						globalStyle.setBorderTop(CellStyle.BORDER_THIN);
						globalStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
						globalStyle.setBorderBottom(CellStyle.BORDER_THIN);
						globalStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
						 Font MDRfont = wb.createFont();
						 MDRfont.setColor(IndexedColors.RED.index);
						 MDRfont.setFontName( "Calibri" );
						 globalStyle.setFont(MDRfont);
						 				
						
						 Student s;
						for(int i=0;i<StudentRegistrationServlet.al.size();i++)
						{
							row = sheet.createRow(i+1);
							// creating cells for row
							
								row.createCell(0);
								s=(Student)StudentRegistrationServlet.al.get(i);
								row.getCell(0).setCellValue(s.getName());
								
								row.createCell(1);						
								row.getCell(1).setCellValue(s.getNrc());
								
								row.createCell(2);					
								row.getCell(2).setCellValue(s.getGender());
								
								row.createCell(3);						
								row.getCell(3).setCellValue(s.getFather());
								
								row.createCell(4);						
								row.getCell(4).setCellValue(s.getAddr());
								
								row.createCell(5);						
								row.getCell(5).setCellValue(s.getPh());
								
								row.getCell(0).setCellStyle(globalStyle);
								row.getCell(1).setCellStyle(globalStyle);
								row.getCell(2).setCellStyle(globalStyle);
								row.getCell(3).setCellStyle(globalStyle);
								row.getCell(4).setCellStyle(globalStyle);
								row.getCell(5).setCellStyle(globalStyle);
								
								System.out.println(s.getName()+"\t"+s.getPh()+"\n");
							
						}
						for(int c = 0; c < 6; c++) {
							sheet.autoSizeColumn(c);
						}
						 	Date date = new Date();
				            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
				            String filename = "Student" + dt.format(date) + ".xls";         	            
				          //  FileOutputStream fileOut = new FileOutputStream(filename);
				         
				            response.setContentType("application/vnd.ms-excel");
				            String st="attachment; filename="+filename;
				            response.setHeader("Content-Disposition", st);	
				            
				            wb.write(response.getOutputStream());
				            
				         //   fileOut.flush();
				          //  fileOut.close();
				           
				          // response.getWriter().write("hello");
				          //  RequestDispatcher rd = request.getRequestDispatcher("./registration");
				    		//rd.forward(request, response);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Get New Excel Book, Sheet, Row, Cell
		
			}

}
