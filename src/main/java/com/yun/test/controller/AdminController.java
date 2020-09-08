package com.yun.test.controller;

import com.yun.common.util.CommonUtils;
import com.yun.test.model.admin;
import com.yun.test.service.AdminService;
//import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import  org.json.simple.JSONObject;
import  org.json.simple.parser.JSONParser;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;


//@RequestMapping("/home")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value  = "/home/home.do")
    public String home(Model model)  throws Exception  {

        int lottoCnt = 926;
        int lottoPlusCnt = 0;
        String comDay = "2020-08-30";
        String today;

        SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd");

        Date time = new Date();

        today = format1.format(time);

        Date FirstDate = format1.parse(today);
        Date SecondDate = format1.parse(comDay);


        long calDate = FirstDate.getTime() - SecondDate.getTime();

        long calDateDays = calDate / ( 24*60*60*1000);

        calDateDays = Math.abs(calDateDays);


        lottoPlusCnt =  ((int)calDateDays / 7) ;

        lottoCnt = lottoCnt + lottoPlusCnt;

        String url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo="+lottoCnt;

        URL apiUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();

        try(OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "UTF-8")){

            String jsonStr = json.toString();
            wr.write(jsonStr);
            wr.flush();
        }catch(Exception e){
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        StringBuffer response = new StringBuffer();

        String output;
        while ((output = br.readLine()) != null) {
            response.append(output);
        }
        String resultStr = response.toString();

//        System.out.println("resultStr : " + resultStr);

        JSONParser parser = new JSONParser();
        JSONObject resultJson = (JSONObject) parser.parse(resultStr);

        String totSellamnt = resultJson.get("totSellamnt").toString();
        String returnValue = resultJson.get("returnValue").toString();
        String drwNoDate = resultJson.get("drwNoDate").toString();
        String firstWinamnt = resultJson.get("firstWinamnt").toString();
        String drwNo = resultJson.get("drwNo").toString();

        String bnusNo = resultJson.get("bnusNo").toString();

        String[] drwtNoArr = new String[7];
        String[] drwtNoColArr = new String[7];

        for (int i=1;i<7;i++){
            String drwtNo = "drwtNo" + i;
            drwtNoArr[i] = resultJson.get(drwtNo).toString();

            if (drwtNoArr[i].length() == 1) {
                drwtNoColArr[i] = "0";
            }else{
                drwtNoColArr[i] = drwtNoArr[i].substring(0,1);
            }
//            System.out.println("drwtNoArr[" + i+"] : " + drwtNoArr[i]);
//            System.out.println("drwtNoColArr[" + i+"] : " + drwtNoColArr[i]);
        }


        String bnusNoCol = bnusNo.substring(0,1);

        if (bnusNo.length() == 1) {
            bnusNoCol = "0";
        }

        model.addAttribute("totSellamnt", resultJson.get("totSellamnt").toString());
        model.addAttribute("drwNoDate", resultJson.get("drwNoDate").toString());
        model.addAttribute("firstWinamnt", resultJson.get("firstWinamnt").toString());
        model.addAttribute("firstPrzwnerCo", resultJson.get("firstPrzwnerCo").toString());
        model.addAttribute("firstAccumamnt", resultJson.get("firstAccumamnt").toString());
        model.addAttribute("drwNo", resultJson.get("drwNo").toString());
        model.addAttribute("drwtNoArr", drwtNoArr);
        model.addAttribute("drwtNoColArr", drwtNoColArr);
        model.addAttribute("bnusNo", bnusNo);
        model.addAttribute("bnusNoCol", bnusNoCol);


        return "home/home";
    }

    @RequestMapping(value  = "/home/test.do")
    public String testMove(ModelMap modelmap) {

        String admin_nm = "이굥의";
        admin admin = new admin();
        admin = adminService.getAdminInfo(admin_nm);

        String nm = admin.getAdmin_nm();

        modelmap.addAttribute("nm" , nm);

        return "test/test";
    }


    @RequestMapping(value  = "/home/lottoResult.do")
    public String lottoBuy(HttpServletRequest request, Model model) {

        Map param = CommonUtils.getParameterMap(request);
//        System.out.println("param : " + param);

        int cnt = (int) param.get("cnt");
        String bnusNo = param.get("bnusNo").toString();
        String [] drwtNoArr = new String[7];

        for (int i=1;i<7;i++){
            String drwtNo = "drwtNo" + i;
            drwtNoArr[i-1] = param.get(drwtNo).toString();
//            System.out.println("drwtNoArr[" + (i-1) +"] : " + drwtNoArr[i-1]);
        }

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 1; i <= 45; i++) {
            numbers.add(i); // 1~45
        }

        int [] prize = new int[6];
        String [] prizeNo = new String[6];

        for (int i=0;i<cnt;i++){

            Collections.shuffle(numbers);

            String [] picked = new String[6];
            for (int j = 0; j < 6; j++) { //numbers의 앞 6개 숫자를 가져옴
                picked[j] = numbers.get(j).toString();
            }
//            System.out.println("picked " + picked[0] + ", "+ picked[1] + ", "+ picked[2] + ", " + picked[3] + ", "+ picked[4] + ", "+ picked[5]);
            int cont = 0;
            String second = "N";
            for (int x = 0; x < 6; x++) {
                for (int y = 0; y < 6; y++) {
                    if (picked[x].equals(drwtNoArr[y])) {
                        cont++;
                    }
                }
            }

            if(cont==5){
                for(int s =0;s<6;s++){
                    if (picked[s].equals(bnusNo)) {
                        second = "Y";
                    }
                }
            }
//            System.out.println("second :  "+ second + " / bnusNo : " + bnusNo );
            if(cont==6){
                prize[0] = prize[0] + 1 ;

                if (prizeNo[0]==null){
                    prizeNo[0] = "[" + picked[0] + ", "+ picked[1] + ", "+ picked[2] + ", " + picked[3] + ", "+ picked[4] + ", "+ picked[5]+"]";
                }else{
                    prizeNo[0] += "\n[" + picked[0] + ", "+ picked[1] + ", "+ picked[2] + ", " + picked[3] + ", "+ picked[4] + ", "+ picked[5]+"]";
                }
            }else if(cont==5&&"Y".equals(second)){
                prize[1] = prize[1] + 1 ;

                if (prizeNo[1]==null){
                    prizeNo[1] = "[" + picked[0] + ", "+ picked[1] + ", "+ picked[2] + ", " + picked[3] + ", "+ picked[4] + ", "+ picked[5]+"]";
                }else{
                    prizeNo[1] += "\n[" + picked[0] + ", "+ picked[1] + ", "+ picked[2] + ", " + picked[3] + ", "+ picked[4] + ", "+ picked[5]+"]";
                }
            }else if(cont==5&&"N".equals(second)){
                prize[2] = prize[2] + 1 ;

                if (prizeNo[2]==null){
                    prizeNo[2] = "[" + picked[0] + ", "+ picked[1] + ", "+ picked[2] + ", " + picked[3] + ", "+ picked[4] + ", "+ picked[5]+"]";
                }else{
                    prizeNo[2] += "\n[" + picked[0] + ", "+ picked[1] + ", "+ picked[2] + ", " + picked[3] + ", "+ picked[4] + ", "+ picked[5]+"]";
                }
            }else if(cont==4){
                prize[3] = prize[3] + 1 ;

                if (prizeNo[3]==null){
                    prizeNo[3] = "[" + picked[0] + ", "+ picked[1] + ", "+ picked[2] + ", " + picked[3] + ", "+ picked[4] + ", "+ picked[5]+"]";
                }else{
                    prizeNo[3] += "\n[" + picked[0] + ", "+ picked[1] + ", "+ picked[2] + ", " + picked[3] + ", "+ picked[4] + ", "+ picked[5]+"]";
                }
            }else if(cont==3){
                prize[4] = prize[4] + 1 ;

                if (prizeNo[4]==null){
                    prizeNo[4] = "[" + picked[0] + ", "+ picked[1] + ", "+ picked[2] + ", " + picked[3] + ", "+ picked[4] + ", "+ picked[5]+"]";
                }else{
                    prizeNo[4] += "\n[" + picked[0] + ", "+ picked[1] + ", "+ picked[2] + ", " + picked[3] + ", "+ picked[4] + ", "+ picked[5]+"]";
                }
            }
        }

        model.addAttribute("prize",prize);
        model.addAttribute("prizeNo",prizeNo);
        model.addAttribute("status","success");

//        System.out.println("1등 당첨 : " + prize[0] + " 회" + "\n2등 당첨 : " + prize[1] + " 회" + "\n3등 당첨 : " + prize[2] + " 회" + "\n4등 당첨 : " + prize[3] + " 회" + "\n5등 당첨 : " + prize[4] + " 회");
//        System.out.println("1등 당첨 : " + prizeNo[0] + "\n2등 당첨 : " + prizeNo[1] + "\n3등 당첨 : " + prizeNo[2]  + "\n4등 당첨 : " + prizeNo[3]  + "\n5등 당첨 : " + prizeNo[4]);

        return "ajaxHtml/home/homeAjax";
    }


    @RequestMapping(value  = "/home/lottoApi.do")
    public String lottoApi(Model model) throws Exception {

        String url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=927";

        URL apiUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();

        try(OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "UTF-8")){

            String jsonStr = json.toString();
            wr.write(jsonStr);
            wr.flush();
        }catch(Exception e){
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        StringBuffer response = new StringBuffer();

        String output;
        while ((output = br.readLine()) != null) {
            response.append(output);
        }
        String resultStr = response.toString();

//        System.out.println("resultStr : " + resultStr);

        JSONParser parser = new JSONParser();
        JSONObject resultJson = (JSONObject) parser.parse(resultStr);

        String totSellamnt = resultJson.get("totSellamnt").toString();
        String returnValue = resultJson.get("returnValue").toString();
        String drwNoDate = resultJson.get("drwNoDate").toString();
        String firstWinamnt = resultJson.get("firstWinamnt").toString();
        String drwNo = resultJson.get("drwNo").toString();

        String drwtNo1 = resultJson.get("drwtNo1").toString();
        String drwtNo2 = resultJson.get("drwtNo2").toString();
        String drwtNo3 = resultJson.get("drwtNo3").toString();
        String drwtNo4 = resultJson.get("drwtNo4").toString();
        String drwtNo5 = resultJson.get("drwtNo5").toString();
        String drwtNo6 = resultJson.get("drwtNo6").toString();
        String bnusNo = resultJson.get("bnusNo").toString();


        return "test/test";
    }


}
