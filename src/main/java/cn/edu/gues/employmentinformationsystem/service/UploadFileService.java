package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.entity.Major;
import cn.edu.gues.employmentinformationsystem.entity.User;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

@Service
public class UploadFileService {
    @Resource
    private UserService userService;
    @Resource
    private MajorService majorService;
    public String uploadFile(MultipartFile file, String saveUrl, String fileType) {
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID() + suffix;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-kk-mm-ss");
        System.out.println("格式化输出：" + sdf.format(d));
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String newUrl = saveUrl+"\\"+fileName;
        System.out.println("文件路径：" + newUrl);
        String[] type_array = fileType.split(",");
        System.out.println("type  :  "+type_array.length);
        File saveFile = new File(newUrl);
        if(!saveFile.getParentFile().exists()){
            saveFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败！";
        }
        //转换为pdf格式并且加上名字后缀.pdf
        File inputWord = new File(saveUrl+"\\"+fileName);
        File outputFile = new File(saveUrl+"\\"+fileName+".pdf");
        try  {

            InputStream docxInputStream = new FileInputStream(inputWord);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(docxInputStream);
            OutputStream outputStream = new FileOutputStream(outputFile);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            IConverter converter = LocalConverter.builder().build();
            converter.convert(bufferedInputStream).as(DocumentType.DOCX).to(bufferedOutputStream).as(DocumentType.PDF).execute();
            bufferedOutputStream.close();
            bufferedInputStream.close();
            outputStream.close();
            docxInputStream.close();
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
    public String uploadImg(MultipartFile file, String saveUrl, String fileType) {
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID() + suffix;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-kk-mm-ss");
        System.out.println("格式化输出：" + sdf.format(d));
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String newUrl = saveUrl+"\\"+fileName;
        System.out.println("文件路径：" + newUrl);
        String[] type_array = fileType.split(",");
        System.out.println("type  :  "+type_array.length);
        File saveFile = new File(newUrl);
        if(!saveFile.getParentFile().exists()){
            saveFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败！";
        }
        return fileName;
    }
    public int uploadExcelForStudent(MultipartFile file, String saveUrl, String fileType,String userId) throws IOException {
        Workbook book;
        try {
          book = new XSSFWorkbook(file.getInputStream());
      } catch (Exception ex) {
          book = new HSSFWorkbook(file.getInputStream());
        }
        Sheet sheet = book.getSheetAt(0);
        int allRowNum = sheet.getLastRowNum();
        for (int i=1;i<=allRowNum;i++){
            Row row1 = sheet.getRow(i);
            //用户名
            Cell cell = row1.getCell(1);
            //姓名
            Cell cell1 = row1.getCell(2);
            //专业
            Cell cell2 = row1.getCell(3);
            User user = new User();
            if(cell.getCellType()==CELL_TYPE_NUMERIC){
                user.setUserName(String.valueOf(cell.getNumericCellValue()));
                user.setSno(String.valueOf(cell.getNumericCellValue()));
            }
            if (cell.getCellType()==CELL_TYPE_STRING){
                user.setUserName(cell.getStringCellValue());
                user.setSno(cell.getStringCellValue());
            }
            user.setPassword("123456");
            if (cell1.getCellType() == CELL_TYPE_NUMERIC) {
                user.setName(String.valueOf(cell1.getNumericCellValue()));
            }
            if (cell1.getCellType() == CELL_TYPE_STRING) {
                user.setName(cell1.getStringCellValue());
            }
            if (cell2.getCellType() == CELL_TYPE_NUMERIC) {
                user.setMajorId(majorService.getMajorByName(String.valueOf(cell2.getNumericCellValue())).getMajorId());
            }
            if (cell2.getCellType() == CELL_TYPE_STRING) {
                user.setMajorId(majorService.getMajorByName(cell2.getStringCellValue()).getMajorId());
            }
            user.setType("1");
            user.setParentUserId(userId);
            if(userService.isUserExist(user.getUserName())){
                return 0;
            }
            userService.addUser(user);
        }
        return 1;
    }
}
