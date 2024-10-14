package hyxf.Autotest.webtest.Utils;

import java.io.*;

/**
 * @ClassName: CmdExecService
 * @Description: TODO
 * @Author: 64463
 * @Date: 2024/8/18 20:35
 * @Version: 1.0
 **/
public class CmdExecService {

    //allure结果存储路径
    private static final String ALLURE_RESULTS_DIR = "F:\\JIANG\\Study\\java\\java project\\testng-java-maven\\target\\allure-results";
    //allure报告存储路径
    private static final String ALLURE_REPORT_DIR = "F:\\JIANG\\Study\\java\\java project\\testng-java-maven\\target\\allure-results\\allure-report";


    /**
     * @param
     * @Description: <生成并打开allure测试报告>
     * @Return:
     * @Throws:
     * @Author: JiangShen
     * @Date: 2024/8/18 22:10
     */
    public static void generateAllureTestReport() {

        int waitForCode = 0;
        String allureGenerateCommand = "allure generate" + " \"" + ALLURE_RESULTS_DIR + "\" " + "-o " + "\"" + ALLURE_REPORT_DIR + "\"" + " -c";

        try {
            //调用CMD指令窗并执行指令
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe","/c",allureGenerateCommand);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            //获取命令输出结果
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
            String line;
            while ((line = reader.readLine())!=null){
                System.out.println(line);
            }
            //等待命令执行完成
            waitForCode = process.waitFor();
            if (waitForCode !=0){
                throw new  RuntimeException("生成allure报告失败");
            }else {
                System.out.println("成功生成allure报告，开始打开测试报告");
                openAllureTestReport();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: <description you method purpose>
     * @param
     * @Return: null
     * @Throws:
     * @Author: JiangShen
     * @Date: 2024/8/23 0:11
     */public static void openAllureTestReport() {

        String allureOpenCommand = "allure open" + " \"" + ALLURE_REPORT_DIR + "\"";
        int waitFor = 0;

        try {
            //调用CMD指令窗并执行指令
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe","/c",allureOpenCommand);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            //获取命令输出结果
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
            String line;
            while ((line = reader.readLine())!=null){
                System.out.println(line);
            }
            //等待命令执行完成
            waitFor=process.waitFor();
            if (waitFor!=0){
                throw new  RuntimeException("打开allure报告失败");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
