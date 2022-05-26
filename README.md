# JavaWeb-20220418
東認 JavaWeb-20220418

# 在 JavaWeb 中建構 sqlite 資料庫
1. pom.xml 加入 sqlite 依賴
<pre>
  &lt;dependency>
    &lt;groupId>org.xerial&lt;/groupId>
    &lt;artifactId>sqlite-jdbc&lt;/artifactId>
    &lt;version>3.36.0.3&lt;/version>
  &lt;/dependency>
</pre>
2. 建立 source folder -> db

3. 撰寫一個建立資裡庫的 servlet

<pre>
  @WebServlet("/servlet/create/db")
  public class CreateDBServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      PrintWriter out = resp.getWriter();

      Connection conn = null;  
          try {
            Class.forName("org.sqlite.JDBC");
              // db parameters  
              String url = "jdbc:sqlite:「你的eclipse專案路徑」/db/webdb.db";  
              // create a connection to the database  
              conn = DriverManager.getConnection(url);  

              out.println("Connection to SQLite has been established.");  


          } catch (Exception e) {  
              out.println(e.getMessage());  
          } finally {  
              try {  
                  if (conn != null) {  
                      conn.close();  
                  }  
              } catch (SQLException ex) {  
                  out.println(ex.getMessage());  
              }  
          }  
    }

  }
</pre>
4. 加入 DBeaver 外掛
