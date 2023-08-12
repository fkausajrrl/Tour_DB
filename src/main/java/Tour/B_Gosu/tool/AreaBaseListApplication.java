package Tour.B_Gosu.tool;

//우리의 시작이자 끝
//공공데이터 api사용하여 데이터 받아오는 코드

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AreaBaseListApplication {
    public static void main(String[] args) throws IOException {
        int i = 0;
        int[] contentType_Id = {12, 14, 38, 39};

        while (i < 4) { //contentTypeId를 4번
            int contentTypeId = contentType_Id[i];

            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=vKpB3BRjLRvDCYPVa5q8UHfrYeIX3NjEDb2mANeain5d14rLyU11zkd151ZW7P4WQAO1wRAP%2Fpx3wIswtBdctw%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("AND", "UTF-8")); /*Moblie OS*/
            urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("B-Gosu", "UTF-8")); /*MobileApp*/
            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/
            urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=" + URLEncoder.encode("Y" + "", "UTF-8")); /*listYN*/
            urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*arrange*/
            urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(contentTypeId), "UTF-8")); /*contentTypeId*/
            urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode("6", "UTF-8")); /*areaCode*/
            //urlBuilder.append("&" + URLEncoder.encode("mapX","UTF-8") + "=" + URLEncoder.encode("129.05773811299215", "UTF-8")); /*mapX*/
            //urlBuilder.append("&" + URLEncoder.encode("mapY","UTF-8") + "=" + URLEncoder.encode("35.15801789360982", "UTF-8")); /*mapY*/
            //urlBuilder.append("&" + URLEncoder.encode("radius","UTF-8") + "=" + URLEncoder.encode("90000", "UTF-8")); /*radius*/
            //urlBuilder.append("&" + URLEncoder.encode("modifiedtime","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*modifiedtime*/

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            System.out.println("Response code: " + conn.getResponseCode());
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();
            //받아온 json 데이터
            String jsonData = sb.toString();

            String filePath = String.format("src/main/java/Tour/json/DB데이터 확정_국문/%s_data.json", contentTypeId); // 파일 경로 및 파일명 지정
            writeJsonToFile(jsonData, filePath);

            System.out.println("JSON data has been saved to file: " + filePath);
            i++;
        }
    }

    public static void writeJsonToFile(String jsonData, String filePath) throws IOException {
        // 파일에 쓰기
        Path path = Paths.get(filePath);
        Files.write(path, jsonData.getBytes());
    }
}