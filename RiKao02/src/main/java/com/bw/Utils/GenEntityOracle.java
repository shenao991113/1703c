package com.bw.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class GenEntityOracle {

    private String authorName = "wanghd";// 作者名字
    private String tablename = "eb_brand";// 表名
    private String packageOutPath = "com.bw.entity";// 指定实体生成所在包的路径
    private String[] colnames; // 列名数组
    private String[] colTypes; // 列名类型数组
    private int[] colLens; // 字段长度数组
    private String[] colComments;  //备注数组
    private String[] tablecolnames;
    private int[] colSizes; // 列名大小数组
    private boolean f_util = false; // 是否需要导入包java.util.*
    private boolean f_sql = false; // 是否需要导入包java.sql.*
    private String javaName = "";

    private String databaseName = "";//mysql数据库名

    // 数据库连接
//    private static final String URL = "jdbc:oracle:thin:@192.168.215.128:1521:orcl";
//    private static final String NAME = "scott";
//    private static final String PASS = "tiger";
    private static final String URL="jdbc:mysql://localhost:3306/xiaoyi?user=root&password=root&useUnicode=true&characterEncoding=UTF8";
//  private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    

    public GenEntityOracle() {
        this("pingtai_kaohezhouqi","","");
    }
    
    public GenEntityOracle(String tablename,String javaName,String databaseName) {
    	this.javaName = javaName;
        this.tablename = tablename;
        this.databaseName = databaseName;
       
        //判断如果有下划线就截取，否则不截取
        if(tablename.indexOf("_")>0){
        	javaName = tablename.split("_")[1];
        }else{
        	javaName = tablename;
        }
        
    }
    
    public void init() {
        // 创建连接
        Connection con;
        // 查要生成实体类的表
        String sql = "select * from " + tablename;
        Statement pStemt = null;
        try {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            //获取注释
            //mysql连接需要需改的地方 		新增参数databaseName 	mysql查询注释和oracle不同
            String comSql = "select column_comment from information_schema.COLUMNS where TABLE_SCHEMA='"+databaseName+"' and  table_name='"+tablename.toUpperCase()+"'";
            // String comSql = "select * from user_col_comments where  table_name='"+tablename.toUpperCase()+"'";
//            Connection ccon = DriverManager.getConnection(URL, NAME, PASS);
            Connection ccon = DriverManager.getConnection(URL);
            Statement stmt = ccon.createStatement();
            ResultSet cRs = stmt.executeQuery(comSql);
            
//            con = DriverManager.getConnection(URL, NAME, PASS);
            con = DriverManager.getConnection(URL);
            pStemt = (Statement) con.createStatement();
            ResultSet rs = pStemt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount(); // 统计列
            colnames = new String[size];
            colTypes = new String[size];
            colLens = new int[size];
            colComments = new String[size];
            colSizes = new int[size];
            int j = 0;
            while(cRs.next()) {
            	//MySQL需要改的地方  应为我select column_comment   所以查询就一个列  这边1 3表示注释所在列的位置
                colComments[j] = cRs.getString(1);
//                colComments[j] = cRs.getString(3);
                j++;
            }
            for (int i = 0; i < size; i++) {
                colnames[i] = rsmd.getColumnName(i + 1);
                colTypes[i] = rsmd.getColumnTypeName(i + 1);
                colLens[i] = rsmd.getColumnDisplaySize(i + 1);
                
                if (colTypes[i].equalsIgnoreCase("date")
                        || colTypes[i].equalsIgnoreCase("timestamp")) {
                    f_util = true;
                }
                if (colTypes[i].equalsIgnoreCase("blob")
                        || colTypes[i].equalsIgnoreCase("char")) {
                    f_sql = true;
                }
                colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
            }
            tablecolnames = colnames.clone();
            for(int i=0;i<colnames.length;i++) {
                String s = colnames[i];
                String[] strs = s.split("_");
                colnames[i] = "";
                for(int k=0;k<strs.length;k++) {
                	//判断  第一个元素默认全小写
                    if(k == 0){
                    	colnames[i] += strs[k].toLowerCase();
                    }else{
                    	//实现从第二单词开始首字母大写
                    	String num = strs[k].toLowerCase();
                    	colnames[i] += num.substring(0,1).toUpperCase()+num.substring(1);
                    }
                }
            }
            
            String content = parse(colnames, colTypes, colSizes);

            try {
                File directory = new File("");
                // System.out.println("绝对路径："+directory.getAbsolutePath());
                // System.out.println("相对路径："+directory.getCanonicalPath());
                String path = this.getClass().getResource("").getPath();

                System.out.println(path);
                // System.out.println("src/?/"+path.substring(path.lastIndexOf("/com/",
                // path.length())) );
                // String outputPath = directory.getAbsolutePath()+
                // "/src/"+path.substring(path.lastIndexOf("/com/",
                // path.length()), path.length()) + initcap(tablename) +
                // ".java";
                //这边目录   需要变动的时候该一下
                String outputPath = directory.getAbsolutePath()
                        + "/src/"
                        + this.packageOutPath.replace(".", "/") + "/"
                        + initcap(javaName) + ".java";
                FileWriter fw = new FileWriter(outputPath);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(content);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // try {
            // con.close();
            // } catch (SQLException e) {
            // e.printStackTrace();
            // }
        }
    }

    /**
     * 功能：生成实体类主体代码
     * 
     * @param colnames
     * @param colTypes
     * @param colSizes
     * @return
     */
    private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
        StringBuffer sb = new StringBuffer();

        sb.append("package " + this.packageOutPath + ";\r\n");
        sb.append("\r\n");
        
        // 判断是否导入工具包
        if (f_util) {
        }
        if (f_sql) {
            sb.append("import java.sql.*;\r\n");
        }
        
        // 注释部分
//        sb.append("   /**\r\n");
//        sb.append("    * " + javaName + " 实体类\r\n");
//        sb.append("    * " + new Date() + " " + this.authorName + "\r\n");
//        sb.append("    */ \r\n");
        SimpleDateFormat sm = new SimpleDateFormat("yyyy年MM月dd日 aHH:mm:ss");
		String time = sm.format(new Date());
		Calendar date = Calendar.getInstance();
		
        // 实体部分
        sb.append("\r\npublic class " + initcap(javaName) + " implements java.io.Serializable {\r\n");
        processAllAttrs(sb);// 属性
        processAllMethod(sb);// get set方法
        sb.append("}\r\n");

        // System.out.println(sb.toString());
        return sb.toString();
    }
    /**
     * 功能：生成所有方法
     * 
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String now = sdf.format(date);
        
        for (int i = 0; i < colnames.length; i++) {
            sb.append("\r\n\tpublic void set" + initcap(colnames[i]) + "("
                    + sqlType2JavaType(colTypes[i]) + " " + colnames[i]
                    + "){\r\n");
            sb.append("\t\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
            sb.append("\t}\r\n");
            
            sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get"
                    + initcap(colnames[i]) + "(){\r\n");
            sb.append("\t\treturn " + colnames[i] + ";\r\n");
            sb.append("\t}\r\n");
            
        }
        
        
    }
    /**
     * 功能：生成所有属性
     * 
     * @param sb
     */
    private void processAllAttrs(StringBuffer sb) {
        sb.append("\r\n\t//columns START\r\n");
        String str = "";
        for (int i = 0; i < colnames.length; i++) {
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " "
                    + colnames[i] + ";\r\n");
            str+=","+sqlType2JavaType(colTypes[i])+" "+colnames[i];
        }
        str = str.substring(1);
        
        sb.append("\t//columns END\r\n");

        sb.append("\tpublic "+javaName+"(){\r\n");
        sb.append("\r\t}\r\n\r");
       
        sb.append("\tpublic "+javaName+"("+str+"){\r\n");
        for (int i = 0; i < colnames.length; i++) {
	        if(i!=colnames.length-1){
	        	sb.append("\t\tthis."+colnames[i]+"="+colnames[i]+";\r");
	        }else{
	        	sb.append("\t\tthis."+colnames[i]+"="+colnames[i]+";");
	        }
        }
        sb.append("\r\t}\r\n");
        
        
    }


    /**
     * 功能：将输入字符串的首字母改成大写
     * 
     * @param str
     * @return
     */
    private String initcap(String str) {

        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }

        return new String(ch);
    }

    /**
     * 功能：获得列的数据类型
     * 
     * @param sqlType
     * @return
     */
    private String sqlType2JavaType(String sqlType) {

        if (sqlType.equalsIgnoreCase("binary_double")) {
            return "double";
        } else if (sqlType.equalsIgnoreCase("binary_float")) {
            return "float";
        } else if (sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar2")
                || sqlType.equalsIgnoreCase("varchar2")
                || sqlType.equalsIgnoreCase("varchar")
                || sqlType.equalsIgnoreCase("blob")
                || sqlType.equalsIgnoreCase("clob")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("date")
                || sqlType.equalsIgnoreCase("timestamp")
                || sqlType.equalsIgnoreCase("timestamp with local time zone")
                || sqlType.equalsIgnoreCase("timestamp with time zone")) {
//            return "Date";
        	return "String";
        } else if (sqlType.equalsIgnoreCase("number") || sqlType.equalsIgnoreCase("int")) {
            return "Integer";
        }
        return "String";
    }
    public static void main(String[] args) {  
        //里面存的是表名  生成的实体首字母大写   如下是User
    	//第一个参数表明    第二个参数实体类名    第三个参数数据库名字
        new GenEntityOracle("area","Area","xiaoyi").init();
        new GenEntityOracle("clazz","Clazz","xiaoyi").init(); 
        new GenEntityOracle("user","User","xiaoyi").init();
        new GenEntityOracle("user_cla","User_Cla","xiaoyi").init();
    }  
}