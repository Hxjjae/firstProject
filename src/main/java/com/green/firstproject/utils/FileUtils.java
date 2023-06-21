package com.green.firstproject.utils;

import java.util.UUID;

public class FileUtils {
    public static String getExt(String fileNm){ // adcd.123.hhh.jpg ->jpg

       String result = fileNm.substring(
               fileNm.lastIndexOf(".")+1);
               return result;
    }
//파일명만 리턴하는 메소드
    public static String getFileNm(String fileNm){
    int idx = fileNm.lastIndexOf(".");
   String resultFileNm = fileNm.substring(0,idx);
        return resultFileNm;
    }
    // UUID 이용,랜덤값 파일명 리턴
    public static String makeRandomFileNm(String fileNm){

    String uuid = UUID.randomUUID().toString();
        String result = fileNm.substring(
                fileNm.lastIndexOf("."));
        String savedFileName = uuid + result;

        return savedFileName;
    }
}
