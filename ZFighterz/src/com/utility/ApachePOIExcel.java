package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOIExcel 
{
	static String F_N1 = "/C:/Users/SAYEM/0. My Stuff/Documents/03. Work/TalenTech/Excel/MyFirstExcel.xlsx";

	public static void main(String[] args) 
	{
		//CREATE & WRITE EXCEL ==================================================
		XSSFWorkbook wb1 = new XSSFWorkbook();
		
		XSSFSheet sh1 = wb1.createSheet("Datatypes in Java");
		
		Object[][] dts =
		{
			{	"DataType" 	, "Type" 			, "Size(bytes)"		}	,
			{	"int"		, "Primitive"		, 2					}	,
			{	"float"		, "Primitive"		, 4					}	,
			{	"double"	, "Primitive"		, 8					}	,
			{	"char"		, "Primitive"		, 1					}	,
			{	"String"	, "Non-Primitive"	, "No fixed size"	}	
		};
		
		
		int rowNum = 0 ;
				
		for (Object[] dt : dts)
		{
			Row rw1 	= sh1.createRow(rowNum++);
			int colNum 	= 0 ;
			
			for (Object fld : dt)
			{
				Cell perfect = rw1.createCell(colNum++);
				if (fld instanceof String)
				{
					perfect.setCellValue((String) fld);
				}
				else if (fld instanceof Integer)
				{
					perfect.setCellValue((Integer) fld);
				}
			}
		}

		try
		{
			FileOutputStream ops = new FileOutputStream(F_N1);
			wb1.write(ops);
			wb1.close();
		}
		catch (FileNotFoundException blah1)
		{
			blah1.printStackTrace();
		}
		catch (IOException blah1)
		{
			blah1.printStackTrace();
		}
		
		System.out.println("DoneW");
		System.out.println();

		
		
		//READ EXCEL ==================================================
		try
		{
			FileInputStream xlf = new FileInputStream(new File(F_N1));
			Workbook wb2 = new XSSFWorkbook(xlf);
			Sheet dts2 = wb2.getSheetAt(0);
			
			Iterator<Row> iter1 = dts2.iterator();
			
			while (iter1.hasNext())
			{
				Row currentRow = iter1.next();
				Iterator<Cell> cellIter = currentRow.iterator();
				
				while (cellIter.hasNext())
				{
					Cell currentCell = cellIter.next();
					
					if (currentCell.getCellTypeEnum() == CellType.STRING)
					{
						System.out.print(currentCell.getStringCellValue() + "	--	");
					}
					else if (currentCell.getCellTypeEnum() == CellType.NUMERIC)
					{
						System.out.print(currentCell.getNumericCellValue() + "	--	");
					}
				}
				
				System.out.println();
				
			}
		}
				
		catch (FileNotFoundException blah1)
		{
			blah1.printStackTrace();
		}
		catch (IOException blah1)
		{
			blah1.printStackTrace();
		}
		
		System.out.println();
		System.out.println("DoneR");	
	}

}